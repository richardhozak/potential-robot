package cz.csfd.csfdroid.module.cinema;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_TimeRange;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2096d;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1973d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FavoriteCinemaListFragment */
public class C2207i extends C2063g<List<Cinema>> implements C1973d {
    private CsfdApplication f5363j;
    private C2057e f5364k;
    private C2138a f5365l;
    private C2197e f5366m;
    private int f5367n;
    private boolean f5368o;
    private Enum_TimeRange f5369p;
    private long f5370q;
    private C2086a f5371r;
    private List<C2083a> f5372s = new ArrayList();

    public void onCreate(Bundle bundle) {
        this.a = false;
        super.onCreate(bundle);
        this.f5363j = m6380c().m6292m();
        this.f5364k = this.f5363j.m6226n();
        this.f5365l = this.f5363j.m6219g();
        this.f5366m = this.f5365l.mo3457g();
        this.f5367n = getArguments().getInt("movie_id");
        this.f5368o = this.f5364k.m7211q();
        this.f5369p = this.f5364k.m7212r();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.CINEMAS, null);
        if (this.f5371r != null) {
            setListAdapter(this.f5371r);
        }
    }

    protected void mo3433j() {
        this.f5366m.mo3494a(this.f5367n, this.f5368o, this.f5369p, this, this.f5363j.m6220h());
    }

    protected void mo3434k() {
        this.f5366m.mo3506e();
    }

    protected void m7922b(List<Cinema> list) {
        this.f5372s.clear();
        for (Cinema cinema : list) {
            cinema.m6751c(true);
            this.f5372s.add(new C2096d(cinema, 0));
        }
        if (this.f5371r == null) {
            this.f5371r = new C2086a(getActivity());
            this.f5371r.m7314a(this.f5372s);
            setListAdapter(this.f5371r);
            return;
        }
        this.f5371r.m7314a(this.f5372s);
        setListAdapter(this.f5371r);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2096d) {
            this.f5366m.mo3496a(getActivity(), ((C2096d) itemAtPosition).m7353c(), Integer.valueOf(this.f5367n));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_cinemas_without_schedule:
                m7920m();
                m7238i();
                return true;
            case R.id.menu_item_date_all:
            case R.id.menu_item_date_month:
            case R.id.menu_item_date_today:
            case R.id.menu_item_date_tomorrow:
            case R.id.menu_item_date_week:
            case R.id.menu_item_date_weekend:
                m7920m();
                m7238i();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m7920m() {
        this.f5368o = this.f5364k.m7211q();
        this.f5369p = this.f5364k.m7212r();
    }

    public void mo3477h() {
        m6382e();
    }

    public void onResume() {
        super.onResume();
        long y = this.f5363j.m6226n().m7218y();
        if (!this.c && this.e && this.f5370q > 0 && this.f5370q != y) {
            mo3433j();
        }
        this.f5370q = y;
    }

    public String mo3436p() {
        return "/cinemas/favorites";
    }
}
