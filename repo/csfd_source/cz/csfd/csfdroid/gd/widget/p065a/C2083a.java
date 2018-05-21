package cz.csfd.csfdroid.gd.widget.p065a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;

/* compiled from: Item */
public abstract class C2083a {
    public boolean f4891a = true;
    private Object f4892b;

    public abstract C2087b mo3426a(Context context, ViewGroup viewGroup);

    public abstract Class<?> mo3427b();

    public Object m7304a() {
        return this.f4892b;
    }

    public void m7305a(Object obj) {
        this.f4892b = obj;
    }

    protected static C2087b m7302a(Context context, int i, ViewGroup viewGroup) {
        return (C2087b) LayoutInflater.from(context).inflate(i, viewGroup, false);
    }
}
