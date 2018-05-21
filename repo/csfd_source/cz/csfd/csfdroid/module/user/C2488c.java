package cz.csfd.csfdroid.module.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.p042c.p049b.C1187t;
import com.p042c.p049b.C1187t.C1183d;
import com.p042c.p049b.ac;
import cz.csfd.csfdroid.C1999d;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2094q;
import cz.csfd.csfdroid.list.p063a.C2099g;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2102j;
import cz.csfd.csfdroid.list.p063a.C2116x;
import cz.csfd.csfdroid.list.p063a.C2117y;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.creator.C2234f;
import cz.csfd.csfdroid.module.messages.MessagesThreadActivity;
import cz.csfd.csfdroid.module.movie.C2366h;
import cz.csfd.csfdroid.module.user.C2489d.C2487c;
import cz.csfd.csfdroid.p061d.C1978a;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserDetailFragment */
public class C2488c extends C1999d implements C2487c {
    private CsfdApplication f6237a;
    private C2489d f6238b;
    private C2366h f6239c;
    private C2234f f6240d;
    private User f6241e;
    private View f6242f;
    private boolean f6243g = false;
    private boolean f6244h = false;
    private Exception f6245i;
    private LoadingView f6246j;
    private OnClickListener f6247k;

    /* compiled from: UserDetailFragment */
    class C24791 implements OnClickListener {
        final /* synthetic */ C2488c f6224a;

        C24791(C2488c c2488c) {
            this.f6224a = c2488c;
        }

        public void onClick(View view) {
            this.f6224a.m9126h();
            this.f6224a.f6246j.setOnTryAgainListener(null);
        }
    }

    /* compiled from: UserDetailFragment */
    class C24802 implements Runnable {
        final /* synthetic */ C2488c f6225a;

        C24802(C2488c c2488c) {
            this.f6225a = c2488c;
        }

        public void run() {
            this.f6225a.m9127i();
        }
    }

    /* compiled from: UserDetailFragment */
    class C24824 implements OnClickListener {
        final /* synthetic */ C2488c f6228a;

