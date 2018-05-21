package cz.csfd.csfdroid.module.ads;

import cz.csfd.csfdroid.data.entity.MovieVideo.Video;
import java.util.Map;

/* compiled from: VideoAd */
public class C2153c {
    private Video f5189a;
    private String f5190b;
    private String f5191c;
    private int f5192d;
    private float f5193e;

    public C2153c(Map<String, String> map, String str, String str2, int i, float f) {
        this.f5189a = new Video(map);
        this.f5190b = str;
        this.f5191c = str2;
        this.f5192d = i;
        this.f5193e = f;
    }

    public Video m7652a() {
        return this.f5189a;
    }

    public String m7653b() {
        return this.f5190b;
    }

    public String m7654c() {
        return this.f5191c;
    }

    public int m7655d() {
        return this.f5192d;
    }

    public float m7656e() {
        return this.f5193e;
    }
}
