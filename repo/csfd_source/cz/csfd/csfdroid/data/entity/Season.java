package cz.csfd.csfdroid.data.entity;

import cz.csfd.csfdroid.R;
import java.io.Serializable;
import java.util.List;

public class Season implements Serializable {
    private List<Episode> episodes;
    private List<String> genre;
    private int id;
    private boolean isHidden;
    private String name;
    private String posterUrl;
    private int ratingCategory;
    private String year;

    public int m7021a() {
        return this.id;
    }

    public void m7022a(int i) {
        this.id = i;
    }

    public String m7026b() {
        return this.name;
    }

    public void m7023a(String str) {
        this.name = str;
    }

    public int m7030c() {
        return this.ratingCategory;
    }

    public void m7027b(int i) {
        this.ratingCategory = i;
    }

    public List<String> m7032d() {
        return this.genre;
    }

    public void m7024a(List<String> list) {
        this.genre = list;
    }

    public String m7033e() {
        return this.posterUrl;
    }

    public void m7028b(String str) {
        this.posterUrl = str;
    }

    public String m7034f() {
        return this.year;
    }

    public void m7031c(String str) {
        this.year = str;
    }

    public void m7025a(boolean z) {
        this.isHidden = z;
    }

    public List<Episode> m7035g() {
        return this.episodes;
    }

    public void m7029b(List<Episode> list) {
        this.episodes = list;
    }

    public int m7036h() {
        switch (m7030c()) {
            case 1:
                return R.drawable.movie_item_c1;
            case 2:
                return R.drawable.movie_item_c2;
            case 3:
                return R.drawable.movie_item_c3;
            default:
                return R.drawable.movie_item_c0;
        }
    }
}
