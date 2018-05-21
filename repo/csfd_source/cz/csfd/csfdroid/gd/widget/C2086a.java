package cz.csfd.csfdroid.gd.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.itemview.C2088a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ItemAdapter */
public class C2086a extends BaseAdapter {
    private List<C2083a> f4895a;
    private HashMap<Class<? extends C2083a>, C2082a> f4896b;
    private Context f4897c;
    private boolean f4898d;
    private int f4899e;

    /* compiled from: ItemAdapter */
    private static class C2082a {
        int f4889a;
        int f4890b;

        private C2082a() {
        }
    }

    public C2086a(Context context) {
        this(context, new ArrayList());
    }

    public C2086a(Context context, List<C2083a> list) {
        this(context, list, 10);
    }

    public C2086a(Context context, List<C2083a> list, int i) {
        this.f4897c = context;
        this.f4895a = list;
        this.f4896b = new HashMap();
        this.f4899e = Integer.MAX_VALUE;
        for (C2083a b : this.f4895a) {
            m7311b(b);
        }
        this.f4899e = Math.max(1, Math.max(this.f4896b.size(), i));
    }

    private void m7311b(C2083a c2083a) {
        Class cls = c2083a.getClass();
        C2082a c2082a = (C2082a) this.f4896b.get(cls);
        if (c2082a == null) {
            int size = this.f4896b.size();
            if (size >= this.f4899e) {
                throw new RuntimeException("This ItemAdapter may handle only " + this.f4899e + " different view types.");
            }
            C2082a c2082a2 = new C2082a();
            c2082a2.f4889a = 1;
            c2082a2.f4890b = size;
            this.f4896b.put(cls, c2082a2);
            return;
        }
        c2082a.f4889a++;
    }

    public void m7313a(C2083a c2083a) {
        this.f4895a.add(c2083a);
        m7311b(c2083a);
        if (this.f4898d) {
            notifyDataSetChanged();
        }
    }

    public void m7312a() {
        this.f4895a.clear();
        this.f4896b.clear();
        if (this.f4898d) {
            notifyDataSetChanged();
        }
    }

    public void m7314a(List<C2083a> list) {
        this.f4895a.clear();
        this.f4896b.clear();
        this.f4895a.addAll(list);
        for (C2083a b : this.f4895a) {
            m7311b(b);
        }
        if (this.f4898d) {
            notifyDataSetChanged();
        }
    }

    public void m7315a(boolean z) {
        this.f4898d = z;
    }

    public int getCount() {
        return this.f4895a.size();
    }

    public Object getItem(int i) {
        return this.f4895a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((C2082a) this.f4896b.get(getItem(i).getClass())).f4890b;
    }

    public boolean isEnabled(int i) {
        return ((C2083a) getItem(i)).f4891a;
    }

    public int getViewTypeCount() {
        return this.f4899e;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2087b a;
        C2083a c2083a = (C2083a) getItem(i);
        C2087b c2087b = (C2087b) view;
        Class b = c2083a.mo3427b();
        if (c2087b == null || !b.equals(c2087b.getClass())) {
            if (c2087b != null && (c2087b instanceof C2088a)) {
                ((C2088a) c2087b).mo3430a();
            }
            a = c2083a.mo3426a(this.f4897c, null);
            a.mo3428b();
        } else {
            a = c2087b;
        }
        a.setObject(c2083a);
        return (View) a;
    }
}
