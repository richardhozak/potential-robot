package cz.csfd.csfdroid.p061d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.p042c.p049b.ae;

/* compiled from: CircleTransformation */
public class C1978a implements ae {
    public Bitmap mo3346a(Bitmap bitmap) {
        int height;
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        if (bitmap.getHeight() > bitmap.getWidth()) {
            height = (bitmap.getHeight() - min) / 3;
        } else {
            height = (bitmap.getHeight() - min) / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, width, height, min, min);
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    public String mo3347a() {
        return "circle";
    }
}
