package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2100h;
import cz.csfd.csfdroid.module.creator.C2234f;
import cz.csfd.csfdroid.p061d.C1998s;

public class CreatorGridRowView extends LinearLayout implements C2087b {
    LayoutInflater f5025a;
    C2234f f5026b;

    public CreatorGridRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5025a = LayoutInflater.from(context);
        this.f5026b = C1998s.m6365a(context).m6219g().mo3454d();
    }

    public void mo3428b() {
    }

    public void setObject(C2083a c2083a) {
        C2100h c2100h = (C2100h) c2083a;
        int size = c2100h.m7391c().size();
        for (int i = 0; i < size; i++) {
            final MovieCreator movieCreator = (MovieCreator) c2100h.m7391c().get(i);
            View a = m7493a(movieCreator);
            a.setLayoutParams(new LayoutParams(-2, -2, 1.0f));
            addView(a);
            a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CreatorGridRowView f5024b;

                public void onClick(View view) {
                    this.f5024b.f5026b.mo3516a(movieCreator, this.f5024b.getContext());
                }
            });
            if (i < size - 1) {
                View view = new View(getContext());
                view.setLayoutParams(new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.list_divider_height), -1));
                view.setBackgroundColor(getResources().getColor(R.color.separator_background));
                addView(view);
            }
        }
    }

    private RelativeLayout m7493a(MovieCreator movieCreator) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f5025a.inflate(R.layout.list_item_creators_grid_item, null);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.creator_item_photo);
        ((TextView) relativeLayout.findViewById(R.id.creator_item_name)).setText(movieCreator.m6859c());
        int integer = getContext().getResources().getDisplayMetrics().widthPixels / getResources().getInteger(R.integer.creators_grid_row_size);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(integer, (int) (1.32f * ((float) integer))));
        if (movieCreator.m6867f().length() > 0) {
            C1187t.m5432a(getContext()).m5439a(movieCreator.m6867f()).m5477a(imageView);
        } else {
            C1187t.m5432a(getContext()).m5437a((int) R.drawable.poster_free).m5473a().m5482c().m5477a(imageView);
        }
        return relativeLayout;
    }
}
