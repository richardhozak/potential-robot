package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chart implements Serializable {
    private static final long serialVersionUID = 1;
    private int mHighlightPosition;
    private String mId;
    private boolean mLoaded;
    private List<ChartMovie> mMovies;
    private String mTitle;

    public Chart(String str) {
        this(str, null);
    }

    public Chart(String str, String str2) {
        this.mMovies = new ArrayList();
        this.mId = str;
        this.mTitle = str2;
    }

    public String m6718a() {
        return this.mId;
    }

    public String m6721b() {
        return this.mTitle;
    }

    public List<ChartMovie> m6722c() {
        return this.mMovies;
    }

    public void m6720a(boolean z) {
        this.mLoaded = z;
    }

    public boolean m6723d() {
        return this.mLoaded;
    }

    public void m6719a(int i) {
        this.mHighlightPosition = i;
    }

    public int m6724e() {
        return this.mHighlightPosition;
    }

    public String toString() {
        return this.mTitle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chart chart = (Chart) obj;
        if (this.mId != null) {
            if (this.mId.equals(chart.mId)) {
                return true;
            }
        } else if (chart.mId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mId != null ? this.mId.hashCode() : 0;
    }
}
