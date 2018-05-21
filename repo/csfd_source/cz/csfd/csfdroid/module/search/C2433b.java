package cz.csfd.csfdroid.module.search;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.C0654b;
import android.support.v7.widget.SearchView.C0655c;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.actions.SearchIntents;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.module.ads.AdBottomView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.search.C2434c.C2432a;
import cz.csfd.csfdroid.p060c.C1970b;
import cz.csfd.csfdroid.p060c.C1970b.C1969a;
import cz.csfd.csfdroid.p060c.C1972c;
import cz.csfd.csfdroid.widget.slidingtabs.SlidingTabLayout;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: SearchFragment */
public class C2433b extends C1974c implements OnCancelListener, C0655c, C2432a {
    private C2434c f6045a;
    private boolean f6046b = false;
    private boolean f6047c = false;
    private Exception f6048d;
    private String f6049e;
    private ViewPager f6050f;
    private SlidingTabLayout f6051g;
    private C1970b f6052h;
    private C2437e f6053i;
    private C2426a f6054j;
    private C2438f f6055k;
    private Map<String, List<? extends BasicEntity>> f6056l;
    private OnClickListener f6057m;
    private SearchView f6058n;

    /* compiled from: SearchFragment */
    class C24271 implements C0654b {
        final /* synthetic */ C2433b f6038a;

        C24271(C2433b c2433b) {
            this.f6038a = c2433b;
        }

        public boolean mo3325a() {
            this.f6038a.getActivity().finish();
            return true;
        }
    }

    /* compiled from: SearchFragment */
    class C24282 implements OnClickListener {
        final /* synthetic */ C2433b f6039a;

        C24282(C2433b c2433b) {
            this.f6039a = c2433b;
        }

        public void onClick(View view) {
            this.f6039a.m8881c(this.f6039a.f6049e);
        }
    }

    /* compiled from: SearchFragment */
    class C24315 implements OnCancelListener {
        final /* synthetic */ C2433b f6044a;

        C24315(C2433b c2433b) {
            this.f6044a = c2433b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f6044a.m6320d().finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f6045a = m6320d().m6292m().m6219g().mo3452b();
        m8884j();
    }

