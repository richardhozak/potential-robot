package cz.csfd.csfdroid.module.chart;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class ChartsActivity extends C2157b {
    protected Fragment mo3474q() {
        Fragment c2170d = new C2170d();
        Uri data = getIntent().getData();
        if (data != null) {
            String a = m6292m().m6219g().mo3458h().mo3479a(data);
            if (a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("chart", a);
                c2170d.setArguments(bundle);
            }
        }
        return c2170d;
    }

    protected C2254b mo3475r() {
        return C2254b.CHARTS;
    }

    public String mo3436p() {
        return "/charts";
    }
}
