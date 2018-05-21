package cz.csfd.csfdroid.module.tvtips;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_OrderBy;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.data.entity.TvStation;
import java.util.List;

/* compiled from: TvTipsModule */
public interface C2462c {
    Intent mo3631a(Context context);

    Fragment mo3632a();

    void mo3633a(long j);

    void mo3634a(C1945a<List<TvStation>> c1945a, CsfdDataProvider c2016c);

    void mo3635a(C1945a<List<C2030g>> c1945a, CsfdDataProvider c2016c, long j, int i, Enum_OrderBy c2020d);

    void mo3636a(List<TvStation> list, C1945a<Boolean> c1945a, CsfdDataProvider c2016c);

    boolean mo3637a(Uri uri);

    void mo3638b();

    void mo3639b(Context context);

    void mo3640c();
}
