package cz.csfd.csfdroid.module.creator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1970b.C1969a;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1991m;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;

/* compiled from: CreatorDetailsFragment */
public class C2227c extends C1974c {
    private MovieCreator f5430a;
    private C1970b f5431b;
    private ViewPager f5432c;
    private SlidingTabLayout f5433d;
    private CsfdApplication f5434e;
    private C2234f f5435f;
    private int f5436g;

    /* compiled from: CreatorDetailsFragment */
    class C22262 implements OnDismissListener {
        final /* synthetic */ C2227c f5429a;

        C22262(C2227c c2227c) {
            this.f5429a = c2227c;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5429a.m6320d().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        this.f5434e = m6320d().m6292m();
        this.f5435f = this.f5434e.m6219g().mo3454d();
        try {
            this.f5436g = this.f5435f.mo3512a(Uri.parse(getArguments().getString("_data")));
            this.f5430a = m8017c(this.f5436g);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6314a(R.string.error_bad_url);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_creator_details, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m8016b(view);
        if (this.f5430a != null) {
            m8015a(view);
            m8018c(view);
        }
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(this.f5436g));
        adBottomView.m7621a(C2146b.CREATOR, hashMap, mo3436p());
        this.f5431b.m6305a(new C1969a(this) {
            final /* synthetic */ C2227c f5428b;

            public void mo3507a(int i) {
                adBottomView.m7620a();
            }
        });
    }

    public void m8020a(MovieCreator movieCreator) {
        this.f5430a = movieCreator;
        View view = getView();
        m8015a(view);
        m8018c(view);
    }

    private MovieCreator m8017c(int i) {
        try {
            C2056d k = this.f5434e.m6223k();
            if (k.m7166b(Integer.valueOf(i))) {
                return C1991m.m6346a(i, getActivity());
            }
            BasicEntity movieCreator = new MovieCreator(i);
            k.m7164a(movieCreator);
            return movieCreator;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            AlertDialog a = C1984g.m6336a(getActivity(), R.string.error);
            a.setOnDismissListener(new C22262(this));
            a.show();
            return null;
        }
    }

    private void m8015a(View view) {
        ((TextView) view.findViewById(R.id.creator_name)).setText(this.f5430a.toString());
    }

    private void m8016b(View view) {
        this.f5433d = (SlidingTabLayout) view.findViewById(R.id.tabs);
        this.f5432c = (ViewPager) view.findViewById(R.id.creator_detail_view_pager);
        C1998s.m6369a(this.f5432c, 2);
        this.f5431b = new C1970b(getActivity(), this.f5432c, this.f5433d);
        Bundle bundle = new Bundle();
        bundle.putInt("creatorId", this.f5436g);
        this.f5431b.m6306b(new C1972c(getString(R.string.tab_creator_biography), C2224b.class, bundle, this));
        this.f5431b.m6306b(new C1972c(getString(R.string.tab_creator_filmography), C2232d.class, bundle, this));
        this.f5432c.setAdapter(this.f5431b);
        this.f5433d.setViewPager(this.f5432c);
    }

    private void m8018c(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("creatorId", this.f5436g);
        if (this.f5430a.m6888w() > 0) {
            this.f5431b.m6306b(new C1972c(getString(R.string.tab_creator_videos), C2236h.class, bundle, this));
        }
        if (this.f5430a.m6887v() > 0) {
            this.f5431b.m6306b(new C1972c(getString(R.string.tab_creator_gallery), C2233e.class, bundle, this));
        }
        this.f5431b.notifyDataSetChanged();
        this.f5433d.m9468a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_web:
                m8019h();
                m6316a("actionbar", "web", mo3436p(), 0);
                return true;
            case R.id.menu_item_share:
                m8014a();
                m6316a("actionbar", "share", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m8014a() {
        if (this.f5430a == null || !this.f5430a.m6880o()) {
            Toast.makeText(getActivity(), R.string.share_creator_not_loaded, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.share_creator));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5430a.toString()).append("\n").append(C1991m.m6348b(this.f5430a));
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        startActivity(Intent.createChooser(intent, getString(R.string.share_with)));
    }

    private void m8019h() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(C1991m.m6348b(this.f5430a)));
        startActivity(intent);
    }

    public String mo3436p() {
        return "/creator";
    }
}
