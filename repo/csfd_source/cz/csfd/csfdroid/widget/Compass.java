package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;
import cz.csfd.csfdroid.R;

public class Compass extends ImageView {
    Paint f6355a = new Paint();
    int f6356b = 0;

    public Compass(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6355a.setColor(-1);
        this.f6355a.setStrokeWidth(2.0f);
        this.f6355a.setStyle(Style.STROKE);
        setImageResource(R.drawable.compass_arrow);
    }

    public void onDraw(Canvas canvas) {
        int height = getHeight();
        canvas.rotate((float) this.f6356b, (float) (getWidth() / 2), (float) (height / 2));
        super.onDraw(canvas);
    }

    public void setDirection(int i) {
        this.f6356b = i;
        invalidate();
    }

    public int getDirection() {
        return this.f6356b;
    }
}
