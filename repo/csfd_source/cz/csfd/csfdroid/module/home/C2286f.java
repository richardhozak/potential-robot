package cz.csfd.csfdroid.module.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.home.C2284d.C2283b;
import cz.csfd.csfdroid.module.movie.C2366h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: ReleasesFragment */
public class C2286f extends C2063g<List<MovieInfo>> {
    private C2284d f5607j;
    private C2366h f5608k;
    private C2086a f5609l;
    private List<C2083a> f5610m = new ArrayList();
    private List<MovieInfo> f5611n = new ArrayList();
    private Calendar f5612o;
    private Calendar f5613p;
    private C2283b f5614q;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2138a g = this.b.m6219g();
        this.f5607j = g.mo3451a();
        this.f5608k = g.mo3453c();
        this.f5614q = (C2283b) getArguments().getSerializable("release_type");
        this.f5612o = m8263m();
        this.f5613p = this.f5612o;
    }

    private Calendar m8263m() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 5);
        return instance;
    }

    protected void mo3433j() {
        this.f5607j.mo3543a((C1945a) this, this.b.m6220h(), this.f5614q, this.f5613p.getTime());
        this.f5613p.add(4, 1);
    }

    protected void mo3434k() {
        this.f5607j.mo3545b();
    }

    protected void m8265b(List<MovieInfo> list) {
        this.f5611n.addAll(list);
        m7233a(this.f5610m);
        for (MovieInfo c2094q : list) {
            this.f5610m.add(new C2094q(c2094q, 2));
        }
        if (list.size() > 0) {
            m7234a(this.f5610m, (int) R.string.tvtips_fetching);
        }
        if (this.f5609l == null) {
            this.f5609l = new C2086a(getActivity(), this.f5610m);
            m6377a(C2146b.RELEASES, null);
            setListAdapter(this.f5609l);
            return;
        }
        this.f5609l.notifyDataSetChanged();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            this.f5608k.mo3575a(((C2094q) itemAtPosition).m7332i(), getActivity());
        }
    }

    public String mo3436p() {
        return "/home/cinema_releases";
    }
}
