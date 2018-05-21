package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.CreatorItemView;
import cz.csfd.csfdroid.p061d.C1991m;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: CreatorListItem */
public class C2099g extends C2083a {
    private MovieCreator f4922b;
    private int f4923c;

    public C2099g(MovieCreator movieCreator, boolean z) {
        this.f4922b = movieCreator;
        if (z) {
            this.f4923c = R.layout.simple_creator_item;
        } else {
            this.f4923c = R.layout.list_item_creator;
        }
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4923c, viewGroup);
    }

    public MovieCreator m7379c() {
        return this.f4922b;
    }

    public String m7380d() {
        if (this.f4922b.m6848a().length() > 0) {
            return this.f4922b.m6848a() + " " + this.f4922b.m6855b();
        }
        return this.f4922b.m6855b();
    }

    public String m7381e() {
        return this.f4922b.m6863d();
    }

    public String m7382f() {
        Date q = this.f4922b.m6882q();
        if (q != null) {
            return new SimpleDateFormat("d.M.yyyy").format(q);
        }
        return m7381e();
    }

    public String m7383g() {
        return this.f4922b.m6872i();
    }

    public String m7384h() {
        return this.f4922b.m6874j();
    }

    public String m7385i() {
        Date r = this.f4922b.m6883r();
        if (r != null) {
            return new SimpleDateFormat("d.M.yyyy").format(r);
        }
        return m7384h();
    }

    public String m7386j() {
        return this.f4922b.m6876k();
    }

    public String m7387k() {
        return C1991m.m6347a(this.f4922b);
    }

    public String m7388l() {
        return this.f4922b.m6867f();
    }

    public Class<?> mo3427b() {
        return CreatorItemView.class;
    }
}
