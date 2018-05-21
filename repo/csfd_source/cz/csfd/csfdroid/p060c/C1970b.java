package cz.csfd.csfdroid.p060c;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import cz.csfd.csfdroid.p060c.C1972c.C1971a;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SimpleTabsAdapter */
public class C1970b extends FragmentPagerAdapter implements OnPageChangeListener {
    private List<C1972c> f4458a;
    private Context f4459b;
    private FragmentManager f4460c;
    private ViewPager f4461d;
    private SlidingTabLayout f4462e;
    private C1969a f4463f;

    /* compiled from: SimpleTabsAdapter */
    public interface C1969a {
        void mo3507a(int i);
    }

    public C1970b(FragmentActivity fragmentActivity, ViewPager viewPager, SlidingTabLayout slidingTabLayout) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity, viewPager, slidingTabLayout);
    }

    public C1970b(FragmentManager fragmentManager, FragmentActivity fragmentActivity, ViewPager viewPager, SlidingTabLayout slidingTabLayout) {
        super(fragmentManager);
        this.f4458a = new ArrayList();
        this.f4459b = fragmentActivity.getApplicationContext();
        this.f4460c = fragmentManager;
        this.f4461d = viewPager;
        this.f4462e = slidingTabLayout;
        this.f4462e.setOnPageChangeListener(this);
    }

    public Fragment getItem(int i) {
        C1971a a = ((C1972c) this.f4458a.get(i)).m6310a();
        Fragment instantiate = Fragment.instantiate(this.f4459b, a.m6307a().getName());
        if (a.m6309c() != null) {
            this.f4460c.putFragment(a.m6308b(), "_parent", a.m6309c());
            instantiate.setTargetFragment(a.m6309c(), 0);
        }
        instantiate.setArguments(a.m6308b());
        return instantiate;
    }

    public CharSequence getPageTitle(int i) {
        return ((C1972c) this.f4458a.get(i)).m6312b();
    }

    public int getCount() {
        return this.f4458a.size();
    }

    public void m6304a() {
        this.f4458a.clear();
    }

    public int m6303a(C1972c c1972c) {
        return this.f4458a.indexOf(c1972c);
    }

    public void m6306b(C1972c c1972c) {
        this.f4458a.add(c1972c);
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
        Fragment findFragmentByTag = this.f4460c.findFragmentByTag(C1970b.m6302a(this.f4461d.getId(), i));
        if (findFragmentByTag != null && (findFragmentByTag instanceof C1973d)) {
            ((C1973d) findFragmentByTag).mo3477h();
        }
        if (this.f4463f != null) {
            this.f4463f.mo3507a(i);
        }
    }

    public static String m6302a(int i, int i2) {
        return "android:switcher:" + i + ":" + i2;
    }

    public void m6305a(C1969a c1969a) {
        this.f4463f = c1969a;
    }
}
