package cz.csfd.csfdroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.TextView;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.list.p063a.C2105m.C2061a;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p058a.C1949a;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.List;

/* compiled from: LoadingListFragment */
public abstract class C2063g<T> extends C1999d implements C1949a, C1945a<T> {
    protected boolean f4835a = true;
    protected CsfdApplication f4836b;
    protected boolean f4837c = false;
    protected boolean f4838d = false;
    protected boolean f4839e = false;
    protected Exception f4840f;
    protected LoadingView f4841g;
    protected OnClickListener f4842h;
    protected T f4843i;
    private ListAdapter f4844j;
    private C2105m f4845k;

    /* compiled from: LoadingListFragment */
    class C20591 implements OnClickListener {
        final /* synthetic */ C2063g f4832a;

        C20591(C2063g c2063g) {
            this.f4832a = c2063g;
        }

        public void onClick(View view) {
            this.f4832a.g_();
            this.f4832a.f4841g.setOnTryAgainListener(null);
        }
    }

    /* compiled from: LoadingListFragment */
    class C20602 implements Runnable {
        final /* synthetic */ C2063g f4833a;

        C20602(C2063g c2063g) {
            this.f4833a = c2063g;
        }

        public void run() {
            this.f4833a.m7226m();
            this.f4833a.mo3433j();
        }
    }

    /* compiled from: LoadingListFragment */
    class C20623 implements C2061a {
        final /* synthetic */ C2063g f4834a;

        C20623(C2063g c2063g) {
            this.f4834a = c2063g;
        }

        public void mo3416a() {
            if (this.f4834a.f4845k != null && this.f4834a.f4845k.m7417d() != 2 && !this.f4834a.f4837c) {
                this.f4834a.g_();
            }
        }
    }

    protected abstract void mo3432b(T t);

    protected abstract void mo3433j();

    protected abstract void mo3434k();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(this.f4835a);
        setHasOptionsMenu(true);
        this.f4836b = m6380c().m6292m();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f4841g = (LoadingView) view.findViewById(R.id.loading);
        this.f4842h = new C20591(this);
        if ((this.f4837c || this.f4838d) && !this.f4839e) {
            this.f4841g.setVisibility(0);
        }
        if (this.f4838d) {
            C1988j.m6341a(getActivity(), this.f4841g, this.f4842h, this.f4840f);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (mo3511l()) {
            mo3417g();
        }
    }

    protected void m7230a(View view, C2146b c2146b) {
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(c2146b, null);
        if (this.f4844j != null) {
            setListAdapter(this.f4844j);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(c2146b, null, mo3436p());
    }

    protected void mo3417g() {
        if (!this.f4837c && !this.f4838d) {
            if (!this.f4839e) {
                g_();
            } else if (this.f4844j != null) {
                setListAdapter(this.f4844j);
                m7227n();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        mo3434k();
    }

    public void setListAdapter(ListAdapter listAdapter) {
        this.f4844j = listAdapter;
        super.setListAdapter(listAdapter);
    }

    protected void g_() {
        m6380c().m6277a(m6380c(), new C20602(this));
    }

    private void m7226m() {
        this.f4837c = true;
        if (!this.f4839e) {
            this.f4841g.setVisibility(0);
            this.f4841g.m9451e();
            this.f4841g.m9448b();
        }
    }

    public void mo3324a(T t) {
        if (isAdded()) {
            this.f4837c = false;
            if (t == null) {
                this.f4838d = true;
                this.f4840f = new NullPointerException("Result is null.");
                C1988j.m6341a(getActivity(), this.f4841g, this.f4842h, this.f4840f);
                return;
            }
            this.f4838d = false;
            this.f4839e = true;
            this.f4843i = t;
            mo3432b((Object) t);
            m7227n();
            TextView textView = (TextView) getView().findViewById(16908292);
            if (textView != null) {
                textView.setText(R.string.empty);
            }
        }
    }

    private void m7227n() {
        if (this.f4841g.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f4841g.startAnimation(b);
            }
            this.f4841g.setVisibility(8);
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

    private void m7228o() {
        if (this.f4841g.getVisibility() == 8) {
            Animation b = m6379b(17432576);
            if (b != null) {
                this.f4841g.startAnimation(b);
            }
            this.f4841g.setVisibility(0);
            if (getView() != null) {
                b = m6379b(17432577);
                if (b != null) {
                    getListView().setVisibility(8);
                    getListView().startAnimation(b);
                    return;
                }
                getListView().setVisibility(8);
            }
        }
    }

    public void mo3322a() {
        this.f4837c = false;
    }

    public void mo3323a(Exception exception) {
        if (isAdded()) {
            this.f4837c = false;
            this.f4838d = true;
            this.f4840f = exception;
            C1988j.m6341a(getActivity(), this.f4841g, this.f4842h, this.f4840f);
            if (this.f4845k != null) {
                this.f4845k.m7412a(2);
            }
        }
    }

    protected void m7233a(List<C2083a> list) {
        if (list.size() > 0 && list.get(list.size() - 1) == this.f4845k) {
            list.remove(list.size() - 1);
            this.f4845k = null;
        } else if (list.size() > 0 && list.get(0) == this.f4845k) {
            list.remove(0);
            this.f4845k = null;
        }
    }

    protected void m7234a(List<C2083a> list, int i) {
        this.f4845k = m7236c(i);
        list.add(this.f4845k);
    }

    protected C2105m m7236c(int i) {
        this.f4845k = new C2105m(getString(i), new C20623(this));
        this.f4845k.m7413a(this.f4842h);
        return this.f4845k;
    }

    protected void m7238i() {
        if (!this.f4837c && this.f4839e) {
            this.f4841g.m9451e();
            this.f4841g.m9448b();
            m7228o();
            g_();
        }
    }

    protected boolean mo3511l() {
        return true;
    }
}
