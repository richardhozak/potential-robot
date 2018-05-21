package oauth.signpost.p070d;

import java.io.Serializable;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;
import org.apache.p071a.p072a.p073a.C2576a;

/* compiled from: OAuthMessageSigner */
public abstract class C2571c implements Serializable {
    private transient C2576a f6421a = new C2576a();
    private String f6422b;
    private String f6423c;

    public abstract String mo3700a();

    public abstract String mo3701a(C0795b c0795b, C2566a c2566a);

    public String m9510b() {
        return this.f6422b;
    }

    public String m9512c() {
        return this.f6423c;
    }

    public void m9509a(String str) {
        this.f6422b = str;
    }

    public void m9511b(String str) {
        this.f6423c = str;
    }

    protected String m9508a(byte[] bArr) {
        return new String(this.f6421a.m9523a(bArr));
    }
}
