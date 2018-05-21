package cz.csfd.csfdroid.module.preferences;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.view.View;
import cz.csfd.csfdroid.R;

public class DragGripView extends View {
    private static final int[] f6000a = new int[]{16842927, 16843173};
    private int f6001b;
    private int f6002c;
    private Paint f6003d;
    private float f6004e;
    private float f6005f;
    private int f6006g;
    private int f6007h;

    public DragGripView(Context context) {
        this(context, null, 0);
    }

    public DragGripView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragGripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6001b = GravityCompat.START;
        this.f6002c = 858993459;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6000a);
        this.f6001b = obtainStyledAttributes.getInteger(0, this.f6001b);
        this.f6002c = obtainStyledAttributes.getColor(1, this.f6002c);
        obtainStyledAttributes.recycle();
        Resources resources = getResources();
        this.f6004e = (float) resources.getDimensionPixelSize(R.dimen.drag_grip_ridge_size);
        this.f6005f = (float) resources.getDimensionPixelSize(R.dimen.drag_grip_ridge_gap);
        this.f6003d = new Paint();
        this.f6003d.setColor(this.f6002c);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize((((int) ((2.0f * (this.f6004e + this.f6005f)) - this.f6005f)) + getPaddingLeft()) + getPaddingRight(), i), View.resolveSize((int) this.f6004e, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float paddingLeft = ((float) getPaddingLeft()) + ((((float) ((this.f6006g - getPaddingLeft()) - getPaddingRight())) - (((this.f6004e + this.f6005f) * 2.0f) - this.f6005f)) / 2.0f);
        int paddingTop = (int) ((((float) ((this.f6007h - getPaddingTop()) - getPaddingBottom())) + this.f6005f) / (this.f6004e + this.f6005f));
        float paddingTop2 = ((float) getPaddingTop()) + ((((float) ((this.f6007h - getPaddingTop()) - getPaddingBottom())) - ((((float) paddingTop) * (this.f6004e + this.f6005f)) - this.f6005f)) / 2.0f);
        for (int i = 0; i < paddingTop; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                Canvas canvas2 = canvas;
                canvas2.drawRect(paddingLeft + (((float) i2) * (this.f6004e + this.f6005f)), paddingTop2 + (((float) i) * (this.f6004e + this.f6005f)), this.f6004e + ((((float) i2) * (this.f6004e + this.f6005f)) + paddingLeft), this.f6004e + ((((float) i) * (this.f6004e + this.f6005f)) + paddingTop2), this.f6003d);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6007h = i2;
        this.f6006g = i;
    }
}
