package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2108p;
import cz.csfd.csfdroid.p061d.C1978a;

public class MessageThreadItemView extends RelativeLayout implements C2087b {
    private ImageView f5050a;
    private TextView f5051b;
    private TextView f5052c;
    private TextView f5053d;
    private TextView f5054e;

    public MessageThreadItemView(Context context) {
        this(context, null);
    }

    public MessageThreadItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5050a = (ImageView) findViewById(R.id.thread_item_avatar);
        this.f5051b = (TextView) findViewById(R.id.thread_item_nick);
        this.f5052c = (TextView) findViewById(R.id.thread_item_date);
        this.f5053d = (TextView) findViewById(R.id.thread_item_text);
        this.f5054e = (TextView) findViewById(R.id.thread_item_unread);
    }

    public void setObject(C2083a c2083a) {
        int c;
        int i;
        int i2 = 0;
        C2108p c2108p = (C2108p) c2083a;
        MessageThread c2 = c2108p.m7427c();
        User a = c2.m6843a();
        Message b = c2.m6846b();
        if (TextUtils.isEmpty(a.m6817d())) {
            C1187t.m5432a(getContext()).m5437a((int) R.drawable.avatar_circle).m5477a(this.f5050a);
        } else {
            C1187t.m5432a(getContext()).m5439a(a.m6817d()).m5476a(new C1978a()).m5474a((int) R.drawable.avatar_circle).m5477a(this.f5050a);
        }
        this.f5051b.setText(a.m6811b());
        this.f5052c.setText(c2108p.m7428d());
        String b2 = b.m6835b();
        if (a == c2.m6846b().m6842f()) {
            b2 = "➥ " + b2;
        }
        this.f5053d.setText(Html.fromHtml(b2));
        if (a == c2.m6846b().m6841e()) {
            c = c2.m6847c();
        } else {
            c = 0;
        }
        TextView textView = this.f5053d;
        if (c > 0) {
            i = 1;
        } else {
            i = 0;
        }
        textView.setTypeface(null, i);
        this.f5054e.setText(String.valueOf(c));
        TextView textView2 = this.f5054e;
        if (c <= 0) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
    }
}
