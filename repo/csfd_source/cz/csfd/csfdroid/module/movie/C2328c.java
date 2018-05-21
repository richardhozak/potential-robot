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
import cz.csfd.csfdroid.data.entity.Comment;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2098f;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.list.p063a.C2109r;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h.C2327a;
import cz.csfd.csfdroid.module.user.C2489d;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: MovieCommentsFragment */
public class C2328c extends C1999d implements C1973d, C2327a {
    private C2366h f5706a;
    private C2489d f5707b;
    private CsfdApplication f5708c;
    private boolean f5709d = false;
    private boolean f5710e = false;
    private Exception f5711f;
    private boolean f5712g = false;
    private MovieInfo f5713h;
    private boolean f5714i = false;
    private LoadingView f5715j;
    private OnClickListener f5716k;
    private C2086a f5717l;
    private List<C2083a> f5718m;
    private C2105m f5719n;
    private AdBannerView f5720o;

    /* compiled from: MovieCommentsFragment */
    class C23231 implements OnClickListener {
        final /* synthetic */ C2328c f5700a;

        C23231(C2328c c2328c) {
            this.f5700a = c2328c;
        }

        public void onClick(View view) {
            this.f5700a.m8439b(this.f5700a.f5713h);
            this.f5700a.f5715j.setOnTryAgainListener(null);
            if (this.f5700a.f5719n != null) {
                this.f5700a.f5719n.m7412a(1);
            }
        }
    }

    /* compiled from: MovieCommentsFragment */
    class C23253 implements OnCancelListener {
        final /* synthetic */ C2328c f5703a;

        C23253(C2328c c2328c) {
            this.f5703a = c2328c;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5703a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5708c = m6380c().m6292m();
        this.f5706a = this.f5708c.m6219g().mo3453c();
        this.f5707b = this.f5708c.m6219g().mo3459i();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5715j = (LoadingView) view.findViewById(R.id.loading);
        this.f5716k = new C23231(this);
        if (this.f5709d || this.f5710e) {
            this.f5715j.setVisibility(0);
        }
        if (this.f5710e) {
            C1988j.m6341a(getActivity(), this.f5715j, this.f5716k, this.f5711f);
        }
    }

    private void m8451i() {
        this.f5720o = new AdBannerView(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("movieId")));
        this.f5720o.m7592a(C2146b.FILM, hashMap, mo3436p());
        getListView().addHeaderView(this.f5720o);
    }

    public void mo3477h() {
        m6382e();
        if (this.f5714i) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5714i = true;
        m8443c(getArguments().getInt("movieId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8443c(int i) {
        try {
            this.f5713h = C1992n.m6350a(i, getActivity());
            if (this.f5713h.m6910T() || this.f5709d) {
                m8447d(this.f5713h);
            } else {
                m8439b(this.f5713h);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
        }
    }

    private void m8439b(final MovieInfo movieInfo) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2328c f5702b;

            public void run() {
                this.f5702b.m8444c(movieInfo);
            }
        }, null, new C23253(this));
    }

    private void m8444c(MovieInfo movieInfo) {
        this.f5706a.mo3578a(movieInfo, (C2327a) this, this.f5708c.m6220h());
    }

    public void onResume() {
        super.onResume();
        if (this.f5720o != null) {
            this.f5720o.m7594c();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f5720o != null) {
            this.f5720o.m7595d();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m8452j();
        if (this.f5720o != null) {
            this.f5720o.m7596e();
        }
    }

    private void m8452j() {
        if (this.f5713h != null) {
            this.f5706a.mo3587c(this.f5713h.m6705g());
        }
        m6383f();
    }

    public void mo3417g() {
        this.f5709d = true;
        if (!this.f5712g) {
            this.f5715j.setVisibility(0);
            this.f5715j.m9451e();
            this.f5715j.m9448b();
        }
    }

    public void m8455a(MovieInfo movieInfo) {
        this.f5709d = false;
        if (movieInfo == null) {
            this.f5710e = true;
            C1988j.m6341a(getActivity(), this.f5715j, this.f5716k, this.f5711f);
            return;
        }
        this.f5710e = false;
        this.f5712g = true;
        this.f5713h = movieInfo;
        m8447d(this.f5713h);
        m8453k();
    }

    private void m8453k() {
        if (this.f5715j.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5715j.startAnimation(b);
            }
            this.f5715j.setVisibility(8);
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
        this.f5709d = false;
    }

    public void mo3323a(Exception exception) {
        this.f5709d = false;
        this.f5710e = true;
        this.f5711f = exception;
        C1988j.m6341a(getActivity(), this.f5715j, this.f5716k, this.f5711f);
        if (this.f5719n != null) {
            this.f5719n.m7412a(2);
        }
    }

    private void m8447d(MovieInfo movieInfo) {
        if (this.f5717l == null) {
            m8451i();
            this.f5718m = new ArrayList();
            m8435a(movieInfo, this.f5718m);
            m8440b(movieInfo, this.f5718m);
            this.f5717l = new C2086a(getActivity(), this.f5718m);
            setListAdapter(this.f5717l);
            return;
        }
        m8440b(movieInfo, this.f5718m);
        this.f5717l.notifyDataSetChanged();
    }

    private void m8435a(MovieInfo movieInfo, List<C2083a> list) {
        if (m8450f(movieInfo)) {
            list.add(new C2109r(m8449e(movieInfo)));
        }
    }

    private Comment m8449e(MovieInfo movieInfo) {
        Comment comment = new Comment(new User(this.f5708c.m6229q().m6253c(), this.f5708c.m6229q().m6256f().name), movieInfo.m6906P(), movieInfo.m6909S(), new Date());
        comment.m6781a(movieInfo.m6908R());
        return comment;
    }

    private boolean m8450f(MovieInfo movieInfo) {
        return this.f5708c.m6229q().m6250a() && movieInfo.m6909S().length() > 0;
    }

    private void m8440b(MovieInfo movieInfo, List<C2083a> list) {
        List K = movieInfo.m6901K();
        if (K.size() > 0) {
            m8437a(K, (List) list);
            m8445c(movieInfo, list);
        }
    }

    private void m8437a(List<Comment> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int a = m8433a((List) list2, size); a < size2; a++) {
            list2.add(new C2098f((Comment) list.get(a)));
        }
    }

    private int m8433a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f5719n) {
            return i;
        }
        list.remove(i - 1);
        this.f5719n = null;
        return i - 1;
    }

    private void m8445c(MovieInfo movieInfo, List<C2083a> list) {
        if (!movieInfo.m6910T()) {
            m8448d(movieInfo, list);
        }
    }

    private void m8448d(final MovieInfo movieInfo, List<C2083a> list) {
        this.f5719n = new C2105m(getString(R.string.movieinfo_fetching_comments), new C2061a(this) {
            final /* synthetic */ C2328c f5705b;

            public void mo3416a() {
                if (this.f5705b.f5719n != null && this.f5705b.f5719n.m7417d() != 2) {
                    this.f5705b.m8439b(movieInfo);
                }
            }
        });
        this.f5719n.m7413a(this.f5716k);
        list.add(this.f5719n);
    }

    public String mo3436p() {
        return "/movie/comments";
    }
}
