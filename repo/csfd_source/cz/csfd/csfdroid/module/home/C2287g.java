package cz.csfd.csfdroid.module.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import cz.csfd.csfdroid.C1964b;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;

/* compiled from: SinglePaneActivity */
public abstract class C2287g extends C1964b {
    private CsfdApplication f5615a;

    protected abstract Fragment mo3475r();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_without_drawer);
        this.f5615a = m6292m();
        if (getSupportFragmentManager().findFragmentById(R.id.content) == null) {
            mo3474q();
        }
    }

    protected final void mo3474q() {
        Fragment r = mo3475r();
        Bundle d = m6284d(getIntent());
        if (r.getArguments() != null) {
            r.getArguments().putAll(d);
        } else {
            r.setArguments(d);
        }
        m8269a(r, false, false);
    }

    protected void m8269a(Fragment fragment, boolean z, boolean z2) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.content);
        Object obj = null;
        if (findFragmentById != null && findFragmentById.getClass().getName().equals(fragment.getClass().getName())) {
            obj = 1;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.content, fragment);
        if (z) {
            beginTransaction.addToBackStack(null);
        }
        if (z2 && r0 == null) {
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        beginTransaction.commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                return super.onOptionsItemSelected(menuItem);
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
