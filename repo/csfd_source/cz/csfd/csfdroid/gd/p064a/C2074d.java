package cz.csfd.csfdroid.gd.p064a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import cz.csfd.csfdroid.gd.p064a.C2069b.C2068c;
import java.util.concurrent.Future;

/* compiled from: ImageRequest */
public class C2074d {
    private static C2069b f4861a;
    private Future<?> f4862b;
    private String f4863c;
    private C2072a f4864d;
    private C2070c f4865e;
    private Options f4866f;

    /* compiled from: ImageRequest */
    public interface C2072a {
        void mo3422a(C2074d c2074d);

        void mo3423a(C2074d c2074d, Bitmap bitmap);

        void mo3424a(C2074d c2074d, Throwable th);

        void mo3425b(C2074d c2074d);
    }

    /* compiled from: ImageRequest */
    private class C2073b implements C2068c {
        final /* synthetic */ C2074d f4860a;

        private C2073b(C2074d c2074d) {
            this.f4860a = c2074d;
        }

        public void mo3419a(C2069b c2069b) {
            if (this.f4860a.f4864d != null) {
                this.f4860a.f4864d.mo3422a(this.f4860a);
            }
        }

        public void mo3420a(C2069b c2069b, Bitmap bitmap) {
            if (!(this.f4860a.f4864d == null || this.f4860a.m7264b())) {
                this.f4860a.f4864d.mo3423a(this.f4860a, bitmap);
            }
            this.f4860a.f4862b = null;
        }

        public void mo3421a(C2069b c2069b, Throwable th) {
            if (!(this.f4860a.f4864d == null || this.f4860a.m7264b())) {
                this.f4860a.f4864d.mo3424a(this.f4860a, th);
            }
            this.f4860a.f4862b = null;
        }
    }

    public C2074d(String str, C2072a c2072a, C2070c c2070c, Options options) {
        this.f4863c = str;
        this.f4864d = c2072a;
        this.f4865e = c2070c;
        this.f4866f = options;
    }

    public void m7263a(Context context) {
        if (this.f4862b == null) {
            if (f4861a == null) {
                f4861a = new C2069b(context);
            }
            this.f4862b = f4861a.m7251a(this.f4863c, new C2073b(), this.f4865e, this.f4866f);
        }
    }

    public void m7262a() {
        if (!m7264b()) {
            this.f4862b.cancel(false);
            if (this.f4864d != null) {
                this.f4864d.mo3425b(this);
            }
        }
    }

    public final boolean m7264b() {
        return this.f4862b.isCancelled();
    }
}
