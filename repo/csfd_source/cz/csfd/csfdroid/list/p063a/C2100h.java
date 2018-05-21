package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.CreatorItemView;
import java.util.List;

/* compiled from: CreatorsGridRow */
public class C2100h extends C2083a {
    private List<MovieCreator> f4924b;

    public C2100h(List<MovieCreator> list) {
        this.f4924b = list;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_creators_grid_row, viewGroup);
    }

    public List<MovieCreator> m7391c() {
        return this.f4924b;
    }

    public Class<?> mo3427b() {
        return CreatorItemView.class;
    }
}
