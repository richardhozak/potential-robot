package cz.csfd.csfdroid.module.movie;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.p039b.p040a.C0951a;
import com.p039b.p040a.C0952b;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2058f;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.C2027d;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.list.p063a.C2099g;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.chart.ChartsActivity;
import cz.csfd.csfdroid.module.cinema.CinemasActivity;
import cz.csfd.csfdroid.module.movie.C2366h.C2332b;
import cz.csfd.csfdroid.module.movie.C2366h.C2361d;
import cz.csfd.csfdroid.module.movie.C2366h.C2362g;
import cz.csfd.csfdroid.module.movie.g.AnonymousClass15;
import cz.csfd.csfdroid.module.series.SeasonsActivity;
import cz.csfd.csfdroid.module.tvschedule.C2450d;
import cz.csfd.csfdroid.module.watchlist.C2494b;
import cz.csfd.csfdroid.p060c.C1968a;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1982e;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.ConfigurableSizeTextView;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;

/* compiled from: MovieInfoFragment */
public class C2363g extends C1974c implements OnItemClickListener, C1973d, C2332b, C2361d, C2362g {
    private C2366h f5818a;
    private C2494b f5819b;
    private C2450d f5820c;
    private CsfdApplication f5821d;
    private C1995q f5822e;
    private C1187t f5823f;
    private boolean f5824g = false;
    private boolean f5825h = false;
    private Exception f5826i;
    private MovieInfo f5827j;
    private boolean f5828k = false;
    private boolean f5829l = false;
    private ListView f5830m;
    private C2086a f5831n;
    private LoadingView f5832o;
    private View f5833p;
    private AdBannerView f5834q;
    private OnClickListener f5835r;
    private Object f5836s = new Object();

    /* compiled from: MovieInfoFragment */
    class C23521 implements OnClickListener {
        final /* synthetic */ C2363g f5806a;

        C23521(C2363g c2363g) {
            this.f5806a = c2363g;
        }

        public void onClick(View view) {
            this.f5806a.m8564b(this.f5806a.f5827j);
            this.f5806a.f5832o.setOnTryAgainListener(null);
        }
    }

    /* compiled from: MovieInfoFragment */
    class C23543 implements OnClickListener {
        final /* synthetic */ C2363g f5809a;

