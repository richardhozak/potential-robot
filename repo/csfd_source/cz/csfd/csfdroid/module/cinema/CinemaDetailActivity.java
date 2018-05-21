package cz.csfd.csfdroid.module.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.module.home.C2157b;
import cz.csfd.csfdroid.module.home.DrawerFragment.C2254b;

public class CinemaDetailActivity extends C2157b {
    public String mo3436p() {
        return "/cinemas/detail";
    }

    protected Fragment mo3474q() {
        Fragment c2195c = new C2195c();
        Bundle bundle = new Bundle();
        bundle.putInt("movie_id", getIntent().getIntExtra("movie_id", 0));
        c2195c.setArguments(bundle);
        return c2195c;
    }

    protected C2254b mo3475r() {
        return C2254b.CINEMAS;
    }

    protected void mo3486c(Intent intent) {
        finish();
    }
}
