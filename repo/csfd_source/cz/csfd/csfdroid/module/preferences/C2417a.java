package cz.csfd.csfdroid.module.preferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.C1810h;
import cz.csfd.csfdroid.C1974c;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Chart;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChartSortFragment */
public class C2417a extends C1974c {
    private C2057e f6020a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6020a = m6320d().m6292m().m6226n();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DragSortListView dragSortListView = (DragSortListView) layoutInflater.inflate(R.layout.fragment_preferences_chart, viewGroup, false);
        final ListAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.list_item_preference_handle, R.id.text, this.f6020a.m7215u());
        dragSortListView.setAdapter(arrayAdapter);
        dragSortListView.setDropListener(new C1810h(this) {
            final /* synthetic */ C2417a f6019b;

            public void a_(int i, int i2) {
                if (i != i2) {
                    Chart chart = (Chart) arrayAdapter.getItem(i);
                    arrayAdapter.remove(chart);
                    arrayAdapter.insert(chart, i2);
                    List arrayList = new ArrayList();
                    for (int i3 = 0; i3 < arrayAdapter.getCount(); i3++) {
                        arrayList.add(arrayAdapter.getItem(i3));
                    }
                    this.f6019b.f6020a.m7192b(arrayList);
                }
            }
        });
        return dragSortListView;
    }

    public String mo3436p() {
        return "/preferences/chart_sort";
    }
}
