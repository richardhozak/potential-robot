package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2096d;
import cz.csfd.csfdroid.widget.Compass;

public class CinemaItemView extends RelativeLayout implements C2087b {
    private TextView f4994a;
    private TextView f4995b;
    private TextView f4996c;
    private Compass f4997d;
    private ImageView f4998e;
    private LinearLayout f4999f;
    private ImageView f5000g;
    private ImageView f5001h;
    private TextView f5002i;
    private final SensorManager f5003j;
    private final Sensor f5004k;
    private SensorEventListener f5005l;

    public CinemaItemView(Context context) {
        this(context, null);
    }

    public CinemaItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5003j = (SensorManager) context.getSystemService("sensor");
        this.f5004k = this.f5003j.getDefaultSensor(3);
    }

    public void mo3428b() {
        this.f4994a = (TextView) findViewById(R.id.cinema_item_name);
        this.f4995b = (TextView) findViewById(R.id.cinema_item_address);
        this.f4996c = (TextView) findViewById(R.id.cinema_item_distance);
        this.f4997d = (Compass) findViewById(R.id.cinema_item_bearing);
        this.f4998e = (ImageView) findViewById(R.id.cinema_item_favourite);
        this.f4999f = (LinearLayout) findViewById(R.id.cinema_item_bearing_distance);
        this.f5000g = (ImageView) findViewById(R.id.cinema_item_poster);
        this.f5001h = (ImageView) findViewById(R.id.cinema_item_shadow);
        this.f5002i = (TextView) findViewById(R.id.cinema_item_schedule);
    }

    public void setObject(C2083a c2083a) {
        final C2096d c2096d = (C2096d) c2083a;
        this.f4994a.setText(c2096d.m7354d());
        if (c2096d.m7355e() == null || (c2096d.m7361k() & 1) != 0) {
            this.f4995b.setVisibility(8);
        } else {
            this.f4995b.setText(c2096d.m7355e());
            this.f4995b.setVisibility(0);
        }
        if (c2096d.m7356f() != null) {
            this.f4996c.setText(c2096d.m7356f());
            this.f4996c.setVisibility(0);
            this.f4999f.setVisibility(0);
        } else {
            this.f4996c.setVisibility(8);
            this.f4999f.setVisibility(8);
        }
        if (this.f5005l != null) {
            this.f5003j.unregisterListener(this.f5005l);
        }
        if (c2096d.m7357g() == -1.0f || this.f5004k == null) {
            this.f4997d.setVisibility(8);
        } else {
            this.f5005l = new SensorEventListener(this) {
                final /* synthetic */ CinemaItemView f4993b;

                public void onSensorChanged(SensorEvent sensorEvent) {
                    int g = (int) (c2096d.m7357g() - sensorEvent.values[0]);
                    if (this.f4993b.f4997d.getDirection() != g) {
                        this.f4993b.f4997d.setDirection(g);
                    }
                    this.f4993b.f4997d.setVisibility(0);
                }

                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };
            this.f5003j.registerListener(this.f5005l, this.f5004k, 2);
        }
        int color = getResources().getColor(R.color.text_color_primary);
        int color2 = getResources().getColor(R.color.text_color_primary_transparent);
        if (c2096d.m7358h()) {
            this.f4994a.setTextColor(color);
        } else {
            this.f4994a.setTextColor(color2);
        }
        if ((c2096d.m7361k() & 1) == 0) {
            ImageView imageView = this.f4998e;
            if (c2096d.m7359i()) {
                color = 0;
            } else {
                color = 8;
            }
            imageView.setVisibility(color);
        } else {
            this.f4998e.setVisibility(8);
        }
        if (c2096d.m7353c().m6762n() != null) {
            C1187t.m5432a(getContext()).m5439a(c2096d.m7353c().m6762n()).m5477a(this.f5000g);
            this.f5000g.setVisibility(0);
            this.f5001h.setVisibility(0);
        } else {
            this.f5000g.setVisibility(8);
            this.f5001h.setVisibility(8);
        }
        if ((c2096d.m7361k() & 1) != 0) {
            this.f5002i.setText(c2096d.m7360j());
            this.f5002i.setVisibility(0);
            return;
        }
        this.f5002i.setVisibility(8);
    }

    protected void onDetachedFromWindow() {
        if (this.f5005l != null) {
            this.f5003j.unregisterListener(this.f5005l);
        }
        super.onDetachedFromWindow();
    }
}
