package cz.csfd.csfdroid.module.tvschedule;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleStationPagerFragment */
public class C2455g extends C1974c {
    private C1970b f6142a;
    private ViewPager f6143b;
    private SlidingTabLayout f6144c;
    private int f6145d;
    private String f6146e;
    private Date f6147f;
    private List<Date> f6148g = new ArrayList();

    /* compiled from: TvScheduleStationPagerFragment */
    class C24542 implements Runnable {
        final /* synthetic */ C2455g f6141a;

        C24542(C2455g c2455g) {
            this.f6141a = c2455g;
        }

        public void run() {
            this.f6141a.f6144c.m9469b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6145d = getArguments().getInt("station_id");
        this.f6146e = getArguments().getString("station_name");
        this.f6147f = (Date) getArguments().getSerializable("date");
        m8986a();
    }

    private void m8986a() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        this.f6148g.clear();
        for (int i = -2; i <= 7; i++) {
            instance.add(5, 1);
            this.f6148g.add(instance.getTime());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tvschedule, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6143b = (ViewPager) view.findViewById(R.id.pager);
        this.f6143b.setOffscreenPageLimit(2);
        this.f6144c = (SlidingTabLayout) view.findViewById(R.id.tabs);
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.TV, null, mo3436p());
        this.f6144c.setOnPageChangeListener(new SimpleOnPageChangeListener(this) {
            final /* synthetic */ C2455g f6140b;

            public void onPageSelected(int i) {
                adBottomView.m7620a();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m8988h();
    }

    private void m8988h() {
        this.f6142a = new C1970b(getChildFragmentManager(), getActivity(), this.f6143b, this.f6144c);
        m8987a(this.f6142a);
        this.f6143b.setAdapter(this.f6142a);
        this.f6143b.setCurrentItem(m8989i());
        this.f6144c.setViewPager(this.f6143b);
        getView().post(new C24542(this));
    }

    private int m8989i() {
        for (int i = 0; i < this.f6148g.size(); i++) {
            if (((Date) this.f6148g.get(i)).getDate() == this.f6147f.getDate()) {
                return i;
            }
        }
        return 2;
    }

    private void m8987a(C1970b c1970b) {
        c1970b.m6304a();
        Calendar instance = Calendar.getInstance();
        for (int i = 0; i < this.f6148g.size(); i++) {
            String string;
            Date date = (Date) this.f6148g.get(i);
            Bundle bundle = new Bundle();
            bundle.putLong("date", date.getTime());
            bundle.putInt("station", this.f6145d);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date);
            if (instance2.get(5) == instance.get(5)) {
                string = getString(R.string.today);
            } else {
                string = DateUtils.formatDateTime(getContext(), date.getTime(), 16);
            }
            c1970b.m6306b(new C1972c(string, C2452f.class, bundle, this));
        }
    }

    public String mo3436p() {
        return "/tv-schedule/station";
    }
}
