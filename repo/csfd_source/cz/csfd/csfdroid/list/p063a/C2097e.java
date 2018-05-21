package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.CinemaMovie;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.CinemaMovieItemView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: CinemaMovieListItem */
public class C2097e extends C2083a {
    protected CinemaMovie f4917b;
    protected int f4918c = R.layout.list_item_cinema_movie;
    private int f4919d = this.f4917b.m6777g().ab();

    public C2097e(CinemaMovie cinemaMovie) {
        this.f4917b = cinemaMovie;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4918c, viewGroup);
    }

    public CinemaMovie m7364c() {
        return this.f4917b;
    }

    public String m7365d() {
        return this.f4917b.m6777g().m6917a();
    }

    public String m7366e() {
        return this.f4917b.m6777g().m6965j() != -1 ? this.f4917b.m6777g().m6965j() + "" : "";
    }

    public String m7367f() {
        return this.f4917b.m6777g().m6893C();
    }

    public List<String> m7368g() {
        List<String> arrayList = new ArrayList();
        for (Date format : this.f4917b.m6779h()) {
            arrayList.add(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(format));
        }
        return arrayList;
    }

    public int m7369h() {
        return this.f4919d;
    }

    public String m7370i() {
        return this.f4917b.m6777g().m6936d();
    }

    public Class<?> mo3427b() {
        return CinemaMovieItemView.class;
    }
}
