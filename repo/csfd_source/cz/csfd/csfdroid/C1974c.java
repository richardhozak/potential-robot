package cz.csfd.csfdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.p030a.p031a.C0831a;
import cz.csfd.csfdroid.module.ads.AdBannerView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.p058a.C1949a;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1984g;
import java.util.HashMap;
import p000a.p001a.p002a.p003a.C0141c;

/* compiled from: BaseFragment */
public abstract class C1974c extends Fragment implements C1949a {
    private C1964b f4469a;
    private Tracker f4470b;
    private MenuItem f4471c;
    private AdBannerView f4472d;
    private boolean f4473e = false;

    /* compiled from: BaseFragment */
    class C19651 implements OnDismissListener {
        final /* synthetic */ C1974c f4452a;

        C19651(C1974c c1974c) {
            this.f4452a = c1974c;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f4452a.m6321e();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C0141c.m469j()) {
            C0831a.m3750a("fragment", mo3436p());
        }
        this.f4470b = m6320d().m6292m().m6233u();
        this.f4473e = bundle != null;
    }

    public void onResume() {
        super.onResume();
        if (this.f4472d != null) {
            this.f4472d.m7594c();
        }
    }

    public void onPause() {
        if (this.f4472d != null) {
            this.f4472d.m7595d();
        }
        super.onPause();
    }

    public void onDestroy() {
        if (this.f4472d != null) {
            this.f4472d.m7596e();
        }
        super.onDestroy();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C1964b) {
            this.f4469a = (C1964b) activity;
            return;
        }
        throw new RuntimeException("The activity has to extend BaseActivity.");
    }

    public void onStart() {
        super.onStart();
        if (!(this instanceof C1973d)) {
            m6322f();
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDetach() {
        super.onDetach();
        this.f4473e = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f4471c = menu.findItem(R.id.menu_item_login);
        m6319c();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_login:
                mo3536b();
                m6316a("actionbar", "login", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void mo3536b() {
        if (this.f4469a.m6292m().m6229q().m6250a()) {
            this.f4469a.m6288i();
        } else {
            this.f4469a.m6278a(null);
        }
    }

    protected void m6319c() {
        boolean a = this.f4469a.m6292m().m6229q().m6250a();
        if (this.f4471c == null) {
            return;
        }
        if (a) {
            this.f4471c.setTitle(R.string.menu_logout);
            if (this.f4471c.getIcon() != null) {
                this.f4471c.setIcon(R.drawable.ic_action_logout);
                return;
            }
            return;
        }
        this.f4471c.setTitle(R.string.menu_login);
        if (this.f4471c.getIcon() != null) {
            this.f4471c.setIcon(R.drawable.ic_action_login);
        }
    }

    protected C1964b m6320d() {
        return this.f4469a;
    }

    protected void m6314a(int i) {
        AlertDialog a = C1984g.m6336a(this.f4469a, i);
        a.setOnDismissListener(new C19651(this));
        a.show();
    }

    protected void m6321e() {
        this.f4469a.finish();
    }

    protected void m6315a(C2146b c2146b, HashMap<String, String> hashMap) {
        this.f4472d = (AdBannerView) getView().findViewById(R.id.ad_banner);
        this.f4472d.m7592a(c2146b, hashMap, mo3436p());
    }

    public void m6316a(String str, String str2, String str3, int i) {
        String replaceAll = str.replaceAll("/", "_");
        if (replaceAll.length() > 1 && replaceAll.charAt(0) == '_') {
            replaceAll = "screen" + replaceAll;
        }
        this.f4470b.send(new EventBuilder().setCategory(replaceAll).setAction(str2).setLabel(str3).setValue((long) i).build());
    }

    protected void m6322f() {
        Log.d("BaseFragment", "trackScreen " + mo3436p());
        this.f4470b.setScreenName(mo3436p());
        this.f4470b.send(new ScreenViewBuilder().build());
    }

    protected Animation m6317b(int i) {
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(getActivity(), i);
        } catch (Throwable e) {
            C1983f.m6334a(getClass().getSimpleName(), "Error while loading fade out animation.", e);
        }
        return animation;
    }

    protected void m6323g() {
        if (!m6320d().isFinishing()) {
            m6320d().finish();
        }
    }
}
