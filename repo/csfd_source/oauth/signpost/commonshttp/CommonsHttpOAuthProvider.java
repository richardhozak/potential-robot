package oauth.signpost.commonshttp;

import java.io.IOException;
import oauth.signpost.C2565b;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2567c;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class CommonsHttpOAuthProvider extends C2565b {
    private static final long serialVersionUID = 1;
    private transient HttpClient httpClient;

    public CommonsHttpOAuthProvider(String str, String str2, String str3) {
        super(str, str2, str3);
        this.httpClient = new DefaultHttpClient();
    }

    public CommonsHttpOAuthProvider(String str, String str2, String str3, HttpClient httpClient) {
        super(str, str2, str3);
        this.httpClient = httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    protected C0795b createRequest(String str) {
        return new HttpRequestAdapter(new HttpPost(str));
    }

    protected C2567c sendRequest(C0795b c0795b) {
        return new HttpResponseAdapter(this.httpClient.execute((HttpUriRequest) c0795b.unwrap()));
    }

    protected void closeConnection(C0795b c0795b, C2567c c2567c) {
        if (c2567c != null) {
            HttpEntity entity = ((HttpResponse) c2567c.unwrap()).getEntity();
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
