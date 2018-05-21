package cz.csfd.csfdroid.gd.widget.p065a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.itemview.ProgressItemView;

/* compiled from: ProgressItem */
public class C2085b extends C2084c {
    public boolean f4894b;

    public C2085b() {
        this(null);
    }

    public C2085b(String str) {
        this(str, false);
    }

    public C2085b(String str, boolean z) {
        super(str);
        this.f4894b = z;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_progress, viewGroup);
    }

    public Class<?> mo3427b() {
        return ProgressItemView.class;
    }
}
