package cz.csfd.csfdroid.module.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.p042c.p049b.C1155e;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C1964b;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.module.ads.C2147a;

public class HomeActivity extends C1964b {
    private CsfdApplication f5545a;
    private C2147a f5546b;
    private C2057e f5547c;
    private InterstitialAd f5548d;
    private Handler f5549e = new Handler();
    private Runnable f5550f = new C22551(this);

    class C22551 implements Runnable {
        final /* synthetic */ HomeActivity f5539a;

        C22551(HomeActivity homeActivity) {
            this.f5539a = homeActivity;
        }

        public void run() {
            this.f5539a.m8174r();
        }
    }

    class C22584 extends AdListener {
        final /* synthetic */ HomeActivity f5544a;

        C22584(HomeActivity homeActivity) {
            this.f5544a = homeActivity;
        }

        public void onAdLoaded() {
            Log.d("HomeActivity", "onAdLoaded");
            this.f5544a.f5549e.removeCallbacks(this.f5544a.f5550f);
            this.f5544a.f5548d.show();
        }

        public void onAdFailedToLoad(int i) {
            Log.d("HomeActivity", "onAdFailedToLoad:" + i);
            this.f5544a.m8174r();
        }

        public void onAdClosed() {
            Log.d("HomeActivity", "onAdClosed");
            this.f5544a.m8174r();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        this.f5545a = m6292m();
        this.f5546b = this.f5545a.m6219g().mo3464n();
        this.f5547c = this.f5545a.m6226n();
        C2024a B = this.f5547c.m7170B();
        String str = this.f5545a.m6226n().m7172D().f4679b;
        this.f5549e.postDelayed(this.f5550f, 10000);
        if (B != null && B.m7087b() != null) {
            m8167a(B);
        } else if (str != null) {
            this.f5548d = new InterstitialAd(this);
            this.f5548d.setAdUnitId(str);
            m8173q();
        } else {
            m8174r();
        }
    }

    public String mo3436p() {
        return "/splash";
    }

    private void m8167a(final C2024a c2024a) {
        Log.d("HomeActivity", "showAdBanner " + c2024a.m7083a() + " " + c2024a.m7087b() + " " + c2024a.m7092f());
        ImageView imageView = (ImageView) findViewById(R.id.splash_banner);
        View findViewById = findViewById(R.id.splash_banner_container);
        if (findViewById != null) {
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ HomeActivity f5541b;

                public void onClick(View view) {
                    this.f5541b.m6282a("ad_splash_shown", "clicked", c2024a.m7083a(), 0);
                    this.f5541b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(c2024a.m7090d())));
                }
            });
        }
        C1187t.m5432a((Context) this).m5439a(c2024a.m7087b()).m5475a((int) R.dimen.splash_banner_size, (int) R.dimen.splash_banner_size).m5478a(imageView, new C1155e(this) {
            final /* synthetic */ HomeActivity f5543b;

            public void mo3529a() {
                this.f5543b.m6282a("ad_splash_shown", "shown", c2024a.m7083a(), 0);
                int f = c2024a.m7092f() * 1000;
                this.f5543b.f5547c.m7171C();
                this.f5543b.f5549e.removeCallbacks(this.f5543b.f5550f);
                this.f5543b.f5549e.postDelayed(this.f5543b.f5550f, (long) f);
            }

            public void mo3530b() {
                this.f5543b.m8174r();
            }
        });
    }

    private void m8173q() {
        Log.d("HomeActivity", "requestNextInterstitial");
        AdRequest build = new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        this.f5548d.setAdListener(new C22584(this));
        this.f5548d.loadAd(build);
    }

    private void m8174r() {
        this.f5549e.removeCallbacks(this.f5550f);
        Log.d("HomeActivity", "startMainActivity");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
