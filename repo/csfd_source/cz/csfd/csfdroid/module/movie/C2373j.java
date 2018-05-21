package cz.csfd.csfdroid.module.movie;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.Trivia;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.list.p063a.C2113u;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h.C2365f;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MovieTriviaFragment */
public class C2373j extends C1999d implements C1973d, C2365f {
    private C2366h f5867a;
    private CsfdApplication f5868b;
    private boolean f5869c = false;
    private boolean f5870d = false;
    private Exception f5871e;
    private boolean f5872f = false;
    private MovieInfo f5873g;
    private boolean f5874h = false;
    private LoadingView f5875i;
    private OnClickListener f5876j;
    private C2086a f5877k;
    private List<C2083a> f5878l;
    private C2105m f5879m;
    private AdBannerView f5880n;

    /* compiled from: MovieTriviaFragment */
    class C23691 implements OnClickListener {
        final /* synthetic */ C2373j f5861a;

        C23691(C2373j c2373j) {
            this.f5861a = c2373j;
        }

        public void onClick(View view) {
            this.f5861a.m8664b(this.f5861a.f5873g);
            this.f5861a.f5875i.setOnTryAgainListener(null);
            if (this.f5861a.f5879m != null) {
                this.f5861a.f5879m.m7412a(1);
            }
        }
    }

    /* compiled from: MovieTriviaFragment */
    class C23713 implements OnCancelListener {
        final /* synthetic */ C2373j f5864a;

        C23713(C2373j c2373j) {
            this.f5864a = c2373j;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5864a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5868b = m6380c().m6292m();
        this.f5867a = this.f5868b.m6219g().mo3453c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5875i = (LoadingView) view.findViewById(R.id.loading);
        this.f5876j = new C23691(this);
        if (this.f5869c || this.f5870d) {
            this.f5875i.setVisibility(0);
        }
        if (this.f5870d) {
            C1988j.m6341a(getActivity(), this.f5875i, this.f5876j, this.f5871e);
        }
    }

    private void m8673g() {
        this.f5880n = new AdBannerView(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("movieId")));
        this.f5880n.m7592a(C2146b.FILM, hashMap, mo3436p());
        getListView().addHeaderView(this.f5880n);
    }

    public void mo3477h() {
        m6382e();
        if (this.f5874h) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5874h = true;
        m8668c(getArguments().getInt("movieId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8668c(int i) {
        try {
            this.f5873g = C1992n.m6350a(i, getActivity());
            if (this.f5873g.m6905O() || this.f5869c) {
                m8672d(this.f5873g);
            } else {
                m8664b(this.f5873g);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
        }
    }

    private void m8664b(final MovieInfo movieInfo) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2373j f5863b;

            public void run() {
                this.f5863b.m8669c(movieInfo);
            }
        }, null, new C23713(this));
    }

    private void m8669c(MovieInfo movieInfo) {
        this.f5867a.mo3582a(movieInfo, (C2365f) this, this.f5868b.m6220h());
    }

    public void onPause() {
        super.onPause();
        if (this.f5880n != null) {
            this.f5880n.m7595d();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f5880n != null) {
            this.f5880n.m7594c();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m8674i();
        if (this.f5880n != null) {
            this.f5880n.m7596e();
        }
    }

    private void m8674i() {
        if (this.f5873g != null) {
            this.f5867a.mo3590f(this.f5873g.m6705g());
        }
        m6383f();
    }

    public void mo3592b() {
        this.f5869c = true;
        if (!this.f5872f) {
            this.f5875i.setVisibility(0);
            this.f5875i.m9451e();
            this.f5875i.m9448b();
        }
    }

    public void m8677a(MovieInfo movieInfo) {
        this.f5869c = false;
        if (movieInfo == null) {
            this.f5870d = true;
            this.f5871e = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5875i, this.f5876j, this.f5871e);
            return;
        }
        this.f5870d = false;
        this.f5872f = true;
        this.f5873g = movieInfo;
        m8672d(this.f5873g);
        m8675j();
    }

    private void m8675j() {
        if (this.f5875i.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5875i.startAnimation(b);
            }
            this.f5875i.setVisibility(8);
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
        this.f5869c = false;
    }

    public void mo3323a(Exception exception) {
        this.f5869c = false;
        this.f5870d = true;
        this.f5871e = exception;
        C1988j.m6341a(getActivity(), this.f5875i, this.f5876j, this.f5871e);
        if (this.f5879m != null) {
            this.f5879m.m7412a(2);
        }
    }

    private void m8672d(MovieInfo movieInfo) {
        if (this.f5877k == null) {
            m8673g();
            this.f5878l = new ArrayList();
            m8660a(movieInfo, this.f5878l);
            this.f5877k = new C2086a(getActivity(), this.f5878l);
            setListAdapter(this.f5877k);
            return;
        }
        m8660a(movieInfo, this.f5878l);
        this.f5877k.notifyDataSetChanged();
    }

    private void m8660a(MovieInfo movieInfo, List<C2083a> list) {
        List M = movieInfo.m6903M();
        if (M.size() > 0) {
            m8662a(M, (List) list);
            m8665b(movieInfo, (List) list);
        }
    }

    private void m8662a(List<Trivia> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int a = m8658a((List) list2, size); a < size2; a++) {
            list2.add(new C2113u((Trivia) list.get(a)));
        }
    }

    private int m8658a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f5879m) {
            return i;
        }
        list.remove(i - 1);
        this.f5879m = null;
        return i - 1;
    }

    private void m8665b(MovieInfo movieInfo, List<C2083a> list) {
        if (!movieInfo.m6905O()) {
            m8670c(movieInfo, list);
        }
    }

    private void m8670c(final MovieInfo movieInfo, List<C2083a> list) {
        this.f5879m = new C2105m(getString(R.string.movieinfo_fetching_trivia), new C2061a(this) {
            final /* synthetic */ C2373j f5866b;

            public void mo3416a() {
                if (this.f5866b.f5879m != null && this.f5866b.f5879m.m7417d() != 2) {
                    this.f5866b.m8664b(movieInfo);
                }
            }
        });
        this.f5879m.m7413a(this.f5876j);
        list.add(this.f5879m);
    }

    public String mo3436p() {
        return "/movie/trivia";
    }
}
