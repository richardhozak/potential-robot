#![windows_subsystem = "windows"]

extern crate oauth1;
extern crate reqwest;
extern crate url;
extern crate web_view;
extern crate kernel32;
extern crate winapi;

use oauth1::Token;
use reqwest::Client;
use reqwest::Proxy;
use reqwest::Certificate;
use reqwest::header::Authorization;
use url::form_urlencoded;
use url::Url;
use std::collections::HashMap;
use std::process::Command;
use std::env;
use std::path::PathBuf;
use std::error::Error;
use std::fs::File;
use std::io::Write;
use std::io::Read;
use std::borrow::Cow;

const REQUEST_TOKEN_URL: &str = "https://android-api.csfd.cz/oauth/request-token";
const ACCESS_TOKEN_URL: &str = "https://android-api.csfd.cz/oauth/access-token";
const AUTHORIZE_URL: &str = "https://android-api.csfd.cz/oauth/authorize";
const BASE_URL: &str = "https://android-api.csfd.cz/";

fn get_request_token<'a>(client: &Client, request_token_url: &str, consumer_token: &Token<'a>) -> Option<Token<'a>> {
    let mut res = client.get(REQUEST_TOKEN_URL)
                    .header(
                        Authorization(
                            oauth1::authorize(
                                "GET",
                                REQUEST_TOKEN_URL,
                                &consumer_token,
                                None,
                                None,
                                oauth1::Mode::Header,
                            ),
                        ),
                    )
                    .send()
                    .expect("could not send request");

    let text = res.text().unwrap();
    let text = form_urlencoded::parse(text.as_bytes());
    let pairs: HashMap<_,_> = text.into_owned().collect();

    if pairs.contains_key("oauth_token") && pairs.contains_key("oauth_token_secret") {
        let token = pairs.get("oauth_token").unwrap().clone();
        let secret = pairs.get("oauth_token_secret").unwrap().clone();
        Some(Token::new(token, secret))
    } else {
        None
    }
}

fn get_authorize_url(url: &str, token: &str, callback: &str) -> String {
    let mut serializer = form_urlencoded::Serializer::new(String::new());
    serializer.append_pair("oauth_token", token);
    serializer.append_pair("oauth_callback", callback);
    let params = serializer.finish();
    format!("{}?{}", url, params)
}

fn get_verifier_file_path() -> PathBuf {
    match env::current_exe() {
        Ok(mut path) => {
            path.pop();
            path.push("callback_result.txt");
            path
        },
        Err(why) => panic!("could not get current exe path: {}", why.description()),
    }
}

fn write_verifier_file(text: String) {
    println!("writing {}", text);
    
    let path = get_verifier_file_path();
    
    let display = path.display();
    println!("{}", display);

    let mut file = match File::create(&path) {
        Ok(file) => file,
        Err(why) => panic!("couldn't create {}: {}",
                           display,
                           why.description()),
    };

    match file.write_all(text.as_bytes()) {
        Ok(_) => println!("successfully wrote to {}", display),
        Err(why) => {
            panic!("couldn't write to {}: {}", display,
                                               why.description())
        },
    }
}

fn read_verifier_file() -> Option<String> {
    println!("reading");

    let path = get_verifier_file_path();
    let display = path.display();
    println!("{}", display);

    let mut file = match File::open(&path) {
        Ok(file) => file,
        Err(why) => {
            panic!("could open {}: {}", display,
                                        why.description())
        },
    };

    let mut contents = String::new();
    file.read_to_string(&mut contents).expect(&format!("could not read {}", display));
    let url = match Url::parse(&contents) {
        Ok(url) => url,
        Err(why) => return None,
    };

    let pairs: HashMap<_, _> = url.query_pairs().into_owned().collect();
    pairs.get("oauth_verifier").cloned()
}

fn get_access_token<'a>(client: &Client, access_token_url: &str, consumer_token: &Token<'a>, request_token: &Token<'a>, verifier: &'a str) -> Option<Token<'a>> {
    // let mut params: HashMap<&'static str, Cow<'a, str>> = HashMap::new();
    // params.insert("oauth_verifier", verifier.clone().into());

    let mut form = HashMap::new();
    form.insert("oauth_verifier", verifier.into());

    let dummy_form = [("", "")];

    let res = client.post(access_token_url)
                    .header(
                        Authorization(
                        oauth1::authorize(
                            "POST",
                            REQUEST_TOKEN_URL,
                            &consumer_token,
                            Some(&request_token),
                            Some(form),
                            oauth1::Mode::Header,
                        ))
                    )
                    .send()
                    .expect("could not retrieve acces token");

    println!("result {:?}", res);
    
    None
}

fn main() {
    if env::args().count() == 2 {
        let text = env::args().skip(1).next().unwrap();
        write_verifier_file(text);
        std::process::exit(0);
    }

    unsafe {
        kernel32::AttachConsole(winapi::wincon::ATTACH_PARENT_PROCESS);
    }

    println!("started");

    let mut cert = Vec::new();
    File::open("C:\\Users\\RHoza\\Documents\\csfdapp\\rustcsfd\\target\\debug\\charlescert.pem").unwrap().read_to_end(&mut cert).unwrap();

    let cert = Certificate::from_pem(&cert).unwrap();

    let consumer_token = Token::new("061025241049", "88af9526ee967179");
    let client = Client::builder()
        .danger_disable_hostname_verification()
        .add_root_certificate(cert)
        .proxy(Proxy::all("http://127.0.0.1:8888").unwrap())
        .build()
        .unwrap();
    
    if let Some(req_token) = get_request_token(&client, REQUEST_TOKEN_URL, &consumer_token) {
        let auth_url = get_authorize_url(AUTHORIZE_URL, &req_token.key, "csfdroid://oauth-callback");
        println!("authorize url {}", auth_url);
        web_view::run("CSFD Auth", &auth_url, Some((800, 600)), true, true, |_|{}, |_,_,_|{}, ());
        if let Some(verifier) = read_verifier_file() {
            println!("verifier {:?}", verifier);
            let access_token = get_access_token(&client, ACCESS_TOKEN_URL, &consumer_token, &req_token, &verifier);
            println!("access token {:?}", access_token);
        }
    }
}
