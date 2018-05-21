package cz.csfd.csfdroid.p060c;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.p039b.p040a.C0951a;
import com.p039b.p040a.C0952b;
import com.p039b.p040a.C0970j;
import com.p039b.p040a.C0970j.C0969b;

/* compiled from: HeightAnimator */
public class C1968a extends C0970j {
    private final C0952b f4457h;

    public C1968a(final View view, int i) {
        m4240a(view.getMeasuredHeight(), i);
        m4239a(new C0969b(this) {
            final /* synthetic */ C1968a f4454b;

            public void mo3336a(C0970j c0970j) {
                view.getLayoutParams().height = ((Integer) c0970j.m4247e()).intValue();
                view.requestLayout();
            }
        });
        this.f4457h = new C0952b(this) {
            final /* synthetic */ C1968a f4456b;

            public void mo1859a(C0951a c0951a) {
                view.setClickable(false);
            }

            public void mo1860b(C0951a c0951a) {
                view.setClickable(true);
            }
        };
    }

    public void mo3337a(boolean z) {
        if (z) {
            m4174b(this.f4457h);
        } else {
            m4172a(this.f4457h);
        }
    }

    public static C1968a m6298a(View view, int i) {
        C1968a c1968a = new C1968a(view, i);
        c1968a.m4238a(new AccelerateInterpolator());
        c1968a.m4235a((long) view.getContext().getResources().getInteger(17694721));
        c1968a.mo3337a(false);
        return c1968a;
    }

    public static C1968a m6299b(View view, int i) {
        C1968a c1968a = new C1968a(view, i);
        c1968a.m4238a(new DecelerateInterpolator());
        c1968a.m4235a((long) view.getContext().getResources().getInteger(17694720));
        c1968a.mo3337a(false);
        return c1968a;
    }
}
