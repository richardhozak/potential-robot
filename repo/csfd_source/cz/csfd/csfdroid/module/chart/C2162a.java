package cz.csfd.csfdroid.module.chart;

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
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.data.entity.ChartMovie;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.list.p063a.C2095c;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.chart.C2164b.C2161a;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChartFragment */
public class C2162a extends C1999d implements C1973d, C2161a {
    private CsfdApplication f5223a;
    private C2164b f5224b;
    private C2366h f5225c;
    private C1995q f5226d;
    private Chart f5227e;
    private List<C2083a> f5228f;
    private C2086a f5229g;
    private boolean f5230h = false;
    private boolean f5231i = false;
    private Exception f5232j;
    private boolean f5233k = false;
    private LoadingView f5234l;
    private OnClickListener f5235m;
    private C2105m f5236n;

    /* compiled from: ChartFragment */
    class C21581 implements OnClickListener {
        final /* synthetic */ C2162a f5220a;

        C21581(C2162a c2162a) {
            this.f5220a = c2162a;
        }

        public void onClick(View view) {
            this.f5220a.m7715i();
            this.f5220a.f5234l.setOnTryAgainListener(null);
            if (this.f5220a.f5236n != null) {
                this.f5220a.f5236n.m7412a(1);
            }
        }
    }

    /* compiled from: ChartFragment */
    class C21592 implements Runnable {
        final /* synthetic */ C2162a f5221a;

        C21592(C2162a c2162a) {
            this.f5221a = c2162a;
        }

        public void run() {
            this.f5221a.m7716j();
        }
    }

    /* compiled from: ChartFragment */
    class C21603 implements C2061a {
        final /* synthetic */ C2162a f5222a;

        C21603(C2162a c2162a) {
            this.f5222a = c2162a;
        }

        public void mo3416a() {
            if (this.f5222a.f5236n != null && this.f5222a.f5236n.m7417d() != 2) {
                this.f5222a.m7715i();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5223a = m6380c().m6292m();
        this.f5224b = this.f5223a.m6219g().mo3458h();
        this.f5225c = this.f5223a.m6219g().mo3453c();
        this.f5226d = new C1995q(getActivity());
        this.f5227e = new Chart(getArguments().getString("chartId"));
        this.f5227e.m6719a(getArguments().getInt("highlightPosition"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5234l = (LoadingView) view.findViewById(R.id.loading);
        this.f5235m = new C21581(this);
        if (this.f5230h || this.f5231i) {
            this.f5234l.setVisibility(0);
        }
        if (this.f5231i) {
            C1988j.m6341a(getActivity(), this.f5234l, this.f5235m, this.f5232j);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (((C2170d) getParentFragment()).m7752h().m6718a().equals(this.f5227e.m6718a()) && this.f5227e.m6722c().size() == 0 && !this.f5231i && !this.f5230h) {
            m7715i();
        }
    }

    private void m7715i() {
        m6380c().m6277a(m6380c(), new C21592(this));
    }

    private void m7716j() {
        this.f5224b.mo3481a(this.f5227e, this, this.f5223a.m6220h());
    }

    public void mo3417g() {
        this.f5230h = true;
        if (!this.f5233k) {
            this.f5234l.setVisibility(0);
            this.f5234l.m9451e();
            this.f5234l.m9448b();
        }
    }

    public void m7719a(Chart chart) {
        this.f5230h = false;
        if (chart.m6722c().size() == 0) {
            this.f5231i = true;
            this.f5232j = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5234l, this.f5235m, this.f5232j);
            return;
        }
        this.f5231i = false;
        this.f5233k = true;
        this.f5227e = chart;
        if (getActivity() != null) {
            m7711b(this.f5227e);
            m7717k();
        }
    }

    private void m7717k() {
        if (this.f5234l.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5234l.startAnimation(b);
            }
            this.f5234l.setVisibility(8);
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

    private void m7711b(Chart chart) {
        if (this.f5229g == null) {
            this.f5228f = new ArrayList();
            m7709a(chart.m6722c(), this.f5228f);
            this.f5228f.add(5, new C2093b(C2146b.CHARTS, mo3436p()));
            this.f5229g = new C2086a(getActivity(), this.f5228f);
            setListAdapter(this.f5229g);
            if (this.f5227e.m6724e() > 0) {
                setSelection(this.f5227e.m6724e() - 1);
                this.f5227e.m6719a(0);
                return;
            }
            return;
        }
        m7709a(chart.m6722c(), this.f5228f);
        this.f5229g.notifyDataSetChanged();
    }

    private void m7709a(List<ChartMovie> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        size = m7706a((List) list2, size);
        for (int i = size > 0 ? size - 1 : 0; i < size2; i++) {
            list2.add(new C2095c((ChartMovie) list.get(i)));
        }
        m7708a(this.f5228f);
    }

    private int m7706a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f5236n) {
            return i;
        }
        list.remove(i - 1);
        this.f5236n = null;
        return i - 1;
    }

    private void m7708a(List<C2083a> list) {
        if (!this.f5227e.m6723d()) {
            m7712b((List) list);
        }
    }

    private void m7712b(List<C2083a> list) {
        this.f5236n = new C2105m(getString(R.string.chart_fetching_movies), new C21603(this));
        this.f5236n.m7413a(this.f5235m);
        try {
            list.add(this.f5236n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2095c) {
            this.f5225c.mo3575a(((C2095c) itemAtPosition).m7345c().m6727b(), getActivity());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5224b.mo3484c();
    }

    public void mo3322a() {
        this.f5230h = false;
    }

    public void mo3323a(Exception exception) {
        this.f5230h = false;
        this.f5231i = true;
        this.f5232j = exception;
        C1988j.m6341a(getActivity(), this.f5234l, this.f5235m, this.f5232j);
        if (this.f5236n != null) {
            this.f5236n.m7412a(2);
        }
    }

    public void onResume() {
        super.onResume();
        this.f5226d.m6362a((C2086a) getListAdapter());
    }

    public String mo3436p() {
        return "/charts/detail";
    }

    public void mo3477h() {
        m6382e();
        if (!this.f5230h && !this.f5231i && this.f5227e.m6722c().size() == 0) {
            m7715i();
        }
    }
}
