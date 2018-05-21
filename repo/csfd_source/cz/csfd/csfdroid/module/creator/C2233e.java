package cz.csfd.csfdroid.module.creator;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.list.p063a.C2104l;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.p060c.C1973d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: CreatorGalleryFragment */
public class C2233e extends C2063g<MovieCreator> implements C1973d {
    private CsfdApplication f5452j;
    private C2234f f5453k;
    private C2366h f5454l;
    private int f5455m;
    private MovieCreator f5456n;
    private boolean f5457o = false;
    private C2086a f5458p;
    private List<C2083a> f5459q = new ArrayList();
    private List<Photo> f5460r = new ArrayList();

    protected /* synthetic */ void mo3432b(Object obj) {
        m8049a((MovieCreator) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5452j = m6380c().m6292m();
        C2138a g = this.f5452j.m6219g();
        this.f5453k = g.mo3454d();
        this.f5454l = g.mo3453c();
        this.f5455m = getArguments().getInt("creatorId");
        this.f5456n = new MovieCreator(this.f5455m);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        if (this.f5458p != null) {
            setListAdapter(this.f5458p);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (listView.getItemAtPosition(i) instanceof C2104l) {
            m6378a(mo3436p(), "photo_selected", null, 0);
            int headerViewsCount = i - listView.getHeaderViewsCount();
            if (headerViewsCount > 2) {
                headerViewsCount--;
            }
            m8047a(this.f5456n, headerViewsCount);
        }
    }

    private void m8047a(MovieCreator movieCreator, int i) {
        this.f5452j.m6219g().mo3456f().mo3527a(movieCreator, i, getActivity());
    }

    public void mo3477h() {
        m6382e();
        if (this.f5457o) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        mo3417g();
        this.f5457o = true;
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    protected void mo3433j() {
        this.f5453k.mo3515a(this.f5456n, this.f5456n.m6885t().size(), 20, this, this.f5452j.m6220h());
    }

    protected void mo3434k() {
        this.f5453k.mo3521d(this.f5455m);
    }

    protected void m8049a(MovieCreator movieCreator) {
        m7233a(this.f5459q);
        m8048a(movieCreator.m6885t(), this.f5459q);
        if (this.f5459q.size() == movieCreator.m6885t().size()) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(getArguments().getInt("creatorId")));
            this.f5459q.add(Math.min(this.f5459q.size(), 1), new C2093b(C2146b.CREATOR, hashMap, mo3436p()));
        }
        if (!movieCreator.m6884s()) {
            m7234a(this.f5459q, (int) R.string.loading);
        }
        if (this.f5458p == null) {
            this.f5458p = new C2086a(getActivity(), this.f5459q);
            setListAdapter(this.f5458p);
            return;
        }
        this.f5458p.notifyDataSetChanged();
    }

    private void m8048a(List<Photo> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int i = size; i < size2; i++) {
            list2.add(new C2104l((Photo) list.get(i)));
        }
    }

    protected boolean mo3511l() {
        return false;
    }

    public String mo3436p() {
        return "/creator/gallery";
    }
}
