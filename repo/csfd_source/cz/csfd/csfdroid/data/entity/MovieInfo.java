package cz.csfd.csfdroid.data.entity;

import cz.csfd.csfdroid.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieInfo extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 3;
    private List<MovieCreator> actors = new ArrayList();
    private C2026c advert;
    private List<MovieCreator> authors = new ArrayList();
    private List<MovieCreator> cinematographers = new ArrayList();
    private List<Comment> comments = new ArrayList();
    private int commentsCount = 0;
    private boolean commentsLoaded = false;
    private List<MovieCreator> composers = new ArrayList();
    private List<MovieCreator> costumes = new ArrayList();
    boolean creatorsLoaded = false;
    boolean detailsLoaded = false;
    private List<MovieCreator> directors = new ArrayList();
    private List<MovieCreator> editors = new ArrayList();
    private List<Photo> gallery = new ArrayList();
    boolean galleryLoaded = false;
    private List<String> genre = new ArrayList();
    private boolean hasNoSeasons = false;
    private MovieVideo homepageTrailer;
    private boolean inCinemas;
    private boolean inFavoriteCinemas;
    private boolean inTv;
    private boolean isInWatchlist = false;
    private boolean isRatingComputed;
    private String length = "";
    private List<C2027d> mCharts = new ArrayList();
    private List<MovieCreator> masks = new ArrayList();
    private String myComment = "";
    private int myRating = -1;
    private String name = "";
    private int nextId;
    private List<String> origin = new ArrayList();
    private String originalName = "";
    private int parentId;
    private int photosCount = 0;
    private String plot = "";
    private String plotSource = "";
    private String positionCode;
    private String posterUrl = "";
    private int prevId;
    private List<MovieCreator> producers = new ArrayList();
    private int rating = -1;
    private boolean ratingAllowed = true;
    private Category ratingCategory = Category.GREY;
    private Date releaseDate;
    private int rootId;
    private String rootName;
    private String rootNameOriginal;
    private List<MovieCreator> scenographies = new ArrayList();
    private List<MovieCreator> screenwriters = new ArrayList();
    private String searchName = "";
    private List<MovieCreator> sound = new ArrayList();
    private List<Trivia> trivia = new ArrayList();
    private int triviaCount = 0;
    private boolean triviaLoaded = false;
    private List<TvProgramm> tvProgramms = new ArrayList();
    private String type = "";
    private int typeId;
    private int videoCount = 0;
    private List<MovieVideo> videos = new ArrayList();
    private boolean videosLoaded = false;
    private int year = -1;

    public enum Category {
        RED(1),
        BLUE(2),
        BLACK(3),
        GREY(0);
        
        private final int code;

        private Category(int i) {
            this.code = i;
        }

        public int m6890a() {
            return this.code;
        }

        public static Category m6889a(int i) {
            switch (i) {
                case 1:
                    return RED;
                case 2:
                    return BLUE;
                case 3:
                    return BLACK;
                default:
                    return GREY;
            }
        }
    }

    public MovieInfo(int i) {
        super(i);
    }

    public MovieInfo(int i, String str) {
        super(i);
        this.name = str;
    }

    public String toString() {
        return this.name + " (" + this.year + ")";
    }

    public String m6917a() {
        return this.name;
    }

    public void m6922a(String str) {
        this.name = str;
    }

    public String m6927b() {
        return this.searchName;
    }

    public void m6928b(String str) {
        this.searchName = str;
    }

    public String m6931c() {
        return this.originalName;
    }

    public void m6933c(String str) {
        this.originalName = str;
    }

    public String m6936d() {
        return this.posterUrl;
    }

    public void m6938d(String str) {
        this.posterUrl = str;
    }

    public int m6941e() {
        return this.rating;
    }

    public void m6918a(int i) {
        this.rating = i;
    }

    public List<MovieCreator> m6946f() {
        return this.actors;
    }

    public void m6925a(List<MovieCreator> list) {
        this.actors = list;
    }

    public int m6955h() {
        return this.gallery.size();
    }

    public List<Photo> m6960i() {
        return this.gallery;
    }

    public int m6965j() {
        return this.year;
    }

    public void m6932c(int i) {
        this.year = i;
    }

    public List<MovieCreator> m6970k() {
        return this.directors;
    }

    public void m6929b(List<MovieCreator> list) {
        this.directors = list;
    }

    public List<MovieCreator> m6975l() {
        return this.composers;
    }

    public void m6934c(List<MovieCreator> list) {
        this.composers = list;
    }

    public List<MovieCreator> m6980m() {
        return this.authors;
    }

    public void m6939d(List<MovieCreator> list) {
        this.authors = list;
    }

    public List<MovieCreator> m6984n() {
        return this.screenwriters;
    }

    public void m6944e(List<MovieCreator> list) {
        this.screenwriters = list;
    }

    public List<MovieCreator> m6986o() {
        return this.cinematographers;
    }

    public void m6949f(List<MovieCreator> list) {
        this.cinematographers = list;
    }

    public List<MovieCreator> m6988p() {
        return this.producers;
    }

    public void m6953g(List<MovieCreator> list) {
        this.producers = list;
    }

    public List<MovieCreator> m6990q() {
        return this.editors;
    }

    public void m6958h(List<MovieCreator> list) {
        this.editors = list;
    }

    public List<MovieCreator> m6991r() {
        return this.sound;
    }

    public void m6963i(List<MovieCreator> list) {
        this.sound = list;
    }

    public List<MovieCreator> m6992s() {
        return this.scenographies;
    }

    public void m6968j(List<MovieCreator> list) {
        this.scenographies = list;
    }

    public List<MovieCreator> m6993t() {
        return this.masks;
    }

    public void m6973k(List<MovieCreator> list) {
        this.masks = list;
    }

    public List<MovieCreator> m6994u() {
        return this.costumes;
    }

    public void m6978l(List<MovieCreator> list) {
        this.costumes = list;
    }

    public boolean m6995v() {
        return this.detailsLoaded;
    }

    public void m6926a(boolean z) {
        this.detailsLoaded = z;
    }

    public boolean m6996w() {
        return this.galleryLoaded;
    }

    public void m6930b(boolean z) {
        this.galleryLoaded = z;
    }

    public List<String> m6997x() {
        return this.genre;
    }

    public void m6982m(List<String> list) {
        this.genre = list;
    }

    public List<String> m6998y() {
        return this.origin;
    }

    public void m6985n(List<String> list) {
        this.origin = list;
    }

    public String m6999z() {
        return this.length;
    }

    public void m6943e(String str) {
        this.length = str;
    }

    public String m6891A() {
        return this.plot;
    }

    public void m6948f(String str) {
        this.plot = str;
    }

    public String m6892B() {
        return this.plotSource;
    }

    public void m6952g(String str) {
        this.plotSource = str;
    }

    public String m6893C() {
        return this.type;
    }

    public void m6957h(String str) {
        this.type = str;
    }

    public int m6894D() {
        return this.typeId;
    }

    public void m6937d(int i) {
        this.typeId = i;
    }

    public int m6895E() {
        return this.rootId;
    }

    public void m6942e(int i) {
        this.rootId = i;
    }

    public String m6896F() {
        return this.rootName;
    }

    public void m6962i(String str) {
        this.rootName = str;
    }

    public void m6967j(String str) {
        this.rootNameOriginal = str;
    }

    public int m6897G() {
        return this.parentId;
    }

    public void m6947f(int i) {
        this.parentId = i;
    }

    public int m6898H() {
        return this.prevId;
    }

    public void m6951g(int i) {
        this.prevId = i;
    }

    public int m6899I() {
        return this.nextId;
    }

    public void m6956h(int i) {
        this.nextId = i;
    }

    public String m6900J() {
        return this.positionCode;
    }

    public void m6972k(String str) {
        this.positionCode = str;
    }

    public List<Comment> m6901K() {
        return this.comments;
    }

    public void m6987o(List<Comment> list) {
        this.comments = list;
    }

    public int m6902L() {
        return this.comments.size();
    }

    public List<Trivia> m6903M() {
        return this.trivia;
    }

    public int m6904N() {
        return this.trivia.size();
    }

    public boolean m6905O() {
        return this.triviaLoaded;
    }

    public void m6935c(boolean z) {
        this.triviaLoaded = z;
    }

    public int m6906P() {
        return this.myRating;
    }

    public void m6961i(int i) {
        this.myRating = i;
    }

    public int m6907Q() {
        return this.myRating / 20;
    }

    public void m6940d(boolean z) {
        this.isRatingComputed = z;
    }

    public boolean m6908R() {
        return this.isRatingComputed;
    }

    public String m6909S() {
        return this.myComment;
    }

    public void m6977l(String str) {
        this.myComment = str;
    }

    public boolean m6910T() {
        return this.commentsLoaded;
    }

    public void m6945e(boolean z) {
        this.commentsLoaded = z;
    }

    public List<MovieVideo> m6911U() {
        return this.videos;
    }

    public int m6912V() {
        return this.videos.size();
    }

    public boolean m6913W() {
        return this.videosLoaded;
    }

    public boolean m6914X() {
        return this.videosLoaded || m6911U().size() > 0;
    }

    public void m6950f(boolean z) {
        this.videosLoaded = z;
    }

    public MovieVideo m6915Y() {
        return this.homepageTrailer;
    }

    public void m6920a(MovieVideo movieVideo) {
        this.homepageTrailer = movieVideo;
    }

    public Category m6916Z() {
        return this.ratingCategory;
    }

    public void m6919a(Category category) {
        this.ratingCategory = category;
    }

    public int aa() {
        switch (m6916Z()) {
            case RED:
                return R.color.movie_color_1;
            case BLUE:
                return R.color.movie_color_2;
            case BLACK:
                return R.color.movie_color_3;
            default:
                return R.color.movie_color_0;
        }
    }

    public int ab() {
        switch (m6916Z()) {
            case RED:
                return R.drawable.movie_item_c1;
            case BLUE:
                return R.drawable.movie_item_c2;
            case BLACK:
                return R.drawable.movie_item_c3;
            default:
                return R.drawable.movie_item_c0;
        }
    }

    public boolean ac() {
        return this.ratingAllowed;
    }

    public void m6954g(boolean z) {
        this.ratingAllowed = z;
    }

    public void m6921a(TvProgramm tvProgramm) {
        this.tvProgramms.add(tvProgramm);
    }

    public List<TvProgramm> ad() {
        return this.tvProgramms;
    }

    public void m6923a(ArrayList<TvProgramm> arrayList) {
        this.tvProgramms = arrayList;
    }

    public Date ae() {
        return this.releaseDate;
    }

    public void m6924a(Date date) {
        this.releaseDate = date;
    }

    public boolean af() {
        return this.creatorsLoaded;
    }

    public void m6959h(boolean z) {
        this.creatorsLoaded = z;
    }

    public void m6966j(int i) {
        this.photosCount = i;
    }

    public void m6971k(int i) {
        this.commentsCount = i;
    }

    public void m6976l(int i) {
        this.videoCount = i;
    }

    public void m6981m(int i) {
        this.triviaCount = i;
    }

    public void m6964i(boolean z) {
        this.inCinemas = z;
    }

    public void m6969j(boolean z) {
        this.inFavoriteCinemas = z;
    }

    public void m6974k(boolean z) {
        this.inTv = z;
    }

    public int ag() {
        return this.photosCount;
    }

    public int ah() {
        return this.commentsCount;
    }

    public int ai() {
        return this.videoCount;
    }

    public int aj() {
        return this.triviaCount;
    }

    public boolean ak() {
        return this.inCinemas;
    }

    public boolean al() {
        return this.inFavoriteCinemas;
    }

    public boolean am() {
        return this.inTv;
    }

    public List<C2027d> an() {
        return this.mCharts;
    }

    public void m6989p(List<C2027d> list) {
        this.mCharts = list;
    }

    public boolean ao() {
        return this.isInWatchlist;
    }

    public void m6979l(boolean z) {
        this.isInWatchlist = z;
    }

    public boolean ap() {
        return this.hasNoSeasons;
    }

    public void m6983m(boolean z) {
        this.hasNoSeasons = z;
    }

    public int hashCode() {
        int i;
        int i2 = 1231;
        int i3 = 0;
        int hashCode = ((((this.comments == null ? 0 : this.comments.hashCode()) + (((this.advert == null ? 0 : this.advert.hashCode()) + (((this.actors == null ? 0 : this.actors.hashCode()) + (super.hashCode() * 31)) * 31)) * 31)) * 31) + this.commentsCount) * 31;
        if (this.commentsLoaded) {
            i = 1231;
        } else {
            i = 1237;
        }
        hashCode = ((this.composers == null ? 0 : this.composers.hashCode()) + ((i + hashCode) * 31)) * 31;
        if (this.creatorsLoaded) {
            i = 1231;
        } else {
            i = 1237;
        }
        hashCode = (i + hashCode) * 31;
        if (this.detailsLoaded) {
            i = 1231;
        } else {
            i = 1237;
        }
        hashCode = ((this.gallery == null ? 0 : this.gallery.hashCode()) + (((this.directors == null ? 0 : this.directors.hashCode()) + ((i + hashCode) * 31)) * 31)) * 31;
        if (this.galleryLoaded) {
            i = 1231;
        } else {
            i = 1237;
        }
        hashCode = ((((this.posterUrl == null ? 0 : this.posterUrl.hashCode()) + (((this.plotSource == null ? 0 : this.plotSource.hashCode()) + (((this.plot == null ? 0 : this.plot.hashCode()) + (((((this.originalName == null ? 0 : this.originalName.hashCode()) + (((this.origin == null ? 0 : this.origin.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((((this.myComment == null ? 0 : this.myComment.hashCode()) + (((this.length == null ? 0 : this.length.hashCode()) + (((this.genre == null ? 0 : this.genre.hashCode()) + ((i + hashCode) * 31)) * 31)) * 31)) * 31) + this.myRating) * 31)) * 31)) * 31)) * 31) + this.photosCount) * 31)) * 31)) * 31)) * 31) + this.rating) * 31;
        if (this.ratingAllowed) {
            i = 1231;
        } else {
            i = 1237;
        }
        i = ((this.videos == null ? 0 : this.videos.hashCode()) + (((((this.type == null ? 0 : this.type.hashCode()) + (((this.tvProgramms == null ? 0 : this.tvProgramms.hashCode()) + (((this.searchName == null ? 0 : this.searchName.hashCode()) + (((this.releaseDate == null ? 0 : this.releaseDate.hashCode()) + (((this.ratingCategory == null ? 0 : this.ratingCategory.hashCode()) + ((i + hashCode) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.videoCount) * 31)) * 31;
        if (!this.videosLoaded) {
            i2 = 1237;
        }
        i = (((i + i2) * 31) + this.year) * 31;
        if (this.homepageTrailer != null) {
            i3 = this.homepageTrailer.hashCode();
        }
        return i + i3;
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
        MovieInfo movieInfo = (MovieInfo) obj;
        if (this.actors == null) {
            if (movieInfo.actors != null) {
                return false;
            }
        } else if (!this.actors.equals(movieInfo.actors)) {
            return false;
        }
        if (this.advert == null) {
            if (movieInfo.advert != null) {
                return false;
            }
        } else if (!this.advert.equals(movieInfo.advert)) {
            return false;
        }
        if (this.comments == null) {
            if (movieInfo.comments != null) {
                return false;
            }
        } else if (!this.comments.equals(movieInfo.comments)) {
            return false;
        }
        if (this.commentsCount != movieInfo.commentsCount) {
            return false;
        }
        if (this.commentsLoaded != movieInfo.commentsLoaded) {
            return false;
        }
        if (this.composers == null) {
            if (movieInfo.composers != null) {
                return false;
            }
        } else if (!this.composers.equals(movieInfo.composers)) {
            return false;
        }
        if (this.creatorsLoaded != movieInfo.creatorsLoaded) {
            return false;
        }
        if (this.detailsLoaded != movieInfo.detailsLoaded) {
            return false;
        }
        if (this.directors == null) {
            if (movieInfo.directors != null) {
                return false;
            }
        } else if (!this.directors.equals(movieInfo.directors)) {
            return false;
        }
        if (this.gallery == null) {
            if (movieInfo.gallery != null) {
                return false;
            }
        } else if (!this.gallery.equals(movieInfo.gallery)) {
            return false;
        }
        if (this.galleryLoaded != movieInfo.galleryLoaded) {
            return false;
        }
        if (this.genre == null) {
            if (movieInfo.genre != null) {
                return false;
            }
        } else if (!this.genre.equals(movieInfo.genre)) {
            return false;
        }
        if (this.length == null) {
            if (movieInfo.length != null) {
                return false;
            }
        } else if (!this.length.equals(movieInfo.length)) {
            return false;
        }
        if (this.myComment == null) {
            if (movieInfo.myComment != null) {
                return false;
            }
        } else if (!this.myComment.equals(movieInfo.myComment)) {
            return false;
        }
        if (this.myRating != movieInfo.myRating) {
            return false;
        }
        if (this.name == null) {
            if (movieInfo.name != null) {
                return false;
            }
        } else if (!this.name.equals(movieInfo.name)) {
            return false;
        }
        if (this.origin == null) {
            if (movieInfo.origin != null) {
                return false;
            }
        } else if (!this.origin.equals(movieInfo.origin)) {
            return false;
        }
        if (this.originalName == null) {
            if (movieInfo.originalName != null) {
                return false;
            }
        } else if (!this.originalName.equals(movieInfo.originalName)) {
            return false;
        }
        if (this.photosCount != movieInfo.photosCount) {
            return false;
        }
        if (this.plot == null) {
            if (movieInfo.plot != null) {
                return false;
            }
        } else if (!this.plot.equals(movieInfo.plot)) {
            return false;
        }
        if (this.plotSource == null) {
            if (movieInfo.plotSource != null) {
                return false;
            }
        } else if (!this.plotSource.equals(movieInfo.plotSource)) {
            return false;
        }
        if (this.posterUrl == null) {
            if (movieInfo.posterUrl != null) {
                return false;
            }
        } else if (!this.posterUrl.equals(movieInfo.posterUrl)) {
            return false;
        }
        if (this.rating != movieInfo.rating) {
            return false;
        }
        if (this.ratingAllowed != movieInfo.ratingAllowed) {
            return false;
        }
        if (this.ratingCategory != movieInfo.ratingCategory) {
            return false;
        }
        if (this.releaseDate == null) {
            if (movieInfo.releaseDate != null) {
                return false;
            }
        } else if (!this.releaseDate.equals(movieInfo.releaseDate)) {
            return false;
        }
        if (this.searchName == null) {
            if (movieInfo.searchName != null) {
                return false;
            }
        } else if (!this.searchName.equals(movieInfo.searchName)) {
            return false;
        }
        if (this.tvProgramms == null) {
            if (movieInfo.tvProgramms != null) {
                return false;
            }
        } else if (!this.tvProgramms.equals(movieInfo.tvProgramms)) {
            return false;
        }
        if (this.type == null) {
            if (movieInfo.type != null) {
                return false;
            }
        } else if (!this.type.equals(movieInfo.type)) {
            return false;
        }
        if (this.videoCount != movieInfo.videoCount) {
            return false;
        }
        if (this.videos == null) {
            if (movieInfo.videos != null) {
                return false;
            }
        } else if (!this.videos.equals(movieInfo.videos)) {
            return false;
        }
        if (this.videosLoaded != movieInfo.videosLoaded) {
            return false;
        }
        if (this.year != movieInfo.year) {
            return false;
        }
        if (this.homepageTrailer == null) {
            if (movieInfo.homepageTrailer != null) {
                return false;
            }
            return true;
        } else if (this.homepageTrailer.equals(movieInfo.homepageTrailer)) {
            return true;
        } else {
            return false;
        }
    }
}
