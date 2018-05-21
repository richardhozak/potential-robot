package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;
import cz.csfd.csfdroid.CsfdApplication;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Utils */
public class C1998s {

    /* compiled from: Utils */
    public static class C1997a {
        public int f4485a;
        public int f4486b;

        public int m6364a() {
            return this.f4485a < this.f4486b ? this.f4485a : this.f4486b;
        }
    }

    public static CsfdApplication m6365a(Context context) {
        return (CsfdApplication) context.getApplicationContext();
    }

    public static boolean m6373a() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean m6374b() {
        return VERSION.SDK_INT >= 11;
    }

    public static void m6372a(Class<?> cls, String str) {
    }

    public static void m6371a(Class<?> cls, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            stringBuilder.append(stackTraceElement.toString());
        }
        Log.e("CSFDroid", cls.getName() + ": " + exception.getMessage() + "\n" + stringBuilder.toString().replaceAll("@\\)@", ")\\n"));
        exception.printStackTrace();
    }

    public static void m6370a(Window window) {
        window.setFormat(1);
    }

    public static void m6369a(ViewPager viewPager, int i) {
        try {
            Field declaredField = viewPager.getClass().getDeclaredField("mTouchSlop");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, Integer.valueOf(((Integer) declaredField.get(viewPager)).intValue() * i));
        } catch (Throwable e) {
            Log.e("Utils", "", e);
        } catch (Throwable e2) {
            Log.e("Utils", "", e2);
        } catch (Throwable e22) {
            Log.e("Utils", "", e22);
        }
    }

    public static String m6367a(List<?> list, String str) {
        String str2 = "";
        if (list.size() <= 0) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(str);
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    public static List<String> m6368a(JSONArray jSONArray) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.getString(i));
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static C1997a m6366a(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        C1997a c1997a = new C1997a();
        if (VERSION.SDK_INT >= 13) {
            c1997a.f4485a = (int) TypedValue.applyDimension(1, (float) configuration.screenWidthDp, displayMetrics);
            c1997a.f4486b = (int) TypedValue.applyDimension(1, (float) configuration.screenHeightDp, displayMetrics);
        } else {
            c1997a.f4485a = displayMetrics.widthPixels;
            c1997a.f4486b = displayMetrics.heightPixels;
        }
        return c1997a;
    }
}
