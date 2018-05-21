package cz.csfd.csfdroid.module.cinema;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_TimeRange;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2096d;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.cinema.C2197e.C2196b;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NearCinemaListFragment */
public class C2217k extends C2181d implements C1973d {
    private boolean f5382A;
    private boolean f5383B;
    private C2197e f5384a;
    private CsfdApplication f5385b;
    private C2057e f5386c;
    private List<Cinema> f5387d;
    private boolean f5388e = false;
    private boolean f5389f = false;
    private Exception f5390g;
    private boolean f5391h = false;
    private boolean f5392i = false;
    private long f5393j;
    private LoadingView f5394k;
    private OnClickListener f5395l;
    private C2086a f5396m;
    private List<C2083a> f5397n;
    private C2105m f5398o;
    private LinearLayout f5399p;
    private ViewGroup f5400q;
    private ViewGroup f5401r;
    private TextView f5402s;
    private Location f5403t;
    private String f5404u;
    private C2216b f5405v;
    private int f5406w;
    private Enum_TimeRange f5407x;
    private boolean f5408y;
    private GoogleApiClient f5409z;

    /* compiled from: NearCinemaListFragment */
    class C22091 implements OnClickListener {
        final /* synthetic */ C2217k f5375a;

        C22091(C2217k c2217k) {
            this.f5375a = c2217k;
        }

        public void onClick(View view) {
            this.f5375a.m7967l();
            this.f5375a.f5394k.setOnTryAgainListener(null);
            if (this.f5375a.f5398o != null) {
                this.f5375a.f5398o.m7412a(1);
            }
        }
    }

    /* compiled from: NearCinemaListFragment */
    class C22102 implements OnClickListener {
        final /* synthetic */ C2217k f5376a;

        C22102(C2217k c2217k) {
            this.f5376a = c2217k;
        }

