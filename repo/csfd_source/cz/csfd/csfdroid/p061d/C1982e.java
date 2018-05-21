package cz.csfd.csfdroid.p061d;

import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtils */
public class C1982e {
    public static String m6330a(Date date) {
        String str = "";
        if (date == null) {
            return str;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        str = simpleDateFormat.format(date);
        String format = simpleDateFormat2.format(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        C1982e.m6331a(instance);
        Calendar a = C1982e.m6331a(Calendar.getInstance());
        Calendar a2 = C1982e.m6331a(Calendar.getInstance());
        a2.add(7, 1);
        if (instance.compareTo(a) == 0) {
            str = "dnes";
        } else if (instance.compareTo(a2) == 0) {
            str = "zítra";
        }
        return str + " v " + format;
    }

    private static Calendar m6331a(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static String m6332b(Date date) {
        if (new Date().getTime() - date.getTime() <= 60000) {
            return "právě teď";
        }
        return DateUtils.getRelativeTimeSpanString(date.getTime()).toString().toLowerCase();
    }
}
