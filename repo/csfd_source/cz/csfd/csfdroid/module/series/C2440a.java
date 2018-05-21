package cz.csfd.csfdroid.module.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Episode;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieInfo.Category;
import cz.csfd.csfdroid.data.entity.Season;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2103k;
import cz.csfd.csfdroid.list.p063a.C2112t;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SeasonFragment */
public class C2440a extends C1974c {
    private LoadingView f6079a;
    private ListView f6080b;
    private C2366h f6081c;
    private C2086a f6082d;
    private List<C2083a> f6083e = new ArrayList();
    private Season f6084f;
    private boolean f6085g;
    private int f6086h;

    /* compiled from: SeasonFragment */
    class C24391 implements OnItemClickListener {
        final /* synthetic */ C2440a f6078a;

        C24391(C2440a c2440a) {
            this.f6078a = c2440a;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C2083a c2083a = (C2083a) this.f6078a.f6083e.get(i);
            if (c2083a instanceof C2112t) {
                Season c = ((C2112t) c2083a).m7437c();
                this.f6078a.m8930a(c.m7021a(), c.m7026b(), c.m7030c());
            } else if (c2083a instanceof C2103k) {
                Episode c2 = ((C2103k) c2083a).m7403c();
                this.f6078a.m8930a(c2.m6785a(), c2.m6788b(), c2.m6791c());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6084f = (Season) getArguments().getSerializable("season");
        this.f6085g = getArguments().getBoolean("has_no_seasons");
        this.f6086h = getArguments().getInt("episode_id");
        this.f6081c = ((CsfdApplication) getContext().getApplicationContext()).m6219g().mo3453c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6079a = (LoadingView) view.findViewById(R.id.loading);
        this.f6080b = (ListView) view.findViewById(16908298);
        this.f6082d = new C2086a(getContext());
        this.f6083e = m8928a(this.f6084f);
        this.f6082d.m7314a(this.f6083e);
        this.f6080b.setAdapter(this.f6082d);
        this.f6080b.setVisibility(0);
        this.f6080b.setOnItemClickListener(new C24391(this));
        m8932c(this.f6086h);
    }

    private void m8932c(int i) {
        for (int i2 = 0; i2 < this.f6083e.size(); i2++) {
            C2083a c2083a = (C2083a) this.f6083e.get(i2);
            if ((c2083a instanceof C2103k) && ((C2103k) c2083a).m7403c().m6785a() == i) {
                this.f6080b.setChoiceMode(1);
                this.f6080b.setSelection(i2);
                this.f6080b.setItemChecked(i2, true);
                return;
            }
        }
    }

    private List<C2083a> m8928a(Season season) {
        List<C2083a> arrayList = new ArrayList();
        if (!this.f6085g) {
            arrayList.add(new C2112t(season));
        }
        arrayList.add(new C2101i(getString(R.string.episodes)));
        for (Episode c2103k : season.m7035g()) {
            arrayList.add(new C2103k(c2103k));
        }
        return arrayList;
    }

    private void m8930a(int i, String str, int i2) {
        MovieInfo movieInfo = new MovieInfo(i);
        movieInfo.m6922a(str);
        movieInfo.m6919a(Category.m6889a(i2));
        this.f6081c.mo3575a(movieInfo, getContext());
    }

    public String mo3436p() {
        return "seasons/season";
    }
}
