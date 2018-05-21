package cz.csfd.csfdroid.module.messages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.p017a.C0436a;
import cz.csfd.csfdroid.module.home.C2287g;

public class ContactsActivity extends C2287g {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0436a b = m1367b();
        b.mo1425e(false);
        b.mo1422d(true);
        b.mo1419b(true);
        b.mo1421c(true);
    }

    protected Fragment mo3475r() {
        return new C2290b();
    }

    public String mo3436p() {
        return "/messages/contacts";
    }
}
