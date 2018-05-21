package cz.csfd.csfdroid.module.cinema;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_TimeRange;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2096d;
import cz.csfd.csfdroid.list.p063a.C2101i;
import cz.csfd.csfdroid.list.p063a.C2105m;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.cinema.C2197e.C2176c;
import cz.csfd.csfdroid.module.cinema.C2197e.C2178d;
import cz.csfd.csfdroid.p060c.C1973d;
import cz.csfd.csfdroid.p061d.C1988j;
import cz.csfd.csfdroid.widget.LoadingView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: AllCinemaListFragment */
public class C2182a extends C2181d implements C1973d {
    private C2197e f5266a;
    private CsfdApplication f5267b;
    private C2057e f5268c;
    private Map<String, List<Cinema>> f5269d;
    private boolean f5270e = false;
    private boolean f5271f = false;
    private Exception f5272g;
    private boolean f5273h = false;
    private boolean f5274i = false;
    private long f5275j;
    private LoadingView f5276k;
    private OnClickListener f5277l;
    private C2086a f5278m;
    private List<C2083a> f5279n;
    private C2105m f5280o;
    private ViewGroup f5281p;
    private AutoCompleteTextView f5282q;
    private C2206h f5283r;
    private String f5284s;
    private C2177a f5285t;
    private String f5286u;
    private C2179b f5287v;
    private int f5288w;
    private Enum_TimeRange f5289x;
    private boolean f5290y;

    /* compiled from: AllCinemaListFragment */
    class C21711 implements OnClickListener {
        final /* synthetic */ C2182a f5258a;

        C21711(C2182a c2182a) {
            this.f5258a = c2182a;
        }

        public void onClick(View view) {
            this.f5258a.m7797g();
            this.f5258a.f5276k.setOnTryAgainListener(null);
            if (this.f5258a.f5280o != null) {
                this.f5258a.f5280o.m7412a(1);
            }
        }
    }

    /* compiled from: AllCinemaListFragment */
    class C21722 implements OnItemClickListener {
        final /* synthetic */ C2182a f5259a;

        C21722(C2182a c2182a) {
            this.f5259a = c2182a;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f5259a.f5286u = this.f5259a.f5283r.m7916a(i);
            this.f5259a.m7797g();
            ((InputMethodManager) this.f5259a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f5259a.f5282q.getWindowToken(), 0);
        }
    }

    /* compiled from: AllCinemaListFragment */
    class C21733 implements OnEditorActionListener {
        final /* synthetic */ C2182a f5260a;

