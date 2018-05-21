package cz.csfd.csfdroid.module.watchlist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.WatchlistMovie;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WatchlistFragment */
public class C2493a extends C2063g<List<WatchlistMovie>> {
    private C2086a f6257j;
    private List<C2083a> f6258k = new ArrayList();
    private List<WatchlistMovie> f6259l = new ArrayList();
    private CsfdApplication f6260m;
    private C2366h f6261n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6260m = m6380c().m6292m();
        this.f6261n = this.f6260m.m6219g().mo3453c();
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.WATCHLIST, null);
        if (this.f6257j != null) {
            setListAdapter(this.f6257j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.WATCHLIST, null, mo3436p());
    }

    protected void mo3433j() {
        this.f6260m.m6219g().mo3461k().mo3664a((C1945a) this, this.f6260m.m6220h(), this.f6259l.size());
    }

    protected void mo3434k() {
        this.f6260m.m6219g().mo3461k().mo3665b();
    }

    protected void m9181b(List<WatchlistMovie> list) {
        this.f6259l.addAll(list);
        m7233a(this.f6258k);
        for (WatchlistMovie a : list) {
            this.f6258k.add(new C2094q(a.m7082a(), 0));
        }
        if ((list.size() < 20 ? 1 : 0) == 0) {
            m7234a(this.f6258k, (int) R.string.watchlist_fetching);
        }
        if (this.f6257j == null) {
            if (this.f6258k.size() > 0) {
                this.f6258k.add(0, new C2101i(getString(R.string.side_menu_watchlist)));
            }
            this.f6257j = new C2086a(getActivity(), this.f6258k);
            setListAdapter(this.f6257j);
            return;
        }
        this.f6257j.notifyDataSetChanged();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            this.f6261n.mo3575a(((C2094q) itemAtPosition).m7332i(), getActivity());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public String mo3436p() {
        return "/watchlist";
    }
}
