package cz.csfd.csfdroid.module.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.TextView;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2116x;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchUsersFragment */
public class C2438f extends C1999d implements C1973d {
    private C1995q f6071a;
    private List<C2083a> f6072b;
    private boolean f6073c = false;
    private LoadingView f6074d;
    private TextView f6075e;
    private boolean f6076f;
    private C2086a f6077g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f6071a = new C1995q(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6074d = (LoadingView) view.findViewById(R.id.loading);
        this.f6075e = (TextView) view.findViewById(16908292);
        if (this.f6076f) {
            m8919i();
        } else {
            m8920a();
        }
        getFragmentManager().getFragment(getArguments(), "_parent").setTargetFragment(this, 3);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.SEARCH, null);
        if (this.f6077g != null) {
            setListAdapter(this.f6077g);
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f6073c) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f6073c = true;
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    public void onResume() {
        super.onResume();
        this.f6071a.m6362a((C2086a) getListAdapter());
    }

    public void m8920a() {
        if (getView() != null) {
            getListView().setVisibility(8);
            this.f6075e.setVisibility(8);
            this.f6074d.setVisibility(0);
            this.f6074d.m9451e();
            this.f6074d.m9448b();
        }
    }

    public void m8921a(OnClickListener onClickListener, Exception exception) {
        getListView().setVisibility(8);
        C1988j.m6341a(getActivity(), this.f6074d, onClickListener, exception);
    }

    public void m8922a(List<User> list) {
        this.f6072b = new ArrayList();
        this.f6072b.addAll(m8918b(list));
        this.f6077g = new C2086a(getActivity(), this.f6072b);
        setListAdapter(this.f6077g);
        this.f6076f = true;
        m8919i();
    }

    private void m8919i() {
        if (this.f6072b.size() == 0) {
            this.f6075e.setText(R.string.search_results_empty);
            this.f6075e.setVisibility(0);
        }
    }

    public void mo3417g() {
        Animation b;
        if (this.f6074d.getVisibility() == 0) {
            b = m6379b(17432577);
            if (b != null) {
                this.f6074d.startAnimation(b);
            }
            this.f6074d.setVisibility(8);
        }
        if (getView() != null) {
            b = m6379b(17432576);
            if (b != null) {
                getListView().startAnimation(b);
            } else {
                getListView().setVisibility(0);
            }
        }
    }

    private List<C2083a> m8918b(List<User> list) {
        List<C2083a> arrayList = new ArrayList();
        for (User c2116x : list) {
            arrayList.add(new C2116x(c2116x));
        }
        return arrayList;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        m8917a(((C2116x) listView.getItemAtPosition(i)).m7463c());
    }

    private void m8917a(User user) {
        C1998s.m6365a(getActivity()).m6219g().mo3459i().mo3653a(getActivity(), user);
    }

    public String mo3436p() {
        return "/search/users";
    }
}
