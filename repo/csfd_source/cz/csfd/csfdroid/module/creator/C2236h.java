package cz.csfd.csfdroid.module.creator;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.list.p063a.C2118z;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.p060c.C1973d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: CreatorVideosFragment */
public class C2236h extends C2063g<List<MovieVideo>> implements C1973d {
    private CsfdApplication f5467j;
    private C2234f f5468k;
    private C2366h f5469l;
    private int f5470m;
    private boolean f5471n = false;
    private C2086a f5472o;
    private List<C2083a> f5473p = new ArrayList();
    private List<MovieVideo> f5474q = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5467j = m6380c().m6292m();
        C2138a g = this.f5467j.m6219g();
        this.f5468k = g.mo3454d();
        this.f5469l = g.mo3453c();
        this.f5470m = getArguments().getInt("creatorId");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        if (this.f5472o != null) {
            setListAdapter(this.f5472o);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2118z) {
            m8077a(((C2118z) itemAtPosition).m7473c());
        }
    }

    private void m8077a(MovieVideo movieVideo) {
        this.f5469l.mo3576a(movieVideo.m7007e(), new MovieVideos(this.f5474q), this.f5474q.indexOf(movieVideo), getActivity());
    }

    public void mo3477h() {
        m6382e();
        if (this.f5471n) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        mo3417g();
        this.f5471n = true;
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    protected void mo3433j() {
        this.f5468k.mo3514a(this.f5470m, this.f5474q.size(), 20, this, this.f5467j.m6220h(), getActivity());
    }

    protected void mo3434k() {
        this.f5468k.mo3520c(this.f5470m);
    }

    protected void m8079b(List<MovieVideo> list) {
        this.f5474q.addAll(list);
        m7233a(this.f5473p);
        for (MovieVideo c2118z : list) {
            this.f5473p.add(new C2118z(c2118z));
        }
        if (this.f5474q.size() == list.size()) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(getArguments().getInt("creatorId")));
            this.f5473p.add(Math.min(2, this.f5474q.size()), new C2093b(C2146b.CREATOR, hashMap, mo3436p()));
        }
        if ((list.size() < 20 ? 1 : null) == null) {
            m7234a(this.f5473p, (int) R.string.videos_fetching);
        }
        if (this.f5472o == null) {
            this.f5472o = new C2086a(getActivity(), this.f5473p);
            setListAdapter(this.f5472o);
            return;
        }
        this.f5472o.notifyDataSetChanged();
    }

    protected boolean mo3511l() {
        return false;
    }

    public String mo3436p() {
        return "/creator/videos";
    }
}
