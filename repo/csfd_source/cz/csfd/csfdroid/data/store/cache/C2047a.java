package cz.csfd.csfdroid.data.store.cache;

/* compiled from: CacheTables */
public class C2047a {

    /* compiled from: CacheTables */
    enum C2037a {
        _ID("favorites_activity", "_id"),
        TYPE("favorites_activity", "activity_type"),
        OPERATION("favorites_activity", "activity_operation"),
        INSERTED_DATETIME("favorites_activity", "inserted_datetime"),
        RATING("favorites_activity", "activity_rating"),
        USER_ID("favorites_activity", "user_id"),
        MOVIE_ID("favorites_activity", "movie_id");
        
        private String f4724h;
        private String f4725i;
        private String f4726j;

        private C2037a(String str, String str2) {
            this.f4724h = str + "." + str2;
            this.f4725i = str2;
            this.f4726j = str + "_" + str2;
        }

        public String m7115a() {
            return this.f4724h;
        }

        public String m7116b() {
            return this.f4725i;
        }
    }

    /* compiled from: CacheTables */
    enum C2038b {
        _ID("home_list_cache", "_id"),
        MOVIE_LIST_ID("home_list_cache", "movie_list_id"),
        LAST_STORED_DATE("home_list_cache", "last_stored_date");
        
        private String f4731d;
        private String f4732e;
        private String f4733f;

        private C2038b(String str, String str2) {
            this.f4731d = str + "." + str2;
            this.f4732e = str2;
            this.f4733f = str + "_" + str2;
        }

        public String m7117a() {
            return this.f4731d;
        }

        public String m7118b() {
            return this.f4732e;
        }
    }

    /* compiled from: CacheTables */
    enum C2039c {
        _ID("movie", "_id"),
        CSFD_ID("movie", "csfd_id"),
        COLOR("movie", "color"),
        RATING("movie", "rating"),
        GENRE("movie", "genre"),
        ORIGIN("movie", "origin"),
        NAME("movie", "name"),
        RELEASE_DATE("movie", "release_date"),
        TYPE("movie", "type"),
        YEAR("movie", "year"),
        POSTER_URL("movie", "poster_url");
        
        private String f4746l;
        private String f4747m;
        private String f4748n;

        private C2039c(String str, String str2) {
            this.f4746l = str + "." + str2;
            this.f4747m = str2;
            this.f4748n = str + "_" + str2;
        }

        public String m7119a() {
            return this.f4746l;
        }

        public String m7120b() {
            return this.f4747m;
        }
    }

    /* compiled from: CacheTables */
    enum C2040d {
        _ID("movie_list", "_id"),
        KEY("movie_list", "key");
        
        private String f4752c;
        private String f4753d;
        private String f4754e;

        private C2040d(String str, String str2) {
            this.f4752c = str + "." + str2;
            this.f4753d = str2;
            this.f4754e = str + "_" + str2;
        }

        public String m7121a() {
            return this.f4752c;
        }

        public String m7122b() {
            return this.f4753d;
        }
    }

    /* compiled from: CacheTables */
    enum C2041e {
        _ID("movie_list_movie", "_id"),
        MOVIE_LIST_ID("movie_list_movie", "movie_list_id"),
        MOVIE_ID("movie_list_movie", "movie_id"),
        ORDER_IN_LIST("movie_list_movie", "order_in_list");
        
        private String f4760e;
        private String f4761f;
        private String f4762g;

        private C2041e(String str, String str2) {
            this.f4760e = str + "." + str2;
            this.f4761f = str2;
            this.f4762g = str + "_" + str2;
        }

        public String m7123a() {
            return this.f4760e;
        }

        public String m7124b() {
            return this.f4761f;
        }
    }

    /* compiled from: CacheTables */
    enum C2042f {
        _ID("movie_video", "_id"),
        MOVIE_ID("movie_video", "movie_id"),
        NAME("movie_video", "name"),
        IS_HOMEPAGE_TRAILER("movie_video", "is_homepage_trailer"),
        THUMBNAIL("movie_video", "thumbnail"),
        THUMBNAIL_WIDTH("movie_video", "thumbnail_width"),
        THUMBNAIL_HEIGHT("movie_video", "thumbnail_height");
        
        private String f4771h;
        private String f4772i;
        private String f4773j;

        private C2042f(String str, String str2) {
            this.f4771h = str + "." + str2;
            this.f4772i = str2;
            this.f4773j = str + "_" + str2;
        }

        public String m7125a() {
            return this.f4772i;
        }
    }

    /* compiled from: CacheTables */
    enum C2043g {
        _ID("movie_video_resolutions", "_id"),
        MOVIE_VIDEO_ID("movie_video_resolutions", "movie_video_id"),
        RESOLUTION("movie_video_resolutions", "resolution"),
        URL("movie_video_resolutions", "url");
        
        private String f4779e;
        private String f4780f;
        private String f4781g;

        private C2043g(String str, String str2) {
            this.f4779e = str + "." + str2;
            this.f4780f = str2;
            this.f4781g = str + "_" + str2;
        }

        public String m7126a() {
            return this.f4780f;
        }
    }

    /* compiled from: CacheTables */
    enum C2044h {
        _ID("movie_video_subtitles", "_id"),
        MOVIE_VIDEO_ID("movie_video_subtitles", "movie_video_id"),
        LANGUAGE("movie_video_subtitles", "language"),
        URL("movie_video_subtitles", "url");
        
        private String f4787e;
        private String f4788f;
        private String f4789g;

        private C2044h(String str, String str2) {
            this.f4787e = str + "." + str2;
            this.f4788f = str2;
            this.f4789g = str + "_" + str2;
        }

        public String m7127a() {
            return this.f4788f;
        }
    }

    /* compiled from: CacheTables */
    enum C2045i {
        _ID("tv_programm", "_id"),
        DATE("tv_programm", "date"),
        MOVIE_ID("tv_programm", "movie_id"),
        STATION("tv_programm", "station");
        
        private String f4795e;
        private String f4796f;
        private String f4797g;

        private C2045i(String str, String str2) {
            this.f4795e = str + "." + str2;
            this.f4796f = str2;
            this.f4797g = str + "_" + str2;
        }

        public String m7128a() {
            return this.f4795e;
        }

        public String m7129b() {
            return this.f4796f;
        }

        public String m7130c() {
            return this.f4797g;
        }
    }

    /* compiled from: CacheTables */
    enum C2046j {
        _ID("user", "_id"),
        USER_ID("user", "user_id"),
        NICK("user", "nick"),
        AVATAR_URL("user", "avatar_url"),
        GENDER_ID("user", "gender_id");
        
        private String f4804f;
        private String f4805g;
        private String f4806h;

        private C2046j(String str, String str2) {
            this.f4804f = str + "." + str2;
            this.f4805g = str2;
            this.f4806h = str + "_" + str2;
        }

        public String m7131a() {
            return this.f4804f;
        }

        public String m7132b() {
            return this.f4805g;
        }
    }
}
