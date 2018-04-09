import requests
import subprocess
import sys
import os
from functools import partialmethod
from rauth import OAuth1Service
import socket

def receive():
    receiver = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    receiver.bind(("127.0.0.1", "8080"))
    receiver.listen(1)
    conn, addr = receiver.accept()
    while True:
        data = conn.recv(1024)
        if not data:
            break
        print("received data", data)
    conn.close()

if __name__ == "__main__":
    #with no_ssl_verification():
    
    requests.Session.request = partialmethod(requests.Session.request, verify=False)
    requests.packages.urllib3.disable_warnings()

    csfd = OAuth1Service(
        name='csfd',
        consumer_key='061025241049',
        consumer_secret='88af9526ee967179',
        request_token_url='https://android-api.csfd.cz/oauth/request-token',
        access_token_url='https://android-api.csfd.cz/oauth/access-token',
        authorize_url='https://android-api.csfd.cz/oauth/authorize',
        base_url='https://android-api.csfd.cz/')

    request_token, request_token_secret = csfd.get_request_token(method="POST")
    print(request_token, request_token_secret)

    authorize_url = csfd.get_authorize_url(request_token, oauth_callback="csfdroid://oauth-callback")
    print("authorize url", authorize_url)
    
    os.system("minimal \"{}\" \"{}\"".format("CSFD Auth", authorize_url))

    auth_verifier = input("Enter: ")

    print(auth_verifier)

    session = csfd.get_auth_session(request_token,
                                    request_token_secret,
                                    method='POST') #data={'oauasdth_verifiera': auth_verifier}

    print("identity", session.get('identity').json())