    public void onStart() {
        super.onStart();
        this.f6058n = (SearchView) m6320d().m1367b().mo1406a().findViewById(R.id.actionbar_searchview);
        this.f6058n.setOnQueryTextListener(this);
        this.f6058n.m2666a(this.f6049e, false);
        this.f6058n.setOnCloseListener(new C24271(this));
        this.f6058n.setIconified(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6057m = new C24282(this);
        m8876a(view);
        final AdBottomView adBottomView = (AdBottomView) view.findViewById(R.id.ad_bottom);
        adBottomView.setBackgroundView(view.findViewById(R.id.ad_bottom_bg));
        adBottomView.m7621a(C2146b.SEARCH, null, mo3436p());
        this.f6052h.m6305a(new C1969a(this) {
            final /* synthetic */ C2433b f6041b;

            public void mo3507a(int i) {
                adBottomView.m7620a();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f6056l == null && !this.f6046b && !this.f6047c) {
            m8881c(this.f6049e);
        }
    }

    public void setTargetFragment(Fragment fragment, int i) {
        if (i == 1) {
            this.f6053i = (C2437e) fragment;
            if (this.f6047c) {
                this.f6053i.m8912a(this.f6057m, this.f6048d);
            }
        } else if (i == 2) {
            this.f6054j = (C2426a) fragment;
            if (this.f6047c) {
                this.f6054j.m8867a(this.f6057m, this.f6048d);
            }
        } else if (i == 3) {
            this.f6055k = (C2438f) fragment;
            if (this.f6047c) {
                this.f6055k.m8921a(this.f6057m, this.f6048d);
            }
        } else {
            super.setTargetFragment(fragment, i);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("searchInProgress", this.f6046b);
    }

    public void onDestroy() {
        super.onDestroy();
        m8883i();
    }

    public void onCancel(DialogInterface dialogInterface) {
        m8883i();
    }

    private void m8883i() {
        this.f6045a.mo3617a();
        m6320d().finish();
    }

    private void m8876a(View view) {
        this.f6050f = (ViewPager) view.findViewById(R.id.search_view_pager);
        this.f6051g = (SlidingTabLayout) view.findViewById(R.id.tabs);
        this.f6052h = new C1970b(getActivity(), this.f6050f, this.f6051g);
        Bundle bundle = new Bundle();
        this.f6052h.m6306b(new C1972c(getString(R.string.search_results_button_movies), C2437e.class, bundle, this));
        this.f6052h.m6306b(new C1972c(getString(R.string.search_results_button_creators), C2426a.class, bundle, this));
        this.f6052h.m6306b(new C1972c(getString(R.string.search_results_button_users), C2438f.class, bundle, this));
        this.f6050f.setAdapter(this.f6052h);
        this.f6050f.setOffscreenPageLimit(2);
        this.f6051g.setViewPager(this.f6050f);
    }

    private void m8884j() {
        Bundle arguments = getArguments();
        if ("android.intent.action.SEARCH".equals(arguments.getString("_action"))) {
            this.f6049e = arguments.getString(SearchIntents.EXTRA_QUERY);
        } else if (arguments.getString("_data") != null) {
            Uri parse = Uri.parse(arguments.getString("_data"));
            if (parse.getScheme().equals("csfdroid")) {
                this.f6049e = parse.getQuery().trim();
                return;
            }
            String trim = parse.getQuery().trim();
            if (trim.contains("q=")) {
                this.f6049e = TextUtils.htmlEncode(Uri.decode(trim.substring(trim.indexOf("q=") + 2).split("&")[0]).replaceAll("\\+", " "));
            }
        } else {
            this.f6049e = "";
        }
    }

    private void m8881c(final String str) {
        m6320d().m6280a(new Runnable(this) {
            final /* synthetic */ C2433b f6043b;

            public void run() {
                this.f6043b.m8882d(str);
            }
        }, null, new C24315(this));
    }

    private void m8882d(String str) {
        this.f6045a.mo3620a(str, this, m6320d().m6292m().m6220h());
    }

    public void mo3615h() {
        this.f6046b = true;
        if (this.f6053i != null) {
            this.f6053i.m8911a();
        }
        if (this.f6054j != null) {
            this.f6054j.m8866a();
        }
        if (this.f6055k != null) {
            this.f6055k.m8920a();
        }
    }

    public void mo3322a() {
        this.f6046b = false;
    }

    public void mo3323a(Exception exception) {
        this.f6046b = false;
        this.f6047c = true;
        this.f6048d = exception;
        if (this.f6053i != null) {
            this.f6053i.m8912a(this.f6057m, this.f6048d);
        }
        if (this.f6054j != null) {
            this.f6054j.m8867a(this.f6057m, this.f6048d);
        }
        if (this.f6055k != null) {
            this.f6055k.m8921a(this.f6057m, this.f6048d);
        }
    }

    public void m8890a(Map<String, List<? extends BasicEntity>> map) {
        this.f6046b = false;
        this.f6056l = map;
        if (map == null) {
            this.f6047c = true;
            this.f6048d = new NullPointerException("Result is null.");
            if (this.f6053i != null) {
                this.f6053i.m8912a(this.f6057m, this.f6048d);
            }
            if (this.f6054j != null) {
                this.f6054j.m8867a(this.f6057m, this.f6048d);
            }
            if (this.f6055k != null) {
                this.f6055k.m8921a(this.f6057m, this.f6048d);
            }
        } else {
            this.f6047c = false;
            m8885k();
        }
        m8886l();
    }

    private void m8885k() {
        if (this.f6056l != null) {
            List list = (List) this.f6056l.get("films");
            if (list != null) {
                this.f6053i.m8913a(list);
            } else {
                this.f6053i.m8913a(Collections.EMPTY_LIST);
            }
            this.f6053i.mo3417g();
            List list2 = (List) this.f6056l.get("creators");
            if (list2 != null) {
                this.f6054j.m8868a(list2);
            } else {
                this.f6054j.m8868a(Collections.EMPTY_LIST);
            }
            this.f6054j.mo3417g();
            List list3 = (List) this.f6056l.get("users");
            if (this.f6055k != null) {
                if (list3 != null) {
                    this.f6055k.m8922a(list3);
                } else {
                    this.f6055k.m8922a(Collections.EMPTY_LIST);
                }
                this.f6055k.mo3417g();
            }
            m8878a(list, list2, list3);
        }
    }

    private void m8878a(List<? extends BasicEntity> list, List<? extends BasicEntity> list2, List<? extends BasicEntity> list3) {
        if (list.size() != 0 || list2.size() <= 0) {
            if (list2.size() != 0 || list.size() <= 0) {
                if (list.size() != 0 || list2.size() != 0 || list3.size() <= 0) {
                    return;
                }
                if (list3.size() > 1) {
                    this.f6050f.setCurrentItem(2);
                } else {
                    m6320d().m6292m().m6219g().mo3459i().mo3653a(getActivity(), (User) list3.get(0));
                }
            } else if (list.size() > 1) {
                this.f6050f.setCurrentItem(0);
            } else {
                m6320d().m6292m().m6219g().mo3453c().mo3575a((MovieInfo) list.get(0), getActivity());
            }
        } else if (list2.size() > 1) {
            this.f6050f.setCurrentItem(1);
        } else {
            m6320d().m6292m().m6219g().mo3454d().mo3516a((MovieCreator) list2.get(0), getActivity());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public boolean mo3326a(String str) {
        this.f6049e = str;
        m8882d(str);
        m8886l();
        return true;
    }

    public boolean mo3327b(String str) {
        return false;
    }

    private void m8886l() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public String mo3436p() {
        return "/search";
    }
}
