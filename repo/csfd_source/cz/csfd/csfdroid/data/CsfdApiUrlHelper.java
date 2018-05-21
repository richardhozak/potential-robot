package cz.csfd.csfdroid.data;

import android.text.TextUtils;
import android.util.Base64;
import cz.csfd.csfdroid.data.C2016c.C2019c;
import cz.csfd.csfdroid.data.C2016c.C2020d;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.module.home.C2284d.C2283b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* compiled from: CsfdApiUrlHelper */
// C2018b
public class CsfdApiUrlHelper {
    public String m6659a(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("home?data=");
        for (String append : list) {
            stringBuilder.append(append).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("&limit=3");
        stringBuilder.append("&creator_profile_visits_limit=4");
        return stringBuilder.toString();
    }

    public static String getBaseApiUrl() {
        return "https://android-api.csfd.cz";
    }

    public String m6660b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append(HTTP.IDENTITY_CODING);
        return stringBuilder.toString();
    }

    public String m6645a(int i) {
        StringBuilder p = m6642p(i);
        p.append("/").append("films").append("?return=array");
        return p.toString();
    }

    public String m6661b(int i) {
        return m6642p(i).toString();
    }

    private StringBuilder m6642p(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("creator").append("/").append(i);
        return stringBuilder;
    }

    public String m6647a(int i, int i2, int i3) {
        StringBuilder p = m6642p(i);
        p.append("/").append("videos").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return p.toString();
    }

    public String m6663b(int i, int i2, int i3) {
        StringBuilder p = m6642p(i);
        p.append("/").append("photos").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return p.toString();
    }

