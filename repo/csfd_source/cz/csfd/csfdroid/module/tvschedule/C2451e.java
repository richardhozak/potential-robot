package cz.csfd.csfdroid.module.tvschedule;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;
import cz.csfd.csfdroid.module.home.MainActivity;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleModuleImpl */
public class C2451e implements C2450d {
    private C2011b f6131a;

    public Intent mo3625a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("row", C2254b.TV_SCHEDULE.m8157a());
        return intent;
    }

    public Fragment mo3627a() {
        return new C2449c();
    }

    public Intent mo3626a(Context context, int i, String str, Date date) {
        Intent intent = new Intent(context, TvScheduleStationActivity.class);
        intent.putExtra("station_id", i);
        intent.putExtra("station_name", str);
        intent.putExtra("date", date);
        return intent;
    }

    public void mo3628a(C1945a<List<TvStation>> c1945a, C2016c c2016c, Date date, List<Integer> list, int i, boolean z) {
        this.f6131a = c2016c.mo3369a((C1945a) c1945a, date, (List) list, i, z);
    }

    public void mo3629b() {
        if (this.f6131a != null) {
            this.f6131a.mo3355a();
            this.f6131a = null;
        }
    }
}
