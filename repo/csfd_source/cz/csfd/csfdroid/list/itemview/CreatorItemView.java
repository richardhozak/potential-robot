package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2099g;

public class CreatorItemView extends RelativeLayout implements C2087b {
    private ImageView f5027a;
    private TextView f5028b;
    private TextView f5029c;
    private TextView f5030d;
    private TextView f5031e;
    private TextView f5032f;
    private TextView f5033g;
    private TextView f5034h;
    private C2057e f5035i;

    public CreatorItemView(Context context) {
        this(context, null);
    }

    public CreatorItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5035i = ((CsfdApplication) context.getApplicationContext()).m6226n();
    }

    public void mo3428b() {
        this.f5027a = (ImageView) findViewById(R.id.creator_item_photo);
        this.f5028b = (TextView) findViewById(R.id.creator_item_name);
        this.f5029c = (TextView) findViewById(R.id.creator_item_birth_date);
        this.f5030d = (TextView) findViewById(R.id.creator_item_birth_date_label);
        this.f5031e = (TextView) findViewById(R.id.creator_item_birth_place);
        this.f5032f = (TextView) findViewById(R.id.creator_item_death_date);
        this.f5033g = (TextView) findViewById(R.id.creator_item_death_date_label);
        this.f5034h = (TextView) findViewById(R.id.creator_item_death_place);
    }

    public void setObject(C2083a c2083a) {
        int i;
        int i2 = 8;
        C2099g c2099g = (C2099g) c2083a;
        if (this.f5035i.m7214t()) {
            String l = c2099g.m7388l();
            if (l.length() == 0) {
                this.f5027a.setImageResource(R.drawable.poster_free);
            } else {
                C1187t.m5432a(getContext()).m5439a(l).m5477a(this.f5027a);
            }
            this.f5027a.setVisibility(0);
        } else {
            this.f5027a.setVisibility(8);
        }
        this.f5028b.setText(c2099g.m7380d());
        Object f = c2099g.m7382f();
        this.f5029c.setText(f);
        if (f.length() == 0) {
            m7496b(this.f5029c, this.f5030d);
        } else {
            m7495a(this.f5029c, this.f5030d);
        }
        f = c2099g.m7383g();
        this.f5031e.setText(f);
        TextView textView = this.f5031e;
        if (f.length() == 0) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        f = c2099g.m7385i();
        this.f5032f.setText(f);
        if (f.length() == 0) {
            m7496b(this.f5032f, this.f5033g);
        } else {
            m7495a(this.f5032f, this.f5033g);
        }
        f = c2099g.m7386j();
        this.f5034h.setText(f);
        textView = this.f5034h;
        if (f.length() != 0) {
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    private void m7495a(TextView textView, TextView textView2) {
        textView.setVisibility(0);
        textView2.setVisibility(0);
    }

    private void m7496b(TextView textView, TextView textView2) {
        textView.setVisibility(8);
        textView2.setVisibility(8);
    }
}
