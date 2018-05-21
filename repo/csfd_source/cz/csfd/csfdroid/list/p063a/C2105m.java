package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.gd.widget.p065a.C2085b;
import cz.csfd.csfdroid.list.itemview.ListenableProgressItemView;

/* compiled from: ListenableProgressItem */
public class C2105m extends C2085b {
    private C2061a f4933d;
    private ListenableProgressItemView f4934e;
    private int f4935f;
    private OnClickListener f4936g;

    /* compiled from: ListenableProgressItem */
    public interface C2061a {
        void mo3416a();
    }

    public C2105m(String str, C2061a c2061a) {
        super(str, true);
        this.f4933d = c2061a;
        this.a = false;
        this.f4935f = 1;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return (ListenableProgressItemView) C2083a.m7302a(context, R.layout.progress_item_view, viewGroup);
    }

    public void m7414a(ListenableProgressItemView listenableProgressItemView) {
        this.f4934e = listenableProgressItemView;
        m7412a(this.f4935f);
        listenableProgressItemView.setButtonListener(this.f4936g);
    }

    public void m7416c() {
        this.f4933d.mo3416a();
    }

    public void m7412a(int i) {
        this.f4935f = i;
        if (this.f4934e != null) {
            switch (i) {
                case 2:
                    this.f4934e.setProgressVisibility(false);
                    this.f4934e.setNoConnectionVisibility(true);
                    return;
                default:
                    this.f4934e.setProgressVisibility(true);
                    this.f4934e.setNoConnectionVisibility(false);
                    return;
            }
        }
    }

    public int m7417d() {
        return this.f4935f;
    }

    public void m7413a(OnClickListener onClickListener) {
        this.f4936g = onClickListener;
        if (this.f4934e != null) {
            this.f4934e.setButtonListener(onClickListener);
        }
    }

    public Class<?> mo3427b() {
        return ListenableProgressItemView.class;
    }
}
