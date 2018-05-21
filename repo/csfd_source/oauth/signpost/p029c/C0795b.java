package oauth.signpost.p029c;

import java.io.InputStream;

/* compiled from: HttpRequest */
public interface C0795b {
    String getContentType();

    String getHeader(String str);

    InputStream getMessagePayload();

    String getMethod();

    String getRequestUrl();

    void setHeader(String str, String str2);

    void setRequestUrl(String str);

    Object unwrap();
}
