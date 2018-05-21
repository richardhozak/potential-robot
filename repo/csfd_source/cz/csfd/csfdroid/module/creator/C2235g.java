package cz.csfd.csfdroid.module.creator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.creator.C2234f.C2223a;
import cz.csfd.csfdroid.module.creator.C2234f.C2231b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.List;
import org.apache.http.HttpHost;

/* compiled from: CreatorModuleImpl */
public class C2235g implements C2234f {
    private C2056d<MovieCreator> f5461a;
    private C2011b f5462b;
    private C2011b f5463c;
    private C2011b f5464d;
    private C2011b f5465e;
    private int f5466f;

    public void mo3516a(MovieCreator movieCreator, Context context) {
        if (this.f5461a == null) {
            this.f5461a = C1998s.m6365a(context).m6223k();
        }
        this.f5461a.m7164a((BasicEntity) movieCreator);
        Intent intent = new Intent(context, CreatorDetailsActivity.class);
        intent.setData(m8076e(movieCreator.m6705g()));
        context.startActivity(intent);
    }

    public void mo3517a(MovieCreator movieCreator, C2223a c2223a, CsfdDataProvider c2016c) {
        mo3513a(this.f5466f);
        if (c2223a != null) {
            c2223a.mo3510i();
        }
        this.f5462b = c2016c.mo3374a(movieCreator, (C1945a) c2223a);
        this.f5466f = movieCreator.m6705g();
    }

    public void mo3513a(int i) {
        if (this.f5462b != null && this.f5466f == i) {
            this.f5462b.mo3355a();
            this.f5462b = null;
        }
    }

    public void mo3518a(MovieCreator movieCreator, C2231b c2231b, CsfdDataProvider c2016c) {
        mo3519b(this.f5466f);
        if (c2231b != null) {
            c2231b.mo3417g();
        }
        this.f5463c = c2016c.mo3394b(movieCreator, (C1945a) c2231b);
        this.f5466f = movieCreator.m6705g();
    }

    public void mo3519b(int i) {
        if (this.f5463c != null && this.f5466f == i) {
            this.f5463c.mo3355a();
            this.f5463c = null;
        }
    }

    public void mo3514a(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, CsfdDataProvider c2016c, Context context) {
        mo3520c(this.f5466f);
        this.f5464d = c2016c.mo3357a(i, i2, i3, (C1945a) c1945a, context);
        this.f5466f = i;
    }

    public void mo3520c(int i) {
        if (this.f5464d != null && this.f5466f == i) {
            this.f5464d.mo3355a();
            this.f5464d = null;
        }
    }

    public void mo3515a(MovieCreator movieCreator, int i, int i2, C1945a<MovieCreator> c1945a, CsfdDataProvider c2016c) {
        mo3521d(movieCreator.m6705g());
        this.f5465e = c2016c.mo3373a(movieCreator, i, i2, (C1945a) c1945a);
        this.f5466f = movieCreator.m6705g();
    }

    public void mo3521d(int i) {
        if (this.f5465e != null && this.f5466f == i) {
            this.f5465e.mo3355a();
            this.f5465e = null;
        }
    }

    public Uri m8076e(int i) {
        Builder builder = new Builder();
        builder.scheme("csfdroid").authority("csfd.cz").path("creator").appendPath(i + "");
        return builder.build();
    }

    public int mo3512a(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase("csfdroid")) {
            return Integer.parseInt(uri.getLastPathSegment());
        }
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            try {
                scheme = (String) uri.getPathSegments().get(1);
                int indexOf = scheme.indexOf("-");
                if (indexOf > 0) {
                    return Integer.parseInt(scheme.substring(0, indexOf));
                }
                return Integer.parseInt(scheme);
            } catch (Throwable e) {
                throw new C2218a(uri.toString(), e);
            }
        }
        throw new C2218a(uri.toString());
    }
}
