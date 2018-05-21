package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class ChartMovie implements Serializable {
    private static final long serialVersionUID = 1;
    private int mFanclubCount;
    private MovieInfo mMovieInfo;
    private int mPosition;
    private int mRating = -1;
    private int mRatingAverage;
    private int mRatingCount;

    public ChartMovie(MovieInfo movieInfo, int i) {
        this.mMovieInfo = movieInfo;
        this.mPosition = i;
    }

    public int m6725a() {
        return this.mPosition;
    }

    public MovieInfo m6727b() {
        return this.mMovieInfo;
    }

    public int m6729c() {
        return this.mRating;
    }

    public void m6726a(int i) {
        this.mRating = i;
    }

    public int m6731d() {
        return this.mRatingAverage;
    }

    public void m6728b(int i) {
        this.mRatingAverage = i;
    }

    public int m6733e() {
        return this.mRatingCount;
    }

    public void m6730c(int i) {
        this.mRatingCount = i;
    }

    public int m6734f() {
        return this.mFanclubCount;
    }

    public void m6732d(int i) {
        this.mFanclubCount = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChartMovie chartMovie = (ChartMovie) obj;
        if (this.mPosition != chartMovie.mPosition) {
            return false;
        }
        if (this.mRating != chartMovie.mRating) {
            return false;
        }
        if (this.mMovieInfo != null) {
            if (this.mMovieInfo.equals(chartMovie.mMovieInfo)) {
                return true;
            }
        } else if (chartMovie.mMovieInfo == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.mMovieInfo != null ? this.mMovieInfo.hashCode() : 0) * 31) + this.mPosition) * 31) + this.mRating;
    }
}
