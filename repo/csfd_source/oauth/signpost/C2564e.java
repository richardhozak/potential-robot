package oauth.signpost;

import java.io.Serializable;

/* compiled from: OAuthProvider */
public interface C2564e extends Serializable {
    void retrieveAccessToken(C0792d c0792d, String str, String... strArr);

    String retrieveRequestToken(C0792d c0792d, String str, String... strArr);
}
