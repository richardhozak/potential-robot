package cz.csfd.csfdroid.module.preferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.C1810h;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.HomeList;
import cz.csfd.csfdroid.module.preferences.C2420b.C2419a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeSortFragment */
public class C2423c extends C1974c {
    private C2057e f6029a;
    private C2420b<HomeList> f6030b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6029a = m6320d().m6292m().m6226n();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final DragSortListView dragSortListView = (DragSortListView) layoutInflater.inflate(R.layout.fragment_preferences_home, viewGroup, false);
        List b = this.f6029a.m7188b();
        this.f6030b = new C2420b(getActivity(), R.layout.list_item_preference_handle_checkbox, R.id.text, b);
        this.f6030b.m8854a(new C2419a(this) {
            final /* synthetic */ C2423c f6026b;

            public void mo3612a(int i, boolean z) {
                ((HomeList) this.f6026b.f6030b.getItem(i)).m6801a(z);
                dragSortListView.setItemChecked(i, z);
            }
        });
        dragSortListView.setAdapter(this.f6030b);
        for (int i = 0; i < b.size(); i++) {
            dragSortListView.setItemChecked(i, ((HomeList) b.get(i)).m6803c());
        }
        dragSortListView.setDropListener(new C1810h(this) {
            final /* synthetic */ C2423c f6028b;

            public void a_(int i, int i2) {
                if (i != i2) {
                    HomeList homeList = (HomeList) this.f6028b.f6030b.getItem(i);
                    this.f6028b.f6030b.remove(homeList);
                    this.f6028b.f6030b.insert(homeList, i2);
                    dragSortListView.m5675a(i, i2);
                }
            }
        });
        return dragSortListView;
    }

    public void onPause() {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.f6030b.getCount(); i++) {
            arrayList.add(this.f6030b.getItem(i));
        }
        this.f6029a.m7186a(arrayList);
        super.onPause();
    }

    public String mo3436p() {
        return "/preferences/home_sort";
    }
}
