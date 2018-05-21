package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.TvStationItemView;

/* compiled from: TvStationListItem */
public class C2115w extends C2083a {
    protected TvStation f4951b;
    protected int f4952c = R.layout.list_item_tv_station;

    public C2115w(TvStation tvStation) {
        this.f4951b = tvStation;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4952c, viewGroup);
    }

    public TvStation m7460c() {
        return this.f4951b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2115w c2115w = (C2115w) obj;
        if (this.f4951b != null) {
            if (this.f4951b.equals(c2115w.f4951b)) {
                return true;
            }
        } else if (c2115w.f4951b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f4951b != null ? this.f4951b.hashCode() : 0;
    }

    public Class<?> mo3427b() {
        return TvStationItemView.class;
    }
}
