package cz.csfd.csfdroid.module.ads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.p042c.p049b.C1187t;
import com.p042c.p049b.ae;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.module.ads.C2147a.C2139a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.HashMap;

public class AdBottomView extends RelativeLayout {
    private String f5154a;
    private C2024a f5155b;
    private View f5156c;
    private View f5157d;
    private ImageView f5158e;
    private C2146b f5159f;
    private HashMap<String, String> f5160g;
    private C2147a f5161h;
    private FrameLayout f5162i;

    class C21421 implements OnClickListener {
        final /* synthetic */ AdBottomView f5149a;

        C21421(AdBottomView adBottomView) {
            this.f5149a = adBottomView;
        }

        public void onClick(View view) {
            if (this.f5149a.f5154a != null) {
                this.f5149a.m7609a("ad_banner_hidden", this.f5149a.f5154a, this.f5149a.f5155b.m7083a(), 0);
                C1998s.m6372a(getClass(), "Ad Banner hidden tracked");
            }
            this.f5149a.m7618f();
        }
    }

    class C21432 implements C2139a {
        final /* synthetic */ AdBottomView f5150a;

        C21432(AdBottomView adBottomView) {
            this.f5150a = adBottomView;
        }

        public void mo3443b() {
        }

        public void mo3444c() {
            this.f5150a.f5161h.mo3448a(false);
            if (this.f5150a.f5155b != null) {
                this.f5150a.m7618f();
            }
        }

        public void m7598a(C2024a c2024a) {
            if (c2024a == null || !c2024a.m7093g()) {
                this.f5150a.f5161h.mo3448a(false);
                if (this.f5150a.f5155b != null) {
                    this.f5150a.m7618f();
                    return;
                }
                return;
            }
            this.f5150a.f5161h.mo3448a(true);
            this.f5150a.f5155b = c2024a;
            this.f5150a.m7612c();
        }

        public void mo3323a(Exception exception) {
            this.f5150a.f5161h.mo3448a(false);
            Log.e("AdBottomView", exception.toString());
        }

        public void mo3322a() {
        }
    }

    class C21454 implements OnClickListener {
        final /* synthetic */ AdBottomView f5153a;

        C21454(AdBottomView adBottomView) {
            this.f5153a = adBottomView;
        }

        public void onClick(View view) {
            this.f5153a.m7615d();
        }
    }

    public AdBottomView(Context context) {
        super(context);
        m7611b();
    }

    public AdBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7611b();
    }

    private void m7611b() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_ad_bottom, this, true);
        if (!isInEditMode()) {
            this.f5161h = C1998s.m6365a(getContext()).m6219g().mo3464n();
        }
        this.f5162i = (FrameLayout) findViewById(R.id.frame);
        this.f5157d = findViewById(R.id.close);
        this.f5157d.setOnClickListener(new C21421(this));
    }

    public void setBackgroundView(View view) {
        this.f5156c = view;
    }

    public void m7621a(C2146b c2146b, HashMap<String, String> hashMap, String str) {
        this.f5159f = c2146b;
        this.f5160g = hashMap;
        this.f5154a = str;
        m7620a();
    }

    public void m7620a() {
        CsfdApplication csfdApplication = (CsfdApplication) getContext().getApplicationContext();
        csfdApplication.m6219g().mo3464n().mo3450b(this.f5159f, this.f5160g, new C21432(this), csfdApplication.m6220h(), getContext());
    }

    private void m7612c() {
        if (this.f5158e == null) {
            this.f5158e = new ImageView(getContext());
            this.f5162i.addView(this.f5158e);
        }
        int i = getResources().getConfiguration().orientation;
        final int i2 = getResources().getDisplayMetrics().widthPixels;
        int h = (int) ((2 == i ? this.f5155b.m7094h() : this.f5155b.m7095i()) * ((double) i2));
        C1187t.m5432a(getContext()).m5439a(this.f5155b.m7084a(i)).m5476a(new ae(this) {
            final /* synthetic */ AdBottomView f5152b;

            public Bitmap mo3346a(Bitmap bitmap) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, (int) ((((double) bitmap.getHeight()) / ((double) bitmap.getWidth())) * ((double) i2)), false);
                if (createScaledBitmap != bitmap) {
                    bitmap.recycle();
                }
                return createScaledBitmap;
            }

            public String mo3347a() {
                return "transformation desiredWidth";
            }
        }).m5477a(this.f5158e);
        this.f5162i.setForeground(getResources().getDrawable(R.drawable.xml_bg_trailer_selector));
        this.f5162i.setOnClickListener(new C21454(this));
        m7616e();
        m7607a(i2, h);
        if (this.f5157d != null) {
            this.f5157d.setVisibility(0);
        }
    }

    private void m7607a(int i, int i2) {
        if (this.f5156c != null) {
            LayoutParams layoutParams = this.f5156c.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.f5156c.setLayoutParams(layoutParams);
        }
    }

    private void m7615d() {
        if (this.f5155b != null && !TextUtils.isEmpty(this.f5155b.m7090d())) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5155b.m7090d()));
            getContext().startActivity(intent);
            m7609a("ad_banner_clicked", this.f5154a, this.f5155b.m7083a(), 0);
        }
    }

    private void m7616e() {
        if (!TextUtils.isEmpty(this.f5155b.m7084a(getResources().getConfiguration().orientation))) {
            if (this.f5154a == null) {
                Log.w("AdBottomView", "Ad tracking name not provided");
                return;
            }
            m7609a("ad_banner_shown", this.f5154a, this.f5155b.m7083a(), 0);
            C1998s.m6372a(getClass(), "Ad Banner shown tracked");
        }
    }

    private void m7618f() {
        this.f5158e = null;
        if (this.f5157d != null) {
            this.f5157d.setVisibility(8);
        }
        this.f5162i.removeAllViews();
        m7607a(0, 0);
    }

    private void m7609a(String str, String str2, String str3, int i) {
        String str4;
        String replaceAll = str.replaceAll("/", "_");
        if (replaceAll.length() <= 1 || replaceAll.charAt(0) != '_') {
            str4 = replaceAll;
        } else {
            str4 = "screen" + replaceAll;
        }
        ((CsfdApplication) getContext().getApplicationContext()).m6233u().send(new EventBuilder().setCategory(str4).setAction(str2).setLabel(str3).setValue((long) i).build());
    }
}
