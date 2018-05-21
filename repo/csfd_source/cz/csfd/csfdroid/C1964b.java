package cz.csfd.csfdroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.p017a.C0436a;
import android.support.v7.p017a.C0465f;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.C0654b;
import android.support.v7.widget.SearchView.C0655c;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.p030a.p031a.C0831a;
import cz.csfd.csfdroid.C1950a.C1947a;
import cz.csfd.csfdroid.module.search.SearchActivity;
import cz.csfd.csfdroid.net.C2516a;
import cz.csfd.csfdroid.net.C2516a.C1963a;
import cz.csfd.csfdroid.oauth.C2540c.C1959b;
import cz.csfd.csfdroid.p058a.C1949a;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import p000a.p001a.p002a.p003a.C0141c;

/* compiled from: BaseActivity */
public abstract class C1964b extends C0465f implements C1949a, C1963a {
    private boolean f4436a = true;
    private boolean f4437b = true;
    private CsfdApplication f4438c;
    private C2057e f4439d;
    private Handler f4440e = new Handler();
    private C2516a f4441f;
    private boolean f4442g;
    private Dialog f4443h;
    private Queue<Runnable> f4444i = new LinkedList();
    private Handler f4445j = new Handler();
    private MenuItem f4446k;
    private TextView f4447l;
    private List<OnDismissListener> f4448m;
    private List<OnCancelListener> f4449n;
    private OnDismissListener f4450o = new C19511(this);
    private OnCancelListener f4451p = new C19522(this);

    /* compiled from: BaseActivity */
    class C19511 implements OnDismissListener {
        final /* synthetic */ C1964b f4417a;

        C19511(C1964b c1964b) {
            this.f4417a = c1964b;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            for (OnDismissListener onDismiss : this.f4417a.f4448m) {
                onDismiss.onDismiss(dialogInterface);
            }
        }
    }

    /* compiled from: BaseActivity */
    class C19522 implements OnCancelListener {
        final /* synthetic */ C1964b f4418a;

        C19522(C1964b c1964b) {
            this.f4418a = c1964b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            for (OnCancelListener onCancel : this.f4418a.f4449n) {
                onCancel.onCancel(dialogInterface);
            }
        }
    }

    /* compiled from: BaseActivity */
    class C19533 implements OnClickListener {
        final /* synthetic */ C1964b f4419a;

        C19533(C1964b c1964b) {
            this.f4419a = c1964b;
        }

        public void onClick(View view) {
            this.f4419a.mo3470o();
        }
    }

    /* compiled from: BaseActivity */
    class C19608 implements C1959b {
        final /* synthetic */ C1964b f4431a;

        /* compiled from: BaseActivity */
        class C19581 implements Runnable {
            final /* synthetic */ C19608 f4430a;

            C19581(C19608 c19608) {
                this.f4430a = c19608;
            }

            public void run() {
                this.f4430a.f4431a.invalidateOptionsMenu();
                Toast.makeText(this.f4430a.f4431a.f4438c, R.string.logout_success, 0).show();
            }
        }

        C19608(C1964b c1964b) {
            this.f4431a = c1964b;
        }

        public void mo3329a() {
            this.f4431a.m6289j().post(new C19581(this));
        }
    }

