package cz.csfd.csfdroid.module.movie;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.avast.android.dialogs.p037a.C0946b;
import com.avast.android.dialogs.p037a.C0946b.C0945a;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import cz.csfd.csfdroid.C2058f;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Identity.Acl;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.module.movie.C2366h.C2318h;
import cz.csfd.csfdroid.net.C2516a;
import cz.csfd.csfdroid.net.C2516a.C1963a;
import cz.csfd.csfdroid.p061d.C1984g;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import cz.csfd.csfdroid.widget.C2550a;
import cz.csfd.csfdroid.widget.CsfdRatingBar;
import cz.csfd.csfdroid.widget.CsfdRatingBar.C2310a;
import java.util.ArrayList;

/* compiled from: CommentDialog */
public class C2322b extends C0946b implements C1963a {
    boolean f5685b = false;
    private CsfdApplication f5686c;
    private C2366h f5687d;
    private boolean f5688e;
    private AlertDialog f5689f;
    private C2058f f5690g;
    private C2550a f5691h;
    private C2516a f5692i;
    private Handler f5693j;
    private C2319a f5694k;
    private C2320b f5695l;
    private MovieInfo f5696m;
    private boolean f5697n = false;
    private int f5698o;
    private C2321c f5699p;

    /* compiled from: CommentDialog */
    class C23081 implements OnClickListener {
        final /* synthetic */ C2322b f5664a;

        C23081(C2322b c2322b) {
            this.f5664a = c2322b;
        }

        public void onClick(View view) {
            this.f5664a.m8418h();
        }
    }

    /* compiled from: CommentDialog */
    class C23113 implements C2310a {
        final /* synthetic */ C2322b f5667a;

        C23113(C2322b c2322b) {
            this.f5667a = c2322b;
        }

        public void mo3562a(RatingBar ratingBar, float f) {
            this.f5667a.f5698o = 0;
            ratingBar.setRating(0.0f);
        }
    }

    /* compiled from: CommentDialog */
    class C23146 implements OnCancelListener {
        final /* synthetic */ C2322b f5674a;

        C23146(C2322b c2322b) {
            this.f5674a = c2322b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            Toast.makeText(this.f5674a.f5686c, R.string.comment_save_canceled, 0).show();
        }
    }

    /* compiled from: CommentDialog */
    class C23157 implements OnCancelListener {
        final /* synthetic */ C2322b f5675a;

