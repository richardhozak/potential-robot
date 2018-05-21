package cz.csfd.csfdroid.module.user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.TextView;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.list.p063a.C2117y;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.user.C2489d.C2477b;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RatingsFragment */
public class C2478b extends C1999d implements C2477b {
    private CsfdApplication f6208a;
    private C2489d f6209b;
    private C2366h f6210c;
    private User f6211d;
    private List<C2083a> f6212e;
    private C2086a f6213f;
    private boolean f6214g;
    private boolean f6215h = false;
    private boolean f6216i = false;
    private Exception f6217j;
    private boolean f6218k = false;
    private LoadingView f6219l;
    private OnClickListener f6220m;
    private C2105m f6221n;
    private View f6222o;
    private List<C2028e> f6223p;

    /* compiled from: RatingsFragment */
    class C24741 implements OnClickListener {
        final /* synthetic */ C2478b f6205a;

        C24741(C2478b c2478b) {
            this.f6205a = c2478b;
        }

        public void onClick(View view) {
            this.f6205a.m9092h();
            this.f6205a.f6219l.setOnTryAgainListener(null);
            if (this.f6205a.f6221n != null) {
                this.f6205a.f6221n.m7412a(1);
            }
        }
    }

    /* compiled from: RatingsFragment */
    class C24752 implements Runnable {
        final /* synthetic */ C2478b f6206a;

        C24752(C2478b c2478b) {
            this.f6206a = c2478b;
        }

        public void run() {
            this.f6206a.m9093i();
        }
    }

    /* compiled from: RatingsFragment */
    class C24763 implements C2061a {
        final /* synthetic */ C2478b f6207a;

        C24763(C2478b c2478b) {
            this.f6207a = c2478b;
        }

        public void mo3416a() {
            if (this.f6207a.f6221n != null && this.f6207a.f6221n.m7417d() != 2) {
                this.f6207a.m9092h();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f6208a = m6380c().m6292m();
        this.f6209b = this.f6208a.m6219g().mo3459i();
        this.f6210c = this.f6208a.m6219g().mo3453c();
        this.f6211d = new User(getArguments().getInt("user_id"));
        this.f6214g = getArguments().getBoolean("comments");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6219l = (LoadingView) view.findViewById(R.id.loading);
        this.f6220m = new C24741(this);
        if (this.f6215h || this.f6216i) {
            this.f6219l.setVisibility(0);
        }
        if (this.f6216i) {
            C1988j.m6341a(getActivity(), this.f6219l, this.f6220m, this.f6217j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.USER, null, mo3436p());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f6215h && !this.f6216i) {
            if (this.f6211d.m6824i()) {
                setListAdapter(null);
                m9096l();
                setListAdapter(this.f6213f);
                return;
            }
            m9092h();
        }
    }

    private void m9092h() {
        m6380c().m6277a(m6380c(), new C24752(this));
    }

    private void m9093i() {
        if (this.f6214g) {
            this.f6209b.mo3660b(this.f6211d, (C2477b) this, this.f6208a.m6220h());
        } else {
            this.f6209b.mo3656a(this.f6211d, (C2477b) this, this.f6208a.m6220h());
        }
    }

    public void mo3417g() {
        this.f6215h = true;
        if (!this.f6218k) {
            this.f6219l.setVisibility(0);
            this.f6219l.m9451e();
            this.f6219l.m9448b();
        }
    }

    public void m9101a(List<C2028e> list) {
        this.f6215h = false;
        if (getActivity() != null) {
            if (!this.f6218k) {
                m9096l();
            }
            m9087b((List) list);
            m9094j();
            this.f6218k = true;
            this.f6223p = list;
        }
    }

    private void m9094j() {
        if (this.f6219l.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f6219l.startAnimation(b);
            }
            this.f6219l.setVisibility(8);
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

    private View m9095k() {
        return getActivity().getLayoutInflater().inflate(R.layout.list_item_user_details_header, getListView(), false);
    }

    private void m9096l() {
        m6377a(C2146b.USER, null);
        this.f6222o = m9095k();
        getListView().addHeaderView(this.f6222o);
        C2488c.m9117a(this.f6222o, this.f6211d);
    }

    private void m9087b(List<C2028e> list) {
        if (list.size() <= 0 && this.f6213f == null) {
            ((TextView) getView().findViewById(16908292)).setText(R.string.section_empty);
        } else if (this.f6213f == null) {
            this.f6212e = new ArrayList();
            String string = getString(R.string.film_ratings);
            if (this.f6214g) {
                string = getString(R.string.film_comments);
            }
            this.f6212e.add(new C2101i(string));
            m9085a((List) list, this.f6212e);
            this.f6213f = new C2086a(getActivity(), this.f6212e);
            setListAdapter(this.f6213f);
        } else {
            m9085a((List) list, this.f6212e);
            this.f6213f.notifyDataSetChanged();
        }
    }

    private void m9085a(List<C2028e> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int a = m9083a((List) list2, size) - 1; a < size2; a++) {
            list2.add(new C2117y((C2028e) list.get(a)));
        }
        m9089c(this.f6212e);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2117y) {
            this.f6210c.mo3575a(((C2117y) itemAtPosition).m7332i(), getActivity());
        }
    }

    private int m9083a(List<C2083a> list, int i) {
        if (i <= 0 || list.get(i - 1) != this.f6221n) {
            return i;
        }
        list.remove(i - 1);
        this.f6221n = null;
        return i - 1;
    }

    private void m9089c(List<C2083a> list) {
        if (!this.f6211d.m6824i()) {
            m9091d((List) list);
        }
    }

    private void m9091d(List<C2083a> list) {
        this.f6221n = new C2105m(getString(R.string.fetching_ratings), new C24763(this));
        this.f6221n.m7413a(this.f6220m);
        try {
            list.add(this.f6221n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6209b.mo3650a();
    }

    public void mo3322a() {
        this.f6215h = false;
    }

    public void mo3323a(Exception exception) {
        this.f6215h = false;
        this.f6216i = true;
        this.f6217j = exception;
        C1988j.m6341a(getActivity(), this.f6219l, this.f6220m, this.f6217j);
        if (this.f6221n != null) {
            this.f6221n.m7412a(2);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_web:
                m9097m();
                m6378a("actionbar", "web", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m9097m() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6209b.mo3649a(this.f6211d, this.f6214g ? Section.FILM_COMMENTS : Section.FILM_RATINGS))));
    }

    public String mo3436p() {
        return "/user/ratings";
    }
}