        C24824(C2488c c2488c) {
            this.f6228a = c2488c;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f6228a.getActivity(), MessagesThreadActivity.class);
            intent.putExtra("user_id", this.f6228a.f6241e.m6705g());
            intent.putExtra("user_nick", this.f6228a.f6241e.m6811b());
            this.f6228a.startActivity(intent);
        }
    }

    /* compiled from: UserDetailFragment */
    class C24835 implements C1945a<Boolean> {
        final /* synthetic */ C2488c f6229a;

        C24835(C2488c c2488c) {
            this.f6229a = c2488c;
        }

        public void m9105a(Boolean bool) {
        }

        public void mo3323a(Exception exception) {
        }

        public void mo3322a() {
        }
    }

    /* compiled from: UserDetailFragment */
    class C24846 implements C1945a<Boolean> {
        final /* synthetic */ C2488c f6230a;

        C24846(C2488c c2488c) {
            this.f6230a = c2488c;
        }

        public void m9109a(Boolean bool) {
        }

        public void mo3323a(Exception exception) {
        }

        public void mo3322a() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f6237a = m6380c().m6292m();
        this.f6238b = this.f6237a.m6219g().mo3459i();
        this.f6239c = this.f6237a.m6219g().mo3453c();
        this.f6240d = this.f6237a.m6219g().mo3454d();
        int i = getArguments().getInt("user_id");
        if (i == 0) {
            i = this.f6238b.mo3646a(Uri.parse(getArguments().getString("_data")));
        }
        this.f6241e = new User(i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6246j = (LoadingView) view.findViewById(R.id.loading);
        this.f6247k = new C24791(this);
        if (this.f6243g || this.f6244h) {
            this.f6246j.setVisibility(0);
        }
        if (this.f6244h) {
            C1988j.m6341a(getActivity(), this.f6246j, this.f6247k, this.f6245i);
        }
        AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.USER, null, mo3436p());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f6243g && !this.f6244h) {
            if (this.f6241e.m6822f()) {
                m9129k();
            } else {
                m9126h();
            }
        }
    }

    private void m9126h() {
        m6380c().m6277a(m6380c(), new C24802(this));
    }

    private void m9127i() {
        this.f6238b.mo3657a(this.f6241e, (C2487c) this, this.f6237a.m6220h());
    }

    public void mo3417g() {
        this.f6243g = true;
        this.f6246j.setVisibility(0);
        this.f6246j.m9451e();
        this.f6246j.m9448b();
    }

    public void m9135a(User user) {
        this.f6243g = false;
        if (user.m6822f()) {
            this.f6244h = false;
            this.f6241e = user;
            if (getActivity() != null) {
                m9121b(this.f6241e);
                m9128j();
                return;
            }
            return;
        }
        this.f6244h = true;
        this.f6245i = new NullPointerException("Result is null.");
        C1988j.m6341a(getActivity(), this.f6246j, this.f6247k, this.f6245i);
    }

    private void m9128j() {
        if (this.f6246j.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f6246j.startAnimation(b);
            }
            this.f6246j.setVisibility(8);
            if (getView() != null) {
                b = m6379b(17432576);
                if (b != null) {
                    getListView().startAnimation(b);
                } else {
                    getListView().setVisibility(0);
                }
            }
        }
    }

    private void m9129k() {
        setListAdapter(null);
        m9121b(this.f6241e);
    }

    private void m9121b(User user) {
        m6377a(C2146b.USER, null);
        this.f6242f = m9130l();
        getListView().addHeaderView(this.f6242f, null, false);
        C2488c.m9117a(this.f6242f, this.f6241e);
        ListAdapter c2086a = new C2086a(getActivity(), m9116a(user.m6825j()));
        if (c2086a.getCount() == 0) {
            c2086a.m7313a(new C2102j());
        }
        setListAdapter(c2086a);
    }

    private List<C2083a> m9116a(List<Section> list) {
        List<C2083a> arrayList = new ArrayList();
        for (Section section : list) {
            C2101i c2101i = new C2101i(section.m7078c(), "(" + section.m7077b() + ")");
            c2101i.m7305a(section);
            c2101i.m7395a(true);
            arrayList.add(c2101i);
            for (Object next : section.m7074a()) {
                if (next instanceof MovieInfo) {
                    arrayList.add(new C2094q((MovieInfo) next, 0));
                } else if (next instanceof MovieCreator) {
                    arrayList.add(new C2099g((MovieCreator) next, false));
                } else if (next instanceof User) {
                    arrayList.add(new C2116x((User) next));
                } else if (next instanceof C2028e) {
                    arrayList.add(new C2117y((C2028e) next));
                }
            }
        }
        return arrayList;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2101i) {
            m9118a((C2101i) itemAtPosition);
        } else if (itemAtPosition instanceof C2094q) {
            this.f6239c.mo3575a(((C2094q) itemAtPosition).m7332i(), getActivity());
        } else if (itemAtPosition instanceof C2099g) {
            this.f6240d.mo3516a(((C2099g) itemAtPosition).m7379c(), getActivity());
        } else if (itemAtPosition instanceof C2116x) {
            this.f6238b.mo3653a(getActivity(), ((C2116x) itemAtPosition).m7463c());
        }
    }

    private void m9118a(C2101i c2101i) {
        Section section = (Section) c2101i.m7304a();
        if (section.m7077b() == 0) {
            Toast.makeText(getActivity(), getString(R.string.section_empty), 0).show();
        } else {
            this.f6238b.mo3654a(getActivity(), this.f6241e, section);
        }
    }

    private View m9130l() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.list_item_user_details_header, getListView(), false);
        if (this.f6237a.m6229q().m6253c() != this.f6241e.m6705g()) {
            final Button button = (Button) inflate.findViewById(R.id.button_favorite);
            Button button2 = (Button) inflate.findViewById(R.id.button_message);
            inflate.findViewById(R.id.user_buttons).setVisibility(0);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2488c f6227b;

                public void onClick(View view) {
                    if (this.f6227b.f6241e.m6828m()) {
                        this.f6227b.m9132n();
                        this.f6227b.f6241e.m6816c(false);
                        button.setText(R.string.menu_add_to_favorites);
                        return;
                    }
                    this.f6227b.m9131m();
                    this.f6227b.f6241e.m6816c(true);
                    button.setText(R.string.menu_remove_from_favorites);
                }
            });
            button2.setOnClickListener(new C24824(this));
        }
        return inflate;
    }

    private void m9131m() {
        this.f6238b.mo3651a(this.f6241e.m6705g(), new C24835(this), this.f6237a.m6220h());
    }

    private void m9132n() {
        this.f6238b.mo3659b(this.f6241e.m6705g(), new C24846(this), this.f6237a.m6220h());
    }

    static void m9117a(final View view, User user) {
        String str;
        final Context context = view.getContext();
        final ImageView imageView = (ImageView) view.findViewById(R.id.user_background);
        final View findViewById = view.findViewById(R.id.user_background_overlay);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.avatar);
        TextView textView = (TextView) view.findViewById(R.id.user_nick);
        TextView textView2 = (TextView) view.findViewById(R.id.user_additional_info);
        Button button = (Button) view.findViewById(R.id.button_favorite);
        if (TextUtils.isEmpty(user.m6817d())) {
            imageView2.setImageResource(R.drawable.avatar_circle);
        } else {
            C1187t a = C1187t.m5432a(context);
            a.m5446a(true);
            a.m5439a(user.m6817d()).m5476a(new C1978a()).m5477a(imageView2);
            ac c24867 = new ac() {
                public void mo3643a(final Bitmap bitmap, C1183d c1183d) {
                    try {
                        RenderScript create = RenderScript.create(context);
                        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
                        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                        create2.setRadius(20.0f);
                        create2.setInput(createFromBitmap);
                        create2.forEach(createTyped);
                        createTyped.copyTo(bitmap);
                        view.post(new Runnable(this) {
                            final /* synthetic */ C24867 f6232b;

                            public void run() {
                                LayoutParams layoutParams = imageView.getLayoutParams();
                                layoutParams.width = view.getWidth();
                                layoutParams.height = view.getHeight();
                                imageView.setLayoutParams(layoutParams);
                                findViewById.setLayoutParams(layoutParams);
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void mo3644a(Drawable drawable) {
                }

                public void mo3645b(Drawable drawable) {
                }
            };
            imageView.setTag(c24867);
            a.m5439a(user.m6817d()).m5479a(c24867);
        }
        textView.setText(user.m6811b());
        CharSequence charSequence = "";
        if (!TextUtils.isEmpty(user.m6814c())) {
            charSequence = charSequence + user.m6814c();
        }
        if (!TextUtils.isEmpty(user.m6819e())) {
            if (!TextUtils.isEmpty(charSequence)) {
                str = charSequence + " | ";
            }
            charSequence = str + user.m6819e();
        }
        if (user.m6826k() >= 0) {
            if (!TextUtils.isEmpty(charSequence)) {
                str = charSequence + " | ";
            }
            charSequence = str + view.getResources().getQuantityString(R.plurals.point_count, user.m6826k(), new Object[]{Integer.valueOf(user.m6826k())});
        }
        textView2.setText(charSequence);
        textView2.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        button.setText(user.m6828m() ? R.string.menu_remove_from_favorites : R.string.menu_add_to_favorites);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void mo3322a() {
        this.f6243g = false;
    }

    public void mo3323a(Exception exception) {
        this.f6243g = false;
        this.f6244h = true;
        this.f6245i = exception;
        C1988j.m6341a(getActivity(), this.f6246j, this.f6247k, this.f6245i);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_web:
                m9133o();
                m6378a("actionbar", "web", mo3436p(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m9133o() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f6238b.mo3649a(this.f6241e, null)));
        startActivity(intent);
    }

    public String mo3436p() {
        return "/user";
    }
}
