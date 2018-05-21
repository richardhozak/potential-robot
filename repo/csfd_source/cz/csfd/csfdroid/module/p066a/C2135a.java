package cz.csfd.csfdroid.module.p066a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.C2031h;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.list.p063a.C2118z;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VideosFragment */
public class C2135a extends C2063g<List<MovieVideo>> {
    private CsfdApplication f5126j;
    private C2136b f5127k;
    private C2366h f5128l;
    private C2086a f5129m;
    private List<C2083a> f5130n = new ArrayList();
    private List<MovieVideo> f5131o = new ArrayList();
    private C1945a<List<C2031h>> f5132p;
    private C2031h f5133q;
    private Spinner f5134r;
    private List<C2031h> f5135s;
    private AdBottomView f5136t;

    /* compiled from: VideosFragment */
    class C21321 implements C1945a<List<C2031h>> {
        final /* synthetic */ C2135a f5122a;

        C21321(C2135a c2135a) {
            this.f5122a = c2135a;
        }

        public void m7527a(List<C2031h> list) {
            this.f5122a.f5135s = list;
            this.f5122a.m7534c(this.f5122a.f5135s);
        }

        public void mo3323a(Exception exception) {
            this.f5122a.m7543m();
        }

        public void mo3322a() {
        }
    }

    /* compiled from: VideosFragment */
    class C21332 implements Runnable {
        final /* synthetic */ C2135a f5123a;

        C21332(C2135a c2135a) {
            this.f5123a = c2135a;
        }

        public void run() {
            this.f5123a.f5127k.mo3441a(this.f5123a.f5132p, this.f5123a.f5126j.m6220h());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        this.f5126j = m6380c().m6292m();
        C2138a g = this.f5126j.m6219g();
        this.f5127k = g.mo3465o();
        this.f5128l = g.mo3453c();
        this.f5133q = new C2031h(0, getResources().getString(R.string.hottest_videos));
        this.f5132p = new C21321(this);
        m7543m();
    }

    private void m7543m() {
        m6380c().m6277a(m6380c(), new C21332(this));
    }

    private void m7534c(final List<C2031h> list) {
        if (getActivity() != null) {
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = getString(R.string.hottest_videos);
            for (int i = 0; i < list.size(); i++) {
                strArr[i + 1] = ((C2031h) list.get(i)).m7111b();
            }
            SpinnerAdapter arrayAdapter = new ArrayAdapter(getActivity(), 17367048, strArr);
            arrayAdapter.setDropDownViewResource(17367049);
            this.f5134r.setAdapter(arrayAdapter);
            this.f5134r.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ C2135a f5125b;

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    C2031h c2031h;
                    if (i > 0) {
                        c2031h = (C2031h) list.get(i - 1);
                    } else {
                        c2031h = new C2031h(0, this.f5125b.getString(R.string.hottest_videos));
                    }
                    if (!this.f5125b.f5133q.equals(c2031h)) {
                        this.f5125b.f5133q = c2031h;
                        this.f5125b.f5131o.clear();
                        this.f5125b.f5130n.clear();
                        this.f5125b.m7238i();
                        this.f5125b.f5136t.m7620a();
                        this.f5125b.m6378a(this.f5125b.mo3436p(), "selected", this.f5125b.f5133q.m7111b(), 0);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f5134r.setEnabled(true);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.overlay_container);
        layoutInflater.inflate(R.layout.video_types_spinner, viewGroup2);
        this.f5134r = (Spinner) viewGroup2.findViewById(R.id.spinner);
        this.f5134r.setEnabled(false);
        return onCreateView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        View view2 = new View(getActivity());
        view2.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.videos_spinner_height)));
        getListView().addHeaderView(view2);
        this.f5136t = (AdBottomView) view.findViewById(R.id.ad_bottom);
        this.f5136t.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        this.f5136t.m7621a(C2146b.VIDEOS, null, mo3436p());
        if (this.f5129m != null) {
            setListAdapter(this.f5129m);
        }
        if (this.f5135s != null) {
            m7534c(this.f5135s);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2118z) {
            m7536d(this.f5131o.indexOf(((C2118z) itemAtPosition).m7473c()));
        }
    }

    private void m7536d(int i) {
        this.f5128l.mo3576a(((MovieVideo) this.f5131o.get(i)).m7007e(), new MovieVideos(this.f5131o), i, getActivity());
    }

    protected void mo3433j() {
        this.f5127k.mo3440a(this.f5133q.m7110a(), this.f5131o.size(), this, this.f5126j.m6220h(), this.f5126j.getApplicationContext());
    }

    protected void mo3434k() {
        this.f5127k.mo3439a(this.f5133q.m7110a());
    }

    protected void m7545b(List<MovieVideo> list) {
        if (this.f5131o.size() == 0) {
            getListView().setSelectionAfterHeaderView();
        }
        this.f5131o.addAll(list);
        m7233a(this.f5130n);
        for (MovieVideo c2118z : list) {
            this.f5130n.add(new C2118z(c2118z));
        }
        if (this.f5131o.size() == list.size()) {
            this.f5130n.add(2, new C2093b(C2146b.VIDEOS, mo3436p()));
        }
        if ((list.size() < 10 ? 1 : null) == null) {
            m7234a(this.f5130n, (int) R.string.videos_fetching);
        }
        if (this.f5129m == null) {
            this.f5129m = new C2086a(getActivity(), this.f5130n);
            setListAdapter(this.f5129m);
            return;
        }
        this.f5129m.notifyDataSetChanged();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5127k.mo3442b();
    }

    public String mo3436p() {
        return "/video";
    }
}
