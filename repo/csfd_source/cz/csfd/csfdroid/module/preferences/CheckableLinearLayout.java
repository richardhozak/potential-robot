package cz.csfd.csfdroid.module.preferences;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout implements Checkable {
    private Checkable f5999a;

    public CheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5999a = (Checkable) getChildAt(1);
    }

    public boolean isChecked() {
        return this.f5999a.isChecked();
    }

    public void setChecked(boolean z) {
        this.f5999a.setChecked(z);
    }

    public void toggle() {
        this.f5999a.toggle();
    }
}
