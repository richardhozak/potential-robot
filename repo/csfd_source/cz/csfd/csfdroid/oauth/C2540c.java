package cz.csfd.csfdroid.oauth;

import android.content.Context;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.entity.Identity;

/* compiled from: OAuthService */
public interface C2540c extends C2539e {

    /* compiled from: OAuthService */
    public interface C1959b {
        void mo3329a();
    }

    /* compiled from: OAuthService */
    public interface C2530a {
        void mo3677a();

        void mo3678a(Identity identity, String str, String str2);

        void mo3679a(String str);
    }

    void mo3681a();

    void mo3682a(Context context, C2016c c2016c, C2530a c2530a);

    void mo3683a(C1959b c1959b);

    void mo3684a(String str);

    void mo3685a(String str, String str2);
}
