package cz.csfd.csfdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p058a.C1949a;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1984g;
import java.util.HashMap;

/* compiled from: BaseListFragment */
public abstract class C1999d extends ListFragment implements C1949a {
    private C1964b f4487a;
    private Tracker f4488b;
    private MenuItem f4489c;
    private AdBannerView f4490d;

    /* compiled from: BaseListFragment */
    class C19762 implements Runnable {
        final /* synthetic */ C1999d f4476a;

        C19762(C1999d c1999d) {
            this.f4476a = c1999d;
        }

        public void run() {
            this.f4476a.m6380c().invalidateOptionsMenu();
        }
    }

    /* compiled from: BaseListFragment */
    class C19773 implements OnDismissListener {
        final /* synthetic */ C1999d f4477a;

        C19773(C1999d c1999d) {
            this.f4477a = c1999d;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f4477a.m6381d();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4488b = m6380c().m6292m().m6233u();
    }

    public void onResume() {
        super.onResume();
        if (this.f4490d != null) {
            this.f4490d.m7594c();
        }
    }

    public void onPause() {
        if (this.f4490d != null) {
            this.f4490d.m7595d();
        }
        super.onPause();
    }

    public void onDestroy() {
        if (this.f4490d != null) {
            this.f4490d.m7596e();
        }
        super.onDestroy();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C1964b) {
            this.f4487a = (C1964b) activity;
            return;
        }
        throw new RuntimeException("The activity has to extend BaseActivity.");
    }

    public void onStart() {
        super.onStart();
        if (!(this instanceof C1973d)) {
            m6382e();
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f4489c = menu.findItem(R.id.menu_item_login);
        h_();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_login:
                mo3417g();
                m6378a("actionbar", "login", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void mo3417g() {
        final CsfdApplication m = this.f4487a.m6292m();
        C1950a q = m.m6229q();
        if (q.m6250a()) {
            m6378a("login", "logout", null, 0);
            q.m6252b();
            Toast.makeText(this.f4487a.getApplicationContext(), R.string.logout_success, 0).show();
            this.f4487a.m6289j().postDelayed(new C19762(this), 300);
            return;
        }
        m6378a("login", "login", "start", 0);
        q.m6246a(m6380c(), new C1947a(this) {
            final /* synthetic */ C1999d f4475b;

            public void mo3328a() {
                this.f4475b.m6378a("login", "login", "success", 0);
                m.m6222j().m7165b();
                this.f4475b.m6380c().invalidateOptionsMenu();
            }
        });
    }

    protected void h_() {
        boolean a = m6380c().m6292m().m6229q().m6250a();
        if (this.f4489c == null) {
            return;
        }
        if (a) {
            this.f4489c.setTitle(R.string.menu_logout);
            if (this.f4489c.getIcon() != null) {
                this.f4489c.setIcon(R.drawable.ic_action_logout);
                return;
            }
            return;
        }
        this.f4489c.setTitle(R.string.menu_login);
        if (this.f4489c.getIcon() != null) {
            this.f4489c.setIcon(R.drawable.ic_action_login);
        }
    }

    protected C1964b m6380c() {
        return this.f4487a;
    }

    protected void m6376a(int i) {
        AlertDialog a = C1984g.m6336a(this.f4487a, i);
        a.setOnDismissListener(new C19773(this));
        a.show();
    }

    protected void m6381d() {
        this.f4487a.finish();
    }

    protected void m6377a(C2146b c2146b, HashMap<String, String> hashMap) {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            setListAdapter(null);
        }
        this.f4490d = new AdBannerView(getActivity());
        this.f4490d.m7592a(c2146b, hashMap, mo3436p());
        getListView().addHeaderView(this.f4490d, null, false);
        if (listAdapter != null) {
            setListAdapter(listAdapter);
        }
    }

    public void m6378a(String str, String str2, String str3, int i) {
        String replaceAll = str.replaceAll("/", "_");
        if (replaceAll.length() > 1 && replaceAll.charAt(0) == '_') {
            replaceAll = "screen" + replaceAll;
        }
        this.f4488b.send(new EventBuilder().setCategory(replaceAll).setAction(str2).setLabel(str3).setValue((long) i).build());
    }

    protected void m6382e() {
        Log.d("BaseListFragment", "trackScreen " + mo3436p());
        this.f4488b.setScreenName(mo3436p());
        this.f4488b.send(new ScreenViewBuilder().build());
    }

    protected Animation m6379b(int i) {
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(getActivity(), i);
        } catch (Throwable e) {
            C1983f.m6334a(getClass().getSimpleName(), "Error while loading fade out animation.", e);
        }
        return animation;
    }

    protected void m6383f() {
        if (!m6380c().isFinishing()) {
            m6380c().finish();
        }
    }
}
