package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.MovieVideo.Video;
import cz.csfd.csfdroid.data.entity.Season;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MovieInfoUtils */
public class C1992n {
    public static String m6351a(MovieInfo movieInfo) {
        return C1992n.m6356a(movieInfo.m6997x(), " / ");
    }

    public static String m6355a(Season season) {
        return C1992n.m6356a(season.m7032d(), " / ");
    }

    public static String m6356a(List<String> list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(append).append(str);
        }
        if (stringBuilder.length() > str.length()) {
            return stringBuilder.substring(0, stringBuilder.length() - str.length());
        }
        return "";
    }

    public static String m6358b(MovieInfo movieInfo) {
        String c = C1992n.m6359c(movieInfo);
        String valueOf = movieInfo.m6965j() != -1 ? String.valueOf(movieInfo.m6965j()) : null;
        String z = (movieInfo.m6999z().length() <= 0 || movieInfo.m6999z().equals("0")) ? "" : movieInfo.m6999z();
        if (z.length() > 0) {
            z = z + " min";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        if (stringBuilder.length() > 0 && valueOf != null) {
            stringBuilder.append(", ");
            stringBuilder.append(valueOf);
        } else if (valueOf != null) {
            stringBuilder.append(valueOf);
        }
        if (stringBuilder.length() > 0 && z.length() > 0) {
            stringBuilder.append(", ");
            stringBuilder.append(z);
        } else if (z.length() > 0) {
            stringBuilder.append(z);
        }
        return stringBuilder.toString();
    }

    public static String m6359c(MovieInfo movieInfo) {
        return C1992n.m6352a(movieInfo, " / ");
    }

    public static String m6352a(MovieInfo movieInfo, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : movieInfo.m6998y()) {
            stringBuilder.append(append).append(str);
        }
        if (stringBuilder.length() > str.length()) {
            return stringBuilder.substring(0, stringBuilder.length() - str.length());
        }
        return "";
    }

    public static String m6360d(MovieInfo movieInfo) {
        Date ae = movieInfo.ae();
        if (ae != null) {
            return new SimpleDateFormat("d.M.yyyy").format(ae);
        }
        return "";
    }

    public static MovieInfo m6350a(int i, Context context) {
        return (MovieInfo) C1998s.m6365a(context).m6222j().m7162a(Integer.valueOf(i));
    }

    public static String m6361e(MovieInfo movieInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://www.csfd.cz").append("/film/").append(movieInfo.m6705g());
        return stringBuilder.toString();
    }

    public static String m6354a(MovieVideo movieVideo, String str) {
        if (movieVideo.m7005c() == null || movieVideo.m7005c().isEmpty()) {
            return null;
        }
        for (Entry entry : movieVideo.m7005c()) {
            if (str.equals(entry.getKey())) {
                return (String) entry.getValue();
            }
        }
        return (String) ((Entry) movieVideo.m7005c().get(0)).getValue();
    }

    public static String m6353a(Video video, String str) {
        Map a = video.m7000a();
        if (a == null || a.isEmpty()) {
            return null;
        }
        if (a.containsKey(str)) {
            return (String) a.get(str);
        }
        return (String) a.get(C1992n.m6357a(a).get(0));
    }

    public static List<String> m6357a(Map<String, String> map) {
        List<String> arrayList = new ArrayList();
        SortedSet<Integer> treeSet = new TreeSet();
        if (!(map == null || map.isEmpty())) {
            for (String str : map.keySet()) {
                try {
                    treeSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    arrayList.add(str);
                }
            }
            for (Integer valueOf : treeSet) {
                arrayList.add(String.valueOf(valueOf));
            }
        }
        return arrayList;
    }

    public static SpannableString m6349a(Resources resources, String str) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("/|,").matcher(str);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.text_slash)), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
