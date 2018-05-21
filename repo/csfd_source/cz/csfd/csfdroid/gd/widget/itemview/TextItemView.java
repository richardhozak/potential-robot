package cz.csfd.csfdroid.gd.widget.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.gd.widget.p065a.C2084c;

public class TextItemView extends TextView implements C2087b {
    public TextItemView(Context context) {
        this(context, null);
    }

    public TextItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo3428b() {
    }

    public void setObject(C2083a c2083a) {
        setText(((C2084c) c2083a).f4893c);
    }
}
