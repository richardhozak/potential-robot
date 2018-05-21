package cz.csfd.csfdroid.module.chart;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.module.chart.C2164b.C2161a;
import cz.csfd.csfdroid.module.chart.C2164b.C2163b;
import org.apache.http.HttpHost;

/* compiled from: ChartModuleImpl */
public class C2165c implements C2164b {
    private C2011b f5237a;
    private C2011b f5238b;

    public void mo3480a(Context context) {
        context.startActivity(new Intent(context, ChartsActivity.class));
    }

    public Fragment mo3478a() {
        return new C2170d();
    }

    public void mo3482a(C2163b c2163b, C2016c c2016c) {
        mo3483b();
        if (c2163b != null) {
            c2163b.f_();
        }
        this.f5237a = c2016c.mo3389b(c2163b);
    }

    public void mo3483b() {
        if (this.f5237a != null) {
            this.f5237a.mo3355a();
            this.f5237a = null;
        }
    }

    public void mo3481a(Chart chart, C2161a c2161a, C2016c c2016c) {
        if (c2161a != null) {
            c2161a.mo3417g();
        }
        this.f5238b = c2016c.mo3371a(chart, chart.m6722c().size(), chart.m6724e() > 0 ? chart.m6724e() + 20 : 20, (C1945a) c2161a);
    }

    public void mo3484c() {
        if (this.f5238b != null) {
            this.f5238b.mo3355a();
            this.f5238b = null;
        }
    }

    public String mo3479a(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            try {
                if (uri.getPathSegments().size() >= 2) {
                    scheme = (String) uri.getPathSegments().get(1);
                    if (TextUtils.isEmpty(scheme)) {
                        return null;
                    }
                    if (scheme.equalsIgnoreCase("nejlepsi-filmy")) {
                        return "filmsByRatingAverageTop";
                    }
                    if (scheme.equalsIgnoreCase("nejhorsi-filmy")) {
                        return "filmsByRatingAverageBottom";
                    }
                    if (scheme.equalsIgnoreCase("nejoblibenejsi-filmy")) {
                        return "filmsByFanclub";
                    }
                    if (scheme.equalsIgnoreCase("nejrozporuplnejsi-filmy")) {
                        return "filmsByRatingDeviation";
                    }
                    if (scheme.equalsIgnoreCase("nejlepsi-serialy")) {
                        return "seriesByRatingAverageTop";
                    }
                    if (scheme.equalsIgnoreCase("nejhorsi-serialy")) {
                        return "seriesByRatingAverageBottom";
                    }
                    if (scheme.equalsIgnoreCase("nejoblibenejsi-serialy")) {
                        return "seriesByFanclub";
                    }
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
