package cz.csfd.csfdroid.module.tvtips;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.C2016c.C2020d;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;
import cz.csfd.csfdroid.module.home.MainActivity;
import java.util.List;

/* compiled from: TvTipsModuleImpl */
public class C2463d implements C2462c {
    private C2011b f6167a;
    private C2011b f6168b;
    private C2011b f6169c;
    private long f6170d;

    public Intent mo3631a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("row", C2254b.TV_TIPS.m8157a());
        return intent;
    }

    public Fragment mo3632a() {
        return new C2468f();
    }

    public boolean mo3637a(Uri uri) {
        return uri.getPath().startsWith("/televize");
    }

    public void mo3635a(C1945a<List<C2030g>> c1945a, C2016c c2016c, long j, int i, C2020d c2020d) {
        this.f6167a = c2016c.mo3367a((C1945a) c1945a, j, i, c2020d);
        this.f6170d = j;
    }

    public void mo3633a(long j) {
        if (this.f6167a != null && this.f6170d == j) {
            this.f6167a.mo3355a();
            this.f6167a = null;
        }
    }

    public void mo3639b(Context context) {
        context.startActivity(new Intent(context, TvStationsActivity.class));
    }

    public void mo3634a(C1945a<List<TvStation>> c1945a, C2016c c2016c) {
        mo3638b();
        this.f6167a = c2016c.mo3400c(c1945a);
    }

    public void mo3638b() {
        if (this.f6168b != null) {
            this.f6168b.mo3355a();
            this.f6168b = null;
        }
    }

    public void mo3636a(List<TvStation> list, C1945a<Boolean> c1945a, C2016c c2016c) {
        this.f6169c = c2016c.mo3385a((List) list, (C1945a) c1945a);
    }

    public void mo3640c() {
        if (this.f6169c != null) {
            this.f6169c.mo3355a();
            this.f6169c = null;
        }
    }
}
