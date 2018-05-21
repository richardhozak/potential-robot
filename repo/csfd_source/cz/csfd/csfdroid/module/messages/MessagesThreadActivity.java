package cz.csfd.csfdroid.module.messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.p017a.C0436a;
import cz.csfd.csfdroid.module.home.C2287g;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class MessagesThreadActivity extends C2287g {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0436a b = m1367b();
        if (b != null) {
            b.mo1425e(false);
            b.mo1422d(true);
            b.mo1421c(true);
            b.mo1419b(true);
        }
    }

    public String mo3436p() {
        return "/messages/thread";
    }

    protected Fragment mo3475r() {
        return new C2306f();
    }

    protected void mo3486c(Intent intent) {
        intent.putExtra("row", C2254b.MESSAGES.m8157a());
        super.mo3486c(intent);
    }
}
