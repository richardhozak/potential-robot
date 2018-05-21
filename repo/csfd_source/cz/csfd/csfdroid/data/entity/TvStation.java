package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TvStation implements Serializable {
    private static final long serialVersionUID = 1;
    private int id;
    private String logoUrl;
    private String name;
    private List<TvMovie> schedule = new ArrayList();
    private boolean selected;

    public int m7060a() {
        return this.id;
    }

    public void m7062a(int i) {
        this.id = i;
    }

    public String m7066b() {
        return this.name;
    }

    public void m7064a(String str) {
        this.name = str;
    }

    public String m7068c() {
        return this.logoUrl;
    }

    public void m7067b(String str) {
        this.logoUrl = str;
    }

    public boolean m7069d() {
        return this.selected;
    }

    public void m7065a(boolean z) {
        this.selected = z;
    }

    public List<TvMovie> m7070e() {
        return this.schedule;
    }

    public List<TvMovie> m7061a(Date date, Date date2, Date date3, boolean z) {
        List<TvMovie> arrayList = new ArrayList();
        for (TvMovie tvMovie : this.schedule) {
            if ((tvMovie.m7049b().compareTo(date) >= 0 && tvMovie.m7049b().compareTo(date2) < 0) || (z && tvMovie.m7051c().after(date3) && tvMovie.m7049b().compareTo(date2) <= 0)) {
                arrayList.add(tvMovie);
            }
        }
        return arrayList;
    }

    public void m7063a(TvMovie tvMovie) {
        this.schedule.add(tvMovie);
    }
}
