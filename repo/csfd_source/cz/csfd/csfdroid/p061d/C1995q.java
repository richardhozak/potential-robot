package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.widget.BaseAdapter;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;

/* compiled from: PosterVisibilityHelper */
public class C1995q {
    private C2057e f4483a;
    private boolean f4484b = this.f4483a.m7214t();

    public C1995q(Context context) {
        this.f4483a = ((CsfdApplication) context.getApplicationContext()).m6226n();
    }

    public void m6362a(BaseAdapter baseAdapter) {
        if (this.f4483a.m7214t() != this.f4484b) {
            if (baseAdapter != null) {
                baseAdapter.notifyDataSetChanged();
            }
            this.f4484b = this.f4483a.m7214t();
        }
    }
}
