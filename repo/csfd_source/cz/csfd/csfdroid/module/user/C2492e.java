package cz.csfd.csfdroid.module.user;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.module.user.C2489d.C2472a;
import cz.csfd.csfdroid.module.user.C2489d.C2477b;
import cz.csfd.csfdroid.module.user.C2489d.C2487c;
import org.apache.http.HttpHost;

/* compiled from: UserModuleImpl */
public class C2492e implements C2489d {
    private C2011b f6253a;
    private C2011b f6254b;
    private C2011b f6255c;
    private C2011b f6256d;

    public void mo3653a(Context context, User user) {
        context.startActivity(mo3647a(context, user.m6705g()));
    }

    public Fragment mo3648a(User user) {
        Fragment c2488c = new C2488c();
        Bundle bundle = new Bundle();
        bundle.putInt("user_id", user.m6705g());
        c2488c.setArguments(bundle);
        return c2488c;
    }

    public void mo3654a(Context context, User user, Section section) {
        switch (section) {
            case FILM_RATINGS:
                m9171b(context, user);
                return;
            case FILM_COMMENTS:
                m9175c(context, user);
                return;
            case FANCLUB_FILMS:
            case FANCLUB_SERIES:
            case FANCLUB_SHOWS:
            case FANCLUB_ACTORS:
            case FANCLUB_ACTRESSES:
            case FANCLUB_DIRECTORS:
            case FANCLUB_COMPOSERS:
            case FANCLUB_CINEMATOGRAPHERS:
            case FANCLUB_SCREENWRITERS:
            case FAVOURITE_USERS:
                m9172b(context, user, section);
                return;
            default:
                return;
        }
    }

    public Intent mo3647a(Context context, int i) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.setData(m9157a(i));
        return intent;
    }

    public void m9171b(Context context, User user) {
        Intent intent = new Intent(context, RatingsActivity.class);
        intent.putExtra("user_id", user.m6705g());
        context.startActivity(intent);
    }

    public void m9175c(Context context, User user) {
        Intent intent = new Intent(context, RatingsActivity.class);
        intent.putExtra("user_id", user.m6705g());
        intent.putExtra("comments", true);
        context.startActivity(intent);
    }

    public void m9172b(Context context, User user, Section section) {
        Intent intent = new Intent(context, FanclubsActivity.class);
        intent.putExtra("user_id", user.m6705g());
        intent.putExtra("fanclub", section);
        context.startActivity(intent);
    }

    public Uri m9157a(int i) {
        Builder builder = new Builder();
        builder.scheme("csfdroid").authority("csfd.cz").path("uzivatel").appendPath(String.valueOf(i));
        return builder.build();
    }

    public String mo3649a(User user, Section section) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://www.csfd.cz").append("/uzivatel/").append(user.m6705g()).append("/");
        if (section != null) {
            stringBuilder.append(section.m7080e());
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public void mo3657a(User user, C2487c c2487c, C2016c c2016c) {
        m9169b();
        if (c2487c != null) {
            c2487c.mo3417g();
        }
        this.f6253a = c2016c.mo3380a(user, (C1945a) c2487c);
    }

    public void m9169b() {
        if (this.f6253a != null) {
            this.f6253a.mo3355a();
            this.f6253a = null;
        }
    }

    public void mo3656a(User user, C2477b c2477b, C2016c c2016c) {
        mo3650a();
        if (c2477b != null) {
            c2477b.mo3417g();
        }
        this.f6254b = c2016c.mo3379a(user, user.m6823h().size(), 20, (C1945a) c2477b);
    }

    public void mo3650a() {
        if (this.f6254b != null) {
            this.f6254b.mo3355a();
            this.f6254b = null;
        }
    }

    public void mo3660b(User user, C2477b c2477b, C2016c c2016c) {
        m9174c();
        if (c2477b != null) {
            c2477b.mo3417g();
        }
        this.f6255c = c2016c.mo3397b(user, user.m6823h().size(), 20, (C1945a) c2477b);
    }

    public void m9174c() {
        if (this.f6255c != null) {
            this.f6255c.mo3355a();
            this.f6255c = null;
        }
    }

    public void mo3655a(User user, Section section, C2472a c2472a, C2016c c2016c) {
        m9176d();
        if (c2472a != null) {
            c2472a.mo3417g();
        }
        this.f6256d = c2016c.mo3381a(user, section, (C1945a) c2472a);
    }

    public void m9176d() {
        if (this.f6256d != null) {
            this.f6256d.mo3355a();
            this.f6256d = null;
        }
    }

    public void mo3651a(int i, C1945a<Boolean> c1945a, C2016c c2016c) {
        c2016c.mo3401c((C1945a) c1945a, i);
    }

    public void mo3659b(int i, C1945a<Boolean> c1945a, C2016c c2016c) {
        c2016c.mo3405d((C1945a) c1945a, i);
    }

    public int mo3646a(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase("csfdroid")) {
            return Integer.parseInt(uri.getLastPathSegment());
        }
        if (!scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) && !scheme.equalsIgnoreCase("https")) {
            return 0;
        }
        try {
            scheme = (String) uri.getPathSegments().get(1);
            int indexOf = scheme.indexOf("-");
            if (indexOf > 0) {
                return Integer.parseInt(scheme.substring(0, indexOf));
            }
            return Integer.parseInt(scheme);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Section mo3658b(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            try {
                return Section.m7073a((String) uri.getPathSegments().get(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void mo3652a(final Activity activity, final C1950a c1950a, int i, final C1947a c1947a) {
        new AlertDialog.Builder(activity).setTitle(R.string.login_alert_dialog_title).setMessage(i).setPositiveButton(R.string.login_alert_dialog_button_yes, new OnClickListener(this) {
            final /* synthetic */ C2492e f6251d;

            public void onClick(DialogInterface dialogInterface, int i) {
                c1950a.m6246a(activity, c1947a);
            }
        }).create().show();
    }
}
