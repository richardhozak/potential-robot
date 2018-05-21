package cz.csfd.csfdroid.module.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.module.home.C2284d.C2281a;
import cz.csfd.csfdroid.module.home.C2284d.Enum_ReleaseType;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: HomeModuleImpl */
public class C2285e implements C2284d {
    C2011b f5606a;

    public Intent mo3538a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(67108864);
        return intent;
    }

    public Intent mo3539a(Context context, Enum_ReleaseType c2283b) {
        Intent intent = new Intent(context, ReleasesActivity.class);
        intent.putExtra("release_type", c2283b);
        return intent;
    }

    public Fragment mo3541a(Enum_ReleaseType c2283b) {
        Fragment c2286f = new C2286f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("release_type", c2283b);
        c2286f.setArguments(bundle);
        return c2286f;
    }

    public Fragment mo3540a() {
        return new C2282c();
    }

    public void mo3544a(List<String> list, C2281a c2281a, CsfdDataProvider c2016c, Context context) {
        c2281a.mo3537h();
        if (list.size() == 0) {
            c2281a.mo3324a((Object) Collections.emptyMap());
        } else {
            c2016c.mo3386a((List) list, (C1945a) c2281a, context);
        }
    }

    public void mo3543a(C1945a<List<MovieInfo>> c1945a, CsfdDataProvider c2016c, Enum_ReleaseType c2283b, Date date) {
        mo3545b();
        this.f5606a = c2016c.mo3382a(c2283b, date, (C1945a) c1945a);
    }

    public void mo3545b() {
        if (this.f5606a != null) {
            this.f5606a.mo3355a();
            this.f5606a = null;
        }
    }

    public void mo3542a(FragmentActivity fragmentActivity) {
        C2260a.m8185a(fragmentActivity.getSupportFragmentManager());
    }
}
