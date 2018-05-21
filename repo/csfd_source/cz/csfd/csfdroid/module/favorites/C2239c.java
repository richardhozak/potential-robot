package cz.csfd.csfdroid.module.favorites;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import java.util.List;

/* compiled from: FavoritesModuleImpl */
public class C2239c implements C2238b {
    C2011b f5480a;

    public void mo3523a(Context context) {
        context.startActivity(new Intent(context, FavoritesActivity.class));
    }

    public Fragment mo3522a() {
        return new C2237a();
    }

    public void mo3524a(C1945a<List<ActivityEntity>> c1945a, C2016c c2016c, int i) {
        mo3525b();
        this.f5480a = c2016c.mo3362a((C1945a) c1945a, i);
    }

    public void mo3525b() {
        if (this.f5480a != null) {
            this.f5480a.mo3355a();
            this.f5480a = null;
        }
    }
}
