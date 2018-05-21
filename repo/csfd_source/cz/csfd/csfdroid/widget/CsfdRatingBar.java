package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RatingBar;

public class CsfdRatingBar extends RatingBar {
    private C2310a f6359a;
    private float f6360b;
    private boolean f6361c;
    private int f6362d;
    private int f6363e;

    public interface C2310a {
        void mo3562a(RatingBar ratingBar, float f);
    }

    public CsfdRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CsfdRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CsfdRatingBar(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float rating = getRating();
        switch (motionEvent.getAction()) {
            case 0:
                this.f6360b = getRating();
                this.f6361c = false;
                setPressed(true);
                break;
        }
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!(getRating() != this.f6360b || this.f6361c || this.f6359a == null)) {
                    this.f6359a.mo3562a(this, getRating());
                }
                setPressed(false);
                break;
            case 2:
                if (getRating() != rating) {
                    this.f6361c = true;
                    break;
                }
                break;
        }
        return true;
    }

    public void setOnRatingBarNoChangeListener(C2310a c2310a) {
        this.f6359a = c2310a;
    }

    public void draw(Canvas canvas) {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
            layerDrawable.setBounds(0, 0, this.f6362d, this.f6363e);
            findDrawableByLayerId.setBounds(0, 0, this.f6362d, this.f6363e);
        }
        super.draw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6362d = (getWidth() - getPaddingRight()) - getPaddingLeft();
        this.f6363e = (getHeight() - getPaddingBottom()) - getPaddingTop();
    }
}
