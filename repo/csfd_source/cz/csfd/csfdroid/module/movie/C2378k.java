package cz.csfd.csfdroid.module.movie;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.list.p063a.C2118z;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h.C2362g;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MovieVideosFragment */
public class C2378k extends C1999d implements OnScrollListener, C1973d, C2362g {
    private C2366h f5887a;
    private CsfdApplication f5888b;
    private boolean f5889c = false;
    private boolean f5890d = false;
    private Exception f5891e;
    private boolean f5892f = false;
    private MovieInfo f5893g;
    private boolean f5894h = false;
    private LoadingView f5895i;
    private C2086a f5896j;
    private List<C2083a> f5897k;
    private C2105m f5898l;
    private OnClickListener f5899m;
    private AdBannerView f5900n;

    /* compiled from: MovieVideosFragment */
    class C23741 implements OnClickListener {
        final /* synthetic */ C2378k f5881a;

        C23741(C2378k c2378k) {
            this.f5881a = c2378k;
        }

        public void onClick(View view) {
            this.f5881a.m8690b(this.f5881a.f5893g);
            this.f5881a.f5895i.setOnTryAgainListener(null);
            if (this.f5881a.f5898l != null) {
                this.f5881a.f5898l.m7412a(1);
            }
        }
    }

    /* compiled from: MovieVideosFragment */
    class C23763 implements OnCancelListener {
        final /* synthetic */ C2378k f5884a;

        C23763(C2378k c2378k) {
            this.f5884a = c2378k;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5884a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5888b = m6380c().m6292m();
        this.f5887a = this.f5888b.m6219g().mo3453c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5895i = (LoadingView) view.findViewById(R.id.loading);
        this.f5899m = new C23741(this);
        if (this.f5889c || this.f5890d) {
            this.f5895i.setVisibility(0);
        }
        if (this.f5890d) {
            C1988j.m6341a(getActivity(), this.f5895i, this.f5899m, this.f5891e);
        }
        getListView().setOnScrollListener(this);
    }

    private void m8700g() {
        this.f5900n = new AdBannerView(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("movieId")));
        this.f5900n.m7592a(C2146b.FILM, hashMap, mo3436p());
        getListView().addHeaderView(this.f5900n);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2118z) {
            ((C2118z) itemAtPosition).m7473c();
            m8694c(i - listView.getHeaderViewsCount());
        }
    }

    private void m8694c(int i) {
        this.f5887a.mo3576a(this.f5893g, new MovieVideos(this.f5893g.m6911U()), i, getActivity());
    }

    public void mo3477h() {
        m6382e();
        if (this.f5894h) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5894h = true;
        m8698d(getArguments().getInt("movieId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8698d(int i) {
        try {
            this.f5893g = C1992n.m6350a(i, getActivity());
            if (this.f5893g.m6913W() || this.f5889c) {
                m8699d(this.f5893g);
            } else {
                m8690b(this.f5893g);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
        }
    }

    private void m8690b(final MovieInfo movieInfo) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2378k f5883b;

            public void run() {
                this.f5883b.m8695c(movieInfo);
            }
        }, null, new C23763(this));
    }

    private void m8695c(MovieInfo movieInfo) {
        this.f5887a.mo3574a(movieInfo, C1998s.m6366a(getResources()).m6364a(), (C2362g) this, this.f5888b.m6220h(), getActivity());
    }

    public void onPause() {
        super.onPause();
        if (this.f5900n != null) {
            this.f5900n.m7595d();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f5900n != null) {
            this.f5900n.m7594c();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m8701j();
        if (this.f5900n != null) {
            this.f5900n.m7596e();
        }
    }

    private void m8701j() {
        if (this.f5893g != null) {
            this.f5887a.mo3588d(this.f5893g.m6705g());
        }
        m6383f();
    }

    public void mo3568i() {
        this.f5889c = true;
        if (!this.f5892f) {
            this.f5895i.setVisibility(0);
            this.f5895i.m9451e();
            this.f5895i.m9448b();
        }
    }

    public void m8704a(MovieInfo movieInfo) {
        this.f5889c = false;
        if (movieInfo == null) {
            this.f5890d = true;
            this.f5891e = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5895i, this.f5899m, this.f5891e);
            return;
        }
        this.f5890d = false;
        this.f5892f = true;
        this.f5893g = movieInfo;
        m8699d(this.f5893g);
        m8702k();
    }

    private void m8702k() {
        if (this.f5895i.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5895i.startAnimation(b);
            }
            this.f5895i.setVisibility(8);
            if (getView() != null) {
                b = m6379b(17432576);
                if (b != null) {
                    getListView().startAnimation(b);
                } else {
                    getListView().setVisibility(0);
                }
            }
        }
    }

    public void mo3322a() {
        this.f5889c = false;
    }

    public void mo3323a(Exception exception) {
        this.f5889c = false;
        this.f5890d = true;
        this.f5891e = exception;
        C1988j.m6341a(getActivity(), this.f5895i, this.f5899m, this.f5891e);
        if (this.f5898l != null) {
            this.f5898l.m7412a(2);
        }
    }

    private void m8699d(MovieInfo movieInfo) {
        if (this.f5896j == null) {
            m8700g();
            this.f5897k = new ArrayList();
            m8686a(movieInfo, this.f5897k);
            this.f5896j = new C2086a(getActivity(), this.f5897k);
            setListAdapter(this.f5896j);
            return;
        }
        m8686a(movieInfo, this.f5897k);
        this.f5896j.notifyDataSetChanged();
    }

    private void m8686a(MovieInfo movieInfo, List<C2083a> list) {
        List U = movieInfo.m6911U();
        if (U.size() > 0) {
            m8688a(U, (List) list);
            m8691b(movieInfo, (List) list);
        }
    }

    private void m8688a(List<MovieVideo> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int a = m8684a((List) list2, size); a < size2; a++) {
            list2.add(new C2118z((MovieVideo) list.get(a)));
        }
    }

    private int m8684a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f5898l) {
            return i;
        }
        list.remove(i - 1);
        this.f5898l = null;
        return i - 1;
    }

    private void m8691b(MovieInfo movieInfo, List<C2083a> list) {
        if (!movieInfo.m6913W()) {
            m8696c(movieInfo, list);
        }
    }

    private void m8696c(final MovieInfo movieInfo, List<C2083a> list) {
        this.f5898l = new C2105m(getString(R.string.movieinfo_fetching_videos), new C2061a(this) {
            final /* synthetic */ C2378k f5886b;

            public void mo3416a() {
                if (this.f5886b.f5898l != null && this.f5886b.f5898l.m7417d() != 2) {
                    this.f5886b.m8690b(movieInfo);
                }
            }
        });
        this.f5898l.m7413a(this.f5899m);
        list.add(this.f5898l);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (getListView() == absListView && i != 2) {
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public String mo3436p() {
        return "/movie/trailers";
    }
}
