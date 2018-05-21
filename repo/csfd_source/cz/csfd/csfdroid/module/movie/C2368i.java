package cz.csfd.csfdroid.module.movie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.data.entity.Seasons;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.movie.C2366h.C2249e;
import cz.csfd.csfdroid.module.movie.C2366h.C2318h;
import cz.csfd.csfdroid.module.movie.C2366h.C2327a;
import cz.csfd.csfdroid.module.movie.C2366h.C2332b;
import cz.csfd.csfdroid.module.movie.C2366h.C2361d;
import cz.csfd.csfdroid.module.movie.C2366h.C2362g;
import cz.csfd.csfdroid.module.movie.C2366h.C2364c;
import cz.csfd.csfdroid.module.movie.C2366h.C2365f;
import cz.csfd.csfdroid.module.movie.video.C2408e;
import cz.csfd.csfdroid.module.movie.video.VideoActivity;
import cz.csfd.csfdroid.p061d.C1998s;
import org.apache.http.HttpHost;

/* compiled from: MovieModuleImpl */
public class C2368i implements C2366h {
    private C2056d<MovieInfo> f5851a;
    private C2011b f5852b;
    private C2011b f5853c;
    private C2011b f5854d;
    private C2011b f5855e;
    private C2011b f5856f;
    private C2011b f5857g;
    private C2011b f5858h;
    private C2011b f5859i;
    private int f5860j;

    public void mo3575a(MovieInfo movieInfo, Context context) {
        mo3580a(movieInfo, C2364c.INFO, context);
    }

    public void mo3580a(MovieInfo movieInfo, C2364c c2364c, Context context) {
        if (this.f5851a == null) {
            this.f5851a = C1998s.m6365a(context).m6222j();
        }
        this.f5851a.m7164a((BasicEntity) movieInfo);
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.setData(m8634a(movieInfo.m6705g(), c2364c));
        context.startActivity(intent);
    }

    public void mo3586b(MovieInfo movieInfo, Context context) {
        Intent intent = new Intent(context, MovieCreatorsActivity.class);
        intent.putExtra("movieId", movieInfo.m6705g());
        context.startActivity(intent);
    }

    public void mo3576a(MovieInfo movieInfo, MovieVideos movieVideos, int i, Context context) {
        mo3577a(movieInfo, movieVideos, i, false, context);
    }

    public void mo3577a(MovieInfo movieInfo, MovieVideos movieVideos, int i, boolean z, Context context) {
        if (this.f5851a == null) {
            this.f5851a = C1998s.m6365a(context).m6222j();
        }
        this.f5851a.m7164a((BasicEntity) movieInfo);
        C2408e.m8784a();
        Intent intent = new Intent(context, VideoActivity.class);
        intent.setData(m8634a(movieInfo.m6705g(), C2364c.VIDEOS));
        intent.putExtra("videos", movieVideos);
        intent.putExtra("video_id", i);
        intent.putExtra("is_homepage_trailer", z);
        context.startActivity(intent);
    }

