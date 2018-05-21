package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.Date;

public class TvMovie implements Serializable {
    private Date mEnd;
    private int mLength;
    private MovieInfo mMovieInfo;
    private Date mStart;

    public MovieInfo m7045a() {
        return this.mMovieInfo;
    }

    public void m7047a(MovieInfo movieInfo) {
        this.mMovieInfo = movieInfo;
    }

    public Date m7049b() {
        return this.mStart;
    }

    public void m7048a(Date date) {
        this.mStart = date;
    }

    public Date m7051c() {
        return this.mEnd;
    }

    public void m7050b(Date date) {
        this.mEnd = date;
    }

    public void m7046a(int i) {
        this.mLength = i;
    }
}
