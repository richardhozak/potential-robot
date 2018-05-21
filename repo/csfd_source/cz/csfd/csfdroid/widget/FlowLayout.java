package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import cz.csfd.csfdroid.C2090h.C2089a;

public class FlowLayout extends ViewGroup {
    private int f6370a = 0;
    private int f6371b = 0;
    private int f6372c = 0;
    private boolean f6373d = false;

    public static class C2547a extends LayoutParams {
        private static int f6364a = -1;
        private int f6365b;
        private int f6366c;
        private int f6367d = f6364a;
        private int f6368e = f6364a;
        private boolean f6369f = false;

        public C2547a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m9428a(context, attributeSet);
        }

        public C2547a(int i, int i2) {
            super(i, i2);
        }

        public C2547a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean m9435a() {
            return this.f6367d != f6364a;
        }

        public boolean m9436b() {
            return this.f6368e != f6364a;
        }

        public void m9434a(int i, int i2) {
            this.f6365b = i;
            this.f6366c = i2;
        }

        private void m9428a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2089a.FlowLayout_LayoutParams);
            try {
                this.f6367d = obtainStyledAttributes.getDimensionPixelSize(1, f6364a);
                this.f6368e = obtainStyledAttributes.getDimensionPixelSize(2, f6364a);
                this.f6369f = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m9442a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m9443a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m9444a(layoutParams);
    }

    public FlowLayout(Context context) {
        super(context);
        m9439a(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9439a(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9439a(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = (MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (this.f6372c == 0) {
            i3 = mode;
            i4 = size;
        } else {
            i3 = mode2;
            i4 = size2;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (i10 < childCount) {
            int i12;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i12 = i9;
            } else {
                int i13;
                i12 = MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? ExploreByTouchHelper.INVALID_ID : mode);
                if (mode2 == 1073741824) {
                    i11 = ExploreByTouchHelper.INVALID_ID;
                } else {
                    i11 = mode2;
                }
                childAt.measure(i12, MeasureSpec.makeMeasureSpec(size2, i11));
                C2547a c2547a = (C2547a) childAt.getLayoutParams();
                int b = m9441b(c2547a);
                i12 = m9437a(c2547a);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (this.f6372c == 0) {
                    i13 = measuredWidth;
                    measuredWidth = measuredHeight;
                } else {
                    i13 = measuredHeight;
                    int i14 = i12;
                    i12 = b;
                    b = i14;
                }
                i7 += i13;
                int i15 = i7 + b;
                Object obj = (c2547a.f6369f || (i3 != 0 && i7 > i4)) ? 1 : null;
                if (obj != null) {
                    i15 = measuredWidth;
                    i6 = measuredWidth + i12;
                    i7 = b + i13;
                    b = i8 + i5;
                    i8 = i13;
                } else {
                    b = i8;
                    i8 = i7;
                    i7 = i15;
                    i15 = i6;
                    i6 = i5;
                }
                i5 = Math.max(i6, i12 + measuredWidth);
                i6 = Math.max(i15, measuredWidth);
                if (this.f6372c == 0) {
                    measuredWidth = (getPaddingLeft() + i8) - i13;
                    i12 = getPaddingTop() + b;
                } else {
                    measuredWidth = getPaddingLeft() + b;
                    i12 = (getPaddingTop() + i8) - measuredHeight;
                }
                c2547a.m9434a(measuredWidth, i12);
                i12 = Math.max(i9, i8);
                i11 = b + i6;
                i8 = b;
            }
            i10++;
            i9 = i12;
        }
        if (this.f6372c == 0) {
            setMeasuredDimension(resolveSize(i9, i), resolveSize(i11, i2));
        } else {
            setMeasuredDimension(resolveSize(i11, i), resolveSize(i9, i2));
        }
    }

    private int m9437a(C2547a c2547a) {
        if (c2547a.m9436b()) {
            return c2547a.f6368e;
        }
        return this.f6371b;
    }

    private int m9441b(C2547a c2547a) {
        if (c2547a.m9435a()) {
            return c2547a.f6367d;
        }
        return this.f6370a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C2547a c2547a = (C2547a) childAt.getLayoutParams();
            childAt.layout(c2547a.f6365b, c2547a.f6366c, c2547a.f6365b + childAt.getMeasuredWidth(), c2547a.f6366c + childAt.getMeasuredHeight());
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        m9440a(canvas, view);
        return drawChild;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C2547a;
    }

    protected C2547a m9442a() {
        return new C2547a(-2, -2);
    }

    public C2547a m9443a(AttributeSet attributeSet) {
        return new C2547a(getContext(), attributeSet);
    }

    protected C2547a m9444a(LayoutParams layoutParams) {
        return new C2547a(layoutParams);
    }

    private void m9439a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2089a.FlowLayout);
        try {
            this.f6370a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f6371b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f6372c = obtainStyledAttributes.getInteger(2, 0);
            this.f6373d = obtainStyledAttributes.getBoolean(3, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m9440a(Canvas canvas, View view) {
        if (this.f6373d) {
            float right;
            float height;
            Paint a = m9438a((int) InputDeviceCompat.SOURCE_ANY);
            Paint a2 = m9438a(-16711936);
            Paint a3 = m9438a((int) SupportMenu.CATEGORY_MASK);
            C2547a c2547a = (C2547a) view.getLayoutParams();
            if (c2547a.f6367d > 0) {
                right = (float) view.getRight();
                height = (((float) view.getHeight()) / 2.0f) + ((float) view.getTop());
                canvas.drawLine(right, height, right + ((float) c2547a.f6367d), height, a);
                canvas.drawLine((((float) c2547a.f6367d) + right) - 4.0f, height - 4.0f, right + ((float) c2547a.f6367d), height, a);
                canvas.drawLine((((float) c2547a.f6367d) + right) - 4.0f, height + 4.0f, right + ((float) c2547a.f6367d), height, a);
            } else if (this.f6370a > 0) {
                float right2 = (float) view.getRight();
                float top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(right2, top, right2 + ((float) this.f6370a), top, a2);
                canvas.drawLine((((float) this.f6370a) + right2) - 4.0f, top - 4.0f, right2 + ((float) this.f6370a), top, a2);
                canvas.drawLine((((float) this.f6370a) + right2) - 4.0f, top + 4.0f, right2 + ((float) this.f6370a), top, a2);
            }
            if (c2547a.f6368e > 0) {
                right = (((float) view.getWidth()) / 2.0f) + ((float) view.getLeft());
                height = (float) view.getBottom();
                canvas.drawLine(right, height, right, height + ((float) c2547a.f6368e), a);
                canvas.drawLine(right - 4.0f, (((float) c2547a.f6368e) + height) - 4.0f, right, height + ((float) c2547a.f6368e), a);
                canvas.drawLine(right + 4.0f, (((float) c2547a.f6368e) + height) - 4.0f, right, height + ((float) c2547a.f6368e), a);
            } else if (this.f6371b > 0) {
                float left = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                float bottom = (float) view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + ((float) this.f6371b), a2);
                canvas.drawLine(left - 4.0f, (((float) this.f6371b) + bottom) - 4.0f, left, bottom + ((float) this.f6371b), a2);
                canvas.drawLine(left + 4.0f, (((float) this.f6371b) + bottom) - 4.0f, left, bottom + ((float) this.f6371b), a2);
            }
            if (!c2547a.f6369f) {
                return;
            }
            float top2;
            if (this.f6372c == 0) {
                right = (float) view.getLeft();
                top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(right, top2 - 6.0f, right, top2 + 6.0f, a3);
                return;
            }
            top2 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
            height = (float) view.getTop();
            canvas.drawLine(top2 - 6.0f, height, 6.0f + top2, height, a3);
        }
    }

    private Paint m9438a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }
}
