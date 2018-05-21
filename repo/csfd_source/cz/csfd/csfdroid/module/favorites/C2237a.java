package cz.csfd.csfdroid.module.favorites;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityType;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2092a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.movie.C2366h.C2364c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FavoritesFragment */
public class C2237a extends C2063g<List<ActivityEntity>> {
    private C2086a f5475j;
    private List<C2083a> f5476k = new ArrayList();
    private List<ActivityEntity> f5477l = new ArrayList();
    private CsfdApplication f5478m;
    private C2366h f5479n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5478m = m6380c().m6292m();
        this.f5479n = this.f5478m.m6219g().mo3453c();
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.FAVORITES, null);
        if (this.f5475j != null) {
            setListAdapter(this.f5475j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.FAVORITES, null, mo3436p());
    }

    protected void mo3433j() {
        this.f5478m.m6219g().mo3460j().mo3524a(this, this.f5478m.m6220h(), this.f5477l.size());
    }

    protected void mo3434k() {
        this.f5478m.m6219g().mo3460j().mo3525b();
    }

    protected void m8089b(List<ActivityEntity> list) {
        this.f5477l.addAll(list);
        m7233a(this.f5476k);
        for (ActivityEntity c2092a : list) {
            this.f5476k.add(new C2092a(c2092a));
        }
        if ((list.size() < 20 ? 1 : 0) == 0) {
            m7234a(this.f5476k, (int) R.string.activity_fetching);
        }
        if (this.f5475j == null) {
            if (this.f5476k.size() > 0) {
                this.f5476k.add(0, new C2101i(getString(R.string.home_favorites)));
            }
            this.f5475j = new C2086a(getActivity(), this.f5476k);
            setListAdapter(this.f5475j);
            return;
        }
        this.f5475j.notifyDataSetChanged();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2092a) {
            ActivityEntity c = ((C2092a) itemAtPosition).m7322c();
            MovieInfo f = c.m6717f();
            if (c.m6706a().equals(ActivityType.FILM_COMMENT)) {
                this.f5479n.mo3580a(f, C2364c.COMMENTS, getActivity());
            } else {
                this.f5479n.mo3575a(f, getActivity());
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public String mo3436p() {
        return "/favorites";
    }
}
