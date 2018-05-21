package oauth.signpost.commonshttp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.p029c.C0795b;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestAdapter implements C0795b {
    private HttpEntity entity;
    private HttpUriRequest request;

    public HttpRequestAdapter(HttpUriRequest httpUriRequest) {
        this.request = httpUriRequest;
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            this.entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
        }
    }

    public String getMethod() {
        return this.request.getRequestLine().getMethod();
    }

    public String getRequestUrl() {
        return this.request.getURI().toString();
    }

    public void setRequestUrl(String str) {
        throw new RuntimeException(new UnsupportedOperationException());
    }

    public String getHeader(String str) {
        Header firstHeader = this.request.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public void setHeader(String str, String str2) {
        this.request.setHeader(str, str2);
    }

    public Map<String, String> getAllHeaders() {
        Header[] allHeaders = this.request.getAllHeaders();
        Map hashMap = new HashMap();
        for (Header header : allHeaders) {
            hashMap.put(header.getName(), header.getValue());
        }
        return hashMap;
    }

    public String getContentType() {
        if (this.entity == null) {
            return null;
        }
        Header contentType = this.entity.getContentType();
        if (contentType != null) {
            return contentType.getValue();
        }
        return null;
    }

    public InputStream getMessagePayload() {
        if (this.entity == null) {
            return null;
        }
        return this.entity.getContent();
    }

    public Object unwrap() {
        return this.request;
    }
}
