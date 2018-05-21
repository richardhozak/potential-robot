package cz.csfd.csfdroid.module.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import cz.csfd.csfdroid.C1964b;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1995q;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchMoviesFragment */
public class C2437e extends C1999d implements C1973d {
    private C1995q f6063a;
    private List<C2083a> f6064b;
    private boolean f6065c = false;
    private LoadingView f6066d;
    private TextView f6067e;
    private boolean f6068f;
    private C2086a f6069g;
    private InterstitialAd f6070h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f6063a = new C1995q(getActivity());
        String str = ((C1964b) getActivity()).m6292m().m6226n().m7172D().f4680c;
        if (str != null) {
            this.f6070h = new InterstitialAd(getContext());
            this.f6070h.setAdUnitId(str);
            m8909i();
        }
    }

    private void m8909i() {
        this.f6070h.loadAd(new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6066d = (LoadingView) view.findViewById(R.id.loading);
        this.f6067e = (TextView) view.findViewById(16908292);
        if (this.f6068f) {
            m8910j();
        } else {
            m8911a();
        }
        getFragmentManager().getFragment(getArguments(), "_parent").setTargetFragment(this, 1);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.SEARCH, null);
        if (this.f6069g != null) {
            setListAdapter(this.f6069g);
        }
    }

    public void mo3477h() {
        m6382e();
        if (this.f6065c) {
            m6378a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f6065c = true;
        m6378a(mo3436p(), "selected", "first_time", 0);
    }

    public void onResume() {
        super.onResume();
        this.f6063a.m6362a((C2086a) getListAdapter());
    }

    public void m8911a() {
        if (getView() != null) {
            getListView().setVisibility(8);
            this.f6067e.setVisibility(8);
            this.f6066d.setVisibility(0);
            this.f6066d.m9451e();
            this.f6066d.m9448b();
        }
    }

    public void m8912a(OnClickListener onClickListener, Exception exception) {
        C1988j.m6341a(getActivity(), this.f6066d, onClickListener, exception);
    }

    public void m8913a(List<MovieInfo> list) {
        this.f6064b = new ArrayList();
        this.f6064b.addAll(m8908b(list));
        this.f6069g = new C2086a(getActivity(), this.f6064b);
        setListAdapter(this.f6069g);
        this.f6068f = true;
        m8910j();
    }

    private void m8910j() {
        if (this.f6064b.size() == 0) {
            this.f6067e.setText(R.string.search_results_empty);
            this.f6067e.setVisibility(0);
        }
    }

    public void mo3417g() {
        Animation b;
        if (this.f6066d.getVisibility() == 0) {
            b = m6379b(17432577);
            if (b != null) {
                this.f6066d.startAnimation(b);
            }
            this.f6066d.setVisibility(8);
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

    private List<C2083a> m8908b(List<MovieInfo> list) {
        List<C2083a> arrayList = new ArrayList();
        for (MovieInfo c2094q : list) {
            arrayList.add(new C2094q(c2094q, 0));
        }
        return arrayList;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition != null && (itemAtPosition instanceof C2094q)) {
            final MovieInfo i2 = ((C2094q) itemAtPosition).m7332i();
            if (this.f6070h == null || !this.f6070h.isLoaded()) {
                m8905a(i2);
                return;
            }
            this.f6070h.setAdListener(new AdListener(this) {
                final /* synthetic */ C2437e f6062b;

                public void onAdClosed() {
                    this.f6062b.m8909i();
                    this.f6062b.m8905a(i2);
                }
            });
            this.f6070h.show();
        }
    }

    private void m8905a(MovieInfo movieInfo) {
        C1998s.m6365a(getActivity()).m6219g().mo3453c().mo3575a(movieInfo, getActivity());
    }

    public String mo3436p() {
        return "/search/movies";
    }
}
