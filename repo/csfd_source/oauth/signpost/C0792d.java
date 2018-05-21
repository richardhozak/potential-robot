package oauth.signpost;

import java.io.Serializable;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;

/* compiled from: OAuthConsumer */
public interface C0792d extends Serializable {
    String getConsumerKey();

    String getConsumerSecret();

    String getToken();

    String getTokenSecret();

    void setAdditionalParameters(C2566a c2566a);

    void setTokenWithSecret(String str, String str2);

    String sign(String str);

    C0795b sign(Object obj);

    C0795b sign(C0795b c0795b);
}
