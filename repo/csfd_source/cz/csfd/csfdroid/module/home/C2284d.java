package cz.csfd.csfdroid.module.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: HomeModule */
public interface C2284d {

    /* compiled from: HomeModule */
    public interface C2281a extends C1945a<Map<String, List<? extends BasicEntity>>> {
        void mo3537h();
    }

    /* compiled from: HomeModule */
    public enum Enum_ReleaseType {
        CINEMA,
        DVD,
        BLURAY
    }

    Intent mo3538a(Context context);

    Intent mo3539a(Context context, Enum_ReleaseType c2283b);

    Fragment mo3540a();

    Fragment mo3541a(Enum_ReleaseType c2283b);

    void mo3542a(FragmentActivity fragmentActivity);

    void mo3543a(C1945a<List<MovieInfo>> c1945a, CsfdDataProvider c2016c, Enum_ReleaseType c2283b, Date date);

    void mo3544a(List<String> list, C2281a c2281a, CsfdDataProvider c2016c, Context context);

    void mo3545b();
}
