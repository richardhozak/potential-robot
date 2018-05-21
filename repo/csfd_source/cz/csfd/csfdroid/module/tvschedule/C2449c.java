package cz.csfd.csfdroid.module.tvschedule;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.tvtips.C2462c;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleHourPagerFragment */
public class C2449c extends C1974c implements C1945a<List<TvStation>> {
    private C2450d f6118a;
    private C2462c f6119b;
    private CsfdApplication f6120c;
    private C2057e f6121d;
    private List<C2444a> f6122e = new ArrayList();
    private C2446b f6123f;
    private ViewPager f6124g;
    private SlidingTabLayout f6125h;
    private List<Date> f6126i = new ArrayList();
    private Date f6127j;
    private List<TvStation> f6128k = new ArrayList();
    private boolean f6129l;
    private int f6130m;

    /* compiled from: TvScheduleHourPagerFragment */
    interface C2444a {
        void mo3623a(List<TvStation> list);
    }

    /* compiled from: TvScheduleHourPagerFragment */
    class C24482 implements Runnable {
        final /* synthetic */ C2449c f6117a;

        C24482(C2449c c2449c) {
            this.f6117a = c2449c;
        }

        public void run() {
            this.f6117a.f6125h.m9469b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f6120c = m6320d().m6292m();
        this.f6118a = this.f6120c.m6219g().mo3463m();
        this.f6119b = this.f6120c.m6219g().mo3462l();
        this.f6121d = this.f6120c.m6226n();
        m8957k();
        this.f6130m = m8958l();
        m8956a(0, false);
    }

    public void onResume() {
        boolean z = true;
        super.onResume();
        if (this.f6121d.m7217x()) {
            this.f6128k.clear();
            m8956a(0, true);
            this.f6123f.notifyDataSetChanged();
            this.f6121d.m7196c(false);
        } else if (this.f6127j != null) {
            Date date = this.f6127j;
            if (this.f6124g.getCurrentItem() != this.f6130m) {
                z = false;
            }
            m8957k();
            this.f6130m = m8958l();
            if (z) {
                this.f6124g.setCurrentItem(this.f6130m);
            }
            if (m8955a(date).getDate() != m8955a(this.f6127j).getDate()) {
                this.f6128k.clear();
                m8956a(0, false);
            }
            this.f6123f.notifyDataSetChanged();
            this.f6125h.m9468a();
        }
    }

    private void m8957k() {
        int i = 4;
        Calendar instance = Calendar.getInstance();
        this.f6127j = instance.getTime();
        if (instance.get(11) < 4) {
            instance.add(5, -1);
        }
        instance.set(11, 3);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.f6126i.clear();
        while (i <= 27) {
            instance.add(11, 1);
            this.f6126i.add(instance.getTime());
            i++;
        }
    }

    private int m8958l() {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        for (int i = 0; i < this.f6126i.size(); i++) {
            instance2.setTime((Date) this.f6126i.get(i));
            if (instance2.get(11) == instance.get(11) && instance2.get(5) == instance.get(5)) {
                return i;
            }
        }
        return -1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tvschedule, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6124g = (ViewPager) view.findViewById(R.id.pager);
        this.f6124g.setOffscreenPageLimit(2);
        this.f6125h = (SlidingTabLayout) view.findViewById(R.id.tabs);
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.TV, null, mo3436p());
        this.f6125h.setOnPageChangeListener(new SimpleOnPageChangeListener(this) {
            final /* synthetic */ C2449c f6116b;

            public void onPageSelected(int i) {
                adBottomView.m7620a();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m8959m();
    }

    public List<TvStation> m8966h() {
        return this.f6128k;
    }

    public void m8961a(C2444a c2444a) {
        this.f6122e.add(c2444a);
    }

    public void m8965b(C2444a c2444a) {
        this.f6122e.remove(c2444a);
    }

    private void m8959m() {
        this.f6123f = new C2446b(getContext(), getChildFragmentManager());
        this.f6123f.m8953a(this.f6126i);
        this.f6124g.setAdapter(this.f6123f);
        this.f6124g.setCurrentItem(this.f6130m);
        this.f6125h.setViewPager(this.f6124g);
        getView().post(new C24482(this));
    }

    private void m8956a(int i, boolean z) {
        if (i == 0) {
            this.f6129l = false;
        }
        this.f6118a.mo3628a(this, this.f6120c.m6220h(), m8955a(new Date()), null, i, z);
    }

    public void m8967i() {
        m8956a(this.f6128k.size(), false);
    }

    public boolean m8968j() {
        return this.f6129l;
    }

    private Date m8955a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        if (instance.get(11) < 4) {
            instance.add(5, -1);
        }
        return instance.getTime();
    }

    public void m8964a(List<TvStation> list) {
        this.f6128k.addAll(list);
        if (list.size() < 20) {
            this.f6129l = true;
        }
        for (C2444a a : this.f6122e) {
            a.mo3623a(this.f6128k);
        }
    }

    public void mo3323a(Exception exception) {
        exception.printStackTrace();
    }

    public void mo3322a() {
    }

    public void onDestroy() {
        this.f6122e.clear();
        this.f6118a.mo3629b();
        super.onDestroy();
    }

    public String mo3436p() {
        return "/tv-schedule";
    }
}
