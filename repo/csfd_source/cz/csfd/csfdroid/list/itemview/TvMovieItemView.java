package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2114v;
import cz.csfd.csfdroid.p061d.C1992n;

public class TvMovieItemView extends RelativeLayout implements C2087b {
    private ImageView f5091a;
    private TextView f5092b;
    private TextView f5093c;
    private TextView f5094d;
    private ImageView f5095e;
    private TextView f5096f;
    private ProgressBar f5097g;
    private Context f5098h;
    private LayoutInflater f5099i;
    private SharedPreferences f5100j;
    private C1187t f5101k;

    public TvMovieItemView(Context context) {
        this(context, null);
    }

    public TvMovieItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5098h = context;
        this.f5099i = (LayoutInflater) this.f5098h.getSystemService("layout_inflater");
        this.f5100j = PreferenceManager.getDefaultSharedPreferences(context);
        this.f5101k = C1187t.m5432a(context);
    }

    public void mo3428b() {
        this.f5091a = (ImageView) findViewById(R.id.movie_item_poster);
        this.f5092b = (TextView) findViewById(R.id.movie_item_name);
        this.f5093c = (TextView) findViewById(R.id.movie_item_year);
        this.f5094d = (TextView) findViewById(R.id.movie_item_type);
        this.f5095e = (ImageView) findViewById(R.id.movie_item_color);
        this.f5096f = (TextView) findViewById(R.id.movie_item_showtime);
        this.f5097g = (ProgressBar) findViewById(R.id.movie_item_progress);
    }

    public void setObject(C2083a c2083a) {
        C2114v c2114v = (C2114v) c2083a;
        this.f5092b.setText(c2114v.m7451d());
        if (this.f5100j.getBoolean("show_posters", true)) {
            String h = c2114v.m7455h();
            if (h.length() == 0) {
                this.f5101k.m5437a((int) R.drawable.poster_free).m5477a(this.f5091a);
            } else {
                this.f5101k.m5439a(h).m5477a(this.f5091a);
            }
            this.f5091a.setVisibility(0);
        } else {
            this.f5091a.setVisibility(8);
        }
        if (c2114v.m7452e().length() > 0) {
            this.f5093c.setText("(" + c2114v.m7452e() + ")");
        } else {
            this.f5093c.setText("");
        }
        m7516a(C1992n.m6349a(getResources(), c2114v.m7453f()), this.f5094d);
        this.f5095e.setImageResource(c2114v.m7454g());
        this.f5096f.setText(c2114v.m7456i());
        if (c2114v.m7457j() <= 1 || c2114v.m7457j() >= 100) {
            this.f5097g.setVisibility(8);
            return;
        }
        this.f5097g.setProgress(c2114v.m7457j());
        this.f5097g.setVisibility(0);
    }

    private void m7516a(SpannableString spannableString, TextView textView) {
        if (spannableString.length() > 0) {
            textView.setText(spannableString);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }
}
