package cz.csfd.csfdroid.module.series;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import cz.csfd.csfdroid.data.entity.Season;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SeasonsPagerAdapter */
public class C2441b extends FragmentStatePagerAdapter {
    private List<Season> f6087a = new ArrayList();
    private boolean f6088b;
    private int f6089c;

    public C2441b(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void m8935a(List<Season> list) {
        this.f6087a = list;
    }

    public void m8936a(boolean z) {
        this.f6088b = z;
    }

    public void m8934a(int i) {
        this.f6089c = i;
    }

    public Fragment getItem(int i) {
        Fragment c2440a = new C2440a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("season", (Serializable) this.f6087a.get(i));
        bundle.putSerializable("has_no_seasons", Boolean.valueOf(this.f6088b));
        bundle.putInt("episode_id", this.f6089c);
        c2440a.setArguments(bundle);
        return c2440a;
    }

    public int getCount() {
        return this.f6087a.size();
    }

    public CharSequence getPageTitle(int i) {
        CharSequence b = ((Season) this.f6087a.get(i)).m7026b();
        String[] split = b.split(" - ");
        if (split.length >= 2) {
            return split[1];
        }
        return b;
    }
}
