package cz.csfd.csfdroid.widget.slidingtabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.C2090h.C2089a;

public class SlidingTabLayout extends HorizontalScrollView {
    private boolean f6392a;
    private boolean f6393b;
    private float f6394c;
    private ColorStateList f6395d;
    private int f6396e;
    private int f6397f;
    private int f6398g;
    private int f6399h;
    private ViewPager f6400i;
    private OnPageChangeListener f6401j;
    private final C2557a f6402k;

    private class C2552a implements OnPageChangeListener {
        final /* synthetic */ SlidingTabLayout f6389a;
        private int f6390b;

        private C2552a(SlidingTabLayout slidingTabLayout) {
            this.f6389a = slidingTabLayout;
        }

        public void onPageScrolled(int i, float f, int i2) {
            int childCount = this.f6389a.f6402k.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                this.f6389a.f6402k.m9477a(i, f);
                View childAt = this.f6389a.f6402k.getChildAt(i);
                this.f6389a.m9461a(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                if (this.f6389a.f6401j != null) {
                    this.f6389a.f6401j.onPageScrolled(i, f, i2);
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            this.f6390b = i;
            if (this.f6389a.f6401j != null) {
                this.f6389a.f6401j.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            if (this.f6390b == 0) {
                this.f6389a.f6402k.m9477a(i, 0.0f);
                this.f6389a.m9461a(i, 0);
            }
            if (this.f6389a.f6401j != null) {
                this.f6389a.f6401j.onPageSelected(i);
            }
        }
    }

    private class C2553b implements OnClickListener {
        final /* synthetic */ SlidingTabLayout f6391a;

        private C2553b(SlidingTabLayout slidingTabLayout) {
            this.f6391a = slidingTabLayout;
        }

        public void onClick(View view) {
            for (int i = 0; i < this.f6391a.f6402k.getChildCount(); i++) {
                if (view == this.f6391a.f6402k.getChildAt(i)) {
                    this.f6391a.f6400i.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    public interface C2554c {
        int mo3688a(int i);

        int mo3689b(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f6397f = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.f6402k = new C2557a(context);
        addView(this.f6402k, -1, -2);
        m9462a(attributeSet, context);
    }

    private void m9462a(AttributeSet attributeSet, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2089a.SlidingTabLayout);
        this.f6396e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6393b = obtainStyledAttributes.getBoolean(5, false);
        Log.d("SlidingTabLayout", "fill width? " + this.f6393b);
        this.f6394c = (float) obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.f6395d = obtainStyledAttributes.getColorStateList(1);
        int color = obtainStyledAttributes.getColor(3, -1);
        this.f6402k.m9479a(color);
    }

    public void setTabsOffset(int i) {
        this.f6396e = i;
    }

    public int getTabsOffset() {
        return this.f6396e;
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f6395d = colorStateList;
    }

    public ColorStateList getTextColor() {
        return this.f6395d;
    }

    public void setCustomTabColorizer(C2554c c2554c) {
        this.f6402k.m9478a(c2554c);
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f6402k.m9479a(iArr);
    }

    public void setDividerColors(int... iArr) {
        this.f6402k.m9480b(iArr);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6401j = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f6402k.removeAllViews();
        this.f6400i = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new C2552a());
            m9466c();
        }
    }

    public void m9468a() {
        setViewPager(this.f6400i);
    }

    protected TextView m9467a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(0, this.f6394c);
        if (this.f6395d != null) {
            textView.setTextColor(this.f6395d);
        }
        if (VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(this.f6392a);
        }
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        int i2 = (int) (14.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i2, i, i2);
        return textView;
    }

    private void m9466c() {
        PagerAdapter adapter = this.f6400i.getAdapter();
        OnClickListener c2553b = new C2553b();
        if (this.f6393b) {
            this.f6402k.setWeightSum((float) adapter.getCount());
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            View inflate;
            TextView textView;
            if (this.f6398g != 0) {
                inflate = LayoutInflater.from(getContext()).inflate(this.f6398g, this.f6402k, false);
                textView = (TextView) inflate.findViewById(this.f6399h);
            } else {
                textView = null;
                inflate = null;
            }
            if (inflate == null) {
                inflate = m9467a(getContext());
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = (TextView) inflate;
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i == 0) {
                layoutParams.leftMargin = this.f6396e;
            } else if (i == adapter.getCount() - 1) {
                layoutParams.rightMargin = this.f6396e;
            }
            if (this.f6393b) {
                layoutParams.weight = 1.0f;
            }
            inflate.setLayoutParams(layoutParams);
            textView.setText(adapter.getPageTitle(i));
            inflate.setOnClickListener(c2553b);
            this.f6402k.addView(inflate);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6400i != null) {
            m9461a(this.f6400i.getCurrentItem(), 0);
        }
    }

    private void m9461a(int i, int i2) {
        int childCount = this.f6402k.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            View childAt = this.f6402k.getChildAt(i);
            if (childAt != null) {
                childCount = (childAt.getLeft() + i2) - this.f6396e;
                if (i > 0 || i2 > 0) {
                    childCount -= this.f6397f;
                }
                scrollTo(childCount, 0);
            }
        }
    }

    public void m9469b() {
        int currentItem = this.f6400i.getCurrentItem();
        this.f6402k.m9477a(currentItem, 0.0f);
        m9461a(currentItem, 0);
    }
}
