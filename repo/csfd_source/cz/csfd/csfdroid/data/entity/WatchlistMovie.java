package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class WatchlistMovie implements Serializable {
    private static final long serialVersionUID = 1;
    private MovieInfo mMovieInfo;

    public WatchlistMovie(MovieInfo movieInfo) {
        this.mMovieInfo = movieInfo;
    }

    public MovieInfo m7082a() {
        return this.mMovieInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WatchlistMovie watchlistMovie = (WatchlistMovie) obj;
        if (this.mMovieInfo != null) {
            if (this.mMovieInfo.equals(watchlistMovie.mMovieInfo)) {
                return true;
            }
        } else if (watchlistMovie.mMovieInfo == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mMovieInfo != null ? this.mMovieInfo.hashCode() : 0;
    }
}
