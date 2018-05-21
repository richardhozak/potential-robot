package p025c.p026a.p027a.p028a;

import com.p042c.p043a.C1123v;
import oauth.signpost.C0793a;
import oauth.signpost.p029c.C0795b;

/* compiled from: OkHttpOAuthConsumer */
public class C0794a extends C0793a {
    public C0794a(String str, String str2) {
        super(str, str2);
    }

    protected C0795b wrap(Object obj) {
        if (obj instanceof C1123v) {
            return new C0796b((C1123v) obj);
        }
        throw new IllegalArgumentException("This consumer expects requests of type " + C1123v.class.getCanonicalName());
    }
}
