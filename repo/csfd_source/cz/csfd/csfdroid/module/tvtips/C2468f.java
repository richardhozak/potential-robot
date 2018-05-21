package cz.csfd.csfdroid.module.tvtips;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_OrderBy;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: TvTipsPagerFragment */
public class C2468f extends C1974c {
    private C2462c f6178a;
    private CsfdApplication f6179b;
    private C2057e f6180c;
    private C2464e f6181d;
    private ViewPager f6182e;
    private SlidingTabLayout f6183f;
    private List<Date> f6184g = new ArrayList();

    /* compiled from: TvTipsPagerFragment */
    class C24662 implements Runnable {
        final /* synthetic */ C2468f f6176a;

        C24662(C2468f c2468f) {
            this.f6176a = c2468f;
        }

        public void run() {
            this.f6176a.f6183f.m9469b();
            C1973d c1973d = (C1973d) this.f6176a.f6181d.m9037a(this.f6176a.f6182e.getCurrentItem());
            if (c1973d != null) {
                c1973d.mo3477h();
            }
        }
    }

    /* compiled from: TvTipsPagerFragment */
    class C24673 implements C1947a {
        final /* synthetic */ C2468f f6177a;

        C24673(C2468f c2468f) {
            this.f6177a = c2468f;
        }

        public void mo3328a() {
            this.f6177a.startActivity(this.f6177a.f6178a.mo3631a(this.f6177a.getActivity()));
            this.f6177a.m6321e();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f6179b = m6320d().m6292m();
        this.f6178a = this.f6179b.m6219g().mo3462l();
        this.f6180c = m6320d().m6292m().m6226n();
        for (int i = 0; i < 13; i++) {
            Calendar instance = Calendar.getInstance();
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(10, 0);
            instance.add(5, i);
            this.f6184g.add(instance.getTime());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tvtips, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6182e = (ViewPager) view.findViewById(R.id.pager);
        this.f6182e.setOffscreenPageLimit(2);
        this.f6183f = (SlidingTabLayout) view.findViewById(R.id.tabs);
        m9041a();
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.TV, null, mo3436p());
        this.f6183f.setOnPageChangeListener(new SimpleOnPageChangeListener(this) {
            final /* synthetic */ C2468f f6175b;

            public void onPageSelected(int i) {
                adBottomView.m7620a();
                Fragment a = this.f6175b.f6181d.m9037a(i);
                if (a != null && (a instanceof C1973d)) {
                    ((C1973d) a).mo3477h();
                }
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void m9041a() {
        this.f6181d = new C2464e(getContext(), getChildFragmentManager());
        this.f6181d.m9038a(this.f6184g);
        this.f6182e.setAdapter(this.f6181d);
        this.f6183f.setViewPager(this.f6182e);
        getView().post(new C24662(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Enum_OrderBy w = this.f6180c.m7216w();
        switch (menuItem.getItemId()) {
            case R.id.menu_item_sort_rating:
                if (w == Enum_OrderBy.RATING) {
                    return true;
                }
                this.f6180c.m7181a(Enum_OrderBy.RATING);
                this.f6181d.notifyDataSetChanged();
                menuItem.setChecked(true);
                return true;
            case R.id.menu_item_sort_time:
                if (w == Enum_OrderBy.TIME) {
                    return true;
                }
                this.f6180c.m7181a(Enum_OrderBy.TIME);
                this.f6181d.notifyDataSetChanged();
                menuItem.setChecked(true);
                return true;
            case R.id.menu_item_stations:
                m9047h();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m9047h() {
        C1950a q = m6320d().m6292m().m6229q();
        if (q.m6250a()) {
            this.f6178a.mo3639b(getActivity());
        } else {
            m9042a(q);
        }
    }

    private void m9042a(C1950a c1950a) {
        m6320d().m6292m().m6219g().mo3459i().mo3652a(getActivity(), c1950a, (int) R.string.login_alert_dialog_text_stations, new C24673(this));
    }

    public void onResume() {
        super.onResume();
        if (this.f6180c.m7217x()) {
            this.f6181d.notifyDataSetChanged();
            this.f6180c.m7196c(false);
        }
    }

    public String mo3436p() {
        return "/tv-tips";
    }
}
