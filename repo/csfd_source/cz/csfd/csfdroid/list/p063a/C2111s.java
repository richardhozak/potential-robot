package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.NewVideosItemView;
import java.util.List;

/* compiled from: NewVideosListItem */
public class C2111s extends C2083a {
    private List<MovieInfo> f4940b;
    private C2110a f4941c;
    private int f4942d;

    /* compiled from: NewVideosListItem */
    public interface C2110a {
        void setOverridingTouchTarget(View view);
    }

    public C2111s(List<MovieInfo> list, C2110a c2110a) {
        this.f4940b = list;
        this.f4941c = c2110a;
    }

    public List<MovieInfo> m7433c() {
        return this.f4940b;
    }

    public C2110a m7434d() {
        return this.f4941c;
    }

    public void m7431a(int i) {
        this.f4942d = i;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_new_videos, viewGroup);
    }

    public Class<?> mo3427b() {
        return NewVideosItemView.class;
    }
}
