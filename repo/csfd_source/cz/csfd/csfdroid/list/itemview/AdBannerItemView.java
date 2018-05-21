package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.itemview.C2088a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.module.ads.AdBannerView;

public class AdBannerItemView extends RelativeLayout implements C2088a, C2087b {
    private AdBannerView f4971a;

    public AdBannerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f4971a = (AdBannerView) findViewById(R.id.ad_banner);
    }

    public void setObject(C2083a c2083a) {
        C2093b c2093b = (C2093b) c2083a;
        this.f4971a.m7592a(c2093b.m7327c(), c2093b.m7329e(), c2093b.m7328d());
    }

    public void mo3430a() {
        this.f4971a.m7596e();
    }

    public void m7481c() {
        this.f4971a.m7595d();
    }

    public void m7482d() {
        this.f4971a.m7594c();
    }

    public void m7483e() {
        this.f4971a.m7596e();
    }
}