        public void onClick(View view) {
            this.f5376a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* compiled from: NearCinemaListFragment */
    class C22113 implements OnConnectionFailedListener {
        final /* synthetic */ C2217k f5377a;

        C22113(C2217k c2217k) {
            this.f5377a = c2217k;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            if (!this.f5377a.f5382A) {
                if (connectionResult.hasResolution()) {
                    try {
                        this.f5377a.f5382A = true;
                        connectionResult.startResolutionForResult(this.f5377a.getActivity(), 1001);
                        return;
                    } catch (SendIntentException e) {
                        this.f5377a.f5409z.connect();
                        return;
                    }
                }
                this.f5377a.m7951c(connectionResult.getErrorCode());
                this.f5377a.f5382A = true;
            }
        }
    }

    /* compiled from: NearCinemaListFragment */
    class C22124 implements ConnectionCallbacks {
        final /* synthetic */ C2217k f5378a;

        C22124(C2217k c2217k) {
            this.f5378a = c2217k;
        }

        public void onConnected(Bundle bundle) {
            Log.d("NearCinemaListFragment", "onConnected");
            if (ContextCompat.checkSelfPermission(this.f5378a.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                this.f5378a.f5383B = true;
                this.f5378a.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
                return;
            }
            this.f5378a.m7958g();
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* compiled from: NearCinemaListFragment */
    class C22135 implements Runnable {
        final /* synthetic */ C2217k f5379a;

        C22135(C2217k c2217k) {
            this.f5379a = c2217k;
        }

        public void run() {
            if (this.f5379a.f5403t != null) {
                this.f5379a.m7938a(this.f5379a.f5403t);
            }
        }
    }

    /* compiled from: NearCinemaListFragment */
    class C22146 implements OnCancelListener {
        final /* synthetic */ C2217k f5380a;

        C22146(C2217k c2217k) {
            this.f5380a = c2217k;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5380a.m6380c().finish();
        }
    }

    /* compiled from: NearCinemaListFragment */
    public static class C2215a extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), getArguments().getInt("dialog_error"), 1001);
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* compiled from: NearCinemaListFragment */
    private class C2216b implements C2196b {
        final /* synthetic */ C2217k f5381a;

        private C2216b(C2217k c2217k) {
            this.f5381a = c2217k;
        }

        public void mo3489b() {
            this.f5381a.m7971n();
        }

        public void m7933a(List<Cinema> list) {
            if (this.f5381a.isAdded()) {
                this.f5381a.f5388e = false;
                if (list == null) {
                    this.f5381a.f5389f = true;
                    this.f5381a.f5390g = new NullPointerException("Result is null.");
                    C1988j.m6341a(this.f5381a.getActivity(), this.f5381a.f5394k, this.f5381a.f5395l, this.f5381a.f5390g);
                    return;
                }
                this.f5381a.f5389f = false;
                this.f5381a.f5391h = true;
                this.f5381a.f5387d = list;
                this.f5381a.m7943a(this.f5381a.f5387d);
                this.f5381a.m7976q();
                if (list.size() > 0) {
                    this.f5381a.m7977r();
                } else {
                    this.f5381a.m7978s();
                }
            }
        }

        public void mo3322a() {
            this.f5381a.m7974o();
        }

        public void mo3323a(Exception exception) {
            this.f5381a.m7942a(exception);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f5385b = m6380c().m6292m();
        this.f5386c = this.f5385b.m6226n();
        this.f5384a = this.f5385b.m6219g().mo3457g();
        this.f5406w = getArguments().getInt("movie_id");
        this.f5405v = new C2216b();
        this.f5409z = m7935a();
    }

    public void onStart() {
        super.onStart();
        this.f5409z.connect();
    }

    public void onStop() {
        super.onStop();
        this.f5409z.disconnect();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading_location, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.CINEMAS, null);
        if (this.f5396m != null) {
            setListAdapter(this.f5396m);
        }
        this.f5401r = (ViewGroup) view.findViewById(R.id.header);
        this.f5394k = (LoadingView) view.findViewById(R.id.loading);
        this.f5395l = new C22091(this);
        this.f5399p = (LinearLayout) view.findViewById(R.id.location_error_panel);
        ((Button) view.findViewById(R.id.location_button_settings)).setOnClickListener(new C22102(this));
        if (this.f5388e || this.f5389f) {
            this.f5394k.setVisibility(0);
        }
        if (this.f5389f) {
            C1988j.m6341a(getActivity(), this.f5394k, this.f5395l, this.f5390g);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f5400q = m7961i();
        this.f5401r.addView(this.f5400q);
        mo3477h();
        if (!this.f5391h) {
            return;
        }
        if (this.f5397n == null || this.f5397n.size() == 0) {
            m7978s();
        }
    }

    private GoogleApiClient m7935a() {
        return new Builder(getContext()).addConnectionCallbacks(new C22124(this)).addOnConnectionFailedListener(new C22113(this)).addApi(LocationServices.API).build();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            this.f5382A = false;
            if (i2 == -1 && !this.f5409z.isConnecting() && !this.f5409z.isConnected()) {
                this.f5409z.connect();
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.d("NearCinemaListFragment", "onRequestPermissionsResult");
        if (i != 2) {
            return;
        }
        if (iArr.length == 1 && iArr[0] == 0) {
            Log.d("NearCinemaListFragment", "onRequestPermissionsResult success");
            m7944a(true);
            return;
        }
        Log.d("NearCinemaListFragment", "onRequestPermissionsResult deny");
        m7944a(false);
    }

    private void m7944a(boolean z) {
        if (z) {
            this.f5399p.setVisibility(8);
            m7958g();
            return;
        }
        this.f5399p.setVisibility(0);
        this.f5402s.setText(getString(R.string.location_error));
    }

    private void m7958g() {
        this.f5403t = LocationServices.FusedLocationApi.getLastLocation(this.f5409z);
        if (this.f5403t != null) {
            Log.d("NearCinemaListFragment", "mLastKnownLocation: " + this.f5403t.getLatitude() + "|" + this.f5403t.getLongitude());
            m7967l();
            m7963j();
            return;
        }
        Log.d("NearCinemaListFragment", "mLastKnownLocation is null");
        this.f5402s.setText(getString(R.string.location_error));
    }

    private void m7951c(int i) {
        C2215a c2215a = new C2215a();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_error", i);
        c2215a.setArguments(bundle);
        c2215a.show(getFragmentManager(), "errordialog");
    }

    private ViewGroup m7961i() {
        ViewGroup viewGroup = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.list_item_cinema_near_header, getListView(), false);
        this.f5402s = (TextView) viewGroup.findViewById(R.id.location);
        this.f5402s.setText(getString(R.string.location_waiting));
        return viewGroup;
    }

    private void m7963j() {
        C2208j c2208j = new C2208j(getActivity(), this);
        if (VERSION.SDK_INT >= 11) {
            c2208j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Location[]{this.f5403t});
            return;
        }
        c2208j.execute(new Location[]{this.f5403t});
    }

    public void m7979a(String str) {
        this.f5404u = str;
        if (str != null) {
            this.f5402s.setText(getResources().getString(R.string.location, new Object[]{str}));
            return;
        }
        this.f5402s.setText(getResources().getString(R.string.location_error));
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (this.f5383B) {
            this.f5383B = false;
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                z = true;
            }
            m7944a(z);
        }
        long y = this.f5385b.m6226n().m7218y();
        if (!this.f5388e && this.f5391h && this.f5393j > 0 && this.f5393j != y) {
            m7967l();
        }
        this.f5393j = y;
    }

    public void mo3477h() {
        m6382e();
        if (this.f5392i) {
            if (this.f5408y != this.f5386c.m7211q()) {
                this.f5391h = false;
                m7967l();
            } else if (this.f5407x != this.f5386c.m7212r()) {
                this.f5391h = false;
                m7967l();
            }
            m6378a(mo3436p(), "selected", null, 0);
        } else {
            this.f5392i = true;
            m7967l();
            m6378a(mo3436p(), "selected", "first_time", 0);
        }
        m7966k();
    }

    private void m7966k() {
        this.f5408y = this.f5386c.m7211q();
        this.f5407x = this.f5386c.m7212r();
    }

    private void m7967l() {
        if (getActivity() != null) {
            m6380c().m6280a(new C22135(this), null, new C22146(this));
        }
    }

    private void m7938a(Location location) {
        this.f5384a.mo3497a(location, this.f5406w, this.f5386c.m7211q(), this.f5386c.m7212r(), this.f5405v, this.f5385b.m6220h(), getActivity().getContentResolver());
    }

    public void onDestroy() {
        super.onDestroy();
        m7970m();
    }

    private void m7970m() {
        this.f5384a.mo3501b();
    }

    private void m7971n() {
        this.f5388e = true;
        if (!this.f5391h && getView() != null) {
            getListView().setVisibility(8);
            ((TextView) getView().findViewById(16908292)).setVisibility(8);
            this.f5394k.setVisibility(0);
            this.f5394k.m9451e();
            this.f5394k.m9448b();
        }
    }

    private void m7974o() {
        this.f5388e = false;
    }

    private void m7942a(Exception exception) {
        if (isAdded()) {
            this.f5388e = false;
            this.f5389f = true;
            this.f5390g = exception;
            C1988j.m6341a(getActivity(), this.f5394k, this.f5395l, this.f5390g);
            if (this.f5398o != null) {
                this.f5398o.m7412a(2);
            }
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2096d) {
            this.f5384a.mo3496a(getActivity(), ((C2096d) itemAtPosition).m7353c(), Integer.valueOf(this.f5406w));
        }
    }

    private void m7976q() {
        if (this.f5394k.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5394k.startAnimation(b);
            }
            this.f5394k.setVisibility(8);
        }
    }

