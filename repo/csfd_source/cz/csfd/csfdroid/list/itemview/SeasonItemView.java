package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2112t;
import cz.csfd.csfdroid.p061d.C1992n;

public class SeasonItemView extends RelativeLayout implements C2087b {
    private ImageView f5074a;
    private TextView f5075b;
    private TextView f5076c;
    private TextView f5077d;
    private TextView f5078e;
    private ImageView f5079f;
    private C2057e f5080g;
    private C1187t f5081h;

    public SeasonItemView(Context context) {
        this(context, null);
    }

    public SeasonItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5080g = ((CsfdApplication) context.getApplicationContext()).m6226n();
        this.f5081h = C1187t.m5432a(getContext());
    }

    public void mo3428b() {
        this.f5074a = (ImageView) findViewById(R.id.movie_item_poster);
        this.f5075b = (TextView) findViewById(R.id.movie_item_name);
        this.f5076c = (TextView) findViewById(R.id.movie_item_year);
        this.f5078e = (TextView) findViewById(R.id.movie_item_episodes);
        this.f5077d = (TextView) findViewById(R.id.movie_item_genre);
        this.f5079f = (ImageView) findViewById(R.id.movie_item_color);
    }

    public void setObject(C2083a c2083a) {
        StringBuilder stringBuilder = new StringBuilder();
        C2112t c2112t = (C2112t) c2083a;
        this.f5081h.m5441a(this.f5074a);
        String g = c2112t.m7441g();
        if (g.length() == 0) {
            this.f5081h.m5437a((int) R.drawable.poster_free).m5477a(this.f5074a);
        } else {
            if (g.startsWith("//")) {
                g = "https:" + g;
            }
            this.f5081h.m5439a(g).m5477a(this.f5074a);
        }
        this.f5074a.setVisibility(0);
        this.f5075b.setText(c2112t.m7438d());
        if (c2112t.m7439e().length() > 0) {
            this.f5076c.setText(stringBuilder.append("(").append(c2112t.m7439e()).append(")").toString());
        } else {
            this.f5076c.setText("");
        }
        int size = c2112t.m7437c().m7035g().size();
        this.f5078e.setText(getContext().getResources().getQuantityString(R.plurals.x_episodes, size, new Object[]{Integer.valueOf(size)}));
        m7511a(C1992n.m6349a(getResources(), c2112t.m7440f()), this.f5077d);
        this.f5079f.setImageResource(c2112t.m7437c().m7036h());
    }

    private void m7511a(CharSequence charSequence, TextView textView) {
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
