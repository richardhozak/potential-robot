package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.ActivityItemView;
import cz.csfd.csfdroid.p061d.C1982e;

/* compiled from: ActivityListItem */
public class C2092a extends C2083a {
    private ActivityEntity f4903b;

    public C2092a(ActivityEntity activityEntity) {
        this.f4903b = activityEntity;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_activity, viewGroup);
    }

    public ActivityEntity m7322c() {
        return this.f4903b;
    }

    public String m7323d() {
        return C1982e.m6330a(this.f4903b.m6714c());
    }

    public int m7324e() {
        switch (this.f4903b.m6717f().m6916Z()) {
            case RED:
                return R.drawable.movie_item_c1;
            case BLUE:
                return R.drawable.movie_item_c2;
            case BLACK:
                return R.drawable.movie_item_c3;
            default:
                return R.drawable.movie_item_c0;
        }
    }

    public Class<?> mo3427b() {
        return ActivityItemView.class;
    }
}
