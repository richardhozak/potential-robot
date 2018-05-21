package cz.csfd.csfdroid.module.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.module.search.C2434c.C2432a;
import java.util.List;

/* compiled from: SearchModuleImpl */
public class C2435d implements C2434c {
    private C2011b f6059a;
    private C2011b f6060b;

    public void mo3619a(String str, Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        Builder builder = new Builder();
        builder.scheme("csfdroid").authority("csfd.cz").path("/search").query(str);
        intent.setData(builder.build());
        context.startActivity(intent);
    }

    public void mo3620a(String str, C2432a c2432a, C2016c c2016c) {
        mo3617a();
        if (c2432a != null) {
            c2432a.mo3615h();
        }
        this.f6059a = c2016c.mo3384a(str, (C1945a) c2432a);
    }

    public void mo3617a() {
        if (this.f6059a != null) {
            this.f6059a.mo3355a();
            this.f6059a = null;
        }
    }

    public void mo3618a(String str, int i, C1945a<List<User>> c1945a, C2016c c2016c) {
        this.f6060b = c2016c.mo3368a((C1945a) c1945a, str, i);
    }

    public void mo3621b() {
        if (this.f6060b != null) {
            this.f6060b.mo3355a();
            this.f6060b = null;
        }
    }
}
