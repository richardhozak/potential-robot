package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Episode;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.EpisodeItemView;

/* compiled from: EpisodeListItem */
public class C2103k extends C2083a {
    private Episode f4930b;

    public C2103k(Episode episode) {
        this.f4930b = episode;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_episode, viewGroup);
    }

    public Episode m7403c() {
        return this.f4930b;
    }

    public String m7404d() {
        return this.f4930b.m6788b();
    }

    public String m7405e() {
        return this.f4930b.m6793d();
    }

    public Class<?> mo3427b() {
        return EpisodeItemView.class;
    }
}
