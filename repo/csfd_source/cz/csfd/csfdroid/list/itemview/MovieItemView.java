package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.p061d.C1992n;

public class MovieItemView extends RelativeLayout implements C2087b {
    private ImageView f4972a;
    private TextView f4973b;
    private TextView f4974c;
    private TextView f4975d;
    private TextView f4976e;
    private TextView f4977f;
    private TextView f4978g;
    private TextView f4979h;
    private View f4980i;
    private TextView f4981j;
    private TextView f4982k;
    private TextView f4983l;
    private ImageView f4984m;
    private C2057e f4985n;
    private C1187t f4986o;

    public MovieItemView(Context context) {
        this(context, null);
    }

    public MovieItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4985n = ((CsfdApplication) context.getApplicationContext()).m6226n();
        this.f4986o = C1187t.m5432a(getContext());
    }

    public void mo3428b() {
        this.f4972a = (ImageView) findViewById(R.id.movie_item_poster);
        this.f4973b = (TextView) findViewById(R.id.movie_item_name);
        this.f4974c = (TextView) findViewById(R.id.movie_item_year);
        this.f4975d = (TextView) findViewById(R.id.movie_item_search_name);
        this.f4976e = (TextView) findViewById(R.id.movie_item_genre);
        this.f4977f = (TextView) findViewById(R.id.movie_item_origin);
        this.f4978g = (TextView) findViewById(R.id.movie_item_type);
        this.f4979h = (TextView) findViewById(R.id.movie_item_type_genre);
        this.f4980i = findViewById(R.id.movie_item_tv_programm_container);
        this.f4981j = (TextView) findViewById(R.id.movie_item_tv_programm_time);
        this.f4982k = (TextView) findViewById(R.id.movie_item_tv_programm_station);
        this.f4983l = (TextView) findViewById(R.id.movie_item_release_date);
        this.f4984m = (ImageView) findViewById(R.id.movie_item_color);
    }

    public void setObject(C2083a c2083a) {
        String r;
        StringBuilder stringBuilder = new StringBuilder();
        C2094q c2094q = (C2094q) c2083a;
        if (this.f4985n.m7214t()) {
            this.f4972a.setImageResource(R.drawable.creator_photo_blank);
            this.f4986o.m5441a(this.f4972a);
            r = c2094q.m7341r();
            if (r.length() == 0) {
                this.f4972a.setImageResource(R.drawable.poster_free);
            } else {
                this.f4986o.m5439a(r).m5477a(this.f4972a);
            }
            this.f4972a.setVisibility(0);
        } else {
            this.f4972a.setVisibility(8);
        }
        this.f4973b.setText(c2094q.m7333j());
        if (c2094q.m7334k().length() > 0) {
            this.f4974c.setText(stringBuilder.append("(").append(c2094q.m7334k()).append(")").toString());
        } else {
            this.f4974c.setText("");
        }
        CharSequence m = c2094q.m7336m();
        if (m.length() > 0) {
            m = "(" + m + ")";
        }
        m7484a(m, this.f4975d);
        String q = c2094q.m7340q();
        if (q != null && q.length() > 1) {
            q = q.substring(0, 1).toUpperCase() + q.substring(1);
        }
        if (this.f4978g != null) {
            m7484a(q, this.f4978g);
        }
        r = c2094q.m7337n();
        if (r.length() > 0) {
            if (q.length() > 0) {
                q = q + ", " + r;
            } else {
                q = r;
            }
        }
        if (this.f4976e != null) {
            m7484a(C1992n.m6349a(getResources(), c2094q.m7337n()), this.f4976e);
        }
        if (this.f4979h != null) {
            m7484a(C1992n.m6349a(getResources(), q), this.f4979h);
        }
        if (this.f4980i != null) {
            if ((c2094q.m7342s() & 1) != 0) {
                this.f4981j.setText(c2094q.m7338o());
                this.f4982k.setText(c2094q.m7339p());
                this.f4980i.setVisibility(0);
            } else {
                this.f4980i.setVisibility(8);
            }
        }
        if ((c2094q.m7342s() & 2) != 0) {
            m = c2094q.m7335l();
            if (m.length() > 0) {
                m = getResources().getString(R.string.home_release_date_label) + " " + m;
            }
            m7484a(m, this.f4983l);
        } else {
            m7484a("", this.f4983l);
        }
        this.f4984m.setImageResource(c2094q.m7332i().ab());
    }

    private void m7484a(CharSequence charSequence, TextView textView) {
        if (textView != null) {
            if (charSequence.length() > 0) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }
}
