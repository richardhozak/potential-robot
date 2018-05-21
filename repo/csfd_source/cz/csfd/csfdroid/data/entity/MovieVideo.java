package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MovieVideo implements Serializable {
    private static final long serialVersionUID = 1;
    private String mCopyright;
    private int mId;
    private List<Entry<String, String>> mLanguageSubtitles;
    private MovieInfo mMovieInfo;
    private String mName;
    private Photo mThumbnail;
    private Video mVideo;

    public static class Video implements Serializable {
        private Map<String, String> mResolutionVideos;

        public Video(Map<String, String> map) {
            this.mResolutionVideos = Collections.unmodifiableMap(map);
        }

        public Map<String, String> m7000a() {
            return this.mResolutionVideos;
        }

        public int hashCode() {
            return (this.mResolutionVideos == null ? 0 : this.mResolutionVideos.hashCode()) + 31;
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
            Video video = (Video) obj;
            if (this.mResolutionVideos == null) {
                if (video.mResolutionVideos != null) {
                    return false;
                }
                return true;
            } else if (this.mResolutionVideos.equals(video.mResolutionVideos)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public MovieVideo(int i, String str, Map<String, String> map, Photo photo, List<Entry<String, String>> list) {
        this.mId = i;
        this.mVideo = new Video(map);
        this.mThumbnail = photo;
        this.mName = str;
        this.mLanguageSubtitles = Collections.unmodifiableList(list);
    }

    public String m7001a() {
        return this.mName;
    }

    public Video m7004b() {
        return this.mVideo;
    }

    public List<Entry<String, String>> m7005c() {
        return this.mLanguageSubtitles;
    }

    public Photo m7006d() {
        return this.mThumbnail;
    }

    public MovieInfo m7007e() {
        return this.mMovieInfo;
    }

    public void m7002a(MovieInfo movieInfo) {
        this.mMovieInfo = movieInfo;
    }

    public String m7008f() {
        return this.mCopyright;
    }

    public void m7003a(String str) {
        this.mCopyright = str;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mThumbnail == null ? 0 : this.mThumbnail.hashCode()) + (((this.mName == null ? 0 : this.mName.hashCode()) + (((this.mLanguageSubtitles == null ? 0 : this.mLanguageSubtitles.hashCode()) + ((this.mId + 31) * 31)) * 31)) * 31)) * 31;
        if (this.mVideo != null) {
            i = this.mVideo.hashCode();
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
        MovieVideo movieVideo = (MovieVideo) obj;
        if (this.mId != movieVideo.mId) {
            return false;
        }
        if (this.mLanguageSubtitles == null) {
            if (movieVideo.mLanguageSubtitles != null) {
                return false;
            }
        } else if (!this.mLanguageSubtitles.equals(movieVideo.mLanguageSubtitles)) {
            return false;
        }
        if (this.mName == null) {
            if (movieVideo.mName != null) {
                return false;
            }
        } else if (!this.mName.equals(movieVideo.mName)) {
            return false;
        }
        if (this.mThumbnail == null) {
            if (movieVideo.mThumbnail != null) {
                return false;
            }
        } else if (!this.mThumbnail.equals(movieVideo.mThumbnail)) {
            return false;
        }
        if (this.mVideo == null) {
            if (movieVideo.mVideo != null) {
                return false;
            }
            return true;
        } else if (this.mVideo.equals(movieVideo.mVideo)) {
            return true;
        } else {
            return false;
        }
    }
}
