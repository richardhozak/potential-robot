package cz.csfd.csfdroid.gd.widget.p065a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.itemview.TextItemView;

/* compiled from: TextItem */
public class C2084c extends C2083a {
    public String f4893c;

    public C2084c(String str) {
        this.f4893c = str;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_text, viewGroup);
    }

    public Class<?> mo3427b() {
        return TextItemView.class;
    }
}
