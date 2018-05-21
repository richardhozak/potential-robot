package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class HomeList implements Serializable, Comparable<HomeList> {
    private static final long serialVersionUID = 1;
    private boolean mChecked;
    private String mDescription;
    private String mKey;
    private int mPosition;
    private String mTitle;

    public /* synthetic */ int compareTo(Object obj) {
        return m6798a((HomeList) obj);
    }

    public HomeList(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public HomeList(String str, String str2, String str3, boolean z) {
        this.mKey = str;
        this.mTitle = str2;
        this.mDescription = str3;
        this.mChecked = z;
    }

    public String m6799a() {
        return this.mKey;
    }

    public String m6802b() {
        return this.mTitle;
    }

    public boolean m6803c() {
        return this.mChecked;
    }

    public void m6801a(boolean z) {
        this.mChecked = z;
    }

    public void m6800a(int i) {
        this.mPosition = i;
    }

    public int m6804d() {
        return this.mPosition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.mKey.equals(((HomeList) obj).mKey)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mKey.hashCode();
    }

    public String toString() {
        return this.mTitle;
    }

    public int m6798a(HomeList homeList) {
        if (this.mPosition < homeList.m6804d()) {
            return -1;
        }
        if (this.mPosition > homeList.m6804d()) {
            return 1;
        }
        return 0;
    }
}
