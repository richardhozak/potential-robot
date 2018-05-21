package cz.csfd.csfdroid.module.ads;

import android.util.Log;
import java.util.List;
import java.util.Random;

/* compiled from: VideoAds */
public class C2154d {
    private List<C2153c> f5194a;
    private int f5195b;

    public C2154d(List<C2153c> list, int i) {
        this.f5194a = list;
        this.f5195b = i;
        Log.d("VideoAds", "intensity: " + this.f5195b);
    }

    public int m7657a() {
        if (this.f5194a != null) {
            return this.f5194a.size();
        }
        return 0;
    }

    public C2153c m7658b() {
        float f = 0.0f;
        float f2 = 0.0f;
        for (C2153c e : this.f5194a) {
            f2 = e.m7656e() + f2;
        }
        f2 *= new Random().nextFloat();
        for (C2153c e2 : this.f5194a) {
            f += e2.m7656e();
            if (f2 < f) {
                return e2;
            }
        }
        return null;
    }

    public int m7659c() {
        return this.f5195b;
    }
}
