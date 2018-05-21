package cz.csfd.csfdroid.data.entity;

import java.util.Date;

/* compiled from: Rating */
public class C2028e {
    private User f4689a;
    private MovieInfo f4690b;
    private int f4691c;
    private Date f4692d;
    private String f4693e;

    public C2028e(User user, MovieInfo movieInfo, int i, Date date) {
        this.f4689a = user;
        this.f4690b = movieInfo;
        this.f4691c = i;
        this.f4692d = date;
    }

    public MovieInfo m7100a() {
        return this.f4690b;
    }

    public int m7102b() {
        return this.f4691c;
    }

    public Date m7103c() {
        return this.f4692d;
    }

    public String m7104d() {
        return this.f4693e;
    }

    public void m7101a(String str) {
        this.f4693e = str;
    }
}
