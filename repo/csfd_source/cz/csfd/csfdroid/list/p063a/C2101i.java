package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.SeparatorItemView;

/* compiled from: CsfdSeparatorItem */
public class C2101i extends C2083a {
    public String f4925b;
    public String f4926c;
    public boolean f4927d;
    private String f4928e;
    private boolean f4929f;

    public C2101i(String str) {
        m7392b(str);
    }

    public C2101i(String str, boolean z) {
        m7392b(str);
        this.f4927d = z;
    }

    public C2101i(String str, String str2) {
        this.f4925b = str;
        this.f4926c = str2;
    }

    public void m7394a(String str) {
        this.f4928e = str;
    }

    public String m7397c() {
        return this.f4928e;
    }

    public void m7395a(boolean z) {
        this.f4929f = z;
    }

    public boolean m7398d() {
        return this.f4929f;
    }

    private void m7392b(String str) {
        String[] split = str.split(" ", 2);
        if (split.length == 1) {
            this.f4925b = split[0];
        } else if (split[0].length() > 2) {
            this.f4925b = split[0];
            this.f4926c = split[1];
        } else {
            split = str.split(" ", 3);
            this.f4925b = split[0] + " " + split[1];
            if (split.length > 2) {
                this.f4926c = split[2];
            }
        }
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_separator, viewGroup);
    }

    public Class<?> mo3427b() {
        return SeparatorItemView.class;
    }
}
