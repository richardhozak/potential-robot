package cz.csfd.csfdroid.data.entity;

import android.location.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema extends BasicEntity implements Serializable, Comparable<Cinema> {
    private static final long serialVersionUID = 1;
    private boolean detailsLoaded = false;
    private String mAddress;
    private float mBearing = -1.0f;
    private String mBestFilmPoster;
    private float mDistance = -1.0f;
    private List<String> mEmails = new ArrayList();
    private boolean mFavourite;
    private boolean mHasSchedule;
    private Location mLocation;
    private String mName;
    private C2029f mSchedule;
    private List<String> mSimpleSchedule;
    private List<String> mTelephones = new ArrayList();
    private String mWeb;

    public /* synthetic */ int compareTo(Object obj) {
        return m6735a((Cinema) obj);
    }

    public Cinema(int i) {
        super(i);
    }

    public Cinema(int i, String str) {
        super(i);
        this.mName = str;
    }

    public String m6736a() {
        return this.mName;
    }

    public void m6740a(String str) {
        this.mName = str;
    }

    public String m6743b() {
        return this.mAddress;
    }

    public void m6745b(String str) {
        this.mAddress = str;
    }

    public String m6748c() {
        return this.mWeb;
    }

    public void m6749c(String str) {
        this.mWeb = str;
    }

    public List<String> m6752d() {
        return this.mTelephones;
    }

    public void m6741a(List<String> list) {
        this.mTelephones = list;
    }

    public List<String> m6754e() {
        return this.mEmails;
    }

    public void m6746b(List<String> list) {
        this.mEmails = list;
    }

    public Location m6755f() {
        return this.mLocation;
    }

    public void m6738a(Location location) {
        this.mLocation = location;
    }

    public float m6756h() {
        return this.mDistance;
    }

    public void m6737a(float f) {
        this.mDistance = f;
    }

    public void m6744b(float f) {
        this.mBearing = f;
    }

    public float m6757i() {
        return this.mBearing;
    }

    public boolean m6758j() {
        return this.detailsLoaded;
    }

    public void m6742a(boolean z) {
        this.detailsLoaded = z;
    }

    public C2029f m6759k() {
        return this.mSchedule;
    }

    public void m6739a(C2029f c2029f) {
        this.mSchedule = c2029f;
    }

    public boolean m6760l() {
        return this.mHasSchedule;
    }

    public void m6747b(boolean z) {
        this.mHasSchedule = z;
    }

    public boolean m6761m() {
        return this.mFavourite;
    }

    public void m6751c(boolean z) {
        this.mFavourite = z;
    }

    public String m6762n() {
        return this.mBestFilmPoster;
    }

    public void m6753d(String str) {
        this.mBestFilmPoster = str;
    }

    public List<String> m6763o() {
        return this.mSimpleSchedule;
    }

    public void m6750c(List<String> list) {
        this.mSimpleSchedule = list;
    }

    public int m6735a(Cinema cinema) {
        return this.mName.compareToIgnoreCase(cinema.mName);
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((this.mName == null ? 0 : this.mName.hashCode()) + (((this.mFavourite ? 1231 : 1237) + (((this.mEmails == null ? 0 : this.mEmails.hashCode()) + (((((((this.mAddress == null ? 0 : this.mAddress.hashCode()) + (super.hashCode() * 31)) * 31) + Float.floatToIntBits(this.mBearing)) * 31) + Float.floatToIntBits(this.mDistance)) * 31)) * 31)) * 31)) * 31;
        if (this.mTelephones == null) {
            i = 0;
        } else {
            i = this.mTelephones.hashCode();
        }
        i = (i + hashCode) * 31;
        if (this.mWeb != null) {
            i2 = this.mWeb.hashCode();
        }
        return i + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cinema cinema = (Cinema) obj;
        if (this.mAddress == null) {
            if (cinema.mAddress != null) {
                return false;
            }
        } else if (!this.mAddress.equals(cinema.mAddress)) {
            return false;
        }
        if (Float.floatToIntBits(this.mBearing) != Float.floatToIntBits(cinema.mBearing)) {
            return false;
        }
        if (Float.floatToIntBits(this.mDistance) != Float.floatToIntBits(cinema.mDistance)) {
            return false;
        }
        if (this.mEmails == null) {
            if (cinema.mEmails != null) {
                return false;
            }
        } else if (!this.mEmails.equals(cinema.mEmails)) {
            return false;
        }
        if (this.mFavourite != cinema.mFavourite) {
            return false;
        }
        if (this.mName == null) {
            if (cinema.mName != null) {
                return false;
            }
        } else if (!this.mName.equals(cinema.mName)) {
            return false;
        }
        if (this.mTelephones == null) {
            if (cinema.mTelephones != null) {
                return false;
            }
        } else if (!this.mTelephones.equals(cinema.mTelephones)) {
            return false;
        }
        if (this.mWeb == null) {
            if (cinema.mWeb != null) {
                return false;
            }
            return true;
        } else if (this.mWeb.equals(cinema.mWeb)) {
            return true;
        } else {
            return false;
        }
    }
}
