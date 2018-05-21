package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.CinemaMovie;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2097e;
import cz.csfd.csfdroid.widget.FlowLayout;

public class CinemaMovieItemView extends RelativeLayout implements C2087b {
    private ImageView f5006a;
    private TextView f5007b;
    private TextView f5008c;
    private TextView f5009d;
    private ImageView f5010e;
    private FlowLayout f5011f;
    private TextView f5012g;
    private Context f5013h;
    private LayoutInflater f5014i;
    private SharedPreferences f5015j;
    private C1187t f5016k;

    public CinemaMovieItemView(Context context) {
        this(context, null);
    }

    public CinemaMovieItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5013h = context;
        this.f5014i = (LayoutInflater) this.f5013h.getSystemService("layout_inflater");
        this.f5015j = PreferenceManager.getDefaultSharedPreferences(context);
        this.f5016k = C1187t.m5432a(context);
    }

    public void mo3428b() {
        this.f5006a = (ImageView) findViewById(R.id.movie_item_poster);
        this.f5007b = (TextView) findViewById(R.id.movie_item_name);
        this.f5008c = (TextView) findViewById(R.id.movie_item_year);
        this.f5009d = (TextView) findViewById(R.id.movie_item_type);
        this.f5010e = (ImageView) findViewById(R.id.movie_item_color);
        this.f5011f = (FlowLayout) findViewById(R.id.movie_item_showtimes);
        this.f5012g = (TextView) findViewById(R.id.movie_item_projection_type);
    }

    public void setObject(C2083a c2083a) {
        String i;
        int length;
        C2097e c2097e = (C2097e) c2083a;
        CinemaMovie c = c2097e.m7364c();
        this.f5007b.setText(c2097e.m7365d());
        if (this.f5015j.getBoolean("show_posters", true)) {
            i = c2097e.m7370i();
            if (i.length() == 0) {
                this.f5016k.m5437a((int) R.drawable.poster_free).m5477a(this.f5006a);
            } else {
                this.f5016k.m5439a(i).m5477a(this.f5006a);
            }
            this.f5006a.setVisibility(0);
        } else {
            this.f5006a.setVisibility(8);
        }
        if (c2097e.m7366e().length() > 0) {
            this.f5008c.setText("(" + c2097e.m7366e() + ")");
        } else {
            this.f5008c.setText("");
        }
        i = c2097e.m7367f();
        if (i.length() > 1) {
            i = i.substring(0, 1).toUpperCase() + i.substring(1);
        }
        m7489a(i, this.f5009d);
        this.f5010e.setImageResource(c2097e.m7369h());
        this.f5011f.removeAllViews();
        for (String i2 : c2097e.m7368g()) {
            TextView textView = (TextView) this.f5014i.inflate(R.layout.list_item_cinema_movie_showtime, null);
            textView.setText(i2);
            this.f5011f.addView(textView);
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (c.m6770c()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            String string = getResources().getString(R.string.projection_type_technology_3d);
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), length, string.length() + length, 0);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.list_item_additional_light)), length, string.length() + length, 0);
        }
        if (c.m6772d()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            string = getResources().getString(R.string.projection_type_technology_4dx);
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), length, string.length() + length, 0);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.list_item_additional_light)), length, string.length() + length, 0);
        }
        if (c.m6774e()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            string = getResources().getString(R.string.projection_type_csfd_hall);
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), length, string.length() + length, 0);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.list_item_additional_light)), length, string.length() + length, 0);
        }
        if (c.m6776f()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            string = getResources().getString(R.string.projection_type_gold_class);
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), length, string.length() + length, 0);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.list_item_additional_light)), length, string.length() + length, 0);
        }
        if (c.m6766a()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            spannableStringBuilder.append(getResources().getString(R.string.projection_type_dubbing));
        }
        if (c.m6768b()) {
            length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.append(" / ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_slash)), length + 1, length + 2, 0);
            }
            spannableStringBuilder.append(getResources().getString(R.string.projection_type_subtitles));
        }
        this.f5012g.setText(spannableStringBuilder);
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            this.f5012g.setVisibility(8);
        } else {
            this.f5012g.setVisibility(0);
        }
    }

    private void m7489a(String str, TextView textView) {
        if (str.length() > 0) {
            textView.setText(str);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }
}
