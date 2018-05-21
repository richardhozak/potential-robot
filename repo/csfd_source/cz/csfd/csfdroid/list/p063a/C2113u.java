package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Trivia;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.TriviaItemView;

/* compiled from: TriviaListItem */
public class C2113u extends C2083a {
    protected Trivia f4945b;
    protected int f4946c;

    public C2113u(Trivia trivia) {
        this.f4945b = trivia;
        this.f4946c = R.layout.trivia_item;
        this.a = false;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4946c, viewGroup);
    }

    public String m7444c() {
        if (this.f4945b.m7043c() != null) {
            return this.f4945b.m7043c().m6811b();
        }
        if (this.f4945b.m7044d() != null) {
            return this.f4945b.m7044d();
        }
        return null;
    }

    public int m7445d() {
        if (this.f4945b.m7043c() != null) {
            return this.f4945b.m7043c().m6705g();
        }
        return 0;
    }

    public String m7446e() {
        return this.f4945b.m7041a();
    }

    public String m7447f() {
        return this.f4945b.m7042b();
    }

    public int hashCode() {
        return (((this.f4945b == null ? 0 : this.f4945b.hashCode()) + 31) * 31) + this.f4946c;
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
        C2113u c2113u = (C2113u) obj;
        if (this.f4945b == null) {
            if (c2113u.f4945b != null) {
                return false;
            }
        } else if (!this.f4945b.equals(c2113u.f4945b)) {
            return false;
        }
        if (this.f4946c != c2113u.f4946c) {
            return false;
        }
        return true;
    }

    public Class<?> mo3427b() {
        return TriviaItemView.class;
    }
}
