package cz.csfd.csfdroid.module.movie.video;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.p030a.p031a.C0831a;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideo.Video;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.module.ads.C2153c;
import cz.csfd.csfdroid.module.ads.C2154d;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2388a;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2389b;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2390c;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2391d;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2392e;
import cz.csfd.csfdroid.module.movie.video.C2397d.C2396a;
import cz.csfd.csfdroid.module.movie.video.C2408e.C2407a;
import cz.csfd.csfdroid.net.C2518c;
import cz.csfd.csfdroid.net.C2519d;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.Map.Entry;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import p000a.p001a.p002a.p003a.C0141c;

/* compiled from: VideoFragment */
public class C2408e extends C1974c {
    private static int f5971x = -1;
    private static int f5972y = -1;
    private C2057e f5973A;
    private boolean f5974B;
    private CsfdApplication f5975a;
    private C2366h f5976b;
    private MovieVideos f5977c;
    private int f5978d;
    private boolean f5979e;
    private MovieInfo f5980f;
    private MovieVideo f5981g;
    private String f5982h;
    private String f5983i;
    private C2154d f5984j;
    private C2153c f5985k;
    private C2393a f5986l;
    private VideoView f5987m;
    private C2388a f5988n;
    private String f5989o;
    private AudioManager f5990p;
    private OnAudioFocusChangeListener f5991q;
    private TextView f5992r;
    private C2395c f5993s;
    private View f5994t;
    private TextView f5995u;
    private boolean f5996v;
    private boolean f5997w = false;
    private Handler f5998z = new C23981(this);

    /* compiled from: VideoFragment */
    class C23981 extends Handler {
        final /* synthetic */ C2408e f5961a;

