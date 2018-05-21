package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2118z;

public class VideoItemView extends RelativeLayout implements C2087b {
    private TextView f5115a;
    private ImageView f5116b;
    private C1187t f5117c;
    private ViewGroup f5118d;
    private TextView f5119e;
    private TextView f5120f;
    private ImageView f5121g;

    public VideoItemView(Context context) {
        this(context, null);
    }

    public VideoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5117c = C1187t.m5432a(context);
    }

    public void mo3428b() {
        this.f5115a = (TextView) findViewById(R.id.video_item_name);
        this.f5116b = (ImageView) findViewById(R.id.video_item_thumbnail);
        this.f5118d = (ViewGroup) findViewById(R.id.movie_item_name_year);
        this.f5119e = (TextView) findViewById(R.id.movie_item_name);
        this.f5120f = (TextView) findViewById(R.id.movie_item_year);
        this.f5121g = (ImageView) findViewById(R.id.movie_item_color);
    }

    public void setObject(C2083a c2083a) {
        int i = 8;
        C2118z c2118z = (C2118z) c2083a;
        this.f5117c.m5439a(c2118z.m7476f().m7010a()).m5473a().m5482c().m5477a(this.f5116b);
        MovieInfo d = c2118z.m7474d();
        this.f5118d.setVisibility(d == null ? 8 : 0);
        ImageView imageView = this.f5121g;
        if (d != null) {
            i = 0;
        }
        imageView.setVisibility(i);
        if (d != null) {
            this.f5119e.setText(d.m6917a());
            this.f5120f.setText("(" + d.m6965j() + ")");
            this.f5121g.setImageResource(d.ab());
        }
        this.f5115a.setText(c2118z.m7475e());
        if (d == null) {
            this.f5115a.setTextColor(getResources().getColor(R.color.list_item_primary));
        }
    }
}
