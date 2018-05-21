package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2116x;
import cz.csfd.csfdroid.p061d.C1978a;

public class UserItemView extends RelativeLayout implements C2087b {
    private ImageView f5108a;
    private TextView f5109b;
    private TextView f5110c;

    public UserItemView(Context context) {
        this(context, null);
    }

    public UserItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5108a = (ImageView) findViewById(R.id.user_item_avatar);
        this.f5109b = (TextView) findViewById(R.id.user_item_nick);
        this.f5110c = (TextView) findViewById(R.id.user_item_name);
    }

    public void setObject(C2083a c2083a) {
        int i = 0;
        C2116x c2116x = (C2116x) c2083a;
        String e = c2116x.m7465e();
        if (TextUtils.isEmpty(e)) {
            this.f5108a.setImageResource(R.drawable.avatar_circle);
        } else {
            C1187t.m5432a(getContext()).m5439a(e).m5476a(new C1978a()).m5477a(this.f5108a);
        }
        this.f5108a.setVisibility(0);
        this.f5109b.setText(c2116x.m7464d());
        this.f5110c.setText(c2116x.m7463c().m6814c());
        TextView textView = this.f5110c;
        if (TextUtils.isEmpty(c2116x.m7463c().m6814c())) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
