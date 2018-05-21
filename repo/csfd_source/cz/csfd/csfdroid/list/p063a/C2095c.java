package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ChartMovie;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.ChartMovieItemView;

/* compiled from: ChartMovieListItem */
public class C2095c extends C2094q {
    private ChartMovie f4913b;

    public C2095c(ChartMovie chartMovie) {
        super(chartMovie.m6727b(), 0);
        this.f4913b = chartMovie;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_chart_movie, viewGroup);
    }

    public ChartMovie m7345c() {
        return this.f4913b;
    }

    public String m7346d() {
        return this.f4913b.m6725a() + ".";
    }

    public int m7347e() {
        return this.f4913b.m6729c();
    }

    public String m7348f() {
        return this.f4913b.m6731d() + "%";
    }

    public int m7349g() {
        return this.f4913b.m6733e();
    }

    public int m7350h() {
        return this.f4913b.m6734f();
    }

    public Class<?> mo3427b() {
        return ChartMovieItemView.class;
    }
}
