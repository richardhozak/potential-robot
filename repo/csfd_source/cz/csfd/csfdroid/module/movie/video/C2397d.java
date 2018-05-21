package cz.csfd.csfdroid.module.movie.video;

import android.widget.VideoView;
import cz.csfd.csfdroid.module.movie.video.C2393a.C2388a;

/* compiled from: VideoControl */
public class C2397d implements C2388a {
    private VideoView f5951a;
    private C2396a f5952b;

    /* compiled from: VideoControl */
    public interface C2396a {
        void mo3603a(C2397d c2397d);

        void mo3604a(C2397d c2397d, int i);

        void mo3605b(C2397d c2397d);

        boolean mo3606c(C2397d c2397d);
    }

    public C2397d(VideoView videoView, C2396a c2396a) {
        this.f5951a = videoView;
        this.f5952b = c2396a;
    }

    public void mo3593a() {
        this.f5951a.start();
        this.f5952b.mo3603a(this);
    }

    public void mo3595b() {
        this.f5951a.pause();
        this.f5952b.mo3605b(this);
    }

    public int mo3596c() {
        return this.f5951a.getDuration();
    }

    public int mo3597d() {
        return this.f5951a.getCurrentPosition();
    }

    public void mo3594a(int i) {
        if (this.f5952b.mo3606c(this)) {
            this.f5951a.seekTo(i);
            this.f5952b.mo3604a(this, i);
        }
    }

    public boolean mo3598e() {
        return this.f5951a.isPlaying();
    }

    public int mo3599f() {
        return this.f5951a.getBufferPercentage();
    }

    public boolean mo3600g() {
        return this.f5951a.canPause();
    }

    public boolean mo3601h() {
        return this.f5952b.mo3606c(this) && this.f5951a.canSeekBackward();
    }

    public boolean mo3602i() {
        return this.f5952b.mo3606c(this) && this.f5951a.canSeekForward();
    }
}