        C21733(C2182a c2182a) {
            this.f5260a = c2182a;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 6 && (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            this.f5260a.f5282q.dismissDropDown();
            this.f5260a.f5286u = this.f5260a.f5282q.getText().toString().trim();
            if (this.f5260a.f5286u.length() >= 2) {
                this.f5260a.m7797g();
                ((InputMethodManager) this.f5260a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            } else {
                Toast.makeText(this.f5260a.getActivity(), this.f5260a.getString(R.string.cinemas_filter_limit), 0).show();
            }
            return true;
        }
    }

    /* compiled from: AllCinemaListFragment */
    class C21744 implements Runnable {
        final /* synthetic */ C2182a f5261a;

        C21744(C2182a c2182a) {
            this.f5261a = c2182a;
        }

        public void run() {
            if (!TextUtils.isEmpty(this.f5261a.f5286u)) {
                this.f5261a.m7782a(this.f5261a.f5286u);
            }
        }
    }

    /* compiled from: AllCinemaListFragment */
    class C21755 implements OnCancelListener {
        final /* synthetic */ C2182a f5262a;

        C21755(C2182a c2182a) {
            this.f5262a = c2182a;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5262a.m6380c().finish();
        }
    }

    /* compiled from: AllCinemaListFragment */
    private class C2177a implements C2176c {
        final /* synthetic */ C2182a f5263a;

        private C2177a(C2182a c2182a) {
            this.f5263a = c2182a;
        }

        public void mo3487b() {
            this.f5263a.f5283r.m7918a();
        }

        public void m7767a(List<String> list) {
            if (this.f5263a.isAdded()) {
                m7763b(list);
                this.f5263a.f5283r.getFilter().filter(this.f5263a.f5282q.getText());
            }
        }

        private void m7763b(List<String> list) {
            this.f5263a.f5283r.m7919a((List) list);
        }

        public void mo3322a() {
        }

        public void mo3323a(Exception exception) {
        }
    }

    /* compiled from: AllCinemaListFragment */
    private class C2179b implements C2178d {
        final /* synthetic */ C2182a f5264a;

        private C2179b(C2182a c2182a) {
            this.f5264a = c2182a;
        }

        public void mo3488b() {
            this.f5264a.m7803j();
        }

        public void m7773a(Map<String, List<Cinema>> map) {
            if (this.f5264a.isAdded()) {
                this.f5264a.f5270e = false;
                if (map == null) {
                    this.f5264a.f5271f = true;
                    this.f5264a.f5272g = new NullPointerException("Result is null.");
                    C1988j.m6341a(this.f5264a.getActivity(), this.f5264a.f5276k, this.f5264a.f5277l, this.f5264a.f5272g);
                    return;
                }
                this.f5264a.f5271f = false;
                this.f5264a.f5273h = true;
                this.f5264a.f5269d = map;
                this.f5264a.m7783a(this.f5264a.f5269d);
                this.f5264a.m7806l();
                if (map.entrySet().size() > 0) {
                    this.f5264a.m7808m();
                } else {
                    this.f5264a.m7810n();
                }
            }
        }

        public void mo3322a() {
            this.f5264a.m7805k();
        }

        public void mo3323a(Exception exception) {
            this.f5264a.m7781a(exception);
        }
    }

    /* compiled from: AllCinemaListFragment */
    private class C2180c implements TextWatcher {
        final /* synthetic */ C2182a f5265a;

        private C2180c(C2182a c2182a) {
            this.f5265a = c2182a;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = 1;
            int i5 = (charSequence.length() < 2 || i >= 2) ? 0 : 1;
            String a = this.f5265a.f5283r.m7917a(charSequence.toString());
            if (this.f5265a.f5284s != null && a.startsWith(this.f5265a.f5284s)) {
                i4 = 0;
            }
            if (i5 != 0 && r1 != 0) {
                this.f5265a.f5284s = a.substring(0, 2);
                this.f5265a.f5266a.mo3500a(this.f5265a.f5284s, this.f5265a.f5285t, this.f5265a.f5267b.m6220h());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f5267b = m6380c().m6292m();
        this.f5268c = this.f5267b.m6226n();
        this.f5266a = this.f5267b.m6219g().mo3457g();
        this.f5288w = getArguments().getInt("movie_id");
        this.f5287v = new C2179b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_list_with_loading_location, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListAdapter() != null) {
            setListAdapter(null);
        }
        m6377a(C2146b.CINEMAS, null);
        if (this.f5278m != null) {
            setListAdapter(this.f5278m);
        }
        this.f5276k = (LoadingView) view.findViewById(R.id.loading);
        this.f5277l = new C21711(this);
        if (this.f5270e || this.f5271f) {
            this.f5276k.setVisibility(0);
        }
        if (this.f5271f) {
            C1988j.m6341a(getActivity(), this.f5276k, this.f5277l, this.f5272g);
        }
        this.f5281p = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.list_item_cinema_filter_header, (ViewGroup) view.findViewById(R.id.header), true);
        this.f5282q = (AutoCompleteTextView) this.f5281p.findViewById(R.id.cinema_filter);
        this.f5282q.setThreshold(2);
        this.f5282q.addTextChangedListener(new C2180c());
        this.f5283r = new C2206h(getActivity());
        this.f5282q.setAdapter(this.f5283r);
        this.f5282q.setOnItemClickListener(new C21722(this));
        this.f5282q.setOnEditorActionListener(new C21733(this));
        this.f5285t = new C2177a();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.f5273h) {
            return;
        }
        if (this.f5279n == null || this.f5279n.size() == 0) {
            m7810n();
        }
    }

    public void onResume() {
        super.onResume();
        long y = this.f5267b.m6226n().m7218y();
        if (!this.f5270e && this.f5273h && this.f5275j > 0 && this.f5275j != y) {
            m7797g();
        }
        this.f5275j = y;
    }

