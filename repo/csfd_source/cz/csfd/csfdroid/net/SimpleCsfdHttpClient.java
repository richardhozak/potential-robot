package cz.csfd.csfdroid.net;

import com.p042c.p043a.C1108n;
import com.p042c.p043a.C1119t;
import com.p042c.p043a.C1123v;
import com.p042c.p043a.C1123v.C1122a;
import com.p042c.p043a.C1124w;
import com.p042c.p043a.C1129x;
import cz.csfd.csfdroid.oauth.C2539e;
import cz.csfd.csfdroid.p061d.C1998s;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;

/* compiled from: SimpleCsfdHttpClient */
public class C2520e implements C2517b {
    private C1119t f6285a = new C1119t();
    private C2539e f6286b;
    private String f6287c;
    private int f6288d;

    public C2520e(String str, int i) {
        CookieHandler cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_NONE);
        this.f6285a.m5119a(cookieManager);
        this.f6287c = str;
        this.f6288d = i;
        C1998s.m6372a(getClass(), "CsfdHttpClient initialized with user agent: " + str);
    }

    public void m9325a(C2539e c2539e) {
        this.f6286b = c2539e;
    }

    public C2519d mo3669a(String str) {
        try {
            return m9320a(new C1122a().m5157a(str));
        } catch (Throwable e) {
            throw new C2518c(e);
        }
    }

    public C2519d mo3670a(String str, Map<String, String> map) {
        try {
            return m9320a(m9321b(str, map));
        } catch (Throwable e) {
            throw new C2518c(e);
        }
    }

    public C2519d mo3671b(String str) {
        try {
            return m9320a(new C1122a().m5157a(str).m5152a());
        } catch (Throwable e) {
            throw new C2518c(e);
        }
    }

    private C2519d m9320a(C1122a c1122a) {
        c1122a.m5162b(HTTP.USER_AGENT, this.f6287c);
        m9322b(c1122a);
        C1123v b = c1122a.m5163b();
        if (this.f6286b != null) {
            b = this.f6286b.mo3680a(b);
        }
        C1129x a = m9319a(b);
        C1998s.m6372a(getClass(), "Response code: " + a.m5231c());
        String f = a.m5235g().m4652f();
        C1998s.m6372a(getClass(), "Response length: " + a.m5235g().mo1921b());
        C1998s.m6372a(getClass(), "Response content: " + f);
        return new C2519d(a.m5231c(), f);
    }

    private C1129x m9319a(C1123v c1123v) {
        return this.f6285a.m5117a(c1123v).m4955a();
    }

    private C1122a m9321b(String str, Map<String, String> map) {
        C1122a a = new C1122a().m5157a(str);
        a.m5156a(m9318a((Map) map));
        return a;
    }

    private C1124w m9318a(Map<String, String> map) {
        C1108n c1108n = new C1108n();
        for (Entry entry : map.entrySet()) {
            c1108n.m5021a((String) entry.getKey(), (String) entry.getValue());
        }
        return c1108n.m5022a();
    }

    private void m9322b(C1122a c1122a) {
        c1122a.m5162b("X-App-Version", String.valueOf(this.f6288d));
    }
}