        C23981(C2408e c2408e) {
            this.f5961a = c2408e;
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                removeMessages(2);
            } else if (message.what == 2) {
                removeMessages(2);
                long d = (long) this.f5961a.f5988n.mo3597d();
                if (!(d <= 0 || this.f5961a.f5993s == null || this.f5961a.f5996v)) {
                    this.f5961a.f5992r.setText(Html.fromHtml(this.f5961a.f5993s.m8756a(d)));
                }
                if (this.f5961a.f5996v && this.f5961a.f5988n.mo3597d() > this.f5961a.f5985k.m7655d() * 1000 && !this.f5961a.f5997w) {
                    C1983f.m6333a("VideoFragment", "Ad skip timeout reached.");
                    this.f5961a.f5997w = true;
                    this.f5961a.f5986l.m8753c();
                    this.f5961a.f5986l.setAdSkipButtonVisibility(true);
                    this.f5961a.m8798b(false);
                }
                if (!this.f5961a.f5996v) {
                    this.f5961a.f5986l.setAdSkipButtonVisibility(false);
                }
                sendEmptyMessageDelayed(2, 300);
            } else if (message.what == 3) {
                removeMessages(3);
                this.f5961a.m8793a(false);
                this.f5961a.f5995u.setVisibility(8);
            }
        }
    }

    /* compiled from: VideoFragment */
    class C23992 implements OnErrorListener {
        final /* synthetic */ C2408e f5962a;

        C23992(C2408e c2408e) {
            this.f5962a = c2408e;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C1983f.m6335b("VideoFragment", "Video playback error: " + i);
            if (this.f5962a.f5996v) {
                this.f5962a.m6316a("video_ad", "playback_error", String.valueOf(i), i2);
                this.f5962a.m8820n();
            } else {
                this.f5962a.m6316a("video_film", "playback_error", String.valueOf(i), i2);
                this.f5962a.m6314a(R.string.video_playback_error);
                this.f5962a.f5988n.mo3595b();
            }
            return true;
        }
    }

    /* compiled from: VideoFragment */
    class C24003 implements Runnable {
        final /* synthetic */ C2408e f5963a;

        C24003(C2408e c2408e) {
            this.f5963a = c2408e;
        }

        public void run() {
            this.f5963a.m8816l();
        }
    }

    /* compiled from: VideoFragment */
    class C24014 implements OnCancelListener {
        final /* synthetic */ C2408e f5964a;

        C24014(C2408e c2408e) {
            this.f5964a = c2408e;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5964a.m6320d().finish();
        }
    }

    /* compiled from: VideoFragment */
    class C24025 implements OnCompletionListener {
        final /* synthetic */ C2408e f5965a;

        C24025(C2408e c2408e) {
            this.f5965a = c2408e;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            C1983f.m6333a("VideoFragment", "VideoView, ad, onCompletion()");
            this.f5965a.m8786a(mediaPlayer);
            this.f5965a.m8820n();
            this.f5965a.m6316a("video_ad", "finish", this.f5965a.f5989o, 0);
        }
    }

    /* compiled from: VideoFragment */
    class C24036 implements Runnable {
        final /* synthetic */ C2408e f5966a;

        C24036(C2408e c2408e) {
            this.f5966a = c2408e;
        }

        public void run() {
            try {
                this.f5966a.m6320d().m6292m().m6221i().mo3669a(this.f5966a.f5985k.m7653b());
            } catch (C2518c e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: VideoFragment */
    class C24047 implements OnCompletionListener {
        final /* synthetic */ C2408e f5967a;

        C24047(C2408e c2408e) {
            this.f5967a = c2408e;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            C1983f.m6333a("VideoFragment", "VideoView, video, onCompletion()");
            this.f5967a.m8798b(true);
            this.f5967a.m6316a("video_film", "finish", this.f5967a.f5989o, 0);
            this.f5967a.m8786a(mediaPlayer);
            this.f5967a.m8838x();
        }
    }

    /* compiled from: VideoFragment */
    class C24058 implements OnAudioFocusChangeListener {
        final /* synthetic */ C2408e f5968a;

        C24058(C2408e c2408e) {
            this.f5968a = c2408e;
        }

        public void onAudioFocusChange(int i) {
        }
    }

    /* compiled from: VideoFragment */
    class C24069 implements OnClickListener {
        final /* synthetic */ C2408e f5969a;

        C24069(C2408e c2408e) {
            this.f5969a = c2408e;
        }

        public void onClick(View view) {
            if (this.f5969a.f5986l.m8754d()) {
                this.f5969a.m8836w();
            } else {
                this.f5969a.m8798b(false);
            }
        }
    }

    /* compiled from: VideoFragment */
    private class C2407a extends AsyncTask<String, Void, C2395c> {
        final /* synthetic */ C2408e f5970a;

        private C2407a(C2408e c2408e) {
            this.f5970a = c2408e;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8779a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m8780a((C2395c) obj);
        }

        protected void onPreExecute() {
            this.f5970a.f5993s = null;
        }

        protected C2395c m8779a(String... strArr) {
            String str = strArr[0];
            if (str == null) {
                return null;
            }
            try {
                C2519d a = this.f5970a.m6320d().m6292m().m6221i().mo3669a(str);
                if (a.m9316a() == HttpStatus.SC_OK) {
                    return new C2395c(a.m9317b());
                }
                return null;
            } catch (C2518c e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void m8780a(C2395c c2395c) {
            if (c2395c != null) {
                this.f5970a.f5993s = c2395c;
                this.f5970a.f5998z.sendEmptyMessage(2);
            }
        }
    }

    public static void m8784a() {
        f5971x = -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f5996v = false;
        this.f5975a = m6320d().m6292m();
        this.f5976b = this.f5975a.m6219g().mo3453c();
        this.f5984j = this.f5975a.m6210a();
        this.f5977c = (MovieVideos) getArguments().getSerializable("videos");
        this.f5978d = getArguments().getInt("video_id");
        this.f5981g = (MovieVideo) this.f5977c.m7009a().get(this.f5978d);
        this.f5979e = getArguments().getBoolean("is_homepage_trailer", false);
        Uri parse = Uri.parse(getArguments().getString("_data"));
        try {
            m8785a(this.f5976b.mo3569a(parse), getArguments().getInt("video_id"), getArguments().getBoolean("is_homepage_trailer", false));
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            if (C0141c.m469j()) {
                C0831a.m3750a("movie_uri", parse.toString());
                C0831a.m3749a("video_id", this.f5978d);
                C0831a.m3751a("is_home_page_trailer", this.f5979e);
                C0831a.m3752a(e);
            }
            m6314a(R.string.error_bad_url);
        }
        if (this.f5980f != null) {
            if (f5972y != this.f5980f.m6705g()) {
                f5971x = -1;
            }
            f5972y = this.f5980f.m6705g();
        }
        if (bundle != null) {
            this.f5982h = bundle.getString("resolution");
            this.f5983i = bundle.getString("subtitle_language");
            this.f5974B = bundle.getBoolean("first_play_after_start");
        } else {
            this.f5974B = true;
        }
        m8807h();
    }

    private void m8785a(int i, int i2, boolean z) {
        try {
            this.f5980f = C1992n.m6350a(i, getActivity());
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            if (C0141c.m469j()) {
                C0831a.m3749a("movie_id", i);
                C0831a.m3749a("video_id", i2);
                C0831a.m3751a("is_home_page_trailer", z);
                C0831a.m3752a(e);
            }
            m6314a(R.string.error);
        }
    }

    private void m8807h() {
        if (this.f5981g != null && this.f5981g.m7005c() != null && !this.f5981g.m7005c().isEmpty()) {
            String str;
            if (this.f5983i == null) {
                this.f5983i = (String) ((Entry) this.f5981g.m7005c().get(0)).getKey();
                str = (String) ((Entry) this.f5981g.m7005c().get(0)).getValue();
            } else {
                str = C1992n.m6354a(this.f5981g, this.f5983i);
            }
            C2407a c2407a = new C2407a();
            if (VERSION.SDK_INT >= 11) {
                c2407a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
                return;
            }
            c2407a.execute(new String[]{str});
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.video_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.video_container);
        frameLayout.setOnClickListener(new C24069(this));
        if (C1998s.m6374b()) {
            frameLayout.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
                final /* synthetic */ C2408e f5953a;

                {
                    this.f5953a = r1;
                }

                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0 && !this.f5953a.f5986l.m8754d()) {
                        this.f5953a.m8798b(false);
                    }
                }
            });
        }
        this.f5987m = (VideoView) view.findViewById(R.id.video_view);
        this.f5995u = (TextView) view.findViewById(R.id.video_copyright);
        this.f5988n = new C2397d(this.f5987m, new C2396a(this) {
            final /* synthetic */ C2408e f5954a;

            {
                this.f5954a = r1;
            }

            public void mo3603a(C2397d c2397d) {
                this.f5954a.f5998z.sendEmptyMessage(2);
                this.f5954a.m8798b(false);
                this.f5954a.m6316a(this.f5954a.f5996v ? "video_ad" : "video_film", "start", this.f5954a.f5989o, this.f5954a.f5987m.getCurrentPosition() / 1000);
            }

            public void mo3605b(C2397d c2397d) {
                this.f5954a.f5998z.sendEmptyMessage(1);
                this.f5954a.m6316a(this.f5954a.f5996v ? "video_ad" : "video_film", "pause", this.f5954a.f5989o, this.f5954a.f5987m.getCurrentPosition() / 1000);
            }

            public void mo3604a(C2397d c2397d, int i) {
                this.f5954a.m6316a(this.f5954a.f5996v ? "video_ad" : "video_film", "seek", this.f5954a.f5989o, i / 1000);
            }

            public boolean mo3606c(C2397d c2397d) {
                return !this.f5954a.f5996v || this.f5954a.f5997w;
            }
        });
        this.f5986l = new C2393a(getActivity(), this.f5988n);
        frameLayout.addView(this.f5986l, new LayoutParams(-1, -1));
        this.f5992r = (TextView) view.findViewById(R.id.video_subtitles);
        this.f5994t = view.findViewById(R.id.video_progressbar);
    }

    @TargetApi(11)
    private void m8793a(boolean z) {
        if (C1998s.m6374b()) {
            this.f5987m.setSystemUiVisibility(z ? 0 : 2);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f5981g == null) {
            getActivity().finish();
        }
        C1983f.m6333a("VideoFragment", "onActivityCreated()");
        this.f5973A = m6320d().m6292m().m6226n();
        int o = this.f5973A.m7209o();
        if (o > 0) {
            this.f5992r.setTextSize(2, (float) o);
        }
        if (this.f5982h == null) {
            this.f5982h = this.f5973A.m7206l();
        }
        if (this.f5983i == null) {
            this.f5983i = this.f5973A.m7207m();
        }
        m8810i();
        m8812j();
        m8813k();
    }

    private void m8787a(final Video video) {
        if (this.f5981g != null) {
            this.f5986l.m8751a(video.m7000a(), this.f5982h, new C2391d(this) {
                final /* synthetic */ C2408e f5956b;

                public void mo3607a(C2393a c2393a, String str, int i) {
                    this.f5956b.f5982h = str;
                    this.f5956b.f5973A.m7184a(str);
                    C2408e.f5971x = this.f5956b.f5988n.mo3597d();
                    this.f5956b.m8792a((String) video.m7000a().get(str));
                }
            });
        }
    }

    private void m8810i() {
        if (this.f5981g != null && this.f5981g.m7005c() != null) {
            this.f5986l.m8750a(this.f5981g.m7005c(), this.f5983i, new C2392e(this) {
                final /* synthetic */ C2408e f5957a;

                {
                    this.f5957a = r1;
                }

                public void mo3608a(C2393a c2393a, String str, int i) {
                    this.f5957a.f5983i = str;
                    this.f5957a.f5973A.m7190b(str);
                    String str2 = (String) ((Entry) this.f5957a.f5981g.m7005c().get(i)).getValue();
                    new C2407a().execute(new String[]{str2});
                }
            });
        }
    }

    private void m8812j() {
        this.f5986l.m8749a(new C2390c(this) {
            final /* synthetic */ C2408e f5958a;

            {
                this.f5958a = r1;
            }

            public void mo3609a(C2393a c2393a) {
                C1983f.m6333a("VideoFragment", "onAdSkipped(), ad playing: " + this.f5958a.f5996v);
                if (this.f5958a.f5996v) {
                    this.f5958a.m8820n();
                    this.f5958a.m6316a("video_ad", "skip", this.f5958a.f5989o, this.f5958a.f5987m.getCurrentPosition() / 1000);
                }
            }
        });
    }

    private void m8813k() {
        this.f5986l.m8748a(new C2389b(this) {
            final /* synthetic */ C2408e f5959a;

            {
                this.f5959a = r1;
            }

            public void mo3610a(C2393a c2393a) {
                C1983f.m6333a("VideoFragment", "onAdClicked(), ad playing: " + this.f5959a.f5996v);
                if (this.f5959a.f5996v) {
                    this.f5959a.m8788a(this.f5959a.f5985k);
                    this.f5959a.m6316a("video_ad", "click", this.f5959a.f5989o, this.f5959a.f5987m.getCurrentPosition() / 1000);
                }
            }
        });
    }

    private void m8788a(C2153c c2153c) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(c2153c.m7654c())));
    }

    public void onStart() {
        super.onStart();
        C1983f.m6333a("VideoFragment", "onStart()");
        m6320d().m1367b().mo1420c();
        long currentTimeMillis = System.currentTimeMillis() - this.f5973A.m7202h();
        this.f5987m.setOnPreparedListener(new OnPreparedListener(this) {
            final /* synthetic */ C2408e f5960a;

            {
                this.f5960a = r1;
            }

            public void onPrepared(MediaPlayer mediaPlayer) {
                C1983f.m6333a("VideoFragment", "VideoView, onPrepared()");
                this.f5960a.f5994t.setVisibility(8);
                this.f5960a.m8830t();
                this.f5960a.m8798b(false);
                this.f5960a.m8836w();
                this.f5960a.m8798b(false);
                if (this.f5960a.f5974B) {
                    this.f5960a.f5988n.mo3593a();
                }
            }
        });
        this.f5987m.setOnErrorListener(new C23992(this));
        m6320d().m6280a(new C24003(this), null, new C24014(this));
    }

    private void m8816l() {
        C1983f.m6333a("VideoFragment", "Setting up the player...");
        if (this.f5984j == null || this.f5975a.m6216d() % this.f5984j.m7659c() != 0) {
            m8825q();
            this.f5975a.m6214b();
        } else if (!this.f5979e || this.f5975a.m6217e()) {
            if (this.f5975a.m6216d() >= this.f5984j.m7659c()) {
                this.f5975a.m6215c();
            }
            m8818m();
            this.f5975a.m6214b();
        } else {
            m8825q();
            this.f5975a.m6213a(true);
        }
    }

    private void m8818m() {
        C1983f.m6333a("VideoFragment", "Setting up for Ad playing.");
        this.f5996v = true;
        this.f5997w = false;
        this.f5985k = this.f5984j.m7658b();
        if (this.f5985k == null) {
            Log.e("VideoFragment", "failed to get ad video");
            m8825q();
            return;
        }
        String str;
        if (!TextUtils.isEmpty(this.f5985k.m7654c())) {
            this.f5986l.setAdUrlButtonVisibility(true);
        }
        m8787a(this.f5985k.m7652a());
        if (this.f5982h == null) {
            str = (String) this.f5985k.m7652a().m7000a().get(C1992n.m6357a(this.f5985k.m7652a().m7000a()).get(0));
        } else {
            str = C1992n.m6353a(this.f5985k.m7652a(), this.f5982h);
        }
        m8792a(str);
        this.f5987m.setOnCompletionListener(new C24025(this));
        m8822o();
    }

    private void m8786a(MediaPlayer mediaPlayer) {
        mediaPlayer.setDisplay(null);
        mediaPlayer.reset();
        mediaPlayer.setDisplay(this.f5987m.getHolder());
    }

    private void m8820n() {
        C1983f.m6333a("VideoFragment", "Finishing playing ad.");
        this.f5973A.m7178a(System.currentTimeMillis());
        f5971x = -1;
        m8825q();
    }

    private void m8822o() {
        new Thread(new C24036(this)).start();
    }

    private void m8825q() {
        String str;
        C1983f.m6333a("VideoFragment", "Setting up for Video playing.");
        this.f5996v = false;
        this.f5986l.setAdSkipButtonVisibility(false);
        this.f5986l.setAdUrlButtonVisibility(false);
        m8787a(this.f5981g.m7004b());
        if (TextUtils.isEmpty(this.f5981g.m7008f())) {
            this.f5995u.setText(null);
        } else {
            this.f5995u.setText("© " + this.f5981g.m7008f());
        }
        if (this.f5982h == null) {
            this.f5982h = (String) C1992n.m6357a(this.f5981g.m7004b().m7000a()).get(0);
            str = (String) this.f5981g.m7004b().m7000a().get(this.f5982h);
        } else {
            str = C1992n.m6353a(this.f5981g.m7004b(), this.f5982h);
        }
        m8792a(str);
        this.f5987m.setOnCompletionListener(new C24047(this));
        this.f5998z.sendEmptyMessage(2);
    }

    @TargetApi(8)
    private void m8826r() {
        this.f5990p = (AudioManager) getActivity().getSystemService("audio");
        this.f5991q = new C24058(this);
        this.f5990p.requestAudioFocus(this.f5991q, 3, 1);
    }

    @TargetApi(8)
    private void m8828s() {
        this.f5990p.abandonAudioFocus(this.f5991q);
    }

    private void m8792a(String str) {
        C1983f.m6333a("VideoFragment", "Setting video url: " + str);
        this.f5994t.setVisibility(0);
        this.f5987m.setVideoURI(Uri.parse(str));
        this.f5986l.m8753c();
        this.f5989o = str;
    }

    private void m8830t() {
        if (f5971x > 0) {
            this.f5988n.mo3594a(f5971x);
        }
    }

    public void onResume() {
        super.onResume();
        if (C1998s.m6373a()) {
            m8826r();
        }
    }

    public void onPause() {
        super.onPause();
        if (f5971x < 0) {
            f5971x = this.f5988n.mo3597d();
        }
        if (this.f5988n.mo3598e()) {
            this.f5988n.mo3595b();
        }
        this.f5974B = false;
        if (C1998s.m6373a()) {
            m8828s();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5974B = false;
        bundle.putString("resolution", this.f5982h);
        bundle.putString("subtitle_language", this.f5983i);
        bundle.putBoolean("first_play_after_start", this.f5974B);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5987m.stopPlayback();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_share:
                m8833u();
                m6316a("actionbar", "share", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m8833u() {
        if (this.f5980f == null || !this.f5980f.m6995v()) {
            Toast.makeText(getActivity(), R.string.share_movie_not_loaded, 0).show();
        } else {
            startActivity(Intent.createChooser(m8834v(), getString(R.string.share_with)));
        }
    }

    private Intent m8834v() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.share_movie));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5980f.m6917a()).append(" (").append(this.f5980f.m6965j()).append("), ").append(this.f5980f.m6941e()).append("%").append("\n").append(C1992n.m6361e(this.f5980f));
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        return intent;
    }

    public String mo3436p() {
        return "/video";
    }

    private void m8798b(boolean z) {
        m8793a(true);
        this.f5995u.setVisibility(0);
        if (z) {
            this.f5986l.m8747a(0);
            return;
        }
        this.f5986l.m8752b();
        this.f5998z.sendEmptyMessageDelayed(3, 3000);
    }

    private void m8836w() {
        this.f5986l.m8755e();
        this.f5995u.setVisibility(8);
        m8793a(false);
    }

    private void m8838x() {
        Log.d("VideoFragment", "playNextVideo");
        this.f5981g = m8839y();
        if (this.f5981g != null) {
            this.f5992r.setText("");
            this.f5993s = null;
            m8807h();
            m8816l();
            return;
        }
        getActivity().finish();
    }

    private MovieVideo m8839y() {
        int i = this.f5978d + 1;
        this.f5978d = i;
        Log.d("VideoFragment", "nextVideoId:" + i);
        if (i < this.f5977c.m7009a().size()) {
            return (MovieVideo) this.f5977c.m7009a().get(i);
        }
        return null;
    }
}
