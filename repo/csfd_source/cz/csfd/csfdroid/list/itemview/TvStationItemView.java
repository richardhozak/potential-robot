package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2115w;

public class TvStationItemView extends RelativeLayout implements C2087b {
    private TextView f5104a;
    private ImageView f5105b;
    private CheckBox f5106c;
    private C1187t f5107d;

    public TvStationItemView(Context context) {
        this(context, null);
    }

    public TvStationItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5107d = ((CsfdApplication) context.getApplicationContext()).m6232t();
    }

    public void mo3428b() {
        this.f5104a = (TextView) findViewById(R.id.station_item_name);
        this.f5105b = (ImageView) findViewById(R.id.station_item_logo);
        this.f5106c = (CheckBox) findViewById(R.id.station_item_checkbox);
    }

    public void setObject(C2083a c2083a) {
        final TvStation c = ((C2115w) c2083a).m7460c();
        this.f5104a.setText(c.m7066b());
        this.f5107d.m5439a(c.m7068c()).m5474a((int) R.drawable.gallery_photo_blank).m5477a(this.f5105b);
        this.f5106c.setChecked(c.m7069d());
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TvStationItemView f5103b;

            public void onClick(View view) {
                boolean z;
                boolean z2 = true;
                boolean d = c.m7069d();
                CheckBox a = this.f5103b.f5106c;
                if (d) {
                    z = false;
                } else {
                    z = true;
                }
                a.setChecked(z);
                TvStation tvStation = c;
                if (d) {
                    z2 = false;
                }
                tvStation.m7065a(z2);
            }
        });
    }
}
