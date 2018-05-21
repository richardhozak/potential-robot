package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.ProgressItemView;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2105m;

public class ListenableProgressItemView extends ProgressItemView {
    private View f5041a;
    private View f5042b;
    private Button f5043c;

    public ListenableProgressItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ListenableProgressItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListenableProgressItemView(Context context) {
        super(context);
    }

    public void mo3428b() {
        super.mo3428b();
        this.f5041a = findViewById(R.id.progress_item_progress);
        this.f5042b = findViewById(R.id.progress_item_error);
        this.f5043c = (Button) findViewById(R.id.progress_item_error_button);
    }

    public void setObject(C2083a c2083a) {
        super.setObject(c2083a);
        C2105m c2105m = (C2105m) c2083a;
        c2105m.m7414a(this);
        c2105m.m7416c();
    }

    public void setProgressVisibility(boolean z) {
        this.f5041a.setVisibility(z ? 0 : 8);
    }

    public void setNoConnectionVisibility(boolean z) {
        this.f5042b.setVisibility(z ? 0 : 8);
    }

    public void setButtonListener(OnClickListener onClickListener) {
        this.f5043c.setOnClickListener(onClickListener);
    }
}
