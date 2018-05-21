package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.TvMovie;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.TvMovieItemView;
import cz.csfd.csfdroid.p061d.C1992n;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TvMovieListItem */
public class C2114v extends C2083a {
    private static final DateFormat f4947d = new SimpleDateFormat("H:mm");
    protected TvMovie f4948b;
    protected int f4949c = R.layout.list_item_tv_movie;
    private int f4950e = this.f4948b.m7045a().ab();

    public C2114v(TvMovie tvMovie) {
        this.f4948b = tvMovie;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4949c, viewGroup);
    }

    public TvMovie m7450c() {
        return this.f4948b;
    }

    public String m7451d() {
        return this.f4948b.m7045a().m6917a();
    }

    public String m7452e() {
        return this.f4948b.m7045a().m6965j() != -1 ? this.f4948b.m7045a().m6965j() + "" : "";
    }

    public String m7453f() {
        return C1992n.m6351a(this.f4948b.m7045a());
    }

    public int m7454g() {
        return this.f4950e;
    }

    public String m7455h() {
        return this.f4948b.m7045a().m6936d();
    }

    public String m7456i() {
        return f4947d.format(this.f4948b.m7049b());
    }

    public int m7457j() {
        long time = this.f4948b.m7049b().getTime();
        long time2 = this.f4948b.m7051c().getTime();
        long time3 = new Date().getTime();
        if (time > time3) {
            return 0;
        }
        if (time2 < time3) {
            return 100;
        }
        return (int) ((((float) (time3 - time)) / ((float) (time2 - time))) * 100.0f);
    }

    public Class<?> mo3427b() {
        return TvMovieItemView.class;
    }
}
