package cz.csfd.csfdroid.module.watchlist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.WatchlistMovie;
import java.util.List;

/* compiled from: WatchlistModuleImpl */
public class C2495c implements C2494b {
    C2011b f6262a;
    C2011b f6263b;
    C2011b f6264c;

    public void mo3663a(Context context) {
        context.startActivity(new Intent(context, WatchlistActivity.class));
    }

    public Fragment mo3661a() {
        return new C2493a();
    }

    public void mo3664a(C1945a<List<WatchlistMovie>> c1945a, C2016c c2016c, int i) {
        mo3665b();
        this.f6262a = c2016c.mo3390b((C1945a) c1945a, i);
    }

    public void mo3665b() {
        if (this.f6262a != null) {
            this.f6262a.mo3355a();
            this.f6262a = null;
        }
    }

    public void mo3662a(int i, C1945a<Object> c1945a, C2016c c2016c) {
        this.f6263b = c2016c.mo3399c(i, (C1945a) c1945a);
    }

    public void mo3667c() {
        if (this.f6263b != null) {
            this.f6263b.mo3355a();
            this.f6263b = null;
        }
    }

    public void mo3666b(int i, C1945a<Object> c1945a, C2016c c2016c) {
        this.f6264c = c2016c.mo3403d(i, (C1945a) c1945a);
    }

    public void mo3668d() {
        if (this.f6264c != null) {
            this.f6264c.mo3355a();
            this.f6264c = null;
        }
    }
}
