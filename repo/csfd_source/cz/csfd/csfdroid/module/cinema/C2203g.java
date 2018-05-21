package cz.csfd.csfdroid.module.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2019c;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1970b.C1969a;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;

/* compiled from: CinemasFragment */
public class C2203g extends C1974c {
    private CsfdApplication f5346a;
    private C2057e f5347b;
    private ViewPager f5348c;
    private SlidingTabLayout f5349d;
    private C1970b f5350e;
    private int f5351f;
    private String f5352g;
    private String f5353h;

    /* compiled from: CinemasFragment */
    class C22022 implements OnClickListener {
        final /* synthetic */ C2203g f5345a;

        C22022(C2203g c2203g) {
            this.f5345a = c2203g;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f5345a.getActivity(), CinemasActivity.class);
            this.f5345a.getActivity().overridePendingTransition(0, 0);
            intent.addFlags(65536);
            this.f5345a.getActivity().finish();
            this.f5345a.getActivity().overridePendingTransition(0, 0);
            this.f5345a.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        this.f5346a = m6320d().m6292m();
        this.f5347b = this.f5346a.m6226n();
        if (getArguments() != null) {
            this.f5351f = getArguments().getInt("movie_id");
            this.f5352g = getArguments().getString("movie_name");
            this.f5353h = getArguments().getString("tab");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_cinemas, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7911a(view);
        m7910a();
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.CINEMAS, null, mo3436p());
        this.f5350e.m6305a(new C1969a(this) {
            final /* synthetic */ C2203g f5344b;

            public void mo3507a(int i) {
                adBottomView.m7620a();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(C1970b.m6302a(this.f5348c.getId(), this.f5348c.getCurrentItem()));
        if (findFragmentByTag != null) {
            findFragmentByTag.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Log.d("CinemasFragment", "onRequestPermissionsResult");
    }

    private void m7911a(View view) {
        this.f5348c = (ViewPager) view.findViewById(R.id.cinemas_pager);
        this.f5349d = (SlidingTabLayout) view.findViewById(R.id.tabs);
        this.f5350e = new C1970b(getChildFragmentManager(), getActivity(), this.f5348c, this.f5349d);
        Bundle bundle = new Bundle();
        bundle.putInt("movie_id", this.f5351f);
        this.f5350e.m6306b(new C1972c(getString(R.string.cinemas_tab_near), C2217k.class, bundle, null));
        bundle = new Bundle();
        bundle.putInt("movie_id", this.f5351f);
        this.f5350e.m6306b(new C1972c(getString(R.string.cinemas_tab_all), C2182a.class, bundle, null));
        if (this.f5346a.m6229q().m6250a()) {
            bundle = new Bundle();
            bundle.putInt("movie_id", this.f5351f);
            this.f5350e.m6306b(new C1972c(getString(R.string.cinemas_tab_favourite), C2207i.class, bundle, null));
        }
        this.f5348c.setAdapter(this.f5350e);
        this.f5349d.setViewPager(this.f5348c);
        if (this.f5353h != null && this.f5353h.equals("FAVORITE")) {
            this.f5348c.setCurrentItem(2);
        }
    }

    private void m7910a() {
        if (this.f5351f > 0) {
            RelativeLayout relativeLayout = (RelativeLayout) getView().findViewById(R.id.filter);
            ImageButton imageButton = (ImageButton) getView().findViewById(R.id.filter_cancel);
            ((TextView) getView().findViewById(R.id.movie)).setText(Html.fromHtml(getString(R.string.cinemas_play, this.f5352g)));
            relativeLayout.setVisibility(0);
            imageButton.setOnClickListener(new C22022(this));
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = true;
        switch (menuItem.getItemId()) {
            case R.id.menu_item_cinemas_without_schedule:
                if (menuItem.isChecked()) {
                    z = false;
                }
                menuItem.setChecked(z);
                this.f5347b.m7187a(menuItem.isChecked());
                return false;
            case R.id.menu_item_date_all:
            case R.id.menu_item_date_month:
            case R.id.menu_item_date_today:
            case R.id.menu_item_date_tomorrow:
            case R.id.menu_item_date_week:
            case R.id.menu_item_date_weekend:
                menuItem.setChecked(true);
                this.f5347b.m7180a(C2019c.m6697a(menuItem.getItemId()));
                return false;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public String mo3436p() {
        return "/cinemas";
    }
}
