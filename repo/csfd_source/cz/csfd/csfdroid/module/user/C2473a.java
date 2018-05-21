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
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.list.p063a.C2099g;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2116x;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.creator.C2234f;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.user.C2489d.C2472a;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FanclubsFragment */
public class C2473a extends C1999d implements C2472a {
    private CsfdApplication f6189a;
    private C2489d f6190b;
    private C2366h f6191c;
    private C2234f f6192d;
    private User f6193e;
    private Section f6194f;
    private List<C2083a> f6195g;
    private List<Object> f6196h;
    private C2086a f6197i;
    private boolean f6198j = false;
    private boolean f6199k = false;
    private boolean f6200l;
    private Exception f6201m;
    private LoadingView f6202n;
    private OnClickListener f6203o;
    private View f6204p;

    /* compiled from: FanclubsFragment */
    class C24691 implements OnClickListener {
        final /* synthetic */ C2473a f6186a;

        C24691(C2473a c2473a) {
            this.f6186a = c2473a;
        }

        public void onClick(View view) {
            this.f6186a.m9070h();
            this.f6186a.f6202n.setOnTryAgainListener(null);
        }
    }

    /* compiled from: FanclubsFragment */
    class C24702 implements Runnable {
        final /* synthetic */ C2473a f6187a;

        C24702(C2473a c2473a) {
            this.f6187a = c2473a;
        }

        public void run() {
            this.f6187a.m9071i();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f6189a = m6380c().m6292m();
        this.f6190b = this.f6189a.m6219g().mo3459i();
        this.f6191c = this.f6189a.m6219g().mo3453c();
        this.f6192d = this.f6189a.m6219g().mo3454d();
        this.f6193e = new User(getArguments().getInt("user_id"));
        this.f6194f = (Section) getArguments().getSerializable("fanclub");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6202n = (LoadingView) view.findViewById(R.id.loading);
        this.f6203o = new C24691(this);
        if (this.f6198j || this.f6199k) {
            this.f6202n.setVisibility(0);
        }
        if (this.f6199k) {
            C1988j.m6341a(getActivity(), this.f6202n, this.f6203o, this.f6201m);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.USER, null, mo3436p());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f6198j && !this.f6199k) {
            if (this.f6200l) {
                setListAdapter(null);
                m9068b(this.f6196h);
                return;
            }
            m9070h();
        }
    }

    private void m9070h() {
        m6380c().m6277a(m6380c(), new C24702(this));
    }

    private void m9071i() {
        this.f6190b.mo3655a(this.f6193e, this.f6194f, (C2472a) this, this.f6189a.m6220h());
    }

    public void mo3417g() {
        this.f6198j = true;
        this.f6202n.setVisibility(0);
        this.f6202n.m9451e();
        this.f6202n.m9448b();
    }

    public void m9078a(List<Object> list) {
        this.f6198j = false;
        this.f6199k = false;
        this.f6200l = true;
        this.f6196h = list;
        if (getActivity() != null) {
            m9068b((List) list);
            m9072j();
        }
    }

    private void m9072j() {
        if (this.f6202n.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f6202n.startAnimation(b);
            }
            this.f6202n.setVisibility(8);
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

    private View m9073k() {
        return getActivity().getLayoutInflater().inflate(R.layout.list_item_user_details_header, getListView(), false);
    }

    private void m9068b(List<Object> list) {
        m6377a(C2146b.USER, null);
        this.f6204p = m9073k();
        getListView().addHeaderView(this.f6204p);
        C2488c.m9117a(this.f6204p, this.f6193e);
        if (list.size() > 0) {
            this.f6195g = new ArrayList();
            this.f6195g.add(new C2101i(this.f6194f.m7078c()));
            m9066a(list, this.f6195g);
            this.f6197i = new C2086a(getActivity(), this.f6195g);
            setListAdapter(this.f6197i);
            return;
        }
        ((TextView) getView().findViewById(16908292)).setText(R.string.section_empty);
        getView().findViewById(R.id.loading).setVisibility(8);
    }

    private void m9066a(List<Object> list, List<C2083a> list2) {
        int size = list2.size();
        int size2 = list.size();
        for (int i = size - 1; i < size2; i++) {
            Object obj;
            switch (this.f6194f) {
                case FANCLUB_FILMS:
                case FANCLUB_SERIES:
                case FANCLUB_SHOWS:
                    C2094q c2094q = new C2094q((MovieInfo) list.get(i), 0);
                    break;
                case FANCLUB_DIRECTORS:
                case FANCLUB_ACTORS:
                case FANCLUB_ACTRESSES:
                case FANCLUB_COMPOSERS:
                case FANCLUB_SCREENWRITERS:
                case FANCLUB_CINEMATOGRAPHERS:
                    C2099g c2099g = new C2099g((MovieCreator) list.get(i), false);
                    break;
                case FAVOURITE_USERS:
                    C2116x c2116x = new C2116x((User) list.get(i));
                    break;
                default:
                    obj = null;
                    break;
            }
            list2.add(obj);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2094q) {
            this.f6191c.mo3575a(((C2094q) itemAtPosition).m7332i(), getActivity());
        } else if (itemAtPosition instanceof C2099g) {
            this.f6192d.mo3516a(((C2099g) itemAtPosition).m7379c(), getActivity());
        } else if (itemAtPosition instanceof C2116x) {
            this.f6190b.mo3653a(getActivity(), ((C2116x) itemAtPosition).m7463c());
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void mo3322a() {
        this.f6198j = false;
    }

    public void mo3323a(Exception exception) {
        this.f6198j = false;
        this.f6199k = true;
        this.f6201m = exception;
        C1988j.m6341a(getActivity(), this.f6202n, this.f6203o, this.f6201m);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_web:
                m9074l();
                m6378a("actionbar", "web", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m9074l() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6190b.mo3649a(this.f6193e, this.f6194f))));
    }

    public String mo3436p() {
        return "/user/fanclubs";
    }
}
