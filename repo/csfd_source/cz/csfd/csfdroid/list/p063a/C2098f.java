package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Comment;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.CommentItemView;

/* compiled from: CommentListItem */
public class C2098f extends C2083a {
    protected Comment f4920b;
    protected int f4921c;

    public C2098f(Comment comment) {
        this.f4920b = comment;
        this.f4921c = R.layout.comment_item;
        this.a = false;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, this.f4921c, viewGroup);
    }

    public Comment m7373c() {
        return this.f4920b;
    }

    public String m7374d() {
        return this.f4920b.m6780a().m6811b();
    }

    public int m7375e() {
        return this.f4920b.m6782b();
    }

    public String m7376f() {
        return this.f4920b.m6783c();
    }

    public int hashCode() {
        return (((this.f4920b == null ? 0 : this.f4920b.hashCode()) + 31) * 31) + this.f4921c;
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
        C2098f c2098f = (C2098f) obj;
        if (this.f4920b == null) {
            if (c2098f.f4920b != null) {
                return false;
            }
        } else if (!this.f4920b.equals(c2098f.f4920b)) {
            return false;
        }
        if (this.f4921c != c2098f.f4921c) {
            return false;
        }
        return true;
    }

    public Class<?> mo3427b() {
        return CommentItemView.class;
    }
}