    public String m6648a(int i, int i2, int i3, int i4) {
        StringBuilder q = m6643q(i);
        q.append("/").append("photos").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3).append("&").append("size=all").append("&").append("width=").append(i4);
        return q.toString();
    }

    public String m6664b(int i, int i2, int i3, int i4) {
        StringBuilder q = m6643q(i);
        q.append("/").append("videos").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3).append("&").append("width=").append(i4);
        return q.toString();
    }

    public String m6670c(int i, int i2, int i3) {
        StringBuilder q = m6643q(i);
        q.append("/").append("comments").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return q.toString();
    }

    public String m6674d(int i, int i2, int i3) {
        StringBuilder q = m6643q(i);
        q.append("/").append("trivia").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return q.toString();
    }

    public String m6669c(int i) {
        StringBuilder q = m6643q(i);
        q.append("/").append("creators");
        return q.toString();
    }

    public String m6673d(int i) {
        StringBuilder q = m6643q(i);
        q.append("/").append("my-rating");
        return q.toString();
    }

    public String m6676e(int i) {
        StringBuilder q = m6643q(i);
        q.append("/").append("my-comment");
        return q.toString();
    }

    public String m6678f(int i) {
        return m6643q(i).toString();
    }

    private StringBuilder m6643q(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("film").append("/").append(i);
        return stringBuilder;
    }

    public String m6654a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("search?q=").append(URLEncoder.encode(str, HTTP.UTF_8));
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        return stringBuilder.toString();
    }

    public String m6655a(String str, int i) {
        String str2;
        Exception e;
        try {
            str2 = CsfdApiUrlHelper.getBaseApiUrl() + "/search/users/?q=" + URLEncoder.encode(str, HTTP.UTF_8);
            if (i > 0) {
                try {
                    str2 = str2 + "&limit=" + i;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    C1998s.m6371a(getClass(), e);
                    return str2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = null;
            e = exception;
            C1998s.m6371a(getClass(), e);
            return str2;
        }
        return str2;
    }

    public String m6644a(double d, double d2, int i, boolean z, C2019c c2019c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("nearest").append("?").append("latitude=").append(d).append("&").append("longitude=").append(d2);
        if (i > 0) {
            stringBuilder.append("&").append("film_id=").append(i);
        }
        if (z) {
            stringBuilder.append("&").append("only_with_schedule=").append("1");
        }
        if (c2019c != null) {
            stringBuilder.append("&").append("time_range=").append(c2019c.name().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public String m6657a(String str, int i, boolean z, C2019c c2019c) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("towns").append("?").append("name=").append(URLEncoder.encode(str, HTTP.UTF_8)).append("&with_cinemas=1");
            if (i > 0) {
                stringBuilder.append("&").append("film_id=").append(i);
            }
            if (z) {
                stringBuilder.append("&").append("only_with_schedule=").append("1");
            }
            if (c2019c != null) {
                stringBuilder.append("&").append("time_range=").append(c2019c.name().toLowerCase());
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        return stringBuilder.toString();
    }

    public String m6666b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("towns").append("?").append("name=").append(URLEncoder.encode(str, HTTP.UTF_8));
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        return stringBuilder.toString();
    }

    public String m6681g(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append(i);
        return stringBuilder.toString();
    }

    public String m6668c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("charts").append("/");
        return stringBuilder.toString();
    }

    public String m6656a(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("charts").append("/").append(str).append("?").append("offset=").append(i).append("&").append("limit=").append(i2);
        return stringBuilder.toString();
    }

    public String m6684h(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("user").append("/").append(i);
        return stringBuilder.toString();
    }

    public String m6677e(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("user").append("/").append(i).append("/").append("film-ratings").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return stringBuilder.toString();
    }

    public String m6679f(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("user").append("/").append(i).append("/").append("film-comments").append("?").append("offset=").append(i2).append("&").append("limit=").append(i3);
        return stringBuilder.toString();
    }

    public String m6650a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "fanclub-" + str.toLowerCase();
        if (str.equals(Section.FAVOURITE_USERS.m7079d())) {
            str2 = "favorites";
        }
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("user").append("/").append(i).append("/").append(str2);
        return stringBuilder.toString();
    }

    public String m6687i(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("favorites").append("/").append("activity").append("/?").append("types").append("=film_rating%2Cfilm_comment").append("&").append("limit").append("=").append(20).append("&").append("offset").append("=").append(i);
        return stringBuilder.toString();
    }

    public String m6689j(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("watchlist").append("/?").append("limit").append("=").append(20).append("&").append("offset").append("=").append(i);
        return stringBuilder.toString();
    }

    public String m6672d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("watchlist");
        return stringBuilder.toString();
    }

    public String m6691k(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("watchlist").append("/?").append("film_id").append("=").append(i);
        return stringBuilder.toString();
    }

    public String m6652a(long j, int i, C2020d c2020d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("tv/tips").append("/?").append("limit").append("=").append(20).append("&").append("offset").append("=").append(i).append("&").append("date").append("=").append(String.format(Locale.ENGLISH, "%tY-%<tm-%<td", new Object[]{Long.valueOf(j)})).append("&").append("orderBy").append("=").append(c2020d.m6699a());
        return stringBuilder.toString();
    }

    public String m6658a(Date date, List<Integer> list, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("tv/schedule").append("/?").append("limit").append("=").append(20).append("&").append("offset").append("=").append(i).append("&").append("date").append("=").append(String.format(Locale.ENGLISH, "%tY-%<tm-%<td", new Object[]{date}));
        if (list != null && list.size() > 0) {
            stringBuilder.append("&").append("stations").append("=").append(TextUtils.join(",", list));
        }
        return stringBuilder.toString();
    }

    public String m6675e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("tv/stations");
        return stringBuilder.toString();
    }

    @Deprecated
    public static String getRequestAccessTokenUrl() {
        StringBuilder stringBuilder = new StringBuilder(CsfdApiUrlHelper.getBaseApiUrl());
        stringBuilder.append("/").append("request-access-token").append("?").append("api_consumer_key=").append("061025241049");
        return stringBuilder.toString();
    }

    public String m6649a(int i, int i2, String str, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("ad/banner").append("?").append("width=").append(i).append("&").append("height=").append(i2).append("&").append("section=").append(str);
        if (map != null && map.size() > 0) {
            stringBuilder.append("&").append("parameters=").append(Base64.encodeToString(new JSONObject(map).toString().getBytes(), 0));
        }
        return stringBuilder.toString();
    }

    public String m6653a(C2283b c2283b, Date date) {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("releases").append("/").append(c2283b.toString().toLowerCase()).append("?date=").append(format);
        return stringBuilder.toString();
    }

    public String m6680g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("favorites");
        return stringBuilder.toString();
    }

    public String m6651a(int i, boolean z, C2019c c2019c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("favorites");
        if (i > 0) {
            stringBuilder.append("?").append("film_id=").append(i);
        }
        if (z) {
            stringBuilder.append(stringBuilder.indexOf("?") == -1 ? "?" : "&").append("only_with_schedule=").append("1");
        }
        if (c2019c != null) {
            stringBuilder.append(stringBuilder.indexOf("?") == -1 ? "?" : "&").append("time_range=").append(c2019c.name().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public String m6693l(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("cinema").append("/").append("favorites").append("?").append("cinema_id=").append(i);
        return stringBuilder.toString();
    }

    public String m6683h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("video").append("/").append("types");
        return stringBuilder.toString();
    }

    public String m6682g(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("video");
        stringBuilder.append("?");
        if (i > 0) {
            stringBuilder.append("type=").append(i);
            stringBuilder.append("&");
        }
        stringBuilder.append("offset=").append(i2).append("&").append("limit=").append(i3);
        return stringBuilder.toString();
    }

    public String m6686i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("ad").append("/").append("ad-mob");
        return stringBuilder.toString();
    }

    public String m6646a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("ad").append("/").append("splash").append("?").append("width=").append(i).append("height=").append(i2);
        return stringBuilder.toString();
    }

    public String m6665b(int i, int i2, String str, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("ad").append("/").append("bottom").append("?").append("width=").append(i).append("&").append("height=").append(i2).append("&").append("section=").append(str);
        if (map != null && map.size() > 0) {
            stringBuilder.append("&").append("parameters=").append(Base64.encodeToString(new JSONObject(map).toString().getBytes(), 0));
        }
        return stringBuilder.toString();
    }

    public String m6662b(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("messages").append("?").append("limit=").append(i).append("&").append("offset=").append(i2);
        return stringBuilder.toString();
    }

    public String m6685h(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("messages").append("/").append("thread").append("?").append("user_id=").append(i).append("&").append("limit=").append(i2).append("&").append("offset=").append(i3);
        return stringBuilder.toString();
    }

    public String m6667b(List<Integer> list) {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/messages/delete/?user_id=" + m6640a((List) list, ",");
    }

    public String m6671c(List<String> list) {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/messages/delete/?message_id=" + m6640a((List) list, ",");
    }

    public String m6688j() {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/messages/unread-threads";
    }

    public String m6694m(int i) {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/" + "user" + "/" + i + "/" + "favorites-add";
    }

    public String m6695n(int i) {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/" + "user" + "/" + i + "/" + "favorites-remove";
    }

    public String m6696o(int i) {
        return CsfdApiUrlHelper.getBaseApiUrl() + "/film/" + i + "/episodes";
    }

    private String m6640a(List list, String str) {
        String str2 = "";
        for (Object next : list) {
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + ",";
            }
            str2 = str2 + next;
        }
        return str2;
    }

    public String m6690k() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("messages").append("/").append("send");
        return stringBuilder.toString();
    }

    public String m6692l() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CsfdApiUrlHelper.getBaseApiUrl()).append("/").append("messages").append("/").append("contacts");
        return stringBuilder.toString();
    }
}