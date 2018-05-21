package cz.csfd.csfdroid.module.messages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;
import cz.csfd.csfdroid.module.home.MainActivity;
import java.util.List;

/* compiled from: MessagesModuleImpl */
public class C2298e implements C2297d {
    C2011b f5640a;
    C2011b f5641b;
    C2011b f5642c;
    C2011b f5643d;
    C2011b f5644e;

    public void mo3553a(C1945a<List<MessageThread>> c1945a, CsfdDataProvider c2016c, int i, int i2) {
        this.f5640a = c2016c.mo3391b(c1945a, i, i2);
    }

    public void mo3551a() {
        if (this.f5640a != null) {
            this.f5640a.mo3355a();
            this.f5640a = null;
        }
    }

    public void mo3554a(C1945a<List<Message>> c1945a, CsfdDataProvider c2016c, int i, int i2, int i3) {
        this.f5641b = c2016c.mo3364a((C1945a) c1945a, i, i2, i3);
    }

    public void mo3557b() {
        if (this.f5641b != null) {
            this.f5641b.mo3355a();
            this.f5641b = null;
        }
    }

    public void mo3556a(C1945a<Boolean> c1945a, CsfdDataProvider c2016c, List<Integer> list) {
        c2016c.mo3370a((C1945a) c1945a, (List) list);
    }

    public void mo3559b(C1945a<Boolean> c1945a, CsfdDataProvider c2016c, List<String> list) {
        c2016c.mo3393b((C1945a) c1945a, (List) list);
    }

    public void mo3555a(C1945a<Message> c1945a, CsfdDataProvider c2016c, int i, String str) {
        this.f5642c = c2016c.mo3366a((C1945a) c1945a, i, str);
    }

    public void mo3552a(C1945a<List<User>> c1945a, CsfdDataProvider c2016c) {
        this.f5643d = c2016c.mo3410g(c1945a);
    }

    public void mo3560c() {
        if (this.f5643d != null) {
            this.f5643d.mo3355a();
            this.f5643d = null;
        }
    }

    public Fragment mo3561d() {
        return new C2296c();
    }

    public Intent mo3550a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("row", C2254b.MESSAGES.m8157a());
        return intent;
    }

    public int mo3549a(Uri uri) {
        if (uri.getScheme().equalsIgnoreCase("csfdroid")) {
            return Integer.parseInt((String) uri.getPathSegments().get(1));
        }
        throw new C2288a(uri.toString());
    }

    public void mo3558b(C1945a<Integer> c1945a, CsfdDataProvider c2016c) {
        if (this.f5644e != null) {
            this.f5644e.mo3355a();
        }
        this.f5644e = c2016c.mo3409f(c1945a);
    }
}
