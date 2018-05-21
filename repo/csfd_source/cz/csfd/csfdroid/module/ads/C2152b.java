package cz.csfd.csfdroid.module.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.data.entity.C2025b;
import cz.csfd.csfdroid.module.ads.C2147a.C2139a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.p061d.C1998s.C1997a;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdsModuleImpl */
public class C2152b implements C2147a {
    private boolean f5188a;

    public C2011b m7645a(C1945a<C2025b> c1945a, CsfdDataProvider c2016c, Context context) {
        return c2016c.mo3404d(c1945a);
    }

    public C2011b mo3446a(C2146b c2146b, HashMap<String, String> hashMap, final C2139a c2139a, CsfdDataProvider c2016c, Context context) {
        final C2057e n = C1998s.m6365a(context).m6226n();
        if (n.m7203i() > System.currentTimeMillis()) {
            C1998s.m6372a(getClass(), "No ad this time, next ad at: " + new Date(n.m7203i()));
            if (n.m7169A() != null) {
                C1998s.m6372a(getClass(), "Show at least admob: " + n.m7169A());
                C2024a c2024a = new C2024a();
                c2024a.m7086a(n.m7169A());
                c2139a.mo3324a((Object) c2024a);
            } else {
                C1998s.m6372a(getClass(), "No ad should be shown");
                c2139a.mo3444c();
            }
            return null;
        }
        int applyDimension;
        int applyDimension2;
        C1998s.m6372a(getClass(), "Started fetching ad, next ad time was: " + new Date(n.m7203i()));
        c2139a.mo3443b();
        Configuration configuration = context.getResources().getConfiguration();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (VERSION.SDK_INT >= 13) {
            applyDimension = (int) TypedValue.applyDimension(1, (float) configuration.screenWidthDp, displayMetrics);
            applyDimension2 = (int) TypedValue.applyDimension(1, (float) configuration.screenHeightDp, displayMetrics);
        } else {
            applyDimension = displayMetrics.widthPixels;
            applyDimension2 = displayMetrics.heightPixels;
        }
        return c2016c.mo3365a(new C1945a<C2024a>(this) {
            final /* synthetic */ C2152b f5180c;

            public void m7630a(C2024a c2024a) {
                if (c2024a != null) {
                    n.m7189b(System.currentTimeMillis() + ((long) c2024a.m7091e()));
                    n.m7179a(c2024a.m7096j());
                }
                c2139a.mo3324a((Object) c2024a);
            }

            public void mo3323a(Exception exception) {
                c2139a.mo3323a(exception);
            }

            public void mo3322a() {
                c2139a.mo3322a();
            }
        }, applyDimension, applyDimension2, c2146b.m7622a(), (Map) hashMap);
    }

    public C2011b mo3450b(C2146b c2146b, HashMap<String, String> hashMap, final C2139a c2139a, CsfdDataProvider c2016c, Context context) {
        final C2057e n = C1998s.m6365a(context).m6226n();
        if (n.m7204j() > System.currentTimeMillis()) {
            C1998s.m6372a(getClass(), "No bottom ad this time, next ad at: " + new Date(n.m7204j()));
            c2139a.mo3444c();
            return null;
        }
        int applyDimension;
        int applyDimension2;
        C1998s.m6372a(getClass(), "Started fetching bottom ad, next ad time was: " + new Date(n.m7204j()));
        c2139a.mo3443b();
        Configuration configuration = context.getResources().getConfiguration();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (VERSION.SDK_INT >= 13) {
            applyDimension = (int) TypedValue.applyDimension(1, (float) configuration.screenWidthDp, displayMetrics);
            applyDimension2 = (int) TypedValue.applyDimension(1, (float) configuration.screenHeightDp, displayMetrics);
        } else {
            applyDimension = displayMetrics.widthPixels;
            applyDimension2 = displayMetrics.heightPixels;
        }
        return c2016c.mo3392b(new C1945a<C2024a>(this) {
            final /* synthetic */ C2152b f5183c;

            public void m7634a(C2024a c2024a) {
                if (c2024a != null) {
                    n.m7194c(System.currentTimeMillis() + ((long) c2024a.m7091e()));
                }
                c2139a.mo3324a((Object) c2024a);
            }

            public void mo3323a(Exception exception) {
                c2139a.mo3323a(exception);
            }

            public void mo3322a() {
                c2139a.mo3322a();
            }
        }, applyDimension, applyDimension2, c2146b.m7622a(), (Map) hashMap);
    }

    public C2011b mo3445a(CsfdDataProvider c2016c, final Context context) {
        C1997a a = C1998s.m6366a(context.getResources());
        return c2016c.mo3363a(new C1945a<C2024a>(this) {
            final /* synthetic */ C2152b f5185b;

            public void m7638a(C2024a c2024a) {
                ((CsfdApplication) context.getApplicationContext()).m6226n().m7182a(c2024a);
            }

            public void mo3323a(Exception exception) {
                Log.e("AdsModuleImpl", exception.toString());
                ((CsfdApplication) context.getApplicationContext()).m6226n().m7182a(null);
            }

            public void mo3322a() {
            }
        }, a.f4485a, a.f4486b);
    }

    public void mo3448a(boolean z) {
        this.f5188a = z;
    }

    public boolean mo3449a() {
        return this.f5188a;
    }

    public void mo3447a(CsfdDataProvider c2016c, Context context, final C2057e c2057e) {
        m7645a(new C1945a<C2025b>(this) {
            final /* synthetic */ C2152b f5187b;

            public void m7642a(C2025b c2025b) {
                c2057e.m7183a(c2025b);
            }

            public void mo3323a(Exception exception) {
            }

            public void mo3322a() {
            }
        }, c2016c, context);
    }
}
