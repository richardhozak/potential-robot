package cz.csfd.csfdroid.module.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.list.p063a.C2111s.C2110a;
import cz.csfd.csfdroid.module.ads.C2147a;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class MainActivity extends C2157b implements C2110a {
    private C2254b f5552e;
    private View f5553f;
    private CsfdApplication f5554g;
    private C2147a f5555h;

    public String mo3436p() {
        return "/home";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5554g = m6292m();
        this.f5555h = this.f5554g.m6219g().mo3464n();
        m8176w();
        this.f5555h.mo3447a(m6292m().m6220h(), this, this.f5554g.m6226n());
    }

    private void m8176w() {
        if (this.f5554g.m6226n().m7205k() < System.currentTimeMillis()) {
            this.f5555h.mo3445a(m6292m().m6220h(), this);
        }
    }

    protected Fragment mo3474q() {
        if (this.f5552e == null) {
            m8177x();
        }
        switch (this.f5552e) {
            case VIDEOS:
                return m6292m().m6219g().mo3465o().mo3438a();
            case TV_TIPS:
                return m6292m().m6219g().mo3462l().mo3632a();
            case CINEMAS:
                return m6292m().m6219g().mo3457g().mo3491a();
            case MESSAGES:
                return m6292m().m6219g().mo3466p().mo3561d();
            case TV_SCHEDULE:
                return m6292m().m6219g().mo3463m().mo3627a();
            default:
                return m6292m().m6219g().mo3451a().mo3540a();
        }
    }

    protected C2254b mo3475r() {
        if (this.f5552e == null) {
            m8177x();
        }
        return this.f5552e;
    }

    private void m8177x() {
        this.f5552e = C2254b.HOMESCREEN;
        Uri data = getIntent().getData();
        if (getIntent().hasExtra("row")) {
            this.f5552e = C2254b.m8156a(getIntent().getIntExtra("row", C2254b.HOMESCREEN.m8157a()));
        } else if (data != null && m6292m().m6219g().mo3462l().mo3637a(data)) {
            this.f5552e = C2254b.TV_TIPS;
        }
    }

    protected boolean mo3531b(C2254b c2254b) {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m8177x();
        m7698t();
    }

    public void setOverridingTouchTarget(View view) {
        this.f5553f = view;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f5553f == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        boolean onTouchEvent = this.f5553f.onTouchEvent(motionEvent);
        if (onTouchEvent) {
            return onTouchEvent;
        }
        this.f5553f = null;
        return onTouchEvent;
    }
}
