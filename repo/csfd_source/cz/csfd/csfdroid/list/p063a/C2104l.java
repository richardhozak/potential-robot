package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.GalleryItemView;

/* compiled from: GalleryListItem */
public class C2104l extends C2083a {
    private Photo f4931b;
    private int f4932c = R.layout.gallery_item;

    public C2104l(Photo photo) {
        this.f4931b = photo;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4932c, viewGroup);
    }

    public String m7408c() {
        return this.f4931b.m7017d();
    }

    public int m7409d() {
        return this.f4931b.m7018e();
    }

    public int m7410e() {
        return this.f4931b.m7019f();
    }

    public Class<?> mo3427b() {
        return GalleryItemView.class;
    }
}
