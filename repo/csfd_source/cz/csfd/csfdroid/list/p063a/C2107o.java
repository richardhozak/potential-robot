package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.MessageItemView;
import cz.csfd.csfdroid.p061d.C1982e;

/* compiled from: MessageListItem */
public class C2107o extends C2083a {
    private Message f4938b;

    public C2107o(Message message) {
        this.f4938b = message;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_message, viewGroup);
    }

    public Message m7423c() {
        return this.f4938b;
    }

    public String m7424d() {
        return C1982e.m6330a(this.f4938b.m6840d());
    }

    public Class<?> mo3427b() {
        return MessageItemView.class;
    }
}
