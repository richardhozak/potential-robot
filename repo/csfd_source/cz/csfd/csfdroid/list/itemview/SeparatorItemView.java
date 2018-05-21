package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.p061d.C1989k;

public class SeparatorItemView extends RelativeLayout implements C2087b {
    private TextView f5082a;
    private TextView f5083b;
    private ImageView f5084c;

    public SeparatorItemView(Context context) {
        this(context, null);
    }

    public SeparatorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeparatorItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo3428b() {
        this.f5082a = (TextView) findViewById(R.id.separator_title_bold);
        this.f5083b = (TextView) findViewById(R.id.separator_title);
        this.f5084c = (ImageView) findViewById(R.id.separator_arrow);
        if (VERSION.SDK_INT < 16) {
            C1989k.m6343a(getContext(), this.f5083b);
        }
    }

    public void setObject(C2083a c2083a) {
        int i;
        C2101i c2101i = (C2101i) c2083a;
        this.f5082a.setText(c2101i.f4925b);
        this.f5083b.setText(c2101i.f4926c);
        this.f5084c.setVisibility(c2101i.m7398d() ? 0 : 8);
        int color = getResources().getColor(R.color.text_color_primary);
        int color2 = getResources().getColor(R.color.text_color_primary_transparent);
        TextView textView = this.f5082a;
        if (c2101i.f4927d) {
            i = color;
        } else {
            i = color2;
        }
        textView.setTextColor(i);
        TextView textView2 = this.f5083b;
        if (!c2101i.f4927d) {
            color = color2;
        }
        textView2.setTextColor(color);
    }
}
