package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.CinemaItemView;
import cz.csfd.csfdroid.p061d.C1985h;
import cz.csfd.csfdroid.p061d.C1990l;

/* compiled from: CinemaListItem */
public class C2096d extends C2083a {
    protected Cinema f4914b;
    protected int f4915c = R.layout.list_item_cinema;
    private int f4916d;

    public C2096d(Cinema cinema, int i) {
        this.f4914b = cinema;
        this.f4916d = i;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4915c, viewGroup);
    }

    public Cinema m7353c() {
        return this.f4914b;
    }

    public String m7354d() {
        return this.f4914b.m6736a();
    }

    public String m7355e() {
        if (this.f4914b.m6743b() != null) {
            return C1990l.m6345a(this.f4914b.m6743b());
        }
        return null;
    }

    public String m7356f() {
        if (this.f4914b.m6756h() > 0.0f) {
            return C1985h.m6338a(this.f4914b.m6756h() * 1000.0f);
        }
        return null;
    }

    public float m7357g() {
        return this.f4914b.m6757i();
    }

    public boolean m7358h() {
        return this.f4914b.m6760l();
    }

    public boolean m7359i() {
        return this.f4914b.m6761m();
    }

    public String m7360j() {
        if (this.f4914b.m6763o() == null) {
            return null;
        }
        String str = "";
        int size = this.f4914b.m6763o().size();
        int i = 0;
        while (i < size) {
            String str2 = str + ((String) this.f4914b.m6763o().get(i));
            if (i < size - 1) {
                str2 = str2 + ", ";
            }
            i++;
            str = str2;
        }
        return str;
    }

    public int m7361k() {
        return this.f4916d;
    }

    public int hashCode() {
        return (this.f4914b == null ? 0 : this.f4914b.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C2096d c2096d = (C2096d) obj;
        if (this.f4914b == null) {
            if (c2096d.f4914b != null) {
                return false;
            }
            return true;
        } else if (this.f4914b.equals(c2096d.f4914b)) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> mo3427b() {
        return CinemaItemView.class;
    }
}
