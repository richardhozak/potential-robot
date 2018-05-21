package cz.csfd.csfdroid.module.tvschedule;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.TvStation;
import java.util.Date;
import java.util.List;

/* compiled from: TvScheduleModule */
public interface C2450d {
    Intent mo3625a(Context context);

    Intent mo3626a(Context context, int i, String str, Date date);

    Fragment mo3627a();

    void mo3628a(C1945a<List<TvStation>> c1945a, CsfdDataProvider c2016c, Date date, List<Integer> list, int i, boolean z);

    void mo3629b();
}
