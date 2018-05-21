package cz.csfd.csfdroid.module.movie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2099g;
import cz.csfd.csfdroid.list.p063a.C2100h;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.module.movie.C2366h.C2332b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MovieCreatorsFragment */
public class C2333d extends C1999d implements C1973d, C2332b {
    private C2366h f5725a;
    private CsfdApplication f5726b;
    private C1995q f5727c;
    private boolean f5728d = false;
    private boolean f5729e = false;
    private Exception f5730f;
    private MovieInfo f5731g;
    private boolean f5732h = false;
    private LoadingView f5733i;
    private OnClickListener f5734j;

    /* compiled from: MovieCreatorsFragment */
    class C23291 implements OnClickListener {
        final /* synthetic */ C2333d f5721a;

        C23291(C2333d c2333d) {
            this.f5721a = c2333d;
        }

        public void onClick(View view) {
            this.f5721a.m8469b(this.f5721a.f5731g);
            this.f5721a.f5733i.setOnTryAgainListener(null);
        }
    }

    /* compiled from: MovieCreatorsFragment */
    class C23313 implements OnCancelListener {
        final /* synthetic */ C2333d f5724a;

        C23313(C2333d c2333d) {
            this.f5724a = c2333d;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5724a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5726b = m6380c().m6292m();
        this.f5725a = this.f5726b.m6219g().mo3453c();
        this.f5727c = new C1995q(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5733i = (LoadingView) view.findViewById(R.id.loading);
        this.f5734j = new C23291(this);
        if (this.f5728d || this.f5729e) {
            this.f5733i.setVisibility(0);
        }
        if (this.f5729e) {
            C1988j.m6341a(getActivity(), this.f5733i, this.f5734j, this.f5730f);
        }
        m8472c(getArguments().getInt("movieId"));
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2099g) {
            m8465a(((C2099g) itemAtPosition).m7379c());
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f5732h) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5732h = true;
        m8472c(getArguments().getInt("movieId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8472c(int i) {
        try {
            this.f5731g = C1992n.m6350a(i, getActivity());
            if (this.f5731g.af()) {
                m8474d(this.f5731g);
            } else {
                m8469b(this.f5731g);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
        }
    }

    private void m8469b(final MovieInfo movieInfo) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2333d f5723b;

            public void run() {
                this.f5723b.m8473c(movieInfo);
            }
        }, null, new C23313(this));
    }

    private void m8473c(MovieInfo movieInfo) {
        this.f5725a.mo3579a(movieInfo, (C2332b) this, this.f5726b.m6220h());
    }

    public void onResume() {
        super.onResume();
        this.f5727c.m6362a((C2086a) getListAdapter());
    }

    public void onDestroy() {
        super.onDestroy();
        m8476i();
    }

    private void m8476i() {
        if (this.f5731g != null) {
            this.f5725a.mo3585b(this.f5731g.m6705g());
        }
        m6383f();
    }

    public void i_() {
        this.f5728d = true;
        this.f5733i.setVisibility(0);
        this.f5733i.m9451e();
        this.f5733i.m9448b();
    }

    public void m8479a(MovieInfo movieInfo) {
        this.f5728d = false;
        if (movieInfo == null) {
            this.f5729e = true;
            this.f5730f = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5733i, this.f5734j, this.f5730f);
            return;
        }
        this.f5729e = false;
        this.f5731g = movieInfo;
        m8474d(this.f5731g);
        m8477j();
    }

    private void m8477j() {
        Animation b;
        if (this.f5733i.getVisibility() == 0) {
            b = m6379b(17432577);
            if (b != null) {
                this.f5733i.startAnimation(b);
            }
            this.f5733i.setVisibility(8);
        }
        if (getView() != null) {
            b = m6379b(17432576);
            if (b != null) {
                getListView().startAnimation(b);
            } else {
                getListView().setVisibility(0);
            }
        }
    }

    public void mo3322a() {
        this.f5728d = false;
    }

    public void mo3323a(Exception exception) {
        this.f5728d = false;
        this.f5729e = true;
        this.f5730f = exception;
        C1988j.m6341a(getActivity(), this.f5733i, this.f5734j, this.f5730f);
    }

    private void m8474d(MovieInfo movieInfo) {
        setListAdapter(m8475e(movieInfo));
    }

    private C2086a m8475e(MovieInfo movieInfo) {
        List arrayList = new ArrayList();
        C2333d.m8464a(getActivity(), movieInfo.m6946f(), R.string.movieinfo_actors, arrayList);
        return new C2086a(getActivity(), arrayList);
    }

    static C2086a m8462a(Context context, MovieInfo movieInfo) {
        List arrayList = new ArrayList();
        List f = movieInfo.m6946f();
        if (f.size() >= context.getResources().getInteger(R.integer.creators_grid_row_size)) {
            C2333d.m8468b(context, f, R.string.movieinfo_actors, arrayList);
        } else {
            C2333d.m8464a(context, f, R.string.movieinfo_actors, arrayList);
        }
        C2333d.m8464a(context, movieInfo.m6970k(), R.string.movieinfo_directors, arrayList);
        C2333d.m8464a(context, movieInfo.m6980m(), R.string.movieinfo_authors, arrayList);
        C2333d.m8464a(context, movieInfo.m6984n(), R.string.movieinfo_screenwriters, arrayList);
        C2333d.m8464a(context, movieInfo.m6986o(), R.string.movieinfo_cinematographers, arrayList);
        C2333d.m8464a(context, movieInfo.m6975l(), R.string.movieinfo_composers, arrayList);
        C2333d.m8464a(context, movieInfo.m6988p(), R.string.movieinfo_production, arrayList);
        C2333d.m8464a(context, movieInfo.m6990q(), R.string.movieinfo_edit, arrayList);
        C2333d.m8464a(context, movieInfo.m6991r(), R.string.movieinfo_sound, arrayList);
        C2333d.m8464a(context, movieInfo.m6992s(), R.string.movieinfo_scenographies, arrayList);
        C2333d.m8464a(context, movieInfo.m6993t(), R.string.movieinfo_masks, arrayList);
        C2333d.m8464a(context, movieInfo.m6994u(), R.string.movieinfo_costumes, arrayList);
        return new C2086a(context, arrayList);
    }

    private static void m8464a(Context context, List<MovieCreator> list, int i, List<C2083a> list2) {
        if (list.size() > 0) {
            list2.addAll(C2333d.m8463a((List) list, context.getString(i)));
        }
    }

    private static List<C2083a> m8463a(List<MovieCreator> list, String str) {
        List<C2083a> arrayList = new ArrayList();
        if (list.size() > 0) {
            arrayList.add(new C2101i(str));
            for (MovieCreator c2099g : list) {
                arrayList.add(new C2099g(c2099g, false));
            }
        }
        return arrayList;
    }

    private static void m8468b(Context context, List<MovieCreator> list, int i, List<C2083a> list2) {
        if (list.size() > 0) {
            C2101i c2101i = new C2101i(context.getString(i), "(" + list.size() + ")");
            c2101i.m7395a(true);
            c2101i.m7394a("actors");
            list2.add(c2101i);
            int integer = context.getResources().getInteger(R.integer.creators_grid_row_size);
            if (list.size() < integer) {
                integer = list.size();
            }
            list2.add(new C2100h(list.subList(0, integer)));
        }
    }

    private void m8465a(MovieCreator movieCreator) {
        this.f5726b.m6219g().mo3454d().mo3516a(movieCreator, getActivity());
    }

    public String mo3436p() {
        return "/movie/creators";
    }
}