    protected void onCreate(Bundle bundle) {
        C1998s.m6370a(getWindow());
        this.f4438c = C1998s.m6365a((Context) this);
        this.f4439d = this.f4438c.m6226n();
        super.onCreate(bundle);
        if (C0141c.m469j()) {
            C0831a.m3750a("activity", mo3436p());
        }
        C0436a b = m1367b();
        if (b != null) {
            boolean z = bundle == null || bundle.getBoolean("logo_visible");
            this.f4436a = z;
            m6267a(b);
        }
        mo3474q();
        this.f4438c.m6233u();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.content);
        if (findFragmentById != null) {
            findFragmentById.onActivityResult(i, i2, intent);
        }
    }

    private void m6267a(C0436a c0436a) {
        m6270b(c0436a);
    }

    private void m6270b(C0436a c0436a) {
        int i = 8;
        c0436a.mo1408a((int) R.layout.actionbar_custom);
        c0436a.mo1422d(false);
        c0436a.mo1425e(true);
        c0436a.mo1414a(false);
        c0436a.mo1419b(false);
        c0436a.mo1421c(false);
        View a = c0436a.mo1406a();
        final View findViewById = a.findViewById(R.id.actionbar_logo);
        findViewById.setVisibility(this.f4436a ? 0 : 8);
        final SearchView searchView = (SearchView) a.findViewById(R.id.actionbar_searchview);
        searchView.setQueryHint(getString(R.string.search_hint));
        final View findViewById2 = a.findViewById(R.id.title);
        if (this.f4437b) {
            i = 0;
        }
        findViewById2.setVisibility(i);
        a.findViewById(R.id.actionbar_drawer_button).setOnClickListener(new C19533(this));
        this.f4447l = (TextView) a.findViewById(R.id.actionbar_notification_count);
        searchView.setOnSearchClickListener(new OnClickListener(this) {
            final /* synthetic */ C1964b f4422c;

            public void onClick(View view) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                this.f4422c.f4436a = false;
                this.f4422c.f4437b = false;
            }
        });
        searchView.setOnCloseListener(new C0654b(this) {
            final /* synthetic */ C1964b f4425c;

            public boolean mo3325a() {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                this.f4425c.f4436a = true;
                this.f4425c.f4437b = true;
                return false;
            }
        });
        searchView.setOnQueryTextListener(new C0655c(this) {
            final /* synthetic */ C1964b f4427b;

            public boolean mo3326a(String str) {
                this.f4427b.m6281a(str);
                searchView.m2666a((CharSequence) "", false);
                searchView.setIconified(true);
                return true;
            }

            public boolean mo3327b(String str) {
                return false;
            }
        });
        Toolbar toolbar = (Toolbar) a.getParent();
        toolbar.setPadding(0, 0, 0, 0);
        toolbar.m2864b(0, 0);
    }

    protected void m6281a(String str) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("_action", "android.intent.action.SEARCH");
        intent.putExtra(SearchIntents.EXTRA_QUERY, str);
        startActivity(intent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("logo_visible", this.f4436a);
        super.onSaveInstanceState(bundle);
    }

    private void mo3474q() {
        this.f4442g = this.f4438c.m6225m().mo3348a(this);
    }

    protected void onStart() {
        super.onStart();
        m6285f();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    protected void onResume() {
        super.onResume();
        this.f4441f = new C2516a(this);
        registerReceiver(this.f4441f, this.f4441f.m9312a());
    }

    protected void onPause() {
        super.onPause();
        if (this.f4441f != null) {
            unregisterReceiver(this.f4441f);
            this.f4441f = null;
        }
    }

    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            m6282a("hw_buttons", "menu", mo3436p(), 0);
        } else if (i == 84) {
            m6282a("hw_buttons", "search", mo3436p(), 0);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    protected void m6285f() {
        boolean a = this.f4438c.m6229q().m6250a();
        if (this.f4446k == null) {
            return;
        }
        if (a) {
            this.f4446k.setTitle(R.string.menu_logout);
            if (this.f4446k.getIcon() != null) {
                this.f4446k.setIcon(R.drawable.ic_action_logout);
                return;
            }
            return;
        }
        this.f4446k.setTitle(R.string.menu_login);
        if (this.f4446k.getIcon() != null) {
            this.f4446k.setIcon(R.drawable.ic_action_login);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                Intent g = mo3630g();
                if (g == null) {
                    finish();
                } else if (NavUtils.shouldUpRecreateTask(this, g)) {
                    mo3642h();
                    finish();
                } else {
                    mo3486c(g);
                }
                m6282a("actionbar", "up", mo3436p(), 0);
                return true;
            case R.id.menu_item_about:
                this.f4438c.m6219g().mo3451a().mo3542a((FragmentActivity) this);
                m6282a("actionbar", "about", mo3436p(), 0);
                return true;
            case R.id.menu_item_preferences:
                this.f4438c.m6219g().mo3455e().mo3613a(this);
                m6282a("actionbar", "preferences", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected Intent mo3630g() {
        return NavUtils.getParentActivityIntent(this);
    }

    protected void mo3642h() {
        TaskStackBuilder.create(this).addParentStack((Activity) this).startActivities();
    }

    protected void mo3486c(Intent intent) {
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void m6278a(final C1947a c1947a) {
        m6282a("login", "login", "start", 0);
        this.f4438c.m6229q().m6246a(this, new C1947a(this) {
            final /* synthetic */ C1964b f4429b;

            public void mo3328a() {
                this.f4429b.m6282a("login", "login", "success", 0);
                this.f4429b.f4438c.m6222j().m7165b();
                this.f4429b.invalidateOptionsMenu();
                if (c1947a != null) {
                    c1947a.mo3328a();
                }
            }
        });
    }

    public void m6288i() {
        m6282a("login", "logout", null, 0);
        this.f4438c.m6229q().m6248a(new C19608(this));
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }

    public Handler m6289j() {
        return this.f4440e;
    }

    public void m6279a(Runnable runnable) {
        if (this.f4442g) {
            this.f4445j.post(runnable);
        } else {
            this.f4444i.add(runnable);
        }
    }

    public void m6280a(Runnable runnable, OnDismissListener onDismissListener, OnCancelListener onCancelListener) {
        m6279a(runnable);
        if (!this.f4442g) {
            if (this.f4443h == null || !this.f4443h.isShowing()) {
                m6266a(onDismissListener, onCancelListener);
                mo3475r();
            }
            if (onDismissListener != null) {
                this.f4448m.add(onDismissListener);
            }
            if (onCancelListener != null) {
                this.f4449n.add(onCancelListener);
            }
        }
    }

    public void m6277a(final Activity activity, Runnable runnable) {
        m6280a(runnable, null, new OnCancelListener(this) {
            final /* synthetic */ C1964b f4433b;

            public void onCancel(DialogInterface dialogInterface) {
                activity.finish();
            }
        });
    }

    public void mo3330k() {
        this.f4442g = true;
        mo3476s();
        while (true) {
            Runnable runnable = (Runnable) this.f4444i.poll();
            if (runnable != null) {
                this.f4445j.post(runnable);
            } else {
                return;
            }
        }
    }

    public void mo3331l() {
        this.f4442g = false;
    }

    private void m6266a(OnDismissListener onDismissListener, OnCancelListener onCancelListener) {
        if (this.f4448m == null) {
            this.f4448m = new LinkedList();
        }
        if (this.f4449n == null) {
            this.f4449n = new LinkedList();
        }
        this.f4443h = C1984g.m6337a(this);
        this.f4443h.setOnDismissListener(this.f4450o);
        this.f4443h.setOnCancelListener(this.f4451p);
    }

    private void mo3475r() {
        this.f4443h.show();
    }

    private void mo3476s() {
        if (this.f4443h != null) {
            this.f4443h.dismiss();
            this.f4443h = null;
        }
    }

    public CsfdApplication m6292m() {
        return this.f4438c;
    }

    protected Bundle m6284d(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("_action", intent.getAction());
        bundle.putString("_data", intent.getDataString());
        if (intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        return bundle;
    }

    public void m6282a(String str, String str2, String str3, int i) {
        String replaceAll = str.replaceAll("/", "_");
        if (replaceAll.length() > 1 && replaceAll.charAt(0) == '_') {
            replaceAll = "screen" + replaceAll;
        }
        this.f4438c.m6233u().send(new EventBuilder().setCategory(replaceAll).setAction(str2).setLabel(str3).setValue((long) i).build());
    }

    public void mo3469n() {
    }

    protected void mo3470o() {
    }

    protected void mo3467a(int i) {
        if (this.f4447l != null) {
            this.f4447l.setText(String.valueOf(i));
            this.f4447l.setVisibility(i > 0 ? 0 : 8);
        }
    }
}
