package cz.csfd.csfdroid.module.movie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import com.p030a.p031a.C0831a;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieInfo.Category;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2322b.C2320b;
import cz.csfd.csfdroid.module.movie.C2366h.C2364c;
import cz.csfd.csfdroid.module.watchlist.C2494b;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1970b.C1969a;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1989k;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.CsfdRatingBar;
import cz.csfd.csfdroid.widget.CsfdRatingBar.C2310a;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.HashMap;
import p000a.p001a.p002a.p003a.C0141c;

/* compiled from: MovieDetailsFragment */
public class C2343e extends C1974c {
    private MovieInfo f5748a;
    private C1970b f5749b;
    private ViewPager f5750c;
    private SlidingTabLayout f5751d;
    private AdBottomView f5752e;
    private C1972c f5753f;
    private C1972c f5754g;
    private C1972c f5755h;
    private C1972c f5756i;
    private C1972c f5757j;
    private CsfdApplication f5758k;
    private C2366h f5759l;
    private C2494b f5760m;
    private C2056d<MovieInfo> f5761n;
    private int f5762o;
    private C2364c f5763p;
    private boolean f5764q;

    /* compiled from: MovieDetailsFragment */
    class C23341 implements Runnable {
        final /* synthetic */ C2343e f5739a;

        C23341(C2343e c2343e) {
            this.f5739a = c2343e;
        }

