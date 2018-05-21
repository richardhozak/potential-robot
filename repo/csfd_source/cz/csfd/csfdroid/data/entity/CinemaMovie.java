package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CinemaMovie implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean mCsfdHall;
    private boolean f4629mDubbng;
    private boolean mFiltered;
    private boolean mGoldClass;
    private MovieInfo mMovieInfo;
    private List<Date> mShowtimes = new ArrayList();
    private boolean mSubtitles;
    private boolean mTechnology3d;
    private boolean mTechnology4dx;

    public CinemaMovie(CinemaMovie cinemaMovie) {
        this.mMovieInfo = cinemaMovie.m6777g();
        this.f4629mDubbng = cinemaMovie.m6766a();
        this.mSubtitles = cinemaMovie.m6768b();
        this.mTechnology3d = cinemaMovie.m6770c();
        this.mTechnology4dx = cinemaMovie.m6772d();
        this.mCsfdHall = cinemaMovie.m6774e();
        this.mGoldClass = cinemaMovie.m6776f();
    }

    public boolean m6766a() {
        return this.f4629mDubbng;
    }

    public void m6765a(boolean z) {
        this.f4629mDubbng = z;
    }

    public boolean m6768b() {
        return this.mSubtitles;
    }

    public void m6767b(boolean z) {
        this.mSubtitles = z;
    }

    public boolean m6770c() {
        return this.mTechnology3d;
    }

    public void m6769c(boolean z) {
        this.mTechnology3d = z;
    }

    public boolean m6772d() {
        return this.mTechnology4dx;
    }

    public void m6771d(boolean z) {
        this.mTechnology4dx = z;
    }

    public boolean m6774e() {
        return this.mCsfdHall;
    }

    public void m6773e(boolean z) {
        this.mCsfdHall = z;
    }

    public boolean m6776f() {
        return this.mGoldClass;
    }

    public void m6775f(boolean z) {
        this.mGoldClass = z;
    }

    public CinemaMovie(MovieInfo movieInfo, List<Date> list) {
        this.mMovieInfo = movieInfo;
        this.mShowtimes = list;
    }

    public void m6778g(boolean z) {
        this.mFiltered = z;
    }

    public MovieInfo m6777g() {
        return this.mMovieInfo;
    }

    public List<Date> m6779h() {
        return this.mShowtimes;
    }

    public void m6764a(Date date) {
        this.mShowtimes.add(date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CinemaMovie cinemaMovie = (CinemaMovie) obj;
        if (this.mCsfdHall != cinemaMovie.mCsfdHall) {
            return false;
        }
        if (this.f4629mDubbng != cinemaMovie.f4629mDubbng) {
            return false;
        }
        if (this.mGoldClass != cinemaMovie.mGoldClass) {
            return false;
        }
        if (this.mSubtitles != cinemaMovie.mSubtitles) {
            return false;
        }
        if (this.mTechnology3d != cinemaMovie.mTechnology3d) {
            return false;
        }
        if (this.mTechnology4dx != cinemaMovie.mTechnology4dx) {
            return false;
        }
        if (this.mMovieInfo != null) {
            if (this.mMovieInfo.equals(cinemaMovie.mMovieInfo)) {
                return true;
            }
        } else if (cinemaMovie.mMovieInfo == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int hashCode = (this.mMovieInfo != null ? this.mMovieInfo.hashCode() : 0) * 31;
        if (this.f4629mDubbng) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (i + hashCode) * 31;
        if (this.mSubtitles) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (i + hashCode) * 31;
        if (this.mTechnology3d) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (i + hashCode) * 31;
        if (this.mTechnology4dx) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (i + hashCode) * 31;
        if (this.mCsfdHall) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + hashCode) * 31;
        if (!this.mGoldClass) {
            i2 = 0;
        }
        return i + i2;
    }
}
