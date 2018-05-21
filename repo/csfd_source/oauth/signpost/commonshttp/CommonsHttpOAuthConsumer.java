package oauth.signpost.commonshttp;

import oauth.signpost.C0793a;
import oauth.signpost.p029c.C0795b;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class CommonsHttpOAuthConsumer extends C0793a {
    private static final long serialVersionUID = 1;

    public CommonsHttpOAuthConsumer(String str, String str2) {
        super(str, str2);
    }

    protected C0795b wrap(Object obj) {
        if (obj instanceof HttpRequest) {
            return new HttpRequestAdapter((HttpUriRequest) obj);
        }
        throw new IllegalArgumentException("This consumer expects requests of type " + HttpRequest.class.getCanonicalName());
    }
}
