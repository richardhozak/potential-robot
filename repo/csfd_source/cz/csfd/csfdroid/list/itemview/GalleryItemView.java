package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2104l;

public class GalleryItemView extends FrameLayout implements C2087b {
    private ImageView f5039a;
    private C1187t f5040b;

    public GalleryItemView(Context context) {
        this(context, null);
    }

    public GalleryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5040b = C1187t.m5432a(context);
    }

    public void mo3428b() {
        this.f5039a = (ImageView) findViewById(R.id.gallery_item_picture);
    }

    public void setObject(C2083a c2083a) {
        int i;
        C2104l c2104l = (C2104l) c2083a;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        if (c2104l.m7409d() > c2104l.m7410e()) {
            i = i2;
            i2 = (int) ((((float) c2104l.m7410e()) / ((float) c2104l.m7409d())) * ((float) i2));
        } else {
            i2 = (int) (((double) i2) * 0.8d);
            i = (int) ((((float) c2104l.m7409d()) / ((float) c2104l.m7410e())) * ((float) i2));
        }
        LayoutParams layoutParams = this.f5039a.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f5039a.setLayoutParams(layoutParams);
        this.f5040b.m5439a(c2104l.m7408c()).m5481b(i, i2).m5477a(this.f5039a);
    }
}