        C23543(C2363g c2363g) {
            this.f5809a = c2363g;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(C1992n.m6361e(this.f5809a.f5827j) + "?source=android"));
            this.f5809a.startActivity(intent);
        }
    }

    /* compiled from: MovieInfoFragment */
    class C23554 implements OnClickListener {
        final /* synthetic */ C2363g f5810a;

        C23554(C2363g c2363g) {
            this.f5810a = c2363g;
        }

        public void onClick(View view) {
            int i = 0;
            Intent intent = new Intent(this.f5810a.getActivity(), SeasonsActivity.class);
            int E = this.f5810a.f5827j.m6895E() > 0 ? this.f5810a.f5827j.m6895E() : this.f5810a.f5827j.m6705g();
            String F = !TextUtils.isEmpty(this.f5810a.f5827j.m6896F()) ? this.f5810a.f5827j.m6896F() : this.f5810a.f5827j.m6917a();
            intent.putExtra("film_id", E);
            intent.putExtra("film_name", F);
            switch (this.f5810a.f5827j.m6894D()) {
                case 10:
                    i = this.f5810a.f5827j.m6705g();
                    E = 0;
                    break;
                case 11:
                    i = this.f5810a.f5827j.m6897G();
                    E = this.f5810a.f5827j.m6705g();
                    break;
                default:
                    E = 0;
                    break;
            }
            if (i > 0) {
                intent.putExtra("season_id", i);
            }
            if (E > 0) {
                intent.putExtra("episode_id", E);
            }
            this.f5810a.startActivity(intent);
        }
    }

    /* compiled from: MovieInfoFragment */
    class C23565 implements OnClickListener {
        final /* synthetic */ C2363g f5811a;

        C23565(C2363g c2363g) {
            this.f5811a = c2363g;
        }

        public void onClick(View view) {
            this.f5811a.m8570d(this.f5811a.f5827j.m6898H());
            this.f5811a.getActivity().overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);
        }
    }

    /* compiled from: MovieInfoFragment */
    class C23576 implements OnClickListener {
        final /* synthetic */ C2363g f5812a;

        C23576(C2363g c2363g) {
            this.f5812a = c2363g;
        }

        public void onClick(View view) {
            this.f5812a.m8570d(this.f5812a.f5827j.m6899I());
            this.f5812a.getActivity().overridePendingTransition(R.anim.activity_in_from_right, R.anim.activity_out_to_left);
        }
    }

    /* compiled from: MovieInfoFragment */
    class C23587 implements C1947a {
        final /* synthetic */ C2363g f5813a;

        C23587(C2363g c2363g) {
            this.f5813a = c2363g;
        }

        public void mo3328a() {
            this.f5813a.m8582m();
            this.f5813a.m6320d().mo3469n();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5821d = m6320d().m6292m();
        this.f5818a = this.f5821d.m6219g().mo3453c();
        this.f5819b = this.f5821d.m6219g().mo3461k();
        this.f5820c = this.f5821d.m6219g().mo3463m();
        this.f5822e = new C1995q(getActivity());
        this.f5823f = C1187t.m5432a(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(16908298);
        this.f5833p = layoutInflater.inflate(R.layout.part_movie_info_header, listView, false);
        listView.addHeaderView(this.f5833p);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m8563b(view);
        m8555a(view);
        this.f5830m = (ListView) view.findViewById(16908298);
        this.f5830m.setOnItemClickListener(this);
        this.f5832o = (LoadingView) view.findViewById(R.id.loading);
        this.f5835r = new C23521(this);
        if (this.f5824g || this.f5825h) {
            this.f5832o.setVisibility(0);
        }
        if (this.f5825h) {
            C1988j.m6341a(getActivity(), this.f5832o, this.f5835r, this.f5826i);
        }
    }

    private void m8555a(View view) {
        this.f5834q = (AdBannerView) view.findViewById(R.id.ad_banner);
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("movieId")));
        this.f5834q.m7592a(C2146b.FILM, hashMap, mo3436p());
    }

    private void m8563b(View view) {
        ((Button) view.findViewById(R.id.button_share)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2363g f5785a;

            {
                this.f5785a = r1;
            }

            public void onClick(View view) {
                this.f5785a.m8552D();
            }
        });
        ((Button) getView().findViewById(R.id.button_watchlist)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2363g f5786a;

            {
                this.f5786a = r1;
            }

            public void onClick(View view) {
                this.f5786a.m8601j();
            }
        });
    }

    private void m8579k() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.movie_poster);
        String d = this.f5827j.m6936d();
        if (d.length() == 0) {
            this.f5823f.m5437a((int) R.drawable.poster_free).m5477a(imageView);
        } else {
            this.f5823f.m5439a(d).m5473a().m5482c().m5477a(imageView);
        }
    }

    private void m8580l() {
        if (this.f5827j.m6911U().size() != 0) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.movie_trailer);
            viewGroup.removeAllViews();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_movie_video, null);
            MovieVideo movieVideo = (MovieVideo) this.f5827j.m6911U().get(0);
            inflate.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2363g f5787a;

                {
                    this.f5787a = r1;
                }

                public void onClick(View view) {
                    this.f5787a.f5818a.mo3576a(this.f5787a.f5827j, new MovieVideos(this.f5787a.f5827j.m6911U()), 0, this.f5787a.getActivity());
                }
            });
            this.f5823f.m5439a(movieVideo.m7006d().m7010a()).m5473a().m5482c().m5477a((ImageView) inflate.findViewById(R.id.video_thumbnail));
            TextView textView = (TextView) inflate.findViewById(R.id.video_name);
            CharSequence a = movieVideo.m7001a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            viewGroup.addView(inflate);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        int i = getArguments().getInt("movieId");
        if (!this.f5824g && !this.f5825h) {
            m8566c(i);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f5831n != null) {
            this.f5822e.m6362a(this.f5831n);
        }
        if (this.f5834q != null) {
            this.f5834q.m7594c();
        }
    }

    public void onPause() {
        if (this.f5834q != null) {
            this.f5834q.m7595d();
        }
        super.onPause();
    }

    public void mo3477h() {
        m6322f();
        if (this.f5828k) {
            m6316a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5828k = true;
        m6316a(mo3436p(), "selected", "first_time", 0);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2099g) {
            m8556a(((C2099g) itemAtPosition).m7379c());
        } else if (itemAtPosition instanceof C2101i) {
            C2101i c2101i = (C2101i) itemAtPosition;
            if (c2101i.m7398d() && c2101i.m7397c().equals("actors")) {
                this.f5818a.mo3586b(this.f5827j, getActivity());
            }
        }
    }

    private void m8566c(int i) {
        try {
            if (this.f5821d.m6222j().m7166b(Integer.valueOf(i))) {
                this.f5827j = C1992n.m6350a(i, getActivity());
                if (this.f5827j.m6995v() && this.f5827j.af() && this.f5827j.m6914X()) {
                    m8571d(this.f5827j);
                    m8584o();
                    return;
                }
                m8564b(this.f5827j);
                return;
            }
            this.f5827j = new MovieInfo(i);
            this.f5821d.m6222j().m7164a(this.f5827j);
            m8564b(this.f5827j);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6314a(R.string.error);
        }
    }

    private void m8564b(final MovieInfo movieInfo) {
        m6320d().m6280a(new Runnable(this) {
            final /* synthetic */ C2363g f5789b;

            public void run() {
                this.f5789b.m8567c(movieInfo);
            }
        }, null, new OnCancelListener(this) {
            final /* synthetic */ C2363g f5790a;

            {
                this.f5790a = r1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                this.f5790a.m6320d().finish();
            }
        });
    }

    private void m8567c(MovieInfo movieInfo) {
        if (!this.f5827j.m6995v()) {
            this.f5818a.mo3581a(movieInfo, (C2361d) this, this.f5821d.m6220h());
        }
        if (!this.f5827j.af()) {
            this.f5818a.mo3579a(movieInfo, (C2332b) this, this.f5821d.m6220h());
        }
        if (!this.f5827j.m6914X()) {
            this.f5818a.mo3574a(movieInfo, 0, (C2362g) this, this.f5821d.m6220h(), getActivity());
        }
    }

    private void m8582m() {
        this.f5818a.mo3581a(this.f5827j, (C2361d) this, this.f5821d.m6220h());
    }

    public void onDestroy() {
        m8583n();
        if (this.f5834q != null) {
            this.f5834q.m7596e();
        }
        super.onDestroy();
    }

    private void m8583n() {
        if (this.f5827j != null) {
            this.f5818a.mo3571a(this.f5827j.m6705g());
            this.f5818a.mo3585b(this.f5827j.m6705g());
            this.f5818a.mo3588d(this.f5827j.m6705g());
        }
        m6323g();
    }

    public void mo3568i() {
        this.f5824g = true;
        this.f5832o.setVisibility(0);
        this.f5832o.m9451e();
        this.f5832o.m9448b();
    }

    public void i_() {
    }

    public void m8596a(MovieInfo movieInfo) {
        if (getActivity() != null) {
            this.f5824g = false;
            if (movieInfo == null) {
                this.f5825h = true;
                this.f5826i = new NullPointerException("Result is null.");
                C1988j.m6341a(getActivity(), this.f5832o, this.f5835r, this.f5826i);
                return;
            }
            this.f5825h = false;
            this.f5827j = movieInfo;
            if (this.f5827j.m6995v() && this.f5827j.af() && this.f5827j.m6914X()) {
                Animation b = m6317b(17432577);
                if (b != null) {
                    this.f5832o.startAnimation(b);
                }
                this.f5832o.setVisibility(8);
                m8571d(this.f5827j);
                m8584o();
                b = m6317b(17432576);
                if (b != null) {
                    this.f5830m.startAnimation(b);
                }
                this.f5830m.setVisibility(0);
                Fragment targetFragment = getTargetFragment();
                if (targetFragment != null && (targetFragment instanceof C2343e)) {
                    ((C2343e) targetFragment).m8510a(this.f5827j);
                }
            }
        }
    }

    private void m8571d(MovieInfo movieInfo) {
        this.f5831n = C2333d.m8462a(getActivity(), movieInfo);
        this.f5830m.setAdapter(this.f5831n);
        if (this.f5831n.getCount() > 0 && getView() != null) {
            getView().findViewById(R.id.movie_plot_separator).setVisibility(8);
        }
    }

    public void mo3322a() {
        this.f5824g = false;
    }

    public void mo3323a(Exception exception) {
        this.f5824g = false;
        this.f5825h = true;
        this.f5826i = exception;
        C1988j.m6341a(getActivity(), this.f5832o, this.f5835r, this.f5826i);
    }

    private void m8584o() {
        this.f5830m.setVisibility(0);
        m8585q();
    }

    private void m8585q() {
        m8586r();
        m8587s();
        m8588t();
        m8589u();
        m8591w();
        m8592x();
        m8593y();
        m8594z();
        m8549A();
        m8550B();
        m8551C();
        m8579k();
        m8580l();
    }

    private void m8586r() {
        String a = C1992n.m6351a(this.f5827j);
        if (a.length() > 0) {
            TextView textView = (TextView) getView().findViewById(R.id.movie_genre);
            textView.setText(C1992n.m6349a(getResources(), a));
            textView.setVisibility(0);
        }
    }

    private void m8587s() {
        CharSequence C = this.f5827j.m6893C();
        if (this.f5827j.m6894D() != 11 && this.f5827j.m6894D() != 10 && C.length() > 0) {
            TextView textView = (TextView) getView().findViewById(R.id.movie_type);
            textView.setText(C);
            textView.setVisibility(0);
        }
    }

    private void m8588t() {
        String b = C1992n.m6358b(this.f5827j);
        if (b.length() > 0) {
            TextView textView = (TextView) getView().findViewById(R.id.movie_origin_year_length);
            textView.setText(C1992n.m6349a(getResources(), b));
            textView.setVisibility(0);
        }
    }

    private void m8589u() {
        synchronized (this.f5836s) {
            TextView textView = (TextView) getView().findViewById(R.id.movie_plot);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f5827j.m6891A());
            String B = this.f5827j.m6892B();
            if (B.length() > 0) {
                stringBuilder.append(" <b><i>(").append(B).append(")</i></b>");
            }
            textView.setText(Html.fromHtml(stringBuilder.toString()), BufferType.SPANNABLE);
            if (TextUtils.isEmpty(stringBuilder.toString())) {
                getView().findViewById(R.id.movie_plot_container).setVisibility(8);
            } else {
                m8590v();
            }
        }
    }

    private void m8590v() {
        final TextView textView = (TextView) getView().findViewById(R.id.movie_plot);
        final TextView textView2 = (TextView) getView().findViewById(R.id.movie_plot_more);
        final View findViewById = getView().findViewById(R.id.movie_plot_separator);
        final View findViewById2 = getView().findViewById(R.id.movie_plot_container);
        ViewTreeObserver viewTreeObserver = findViewById2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ C2363g f5802e;

                public boolean onPreDraw() {
                    findViewById2.getViewTreeObserver().removeOnPreDrawListener(this);
                    synchronized (this.f5802e.f5836s) {
                        try {
                            int lineHeight = ((textView.getLineHeight() * 4) + textView.getTotalPaddingTop()) + (textView.getLineHeight() / 2);
                        } catch (NullPointerException e) {
                            lineHeight = (textView.getLineHeight() * 4) + (textView.getLineHeight() / 2);
                        }
                        int measuredHeight = textView.getMeasuredHeight();
                        if (lineHeight >= measuredHeight) {
                            findViewById2.setClickable(false);
                            textView2.setVisibility(8);
                            findViewById.setVisibility(8);
                        } else {
                            int i;
                            int measuredHeight2 = findViewById2.getMeasuredHeight();
                            if (VERSION.SDK_INT < 11) {
                                i = ((LayoutParams) textView.getLayoutParams()).bottomMargin + measuredHeight2;
                            } else {
                                i = measuredHeight2;
                            }
                            measuredHeight2 = (lineHeight + i) - measuredHeight;
                            if (this.f5802e.f5829l) {
                                textView2.setVisibility(8);
                            } else {
                                findViewById2.getLayoutParams().height = measuredHeight2;
                                findViewById2.requestLayout();
                                textView.setMaxLines(4);
                            }
                            findViewById2.setOnClickListener(new OnClickListener(this) {
                                C1968a f5793a;
                                C1968a f5794b;
                                final /* synthetic */ AnonymousClass15 f5797e;

                                /* compiled from: MovieInfoFragment */
                                class C23491 extends C0952b {
                                    final /* synthetic */ C23511 f5791a;

                                    C23491(C23511 c23511) {
                                        this.f5791a = c23511;
                                    }

                                    public void mo1859a(C0951a c0951a) {
                                        textView.setMaxLines(Integer.MAX_VALUE);
                                        textView2.setVisibility(8);
                                    }

                                    public void mo1860b(C0951a c0951a) {
                                    }
                                }

                                /* compiled from: MovieInfoFragment */
                                class C23502 extends C0952b {
                                    final /* synthetic */ C23511 f5792a;

                                    C23502(C23511 c23511) {
                                        this.f5792a = c23511;
                                    }

                                    public void mo1860b(C0951a c0951a) {
                                        textView.setMaxLines(4);
                                        textView2.setVisibility(0);
                                    }
                                }

                                public void onClick(View view) {
                                    if (this.f5797e.f5802e.f5829l) {
                                        if (this.f5794b == null) {
                                            this.f5794b = C1968a.m6299b(findViewById2, measuredHeight2);
                                            this.f5794b.m4172a(new C23502(this));
                                        }
                                        this.f5794b.mo1874a();
                                    } else {
                                        if (this.f5793a == null) {
                                            this.f5793a = C1968a.m6298a(findViewById2, i);
                                            this.f5793a.m4172a(new C23491(this));
                                        }
                                        this.f5793a.mo1874a();
                                    }
                                    this.f5797e.f5802e.f5829l = !this.f5797e.f5802e.f5829l;
                                }
                            });
                        }
                    }
                    return true;
                }
            });
        }
    }

    private void m8591w() {
        Button button = (Button) getView().findViewById(R.id.movie_cinemas_btn);
        if (this.f5827j.ak()) {
            button.setVisibility(0);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2363g f5803a;

                {
                    this.f5803a = r1;
                }

                public void onClick(View view) {
                    Intent intent = new Intent(this.f5803a.getActivity(), CinemasActivity.class);
                    intent.putExtra("movie_id", this.f5803a.f5827j.m6705g());
                    intent.putExtra("movie_name", this.f5803a.f5827j.m6917a());
                    this.f5803a.startActivity(intent);
                }
            });
            if (this.f5827j.al()) {
                button.setText(getString(R.string.in_favorite_cinemas));
            }
        }
    }

    private void m8592x() {
        Button button = (Button) getView().findViewById(R.id.movie_tv_btn);
        if (this.f5827j.am()) {
            button.setVisibility(0);
            if (this.f5827j.ad().size() > 0) {
                final TvProgramm tvProgramm = (TvProgramm) this.f5827j.ad().get(0);
                String str = C1982e.m6330a(tvProgramm.m7057c()) + " na " + tvProgramm.m7053a();
                button.setText(Character.toUpperCase(str.charAt(0)) + str.substring(1));
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C2363g f5805b;

                    public void onClick(View view) {
                        this.f5805b.startActivity(this.f5805b.f5820c.mo3626a(this.f5805b.getContext(), tvProgramm.m7056b(), tvProgramm.m7053a(), tvProgramm.m7058d()));
                    }
                });
            }
        }
    }

    private void m8593y() {
        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.movie_chart);
        linearLayout.removeAllViews();
        if (!this.f5827j.an().isEmpty()) {
            linearLayout.setVisibility(0);
            for (final C2027d c2027d : this.f5827j.an()) {
                int i;
                View configurableSizeTextView = new ConfigurableSizeTextView(getActivity());
                if (c2027d.m7098b().equals("filmsByRatingAverageTop") || c2027d.m7098b().equals("filmsByFanclub") || c2027d.m7098b().equals("seriesByRatingAverageTop") || c2027d.m7098b().equals("seriesByFanclub")) {
                    i = R.drawable.xml_btn_movie_chart_red;
                } else if (c2027d.m7098b().equals("filmsByRatingDeviation")) {
                    i = R.drawable.xml_btn_movie_chart_blue;
                } else {
                    i = R.drawable.xml_btn_movie_chart_gray;
                }
                configurableSizeTextView.setTextColor(getResources().getColorStateList(i));
                configurableSizeTextView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.movieinfo_head_textsize_small));
                configurableSizeTextView.setTypeface(null, 1);
                configurableSizeTextView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.chart_btn_padding_vertical), 0, 0);
                configurableSizeTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                configurableSizeTextView.setText(c2027d.m7099c());
                configurableSizeTextView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C2363g f5808b;

                    public void onClick(View view) {
                        this.f5808b.m8560a(c2027d.m7098b(), c2027d.m7097a());
                    }
                });
                linearLayout.addView(configurableSizeTextView);
            }
        }
    }

    private void m8594z() {
        getView().findViewById(R.id.movie_link_web).setOnClickListener(new C23543(this));
    }

    private void m8549A() {
        Button button = (Button) getView().findViewById(R.id.button_watchlist);
        if (this.f5827j.ao()) {
            button.setTypeface(null, 1);
            button.setText(getResources().getString(R.string.menu_remove_from_watchlist));
            return;
        }
        button.setTypeface(null, 1);
        button.setText(getResources().getString(R.string.menu_add_to_watchlist));
    }

    private void m8550B() {
        Button button = (Button) getView().findViewById(R.id.movie_episodes_btn);
        switch (this.f5827j.m6894D()) {
            case 10:
                button.setText(R.string.season_episodes);
                button.setVisibility(0);
                break;
            case 11:
                button.setText(R.string.all_episodes);
                button.setVisibility(0);
                break;
            case 12:
            case 13:
                if (this.f5827j.ap()) {
                    button.setText(R.string.episodes);
                } else {
                    button.setText(R.string.seasons_and_episodes);
                }
                button.setVisibility(0);
                break;
            default:
                button.setVisibility(8);
                break;
        }
        button.setOnClickListener(new C23554(this));
    }

    private void m8551C() {
        int i;
        int i2 = 0;
        Button button = (Button) getView().findViewById(R.id.button_prev_episode);
        Button button2 = (Button) getView().findViewById(R.id.button_next_episode);
        getView().findViewById(R.id.episodes_container).setVisibility(this.f5827j.m6894D() == 11 ? 0 : 8);
        if (this.f5827j.m6898H() > 0) {
            i = 0;
        } else {
            i = 8;
        }
        button.setVisibility(i);
        if (this.f5827j.m6899I() <= 0) {
            i2 = 8;
        }
        button2.setVisibility(i2);
        button.setOnClickListener(new C23565(this));
        button2.setOnClickListener(new C23576(this));
    }

    private void m8570d(int i) {
        this.f5818a.mo3575a(new MovieInfo(i), getContext());
        m6323g();
    }

    private void m8552D() {
        if (this.f5827j == null || !this.f5827j.m6995v()) {
            Toast.makeText(getActivity(), R.string.share_movie_not_loaded, 0).show();
        } else {
            startActivity(Intent.createChooser(m8553E(), getString(R.string.share_with)));
        }
    }

    private Intent m8553E() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.share_movie));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5827j.m6917a()).append(" (").append(this.f5827j.m6965j()).append("), ");
        if (this.f5827j.m6941e() > 0) {
            stringBuilder.append(this.f5827j.m6941e()).append("%").append("\n");
        }
        stringBuilder.append(C1992n.m6361e(this.f5827j));
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        return intent;
    }

    public void m8601j() {
        if (!this.f5821d.m6229q().m6250a()) {
            this.f5821d.m6229q().m6246a(getActivity(), new C23587(this));
        } else if (this.f5827j == null || !this.f5827j.m6995v()) {
            m6316a("comment", "pressed", "not_loaded", 0);
            Toast.makeText(getActivity(), R.string.watchlist_movie_not_loaded, 0).show();
        } else {
            final boolean ao = this.f5827j.ao();
            C2058f.m7220a(getFragmentManager(), "watchlist_dialog_progress", !ao ? R.string.watchlist_saving : R.string.watchlist_deleting, true).m7221a(new OnCancelListener(this) {
                final /* synthetic */ C2363g f5815b;

                public void onCancel(DialogInterface dialogInterface) {
                    if (ao) {
                        this.f5815b.f5819b.mo3668d();
                    } else {
                        this.f5815b.f5819b.mo3667c();
                    }
                }
            });
            C1945a c23609 = new C1945a<Object>(this) {
                final /* synthetic */ C2363g f5817b;

                public void mo3324a(Object obj) {
                    this.f5817b.f5827j.m6979l(!ao);
                    this.f5817b.m8549A();
                    if (this.f5817b.isAdded()) {
                        m8543b();
                        Toast.makeText(this.f5817b.getActivity(), this.f5817b.getString(!ao ? R.string.watchlist_save_success : R.string.watchlist_delete_success), 0).show();
                    }
                }

                public void mo3323a(Exception exception) {
                    if (this.f5817b.isAdded()) {
                        m8543b();
                        Toast.makeText(this.f5817b.getActivity(), this.f5817b.getString(!ao ? R.string.watchlist_save_failed : R.string.watchlist_delete_failed), 0).show();
                    }
                }

                public void mo3322a() {
                    if (this.f5817b.isAdded()) {
                        m8543b();
                    }
                }

                private void m8543b() {
                    C2058f c2058f = (C2058f) this.f5817b.getFragmentManager().findFragmentByTag("watchlist_dialog_progress");
                    if (c2058f != null) {
                        c2058f.dismissAllowingStateLoss();
                    }
                }
            };
            if (this.f5827j.ao()) {
                this.f5819b.mo3666b(this.f5827j.m6705g(), c23609, this.f5821d.m6220h());
            } else {
                this.f5819b.mo3662a(this.f5827j.m6705g(), c23609, this.f5821d.m6220h());
            }
        }
    }

    private void m8560a(String str, int i) {
        Intent intent = new Intent(getActivity(), ChartsActivity.class);
        intent.putExtra("chart", str);
        intent.putExtra("position", i);
        startActivity(intent);
    }

    private void m8556a(MovieCreator movieCreator) {
        this.f5821d.m6219g().mo3454d().mo3516a(movieCreator, getActivity());
    }

    public String mo3436p() {
        return "/movie/info";
    }
}
