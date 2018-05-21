package cz.csfd.csfdroid;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.onesignal.ae;
import com.onesignal.ae.C1856h;
import com.p030a.p031a.Crashlytics;
import com.p042c.p043a.C1119t;
import com.p042c.p049b.C1177s;
import com.p042c.p049b.C1187t;
import com.p042c.p049b.C1187t.C1179a;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.CsfdApiDataProvider;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.p062a.ConsumerSecretService;
import cz.csfd.csfdroid.data.p062a.CsfdConsumerSecretService;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.data.store.cache.C2049b;
import cz.csfd.csfdroid.data.store.cache.C2054d;
import cz.csfd.csfdroid.data.store.cache.C2055e;
import cz.csfd.csfdroid.gd.p064a.C2064a;
import cz.csfd.csfdroid.module.C2138a;
import cz.csfd.csfdroid.module.C2155b;
import cz.csfd.csfdroid.module.ads.C2154d;
import cz.csfd.csfdroid.net.CsfdHttpClient;
import cz.csfd.csfdroid.net.SimpleCsfdHttpClient;
import cz.csfd.csfdroid.net.queue.C2529b;
import cz.csfd.csfdroid.oauth.OAuthService;
import cz.csfd.csfdroid.oauth.OAuthServiceImpl;
import cz.csfd.csfdroid.p061d.C1979b;
import cz.csfd.csfdroid.p061d.C1980c;
import cz.csfd.csfdroid.p061d.C1981d;
import cz.csfd.csfdroid.p061d.C1993o;
import cz.csfd.csfdroid.p061d.C1994p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p001a.p002a.p003a.Fabric;

public class CsfdApplication extends Application {
    private static final ThreadFactory f4385a = new C19411();
    private ExecutorService f4386b;
    private C2064a f4387c;
    private ArrayList<WeakReference<C1942a>> f4388d = new ArrayList();
    private Tracker f4389e;
    private C2138a f4390f;
    private C2016c csfdApiDataProvider;
    private CsfdHttpClient csfdHttpClient;
    private C1993o f4393i;
    private C1979b f4394j;
    private C2056d<MovieInfo> f4395k;
    private C2056d<MovieCreator> f4396l;
    private C2056d<Cinema> f4397m;
    private C2049b f4398n;
    private OAuthService oauthServiceInterface;
    private Config config;
    private C1950a f4401q;
    private C1187t f4402r;
    private String versionString;
    private C2154d f4404t;
    private int f4405u = 0;
    private boolean f4406v = false;

    static class C19411 implements ThreadFactory {
        private final AtomicInteger f4384a = new AtomicInteger(1);

