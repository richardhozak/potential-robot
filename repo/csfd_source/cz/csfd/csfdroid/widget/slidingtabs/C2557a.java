package cz.csfd.csfdroid.widget.slidingtabs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout.C2554c;

/* compiled from: SlidingTabStrip */
class C2557a extends LinearLayout {
    private final int f6405a;
    private final Paint f6406b;
    private final int f6407c;
    private final Paint f6408d;
    private final int f6409e;
    private final Paint f6410f;
    private final float f6411g;
    private int f6412h;
    private float f6413i;
    private C2554c f6414j;
    private final C2556a f6415k;

    /* compiled from: SlidingTabStrip */
    private static class C2556a implements C2554c {
        private int[] f6403a;
        private int[] f6404b;

        private C2556a() {
        }

        public final int mo3688a(int i) {
            return this.f6403a[i % this.f6403a.length];
        }

        public final int mo3689b(int i) {
            return this.f6404b[i % this.f6404b.length];
        }

        void m9471a(int... iArr) {
            this.f6403a = iArr;
        }

        void m9473b(int... iArr) {
            this.f6404b = iArr;
        }
    }

    C2557a(Context context) {
        this(context, null);
    }

    C2557a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        this.f6409e = C2557a.m9474a(typedValue.data, (byte) 0);
        this.f6415k = new C2556a();
        this.f6415k.m9471a(-1);
        this.f6415k.m9473b(C2557a.m9474a(r1, (byte) 32));
        this.f6405a = (int) (2.0f * f);
        this.f6406b = new Paint();
        this.f6406b.setColor(this.f6409e);
        this.f6407c = (int) (5.0f * f);
        this.f6408d = new Paint();
        this.f6411g = 0.5f;
        this.f6410f = new Paint();
        this.f6410f.setStrokeWidth((float) ((int) (f * 1.0f)));
    }

    void m9478a(C2554c c2554c) {
        this.f6414j = c2554c;
        invalidate();
    }

    void m9479a(int... iArr) {
        this.f6414j = null;
        this.f6415k.m9471a(iArr);
        invalidate();
    }

    void m9480b(int... iArr) {
        this.f6414j = null;
        this.f6415k.m9473b(iArr);
        invalidate();
    }

    void m9477a(int i, float f) {
        this.f6412h = i;
        this.f6413i = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        int min = (int) (Math.min(Math.max(0.0f, this.f6411g), 1.0f) * ((float) height));
        if (this.f6414j != null) {
            C2554c c2554c = this.f6414j;
        } else {
            Object obj = this.f6415k;
        }
        if (childCount > 0) {
            int i;
            m9476a();
            View childAt = getChildAt(this.f6412h);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int a = c2554c.mo3688a(this.f6412h);
            if (this.f6413i <= 0.0f || this.f6412h >= getChildCount() - 1) {
                i = right;
                right = left;
            } else {
                i = c2554c.mo3688a(this.f6412h + 1);
                if (a != i) {
                    a = C2557a.m9475a(i, a, this.f6413i);
                }
                View childAt2 = getChildAt(this.f6412h + 1);
                left = (int) ((((float) left) * (1.0f - this.f6413i)) + (this.f6413i * ((float) childAt2.getLeft())));
                i = (int) ((((float) right) * (1.0f - this.f6413i)) + (((float) childAt2.getRight()) * this.f6413i));
                right = left;
            }
            this.f6408d.setColor(a);
            canvas.drawRect((float) right, (float) (height - this.f6407c), (float) i, (float) height, this.f6408d);
        }
        canvas.drawRect(0.0f, (float) (height - this.f6405a), (float) getWidth(), (float) height, this.f6406b);
        int i2 = (height - min) / 2;
        for (height = 0; height < childCount - 1; height++) {
            childAt = getChildAt(height);
            this.f6410f.setColor(c2554c.mo3689b(height));
            canvas.drawLine((float) childAt.getRight(), (float) i2, (float) childAt.getRight(), (float) (i2 + min), this.f6410f);
        }
    }

    private void m9476a() {
        for (int i = 0; i < getChildCount(); i++) {
            boolean z;
            View childAt = getChildAt(i);
            if (i == this.f6412h) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }

    private static int m9474a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int m9475a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }
}
