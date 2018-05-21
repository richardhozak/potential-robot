package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2095c;

public class ChartMovieItemView extends MovieItemView {
    private TextView f4987a;
    private ImageView f4988b;
    private TextView f4989c;
    private TextView f4990d;
    private TextView f4991e;

    public ChartMovieItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        super.mo3428b();
        this.f4987a = (TextView) findViewById(R.id.movie_item_position);
        this.f4988b = (ImageView) findViewById(R.id.movie_item_rating);
        this.f4989c = (TextView) findViewById(R.id.movie_item_garbage_rating);
        this.f4990d = (TextView) findViewById(R.id.movie_item_rating_average);
        this.f4991e = (TextView) findViewById(R.id.movie_item_rating_count);
    }

    public void setObject(C2083a c2083a) {
        super.setObject(c2083a);
        C2095c c2095c = (C2095c) c2083a;
        this.f4987a.setText(c2095c.m7346d());
        CommentItemView.m7491a(getContext(), c2095c.m7347e(), c2095c.m7345c().m6727b().m6908R(), this.f4988b, this.f4989c);
        this.f4990d.setText(c2095c.m7348f());
        if (c2095c.m7349g() > 0) {
            this.f4991e.setText(getResources().getString(R.string.chart_rating_count, new Object[]{Integer.valueOf(c2095c.m7349g())}));
        }
        if (c2095c.m7350h() > 0) {
            this.f4991e.setText(getResources().getString(R.string.chart_fanclub_count, new Object[]{Integer.valueOf(c2095c.m7350h())}));
        }
    }
}
