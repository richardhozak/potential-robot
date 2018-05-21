package cz.csfd.csfdroid.module.user;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class FanclubsActivity extends C2157b {
    protected Fragment mo3474q() {
        return new C2473a();
    }

    protected C2254b mo3475r() {
        return null;
    }

    protected Intent mo3630g() {
        return m6292m().m6219g().mo3459i().mo3647a((Context) this, getIntent().getIntExtra("user_id", 0));
    }

    protected void mo3642h() {
        TaskStackBuilder.create(this).addNextIntentWithParentStack(mo3630g()).startActivities();
    }

    public String mo3436p() {
        return "/user/ratings";
    }
}
