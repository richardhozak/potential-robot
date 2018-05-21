package cz.csfd.csfdroid.module.favorites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class FavoritesActivity extends C2157b {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected Fragment mo3474q() {
        return new C2237a();
    }

    protected C2254b mo3475r() {
        return C2254b.FAVORITES;
    }

    public String mo3436p() {
        return "/favorites";
    }
}
