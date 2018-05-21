package cz.csfd.csfdroid.data.entity;

import android.text.TextUtils;
import com.google.android.gms.ads.AdSize;

/* compiled from: AdBanner */
public class C2024a {
    private String f4669a;
    private String f4670b;
    private String f4671c;
    private String f4672d;
    private int f4673e;
    private int f4674f;
    private double f4675g;
    private double f4676h;
    private AdSize f4677i;

    public C2024a(String str, String str2, String str3, String str4, int i) {
        this.f4669a = str;
        this.f4670b = str2;
        this.f4671c = str3;
        this.f4672d = str4;
        this.f4673e = i;
    }

    public C2024a(String str, String str2, String str3, int i, int i2) {
        this.f4669a = str;
        this.f4670b = str2;
        this.f4672d = str3;
        this.f4673e = i;
        this.f4674f = i2;
    }

    public String m7083a() {
        return this.f4669a;
    }

    public String m7087b() {
        return this.f4670b;
    }

    public String m7089c() {
        return this.f4671c;
    }

    public String m7084a(int i) {
        CharSequence b;
        String c;
        if (i == 1) {
            b = m7087b();
            c = m7089c();
        } else {
            b = m7089c();
            c = m7087b();
        }
        if (TextUtils.isEmpty(b)) {
            return c;
        }
        return b;
    }

    public String m7090d() {
        return this.f4672d;
    }

    public int m7091e() {
        return this.f4673e;
    }

    public int m7092f() {
        return this.f4674f;
    }

    public boolean m7093g() {
        return !TextUtils.isEmpty(this.f4670b);
    }

    public void m7085a(double d) {
        this.f4675g = d;
    }

    public double m7094h() {
        return this.f4675g;
    }

    public void m7088b(double d) {
        this.f4676h = d;
    }

    public double m7095i() {
        return this.f4676h;
    }

    public void m7086a(AdSize adSize) {
        this.f4677i = adSize;
    }

    public AdSize m7096j() {
        return this.f4677i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2024a c2024a = (C2024a) obj;
        if (this.f4673e != c2024a.f4673e) {
            return false;
        }
        if (this.f4669a == null ? c2024a.f4669a != null : !this.f4669a.equals(c2024a.f4669a)) {
            return false;
        }
        if (this.f4671c == null ? c2024a.f4671c != null : !this.f4671c.equals(c2024a.f4671c)) {
            return false;
        }
        if (this.f4670b == null ? c2024a.f4670b != null : !this.f4670b.equals(c2024a.f4670b)) {
            return false;
        }
        if (this.f4672d != null) {
            if (this.f4672d.equals(c2024a.f4672d)) {
                return true;
            }
        } else if (c2024a.f4672d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.f4669a != null ? this.f4669a.hashCode() : 0) * 31;
        if (this.f4670b != null) {
            hashCode = this.f4670b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f4671c != null) {
            hashCode = this.f4671c.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f4672d != null) {
            i = this.f4672d.hashCode();
        }
        return ((hashCode + i) * 31) + this.f4673e;
    }
}
