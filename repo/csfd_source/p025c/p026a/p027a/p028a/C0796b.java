package p025c.p026a.p027a.p028a;

import com.p042c.p043a.C1123v;
import java.io.InputStream;
import oauth.signpost.p029c.C0795b;
import p024b.C0772c;

/* compiled from: OkHttpRequestAdapter */
public class C0796b implements C0795b {
    private C1123v f2449a;

    public C0796b(C1123v c1123v) {
        this.f2449a = c1123v;
    }

    public String getContentType() {
        if (this.f2449a.m5176f() == null || this.f2449a.m5176f().mo1960a() == null) {
            return null;
        }
        return this.f2449a.m5176f().mo1960a().toString();
    }

    public String getHeader(String str) {
        return this.f2449a.m5170a(str);
    }

    public InputStream getMessagePayload() {
        if (this.f2449a.m5176f() == null) {
            return null;
        }
        Object c0772c = new C0772c();
        this.f2449a.m5176f().mo1961a(c0772c);
        return c0772c.mo1750g();
    }

    public String getMethod() {
        return this.f2449a.m5174d();
    }

    public String getRequestUrl() {
        return this.f2449a.m5173c();
    }

    public void setHeader(String str, String str2) {
        this.f2449a = this.f2449a.m5177g().m5159a(str, str2).m5163b();
    }

    public void setRequestUrl(String str) {
        this.f2449a = this.f2449a.m5177g().m5157a(str).m5163b();
    }

    public Object unwrap() {
        return this.f2449a;
    }
}
