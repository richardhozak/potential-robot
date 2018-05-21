package cz.csfd.csfdroid.module.gallery;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.module.creator.C2234f;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.movie.C2366h.C2249e;
import cz.csfd.csfdroid.net.C2516a;
import cz.csfd.csfdroid.net.C2516a.C1963a;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1991m;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.C2550a;
import java.util.ArrayList;
import java.util.List;

public class FullscreenGalleryActivity extends Activity implements C2249e, C1963a {
    private CsfdApplication f5493a;
    private C2366h f5494b;
    private C2234f f5495c;
    private List<Photo> f5496d;
    private ViewPager f5497e;
    private C2250a f5498f;
    private LinearLayout f5499g;
    private TextView f5500h;
    private int f5501i;
    private boolean f5502j = false;
    private MovieInfo f5503k;
    private MovieCreator f5504l;
    private C2516a f5505m;
    private boolean f5506n;
    private C2550a f5507o;
    private Handler f5508p;

    class C22412 implements OnCancelListener {
        final /* synthetic */ FullscreenGalleryActivity f5483a;

        C22412(FullscreenGalleryActivity fullscreenGalleryActivity) {
            this.f5483a = fullscreenGalleryActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    class C22434 implements OnCancelListener {
        final /* synthetic */ FullscreenGalleryActivity f5486a;

        C22434(FullscreenGalleryActivity fullscreenGalleryActivity) {
            this.f5486a = fullscreenGalleryActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    class C22445 implements C1945a<MovieCreator> {
        final /* synthetic */ FullscreenGalleryActivity f5487a;

        C22445(FullscreenGalleryActivity fullscreenGalleryActivity) {
            this.f5487a = fullscreenGalleryActivity;
        }

        public void m8102a(MovieCreator movieCreator) {
            this.f5487a.m8136i();
            if (movieCreator == null) {
                this.f5487a.m8110a((int) R.string.error_data_fetch, false);
            } else {
                this.f5487a.m8113a(movieCreator);
            }
        }

        public void mo3323a(Exception exception) {
            this.f5487a.mo3323a(exception);
        }

        public void mo3322a() {
            this.f5487a.mo3322a();
        }
    }

    class C22456 implements OnDismissListener {
        final /* synthetic */ FullscreenGalleryActivity f5488a;

        C22456(FullscreenGalleryActivity fullscreenGalleryActivity) {
            this.f5488a = fullscreenGalleryActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5488a.finish();
        }
    }

    private final class C2246a implements OnPageChangeListener {
        final /* synthetic */ FullscreenGalleryActivity f5489a;
        private MovieInfo f5490b;
        private MovieCreator f5491c;

        private C2246a(FullscreenGalleryActivity fullscreenGalleryActivity, MovieInfo movieInfo) {
            this.f5489a = fullscreenGalleryActivity;
            this.f5490b = movieInfo;
        }

        private C2246a(FullscreenGalleryActivity fullscreenGalleryActivity, MovieCreator movieCreator) {
            this.f5489a = fullscreenGalleryActivity;
            this.f5491c = movieCreator;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            this.f5489a.f5501i = i;
            if (!(this.f5490b == null || this.f5490b.m6996w() || i != this.f5489a.f5496d.size() - 1)) {
                this.f5489a.m8126c(this.f5490b);
            }
            if (!(this.f5491c == null || this.f5491c.m6884s() || i != this.f5489a.f5496d.size() - 1)) {
                this.f5489a.m8119b(this.f5491c);
            }
            this.f5489a.m8124c(i);
        }
    }

    private class C2247b extends Handler {
        final /* synthetic */ FullscreenGalleryActivity f5492a;

        private C2247b(FullscreenGalleryActivity fullscreenGalleryActivity) {
            this.f5492a = fullscreenGalleryActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f5492a.f5499g.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    static class C2248c {
        static void m8105a(Activity activity, int i, int i2) {
            activity.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m8139n();
        setContentView(R.layout.fullscreen_gallery);
        this.f5493a = C1998s.m6365a((Context) this);
        this.f5494b = this.f5493a.m6219g().mo3453c();
        this.f5495c = this.f5493a.m6219g().mo3454d();
        this.f5508p = new C2247b();
        this.f5499g = (LinearLayout) findViewById(R.id.gallery_fullscreen_progress);
        this.f5497e = (ViewPager) findViewById(R.id.gallery_fullscreen_gallery);
        this.f5500h = (TextView) findViewById(R.id.copyright);
        m8132e();
        if (bundle != null) {
            this.f5496d = (List) bundle.getSerializable("photos");
            this.f5501i = bundle.getInt("displayed_photo");
            this.f5504l = (MovieCreator) bundle.getSerializable("creator");
            this.f5503k = (MovieInfo) bundle.getSerializable("movie");
            m8133f();
            if (this.f5504l != null) {
                this.f5497e.setOnPageChangeListener(new C2246a(this.f5504l));
            } else if (this.f5503k != null) {
                this.f5497e.setOnPageChangeListener(new C2246a(this.f5503k));
            }
        } else {
            Uri data = getIntent().getData();
            int parseInt = Integer.parseInt(data.getQuery());
            if (data.getScheme().equals("creator")) {
                m8118b(parseInt);
            } else {
                m8109a(parseInt);
            }
        }
        m8112a(bundle);
        m8134g();
        if (C1998s.m6374b()) {
            findViewById(16908290).setSystemUiVisibility(1);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f5493a.m6233u().setScreenName(m8145c());
        this.f5493a.m6233u().send(new ScreenViewBuilder().build());
    }

    protected void onResume() {
        super.onResume();
        this.f5505m = new C2516a(this);
        registerReceiver(this.f5505m, this.f5505m.m9312a());
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.f5505m);
        this.f5505m = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        m8129d();
        finish();
        m8139n();
        return true;
    }

    private void m8129d() {
        Intent intent = new Intent();
        intent.putExtra("displayed_photo", this.f5501i);
        setResult(-1, intent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("displayed_photo", this.f5501i);
        bundle.putSerializable("photos", (ArrayList) this.f5496d);
        bundle.putSerializable("creator", this.f5504l);
        bundle.putSerializable("movie", this.f5503k);
    }

    private void m8132e() {
        this.f5506n = this.f5493a.m6225m().mo3348a(this);
    }

    private void m8109a(int i) {
        try {
            this.f5503k = C1992n.m6350a(i, (Context) this);
            this.f5497e.setOnPageChangeListener(new C2246a(this.f5503k));
            m8120b(this.f5503k);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m8110a((int) R.string.error, true);
        }
    }

    private void m8118b(int i) {
        try {
            this.f5504l = C1991m.m6346a(i, this);
            this.f5497e.setOnPageChangeListener(new C2246a(this.f5504l));
            m8113a(this.f5504l);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m8110a((int) R.string.error, true);
        }
    }

    private void m8120b(MovieInfo movieInfo) {
        this.f5496d = movieInfo.m6960i();
        m8133f();
    }

    private void m8113a(MovieCreator movieCreator) {
        this.f5496d = movieCreator.m6885t();
        m8133f();
    }

    private void m8133f() {
        if (this.f5498f == null) {
            this.f5498f = new C2250a(this.f5496d, this);
            this.f5497e.setAdapter(this.f5498f);
        } else {
            this.f5498f.notifyDataSetChanged();
        }
        m8124c(this.f5501i);
    }

    private void m8112a(Bundle bundle) {
        this.f5501i = getIntent().getExtras().getInt("displayed_photo", 0);
        if (bundle != null) {
            this.f5501i = bundle.getInt("displayed_photo", this.f5501i);
        }
    }

    private void m8134g() {
        if (this.f5496d.size() > this.f5501i && this.f5501i > 0) {
            this.f5497e.setCurrentItem(this.f5501i);
        }
        this.f5502j = true;
    }

    public void mo3526b() {
        m8135h();
    }

    public void m8141a(MovieInfo movieInfo) {
        m8136i();
        if (movieInfo == null) {
            m8110a((int) R.string.error_data_fetch, false);
        } else {
            m8120b(movieInfo);
        }
    }

    public void mo3322a() {
        m8136i();
    }

    public void mo3323a(Exception exception) {
        m8136i();
    }

    private void m8126c(final MovieInfo movieInfo) {
        if (this.f5506n) {
            m8130d(movieInfo);
            return;
        }
        m8111a(new OnDismissListener(this) {
            final /* synthetic */ FullscreenGalleryActivity f5482b;

            public void onDismiss(DialogInterface dialogInterface) {
                if (this.f5482b.f5506n) {
                    this.f5482b.m8130d(movieInfo);
                }
            }
        }, new C22412(this));
        m8137j();
    }

    private void m8130d(MovieInfo movieInfo) {
        if (movieInfo != null) {
            this.f5494b.mo3573a(movieInfo, Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels), (C2249e) this, this.f5493a.m6220h());
        }
    }

    private void m8119b(final MovieCreator movieCreator) {
        if (this.f5506n) {
            m8125c(movieCreator);
            return;
        }
        m8111a(new OnDismissListener(this) {
            final /* synthetic */ FullscreenGalleryActivity f5485b;

            public void onDismiss(DialogInterface dialogInterface) {
                if (this.f5485b.f5506n) {
                    this.f5485b.m8125c(movieCreator);
                }
            }
        }, new C22434(this));
        m8137j();
    }

    private void m8125c(MovieCreator movieCreator) {
        if (movieCreator != null) {
            C1945a c22445 = new C22445(this);
            this.f5495c.mo3515a(movieCreator, 20, movieCreator.m6886u(), c22445, this.f5493a.m6220h());
        }
    }

    private void m8110a(int i, boolean z) {
        AlertDialog a = C1984g.m6336a(this, i);
        if (z) {
            a.setOnDismissListener(new C22456(this));
        }
        a.show();
    }

    private void m8135h() {
        this.f5499g.setVisibility(0);
    }

    private void m8136i() {
        this.f5508p.obtainMessage(1).sendToTarget();
    }

    public void mo3330k() {
        this.f5506n = true;
        m8138m();
    }

    public void mo3331l() {
        this.f5506n = false;
    }

    private void m8111a(OnDismissListener onDismissListener, OnCancelListener onCancelListener) {
        if (this.f5507o == null || this.f5507o.m9457a()) {
            this.f5507o = C1984g.m6337a(this);
        }
        this.f5507o.setOnDismissListener(onDismissListener);
        this.f5507o.setOnCancelListener(onCancelListener);
    }

    private void m8137j() {
        this.f5507o.show();
    }

    private void m8138m() {
        if (this.f5507o != null) {
            this.f5507o.dismiss();
            this.f5507o = null;
        }
    }

    private void m8139n() {
        if (VERSION.SDK_INT >= 5) {
            C2248c.m8105a(this, R.anim.fadein, R.anim.fadeout);
        }
    }

    private void m8124c(int i) {
        Photo photo = (Photo) this.f5496d.get(i);
        if (TextUtils.isEmpty(photo.m7020g())) {
            this.f5500h.setVisibility(8);
            return;
        }
        this.f5500h.setVisibility(0);
        this.f5500h.setText("© " + photo.m7020g());
    }

    public String m8145c() {
        return "/gallery";
    }
}
