package cz.csfd.csfdroid.module.cinema;

import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2096d;
import java.util.List;

/* compiled from: CinemaListFragment */
public abstract class C2181d extends C1999d {
    protected void m7775a(List<Cinema> list, List<C2083a> list2) {
        if (list != null && list.size() > 0) {
            for (Cinema c2096d : list) {
                list2.add(new C2096d(c2096d, 0));
            }
        }
    }
}
