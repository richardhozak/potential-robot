package cz.csfd.csfdroid.module.ads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.common.GoogleApiAvailability;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.module.ads.C2147a.C2139a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.HashMap;

public class AdBannerView extends FrameLayout {
    CsfdApplication f5142a;
    C2147a f5143b;
    C2024a f5144c;
    String f5145d;
    String f5146e;
    AdView f5147f;
    boolean f5148g;

    class C21401 implements C2139a {
        final /* synthetic */ AdBannerView f5140a;

        C21401(AdBannerView adBannerView) {
            this.f5140a = adBannerView;
        }

        public void mo3443b() {
        }

        public void mo3444c() {
            this.f5140a.m7591a();
        }

        public void m7580a(C2024a c2024a) {
            this.f5140a.f5144c = c2024a;
            this.f5140a.m7591a();
        }

        public void mo3323a(Exception exception) {
        }

        public void mo3322a() {
        }
    }

    class C21412 implements OnClickListener {
        final /* synthetic */ AdBannerView f5141a;

        C21412(AdBannerView adBannerView) {
            this.f5141a = adBannerView;
        }

        public void onClick(View view) {
            this.f5141a.m7593b();
        }
    }

    public AdBannerView(Context context) {
        super(context);
        m7586f();
    }

    public AdBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7586f();
    }

    private void m7586f() {
        this.f5142a = C1998s.m6365a(getContext());
        this.f5143b = this.f5142a.m6219g().mo3464n();
        setBackgroundResource(R.color.ad_background);
    }

    public void setTrackingName(String str) {
        this.f5145d = str;
    }

    public void setAdBanner(C2024a c2024a) {
        this.f5144c = c2024a;
    }

    public void m7592a(C2146b c2146b, HashMap<String, String> hashMap, String str) {
        if (!this.f5148g) {
            this.f5145d = str;
            this.f5143b.mo3446a(c2146b, hashMap, new C21401(this), this.f5142a.m6220h(), getContext());
        }
    }

    public void m7591a() {
        this.f5148g = true;
        removeAllViews();
        if (this.f5144c == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f5144c.m7087b())) {
            m7587g();
        } else if (this.f5144c.m7096j() != null) {
            m7589i();
        }
    }

    private void m7587g() {
        int i = getResources().getConfiguration().orientation;
        Object a = this.f5144c.m7084a(i);
        if (TextUtils.isEmpty(a)) {
            m7589i();
            return;
        }
        Uri parse = Uri.parse(a);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        double h = 2 == i ? this.f5144c.m7094h() : this.f5144c.m7095i();
        if (h > 0.5d) {
            i2 = Math.min(i2, getResources().getDimensionPixelSize(R.dimen.medium_rectangle_width));
        }
        i = (int) (h * ((double) i2));
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        C1187t.m5432a(getContext()).m5438a(parse).m5481b(i2, i).m5483d().m5477a(imageView);
        setForeground(getResources().getDrawable(R.drawable.xml_bg_trailer_selector));
        setOnClickListener(new C21412(this));
        m7588h();
    }

    protected void m7593b() {
        if (this.f5144c != null && !TextUtils.isEmpty(this.f5144c.m7090d())) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5144c.m7090d()));
            getContext().startActivity(intent);
            m7585a("ad_banner_clicked", this.f5145d, this.f5144c.m7083a(), 0);
        }
    }

    private void m7588h() {
        if (!TextUtils.isEmpty(this.f5144c.m7084a(getResources().getConfiguration().orientation))) {
            if (this.f5145d == null) {
                Log.w("AdBannerView", "Ad tracking name not provided");
                return;
            }
            m7585a("ad_banner_shown", this.f5145d, this.f5144c.m7083a(), 0);
            C1998s.m6372a(getClass(), "Ad Banner shown tracked");
        }
    }

    private void m7585a(String str, String str2, String str3, int i) {
        String str4;
        String replaceAll = str.replaceAll("/", "_");
        if (replaceAll.length() <= 1 || replaceAll.charAt(0) != '_') {
            str4 = replaceAll;
        } else {
            str4 = "screen" + replaceAll;
        }
        ((CsfdApplication) getContext().getApplicationContext()).m6233u().send(new EventBuilder().setCategory(str4).setAction(str2).setLabel(str3).setValue((long) i).build());
    }

    public void setContentUrl(String str) {
        this.f5146e = str;
    }

    private void m7589i() {
        if (!this.f5143b.mo3449a()) {
            m7590j();
        }
    }

    private void m7590j() {
        Object z = this.f5142a.m6226n().m7219z();
        if (TextUtils.isEmpty(z)) {
            setVisibility(8);
        } else if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext()) != 0) {
            setVisibility(8);
        } else {
            View adView = new AdView(getContext());
            this.f5147f = adView;
            adView.setAdUnitId(z);
            adView.setAdSize(this.f5144c.m7096j());
            addView(adView);
            Builder builder = new Builder();
            builder.addKeyword("movie").addKeyword("film").addKeyword("television").addKeyword("cinema");
            if (this.f5146e != null) {
                builder.setContentUrl(this.f5146e);
            }
            builder.addTestDevice("05A1E9032FB4A113222BDA7CAE5CF89F");
            builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            adView.loadAd(builder.build());
            m7585a("ad_admob_shown", this.f5145d, this.f5144c.m7083a(), 0);
        }
    }

    public void m7594c() {
        if (this.f5147f != null) {
            this.f5147f.resume();
        }
    }

    public void m7595d() {
        if (this.f5147f != null) {
            this.f5147f.pause();
        }
    }

    public void m7596e() {
        if (this.f5147f != null) {
            this.f5147f.destroy();
        }
    }
}
