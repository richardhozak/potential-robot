package cz.csfd.csfdroid.module.tvschedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.TvMovie;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.list.p063a.C2114v;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.tvschedule.C2449c.C2444a;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleHourFragment */
public class C2445a extends C1999d implements C2444a {
    private C2366h f6103a;
    private C2450d f6104b;
    private LoadingView f6105c;
    private C2449c f6106d;
    private Date f6107e;
    private boolean f6108f;
    private List<C2083a> f6109g = new ArrayList();
    private C2086a f6110h;
    private List<TvStation> f6111i;
    private C2105m f6112j;

    /* compiled from: TvScheduleHourFragment */
    class C24431 implements C2061a {
        final /* synthetic */ C2445a f6102a;

        C24431(C2445a c2445a) {
            this.f6102a = c2445a;
        }

        public void mo3416a() {
            if (this.f6102a.f6112j != null && this.f6102a.f6112j.m7417d() != 2) {
                ((C2449c) this.f6102a.getParentFragment()).m8967i();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CsfdApplication csfdApplication = (CsfdApplication) getActivity().getApplication();
        this.f6103a = csfdApplication.m6219g().mo3453c();
        this.f6104b = csfdApplication.m6219g().mo3463m();
        this.f6107e = new Date(getArguments().getLong("time"));
        this.f6108f = getArguments().getBoolean("ongoing");
        this.f6106d = (C2449c) getParentFragment();
        this.f6111i = this.f6106d.m8966h();
        this.f6106d.m8961a((C2444a) this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6105c = (LoadingView) view.findViewById(R.id.loading);
        m6377a(C2146b.TV, null);
        this.f6110h = new C2086a(getContext());
        setListAdapter(this.f6110h);
        if (this.f6111i.size() > 0) {
            m8949a();
            this.f6110h.m7314a(this.f6109g);
            this.f6110h.notifyDataSetChanged();
            this.f6105c.setVisibility(8);
            return;
        }
        this.f6105c.setVisibility(0);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2114v) {
            MovieInfo a = ((C2114v) itemAtPosition).m7450c().m7045a();
            if (a.m6705g() > 0) {
                this.f6103a.mo3575a(a, getActivity());
            }
        } else if (itemAtPosition instanceof C2101i) {
            int parseInt = Integer.parseInt(((C2101i) itemAtPosition).m7397c());
            startActivity(this.f6104b.mo3626a(getActivity(), parseInt, m8950c(parseInt), this.f6107e));
        }
    }

    private String m8950c(int i) {
        for (TvStation tvStation : this.f6111i) {
            if (tvStation.m7060a() == i) {
                return tvStation.m7066b();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.f6106d.m8965b(this);
        super.onDestroy();
    }

    public void mo3623a(List<TvStation> list) {
        this.f6111i = list;
        this.f6109g.clear();
        m8949a();
        this.f6110h.m7314a(this.f6109g);
        this.f6110h.notifyDataSetChanged();
        this.f6105c.setVisibility(8);
    }

    private void m8949a() {
        Date date = this.f6107e;
        Date date2 = new Date(this.f6107e.getTime() + 3600000);
        Date date3 = new Date();
        for (TvStation tvStation : this.f6111i) {
            List<TvMovie> a = tvStation.m7061a(date, date2, date3, this.f6108f);
            if (a.size() > 0) {
                C2101i c2101i = new C2101i(tvStation.m7066b());
                c2101i.m7395a(true);
                c2101i.m7394a(String.valueOf(tvStation.m7060a()));
                this.f6109g.add(c2101i);
                for (TvMovie c2114v : a) {
                    this.f6109g.add(new C2114v(c2114v));
                }
            }
        }
        if (!((C2449c) getParentFragment()).m8968j()) {
            this.f6112j = new C2105m(getString(R.string.loading), new C24431(this));
            this.f6109g.add(this.f6112j);
        }
    }

    public String mo3436p() {
        return "/tv-schedule/hour";
    }
}
