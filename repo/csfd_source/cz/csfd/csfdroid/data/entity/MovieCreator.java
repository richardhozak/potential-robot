package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieCreator extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 3;
    private Map<String, List<MovieInfo>> actorFilmography = new HashMap();
    private Map<String, List<MovieInfo>> authorFilmography = new HashMap();
    private String biography = "";
    private String biographySource = "";
    private Date birthDate;
    private String birthPlace = "";
    private String birthYear = "";
    private Map<String, List<MovieInfo>> cinematographerFilmography = new HashMap();
    private Map<String, List<MovieInfo>> composerFilmography = new HashMap();
    private Date deathDate;
    private String deathPlace = "";
    private String deathYear = "";
    private boolean detailsLoaded = false;
    private Map<String, List<MovieInfo>> directorFilmography = new HashMap();
    private List<Filmography> filmographies = new ArrayList();
    private boolean filmographyLoaded = false;
    private String firstname = "";
    private List<Photo> gallery = new ArrayList();
    private boolean galleryLoaded;
    private String photoCopyright = "";
    private int photoCount;
    private String photoUrl = "";
    private Map<String, List<MovieInfo>> screenwriterFilmography = new HashMap();
    private String surname = "";
    private List<String> type = new ArrayList();
    private int videoCount;

    public MovieCreator(int i) {
        super(i);
    }

    public String m6848a() {
        return this.firstname;
    }

    public void m6851a(String str) {
        this.firstname = str;
    }

    public String m6855b() {
        return this.surname;
    }

    public void m6856b(String str) {
        this.surname = str;
    }

    public String m6859c() {
        if (this.firstname.length() > 0) {
            return this.firstname + " " + this.surname;
        }
        return this.surname;
    }

    public String m6863d() {
        if (this.birthDate != null) {
            return String.valueOf(this.birthDate.getYear());
        }
        return this.birthYear;
    }

    public void m6861c(String str) {
        this.birthYear = str;
    }

    public List<String> m6865e() {
        return this.type;
    }

    public void m6853a(List<String> list) {
        this.type = list;
    }

    public String m6867f() {
        return this.photoUrl;
    }

    public void m6864d(String str) {
        this.photoUrl = str;
    }

    public String m6870h() {
        return this.photoCopyright;
    }

    public void m6866e(String str) {
        this.photoCopyright = str;
    }

    public String m6872i() {
        return this.birthPlace;
    }

    public void m6868f(String str) {
        this.birthPlace = str;
    }

    public String m6874j() {
        if (this.deathDate != null) {
            return String.valueOf(this.deathDate.getYear());
        }
        return this.deathYear;
    }

    public void m6869g(String str) {
        this.deathYear = str;
    }

    public String m6876k() {
        return this.deathPlace;
    }

    public void m6871h(String str) {
        this.deathPlace = str;
    }

    public String m6877l() {
        return this.biography;
    }

    public void m6873i(String str) {
        this.biography = str;
    }

    public String m6878m() {
        return this.biographySource;
    }

    public void m6875j(String str) {
        this.biographySource = str;
    }

    public void m6850a(Filmography filmography) {
        this.filmographies.add(filmography);
    }

    public List<Filmography> m6879n() {
        return this.filmographies;
    }

    public boolean m6880o() {
        return this.detailsLoaded;
    }

    public void m6854a(boolean z) {
        this.detailsLoaded = z;
    }

    public boolean m6881p() {
        return this.filmographyLoaded;
    }

    public void m6858b(boolean z) {
        this.filmographyLoaded = z;
    }

    public Date m6882q() {
        return this.birthDate;
    }

    public void m6852a(Date date) {
        this.birthYear = String.valueOf(date.getYear());
        this.birthDate = date;
    }

    public Date m6883r() {
        return this.deathDate;
    }

    public void m6857b(Date date) {
        this.deathYear = String.valueOf(date.getYear());
        this.deathDate = date;
    }

    public boolean m6884s() {
        return this.galleryLoaded;
    }

    public void m6862c(boolean z) {
        this.galleryLoaded = z;
    }

    public List<Photo> m6885t() {
        return this.gallery;
    }

    public int m6886u() {
        return this.gallery.size();
    }

    public int m6887v() {
        return this.photoCount;
    }

    public void m6849a(int i) {
        this.photoCount = i;
    }

    public int m6888w() {
        return this.videoCount;
    }

    public void m6860c(int i) {
        this.videoCount = i;
    }

    public String toString() {
        if (this.firstname.length() > 0) {
            return this.firstname + " " + this.surname;
        }
        return this.surname;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MovieCreator movieCreator = (MovieCreator) obj;
        if ((this.firstname == movieCreator.firstname || this.firstname.equals(movieCreator.firstname)) && ((this.surname == movieCreator.surname || this.surname.equals(movieCreator.surname)) && ((this.birthPlace == movieCreator.birthPlace || this.birthPlace.equals(movieCreator.birthPlace)) && ((this.deathPlace == movieCreator.deathPlace || this.deathPlace.equals(movieCreator.deathPlace)) && ((this.biography == movieCreator.biography || this.biography.equals(movieCreator.biography)) && ((this.biographySource == movieCreator.biographySource || this.biographySource.equals(movieCreator.biographySource)) && ((this.photoUrl == movieCreator.photoUrl || this.photoUrl.equals(movieCreator.photoUrl)) && ((this.birthDate == movieCreator.birthDate || this.birthDate.equals(movieCreator.birthDate)) && ((this.deathDate == movieCreator.deathDate || this.deathDate.equals(movieCreator.deathDate)) && this.birthYear == movieCreator.birthYear && this.deathYear == movieCreator.deathYear && this.filmographyLoaded == movieCreator.filmographyLoaded && this.detailsLoaded == movieCreator.detailsLoaded && ((this.type == movieCreator.type || this.type.equals(movieCreator.type)) && ((this.directorFilmography == movieCreator.directorFilmography || this.directorFilmography.equals(movieCreator.directorFilmography)) && ((this.actorFilmography == movieCreator.actorFilmography || this.actorFilmography.equals(movieCreator.actorFilmography)) && (this.composerFilmography == movieCreator.composerFilmography || this.composerFilmography.equals(movieCreator.composerFilmography)))))))))))))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int hashCode = (((((((((((((((((((((this.firstname == null ? 0 : this.firstname.hashCode()) + 217) * 31) + (this.surname == null ? 0 : this.surname.hashCode())) * 31) + (this.birthPlace == null ? 0 : this.birthPlace.hashCode())) * 31) + (this.deathPlace == null ? 0 : this.deathPlace.hashCode())) * 31) + (this.biography == null ? 0 : this.biography.hashCode())) * 31) + (this.biographySource == null ? 0 : this.biographySource.hashCode())) * 31) + (this.photoUrl == null ? 0 : this.photoUrl.hashCode())) * 31) + (this.birthDate == null ? 0 : this.birthDate.hashCode())) * 31) + (this.deathDate == null ? 0 : this.deathDate.hashCode())) * 31) + (this.birthYear == null ? 0 : this.birthYear.hashCode())) * 31) + (this.deathYear == null ? 0 : this.deathYear.hashCode());
        if (this.filmographyLoaded) {
            i = 1;
        } else {
            i = 0;
        }
        i += hashCode * 31;
        if (!this.detailsLoaded) {
            i2 = 0;
        }
        i = (this.actorFilmography == null ? 0 : this.actorFilmography.hashCode()) + ((((((i2 + (i * 31)) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.directorFilmography == null ? 0 : this.directorFilmography.hashCode())) * 31);
        if (this.composerFilmography != null) {
            i3 = this.composerFilmography.hashCode();
        }
        return (i * 31) + i3;
    }
}
