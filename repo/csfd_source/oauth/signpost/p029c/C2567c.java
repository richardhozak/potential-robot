package oauth.signpost.p029c;

import java.io.InputStream;

/* compiled from: HttpResponse */
public interface C2567c {
    InputStream getContent();

    String getReasonPhrase();

    int getStatusCode();

    Object unwrap();
}
