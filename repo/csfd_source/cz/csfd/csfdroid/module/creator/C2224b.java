package cz.csfd.csfdroid.module.creator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.creator.C2234f.C2223a;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.p061d.C1991m;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.LoadingView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: CreatorBiographyFragment */
public class C2224b extends C1974c implements C1973d, C2223a {
    private C2234f f5415a;
    private CsfdApplication f5416b;
    private C1187t f5417c;
    private boolean f5418d = false;
    private boolean f5419e = false;
    private Exception f5420f;
    private MovieCreator f5421g;
    private boolean f5422h = false;
    private ViewGroup f5423i;
    private LoadingView f5424j;
    private OnClickListener f5425k;
    private int f5426l;

    /* compiled from: CreatorBiographyFragment */
    class C22191 implements OnClickListener {
        final /* synthetic */ C2224b f5410a;

        C22191(C2224b c2224b) {
            this.f5410a = c2224b;
        }

        public void onClick(View view) {
            this.f5410a.m7989b(this.f5410a.f5421g);
            this.f5410a.f5424j.setOnTryAgainListener(null);
        }
    }

    /* compiled from: CreatorBiographyFragment */
    class C22213 implements OnCancelListener {
        final /* synthetic */ C2224b f5413a;

        C22213(C2224b c2224b) {
            this.f5413a = c2224b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5413a.m6320d().finish();
        }
    }

    /* compiled from: CreatorBiographyFragment */
    class C22224 implements OnClickListener {
        final /* synthetic */ C2224b f5414a;

        C22224(C2224b c2224b) {
            this.f5414a = c2224b;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(C1991m.m6348b(this.f5414a.f5421g)));
            this.f5414a.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5416b = m6320d().m6292m();
        this.f5415a = this.f5416b.m6219g().mo3454d();
        this.f5417c = C1187t.m5432a(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_creator_biography, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(getArguments().getInt("creatorId")));
        m6315a(C2146b.CREATOR, hashMap);
        this.f5423i = (ViewGroup) view.findViewById(R.id.creator_biography_content);
        this.f5424j = (LoadingView) view.findViewById(R.id.loading);
        this.f5425k = new C22191(this);
        if (this.f5418d || this.f5419e) {
            this.f5424j.setVisibility(0);
        }
        if (this.f5419e) {
            C1988j.m6341a(getActivity(), this.f5424j, this.f5425k, this.f5420f);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f5426l = getArguments().getInt("creatorId");
        if (!this.f5418d && !this.f5419e) {
            m7992c(this.f5426l);
        }
    }

    public void mo3477h() {
        m6322f();
        if (this.f5422h) {
            m6316a(mo3436p(), "selected", null, 0);
            return;
        }
        this.f5422h = true;
        m6316a(mo3436p(), "selected", "first_time", 0);
    }

    private void m7992c(int i) {
        this.f5421g = m7994d(i);
        if (this.f5421g.m6880o()) {
            m7996k();
        } else {
            m7989b(this.f5421g);
        }
    }

    private MovieCreator m7994d(int i) {
        try {
            C2056d k = this.f5416b.m6223k();
            if (k.m7166b(Integer.valueOf(i))) {
                return C1991m.m6346a(i, getActivity());
            }
            BasicEntity movieCreator = new MovieCreator(i);
            k.m7164a(movieCreator);
            return movieCreator;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m6314a(R.string.error);
            return null;
        }
    }

    private void m7989b(final MovieCreator movieCreator) {
        m6320d().m6280a(new Runnable(this) {
            final /* synthetic */ C2224b f5412b;

            public void run() {
                this.f5412b.m7993c(movieCreator);
            }
        }, null, new C22213(this));
    }

    private void m7993c(MovieCreator movieCreator) {
        this.f5415a.mo3517a(movieCreator, (C2223a) this, this.f5416b.m6220h());
    }

    public void onDestroy() {
        super.onDestroy();
        m7995j();
    }

    private void m7995j() {
        if (this.f5421g != null) {
            this.f5415a.mo3513a(this.f5421g.m6705g());
        }
        m6323g();
    }

    public void mo3510i() {
        this.f5418d = true;
        this.f5424j.setVisibility(0);
        this.f5424j.m9451e();
        this.f5424j.m9448b();
    }

