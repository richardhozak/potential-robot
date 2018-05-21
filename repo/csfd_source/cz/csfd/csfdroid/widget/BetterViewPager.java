package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BetterViewPager extends ViewPager {
    public BetterViewPager(Context context) {
        super(context, null);
    }

    public BetterViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view == this || !(view instanceof ViewPager)) {
            return super.canScroll(view, z, i, i2, i3);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter adapter = getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            if (count != 0) {
                if (adapter.getPageWidth(0) * ((float) count) < 1.0f) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