        C23157(C2322b c2322b) {
            this.f5675a = c2322b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f5675a.f5685b) {
                this.f5675a.f5687d.mo3570a();
            }
        }
    }

    /* compiled from: CommentDialog */
    private static class C2319a implements C2318h {
        C2322b f5682a;

        public C2319a(C2322b c2322b) {
            this.f5682a = c2322b;
        }

        public void mo3563b() {
            this.f5682a.f5685b = true;
            this.f5682a.m8406b((int) R.string.comment_sending);
        }

        public void m8388a(MovieInfo movieInfo) {
            this.f5682a.f5685b = false;
            this.f5682a.mo3565b();
            this.f5682a.m8396a((int) R.string.comment_save_success, 0);
            if (movieInfo.m6909S() != null) {
                if (!(this.f5682a.f5696m.m6909S().equals(movieInfo.m6909S()) && this.f5682a.f5696m.m6906P() == movieInfo.m6906P())) {
                    m8386c();
                }
                if (movieInfo.m6909S().length() > 0 && this.f5682a.f5696m.m6909S().length() == 0) {
                    this.f5682a.f5696m.m6971k(this.f5682a.f5696m.ah() + 1);
                }
                this.f5682a.f5696m.m6977l(movieInfo.m6909S());
            } else {
                if (this.f5682a.f5696m.m6909S().length() > 0) {
                    this.f5682a.f5696m.m6971k(this.f5682a.f5696m.ah() - 1);
                    m8386c();
                }
                this.f5682a.f5696m.m6977l("");
            }
            this.f5682a.f5696m.m6961i(movieInfo.m6906P());
            this.f5682a.f5696m.m6940d(movieInfo.m6908R());
            this.f5682a.m8427d();
            this.f5682a.getDialog().dismiss();
        }

        private void m8386c() {
            this.f5682a.f5696m.m6945e(false);
            this.f5682a.f5696m.m6987o(new ArrayList());
        }

        public void mo3322a() {
            this.f5682a.f5685b = false;
            this.f5682a.m8396a((int) R.string.comment_save_canceled, 0);
        }

        public void mo3323a(Exception exception) {
            this.f5682a.f5685b = false;
            this.f5682a.mo3565b();
            this.f5682a.m8426c();
            this.f5682a.m8411c((int) R.string.comment_save_failed);
        }
    }

    /* compiled from: CommentDialog */
    public interface C2320b {
        void mo3567a();
    }

    /* compiled from: CommentDialog */
    public static class C2321c extends Fragment {
        C2319a f5683a;
        C2320b f5684b;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }
    }

    public static void m8399a(FragmentManager fragmentManager, Uri uri, C2320b c2320b) {
        if (fragmentManager.findFragmentByTag("comment_dialog") == null) {
            C2322b c2322b = new C2322b();
            Bundle bundle = new Bundle();
            bundle.putString("data", uri.toString());
            c2322b.setArguments(bundle);
            c2322b.setRetainInstance(true);
            c2322b.m8424a(c2320b);
            c2322b.show(fragmentManager, "comment_dialog");
        }
    }

    public void m8424a(C2320b c2320b) {
        this.f5695l = c2320b;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        return onCreateDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973834);
        this.f5686c = C1998s.m6365a(getActivity());
        this.f5687d = this.f5686c.m6219g().mo3453c();
        this.f5693j = new Handler();
        if (this.f5686c.m6229q().m6250a()) {
            try {
                this.f5696m = m8394a(this.f5687d.mo3569a(Uri.parse(getArguments().getString("data"))));
            } catch (Exception e) {
                C1998s.m6371a(getClass(), e);
                m8411c((int) R.string.error_bad_url);
            }
            if (this.f5696m == null) {
                dismiss();
                return;
            }
            this.f5697n = this.f5686c.m6229q().m6251a(Acl.FILM_COMMENT);
            m8419i();
            if (bundle != null) {
                this.f5685b = bundle.getBoolean("sending_in_progress");
            }
            m8416f();
            m8417g();
            return;
        }
        dismiss();
    }

    private void m8416f() {
        this.f5699p = (C2321c) getFragmentManager().findFragmentByTag("comment_dialog_retain_fragment");
        if (this.f5699p != null) {
            this.f5694k = this.f5699p.f5683a;
            this.f5695l = this.f5699p.f5684b;
            if (this.f5694k == null) {
                this.f5694k = new C2319a(this);
                this.f5699p.f5683a = this.f5694k;
                return;
            }
            this.f5694k.f5682a = this;
            return;
        }
        this.f5699p = new C2321c();
        getFragmentManager().beginTransaction().add(this.f5699p, "comment_dialog_retain_fragment").commit();
        this.f5694k = new C2319a(this);
        this.f5699p.f5683a = this.f5694k;
        this.f5699p.f5684b = this.f5695l;
    }

    private void m8417g() {
        this.f5690g = (C2058f) getFragmentManager().findFragmentByTag("comment_dialog_progress");
        m8422n();
    }

    protected C0945a mo3564a(C0945a c0945a) {
        c0945a.m4157a((int) R.string.rating_title);
        c0945a.m4158a((int) R.string.comment_save, new C23081(this));
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.comment_dialog, null);
        m8400a(inflate);
        c0945a.m4159a(inflate);
        return c0945a;
    }

    public void onStart() {
        super.onStart();
        this.f5686c.m6233u().setScreenName(m8428e());
        this.f5686c.m6233u().send(new ScreenViewBuilder().build());
    }

    public void onResume() {
        super.onResume();
        this.f5692i = new C2516a(this);
        getActivity().registerReceiver(this.f5692i, this.f5692i.m9312a());
    }

    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(this.f5692i);
        this.f5692i = null;
    }

    public void onDestroy() {
        super.onDestroy();
        m8426c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("sending_in_progress", this.f5685b);
    }

    private MovieInfo m8394a(int i) {
        try {
            return C1992n.m6350a(i, getActivity());
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            m8411c((int) R.string.error);
            dismiss();
            return null;
        }
    }

    private void m8400a(View view) {
        EditText editText = (EditText) view.findViewById(R.id.comment);
        if (this.f5697n) {
            editText.setText(Html.fromHtml(this.f5696m.m6909S()));
        } else {
            editText.setVisibility(8);
        }
        final ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.rating_garbage);
        if (this.f5696m.m6906P() == 0) {
            m8401a(toggleButton, true);
        }
        final CsfdRatingBar csfdRatingBar = (CsfdRatingBar) view.findViewById(R.id.rating_bar);
        if (!this.f5696m.m6908R()) {
            this.f5698o = this.f5696m.m6906P() / 20;
        }
        csfdRatingBar.setRating((float) this.f5698o);
        csfdRatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(this) {
            final /* synthetic */ C2322b f5666b;

            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                if (toggleButton.isChecked()) {
                    this.f5666b.m8401a(toggleButton, false);
                }
                this.f5666b.f5698o = (int) f;
            }
        });
        csfdRatingBar.setOnRatingBarNoChangeListener(new C23113(this));
        toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ C2322b f5670c;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    csfdRatingBar.setRating(0.0f);
                    this.f5670c.m8401a(toggleButton, true);
                    return;
                }
                this.f5670c.m8401a(toggleButton, false);
            }
        });
    }

    private void m8418h() {
        int i;
        View view = getView();
        ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.rating_garbage);
        EditText editText = (EditText) view.findViewById(R.id.comment);
        CsfdRatingBar csfdRatingBar = (CsfdRatingBar) view.findViewById(R.id.rating_bar);
        if (toggleButton.isChecked()) {
            i = 0;
        } else {
            i = ((int) csfdRatingBar.getRating()) * 20;
            if (i == 0) {
                i = -1;
            }
        }
        m8397a(i, editText.getText().toString().trim());
    }

    private void m8401a(ToggleButton toggleButton, boolean z) {
        if (z) {
            toggleButton.setTextColor(getResources().getColor(R.color.comment_dialog_garbage_selected_color));
        } else {
            toggleButton.setTextColor(getResources().getColor(R.color.comment_dialog_garbage_notselected_color));
        }
        toggleButton.setChecked(z);
    }

    private void m8419i() {
        this.f5688e = this.f5686c.m6225m().mo3348a(getActivity());
    }

    private void m8397a(final int i, final String str) {
        if (this.f5688e) {
            m8407b(i, str);
            return;
        }
        m8398a(new OnDismissListener(this) {
            final /* synthetic */ C2322b f5673c;

            public void onDismiss(DialogInterface dialogInterface) {
                if (this.f5673c.f5688e) {
                    this.f5673c.m8407b(i, str);
                }
            }
        }, new C23146(this));
        m8420j();
    }

    private void m8407b(int i, String str) {
        boolean z = true;
        MovieInfo movieInfo = new MovieInfo(this.f5696m.m6705g());
        movieInfo.m6961i(this.f5696m.m6906P());
        movieInfo.m6977l(this.f5696m.m6909S());
        movieInfo.m6940d(this.f5696m.m6908R());
        boolean z2 = (i == -1 && this.f5696m.m6908R()) ? false : true;
        if (z2) {
            movieInfo.m6961i(i);
        }
        if (!this.f5697n || TextUtils.equals(movieInfo.m6909S(), str)) {
            z = false;
        }
        if (z) {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            movieInfo.m6977l(str);
        }
        this.f5686c.m6233u().send(new EventBuilder().setCategory(m8428e()).setAction("comment_sent").setLabel("rating: " + z2 + ", comment: " + z).setValue(0).build());
        this.f5687d.mo3583a(movieInfo, this.f5694k, this.f5686c.m6220h(), z2, z);
    }

    public void mo3330k() {
        this.f5688e = true;
        m8421m();
    }

    public void mo3331l() {
        this.f5688e = false;
    }

    private void m8398a(OnDismissListener onDismissListener, OnCancelListener onCancelListener) {
        if (this.f5691h == null || this.f5691h.m9457a()) {
            this.f5691h = C1984g.m6337a(getActivity());
        }
        this.f5691h.setOnDismissListener(onDismissListener);
        this.f5691h.setOnCancelListener(onCancelListener);
    }

    private void m8420j() {
        this.f5691h.show();
    }

    private void m8421m() {
        if (this.f5691h != null) {
            this.f5691h.dismiss();
            this.f5691h = null;
        }
    }

    private void m8406b(int i) {
        if (isAdded()) {
            this.f5690g = C2058f.m7220a(getFragmentManager(), "comment_dialog_progress", i, true);
            m8422n();
        }
    }

    public void mo3565b() {
        if (this.f5690g != null) {
            this.f5690g.dismiss();
            this.f5690g = null;
        }
    }

    private void m8422n() {
        if (this.f5690g != null) {
            this.f5690g.m7221a(new C23157(this));
        }
    }

    private void m8411c(final int i) {
        if (isAdded()) {
            final Activity activity = getActivity();
            this.f5693j.post(new Runnable(this) {
                final /* synthetic */ C2322b f5678c;

                public void run() {
                    this.f5678c.f5689f = C1984g.m6336a(activity, i);
                    this.f5678c.f5689f.setCanceledOnTouchOutside(true);
                    this.f5678c.f5689f.show();
                }
            });
        }
    }

    public void m8426c() {
        if (this.f5689f != null) {
            this.f5689f.dismiss();
            this.f5689f = null;
        }
    }

    public void m8427d() {
        if (this.f5695l != null) {
            this.f5695l.mo3567a();
        }
    }

    private void m8396a(final int i, final int i2) {
        this.f5693j.post(new Runnable(this) {
            final /* synthetic */ C2322b f5681c;

            public void run() {
                Toast.makeText(this.f5681c.f5686c, i, i2).show();
            }
        });
    }

    public String m8428e() {
        return "/comment";
    }
}
