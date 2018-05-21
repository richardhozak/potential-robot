package oauth.signpost.p070d;

import java.util.Iterator;
import oauth.signpost.C2568c;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;

/* compiled from: QueryStringSigningStrategy */
public class C2573d implements C2569f {
    public String mo3699a(String str, C0795b c0795b, C2566a c2566a) {
        C2566a a = c2566a.m9488a();
        a.m9484a("oauth_signature", str, true);
        Iterator it = a.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder(C2568c.m9496a(c0795b.getRequestUrl(), a.m9493c((String) it.next())));
        while (it.hasNext()) {
            stringBuilder.append("&");
            stringBuilder.append(a.m9493c((String) it.next()));
        }
        String stringBuilder2 = stringBuilder.toString();
        c0795b.setRequestUrl(stringBuilder2);
        return stringBuilder2;
    }
}
