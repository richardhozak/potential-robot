package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2099g;

public class SimpleCreatorItemView extends RelativeLayout implements C2087b {
    private TextView f5085a;
    private TextView f5086b;
    private TextView f5087c;

    public SimpleCreatorItemView(Context context) {
        this(context, null);
    }

    public SimpleCreatorItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5085a = (TextView) findViewById(R.id.creator_item_name);
        this.f5086b = (TextView) findViewById(R.id.creator_item_year);
        this.f5087c = (TextView) findViewById(R.id.creator_item_additional);
    }

    public void setObject(C2083a c2083a) {
        C2099g c2099g = (C2099g) c2083a;
        this.f5085a.setText(c2099g.m7380d());
        String e = c2099g.m7381e();
        if (e.length() > 0) {
            this.f5086b.setText("(" + e + ")");
        } else {
            this.f5086b.setVisibility(8);
        }
        this.f5087c.setText(c2099g.m7387k());
    }
}
