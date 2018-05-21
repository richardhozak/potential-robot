package cz.csfd.csfdroid.module.creator;

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
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.Filmography;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.creator.C2234f.C2231b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1991m;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CreatorFilmographyFragment */
public class C2232d extends C1999d implements C1973d, C2231b {
    private C2234f f5441a;
    private CsfdApplication f5442b;
    private C1995q f5443c;
    private boolean f5444d = false;
    private boolean f5445e = false;
    private Exception f5446f;
    private MovieCreator f5447g;
    private boolean f5448h = false;
    private LoadingView f5449i;
    private OnClickListener f5450j;
    private C2086a f5451k;

    /* compiled from: CreatorFilmographyFragment */
    class C22281 implements OnClickListener {
        final /* synthetic */ C2232d f5437a;

        C22281(C2232d c2232d) {
            this.f5437a = c2232d;
        }

        public void onClick(View view) {
            this.f5437a.m8031b(this.f5437a.f5447g);
            this.f5437a.f5449i.setOnTryAgainListener(null);
        }
    }

    /* compiled from: CreatorFilmographyFragment */
    class C22303 implements OnCancelListener {
        final /* synthetic */ C2232d f5440a;

        C22303(C2232d c2232d) {
            this.f5440a = c2232d;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5440a.m6380c().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5442b = m6380c().m6292m();
        this.f5441a = this.f5442b.m6219g().mo3454d();
        this.f5443c = new C1995q(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("creatorId")));
        m6377a(C2146b.CREATOR, hashMap);
        if (this.f5451k != null) {
            setListAdapter(this.f5451k);
        }
        this.f5449i = (LoadingView) view.findViewById(R.id.loading);
        this.f5450j = new C22281(this);
        if (this.f5444d || this.f5445e) {
            this.f5449i.setVisibility(0);
        }
        if (this.f5445e) {
            C1988j.m6341a(getActivity(), this.f5449i, this.f5450j, this.f5446f);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            m8026a(((C2094q) itemAtPosition).m7332i());
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f5448h) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5448h = true;
        m8034c(getArguments().getInt("creatorId"));
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    private void m8034c(int i) {
        this.f5447g = m8036d(i);
        if (this.f5447g == null || this.f5447g.m6881p()) {
            m8037d(this.f5447g);
        } else {
            m8031b(this.f5447g);
        }
    }

    private MovieCreator m8036d(int i) {
        try {
            C2056d k = this.f5442b.m6223k();
            if (k.m7166b(Integer.valueOf(i))) {
                return C1991m.m6346a(i, getActivity());
            }
            BasicEntity movieCreator = new MovieCreator(i);
            k.m7164a(movieCreator);
            return movieCreator;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error);
            return null;
        }
    }

    private void m8031b(final MovieCreator movieCreator) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2232d f5439b;

            public void run() {
                this.f5439b.m8035c(movieCreator);
            }
        }, null, new C22303(this));
    }

    private void m8035c(MovieCreator movieCreator) {
        this.f5441a.mo3518a(movieCreator, (C2231b) this, this.f5442b.m6220h());
    }

    public void onResume() {
        super.onResume();
        this.f5443c.m6362a((C2086a) getListAdapter());
    }

    public void onDestroy() {
        super.onDestroy();
        m8038i();
    }

    private void m8038i() {
        if (this.f5447g != null) {
            this.f5441a.mo3519b(this.f5447g.m6705g());
        }
        m6383f();
    }

    public void mo3417g() {
        this.f5444d = true;
        if (this.f5449i != null) {
            this.f5449i.setVisibility(0);
            this.f5449i.m9451e();
            this.f5449i.m9448b();
        }
    }

    public void m8041a(MovieCreator movieCreator) {
        this.f5444d = false;
        if (movieCreator == null) {
            this.f5445e = true;
            this.f5446f = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5449i, this.f5450j, this.f5446f);
            return;
        }
        this.f5445e = false;
        this.f5447g = movieCreator;
        m8037d(movieCreator);
        m8039j();
    }

    private void m8039j() {
        Animation b;
        if (this.f5449i.getVisibility() == 0) {
            b = m6379b(17432577);
            if (b != null) {
                this.f5449i.startAnimation(b);
            }
            this.f5449i.setVisibility(8);
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
        this.f5444d = false;
    }

    public void mo3323a(Exception exception) {
        this.f5444d = false;
        this.f5445e = true;
        this.f5446f = exception;
        C1988j.m6341a(getActivity(), this.f5449i, this.f5450j, this.f5446f);
    }

    private void m8037d(MovieCreator movieCreator) {
        List arrayList = new ArrayList();
        List n = movieCreator.m6879n();
        for (int i = 0; i < n.size(); i++) {
            Filmography filmography = (Filmography) n.get(i);
            m8028a(filmography.m6797b(), filmography.m6795a(), arrayList);
        }
        this.f5451k = new C2086a(getActivity(), arrayList);
        setListAdapter(this.f5451k);
    }

    private void m8028a(Map<String, List<MovieInfo>> map, int i, List<C2083a> list) {
        if (map.size() > 0) {
            list.add(new C2101i(getString(i), true));
        }
        m8029a(map, list, "main", R.string.movie_list_films);
        m8029a(map, list, "tv_series", R.string.movie_list_tv_series);
        m8029a(map, list, "documents", R.string.movie_list_documents);
        m8029a(map, list, "tv_shows", R.string.movie_list_tv_shows);
        m8029a(map, list, "music_video_clip", R.string.movie_list_music_video_clips);
    }

    private void m8029a(Map<String, List<MovieInfo>> map, List<C2083a> list, String str, int i) {
        if (map.containsKey(str)) {
            List list2 = (List) map.get(str);
            if (i > 0) {
                list.addAll(m8025a(list2, getString(i)));
            } else {
                list.addAll(m8024a(list2));
            }
        }
    }

    private List<C2083a> m8024a(List<MovieInfo> list) {
        List<C2083a> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (BasicEntity basicEntity : list) {
                arrayList.add(new C2094q((MovieInfo) basicEntity, 0));
            }
        }
        return arrayList;
    }

    private List<C2083a> m8025a(List<MovieInfo> list, String str) {
        List<C2083a> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.add(new C2101i(str, false));
            for (BasicEntity basicEntity : list) {
                arrayList.add(new C2094q((MovieInfo) basicEntity, 0));
            }
        }
        return arrayList;
    }

    private void m8026a(MovieInfo movieInfo) {
        this.f5442b.m6219g().mo3453c().mo3575a(movieInfo, getActivity());
    }

    public String mo3436p() {
        return "/creator/filmography";
    }
}
