package cz.csfd.csfdroid.module.series;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.p017a.C0436a;
import android.support.v7.p017a.C0465f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.Season;
import cz.csfd.csfdroid.data.entity.Seasons;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.widget.LoadingView;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SeasonsPagerFragment */
public class C2442c extends C1974c implements C1945a<Seasons> {
    private CsfdApplication f6090a;
    private C2366h f6091b;
    private LoadingView f6092c;
    private SlidingTabLayout f6093d;
    private ViewPager f6094e;
    private int f6095f;
    private String f6096g;
    private int f6097h;
    private int f6098i;
    private C2441b f6099j;
    private List<Season> f6100k;
    private boolean f6101l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6095f = getArguments().getInt("film_id");
        this.f6096g = getArguments().getString("film_name");
        this.f6097h = getArguments().getInt("season_id");
        this.f6098i = getArguments().getInt("episode_id");
        this.f6090a = (CsfdApplication) getActivity().getApplication();
        this.f6091b = this.f6090a.m6219g().mo3453c();
        setRetainInstance(true);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C0436a b = ((C0465f) getActivity()).m1367b();
        if (b != null) {
            b.mo1421c(true);
            b.mo1422d(true);
            b.mo1425e(true);
            View a = b.mo1406a();
            if (a != null) {
                ((TextView) a.findViewById(R.id.title)).setText(this.f6096g);
                a.findViewById(R.id.actionbar_logo_container).setVisibility(8);
                a.findViewById(R.id.actionbar_drawer_button).setVisibility(8);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_seasons, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6092c = (LoadingView) view.findViewById(R.id.loading);
        this.f6093d = (SlidingTabLayout) view.findViewById(R.id.tabs);
        this.f6094e = (ViewPager) view.findViewById(R.id.pager);
        this.f6099j = new C2441b(getChildFragmentManager());
        if (this.f6100k == null) {
            this.f6092c.m9448b();
        } else {
            this.f6099j.m8935a(this.f6100k);
            this.f6094e.setAdapter(this.f6099j);
            this.f6094e.setCurrentItem(m8937h());
            this.f6093d.setViewPager(this.f6094e);
            this.f6092c.m9449c();
        }
        m8938i();
    }

    public void onStart() {
        super.onStart();
        if (this.f6100k == null) {
            this.f6091b.mo3572a(this.f6095f, (C1945a) this, this.f6090a.m6220h());
        }
    }

    public void m8940a(Seasons seasons) {
        this.f6092c.m9449c();
        this.f6092c.m9451e();
        List arrayList = new ArrayList();
        for (int i = 0; i < seasons.m7037a().size(); i++) {
            arrayList.add(0, seasons.m7037a().get(i));
        }
        this.f6100k = arrayList;
        this.f6101l = seasons.m7040b();
        this.f6099j.m8935a(this.f6100k);
        this.f6099j.m8936a(this.f6101l);
        this.f6099j.m8934a(this.f6098i);
        this.f6094e.setAdapter(this.f6099j);
        this.f6094e.setCurrentItem(m8937h());
        this.f6093d.setViewPager(this.f6094e);
        this.f6092c.m9449c();
        m8938i();
    }

    public void mo3323a(Exception exception) {
        this.f6092c.m9449c();
        this.f6092c.m9450d();
    }

    public void mo3322a() {
    }

    private int m8937h() {
        int size = this.f6100k.size() - 1;
        for (int i = 0; i < this.f6100k.size(); i++) {
            if (((Season) this.f6100k.get(i)).m7021a() == this.f6097h) {
                return i;
            }
        }
        return size;
    }

    private void m8938i() {
        SlidingTabLayout slidingTabLayout = this.f6093d;
        int i = (this.f6100k != null && this.f6100k.size() == 1 && this.f6101l) ? 8 : 0;
        slidingTabLayout.setVisibility(i);
    }

    public String mo3436p() {
        return "seasons";
    }
}
