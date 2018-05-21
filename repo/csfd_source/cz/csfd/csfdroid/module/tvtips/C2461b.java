package cz.csfd.csfdroid.module.tvtips;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2020d;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.p060c.C1973d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TvTipsFragment */
public class C2461b extends C2063g<List<C2030g>> implements C1973d {
    private C2086a f6159j;
    private List<C2083a> f6160k = new ArrayList();
    private List<C2030g> f6161l = new ArrayList();
    private CsfdApplication f6162m;
    private C2366h f6163n;
    private C2057e f6164o;
    private long f6165p;
    private C2020d f6166q;

    public void onCreate(Bundle bundle) {
        this.a = false;
        super.onCreate(bundle);
        this.f6162m = m6380c().m6292m();
        this.f6163n = this.f6162m.m6219g().mo3453c();
        this.f6164o = this.f6162m.m6226n();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f6165p = arguments.getLong("date", 0);
        }
        if (this.f6165p == 0) {
            this.f6165p = System.currentTimeMillis();
        }
        this.f6166q = this.f6164o.m7216w();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m6377a(C2146b.TV, null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void mo3477h() {
        m6382e();
        if (!this.c && !this.d && this.f6161l.size() == 0) {
            g_();
        }
    }

    protected boolean mo3511l() {
        return false;
    }

    protected void mo3433j() {
        this.f6162m.m6219g().mo3462l().mo3635a(this, this.f6162m.m6220h(), this.f6165p, this.f6161l.size(), this.f6166q);
    }

    protected void mo3434k() {
        this.f6162m.m6219g().mo3462l().mo3633a(this.f6165p);
    }

    protected void m9011b(List<C2030g> list) {
        this.f6161l.addAll(list);
        m7233a(this.f6160k);
        for (C2030g a : list) {
            this.f6160k.add(new C2094q(a.m7109a(), 1));
        }
        if ((list.size() < 20 ? 1 : 0) == 0) {
            m7234a(this.f6160k, (int) R.string.tvtips_fetching);
        }
        if (this.f6159j == null) {
            this.f6159j = new C2086a(getActivity(), this.f6160k);
            setListAdapter(this.f6159j);
            return;
        }
        this.f6159j.notifyDataSetChanged();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            this.f6163n.mo3575a(((C2094q) itemAtPosition).m7332i(), getActivity());
        }
    }

    public String mo3436p() {
        return "/tv-tips/day";
    }
}
