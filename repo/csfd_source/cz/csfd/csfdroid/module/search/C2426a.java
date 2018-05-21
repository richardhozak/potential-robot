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
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2099g;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchCreatorsFragment */
public class C2426a extends C1999d implements C1973d {
    private C1995q f6031a;
    private List<C2083a> f6032b;
    private boolean f6033c = false;
    private LoadingView f6034d;
    private TextView f6035e;
    private boolean f6036f;
    private C2086a f6037g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f6031a = new C1995q(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6034d = (LoadingView) view.findViewById(R.id.loading);
        this.f6035e = (TextView) view.findViewById(16908292);
        if (this.f6036f) {
            m8865i();
        } else {
            m8866a();
        }
        getFragmentManager().getFragment(getArguments(), "_parent").setTargetFragment(this, 2);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.SEARCH, null);
        if (this.f6037g != null) {
            setListAdapter(this.f6037g);
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f6033c) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f6033c = true;
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    public void onResume() {
        super.onResume();
        this.f6031a.m6362a((C2086a) getListAdapter());
    }

    public void m8866a() {
        if (getView() != null) {
            getListView().setVisibility(8);
            this.f6035e.setVisibility(8);
            this.f6034d.setVisibility(0);
            this.f6034d.m9451e();
            this.f6034d.m9448b();
        }
    }

    public void m8867a(OnClickListener onClickListener, Exception exception) {
        getListView().setVisibility(8);
        C1988j.m6341a(getActivity(), this.f6034d, onClickListener, exception);
    }

    public void m8868a(List<MovieCreator> list) {
        this.f6032b = new ArrayList();
        this.f6032b.addAll(m8864b(list));
        this.f6037g = new C2086a(getActivity(), this.f6032b);
        setListAdapter(this.f6037g);
        this.f6036f = true;
        m8865i();
    }

    private void m8865i() {
        if (this.f6032b.size() == 0) {
            this.f6035e.setText(R.string.search_results_empty);
            this.f6035e.setVisibility(0);
        }
    }

    public void mo3417g() {
        Animation b;
        if (this.f6034d.getVisibility() == 0) {
            b = m6379b(17432577);
            if (b != null) {
                this.f6034d.startAnimation(b);
            }
            this.f6034d.setVisibility(8);
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

    private List<C2083a> m8864b(List<MovieCreator> list) {
        List<C2083a> arrayList = new ArrayList();
        for (MovieCreator c2099g : list) {
            arrayList.add(new C2099g(c2099g, false));
        }
        return arrayList;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        m8863a(((C2099g) listView.getItemAtPosition(i)).m7379c());
    }

    private void m8863a(MovieCreator movieCreator) {
        C1998s.m6365a(getActivity()).m6219g().mo3454d().mo3516a(movieCreator, getActivity());
    }

    public String mo3436p() {
        return "/search/creators";
    }
}