    public void mo3477h() {
        m6382e();
        if (this.f5274i) {
            if (this.f5290y != this.f5268c.m7211q()) {
                this.f5273h = false;
                m7797g();
            } else if (this.f5289x != this.f5268c.m7212r()) {
                this.f5273h = false;
                m7797g();
            }
            m6378a(mo3436p(), "selected", null, 0);
        } else {
            this.f5274i = true;
            m6378a(mo3436p(), "selected", "first_time", 0);
        }
        m7780a();
    }

    private void m7780a() {
        this.f5290y = this.f5268c.m7211q();
        this.f5289x = this.f5268c.m7212r();
    }

    private void m7797g() {
        if (getActivity() != null) {
            m6380c().m6280a(new C21744(this), null, new C21755(this));
        }
    }

    private void m7782a(String str) {
        this.f5266a.mo3499a(str, this.f5288w, this.f5268c.m7211q(), this.f5268c.m7212r(), this.f5287v, this.f5267b.m6220h(), getActivity().getContentResolver());
    }

    public void onDestroy() {
        super.onDestroy();
        m7801i();
    }

    private void m7801i() {
        this.f5266a.mo3504c();
        this.f5266a.mo3505d();
    }

    private void m7803j() {
        this.f5270e = true;
        if (getView() != null) {
            getListView().setVisibility(8);
            ((TextView) getView().findViewById(16908292)).setVisibility(8);
            this.f5276k.setVisibility(0);
            this.f5276k.m9451e();
            this.f5276k.m9448b();
        }
    }

    private void m7805k() {
        this.f5270e = false;
    }

    private void m7781a(Exception exception) {
        if (isAdded()) {
            this.f5270e = false;
            this.f5271f = true;
            this.f5272g = exception;
            C1988j.m6341a(getActivity(), this.f5276k, this.f5277l, this.f5272g);
            if (this.f5280o != null) {
                this.f5280o.m7412a(2);
            }
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object itemAtPosition = listView.getItemAtPosition(i);
        if (itemAtPosition instanceof C2096d) {
            this.f5266a.mo3496a(getActivity(), ((C2096d) itemAtPosition).m7353c(), Integer.valueOf(this.f5288w));
        }
    }

    private void m7806l() {
        if (this.f5276k.getVisibility() == 0) {
            Animation b = m6379b(17432577);
            if (b != null) {
                this.f5276k.startAnimation(b);
            }
            this.f5276k.setVisibility(8);
        }
    }

    private void m7808m() {
        if (getListView().getVisibility() == 8 && getView() != null) {
            Animation b = m6379b(17432576);
            if (b != null) {
                getListView().startAnimation(b);
            } else {
                getListView().setVisibility(0);
            }
        }
    }

    private void m7810n() {
        ((TextView) getView().findViewById(16908292)).setText(this.f5288w != 0 ? R.string.cinemas_movie_empty : R.string.cinemas_empty);
    }

    private void m7783a(Map<String, List<Cinema>> map) {
        if (this.f5278m == null || this.f5278m.getCount() == 0) {
            this.f5279n = new ArrayList();
            m7789b((Map) map);
            this.f5278m = new C2086a(getActivity(), this.f5279n);
            setListAdapter(this.f5278m);
            return;
        }
        this.f5279n.clear();
        m7789b((Map) map);
        this.f5278m.notifyDataSetChanged();
    }

    private void m7789b(Map<String, List<Cinema>> map) {
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            this.f5279n.add(new C2101i((String) entry.getKey()));
            m7775a(list, this.f5279n);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_cinemas_without_schedule:
                this.f5273h = false;
                m7780a();
                m7797g();
                return true;
            case R.id.menu_item_date_all:
            case R.id.menu_item_date_month:
            case R.id.menu_item_date_today:
            case R.id.menu_item_date_tomorrow:
            case R.id.menu_item_date_week:
            case R.id.menu_item_date_weekend:
                this.f5273h = false;
                m7780a();
                m7797g();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public String mo3436p() {
        return "/cinemas/list";
    }
}
