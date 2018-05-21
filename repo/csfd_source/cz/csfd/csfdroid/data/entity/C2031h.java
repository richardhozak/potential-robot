package cz.csfd.csfdroid.data.entity;

/* compiled from: VideoType */
public class C2031h {
    private int f4699a;
    private String f4700b;

    public C2031h(int i, String str) {
        this.f4699a = i;
        this.f4700b = str;
    }

    public int m7110a() {
        return this.f4699a;
    }

    public String m7111b() {
        return this.f4700b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2031h c2031h = (C2031h) obj;
        if (this.f4699a != c2031h.f4699a) {
            return false;
        }
        if (this.f4700b != null) {
            if (this.f4700b.equals(c2031h.f4700b)) {
                return true;
            }
        } else if (c2031h.f4700b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f4700b != null ? this.f4700b.hashCode() : 0) + (this.f4699a * 31);
    }
}
