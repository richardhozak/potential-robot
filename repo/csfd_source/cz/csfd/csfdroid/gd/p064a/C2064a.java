package cz.csfd.csfdroid.gd.p064a;

import android.content.Context;
import android.graphics.Bitmap;
import cz.csfd.csfdroid.CsfdApplication.C1942a;
import cz.csfd.csfdroid.p061d.C1998s;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* compiled from: ImageCache */
public class C2064a implements C1942a {
    private final HashMap<String, SoftReference<Bitmap>> f4846a = new HashMap();
    private final C2076e f4847b;

    public C2064a(Context context) {
        this.f4847b = new C2076e(context);
        C1998s.m6365a(context).m6211a((C1942a) this);
    }

    public Bitmap m7242a(String str) {
        SoftReference softReference = (SoftReference) this.f4846a.get(str);
        Bitmap a;
        if (softReference == null) {
            a = this.f4847b.m7277a(str);
            if (a == null) {
                return null;
            }
            this.f4846a.put(str, new SoftReference(a));
            return a;
        }
        a = (Bitmap) softReference.get();
        if (a != null) {
            return a;
        }
        a = this.f4847b.m7277a(str);
        if (a != null) {
            this.f4846a.put(str, new SoftReference(a));
            return a;
        }
        this.f4846a.remove(str);
        return a;
    }

    public void m7244a(String str, Bitmap bitmap) {
        this.f4846a.put(str, new SoftReference(bitmap));
        this.f4847b.m7278a(str, bitmap);
    }

    public void m7245b() {
        this.f4846a.clear();
    }

    public void mo3415a() {
        m7245b();
    }
}
