package cz.csfd.csfdroid.module.tvschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.TvMovie;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2114v;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleStationDayFragment */
public class C2452f extends C2063g<List<TvStation>> {
    private CsfdApplication f6132j;
    private C2366h f6133k;
    private C2450d f6134l;
    private Date f6135m;
    private int f6136n;
    private List<C2083a> f6137o = new ArrayList();
    private C2086a f6138p;

    public void onCreate(Bundle bundle) {
        this.a = false;
        super.onCreate(bundle);
        this.f6132j = (CsfdApplication) getActivity().getApplication();
        this.f6133k = this.f6132j.m6219g().mo3453c();
        this.f6134l = this.f6132j.m6219g().mo3463m();
        this.f6135m = new Date(getArguments().getLong("date"));
        this.f6136n = getArguments().getInt("station");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m6377a(C2146b.TV, null);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2114v) {
            MovieInfo a = ((C2114v) itemAtPosition).m7450c().m7045a();
            if (a.m6705g() > 0) {
                this.f6133k.mo3575a(a, getActivity());
            }
        }
    }

    protected void mo3433j() {
        this.f6134l.mo3628a(this, this.f6132j.m6220h(), this.f6135m, Arrays.asList(new Integer[]{Integer.valueOf(this.f6136n)}), 0, false);
    }

    protected void mo3434k() {
        this.f6134l.mo3629b();
    }

    protected void m8981b(List<TvStation> list) {
        this.f6138p = new C2086a(getContext(), this.f6137o);
        for (TvStation tvStation : list) {
            List<TvMovie> e = tvStation.m7070e();
            if (e.size() > 0) {
                this.f6138p.m7313a(new C2101i(tvStation.m7066b()));
                for (TvMovie c2114v : e) {
                    this.f6138p.m7313a(new C2114v(c2114v));
                }
            }
        }
        setListAdapter(this.f6138p);
    }

    public String mo3436p() {
        return "/tv-schedule/station/day";
    }
}
