package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.MessageDateItemView;
import cz.csfd.csfdroid.p061d.C1982e;
import java.util.Date;

/* compiled from: MessageDateListItem */
public class C2106n extends C2083a {
    private Date f4937b;

    public C2106n(Date date) {
        this.f4937b = date;
        this.a = false;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_message_date, viewGroup);
    }

    public String m7420c() {
        return C1982e.m6332b(this.f4937b);
    }

    public Class<?> mo3427b() {
        return MessageDateItemView.class;
    }
}
