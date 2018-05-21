package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import cz.csfd.csfdroid.CsfdApplication;

public class ConfigurableSizeTextView extends TextView {
    private float f6358a = 1.0f;

    public ConfigurableSizeTextView(Context context) {
        super(context);
        m9426a(context);
    }

    public ConfigurableSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9426a(context);
    }

    public ConfigurableSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9426a(context);
    }

    private void m9426a(Context context) {
        if (!isInEditMode()) {
            float textSize = getTextSize();
            m9427b(context);
            setTextSize(0, textSize);
        }
    }

    private void m9427b(Context context) {
        this.f6358a = ((CsfdApplication) context.getApplicationContext()).m6226n().m7210p();
    }

    public float getTextSize() {
        return super.getTextSize() / this.f6358a;
    }

    public void setTextSize(float f) {
        super.setTextSize(this.f6358a * f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, this.f6358a * f);
    }
}
