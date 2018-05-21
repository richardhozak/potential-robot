package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.MessageThreadItemView;
import cz.csfd.csfdroid.p061d.C1982e;

/* compiled from: MessageThreadListItem */
public class C2108p extends C2083a {
    private MessageThread f4939b;

    public C2108p(MessageThread messageThread) {
        this.f4939b = messageThread;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_message_thread, viewGroup);
    }

    public MessageThread m7427c() {
        return this.f4939b;
    }

    public String m7428d() {
        return C1982e.m6332b(this.f4939b.m6846b().m6840d());
    }

    public Class<?> mo3427b() {
        return MessageThreadItemView.class;
    }
}
