package cz.csfd.csfdroid.module.tvtips;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.format.DateUtils;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: TvTipsPagerAdapter */
public class C2464e extends FragmentStatePagerAdapter {
    private Context f6171a;
    private List<Date> f6172b = new ArrayList();
    private HashMap<Integer, WeakReference<Fragment>> f6173c = new HashMap();

    public C2464e(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f6171a = context;
    }

    public void m9038a(List<Date> list) {
        this.f6172b = list;
    }

    public int getCount() {
        return this.f6172b.size();
    }

    public Fragment getItem(int i) {
        Date date = (Date) this.f6172b.get(i);
        Bundle bundle = new Bundle();
        bundle.putLong("date", date.getTime());
        bundle.putInt("position", i);
        Fragment c2461b = new C2461b();
        c2461b.setArguments(bundle);
        return c2461b;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        this.f6173c.put(Integer.valueOf(i), new WeakReference(fragment));
        return fragment;
    }

    public Fragment m9037a(int i) {
        WeakReference weakReference = (WeakReference) this.f6173c.get(Integer.valueOf(i));
        return weakReference != null ? (Fragment) weakReference.get() : null;
    }

    public CharSequence getPageTitle(int i) {
        return DateUtils.formatDateTime(this.f6171a, ((Date) this.f6172b.get(i)).getTime(), 18);
    }

    public void notifyDataSetChanged() {
        this.f6173c.clear();
        super.notifyDataSetChanged();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
