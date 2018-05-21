package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.List;

public class Seasons implements Serializable {
    private boolean hasNoSeasons;
    private List<Season> seasons;

    public List<Season> m7037a() {
        return this.seasons;
    }

    public void m7038a(List<Season> list) {
        this.seasons = list;
    }

    public boolean m7040b() {
        return this.hasNoSeasons;
    }

    public void m7039a(boolean z) {
        this.hasNoSeasons = z;
    }
}
