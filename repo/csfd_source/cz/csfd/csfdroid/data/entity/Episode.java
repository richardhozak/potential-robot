package cz.csfd.csfdroid.data.entity;

import cz.csfd.csfdroid.R;
import java.io.Serializable;

public class Episode implements Serializable {
    private int id;
    private String name;
    private String positionCode;
    private int ratingCategory;
    private String year;

    public int m6785a() {
        return this.id;
    }

    public void m6786a(int i) {
        this.id = i;
    }

    public String m6788b() {
        return this.name;
    }

    public void m6787a(String str) {
        this.name = str;
    }

    public int m6791c() {
        return this.ratingCategory;
    }

    public void m6789b(int i) {
        this.ratingCategory = i;
    }

    public void m6790b(String str) {
        this.year = str;
    }

    public String m6793d() {
        return this.positionCode;
    }

    public void m6792c(String str) {
        this.positionCode = str;
    }

    public int m6794e() {
        switch (m6791c()) {
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
