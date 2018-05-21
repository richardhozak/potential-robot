package cz.csfd.csfdroid.module.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class SearchActivity extends C2157b {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected Fragment mo3474q() {
        return new C2433b();
    }

    protected C2254b mo3475r() {
        return null;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public String mo3436p() {
        return "/search";
    }
}
