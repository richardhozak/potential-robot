package cz.csfd.csfdroid.module.chart;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.chart.C2164b.C2163b;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.Arrays;
import java.util.List;

/* compiled from: ChartsFragment */
public class C2170d extends C1974c implements C2163b {
    private CsfdApplication f5244a;
    private C2057e f5245b;
    private C2164b f5246c;
    private boolean f5247d = false;
    private boolean f5248e = false;
    private Exception f5249f;
    private LoadingView f5250g;
    private OnClickListener f5251h;
    private C2105m f5252i;
    private ViewPager f5253j;
    private SlidingTabLayout f5254k;
    private List<Chart> f5255l;
    private C1970b f5256m;

    /* compiled from: ChartsFragment */
    class C21661 implements OnClickListener {
        final /* synthetic */ C2170d f5239a;

        C21661(C2170d c2170d) {
            this.f5239a = c2170d;
        }

        public void onClick(View view) {
            this.f5239a.m7746i();
            this.f5239a.f5250g.setOnTryAgainListener(null);
            if (this.f5239a.f5252i != null) {
                this.f5239a.f5252i.m7412a(1);
            }
        }
    }

    /* compiled from: ChartsFragment */
    class C21683 implements Runnable {
        final /* synthetic */ C2170d f5242a;

        C21683(C2170d c2170d) {
            this.f5242a = c2170d;
        }

        public void run() {
            this.f5242a.f5254k.m9469b();
        }
    }

    /* compiled from: ChartsFragment */
    class C21694 implements Runnable {
        final /* synthetic */ C2170d f5243a;

        C21694(C2170d c2170d) {
            this.f5243a = c2170d;
        }

        public void run() {
            this.f5243a.m7747j();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        this.f5244a = m6320d().m6292m();
        this.f5245b = this.f5244a.m6226n();
        this.f5246c = this.f5244a.m6219g().mo3458h();
    }

    public void onResume() {
        super.onResume();
        List u = this.f5245b.m7215u();
        if (this.f5255l != null && !Arrays.equals(this.f5255l.toArray(), u.toArray())) {
            this.f5255l = u;
            this.f5256m.m6304a();
            m7740a(u, this.f5256m);
            this.f5256m.notifyDataSetChanged();
            this.f5254k.m9468a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_charts, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5250g = (LoadingView) view.findViewById(R.id.loading);
        this.f5251h = new C21661(this);
        if (this.f5247d || this.f5248e) {
            this.f5250g.setVisibility(0);
        }
        if (this.f5248e) {
            C1988j.m6341a(getActivity(), this.f5250g, this.f5251h, this.f5249f);
        }
        this.f5253j = (ViewPager) view.findViewById(R.id.charts_pager);
        this.f5253j.setOffscreenPageLimit(2);
        this.f5254k = (SlidingTabLayout) view.findViewById(R.id.tabs);
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.CHARTS, null, mo3436p());
        this.f5254k.setOnPageChangeListener(new OnPageChangeListener(this) {
            final /* synthetic */ C2170d f5241b;

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                adBottomView.m7620a();
            }

            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f5247d && !this.f5248e) {
            this.f5255l = this.f5245b.m7215u();
            if (this.f5255l.size() > 0) {
                m7742b(this.f5255l);
            } else {
                m7746i();
            }
        }
    }

    public Chart m7752h() {
        return (Chart) this.f5255l.get(this.f5253j.getCurrentItem());
    }

    private void m7740a(List<Chart> list, C1970b c1970b) {
        for (int i = 0; i < list.size(); i++) {
            Chart chart = (Chart) list.get(i);
            Bundle bundle = new Bundle();
            bundle.putString("chartId", chart.m6718a());
            bundle.putInt("highlightPosition", chart.m6724e());
            bundle.putInt("position", i);
            c1970b.m6306b(new C1972c(chart.m6721b(), C2162a.class, bundle, this));
        }
    }

    private void m7742b(List<Chart> list) {
        int i = 0;
        this.f5256m = new C1970b(getChildFragmentManager(), getActivity(), this.f5253j, this.f5254k);
        m7740a(list, this.f5256m);
        if (getArguments() != null) {
            String string = getArguments().getString("chart");
            int i2 = getArguments().getInt("position");
            for (int i3 = 0; i3 < list.size(); i3++) {
                Chart chart = (Chart) list.get(i3);
                if (chart.m6718a().equals(string)) {
                    chart.m6719a(i2);
                    i = i3;
                    break;
                }
            }
        }
        this.f5253j.setAdapter(this.f5256m);
        this.f5253j.setCurrentItem(i);
        this.f5254k.setViewPager(this.f5253j);
        getView().post(new C21683(this));
        this.f5250g.setVisibility(8);
    }

    private void m7746i() {
        m6320d().m6277a(m6320d(), new C21694(this));
    }

    private void m7747j() {
        this.f5246c.mo3482a(this, this.f5244a.m6220h());
    }

    public void f_() {
        this.f5247d = true;
        this.f5250g.setVisibility(0);
        this.f5250g.m9451e();
        this.f5250g.m9448b();
    }

    public void m7751a(List<Chart> list) {
        this.f5247d = false;
        if (list.size() == 0) {
            this.f5248e = true;
            this.f5249f = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5250g, this.f5251h, this.f5249f);
            return;
        }
        this.f5248e = false;
        this.f5245b.m7192b((List) list);
        m7742b((List) list);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5246c.mo3483b();
    }

    public void mo3322a() {
        this.f5247d = false;
    }

    public void mo3323a(Exception exception) {
        this.f5247d = false;
        this.f5248e = true;
        this.f5249f = exception;
        C1988j.m6341a(getActivity(), this.f5250g, this.f5251h, this.f5249f);
        if (this.f5252i != null) {
            this.f5252i.m7412a(2);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public String mo3436p() {
        return "/charts";
    }
}
