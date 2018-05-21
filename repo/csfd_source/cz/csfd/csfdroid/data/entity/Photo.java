package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class Photo implements Serializable {
    private static final long serialVersionUID = 1;
    private String copyright;
    private int height;
    private int smallHeight = -1;
    private String smallUrl;
    private int smallWidth = -1;
    private String url;
    private int width;

    public Photo(String str, int i, int i2) {
        this.url = str;
        this.width = i;
        this.height = i2;
    }

    public String m7010a() {
        return this.url;
    }

    public int m7013b() {
        return this.width;
    }

    public int m7016c() {
        return this.height;
    }

    public String m7017d() {
        return this.smallUrl != null ? this.smallUrl : this.url;
    }

    public void m7012a(String str) {
        this.smallUrl = str;
    }

    public int m7018e() {
        return this.smallWidth != -1 ? this.smallWidth : this.width;
    }

    public void m7011a(int i) {
        this.smallWidth = i;
    }

    public int m7019f() {
        return this.smallHeight != -1 ? this.smallHeight : this.height;
    }

    public void m7014b(int i) {
        this.smallHeight = i;
    }

    public void m7015b(String str) {
        this.copyright = str;
    }

    public String m7020g() {
        return this.copyright;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Photo photo = (Photo) obj;
        if ((this.url == photo.url || this.url.equals(photo.url)) && ((this.smallUrl == photo.smallUrl || this.smallUrl.equals(photo.smallUrl)) && this.width == photo.width && this.smallWidth == photo.smallWidth && this.height == photo.height && this.smallHeight == photo.smallHeight)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.url == null ? 0 : this.url.hashCode()) + 217;
        if (this.smallUrl != null) {
            i = this.smallUrl.hashCode();
        }
        return (((((((((hashCode * 31) + i) * 31) + this.width) * 31) + this.smallWidth) * 31) + this.height) * 31) + this.smallHeight;
    }
}
