package cz.csfd.csfdroid.module.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.widget.SideNavigationRow;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class DrawerFragment extends Fragment {
    private C2156a f5534a;
    private boolean f5535b;
    private int f5536c;
    private List<View> f5537d;
    private C2254b f5538e;

    public interface C2156a {
        void mo3468a(C2254b c2254b);
    }

    class C22531 implements OnClickListener {
        final /* synthetic */ DrawerFragment f5514a;

        C22531(DrawerFragment drawerFragment) {
            this.f5514a = drawerFragment;
        }

        public void onClick(View view) {
            if ((this.f5514a.f5538e == null || this.f5514a.f5538e.m8157a() != view.getId()) && this.f5514a.f5534a != null) {
                this.f5514a.f5534a.mo3468a(C2254b.m8156a(view.getId()));
            }
        }
    }

    public enum C2254b {
        HOMESCREEN(R.id.side_menu_homescreen),
        VIDEOS(R.id.side_menu_videos),
        CINEMAS(R.id.side_menu_cinemas),
        BLURAY(R.id.side_menu_bluray),
        DVD(R.id.side_menu_dvd),
        CHARTS(R.id.side_menu_charts),
        FAVORITES(R.id.side_menu_favorites),
        WATCHLIST(R.id.side_menu_watchlist),
        TV_TIPS(R.id.side_menu_tvtips),
        TV_SCHEDULE(R.id.side_menu_tvschedule),
        MESSAGES(R.id.side_menu_messages),
        ACCOUNT(R.id.side_menu_account),
        PREFERENCES(R.id.side_menu_preferences),
        ABOUT(R.id.side_menu_about),
        LOGIN(R.id.side_menu_login),
        LOGOUT(R.id.side_menu_logout);
        
        private static SparseArray<C2254b> f5531r;
        private int f5533q;

        static {
            EnumSet allOf = EnumSet.allOf(C2254b.class);
            f5531r = new SparseArray(allOf.size());
            Iterator it = allOf.iterator();
            while (it.hasNext()) {
                C2254b c2254b = (C2254b) it.next();
                f5531r.put(c2254b.m8157a(), c2254b);
            }
        }

        private C2254b(int i) {
            this.f5533q = i;
        }

        public int m8157a() {
            return this.f5533q;
        }

        public static C2254b m8156a(int i) {
            return (C2254b) f5531r.get(i);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C2156a) {
            this.f5534a = (C2156a) activity;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f5534a = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5537d = new ArrayList();
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_drawer, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        OnClickListener c22531 = new C22531(this);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof SideNavigationRow) {
                childAt.setOnClickListener(c22531);
                this.f5537d.add(childAt);
            }
        }
        m8159a(view);
        if (this.f5538e != null) {
            m8163a(this.f5538e);
        }
    }

    public void m8163a(C2254b c2254b) {
        for (View view : this.f5537d) {
            view.setSelected(view.getId() == c2254b.m8157a());
        }
        this.f5538e = c2254b;
    }

    public C2254b m8161a() {
        return this.f5538e;
    }

    public void m8164a(boolean z) {
        this.f5535b = z;
        if (getView() != null) {
            m8159a(getView());
        }
    }

    public void m8162a(int i) {
        this.f5536c = i;
        if (getView() != null) {
            m8159a(getView());
        }
    }

    private void m8159a(View view) {
        int i = 0;
        view.findViewById(R.id.side_menu_login).setVisibility(this.f5535b ? 8 : 0);
        View findViewById = view.findViewById(R.id.side_menu_logout);
        if (!this.f5535b) {
            i = 8;
        }
        findViewById.setVisibility(i);
        ((SideNavigationRow) view.findViewById(R.id.side_menu_messages)).setCount(this.f5536c);
    }
}
