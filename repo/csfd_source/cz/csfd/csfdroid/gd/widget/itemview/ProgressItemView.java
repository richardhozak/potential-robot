package cz.csfd.csfdroid.gd.widget.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.gd.widget.p065a.C2085b;

public class ProgressItemView extends FrameLayout implements C2087b {
    private ProgressBar f4900a;
    private TextView f4901b;

    public ProgressItemView(Context context) {
        this(context, null);
    }

    public ProgressItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo3428b() {
        this.f4900a = (ProgressBar) findViewById(R.id.gd_progress_bar);
        this.f4901b = (TextView) findViewById(R.id.gd_text);
    }

    public void setObject(C2083a c2083a) {
        C2085b c2085b = (C2085b) c2083a;
        this.f4900a.setVisibility(c2085b.f4894b ? 0 : 8);
        this.f4901b.setText(c2085b.c);
    }
}
