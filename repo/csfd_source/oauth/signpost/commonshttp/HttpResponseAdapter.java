package oauth.signpost.commonshttp;

import java.io.InputStream;
import oauth.signpost.p029c.C2567c;
import org.apache.http.HttpResponse;

public class HttpResponseAdapter implements C2567c {
    private HttpResponse response;

    public HttpResponseAdapter(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    public InputStream getContent() {
        return this.response.getEntity().getContent();
    }

    public int getStatusCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    public String getReasonPhrase() {
        return this.response.getStatusLine().getReasonPhrase();
    }

    public Object unwrap() {
        return this.response;
    }
}
