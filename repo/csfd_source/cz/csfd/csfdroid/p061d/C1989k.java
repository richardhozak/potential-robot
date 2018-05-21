package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: FontUtils */
public class C1989k {
    private static Typeface f4481a;
    private static Typeface f4482b;

    public static void m6343a(Context context, View view) {
        if (f4481a == null) {
            f4481a = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                C1989k.m6343a(context, ((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(f4481a);
        }
    }

    public static void m6344b(Context context, View view) {
        if (f4482b == null) {
            f4482b = Typeface.createFromAsset(context.getAssets(), "Roboto-Black.ttf");
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                C1989k.m6344b(context, ((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(f4482b);
        }
    }
}
