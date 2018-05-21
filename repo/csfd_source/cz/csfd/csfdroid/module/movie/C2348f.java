package cz.csfd.csfdroid.module.movie;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2104l;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h.C2249e;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MovieGalleryFragment */
public class C2348f extends C1999d implements C1973d, C2249e {
    private C2366h f5771a;
    private CsfdApplication f5772b;
    private boolean f5773c = false;
    private boolean f5774d = false;
    private Exception f5775e;
    private boolean f5776f = false;
    private MovieInfo f5777g;
    private boolean f5778h = false;
    private LoadingView f5779i;
    private C2086a f5780j;
    private List<C2083a> f5781k;
    private C2105m f5782l;
    private OnClickListener f5783m;
    private AdBannerView f5784n;

    /* compiled from: MovieGalleryFragment */
    class C23441 implements OnClickListener {
        final /* synthetic */ C2348f f5765a;

        C23441(C2348f c2348f) {
            this.f5765a = c2348f;
        }

        public void onClick(View view) {
            this.f5765a.m8520b(this.f5765a.f5777g);
            this.f5765a.f5779i.setOnTryAgainListener(null);
            if (this.f5765a.f5782l != null) {
                this.f5765a.f5782l.m7412a(1);
            }
        }
    }

    /* compiled from: MovieGalleryFragment */
    class C23463 implements OnCancelListener {
        final /* synthetic */ C2348f f5768a;

        C23463(C2348f c2348f) {
            this.f5768a = c2348f;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5768a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5772b = m6380c().m6292m();
        this.f5771a = this.f5772b.m6219g().mo3453c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getListView().setAdapter(null);
        m8529g();
        getListView().setAdapter(this.f5780j);
        this.f5779i = (LoadingView) view.findViewById(R.id.loading);
        this.f5783m = new C23441(this);
        if (this.f5773c || this.f5774d) {
            this.f5779i.setVisibility(0);
        }
        if (this.f5774d) {
            C1988j.m6341a(getActivity(), this.f5779i, this.f5783m, this.f5775e);
        }
        getListView().setDivider(null);
    }

    private void m8529g() {
        this.f5784n = new AdBannerView(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("movieId")));
        this.f5784n.m7592a(C2146b.FILM, hashMap, mo3436p());
        getListView().addHeaderView(this.f5784n);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f5777g == null) {
            m6383f();
        } else if (i != 1) {
        } else {
            if (i2 == -1 || i2 == 0) {
                m8528d(this.f5777g);
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        int i3 = extras.getInt("displayed_photo", 0);
                        if (i3 != 0 && i3 < this.f5781k.size()) {
                            getListView().setSelectionFromTop(i3, getResources().getDimensionPixelSize(R.dimen.gallery_photo_selected_top_ofset));
                        }
                    }
                }
            }
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f5778h) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5778h = true;
        m8524c(getArguments().getInt("movieId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8524c(int i) {
        try {
            this.f5777g = C1992n.m6350a(i, getActivity());
            if (this.f5777g.m6996w() || this.f5773c) {
                m8528d(this.f5777g);
            } else {
                m8520b(this.f5777g);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
        }
    }

    private void m8520b(final MovieInfo movieInfo) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2348f f5767b;

            public void run() {
                this.f5767b.m8525c(movieInfo);
            }
        }, null, new C23463(this));
    }

    private void m8525c(MovieInfo movieInfo) {
        this.f5771a.mo3573a(movieInfo, C1998s.m6366a(getResources()).m6364a(), (C2249e) this, this.f5772b.m6220h());
    }

    public void onPause() {
        super.onPause();
        if (this.f5784n != null) {
            this.f5784n.m7595d();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f5784n != null) {
            this.f5784n.m7594c();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m8530i();
        if (this.f5784n != null) {
            this.f5784n.m7596e();
        }
    }

    private void m8530i() {
        if (this.f5777g != null) {
            this.f5771a.mo3589e(this.f5777g.m6705g());
        }
        m6383f();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (listView.getItemAtPosition(i) instanceof C2104l) {
            m6378a(mo3436p(), "photo_selected", null, 0);
            m8515a(this.f5777g, i - listView.getHeaderViewsCount());
        }
    }

    private void m8515a(MovieInfo movieInfo, int i) {
        this.f5772b.m6219g().mo3456f().mo3528a(movieInfo, i, getActivity());
    }

    public void mo3526b() {
        this.f5773c = true;
        if (!this.f5776f) {
            this.f5779i.setVisibility(0);
            this.f5779i.m9451e();
            this.f5779i.m9448b();
        }
    }

    public void m8533a(MovieInfo movieInfo) {
        this.f5773c = false;
        if (movieInfo == null) {
            this.f5774d = true;
            this.f5775e = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5779i, this.f5783m, this.f5775e);
            return;
        }
        this.f5774d = false;
        this.f5776f = true;
        this.f5777g = movieInfo;
        m8528d(this.f5777g);
        m8531j();
    }

    private void m8531j() {
        if (this.f5779i.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5779i.startAnimation(b);
            }
            this.f5779i.setVisibility(8);
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
        this.f5773c = false;
    }

    public void mo3323a(Exception exception) {
        this.f5773c = false;
        this.f5774d = true;
        this.f5775e = exception;
        C1988j.m6341a(getActivity(), this.f5779i, this.f5783m, this.f5775e);
        if (this.f5782l != null) {
            this.f5782l.m7412a(2);
        }
    }

    private void m8528d(MovieInfo movieInfo) {
        if (this.f5780j == null) {
            this.f5781k = new ArrayList();
            m8516a(movieInfo, this.f5781k);
            this.f5780j = new C2086a(getActivity(), this.f5781k);
            setListAdapter(this.f5780j);
            return;
        }
        m8516a(movieInfo, this.f5781k);
        this.f5780j.notifyDataSetChanged();
    }

    private void m8516a(MovieInfo movieInfo, List<C2083a> list) {
        List i = movieInfo.m6960i();
        if (i.size() > 0) {
            m8518a(i, (List) list);
            m8521b(movieInfo, (List) list);
        }
    }

    private void m8518a(List<Photo> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int a = m8513a((List) list2, size); a < size2; a++) {
            list2.add(new C2104l((Photo) list.get(a)));
        }
    }

    private int m8513a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f5782l) {
            return i;
        }
        list.remove(i - 1);
        this.f5782l = null;
        return i - 1;
    }

    private void m8521b(MovieInfo movieInfo, List<C2083a> list) {
        if (!movieInfo.m6996w()) {
            m8526c(movieInfo, list);
        }
    }

    private void m8526c(final MovieInfo movieInfo, List<C2083a> list) {
        this.f5782l = new C2105m(getString(R.string.movieinfo_fetching_gallery), new C2061a(this) {
            final /* synthetic */ C2348f f5770b;

            public void mo3416a() {
                if (this.f5770b.f5782l != null && this.f5770b.f5782l.m7417d() != 2) {
                    this.f5770b.m8520b(movieInfo);
                }
            }
        });
        this.f5782l.m7413a(this.f5783m);
        list.add(this.f5782l);
    }

    public String mo3436p() {
        return "/movie/gallery";
    }
}