    public void m8006a(MovieCreator movieCreator) {
        this.f5418d = false;
        if (movieCreator == null) {
            this.f5419e = true;
            this.f5420f = new NullPointerException("Result is null.");
            C1988j.m6341a(getActivity(), this.f5424j, this.f5425k, this.f5420f);
            return;
        }
        this.f5419e = false;
        Animation b = m6317b(17432577);
        if (b != null) {
            this.f5424j.startAnimation(b);
        }
        this.f5424j.setVisibility(8);
        this.f5421g = movieCreator;
        b = m6317b(17432576);
        if (b != null) {
            this.f5423i.startAnimation(b);
        }
        m7996k();
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null && (targetFragment instanceof C2227c)) {
            ((C2227c) targetFragment).m8020a(this.f5421g);
        }
    }

    public void mo3322a() {
        this.f5418d = false;
    }

    public void mo3323a(Exception exception) {
        this.f5418d = false;
        this.f5419e = true;
        this.f5420f = exception;
        C1988j.m6341a(getActivity(), this.f5424j, this.f5425k, this.f5420f);
    }

    private void m7996k() {
        this.f5423i.setVisibility(0);
        m7997l();
    }

    private void m7997l() {
        m7998m();
        m7999n();
        m8000o();
        m8001q();
        m8002r();
        m8003s();
        m8004t();
    }

    private void m7998m() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.creator_photo);
        String f = this.f5421g.m6867f();
        if (f.length() == 0) {
            this.f5417c.m5437a((int) R.drawable.poster_free).m5473a().m5482c().m5477a(imageView);
        } else {
            this.f5417c.m5439a(f).m5473a().m5482c().m5477a(imageView);
        }
    }

    private void m7999n() {
        TextView textView = (TextView) getView().findViewById(R.id.creator_type);
        List e = this.f5421g.m6865e();
        if (e != null && e.size() > 0) {
            textView.setText(C1991m.m6347a(this.f5421g));
            textView.setVisibility(0);
        }
    }

    private void m8000o() {
        CharSequence format;
        TextView textView = (TextView) getView().findViewById(R.id.creator_birth_date);
        TextView textView2 = (TextView) getView().findViewById(R.id.creator_birth_date_label);
        Date q = this.f5421g.m6882q();
        if (q != null) {
            format = new SimpleDateFormat("d.M.yyyy").format(q);
        } else {
            format = this.f5421g.m6863d();
            if (TextUtils.isEmpty(format)) {
                format = null;
            }
        }
        if (format != null) {
            textView.setText(format);
            textView.setVisibility(0);
            textView2.setVisibility(0);
        }
        ((TextView) getView().findViewById(R.id.creator_birth_place)).setText(this.f5421g.m6872i());
    }

    private void m8001q() {
        CharSequence format;
        TextView textView = (TextView) getView().findViewById(R.id.creator_death_date);
        TextView textView2 = (TextView) getView().findViewById(R.id.creator_death_date_label);
        Date r = this.f5421g.m6883r();
        if (r != null) {
            format = new SimpleDateFormat("d.M.yyyy").format(r);
        } else {
            format = this.f5421g.m6874j();
            if (TextUtils.isEmpty(format)) {
                format = null;
            }
        }
        if (format != null) {
            textView.setText(format);
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
            textView.setVisibility(8);
        }
        textView = (TextView) getView().findViewById(R.id.creator_death_place);
        textView.setText(this.f5421g.m6876k());
        if (TextUtils.isEmpty(this.f5421g.m6876k())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m8002r() {
        TextView textView = (TextView) getView().findViewById(R.id.creator_biography);
        if (TextUtils.isEmpty(this.f5421g.m6877l())) {
            textView.setVisibility(8);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5421g.m6877l());
        String m = this.f5421g.m6878m();
        if (m.length() > 0) {
            stringBuilder.append(" <b><i>(").append(m).append(")</i></b>");
        }
        textView.setText(Html.fromHtml(stringBuilder.toString()));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinksClickable(true);
        textView.setVisibility(0);
    }

    private void m8003s() {
        getView().findViewById(R.id.creator_link_web).setOnClickListener(new C22224(this));
    }

    private void m8004t() {
        TextView textView = (TextView) getView().findViewById(R.id.creator_copyright);
        if (TextUtils.isEmpty(this.f5421g.m6870h())) {
            textView.setVisibility(8);
            return;
        }
        textView.setText("Photo © " + this.f5421g.m6870h());
        textView.setVisibility(0);
    }

    public String mo3436p() {
        return "/creator/biography";
    }
}
