package oauth.signpost.p070d;

import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import oauth.signpost.C2568c;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;
import oauth.signpost.p069b.C2562d;
import org.apache.http.protocol.HTTP;

/* compiled from: HmacSha1MessageSigner */
public class C2572b extends C2571c {
    public String mo3700a() {
        return "HMAC-SHA1";
    }

    public String mo3701a(C0795b c0795b, C2566a c2566a) {
        try {
            Key secretKeySpec = new SecretKeySpec((C2568c.m9495a(m9510b()) + '&' + C2568c.m9495a(m9512c())).getBytes(HTTP.UTF_8), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            String a = new C2574e(c0795b, c2566a).m9516a();
            C2568c.m9500b("SBS", a);
            return m9508a(instance.doFinal(a.getBytes(HTTP.UTF_8))).trim();
        } catch (Exception e) {
            throw new C2562d(e);
        } catch (Exception e2) {
            throw new C2562d(e2);
        }
    }
}
