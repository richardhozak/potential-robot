package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import cz.csfd.csfdroid.CsfdApplication;

public class ConfigurableSizeButton extends Button {
    private float f6357a = 1.0f;

    public ConfigurableSizeButton(Context context) {
        super(context);
        m9424a(context);
    }

    public ConfigurableSizeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9424a(context);
    }

    public ConfigurableSizeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9424a(context);
    }

    private void m9424a(Context context) {
        float textSize = getTextSize();
        m9425b(context);
        setTextSize(0, textSize);
    }

    private void m9425b(Context context) {
        this.f6357a = ((CsfdApplication) context.getApplicationContext()).m6226n().m7210p();
    }

    public float getTextSize() {
        return super.getTextSize() / this.f6357a;
    }

    public void setTextSize(float f) {
        super.setTextSize(this.f6357a * f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, this.f6357a * f);
    }
}
