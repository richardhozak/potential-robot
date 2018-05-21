package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Season;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.SeasonItemView;
import cz.csfd.csfdroid.p061d.C1992n;

/* compiled from: SeasonListItem */
public class C2112t extends C2083a {
    private Season f4943b;
    private String f4944c;

    public C2112t(Season season) {
        this.f4943b = season;
        this.f4944c = C1992n.m6355a(season);
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_season, viewGroup);
    }

    public Season m7437c() {
        return this.f4943b;
    }

    public String m7438d() {
        return this.f4943b.m7026b();
    }

    public String m7439e() {
        return this.f4943b.m7034f();
    }

    public String m7440f() {
        return this.f4944c;
    }

    public String m7441g() {
        return this.f4943b.m7033e();
    }

    public Class<?> mo3427b() {
        return SeasonItemView.class;
    }
}
