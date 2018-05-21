package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.C2090h.C2089a;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.p061d.C1989k;

public class SideNavigationRow extends LinearLayout {
    private int f6380a;
    private int f6381b;
    private ImageView f6382c;
    private TextView f6383d;
    private TextView f6384e;
    private int f6385f;

    public SideNavigationRow(Context context) {
        this(context, null);
    }

    public SideNavigationRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9455a(attributeSet, 0);
    }

    public SideNavigationRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9455a(attributeSet, i);
    }

    public void setCount(int i) {
        this.f6385f = i;
        m9454a();
    }

    private void m9455a(AttributeSet attributeSet, int i) {
        setClickable(true);
        setFocusable(true);
        setDescendantFocusability(393216);
        setBackgroundResource(R.drawable.xml_bg_list_selector_transparent);
        setGravity(16);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.style.Theme.Csfd, new int[]{R.attr.itemViewPreferredHeight});
        setMinimumHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2089a.SideNavigationRow, i, 0);
        this.f6380a = obtainStyledAttributes.getResourceId(0, 0);
        this.f6381b = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.side_navigation_item, this);
        this.f6382c = (ImageView) findViewById(R.id.side_navigation_item_icon);
        this.f6383d = (TextView) findViewById(R.id.side_navigation_item_title);
        this.f6384e = (TextView) findViewById(R.id.side_navigation_item_count);
        this.f6382c.setImageResource(this.f6380a);
        this.f6383d.setText(this.f6381b);
        C1989k.m6343a(getContext(), this.f6383d);
        this.f6382c.setVisibility(8);
        m9454a();
    }

    private void m9454a() {
        this.f6384e.setText(String.valueOf(this.f6385f));
        this.f6384e.setVisibility(this.f6385f > 0 ? 0 : 8);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            C1989k.m6344b(getContext(), this.f6383d);
        } else {
            C1989k.m6343a(getContext(), this.f6383d);
        }
    }
}
