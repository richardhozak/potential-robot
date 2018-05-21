package oauth.signpost.p068a;

import java.io.InputStream;
import oauth.signpost.p029c.C0795b;

/* compiled from: UrlStringRequestAdapter */
public class C2558a implements C0795b {
    private String f6416a;

    public C2558a(String str) {
        this.f6416a = str;
    }

    public String getMethod() {
        return "GET";
    }

    public String getRequestUrl() {
        return this.f6416a;
    }

    public void setRequestUrl(String str) {
        this.f6416a = str;
    }

    public void setHeader(String str, String str2) {
    }

    public String getHeader(String str) {
        return null;
    }

    public InputStream getMessagePayload() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public Object unwrap() {
        return this.f6416a;
    }
}