        C19411() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Csfdroid thread #" + this.f4384a.getAndIncrement());
        }
    }

    public interface C1942a {
        void mo3415a();
    }

    public void onCreate() {
        int i = 0;
        super.onCreate();
        Fabric.m457a((Context) this, new Crashlytics());
        this.config = new Config(this);
        this.config.increaseNumberOfLaunches();
        this.versionString = "0.0.0";
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            i = packageInfo.versionCode;
            this.versionString = packageInfo.versionName;
        } catch (NameNotFoundException e) {
        }
        ConsumerSecretService csfdConsumerSecretService = new CsfdConsumerSecretService();
        CsfdHttpClient csfdHttpClient = new SimpleCsfdHttpClient(this.config.m7201g(), i);
        this.oauthServiceInterface = new OAuthServiceImpl(csfdHttpClient, csfdConsumerSecretService);
        csfdHttpClient.m9325a(this.oauthServiceInterface);
        this.csfdHttpClient = csfdHttpClient;
        this.csfdApiDataProvider = new CsfdApiDataProvider(csfdHttpClient, C2529b.m9342a((Context) this));
        this.f4401q = new C1950a(AccountManager.get(this), this.oauthServiceInterface, this.csfdApiDataProvider);
        this.f4401q.m6249a(this.oauthServiceInterface);
        ae.m5808a((Context) this).m5785a(new C1981d(getApplicationContext())).m5786a(C1856h.Notification).m5787a();
        ae.m5823a("user_id", String.valueOf(this.f4401q.m6253c()));
        Set G = this.config.m7175G();
        if (G.contains("messages")) {
            ae.m5823a("messages", "1");
        }
        if (G.contains("wishlist")) {
            ae.m5823a("wishlist", "1");
        }
        this.f4390f = new C2155b();
        this.f4393i = new C1994p();
        this.f4394j = new C1980c();
        this.f4395k = new C2056d();
        this.f4396l = new C2056d();
        this.f4397m = new C2056d();
        m6211a(this.f4395k);
        m6211a(this.f4396l);
    }

    public void m6212a(C2154d c2154d) {
        if (c2154d != null) {
            Log.d("CsfdApplication", "set video ads | intensity: " + c2154d.m7659c() + " | count: " + c2154d.m7657a());
        } else {
            Log.d("CsfdApplication", "set video ads NULL");
        }
        this.f4404t = c2154d;
    }

    public C2154d m6210a() {
        return this.f4404t;
    }

    public int m6214b() {
        Log.d("CsfdApplication", "increase video counter " + this.f4405u + " -> " + (this.f4405u + 1));
        int i = this.f4405u + 1;
        this.f4405u = i;
        return i;
    }

    public void m6215c() {
        Log.d("CsfdApplication", "clear video counter " + this.f4405u + " -> " + 0);
        this.f4405u = 0;
    }

    public int m6216d() {
        Log.d("CsfdApplication", "get video counter: " + this.f4405u);
        return this.f4405u;
    }

    public void m6213a(boolean z) {
        this.f4406v = z;
    }

    public boolean m6217e() {
        return this.f4406v;
    }

    // m6218f
    public String getVersionString() {
        return this.versionString;
    }

    public C2138a m6219g() {
        return this.f4390f;
    }

    public C2016c m6220h() {
        return this.csfdApiDataProvider;
    }

    public CsfdHttpClient m6221i() {
        return this.csfdHttpClient;
    }

    public C2056d<MovieInfo> m6222j() {
        return this.f4395k;
    }

    public C2056d<MovieCreator> m6223k() {
        return this.f4396l;
    }

    public C2056d<Cinema> m6224l() {
        return this.f4397m;
    }

    public C1979b m6225m() {
        return this.f4394j;
    }

    public Config m6226n() {
        return this.config;
    }

    public C2049b m6227o() {
        if (this.f4398n == null) {
            this.f4398n = new C2054d(new C2055e(this));
        }
        return this.f4398n;
    }

    public OAuthService m6228p() {
        return this.oauthServiceInterface;
    }

    public C1950a m6229q() {
        return this.f4401q;
    }

    public synchronized ExecutorService m6230r() {
        if (this.f4386b == null) {
            this.f4386b = Executors.newFixedThreadPool(5, f4385a);
        }
        return this.f4386b;
    }

    public synchronized C2064a m6231s() {
        if (this.f4387c == null) {
            this.f4387c = new C2064a(this);
        }
        return this.f4387c;
    }

    public synchronized C1187t m6232t() {
        if (this.f4402r == null) {
            C1119t c1119t = new C1119t();
            C1179a c1179a = new C1179a(this);
            c1179a.m5427a(new C1177s(c1119t));
            this.f4402r = c1179a.m5428a();
        }
        return this.f4402r;
    }

    public synchronized Tracker m6233u() {
        if (this.f4389e == null) {
            this.f4389e = GoogleAnalytics.getInstance(this).newTracker((int) R.xml.global_tracker);
        }
        return this.f4389e;
    }

    public void m6211a(C1942a c1942a) {
        if (c1942a != null) {
            this.f4388d.add(new WeakReference(c1942a));
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        int i = 0;
        while (i < this.f4388d.size()) {
            int i2;
            C1942a c1942a = (C1942a) ((WeakReference) this.f4388d.get(i)).get();
            if (c1942a == null) {
                this.f4388d.remove(i);
                i2 = i;
            } else {
                c1942a.mo3415a();
                i2 = i + 1;
            }
            i = i2;
        }
    }
}
