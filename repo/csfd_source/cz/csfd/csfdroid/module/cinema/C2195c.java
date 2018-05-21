package cz.csfd.csfdroid.module.cinema;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.CinemaMovie;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2097e;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.cinema.C2197e.C2194a;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.user.C2489d;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1990l;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: CinemaDetailFragment */
public class C2195c extends C1999d implements C2194a {
    private C2197e f5302a;
    private C2366h f5303b;
    private C2489d f5304c;
    private CsfdApplication f5305d;
    private C1995q f5306e;
    private int f5307f;
    private Cinema f5308g;
    private boolean f5309h = false;
    private boolean f5310i = false;
    private Exception f5311j;
    private boolean f5312k = false;
    private int f5313l;
    private ViewGroup f5314m;
    private LoadingView f5315n;
    private OnClickListener f5316o;
    private C2086a f5317p;
    private List<C2083a> f5318q;
    private C2105m f5319r;
    private Button f5320s;
    private Button f5321t;
    private ViewGroup f5322u;
    private TextView f5323v;
    private TextView f5324w;
    private TextView f5325x;
    private TextView f5326y;
    private TextView f5327z;

    /* compiled from: CinemaDetailFragment */
    class C21841 implements OnDismissListener {
        final /* synthetic */ C2195c f5291a;

