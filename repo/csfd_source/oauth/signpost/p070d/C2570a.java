package oauth.signpost.p070d;

import java.util.Iterator;
import oauth.signpost.C2568c;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;

/* compiled from: AuthorizationHeaderSigningStrategy */
public class C2570a implements C2569f {
    public String mo3699a(String str, C0795b c0795b, C2566a c2566a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ");
        if (c2566a.containsKey("realm")) {
            stringBuilder.append(c2566a.m9482a("realm"));
            stringBuilder.append(", ");
        }
        C2566a a = c2566a.m9488a();
        a.m9484a("oauth_signature", str, true);
        Iterator it = a.keySet().iterator();
        while (it.hasNext()) {
            stringBuilder.append(a.m9482a((String) it.next()));
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        C2568c.m9500b("Auth Header", stringBuilder2);
        c0795b.setHeader("Authorization", stringBuilder2);
        return stringBuilder2;
    }
}
