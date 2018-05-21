package cz.csfd.csfdroid.module.search;

import android.content.Context;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.User;
import java.util.List;
import java.util.Map;

/* compiled from: SearchModule */
public interface C2434c {

    /* compiled from: SearchModule */
    public interface C2432a extends C1945a<Map<String, List<? extends BasicEntity>>> {
        void mo3615h();
    }

    void mo3617a();

    void mo3618a(String str, int i, C1945a<List<User>> c1945a, CsfdDataProvider c2016c);

    void mo3619a(String str, Context context);

    void mo3620a(String str, C2432a c2432a, CsfdDataProvider c2016c);

    void mo3621b();
}
