package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.VideoItemView;

/* compiled from: VideoListItem */
public class C2118z extends C2083a {
    private MovieVideo f4955b;
    private int f4956c = R.layout.list_item_video;

    public C2118z(MovieVideo movieVideo) {
        this.f4955b = movieVideo;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4956c, viewGroup);
    }

    public MovieVideo m7473c() {
        return this.f4955b;
    }

    public MovieInfo m7474d() {
        return this.f4955b.m7007e();
    }

    public String m7475e() {
        if (this.f4955b.m7001a().length() > 0) {
            return this.f4955b.m7001a();
        }
        return "";
    }

    public Photo m7476f() {
        return this.f4955b.m7006d();
    }

    public Class<?> mo3427b() {
        return VideoItemView.class;
    }
}
