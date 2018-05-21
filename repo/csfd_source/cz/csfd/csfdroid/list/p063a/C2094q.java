package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.MovieItemView;
import cz.csfd.csfdroid.p061d.C1992n;

/* compiled from: MovieListItem */
public class C2094q extends C2083a {
    private MovieInfo f4907b;
    private String f4908c;
    private String f4909d;
    private String f4910e = this.f4907b.m6927b();
    private String f4911f = C1992n.m6360d(this.f4907b);
    private int f4912g;

    public C2094q(MovieInfo movieInfo, int i) {
        this.f4907b = movieInfo;
        this.f4908c = C1992n.m6351a(movieInfo);
        this.f4909d = C1992n.m6359c(movieInfo);
        if (this.f4910e.equals(this.f4907b.m6917a())) {
            this.f4910e = "";
        }
        this.f4912g = i;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_movie, viewGroup);
    }

    public MovieInfo m7332i() {
        return this.f4907b;
    }

    public String m7333j() {
        return this.f4907b.m6917a();
    }

    public String m7334k() {
        return this.f4907b.m6965j() != -1 ? this.f4907b.m6965j() + "" : "";
    }

    public String m7335l() {
        return this.f4911f;
    }

    public String m7336m() {
        return this.f4910e;
    }

    public String m7337n() {
        return this.f4908c;
    }

    public String m7338o() {
        if (this.f4907b.ad().size() > 0) {
            return ((TvProgramm) this.f4907b.ad().get(0)).m7059e();
        }
        return null;
    }

    public String m7339p() {
        if (this.f4907b.ad().size() > 0) {
            return ((TvProgramm) this.f4907b.ad().get(0)).m7053a();
        }
        return null;
    }

    public String m7340q() {
        return this.f4907b.m6893C();
    }

    public String m7341r() {
        return this.f4907b.m6936d();
    }

    public int m7342s() {
        return this.f4912g;
    }

    public Class<?> mo3427b() {
        return MovieItemView.class;
    }
}
