package cz.csfd.csfdroid.p061d;

import android.content.Context;
import cz.csfd.csfdroid.data.entity.MovieCreator;

/* compiled from: MovieCreatorUtils */
public class C1991m {
    public static String m6347a(MovieCreator movieCreator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : movieCreator.m6865e()) {
            stringBuilder.append(append).append(" / ");
        }
        if (stringBuilder.length() > 3) {
            return stringBuilder.substring(0, stringBuilder.length() - 3);
        }
        return "";
    }

    public static MovieCreator m6346a(int i, Context context) {
        return (MovieCreator) C1998s.m6365a(context).m6223k().m7162a(Integer.valueOf(i));
    }

    public static String m6348b(MovieCreator movieCreator) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://www.csfd.cz").append("/tvurce/").append(movieCreator.m6705g());
        return stringBuilder.toString();
    }
}
