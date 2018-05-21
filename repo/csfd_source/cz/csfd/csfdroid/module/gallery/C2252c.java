package cz.csfd.csfdroid.module.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.p061d.C1998s;

/* compiled from: GalleryModuleImpl */
public class C2252c implements C2251b {
    private C2056d<MovieInfo> f5512a;
    private C2056d<MovieCreator> f5513b;

    public void mo3528a(MovieInfo movieInfo, int i, Activity activity) {
        m8153a(movieInfo, activity);
        Intent intent = new Intent(activity, FullscreenGalleryActivity.class);
        intent.setData(m8151a(movieInfo));
        intent.putExtra("displayed_photo", i);
        activity.startActivityForResult(intent, 1);
    }

    public void mo3527a(MovieCreator movieCreator, int i, Activity activity) {
        m8152a(movieCreator, activity);
        Intent intent = new Intent(activity, FullscreenGalleryActivity.class);
        intent.setData(m8150a(movieCreator));
        intent.putExtra("displayed_photo", i);
        activity.startActivityForResult(intent, 1);
    }

    private void m8153a(MovieInfo movieInfo, Activity activity) {
        if (this.f5512a == null) {
            this.f5512a = C1998s.m6365a((Context) activity).m6222j();
        }
        this.f5512a.m7164a((BasicEntity) movieInfo);
    }

    private void m8152a(MovieCreator movieCreator, Activity activity) {
        if (this.f5513b == null) {
            this.f5513b = C1998s.m6365a((Context) activity).m6223k();
        }
        this.f5513b.m7164a((BasicEntity) movieCreator);
    }

    private Uri m8151a(MovieInfo movieInfo) {
        Builder builder = new Builder();
        builder.scheme("film").authority("csfd.cz").path("/gallery").query(movieInfo.m6705g() + "");
        return builder.build();
    }

    private Uri m8150a(MovieCreator movieCreator) {
        Builder builder = new Builder();
        builder.scheme("creator").authority("csfd.cz").path("/gallery").query(movieCreator.m6705g() + "");
        return builder.build();
    }
}
