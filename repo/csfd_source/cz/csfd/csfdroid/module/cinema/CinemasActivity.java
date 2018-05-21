package cz.csfd.csfdroid.module.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class CinemasActivity extends C2157b {
    private int f5257e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5257e = getIntent().getIntExtra("movie_id", 0);
        if (this.f5257e != 0) {
            this.a.setDrawerLockMode(1);
            this.b.m1312a(false);
        }
    }

    protected Fragment mo3474q() {
        Fragment c2203g = new C2203g();
        Bundle bundle = new Bundle();
        bundle.putInt("movie_id", getIntent().getIntExtra("movie_id", 0));
        bundle.putString("movie_name", getIntent().getStringExtra("movie_name"));
        bundle.putString("tab", getIntent().getStringExtra("tab"));
        c2203g.setArguments(bundle);
        return c2203g;
    }

    protected C2254b mo3475r() {
        return this.f5257e == 0 ? C2254b.CINEMAS : null;
    }

    protected void mo3486c(Intent intent) {
        if (this.f5257e > 0) {
            finish();
        } else {
            super.mo3486c(intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Log.d("CinemasActivity", "onRequestPermissionsResult");
    }

    public String mo3436p() {
        return "/cinemas";
    }
}
