package cz.csfd.csfdroid.data.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: Schedule */
public class C2029f {
    private List<CinemaMovie> f4694a = new ArrayList();

    public void m7107a(CinemaMovie cinemaMovie) {
        this.f4694a.add(cinemaMovie);
    }

    private void m7105a(SortedMap<Long, List<CinemaMovie>> sortedMap, CinemaMovie cinemaMovie, Date date) {
        CinemaMovie cinemaMovie2;
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        List list = (List) sortedMap.get(Long.valueOf(instance.getTimeInMillis()));
        if (list == null) {
            list = new ArrayList();
            sortedMap.put(Long.valueOf(instance.getTimeInMillis()), list);
        }
        CinemaMovie cinemaMovie3 = new CinemaMovie(cinemaMovie);
        int indexOf = list.indexOf(cinemaMovie3);
        if (indexOf >= 0) {
            cinemaMovie2 = (CinemaMovie) list.get(indexOf);
        } else {
            list.add(cinemaMovie3);
            cinemaMovie2 = cinemaMovie3;
        }
        cinemaMovie2.m6764a(date);
    }

    public SortedMap<Long, List<CinemaMovie>> m7106a() {
        SortedMap<Long, List<CinemaMovie>> treeMap = new TreeMap();
        for (CinemaMovie cinemaMovie : this.f4694a) {
            for (Date a : cinemaMovie.m6779h()) {
                m7105a(treeMap, cinemaMovie, a);
            }
        }
        return treeMap;
    }

    public int m7108b() {
        return this.f4694a.size();
    }
}