        public void run() {
            this.f5739a.m8489a();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23352 implements OnClickListener {
        final /* synthetic */ C2343e f5740a;

        C23352(C2343e c2343e) {
            this.f5740a = c2343e;
        }

        public void onClick(View view) {
            this.f5740a.m8508h();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23363 implements OnClickListener {
        final /* synthetic */ C2343e f5741a;

        C23363(C2343e c2343e) {
            this.f5741a = c2343e;
        }

        public void onClick(View view) {
            this.f5741a.m8508h();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23374 implements C2320b {
        final /* synthetic */ C2343e f5742a;

        C23374(C2343e c2343e) {
            this.f5742a = c2343e;
        }

        public void mo3567a() {
            this.f5742a.m8507g(this.f5742a.getView());
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23385 implements C1947a {
        final /* synthetic */ C2343e f5743a;

        C23385(C2343e c2343e) {
            this.f5743a = c2343e;
        }

        public void mo3328a() {
            this.f5743a.m6320d().mo3469n();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23407 implements C1969a {
        final /* synthetic */ C2343e f5745a;

        C23407(C2343e c2343e) {
            this.f5745a = c2343e;
        }

        public void mo3507a(int i) {
            this.f5745a.f5752e.m7620a();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23418 implements Runnable {
        final /* synthetic */ C2343e f5746a;

        C23418(C2343e c2343e) {
            this.f5746a = c2343e;
        }

        public void run() {
            this.f5746a.m8489a();
        }
    }

    /* compiled from: MovieDetailsFragment */
    class C23429 implements OnDismissListener {
        final /* synthetic */ C2343e f5747a;

        C23429(C2343e c2343e) {
            this.f5747a = c2343e;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5747a.m6320d().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5758k = m6320d().m6292m();
        this.f5759l = this.f5758k.m6219g().mo3453c();
        this.f5760m = this.f5758k.m6219g().mo3461k();
        this.f5761n = this.f5758k.m6222j();
        Uri parse = Uri.parse(getArguments().getString("_data"));
        try {
            this.f5762o = this.f5759l.mo3569a(parse);
            this.f5763p = this.f5759l.mo3584b(parse);
            this.f5748a = m8499c(this.f5762o);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6314a(R.string.error_bad_url);
        }
        if (C0141c.m469j()) {
            C0831a.m3749a("movieId", this.f5762o);
        }
        setHasOptionsMenu(true);
        setRetainInstance(true);
        if (bundle != null) {
            this.f5764q = bundle.getBoolean("dont_show_section");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_movie_details, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m8491a(view);
        if (this.f5748a != null) {
            m8500c(view);
            m8497b(view);
            m8509h(view);
        }
        getView().post(new C23341(this));
        this.f5752e = (AdBottomView) view.findViewById(R.id.ad_bottom);
        this.f5752e.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(this.f5762o));
        this.f5752e.m7621a(C2146b.FILM, hashMap, mo3436p());
        this.f5749b.m6305a(new C23407(this));
    }

    private void m8489a() {
        if (!this.f5764q && this.f5763p != null) {
            switch (this.f5763p) {
                case COMMENTS:
                    if (this.f5754g != null) {
                        this.f5750c.setCurrentItem(this.f5749b.m6303a(this.f5754g));
                        this.f5764q = true;
                        return;
                    }
                    return;
                case TRIVIA:
                    if (this.f5757j != null) {
                        this.f5750c.setCurrentItem(this.f5749b.m6303a(this.f5757j));
                        this.f5764q = true;
                        return;
                    }
                    return;
                case GALLERY:
                    if (this.f5755h != null) {
                        this.f5750c.setCurrentItem(this.f5749b.m6303a(this.f5755h));
                        this.f5764q = true;
                        return;
                    }
                    return;
                case VIDEOS:
                    if (this.f5756i != null) {
                        this.f5750c.setCurrentItem(this.f5749b.m6303a(this.f5756i));
                        this.f5764q = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void m8510a(MovieInfo movieInfo) {
        this.f5748a = movieInfo;
        View view = getView();
        m8500c(view);
        m8497b(view);
        m8509h(view);
        getView().post(new C23418(this));
    }

    private MovieInfo m8499c(int i) {
        try {
            if (this.f5761n.m7166b(Integer.valueOf(i))) {
                return (MovieInfo) this.f5761n.m7162a(Integer.valueOf(i));
            }
            this.f5761n.m7164a(new MovieInfo(i));
            return null;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            AlertDialog a = C1984g.m6336a(getActivity(), R.string.error);
            a.setOnDismissListener(new C23429(this));
            a.show();
            return null;
        }
    }

    private void m8491a(View view) {
        this.f5751d = (SlidingTabLayout) view.findViewById(R.id.tabs);
        this.f5750c = (ViewPager) view.findViewById(R.id.movie_detail_view_pager);
        C1998s.m6369a(this.f5750c, 2);
        this.f5749b = new C1970b(getActivity(), this.f5750c, this.f5751d);
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", this.f5762o);
        this.f5753f = new C1972c(getString(R.string.tab_movie_plot), C2363g.class, bundle, this);
        this.f5749b.m6306b(this.f5753f);
        this.f5750c.setAdapter(this.f5749b);
        this.f5751d.setViewPager(this.f5750c);
    }

    private boolean m8495a(C1972c c1972c) {
        if (c1972c == null || this.f5749b.m6303a(c1972c) == -1) {
            return false;
        }
        return true;
    }

    private void m8497b(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", this.f5748a.m6705g());
        this.f5750c.setOffscreenPageLimit(3);
        switch (this.f5748a.m6894D()) {
            case 3:
            case 12:
                this.f5753f.m6311a(getString(R.string.tab_serie_plot));
                break;
            case 10:
                this.f5753f.m6311a(getString(R.string.tab_season_plot));
                break;
            case 11:
                this.f5753f.m6311a(getString(R.string.tab_episode_plot));
                break;
            case 13:
                this.f5753f.m6311a(getString(R.string.tab_show_plot));
                break;
            default:
                this.f5753f.m6311a(getString(R.string.tab_movie_plot));
                break;
        }
        if (this.f5748a.ah() > 0 && !m8495a(this.f5754g)) {
            if (this.f5754g == null) {
                this.f5754g = new C1972c(getString(R.string.tab_movie_comments), C2328c.class, bundle, this);
            }
            this.f5749b.m6306b(this.f5754g);
        }
        if (this.f5748a.aj() > 0 && !m8495a(this.f5757j)) {
            if (this.f5757j == null) {
                this.f5757j = new C1972c(getString(R.string.tab_movie_trivia), C2373j.class, bundle, this);
            }
            this.f5749b.m6306b(this.f5757j);
        }
        if (this.f5748a.ai() > 0 && !m8495a(this.f5756i)) {
            if (this.f5756i == null) {
                this.f5756i = new C1972c(getString(R.string.tab_movie_videos), C2378k.class, bundle, this);
            }
            this.f5749b.m6306b(this.f5756i);
        }
        if (this.f5748a.ag() > 0 && !m8495a(this.f5755h)) {
            if (this.f5755h == null) {
                this.f5755h = new C1972c(getString(R.string.tab_movie_gallery), C2348f.class, bundle, this);
            }
            this.f5749b.m6306b(this.f5755h);
        }
        this.f5749b.notifyDataSetChanged();
        this.f5751d.m9468a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private void m8500c(View view) {
        view.findViewById(R.id.movie_head).setBackgroundColor(getResources().getColor(this.f5748a.aa()));
        m8502d(view);
        m8503e(view);
        m8506f(view);
        m8507g(view);
    }

    private void m8502d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.movie_name);
        C1989k.m6344b(getActivity(), textView);
        textView.setText(!TextUtils.isEmpty(this.f5748a.m6896F()) ? this.f5748a.m6896F() : this.f5748a.m6917a());
        if (TextUtils.isEmpty(this.f5748a.m6896F())) {
            textView.setOnClickListener(null);
        } else {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2343e f5735a;

                {
                    this.f5735a = r1;
                }

                public void onClick(View view) {
                    this.f5735a.m8490a(this.f5735a.f5748a.m6895E(), this.f5735a.f5748a.m6896F());
                }
            });
        }
    }

    private void m8503e(View view) {
        CharSequence c;
        View findViewById = view.findViewById(R.id.movie_original_name_container);
        TextView textView = (TextView) view.findViewById(R.id.movie_original_name);
        Object F = !TextUtils.isEmpty(this.f5748a.m6896F()) ? this.f5748a.m6896F() : this.f5748a.m6917a();
        if (TextUtils.isEmpty(this.f5748a.m6896F())) {
            c = this.f5748a.m6931c();
        } else {
            c = this.f5748a.m6917a();
            if (this.f5748a.m6894D() == 11) {
                c = c + " (" + this.f5748a.m6900J() + ")";
            }
        }
        if (c.length() > 0 && !c.equals(F)) {
            textView.setText(c);
            findViewById.setVisibility(0);
        }
    }

    private void m8506f(View view) {
        TextView textView = (TextView) view.findViewById(R.id.movie_rating);
        C1989k.m6344b(getActivity(), textView);
        if (this.f5748a.m6941e() > -1) {
            textView.setText(this.f5748a.m6941e() + " %");
        }
    }

    private void m8507g(View view) {
        C1950a q = this.f5758k.m6229q();
        if (this.f5748a.m6995v() && this.f5748a.ac()) {
            Button button = (Button) view.findViewById(R.id.button_rate);
            if (q.m6250a()) {
                CsfdRatingBar csfdRatingBar = (CsfdRatingBar) view.findViewById(R.id.rating_bar);
                CsfdRatingBar csfdRatingBar2 = (CsfdRatingBar) view.findViewById(R.id.rating_bar_computed);
                TextView textView = (TextView) view.findViewById(R.id.rating_garbage);
                button.setVisibility(8);
                csfdRatingBar.setVisibility(8);
                csfdRatingBar2.setVisibility(8);
                textView.setVisibility(8);
                if (this.f5748a.m6906P() == -1) {
                    button.setVisibility(0);
                    button.setOnClickListener(new C23352(this));
                    return;
                } else if (this.f5748a.m6907Q() <= 0) {
                    textView.setVisibility(0);
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ C2343e f5738a;

                        {
                            this.f5738a = r1;
                        }

                        public void onClick(View view) {
                            this.f5738a.m8508h();
                        }
                    });
                    return;
                } else if (this.f5748a.m6908R()) {
                    csfdRatingBar2.setVisibility(0);
                    csfdRatingBar2.setNumStars(this.f5748a.m6907Q());
                    csfdRatingBar2.setOnRatingBarNoChangeListener(new C2310a(this) {
                        final /* synthetic */ C2343e f5736a;

                        {
                            this.f5736a = r1;
                        }

                        public void mo3562a(RatingBar ratingBar, float f) {
                            this.f5736a.m8508h();
                        }
                    });
                    return;
                } else {
                    csfdRatingBar.setVisibility(0);
                    csfdRatingBar.setNumStars(this.f5748a.m6907Q());
                    csfdRatingBar.setOnRatingBarNoChangeListener(new C2310a(this) {
                        final /* synthetic */ C2343e f5737a;

                        {
                            this.f5737a = r1;
                        }

                        public void mo3562a(RatingBar ratingBar, float f) {
                            this.f5737a.m8508h();
                        }
                    });
                    return;
                }
            }
            button.setVisibility(0);
            button.setOnClickListener(new C23363(this));
        }
    }

    private void m8508h() {
        if (this.f5758k.m6229q().m6250a()) {
            m6316a("comment", "pressed", null, 0);
            if (!this.f5761n.m7166b(Integer.valueOf(this.f5762o))) {
                this.f5761n.m7164a(this.f5748a);
            }
            C2322b.m8399a(getFragmentManager(), this.f5759l.mo3591g(this.f5748a.m6705g()), new C23374(this));
            return;
        }
        this.f5758k.m6229q().m6246a(getActivity(), new C23385(this));
    }

    private void m8509h(View view) {
        int color;
        int color2;
        ColorStateList colorStateList;
        if (this.f5748a.m6916Z() == Category.GREY) {
            color = getResources().getColor(R.color.text_color_inverse);
            color2 = getResources().getColor(R.color.text_color_inverse_transparent);
            colorStateList = getResources().getColorStateList(R.color.xml_tab_text_color_inverse);
        } else {
            color = getResources().getColor(R.color.movieinfo_head_textcolor);
            color2 = getResources().getColor(R.color.movieinfo_head_textcolor);
            colorStateList = getResources().getColorStateList(R.color.xml_tab_text_color);
        }
        this.f5751d.setTextColor(colorStateList);
        this.f5751d.setSelectedIndicatorColors(color);
        this.f5751d.m9468a();
        ((TextView) view.findViewById(R.id.movie_name)).setTextColor(color);
        ((TextView) view.findViewById(R.id.movie_rating)).setTextColor(color);
        ((TextView) view.findViewById(R.id.movie_original_name)).setTextColor(color2);
    }

    private void m8490a(int i, String str) {
        MovieInfo movieInfo = new MovieInfo(i);
        movieInfo.m6922a(str);
        this.f5759l.mo3575a(movieInfo, getContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("dont_show_section", this.f5764q);
    }

    public String mo3436p() {
        return "/movie";
    }
}