    private void m7977r() {
        if (getListView().getVisibility() == 8 && getView() != null) {
            Animation b = m6379b(17432576);
            if (b != null) {
                getListView().startAnimation(b);
            } else {
                getListView().setVisibility(0);
            }
        }
    }

    private void m7978s() {
        ((TextView) getView().findViewById(16908292)).setText(this.f5406w != 0 ? R.string.cinemas_movie_empty : R.string.cinemas_empty);
    }

    private void m7943a(List<Cinema> list) {
        if (this.f5396m == null || this.f5396m.getCount() == 0) {
            this.f5397n = new ArrayList();
            m7775a(list, this.f5397n);
            this.f5396m = new C2086a(getActivity(), this.f5397n);
            setListAdapter(this.f5396m);
            return;
        }
        this.f5397n.clear();
        m7775a(list, this.f5397n);
        this.f5396m.notifyDataSetChanged();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_cinemas_without_schedule:
                this.f5391h = false;
                m7966k();
                m7967l();
                return true;
            case R.id.menu_item_date_all:
            case R.id.menu_item_date_month:
            case R.id.menu_item_date_today:
            case R.id.menu_item_date_tomorrow:
            case R.id.menu_item_date_week:
            case R.id.menu_item_date_weekend:
                this.f5391h = false;
                m7966k();
                m7967l();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public String mo3436p() {
        return "/cinemas/list";
    }
}
