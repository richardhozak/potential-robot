package cz.csfd.csfdroid.module.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.p017a.C0444b;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1950a.C1948b;
import cz.csfd.csfdroid.C1964b;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.module.chart.C2164b;
import cz.csfd.csfdroid.module.cinema.C2197e;
import cz.csfd.csfdroid.module.favorites.C2238b;
import cz.csfd.csfdroid.module.home.C2284d.C2283b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2156a;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;
import cz.csfd.csfdroid.module.messages.C2297d;
import cz.csfd.csfdroid.module.p066a.C2136b;
import cz.csfd.csfdroid.module.tvschedule.C2450d;
import cz.csfd.csfdroid.module.tvtips.C2462c;
import cz.csfd.csfdroid.module.user.C2489d;
import cz.csfd.csfdroid.module.watchlist.C2494b;
import cz.csfd.csfdroid.oauth.C2540c.C1959b;
import cz.csfd.csfdroid.p061d.C1996r;

/* compiled from: DrawerActivity */
public abstract class C2157b extends C1964b implements C2156a {
    protected DrawerLayout f5212a;
    protected C0444b f5213b;
    protected View f5214c;
    protected DrawerFragment f5215d;
    private CsfdApplication f5216e;
    private C1996r f5217f;
    private InterstitialAd f5218g;
    private C1945a<Integer> f5219h = new C22611(this);

    /* compiled from: DrawerActivity */
    class C22611 implements C1945a<Integer> {
        final /* synthetic */ C2157b f5556a;

        C22611(C2157b c2157b) {
            this.f5556a = c2157b;
        }

        public void m8188a(Integer num) {
            this.f5556a.mo3467a(num.intValue());
        }

        public void mo3323a(Exception exception) {
        }

        public void mo3322a() {
        }
    }

    /* compiled from: DrawerActivity */
    class C22633 extends AdListener {
        final /* synthetic */ C2157b f5559a;

        C22633(C2157b c2157b) {
            this.f5559a = c2157b;
        }

        public void onAdClosed() {
            this.f5559a.m7685w();
            this.f5559a.m7687y();
        }
    }

    /* compiled from: DrawerActivity */
    class C22654 implements C1959b {
        final /* synthetic */ C2157b f5561a;

        /* compiled from: DrawerActivity */
        class C22641 implements Runnable {
            final /* synthetic */ C22654 f5560a;

            C22641(C22654 c22654) {
                this.f5560a = c22654;
            }

            public void run() {
                this.f5560a.f5561a.f5215d.m8163a(C2254b.HOMESCREEN);
                this.f5560a.f5561a.mo3469n();
            }
        }

        C22654(C2157b c2157b) {
            this.f5561a = c2157b;
        }

        public void mo3329a() {
            this.f5561a.f5216e.m6222j().m7165b();
            C2284d a = this.f5561a.f5216e.m6219g().mo3451a();
            if (this.f5561a.mo3531b(C2254b.HOMESCREEN)) {
                this.f5561a.startActivity(a.mo3538a(this.f5561a));
                this.f5561a.finish();
                return;
            }
            this.f5561a.m7690a(a.mo3540a(), false, true);
            this.f5561a.runOnUiThread(new C22641(this));
        }
    }

    protected abstract Fragment mo3474q();

