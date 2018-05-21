package cz.csfd.csfdroid.module.home;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C1950a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityType;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.HomeList;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.store.cache.C2049b;
import cz.csfd.csfdroid.data.store.cache.C2049b.C2048a;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.AdBannerItemView;
import cz.csfd.csfdroid.list.p063a.C2092a;
import cz.csfd.csfdroid.list.p063a.C2093b;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.list.p063a.C2096d;
import cz.csfd.csfdroid.list.p063a.C2100h;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2111s;
import cz.csfd.csfdroid.list.p063a.C2111s.C2110a;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.cinema.C2197e;
import cz.csfd.csfdroid.module.home.C2284d.C2281a;
import cz.csfd.csfdroid.module.home.C2284d.Enum_ReleaseType;
import cz.csfd.csfdroid.module.movie.C2366h.C2364c;
import cz.csfd.csfdroid.oauth.C2540c.C1959b;
import cz.csfd.csfdroid.p061d.C1978a;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: HomeFragment */
public class C2282c extends C1974c implements OnItemClickListener, C2110a, C2281a {
    private CsfdApplication f5583a;
    private C2284d f5584b;
    private C2147a f5585c;
    private C2197e f5586d;
    private C2057e f5587e;
    private C1995q f5588f;
    private MenuItem f5589g;
    private EditText f5590h;
    private Handler f5591i;
    private Exception f5592j;
    private boolean f5593k = false;
    private boolean f5594l = false;
    private List<String> f5595m;
    private Map<String, List<? extends BasicEntity>> f5596n;
    private ListView f5597o;
    private C2086a f5598p;
    private LoadingView f5599q;
    private OnClickListener f5600r;
    private C2049b f5601s;

    /* compiled from: HomeFragment */
    class C22711 implements OnClickListener {
        final /* synthetic */ C2282c f5571a;

        C22711(C2282c c2282c) {
            this.f5571a = c2282c;
        }

        public void onClick(View view) {
            ((C2157b) this.f5571a.m6320d()).m7699u();
        }
    }

    /* compiled from: HomeFragment */
    class C22722 implements OnClickListener {
        final /* synthetic */ C2282c f5572a;

        C22722(C2282c c2282c) {
            this.f5572a = c2282c;
        }

        public void onClick(View view) {
            this.f5572a.mo3536b();
        }
    }

    /* compiled from: HomeFragment */
    class C22733 implements OnClickListener {
        final /* synthetic */ C2282c f5573a;

        C22733(C2282c c2282c) {
            this.f5573a = c2282c;
        }

        public void onClick(View view) {
            this.f5573a.m8228l();
            this.f5573a.f5599q.setOnTryAgainListener(null);
        }
    }

    /* compiled from: HomeFragment */
    class C22755 implements Runnable {
        final /* synthetic */ C2282c f5576a;

        C22755(C2282c c2282c) {
            this.f5576a = c2282c;
        }

        public void run() {
            this.f5576a.m8229m();
        }
    }

    /* compiled from: HomeFragment */
    class C22777 implements Runnable {
        final /* synthetic */ C2282c f5579a;

        C22777(C2282c c2282c) {
            this.f5579a = c2282c;
        }

        public void run() {
            this.f5579a.m8209a(false);
        }
    }

    /* compiled from: HomeFragment */
    class C22788 implements C1947a {
        final /* synthetic */ C2282c f5580a;

        C22788(C2282c c2282c) {
            this.f5580a = c2282c;
        }

        public void mo3328a() {
            this.f5580a.m6320d().mo3469n();
            this.f5580a.m8222i();
            this.f5580a.f5583a.m6222j().m7165b();
            this.f5580a.f5598p.m7312a();
            this.f5580a.f5598p.notifyDataSetChanged();
            this.f5580a.f5595m = this.f5580a.m8223j();
            this.f5580a.m8228l();
        }
    }

    /* compiled from: HomeFragment */
    class C22809 implements C1959b {
        final /* synthetic */ C2282c f5582a;

        /* compiled from: HomeFragment */
        class C22791 implements Runnable {
            final /* synthetic */ C22809 f5581a;

            C22791(C22809 c22809) {
                this.f5581a = c22809;
            }

