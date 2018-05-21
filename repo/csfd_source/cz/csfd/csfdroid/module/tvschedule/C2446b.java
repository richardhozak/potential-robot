package cz.csfd.csfdroid.module.tvschedule;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.format.DateUtils;
import cz.csfd.csfdroid.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleHourPagerAdapter */
public class C2446b extends FragmentStatePagerAdapter {
    private Context f6113a;
    private List<Date> f6114b = new ArrayList();

    public C2446b(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f6113a = context;
    }

    public void m8953a(List<Date> list) {
        this.f6114b = list;
    }

    public Fragment getItem(int i) {
        Fragment c2445a = new C2445a();
        Bundle bundle = new Bundle();
        Calendar instance = Calendar.getInstance();
        Date date = (Date) this.f6114b.get(i);
        bundle.putLong("time", date.getTime());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance2.get(11) == instance.get(11) && instance2.get(5) == instance.get(5)) {
            bundle.putBoolean("ongoing", true);
        }
        c2445a.setArguments(bundle);
        return c2445a;
    }

    public int getCount() {
        return this.f6114b.size();
    }

    public CharSequence getPageTitle(int i) {
        Date date = (Date) this.f6114b.get(i);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance2.get(11) == instance.get(11) && instance2.get(5) == instance.get(5)) {
            return this.f6113a.getString(R.string.now);
        }
        return DateUtils.formatDateTime(this.f6113a, date.getTime(), 1);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
