package cz.csfd.csfdroid.data.entity;

import cz.csfd.csfdroid.data.entity.MovieVideo.Video;

/* compiled from: Advert */
public class C2026c {
    private String f4681a;
    private String f4682b;
    private int f4683c;
    private int f4684d;
    private Video f4685e;

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4681a == null ? 0 : this.f4681a.hashCode()) + (((((this.f4682b == null ? 0 : this.f4682b.hashCode()) + ((this.f4684d + 31) * 31)) * 31) + this.f4683c) * 31)) * 31;
        if (this.f4685e != null) {
            i = this.f4685e.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C2026c c2026c = (C2026c) obj;
        if (this.f4684d != c2026c.f4684d) {
            return false;
        }
        if (this.f4682b == null) {
            if (c2026c.f4682b != null) {
                return false;
            }
        } else if (!this.f4682b.equals(c2026c.f4682b)) {
            return false;
        }
        if (this.f4683c != c2026c.f4683c) {
            return false;
        }
        if (this.f4681a == null) {
            if (c2026c.f4681a != null) {
                return false;
            }
        } else if (!this.f4681a.equals(c2026c.f4681a)) {
            return false;
        }
        if (this.f4685e == null) {
            if (c2026c.f4685e != null) {
                return false;
            }
            return true;
        } else if (this.f4685e.equals(c2026c.f4685e)) {
            return true;
        } else {
            return false;
        }
    }
}
