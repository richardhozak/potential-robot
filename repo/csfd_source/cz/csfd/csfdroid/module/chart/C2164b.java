package cz.csfd.csfdroid.module.chart;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.Chart;
import java.util.List;

/* compiled from: ChartModule */
public interface C2164b {

    /* compiled from: ChartModule */
    public interface C2161a extends C1945a<Chart> {
        void mo3417g();
    }

    /* compiled from: ChartModule */
    public interface C2163b extends C1945a<List<Chart>> {
        void f_();
    }

    Fragment mo3478a();

    String mo3479a(Uri uri);

    void mo3480a(Context context);

    void mo3481a(Chart chart, C2161a c2161a, CsfdDataProvider c2016c);

    void mo3482a(C2163b c2163b, CsfdDataProvider c2016c);

    void mo3483b();

    void mo3484c();
}
