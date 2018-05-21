package cz.csfd.csfdroid.module.p066a;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.C2031h;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;
import cz.csfd.csfdroid.module.home.MainActivity;
import java.util.List;

/* compiled from: VideosModuleImpl */
public class C2137c implements C2136b {
    private C2011b f5137a;
    private C2011b f5138b;
    private int f5139c;

    public Intent mo3437a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("row", C2254b.VIDEOS.m8157a());
        return intent;
    }

    public Fragment mo3438a() {
        return new C2135a();
    }

    public void mo3441a(C1945a<List<C2031h>> c1945a, C2016c c2016c) {
        mo3442b();
        c2016c.mo3407e(c1945a);
    }

    public void mo3442b() {
        if (this.f5137a != null) {
            this.f5137a.mo3355a();
            this.f5137a = null;
        }
    }

    public void mo3440a(int i, int i2, C1945a<List<MovieVideo>> c1945a, C2016c c2016c, Context context) {
        mo3439a(this.f5139c);
        this.f5138b = c2016c.mo3387b(i2, 10, i, (C1945a) c1945a, context);
        this.f5139c = i;
    }

    public void mo3439a(int i) {
        if (this.f5138b != null && this.f5139c == i) {
            this.f5138b.mo3355a();
        }
    }
}
