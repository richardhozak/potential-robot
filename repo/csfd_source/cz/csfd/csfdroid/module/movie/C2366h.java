package cz.csfd.csfdroid.module.movie;

import android.content.Context;
import android.net.Uri;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.data.entity.Seasons;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: MovieModule */
public interface C2366h {

    /* compiled from: MovieModule */
    public interface C2249e extends C1945a<MovieInfo> {
        void mo3526b();
    }

    /* compiled from: MovieModule */
    public interface C2318h extends C1945a<MovieInfo> {
        void mo3563b();
    }

    /* compiled from: MovieModule */
    public interface C2327a extends C1945a<MovieInfo> {
        void mo3417g();
    }

    /* compiled from: MovieModule */
    public interface C2332b extends C1945a<MovieInfo> {
        void i_();
    }

    /* compiled from: MovieModule */
    public interface C2361d extends C1945a<MovieInfo> {
        void mo3568i();
    }

    /* compiled from: MovieModule */
    public interface C2362g extends C1945a<MovieInfo> {
        void mo3568i();
    }

    /* compiled from: MovieModule */
    public enum C2364c {
        INFO(""),
        COMMENTS("komentare"),
        CREATORS("tvurci"),
        TRIVIA("zajimavosti"),
        GALLERY("galerie"),
        VIDEOS("videa");
        
        private String f5844g;

        private C2364c(String str) {
            this.f5844g = str;
        }

        public String m8604a() {
            return this.f5844g;
        }

        public static C2364c m8603a(Uri uri) {
            try {
                if (uri.getPathSegments().size() >= 2) {
                    String str = (String) uri.getPathSegments().get(2);
                    Iterator it = EnumSet.allOf(C2364c.class).iterator();
                    while (it.hasNext()) {
                        C2364c c2364c = (C2364c) it.next();
                        if (c2364c.m8604a().equals(str)) {
                            return c2364c;
                        }
                    }
                }
                return INFO;
            } catch (Exception e) {
                return INFO;
            }
        }
    }

    /* compiled from: MovieModule */
    public interface C2365f extends C1945a<MovieInfo> {
        void mo3592b();
    }

    int mo3569a(Uri uri);

    void mo3570a();

    void mo3571a(int i);

    void mo3572a(int i, C1945a<Seasons> c1945a, CsfdDataProvider c2016c);

    void mo3573a(MovieInfo movieInfo, int i, C2249e c2249e, CsfdDataProvider c2016c);

    void mo3574a(MovieInfo movieInfo, int i, C2362g c2362g, CsfdDataProvider c2016c, Context context);

    void mo3575a(MovieInfo movieInfo, Context context);

    void mo3576a(MovieInfo movieInfo, MovieVideos movieVideos, int i, Context context);

    void mo3577a(MovieInfo movieInfo, MovieVideos movieVideos, int i, boolean z, Context context);

    void mo3578a(MovieInfo movieInfo, C2327a c2327a, CsfdDataProvider c2016c);

    void mo3579a(MovieInfo movieInfo, C2332b c2332b, CsfdDataProvider c2016c);

    void mo3580a(MovieInfo movieInfo, C2364c c2364c, Context context);

    void mo3581a(MovieInfo movieInfo, C2361d c2361d, CsfdDataProvider c2016c);

    void mo3582a(MovieInfo movieInfo, C2365f c2365f, CsfdDataProvider c2016c);

    void mo3583a(MovieInfo movieInfo, C2318h c2318h, CsfdDataProvider c2016c, boolean z, boolean z2);

    C2364c mo3584b(Uri uri);

    void mo3585b(int i);

    void mo3586b(MovieInfo movieInfo, Context context);

    void mo3587c(int i);

    void mo3588d(int i);

    void mo3589e(int i);

    void mo3590f(int i);

    Uri mo3591g(int i);
}