    protected abstract C2254b mo3475r();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_with_drawer);
        this.f5216e = m6292m();
        if (m7700v()) {
            m7686x();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.content) == null) {
            m7698t();
        }
        C2254b r = mo3475r();
        if (r != null && bundle == null) {
            this.f5215d.m8163a(r);
        }
        String str = this.f5216e.m6226n().m7172D().f4679b;
        if (str != null) {
            this.f5218g = new InterstitialAd(this);
            this.f5218g.setAdUnitId(str);
            m7685w();
        }
        mo3476s();
    }

    public void mo3476s() {
        this.f5216e.m6219g().mo3466p().mo3558b(this.f5219h, this.f5216e.m6220h());
    }

    private void m7685w() {
        this.f5218g.loadAd(new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
    }

    protected final void m7698t() {
        Fragment q = mo3474q();
        Bundle d = m6284d(getIntent());
        if (q.getArguments() != null) {
            q.getArguments().putAll(d);
        } else {
            q.setArguments(d);
        }
        m7690a(q, false, false);
    }

    private void m7686x() {
        final C2057e n = this.f5216e.m6226n();
        this.f5214c = findViewById(R.id.drawer_fragment);
        this.f5215d = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer_fragment);
        this.f5215d.m8164a(this.f5216e.m6229q().m6250a());
        this.f5212a = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f5213b = new C0444b(this, this, this.f5212a, R.string.drawer_open, R.string.drawer_close) {
            final /* synthetic */ C2157b f5558d;

            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View view) {
                n.m7191b(true);
            }
        };
        this.f5212a.setDrawerListener(this.f5213b);
        this.f5212a.setDrawerShadow((int) R.drawable.drawer_shadow, 3);
        long F = n.m7174F();
        if (!n.m7213s() && F > 2) {
            this.f5212a.openDrawer(this.f5214c);
            n.m7191b(true);
        }
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.f5213b != null) {
            this.f5213b.m1308a();
        }
    }

    protected void m7690a(Fragment fragment, boolean z, boolean z2) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.content);
        Object obj = null;
        if (findFragmentById != null && findFragmentById.getClass().getName().equals(fragment.getClass().getName())) {
            obj = 1;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.content, fragment);
        if (z) {
            beginTransaction.addToBackStack(null);
        }
        if (z2 && r0 == null) {
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        beginTransaction.commit();
    }

    public void mo3468a(C2254b c2254b) {
        if (c2254b != null && this.f5215d.m8161a() != c2254b) {
            Intent a;
            switch (c2254b) {
                case HOMESCREEN:
                    if (this.f5218g != null && this.f5218g.isLoaded()) {
                        this.f5218g.setAdListener(new C22633(this));
                        this.f5218g.show();
                        break;
                    }
                    m7687y();
                    break;
                    break;
                case VIDEOS:
                    C2136b o = this.f5216e.m6219g().mo3465o();
                    if (mo3531b(c2254b)) {
                        a = o.mo3437a((Context) this);
                        a.addFlags(67108864);
                        startActivity(a);
                        finish();
                    } else {
                        m7690a(o.mo3438a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "videos", mo3436p(), 0);
                    break;
                case CINEMAS:
                    C2197e g = this.f5216e.m6219g().mo3457g();
                    if (mo3531b(c2254b)) {
                        g.mo3495a((Context) this);
                        finish();
                    } else {
                        m7690a(g.mo3491a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "cinemas", mo3436p(), 0);
                    break;
                case BLURAY:
                    m7688z();
                    break;
                case DVD:
                    m7677A();
                    break;
                case CHARTS:
                    C2164b h = this.f5216e.m6219g().mo3458h();
                    if (mo3531b(c2254b)) {
                        h.mo3480a((Context) this);
                        finish();
                    } else {
                        m7690a(h.mo3478a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "charts", mo3436p(), 0);
                    break;
                case FAVORITES:
                    if (this.f5216e.m6229q().m6253c() > 0) {
                        C2238b j = this.f5216e.m6219g().mo3460j();
                        if (mo3531b(c2254b)) {
                            j.mo3523a(this);
                            finish();
                        } else {
                            m7690a(j.mo3522a(), false, true);
                            this.f5215d.m8163a(c2254b);
                        }
                    } else {
                        m7683c(c2254b);
                    }
                    m6282a("sidenav", "favorites", mo3436p(), 0);
                    break;
                case WATCHLIST:
                    C2494b k = this.f5216e.m6219g().mo3461k();
                    if (this.f5216e.m6229q().m6253c() <= 0) {
                        m7683c(c2254b);
                    } else if (mo3531b(c2254b)) {
                        k.mo3663a(this);
                        finish();
                    } else {
                        m7690a(k.mo3661a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "watchlist", mo3436p(), 0);
                    break;
                case TV_TIPS:
                    C2462c l = this.f5216e.m6219g().mo3462l();
                    if (mo3531b(c2254b)) {
                        a = l.mo3631a((Context) this);
                        a.addFlags(67108864);
                        startActivity(a);
                        finish();
                    } else {
                        m7690a(l.mo3632a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "tv-tips", mo3436p(), 0);
                    break;
                case TV_SCHEDULE:
                    C2450d m = this.f5216e.m6219g().mo3463m();
                    if (mo3531b(c2254b)) {
                        a = m.mo3625a(this);
                        a.addFlags(67108864);
                        startActivity(a);
                        finish();
                    } else {
                        m7690a(m.mo3627a(), false, true);
                        this.f5215d.m8163a(c2254b);
                    }
                    m6282a("sidenav", "tv-schedule", mo3436p(), 0);
                    break;
                case MESSAGES:
                    if (this.f5216e.m6229q().m6253c() > 0) {
                        C2297d p = this.f5216e.m6219g().mo3466p();
                        if (mo3531b(c2254b)) {
                            a = p.mo3550a((Context) this);
                            a.addFlags(67108864);
                            startActivity(a);
                            finish();
                        } else {
                            m7690a(p.mo3561d(), false, true);
                            this.f5215d.m8163a(c2254b);
                        }
                    } else {
                        m7683c(c2254b);
                    }
                    m6282a("sidenav", "messages", mo3436p(), 0);
                    break;
                case ACCOUNT:
                    m7699u();
                    break;
                case PREFERENCES:
                    this.f5216e.m6219g().mo3455e().mo3613a(this);
                    m6282a("sidenav", "preferences", mo3436p(), 0);
                    break;
                case ABOUT:
                    this.f5216e.m6219g().mo3451a().mo3542a((FragmentActivity) this);
                    m6282a("sidenav", "about", mo3436p(), 0);
                    break;
                case LOGOUT:
                    this.f5216e.m6229q().m6248a(new C22654(this));
                    m6282a("sidenav", "logout", mo3436p(), 0);
                    break;
                case LOGIN:
                    m7683c(null);
                    break;
            }
            this.f5212a.closeDrawer(this.f5214c);
        }
    }

    private void m7687y() {
        C2284d a = this.f5216e.m6219g().mo3451a();
        if (mo3531b(C2254b.HOMESCREEN)) {
            startActivity(a.mo3538a((Context) this));
            finish();
        } else {
            m7690a(a.mo3540a(), false, true);
            this.f5215d.m8163a(C2254b.HOMESCREEN);
        }
        m6282a("sidenav", "home", mo3436p(), 0);
    }

    private void m7688z() {
        C2284d a = this.f5216e.m6219g().mo3451a();
        if (mo3531b(C2254b.BLURAY)) {
            startActivity(a.mo3539a(this, C2283b.BLURAY));
            finish();
        } else {
            m7690a(a.mo3541a(C2283b.BLURAY), false, true);
            this.f5215d.m8163a(C2254b.BLURAY);
        }
        m6282a("sidenav", "bluray", mo3436p(), 0);
    }

    private void m7677A() {
        C2284d a = this.f5216e.m6219g().mo3451a();
        if (mo3531b(C2254b.DVD)) {
            startActivity(a.mo3539a(this, C2283b.DVD));
            finish();
        } else {
            m7690a(a.mo3541a(C2283b.DVD), false, true);
            this.f5215d.m8163a(C2254b.DVD);
        }
        m6282a("sidenav", "dvd", mo3436p(), 0);
    }

    public void m7699u() {
        int c = this.f5216e.m6229q().m6253c();
        C2489d i = this.f5216e.m6219g().mo3459i();
        if (c > 0) {
            User user = new User(c);
            if (mo3531b(C2254b.ACCOUNT)) {
                Intent a = i.mo3647a((Context) this, user.m6705g());
                a.addFlags(67108864);
                startActivity(a);
                finish();
            } else {
                m7690a(i.mo3648a(user), false, true);
                this.f5215d.m8163a(C2254b.ACCOUNT);
            }
        } else {
            m7683c(C2254b.ACCOUNT);
        }
        m6282a("sidenav", "account", mo3436p(), 0);
    }

    protected boolean mo3531b(C2254b c2254b) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (!this.f5213b.m1314c()) {
                    return super.onOptionsItemSelected(menuItem);
                }
                if (this.f5212a.isDrawerOpen(this.f5214c)) {
                    this.f5212a.closeDrawer(this.f5214c);
                } else {
                    this.f5212a.openDrawer(this.f5214c);
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5213b.m1310a(configuration);
    }

    public void onBackPressed() {
        if (this.f5212a.isDrawerOpen(this.f5214c)) {
            this.f5212a.closeDrawer(this.f5214c);
        } else {
            super.onBackPressed();
        }
    }

    private void m7683c(final C2254b c2254b) {
        final C1950a q = this.f5216e.m6229q();
        if (q.m6250a()) {
            this.f5217f = C1996r.m6363a(R.string.dialog_oauth_login, true);
            this.f5217f.show(getSupportFragmentManager(), "identity_update");
            q.m6247a(new C1948b(this) {
                final /* synthetic */ C2157b f5565c;

                /* compiled from: DrawerActivity */
                class C22661 implements Runnable {
                    final /* synthetic */ C22675 f5562a;

                    C22661(C22675 c22675) {
                        this.f5562a = c22675;
                    }

                    public void run() {
                        this.f5562a.f5565c.mo3469n();
                    }
                }

                public void mo3534a() {
                    this.f5565c.f5217f.dismiss();
                    this.f5565c.m7678a(q, c2254b);
                    this.f5565c.runOnUiThread(new C22661(this));
                }
            });
            q.m6255e();
            return;
        }
        m6278a(new C1947a(this) {
            final /* synthetic */ C2157b f5569c;

            /* compiled from: DrawerActivity */
            class C22681 implements Runnable {
                final /* synthetic */ C22696 f5566a;

                C22681(C22696 c22696) {
                    this.f5566a = c22696;
                }

                public void run() {
                    this.f5566a.f5569c.mo3469n();
                }
            }

            public void mo3328a() {
                this.f5569c.m7678a(q, c2254b);
                this.f5569c.runOnUiThread(new C22681(this));
            }
        });
    }

    private void m7678a(C1950a c1950a, C2254b c2254b) {
        User user = new User(c1950a.m6253c());
        if (c2254b == C2254b.FAVORITES) {
            this.f5216e.m6219g().mo3460j().mo3523a(this);
            finish();
            overridePendingTransition(0, 0);
        } else if (c2254b == C2254b.ACCOUNT) {
            this.f5216e.m6219g().mo3459i().mo3653a((Context) this, user);
            finish();
            overridePendingTransition(0, 0);
        } else if (c2254b == C2254b.WATCHLIST) {
            this.f5216e.m6219g().mo3461k().mo3663a(this);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    public void mo3469n() {
        this.f5215d.m8164a(this.f5216e.m6229q().m6250a());
    }

    public boolean m7700v() {
        return true;
    }

    protected void mo3470o() {
        if (this.f5212a.isDrawerOpen(this.f5214c)) {
            this.f5212a.closeDrawer(this.f5214c);
        } else {
            this.f5212a.openDrawer(this.f5214c);
        }
    }

    public void mo3467a(int i) {
        super.mo3467a(i);
        this.f5215d.m8162a(i);
    }
}