        C21841(C2195c c2195c) {
            this.f5291a = c2195c;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5291a.m6380c().finish();
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21852 implements OnClickListener {
        final /* synthetic */ C2195c f5292a;

        C21852(C2195c c2195c) {
            this.f5292a = c2195c;
        }

        public void onClick(View view) {
            this.f5292a.m7830b(this.f5292a.f5308g);
            this.f5292a.f5315n.setOnTryAgainListener(null);
            if (this.f5292a.f5319r != null) {
                this.f5292a.f5319r.m7412a(1);
            }
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21874 implements OnCancelListener {
        final /* synthetic */ C2195c f5295a;

        C21874(C2195c c2195c) {
            this.f5295a = c2195c;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5295a.m6380c().finish();
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21885 implements OnClickListener {
        final /* synthetic */ C2195c f5296a;

        C21885(C2195c c2195c) {
            this.f5296a = c2195c;
        }

        public void onClick(View view) {
            this.f5296a.m7847m();
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21906 implements OnClickListener {
        final /* synthetic */ C2195c f5298a;

        /* compiled from: CinemaDetailFragment */
        class C21891 implements C1947a {
            final /* synthetic */ C21906 f5297a;

            C21891(C21906 c21906) {
                this.f5297a = c21906;
            }

            public void mo3328a() {
                this.f5297a.f5298a.m7843j();
            }
        }

        C21906(C2195c c2195c) {
            this.f5298a = c2195c;
        }

        public void onClick(View view) {
            if (this.f5298a.f5305d.m6229q().m6250a()) {
                this.f5298a.m7843j();
            } else {
                this.f5298a.f5304c.mo3652a(this.f5298a.getActivity(), this.f5298a.f5305d.m6229q(), (int) R.string.login_alert_dialog_text_cinema_favorite, new C21891(this));
            }
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21917 implements OnClickListener {
        final /* synthetic */ C2195c f5299a;

        C21917(C2195c c2195c) {
            this.f5299a = c2195c;
        }

        public void onClick(View view) {
            this.f5299a.m7847m();
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21928 implements C1945a<Object> {
        final /* synthetic */ C2195c f5300a;

        C21928(C2195c c2195c) {
            this.f5300a = c2195c;
        }

        public void mo3324a(Object obj) {
            this.f5300a.f5305d.m6226n().m7198d(new Date().getTime());
            Toast.makeText(this.f5300a.getActivity(), this.f5300a.getString(R.string.cinema_add_favorite_success), 0).show();
        }

        public void mo3323a(Exception exception) {
            Toast.makeText(this.f5300a.getActivity(), this.f5300a.getString(R.string.cinema_add_favorite_error), 0).show();
            this.f5300a.m7846l();
        }

        public void mo3322a() {
            this.f5300a.m7846l();
        }
    }

    /* compiled from: CinemaDetailFragment */
    class C21939 implements C1945a<Object> {
        final /* synthetic */ C2195c f5301a;

        C21939(C2195c c2195c) {
            this.f5301a = c2195c;
        }

        public void mo3324a(Object obj) {
            this.f5301a.f5305d.m6226n().m7198d(new Date().getTime());
            Toast.makeText(this.f5301a.getActivity(), this.f5301a.getString(R.string.cinema_remove_favorite_success), 0).show();
        }

        public void mo3323a(Exception exception) {
            Toast.makeText(this.f5301a.getActivity(), this.f5301a.getString(R.string.cinema_remove_favorite_error), 0).show();
            this.f5301a.m7846l();
        }

        public void mo3322a() {
            this.f5301a.m7846l();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f5305d = m6380c().m6292m();
        this.f5302a = this.f5305d.m6219g().mo3457g();
        this.f5303b = this.f5305d.m6219g().mo3453c();
        this.f5304c = this.f5305d.m6219g().mo3459i();
        this.f5306e = new C1995q(getActivity());
        this.f5313l = getArguments().getInt("movie_id");
        try {
            this.f5307f = this.f5302a.mo3490a(Uri.parse(getArguments().getString("_data")));
            this.f5308g = m7832c(this.f5307f);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6376a(R.string.error_bad_url);
        }
    }

    private Cinema m7832c(int i) {
        try {
            C2056d l = this.f5305d.m6224l();
            if (l.m7166b(Integer.valueOf(i))) {
                return (Cinema) l.m7162a(Integer.valueOf(i));
            }
            BasicEntity cinema = new Cinema(i);
            l.m7164a(cinema);
            return cinema;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            AlertDialog a = C1984g.m6336a(getActivity(), R.string.error);
            a.setOnDismissListener(new C21841(this));
            a.show();
            return null;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5314m = (ViewGroup) view.findViewById(R.id.header);
        this.f5315n = (LoadingView) view.findViewById(R.id.loading);
        this.f5316o = new C21852(this);
        if (this.f5309h || this.f5310i) {
            this.f5315n.setVisibility(0);
        }
        if (this.f5310i) {
            C1988j.m6341a(getActivity(), this.f5315n, this.f5316o, this.f5311j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.CINEMAS, null, mo3436p());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f5309h && !this.f5310i) {
            if (this.f5308g.m6758j()) {
                m7839h();
            } else {
                m7830b(this.f5308g);
            }
        }
    }

    private void m7830b(final Cinema cinema) {
        m6380c().m6280a(new Runnable(this) {
            final /* synthetic */ C2195c f5294b;

            public void run() {
                this.f5294b.m7834c(cinema);
            }
        }, null, new C21874(this));
    }

    private void m7834c(Cinema cinema) {
        this.f5302a.mo3498a(cinema, (C2194a) this, this.f5305d.m6220h());
    }

    public void onResume() {
        super.onResume();
        this.f5306e.m6362a((C2086a) getListAdapter());
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5302a.mo3492a(this.f5307f);
    }

    public void mo3417g() {
        this.f5309h = true;
        if (!this.f5312k) {
            this.f5315n.setVisibility(0);
            this.f5315n.m9451e();
            this.f5315n.m9448b();
        }
    }

    public void m7855a(Cinema cinema) {
        this.f5309h = false;
        if (cinema == null) {
            this.f5310i = true;
            this.f5311j = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5315n, this.f5316o, this.f5311j);
            return;
        }
        this.f5310i = false;
        this.f5312k = true;
        this.f5308g = cinema;
        m7839h();
    }

    private void m7839h() {
        m6377a(C2146b.CINEMAS, null);
        this.f5322u = m7841i();
        if (this.f5308g.m6759k() == null || this.f5308g.m6759k().m7108b() == 0) {
            this.f5314m.addView(this.f5322u);
            m7853t();
        } else {
            if (getListView().getAdapter() == null) {
                getListView().addHeaderView(this.f5322u);
            }
            m7850q();
        }
        m7852s();
    }

    private ViewGroup m7841i() {
        ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.list_item_cinema_details_header, getListView(), false);
        this.f5320s = (Button) viewGroup.findViewById(R.id.button_map);
        this.f5321t = (Button) viewGroup.findViewById(R.id.button_favorite);
        this.f5320s.setOnClickListener(new C21885(this));
        m7846l();
        this.f5321t.setOnClickListener(new C21906(this));
        this.f5323v = (TextView) viewGroup.findViewById(R.id.cinema_name);
        this.f5324w = (TextView) viewGroup.findViewById(R.id.cinema_address);
        this.f5325x = (TextView) viewGroup.findViewById(R.id.cinema_phone);
        this.f5326y = (TextView) viewGroup.findViewById(R.id.cinema_email);
        this.f5327z = (TextView) viewGroup.findViewById(R.id.cinema_web);
        m7845k();
        return viewGroup;
    }

    private void m7843j() {
        if (this.f5308g.m6761m()) {
            m7849o();
        } else {
            m7848n();
        }
    }

    private void m7845k() {
        this.f5323v.setText(this.f5308g.m6736a());
        this.f5324w.setText(C1990l.m6345a(this.f5308g.m6743b()));
        if (!this.f5308g.m6752d().isEmpty()) {
            this.f5325x.setText(getString(R.string.cinema_phone, C1998s.m6367a(this.f5308g.m6752d(), ", ")));
            this.f5325x.setVisibility(0);
            Linkify.addLinks(this.f5325x, Pattern.compile("([0-9/]+\\s*)+"), "tel:");
        }
        if (!this.f5308g.m6754e().isEmpty()) {
            this.f5326y.setText(getString(R.string.cinema_email, C1998s.m6367a(this.f5308g.m6754e(), ", ")));
            this.f5326y.setVisibility(0);
            Linkify.addLinks(this.f5326y, 2);
        }
        if (this.f5308g.m6748c() != null) {
            this.f5327z.setText(getString(R.string.cinema_web, this.f5308g.m6748c()));
            this.f5327z.setVisibility(0);
            Linkify.addLinks(this.f5327z, 1);
        }
        this.f5324w.setOnClickListener(new C21917(this));
    }

    private void m7846l() {
        if (this.f5308g.m6761m()) {
            this.f5321t.setText(R.string.menu_remove_from_favorites);
        } else {
            this.f5321t.setText(R.string.menu_add_to_favorites);
        }
    }

    private void m7847m() {
        double latitude;
        double d = 0.0d;
        if (this.f5308g.m6755f() != null) {
            latitude = this.f5308g.m6755f().getLatitude();
            d = this.f5308g.m6755f().getLongitude();
        } else {
            latitude = 0.0d;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + latitude + "," + d + "?q=" + Uri.encode(this.f5308g.m6736a()) + "&z=" + String.valueOf(21))));
    }

    private void m7848n() {
        this.f5308g.m6751c(true);
        m7846l();
        this.f5302a.mo3493a(this.f5307f, new C21928(this), this.f5305d.m6220h());
    }

    private void m7849o() {
        this.f5308g.m6751c(false);
        m7846l();
        this.f5302a.mo3502b(this.f5307f, new C21939(this), this.f5305d.m6220h());
    }

    private void m7850q() {
        m7851r();
        this.f5317p = new C2086a(getActivity(), this.f5318q);
        getListView().setAdapter(this.f5317p);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2097e) {
            this.f5303b.mo3575a(((C2097e) itemAtPosition).m7364c().m6777g(), getActivity());
        }
    }

    private void m7851r() {
        this.f5318q = new ArrayList();
        for (Entry entry : this.f5308g.m6759k().m7106a().entrySet()) {
            List<CinemaMovie> list = (List) entry.getValue();
            this.f5318q.add(new C2101i(DateUtils.formatDateTime(getActivity(), ((Long) entry.getKey()).longValue(), 18)));
            for (CinemaMovie cinemaMovie : list) {
                if (cinemaMovie.m6777g().m6705g() == this.f5313l) {
                    cinemaMovie.m6778g(true);
                }
                this.f5318q.add(new C2097e(cinemaMovie));
            }
        }
    }

    private void m7852s() {
        if (this.f5315n.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5315n.startAnimation(b);
            }
            this.f5315n.setVisibility(8);
            if (getView() != null) {
                b = m6379b(17432576);
                if (b != null) {
                    getListView().startAnimation(b);
                } else {
                    getListView().setVisibility(0);
                }
            }
        }
    }

    private void m7853t() {
        ((TextView) getView().findViewById(16908292)).setText(R.string.cinema_programm_empty);
    }

    public void mo3322a() {
        this.f5309h = false;
    }

    public void mo3323a(Exception exception) {
        this.f5309h = false;
        this.f5310i = true;
        this.f5311j = exception;
        C1988j.m6341a(getActivity(), this.f5315n, this.f5316o, this.f5311j);
        if (this.f5319r != null) {
            this.f5319r.m7412a(2);
        }
    }

    public String mo3436p() {
        return "/cinemas/detail";
    }
}
