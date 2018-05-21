package cz.csfd.csfdroid.module.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import java.util.List;

/* compiled from: UserModule */
public interface C2489d {

    /* compiled from: UserModule */
    public interface C2472a extends C1945a<List<Object>> {
        void mo3417g();
    }

    /* compiled from: UserModule */
    public interface C2477b extends C1945a<List<C2028e>> {
        void mo3417g();
    }

    /* compiled from: UserModule */
    public interface C2487c extends C1945a<User> {
        void mo3417g();
    }

    int mo3646a(Uri uri);

    Intent mo3647a(Context context, int i);

    Fragment mo3648a(User user);

    String mo3649a(User user, Section section);

    void mo3650a();

    void mo3651a(int i, C1945a<Boolean> c1945a, CsfdDataProvider c2016c);

    void mo3652a(Activity activity, C1950a c1950a, int i, C1947a c1947a);

    void mo3653a(Context context, User user);

    void mo3654a(Context context, User user, Section section);

    void mo3655a(User user, Section section, C2472a c2472a, CsfdDataProvider c2016c);

    void mo3656a(User user, C2477b c2477b, CsfdDataProvider c2016c);

    void mo3657a(User user, C2487c c2487c, CsfdDataProvider c2016c);

    Section mo3658b(Uri uri);

    void mo3659b(int i, C1945a<Boolean> c1945a, CsfdDataProvider c2016c);

    void mo3660b(User user, C2477b c2477b, CsfdDataProvider c2016c);
}
