package cz.csfd.csfdroid.module.tvtips;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.p017a.C0436a;
import android.support.v7.p017a.C0436a.C0433a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.C2058f;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2115w;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TvStationsFragment */
public class C2460a extends C2063g<List<TvStation>> {
    private C2057e f6154j;
    private C2462c f6155k;
    private List<C2083a> f6156l = new ArrayList();
    private List<TvStation> f6157m = new ArrayList();
    private C2086a f6158n;

    /* compiled from: TvStationsFragment */
    class C24561 implements OnClickListener {
        final /* synthetic */ C2460a f6149a;

        C24561(C2460a c2460a) {
            this.f6149a = c2460a;
        }

        public void onClick(View view) {
            this.f6149a.m9003n();
        }
    }

    /* compiled from: TvStationsFragment */
    class C24572 implements OnClickListener {
        final /* synthetic */ C2460a f6150a;

        C24572(C2460a c2460a) {
            this.f6150a = c2460a;
        }

        public void onClick(View view) {
            this.f6150a.getActivity().finish();
        }
    }

    /* compiled from: TvStationsFragment */
    class C24583 implements OnCancelListener {
        final /* synthetic */ C2460a f6151a;

        C24583(C2460a c2460a) {
            this.f6151a = c2460a;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f6151a.f6155k.mo3640c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        this.f6154j = this.b.m6226n();
        this.f6155k = this.b.m6219g().mo3462l();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m9002m();
    }

    private void m9002m() {
        View inflate = ((LayoutInflater) m6380c().m1367b().mo1424e().getSystemService("layout_inflater")).inflate(R.layout.actionbar_custom_view_done_cancel, null);
        inflate.findViewById(R.id.actionbar_done).setOnClickListener(new C24561(this));
        inflate.findViewById(R.id.actionbar_cancel).setOnClickListener(new C24572(this));
        C0436a b = m6380c().m1367b();
        b.mo1409a(16, 26);
        b.mo1412a(inflate, new C0433a(-1, -1));
        b.mo1419b(false);
        b.mo1421c(false);
    }

    protected void mo3433j() {
        this.f6155k.mo3634a(this, this.b.m6220h());
    }

    protected void mo3434k() {
        this.f6155k.mo3638b();
    }

    protected void m9006b(List<TvStation> list) {
        this.f6157m.addAll(list);
        for (TvStation c2115w : list) {
            this.f6156l.add(new C2115w(c2115w));
        }
        this.f6158n = new C2086a(getActivity(), this.f6156l);
        setListAdapter(this.f6158n);
    }

    private void m9003n() {
        if (m9004o() == 0) {
            Toast.makeText(getActivity(), getString(R.string.error_no_stations), 0).show();
            return;
        }
        final C2058f a = C2058f.m7220a(getFragmentManager(), "stations_progress", R.string.stations_saving, true);
        a.m7221a(new C24583(this));
        this.f6155k.mo3636a(this.f6157m, new C1945a<Boolean>(this) {
            final /* synthetic */ C2460a f6153b;

            public void m8996a(Boolean bool) {
                this.f6153b.f6154j.m7196c(true);
                a.dismiss();
                this.f6153b.getActivity().finish();
            }

            public void mo3323a(Exception exception) {
                a.dismiss();
                Toast.makeText(this.f6153b.getActivity(), this.f6153b.getString(R.string.stations_save_failed), 0).show();
            }

            public void mo3322a() {
                this.f6153b.f6155k.mo3640c();
                a.dismiss();
            }
        }, this.b.m6220h());
    }

    private int m9004o() {
        int i = 0;
        for (TvStation d : this.f6157m) {
            int i2;
            if (d.m7069d()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public String mo3436p() {
        return "/tv-stations";
    }
}
