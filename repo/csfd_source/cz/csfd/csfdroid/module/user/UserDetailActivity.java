package cz.csfd.csfdroid.module.user;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class UserDetailActivity extends C2157b {
    private C2489d f6185e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f6185e == null) {
            this.f6185e = m6292m().m6219g().mo3459i();
        }
        Section x = m9060x();
        if (x != null) {
            this.f6185e.mo3654a((Context) this, new User(m9059w()), x);
            finish();
        }
        if (m6292m().m6229q().m6253c() != m9059w()) {
            this.a.setDrawerLockMode(1);
            this.b.m1312a(false);
        }
    }

    protected Fragment mo3474q() {
        if (this.f6185e == null) {
            this.f6185e = m6292m().m6219g().mo3459i();
        }
        Fragment c2488c = new C2488c();
        Bundle bundle = new Bundle();
        bundle.putInt("user_id", m9059w());
        c2488c.setArguments(bundle);
        return c2488c;
    }

    protected C2254b mo3475r() {
        return m6292m().m6229q().m6253c() == m9059w() ? C2254b.ACCOUNT : null;
    }

    private int m9059w() {
        if (this.f6185e == null) {
            this.f6185e = m6292m().m6219g().mo3459i();
        }
        return this.f6185e.mo3646a(getIntent().getData());
    }

    private Section m9060x() {
        if (this.f6185e == null) {
            this.f6185e = m6292m().m6219g().mo3459i();
        }
        return this.f6185e.mo3658b(getIntent().getData());
    }

    public String mo3436p() {
        return "/user";
    }
}
