package oauth.signpost.p070d;

import java.net.URI;
import oauth.signpost.C2568c;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;
import oauth.signpost.p069b.C2562d;
import org.apache.http.HttpHost;

/* compiled from: SignatureBaseString */
public class C2574e {
    private C0795b f6424a;
    private C2566a f6425b;

    public C2574e(C0795b c0795b, C2566a c2566a) {
        this.f6424a = c0795b;
        this.f6425b = c2566a;
    }

    public String m9516a() {
        try {
            return this.f6424a.getMethod() + '&' + C2568c.m9495a(m9517b()) + '&' + C2568c.m9495a(m9518c());
        } catch (Exception e) {
            throw new C2562d(e);
        }
    }

    public String m9517b() {
        URI uri = new URI(this.f6424a.getRequestUrl());
        String toLowerCase = uri.getScheme().toLowerCase();
        String toLowerCase2 = uri.getAuthority().toLowerCase();
        int i = ((toLowerCase.equals(HttpHost.DEFAULT_SCHEME_NAME) && uri.getPort() == 80) || (toLowerCase.equals("https") && uri.getPort() == 443)) ? 1 : 0;
        if (i != 0) {
            i = toLowerCase2.lastIndexOf(":");
            if (i >= 0) {
                toLowerCase2 = toLowerCase2.substring(0, i);
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() <= 0) {
            rawPath = "/";
        }
        return toLowerCase + "://" + toLowerCase2 + rawPath;
    }

    public String m9518c() {
        if (this.f6425b == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.f6425b.keySet()) {
            if (!("oauth_signature".equals(str) || "realm".equals(str))) {
                if (i > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(this.f6425b.m9492b(str, false));
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
