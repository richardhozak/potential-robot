package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 1;
    private String avatar;
    private String district;
    private String fullName;
    private Gender gender;
    private boolean inFavorites;
    private boolean loaded;
    private String nick;
    private String occupation;
    private int pointCount = -1;
    private List<C2028e> ratings = new ArrayList();
    private boolean ratingsLoaded;
    private String registration;
    private List<Section> sections = new ArrayList();

    public enum Gender {
        MALE(1),
        FEMALE(2);
        
        int genderId;

        private Gender(int i) {
            this.genderId = i;
        }

        public int m7072a() {
            return this.genderId;
        }

        public static Gender m7071a(int i) {
            for (Gender gender : values()) {
                if (gender.genderId == i) {
                    return gender;
                }
            }
            return null;
        }
    }

    public enum Section {
        FILM_RATINGS("Hodnocení", "ratings", "hodnoceni", "ratings"),
        FILM_COMMENTS("Komentáře", "comments", "komentare", "comments"),
        FANCLUB_FILMS("Oblíbené filmy", "films", "oblibene-filmy", "fanclub_films"),
        FANCLUB_SERIES("Oblíbené seriály", "series", "oblibene-serialy", "fanclub_series"),
        FANCLUB_SHOWS("Oblíbené pořady", "shows", "oblibene-porady", "fanclub_shows"),
        FANCLUB_ACTORS("Oblíbení herci", "actors", "oblibeni-herci", "fanclub_actors"),
        FANCLUB_ACTRESSES("Oblíbené herečky", "actresses", "oblibene-herecky", "fanclub_actresses"),
        FANCLUB_DIRECTORS("Oblíbení režiséři", "directors", "oblibeni-reziseri", "fanclub_directors"),
        FANCLUB_COMPOSERS("Oblíbení skladatelé", "composers", "oblibeni-skladatele", "fanclub_composers"),
        FANCLUB_SCREENWRITERS("Oblíbení scénáristé", "screenwriters", "oblibeni-scenariste", "fanclub_screenwriters"),
        FANCLUB_CINEMATOGRAPHERS("Oblíbení kameramané", "cinematographers", "oblibeni-kameramane", "fanclub_cinematographers"),
        FAVOURITE_USERS("Oblíbení uživatelé", "favorites", "oblibeni-uzivatele", "favorites");
        
        int count;
        String label;
        String path;
        List<?> preview;
        String previewPath;
        String webPath;

        private Section(String str, String str2, String str3, String str4) {
            this.preview = new ArrayList();
            this.label = str;
            this.path = str2;
            this.webPath = str3;
            this.previewPath = str4;
        }

        public void m7076a(List<?> list) {
            this.preview = list;
        }

        public List<?> m7074a() {
            return this.preview;
        }

        public void m7075a(int i) {
            this.count = i;
        }

        public int m7077b() {
            return this.count;
        }

        public String m7078c() {
            return this.label;
        }

        public String sectionPath() {
            return this.path;
        }

        public String m7080e() {
            return this.webPath;
        }

        public String m7081f() {
            return this.previewPath;
        }

        public String toString() {
            return this.label + " (" + this.count + ")";
        }

        public static Section m7073a(String str) {
            for (Section section : values()) {
                if (section.m7080e().equals(str)) {
                    return section;
                }
            }
            return null;
        }
    }

    public User(int i) {
        super(i);
    }

    public User(int i, String str) {
        super(i);
        this.nick = str;
    }

    public String m6811b() {
        return this.nick;
    }

    public void m6808a(String str) {
        this.nick = str;
    }

    public String m6814c() {
        return this.fullName;
    }

    public void m6812b(String str) {
        this.fullName = str;
    }

    public String m6817d() {
        return this.avatar;
    }

    public void m6815c(String str) {
        this.avatar = str;
    }

    public void m6818d(String str) {
        this.occupation = str;
    }

    public String m6819e() {
        return this.district;
    }

    public void m6820e(String str) {
        this.district = str;
    }

    public void m6821f(String str) {
        this.registration = str;
    }

    public boolean m6822f() {
        return this.loaded;
    }

    public void m6810a(boolean z) {
        this.loaded = z;
    }

    public List<C2028e> m6823h() {
        return this.ratings;
    }

    public boolean m6824i() {
        return this.ratingsLoaded;
    }

    public void m6813b(boolean z) {
        this.ratingsLoaded = z;
    }

    public List<Section> m6825j() {
        return this.sections;
    }

    public void m6809a(List<Section> list) {
        this.sections = list;
    }

    public int m6826k() {
        return this.pointCount;
    }

    public void m6806a(int i) {
        this.pointCount = i;
    }

    public Gender m6827l() {
        return this.gender;
    }

    public void m6807a(Gender gender) {
        this.gender = gender;
    }

    public void m6816c(boolean z) {
        this.inFavorites = z;
    }

    public boolean m6828m() {
        return this.inFavorites;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.id == user.id && (this.nick == user.nick || this.nick.equals(user.nick))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.nick == null ? 0 : this.nick.hashCode()) + ((this.id + 217) * 31);
    }
}
