package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2103k;

public class EpisodeItemView extends RelativeLayout implements C2087b {
    private TextView f5036a;
    private TextView f5037b;
    private ImageView f5038c;

    public EpisodeItemView(Context context) {
        this(context, null);
    }

    public EpisodeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5036a = (TextView) findViewById(R.id.movie_item_name);
        this.f5037b = (TextView) findViewById(R.id.movie_item_code);
        this.f5038c = (ImageView) findViewById(R.id.movie_item_color);
    }

    public void setObject(C2083a c2083a) {
        C2103k c2103k = (C2103k) c2083a;
        this.f5036a.setText(c2103k.m7404d());
        this.f5037b.setText("(" + c2103k.m7405e() + ")");
        this.f5038c.setImageResource(c2103k.m7403c().m6794e());
    }
}