    public void mo3581a(MovieInfo movieInfo, C2361d c2361d, C2016c c2016c) {
        mo3571a(this.f5860j);
        if (c2361d != null) {
            c2361d.mo3568i();
        }
        this.f5852b = c2016c.mo3378a(movieInfo, (C1945a) c2361d);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3571a(int i) {
        if (this.f5852b != null && this.f5860j == i) {
            this.f5852b.mo3355a();
            this.f5852b = null;
        }
    }

    public void mo3579a(MovieInfo movieInfo, C2332b c2332b, C2016c c2016c) {
        mo3585b(this.f5860j);
        if (c2332b != null) {
            c2332b.i_();
        }
        this.f5853c = c2016c.mo3396b(movieInfo, (C1945a) c2332b);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3585b(int i) {
        if (this.f5853c != null && this.f5860j == i) {
            this.f5853c.mo3355a();
            this.f5853c = null;
        }
    }

    public void mo3578a(MovieInfo movieInfo, C2327a c2327a, C2016c c2016c) {
        mo3587c(this.f5860j);
        if (c2327a != null) {
            c2327a.mo3417g();
        }
        this.f5855e = c2016c.mo3377a(movieInfo, movieInfo.m6902L(), 10, (C1945a) c2327a);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3587c(int i) {
        if (this.f5855e != null && this.f5860j == i) {
            this.f5855e.mo3355a();
            this.f5855e = null;
        }
    }

    public void mo3573a(MovieInfo movieInfo, int i, C2249e c2249e, C2016c c2016c) {
        mo3589e(this.f5860j);
        if (c2249e != null) {
            c2249e.mo3526b();
        }
        this.f5856f = c2016c.mo3375a(movieInfo, movieInfo.m6955h(), 10, i, (C1945a) c2249e);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3589e(int i) {
        if (this.f5856f != null && this.f5860j == i) {
            this.f5856f.mo3355a();
            this.f5856f = null;
        }
    }

    public void mo3574a(MovieInfo movieInfo, int i, C2362g c2362g, C2016c c2016c, Context context) {
        mo3588d(this.f5860j);
        if (c2362g != null) {
            c2362g.mo3568i();
        }
        this.f5854d = c2016c.mo3376a(movieInfo, movieInfo.m6912V(), 10, i, c2362g, context);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3588d(int i) {
        if (this.f5854d != null && this.f5860j == i) {
            this.f5854d.mo3355a();
            this.f5854d = null;
        }
    }

    public void mo3582a(MovieInfo movieInfo, C2365f c2365f, C2016c c2016c) {
        mo3590f(this.f5860j);
        if (c2365f != null) {
            c2365f.mo3592b();
        }
        this.f5857g = c2016c.mo3395b(movieInfo, movieInfo.m6904N(), 20, (C1945a) c2365f);
        this.f5860j = movieInfo.m6705g();
    }

    public void mo3590f(int i) {
        if (this.f5857g != null && this.f5860j == i) {
            this.f5857g.mo3355a();
            this.f5857g = null;
        }
    }

    public void mo3583a(MovieInfo movieInfo, final C2318h c2318h, C2016c c2016c, boolean z, boolean z2) {
        mo3570a();
        if (c2318h != null) {
            c2318h.mo3563b();
        }
        final boolean z3 = z && z2;
        C1945a c23671 = new C1945a<MovieInfo>(this) {
            boolean f5845a = false;
            boolean f5846b = false;
            boolean f5847c = false;
            final /* synthetic */ C2368i f5850f;

            public void m8630a(MovieInfo movieInfo) {
                if (this.f5845a || !z3) {
                    c2318h.mo3324a((Object) movieInfo);
                }
                this.f5845a = true;
            }

            public void mo3323a(Exception exception) {
                if (this.f5846b || !z3) {
                    c2318h.mo3323a(exception);
                }
                this.f5846b = true;
            }

            public void mo3322a() {
                if (this.f5847c || !z3) {
                    c2318h.mo3322a();
                }
                this.f5847c = true;
            }
        };
        if (z) {
            this.f5858h = c2016c.mo3402c(movieInfo, c23671);
        }
        if (z2) {
            this.f5859i = c2016c.mo3406d(movieInfo, c23671);
        }
        if (!z && !z2 && c2318h != null) {
            c2318h.mo3324a((Object) movieInfo);
        }
    }

    public void mo3570a() {
        if (this.f5858h != null) {
            this.f5858h.mo3355a();
            this.f5858h = null;
        }
        if (this.f5859i != null) {
            this.f5859i.mo3355a();
            this.f5859i = null;
        }
    }

    public void mo3572a(int i, C1945a<Seasons> c1945a, C2016c c2016c) {
        c2016c.mo3408e(c1945a, i);
    }

    public Uri mo3591g(int i) {
        return m8634a(i, C2364c.INFO);
    }

    public Uri m8634a(int i, C2364c c2364c) {
        Builder builder = new Builder();
        builder.scheme("csfdroid").authority("csfd.cz").appendEncodedPath("film").appendEncodedPath(i + "").appendEncodedPath(c2364c.m8604a());
        return builder.build();
    }

    public int mo3569a(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase("csfdroid")) {
            return Integer.parseInt((String) uri.getPathSegments().get(1));
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
                throw new C2307a(uri.toString(), e);
            }
        }
        throw new C2307a(uri.toString());
    }

    public C2364c mo3584b(Uri uri) {
        return C2364c.m8603a(uri);
    }
}
