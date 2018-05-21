package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2106n;

public class MessageDateItemView extends RelativeLayout implements C2087b {
    private TextView f5044a;

    public MessageDateItemView(Context context) {
        this(context, null);
    }

    public MessageDateItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5044a = (TextView) findViewById(R.id.message_item_date);
    }

    public void setObject(C2083a c2083a) {
        this.f5044a.setText(((C2106n) c2083a).m7420c());
    }
}
