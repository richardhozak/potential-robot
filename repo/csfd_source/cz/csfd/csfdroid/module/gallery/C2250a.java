package cz.csfd.csfdroid.module.gallery;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.p061d.C1983f;
import java.util.List;

/* compiled from: GalleryAdapter */
public class C2250a extends PagerAdapter {
    private List<Photo> f5509a;
    private LayoutInflater f5510b;
    private C1187t f5511c;

    public C2250a(List<Photo> list, Context context) {
        this.f5509a = list;
        this.f5510b = LayoutInflater.from(context);
        this.f5511c = ((CsfdApplication) context.getApplicationContext()).m6232t();
    }

    public int getCount() {
        return this.f5509a.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C1983f.m6333a("GalleryAdapter", "getView " + i);
        RelativeLayout relativeLayout = (RelativeLayout) this.f5510b.inflate(R.layout.gallery_fullscreen_item, viewGroup, false);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.gallery_fullscreen_item_picture);
        this.f5511c.m5438a(Uri.parse(((Photo) this.f5509a.get(i)).m7010a())).m5477a(imageView);
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    public void startUpdate(ViewGroup viewGroup) {
        super.startUpdate(viewGroup);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        super.finishUpdate(viewGroup);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