            public void run() {
                this.f5581a.f5582a.m6320d().mo3469n();
                this.f5581a.f5582a.m8222i();
                this.f5581a.f5582a.f5583a.m6222j().m7165b();
                this.f5581a.f5582a.f5598p.m7312a();
                this.f5581a.f5582a.f5598p.notifyDataSetChanged();
                this.f5581a.f5582a.f5595m = this.f5581a.f5582a.m8223j();
                this.f5581a.f5582a.m8228l();
                Toast.makeText(this.f5581a.f5582a.f5583a, R.string.logout_success, 0).show();
            }
        }

        C22809(C2282c c2282c) {
            this.f5582a = c2282c;
        }

        public void mo3329a() {
            this.f5582a.f5591i.post(new C22791(this));
        }
    }

    public String mo3436p() {
        return "/home";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5583a = C1998s.m6365a(getActivity());
        this.f5584b = this.f5583a.m6219g().mo3451a();
        this.f5585c = this.f5583a.m6219g().mo3464n();
        this.f5586d = this.f5583a.m6219g().mo3457g();
        this.f5601s = this.f5583a.m6227o();
        this.f5591i = new Handler();
        this.f5587e = this.f5583a.m6226n();
        this.f5588f = new C1995q(getActivity());
        m8231o();
        m8232q();
        this.f5595m = m8223j();
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    private void m8222i() {
        View a = m6320d().m1367b().mo1406a();
        ImageView imageView = (ImageView) a.findViewById(R.id.actionbar_avatar);
        a = a.findViewById(R.id.actionbar_login);
        if (this.f5583a.m6229q().m6250a()) {
            imageView.setVisibility(0);
            a.setVisibility(8);
            String d = this.f5583a.m6229q().m6254d();
            if (d != null) {
                C1187t.m5432a(getActivity()).m5439a(d).m5476a(new C1978a()).m5477a(imageView);
            }
            imageView.setOnClickListener(new C22711(this));
            return;
        }
        imageView.setVisibility(8);
        a.setVisibility(0);
        a.setOnClickListener(new C22722(this));
    }

    private List<String> m8223j() {
        List<String> c = this.f5583a.m6226n().m7193c();
        if (c.contains("favorites") && this.f5583a.m6229q().m6256f() == null) {
            c.remove("favorites");
            c.remove("favorite_cinemas");
        }
        return c;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5597o = (ListView) view.findViewById(16908298);
        this.f5597o.setOnItemClickListener(this);
        this.f5597o.setHeaderDividersEnabled(false);
        this.f5599q = (LoadingView) view.findViewById(R.id.loading);
        this.f5600r = new C22733(this);
        if (this.f5593k || this.f5594l) {
            this.f5599q.setVisibility(0);
        }
        if (this.f5594l) {
            C1988j.m6341a(getActivity(), this.f5599q, this.f5600r, this.f5592j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.HOME, null, mo3436p());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f5593k && !this.f5594l) {
            m8226k();
        }
    }

    public void onResume() {
        super.onResume();
        this.f5588f.m6362a(this.f5598p);
        List j = m8223j();
        if (!Arrays.equals(this.f5595m.toArray(), j.toArray())) {
            this.f5595m = j;
            m8228l();
        }
        for (int i = 0; i < this.f5597o.getChildCount(); i++) {
            View childAt = this.f5597o.getChildAt(i);
            if (childAt instanceof AdBannerItemView) {
                ((AdBannerItemView) childAt).m7482d();
            }
        }
    }

    public void onPause() {
        super.onPause();
        for (int i = 0; i < this.f5597o.getChildCount(); i++) {
            View childAt = this.f5597o.getChildAt(i);
            if (childAt instanceof AdBannerItemView) {
                ((AdBannerItemView) childAt).m7481c();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < this.f5597o.getChildCount(); i++) {
            View childAt = this.f5597o.getChildAt(i);
            if (childAt instanceof AdBannerItemView) {
                ((AdBannerItemView) childAt).m7483e();
            }
        }
    }

    private void m8226k() {
        if (this.f5598p != null) {
            this.f5597o.setAdapter(this.f5598p);
            return;
        }
        this.f5597o.setVisibility(8);
        final List list = this.f5595m;
        if (list.size() > 0) {
            this.f5599q.setVisibility(0);
            this.f5599q.m9451e();
            this.f5599q.m9448b();
            this.f5601s.mo3413a(this.f5595m, new C2048a(this) {
                final /* synthetic */ C2282c f5575b;

                public void mo3535a(Map<String, List<? extends BasicEntity>> map) {
                    if (this.f5575b.getActivity() != null) {
                        if (map.size() > 0) {
                            this.f5575b.m8213b((Map) map);
                        }
                        if (map.size() < list.size() || this.f5575b.f5595m.contains("favorites")) {
                            this.f5575b.m8228l();
                        }
                    }
                }
            });
            return;
        }
        m8234s();
    }

    private void m8228l() {
        m6320d().m6280a(new C22755(this), null, null);
    }

    private void m8229m() {
        m8230n();
        C1998s.m6372a(getClass(), "Fetching home lists.");
        this.f5584b.mo3544a(this.f5595m, (C2281a) this, this.f5583a.m6220h(), getActivity());
        m6316a(mo3436p(), "refresh", Arrays.toString(this.f5595m.toArray()), this.f5595m.size());
    }

    private void m8230n() {
        if (this.f5583a.m6229q().m6250a()) {
            this.f5583a.m6229q().m6255e();
        }
    }

    private void m8231o() {
        getActivity().getWindow().setSoftInputMode(3);
    }

    private void m8232q() {
        C2057e n = this.f5583a.m6226n();
        boolean e = n.m7199e();
        try {
            PackageInfo packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            if (n.m7197d() < packageInfo.versionCode) {
                n.m7177a(packageInfo.versionCode);
            }
        } catch (Exception e2) {
            C1998s.m6371a(getClass(), e2);
        }
        if (e) {
            n.m7200f();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2 && i2 == -1) {
            this.f5590h.setText((CharSequence) intent.getStringArrayListExtra("android.speech.extra.RESULTS").get(0));
            m8242a(m8233r());
        }
    }

    private String m8233r() {
        return this.f5590h.getText().toString().trim();
    }

    protected void m8242a(final String str) {
        m6320d().m6280a(new Runnable(this) {
            final /* synthetic */ C2282c f5578b;

            public void run() {
                this.f5578b.m8212b(str);
            }
        }, null, null);
    }

    private void m8212b(String str) {
        if (str.length() > 0) {
            this.f5583a.m6219g().mo3452b().mo3619a(str, getActivity());
            m6316a(mo3436p(), "search", null, 0);
        }
    }

    private void m8200a(MovieInfo movieInfo) {
        this.f5583a.m6219g().mo3453c().mo3575a(movieInfo, getActivity());
    }

    private void m8201a(MovieInfo movieInfo, C2364c c2364c) {
        this.f5583a.m6219g().mo3453c().mo3580a(movieInfo, c2364c, getActivity());
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            m8200a(((C2094q) itemAtPosition).m7332i());
        } else if (itemAtPosition instanceof C2092a) {
            ActivityEntity c = ((C2092a) itemAtPosition).m7322c();
            if (c.m6706a().equals(ActivityType.FILM_COMMENT)) {
                m8201a(c.m6717f(), C2364c.COMMENTS);
            } else {
                m8200a(c.m6717f());
            }
        } else if (itemAtPosition instanceof C2096d) {
            this.f5586d.mo3496a(getActivity(), ((C2096d) itemAtPosition).m7353c(), null);
        } else if (itemAtPosition instanceof C2101i) {
            m8202a((C2101i) itemAtPosition);
        }
    }

    private void m8202a(C2101i c2101i) {
        String c = c2101i.m7397c();
        if (c.equals("favorites")) {
            if (this.f5583a.m6229q().m6253c() > 0) {
                this.f5583a.m6219g().mo3460j().mo3523a(getActivity());
            }
        } else if (c.equals("tv_tips")) {
            startActivity(this.f5583a.m6219g().mo3462l().mo3631a(getActivity()));
        } else if (c.equals("cinema_releases")) {
            startActivity(this.f5584b.mo3539a(getActivity(), Enum_ReleaseType.CINEMA));
        } else if (c.equals("dvd_releases")) {
            startActivity(this.f5584b.mo3539a(getActivity(), Enum_ReleaseType.DVD));
        } else if (c.equals("bluray_releases")) {
            startActivity(this.f5584b.mo3539a(getActivity(), Enum_ReleaseType.BLURAY));
        } else if (c.equals("favorite_cinemas")) {
            this.f5586d.mo3503b(getActivity());
        } else if (c.equals("new_videos")) {
            startActivity(this.f5583a.m6219g().mo3465o().mo3437a(getActivity()));
        }
    }

    public void mo3537h() {
        this.f5593k = true;
        if (this.f5597o.getVisibility() == 8) {
            this.f5599q.setVisibility(0);
            this.f5599q.m9451e();
            this.f5599q.m9448b();
        }
        m8209a(true);
    }

    public void m8243a(Map<String, List<? extends BasicEntity>> map) {
        if (isAdded()) {
            this.f5593k = false;
            m8209a(false);
            if (map == null) {
                this.f5594l = true;
                C1988j.m6341a(getActivity(), this.f5599q, this.f5600r, this.f5592j);
                return;
            }
            this.f5583a.m6226n().m7185a(new Date());
            this.f5594l = false;
            m8213b((Map) map);
            m8237v();
        }
    }

    private void m8234s() {
        if (getView() != null) {
            TextView textView = (TextView) getView().findViewById(16908292);
            if (this.f5598p == null || this.f5598p.getCount() == 0) {
                textView.setText(R.string.home_empty);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    private void m8213b(Map<String, List<? extends BasicEntity>> map) {
        this.f5596n = map;
        m8206a(m8215c((Map) map));
        m8235t();
        m8236u();
        m8234s();
    }

    private void m8206a(List<C2083a> list) {
        if (this.f5598p == null) {
            this.f5598p = m8210b((List) list);
            this.f5597o.setAdapter(this.f5598p);
            return;
        }
        this.f5598p.m7314a((List) list);
    }

    private void m8235t() {
        if (this.f5599q.getVisibility() == 0) {
            Animation b = m6317b(17432577);
            if (b != null) {
                this.f5599q.startAnimation(b);
            }
            this.f5599q.setVisibility(8);
        }
    }

    private void m8236u() {
        if (this.f5597o.getVisibility() == 8 && getView() != null) {
            Animation b = m6317b(17432576);
            if (b != null) {
                this.f5597o.startAnimation(b);
            }
            this.f5597o.setVisibility(0);
        }
    }

    private C2086a m8210b(List<C2083a> list) {
        C2086a c2086a = new C2086a(getActivity(), list);
        c2086a.m7315a(true);
        return c2086a;
    }

    private List<C2083a> m8215c(Map<String, List<? extends BasicEntity>> map) {
        List<C2083a> arrayList = new ArrayList();
        List b = this.f5587e.m7188b();
        for (int i = 0; i < b.size(); i++) {
            HomeList homeList = (HomeList) b.get(i);
            if (i == 3) {
                arrayList.add(new C2093b(C2146b.HOME, mo3436p()));
            }
            if (homeList.m6799a().equals("dvd_releases")) {
                m8208a(map, arrayList, homeList.m6799a(), homeList.m6802b(), 8);
            } else if (homeList.m6799a().equals("bluray_releases")) {
                m8208a(map, arrayList, homeList.m6799a(), homeList.m6802b(), 8);
            } else {
                m8207a(map, arrayList, homeList.m6799a(), homeList.m6802b());
            }
        }
        return arrayList;
    }

    private void m8207a(Map<String, List<? extends BasicEntity>> map, List<C2083a> list, String str, String str2) {
        if (map.containsKey(str)) {
            list.addAll(m8199a((List) map.get(str), str, str2));
        }
    }

    private void m8208a(Map<String, List<? extends BasicEntity>> map, List<C2083a> list, String str, String str2, int i) {
        if (map.containsKey(str)) {
            List list2 = (List) map.get(str);
            if (i < list2.size()) {
                List arrayList = new ArrayList(list2);
                while (arrayList.size() > i) {
                    arrayList.remove((int) (Math.random() * ((double) arrayList.size())));
                }
                list2 = arrayList;
            }
            list.addAll(m8199a(list2, str, str2));
        }
    }

    private List<C2083a> m8199a(List<? extends BasicEntity> list, String str, String str2) {
        int i = 3;
        List<C2083a> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i2;
            if (str.equals("tv_tips")) {
                i2 = Calendar.getInstance().get(7);
                str2 = getString(R.string.home_tv_tips_for_day, getResources().getStringArray(R.array.days_in_week_akuzativ)[i2 - 1]);
            }
            C2101i c2101i = new C2101i(str2);
            c2101i.m7394a(str);
            if (str.equals("tv_tips") || str.equals("favorites") || str.equals("cinema_releases") || str.equals("dvd_releases") || str.equals("bluray_releases") || str.equals("favorite_cinemas") || str.equals("new_videos")) {
                c2101i.m7395a(true);
            }
            arrayList.add(c2101i);
            if (str.equals("tv_tips")) {
                i2 = 1;
            } else if (str.equals("bluray_releases") || str.equals("dvd_releases") || str.equals("cinema_releases")) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            if (list.size() < 3) {
                i = list.size();
            }
            if (str.equals("new_videos")) {
                List arrayList2 = new ArrayList();
                for (i2 = 0; i2 < list.size(); i2++) {
                    MovieInfo movieInfo = (MovieInfo) list.get(i2);
                    if (movieInfo.m6915Y() != null) {
                        arrayList2.add(movieInfo);
                    }
                }
                arrayList.add(new C2111s(arrayList2, this));
            } else if (str.equals("favorites")) {
                for (i2 = 0; i2 < i; i2++) {
                    arrayList.add(new C2092a((ActivityEntity) list.get(i2)));
                }
            } else if (str.equals("favorite_cinemas")) {
                for (i2 = 0; i2 < i; i2++) {
                    Cinema cinema = (Cinema) list.get(i2);
                    cinema.m6747b(true);
                    arrayList.add(new C2096d(cinema, 1));
                }
            } else if (str.equals("creator_profile_visits")) {
                r2 = Math.min(getResources().getInteger(R.integer.creators_grid_row_size), list.size());
                List arrayList3 = new ArrayList(r2);
                for (i2 = 0; i2 < r2; i2++) {
                    arrayList3.add((MovieCreator) list.get(i2));
                }
                arrayList.add(new C2100h(arrayList3));
            } else {
                for (r2 = 0; r2 < i; r2++) {
                    arrayList.add(new C2094q((MovieInfo) list.get(r2), i2));
                }
            }
        }
        return arrayList;
    }

    private void m8237v() {
        if (this.f5596n != null) {
            this.f5601s.mo3414a(this.f5596n);
        }
    }

    public void mo3322a() {
        this.f5593k = false;
        m8209a(false);
    }

    private void m8238w() {
        this.f5591i.post(new C22777(this));
    }

    public void mo3323a(Exception exception) {
        if (isAdded()) {
            this.f5593k = false;
            this.f5594l = true;
            this.f5592j = exception;
            C1988j.m6341a(getActivity(), this.f5599q, this.f5600r, this.f5592j);
            m8238w();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_refresh:
                this.f5595m = m8223j();
                m8228l();
                m6316a("actionbar", "refresh", mo3436p(), 0);
                return true;
            case R.id.menu_item_web:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://www.csfd.cz"));
                startActivity(intent);
                m6316a("actionbar", "web", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void mo3536b() {
        C1950a q = this.f5583a.m6229q();
        if (q.m6250a()) {
            q.m6248a(new C22809(this));
        } else {
            q.m6246a(getActivity(), new C22788(this));
        }
    }

    private void m8209a(boolean z) {
        if (this.f5589g == null) {
            return;
        }
        if (z) {
            this.f5589g.setActionView(R.layout.actionbar_indeterminate_progress);
        } else {
            this.f5589g.setActionView(null);
        }
    }

    public void setOverridingTouchTarget(View view) {
        ((MainActivity) getActivity()).setOverridingTouchTarget(view);
    }
}
