package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.C2027d;
import cz.csfd.csfdroid.data.entity.Episode;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieInfo.Category;
import cz.csfd.csfdroid.data.entity.Season;
import cz.csfd.csfdroid.data.entity.Seasons;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MovieJsonHelper */
public class C2508m {
    public MovieInfo m9277a(MovieInfo movieInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("info");
        m9270c(movieInfo, jSONObject2);
        m9271d(movieInfo, jSONObject2);
        m9279b(movieInfo, jSONObject2);
        m9272e(movieInfo, jSONObject2);
        m9273f(movieInfo, jSONObject2);
        return movieInfo;
    }

    MovieInfo m9278a(JSONObject jSONObject) {
        MovieInfo movieInfo = new MovieInfo(!jSONObject.isNull("id") ? jSONObject.getInt("id") : 0, jSONObject.getString("name"));
        if (!jSONObject.isNull("poster_url")) {
            movieInfo.m6938d(jSONObject.getString("poster_url"));
        }
        m9270c(movieInfo, jSONObject);
        return movieInfo;
    }

    public MovieInfo m9280b(JSONObject jSONObject) {
        MovieInfo a = m9278a(jSONObject);
        m9270c(a, jSONObject);
        return a;
    }

    private void m9270c(MovieInfo movieInfo, JSONObject jSONObject) {
        movieInfo.m6704b(!jSONObject.isNull("id") ? jSONObject.getInt("id") : 0);
        movieInfo.m6922a(jSONObject.getString("name"));
        if (!jSONObject.isNull("search_name")) {
            movieInfo.m6928b(jSONObject.getString("search_name"));
        }
        if (!jSONObject.isNull("year")) {
            movieInfo.m6932c(jSONObject.getInt("year"));
        }
        if (!jSONObject.isNull("type")) {
            movieInfo.m6957h(jSONObject.getString("type"));
        }
        if (!jSONObject.isNull("type_id")) {
            movieInfo.m6937d(jSONObject.getInt("type_id"));
        }
        List g = m9274g(jSONObject);
        if (g != null) {
            movieInfo.m6985n(g);
        }
        g = m9275h(jSONObject);
        if (g != null) {
            movieInfo.m6982m(g);
        }
        movieInfo.m6919a(m9281c(jSONObject));
        if (!jSONObject.isNull("rating_average")) {
            movieInfo.m6918a(jSONObject.getInt("rating_average"));
        }
    }

    private List<String> m9274g(JSONObject jSONObject) {
        List<String> list = null;
        if (!jSONObject.isNull("origin")) {
            JSONArray jSONArray = jSONObject.getJSONArray("origin");
            int length = jSONArray.length();
            list = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                list.add(jSONArray.getString(i));
            }
        }
        return list;
    }

    private List<String> m9275h(JSONObject jSONObject) {
        List<String> list = null;
        if (!jSONObject.isNull("genre")) {
            JSONArray jSONArray = jSONObject.getJSONArray("genre");
            int length = jSONArray.length();
            list = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                list.add(jSONArray.getString(i));
            }
        }
        return list;
    }

    protected Category m9281c(JSONObject jSONObject) {
        switch (jSONObject.getInt("rating_category")) {
            case 1:
                return Category.RED;
            case 2:
                return Category.BLUE;
            case 3:
                return Category.BLACK;
            default:
                return Category.GREY;
        }
    }

    TvProgramm m9282d(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("station");
        String string = jSONObject.getString("start_datetime");
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            TvProgramm tvProgramm = new TvProgramm(jSONObject2.getString("name"), simpleDateFormat.parse(string));
            if (jSONObject2.has("id")) {
                tvProgramm.m7054a(Integer.parseInt(jSONObject2.getString("id")));
            }
            if (!jSONObject.has("tv_schedule_date")) {
                return tvProgramm;
            }
            tvProgramm.m7055a(simpleDateFormat2.parse(jSONObject.getString("tv_schedule_date")));
            return tvProgramm;
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            return null;
        }
    }

    Date m9283e(JSONObject jSONObject) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(jSONObject.getString("release_date"));
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            return null;
        }
    }

    private MovieInfo m9271d(MovieInfo movieInfo, JSONObject jSONObject) {
        if (!jSONObject.isNull("length")) {
            movieInfo.m6943e(jSONObject.getString("length"));
        }
        if (!jSONObject.isNull("poster_url")) {
            movieInfo.m6938d(jSONObject.getString("poster_url"));
        }
        if (!jSONObject.isNull("name_orig")) {
            movieInfo.m6933c(jSONObject.getString("name_orig"));
        }
        if (!jSONObject.isNull("rating_allowed")) {
            movieInfo.m6954g(jSONObject.getBoolean("rating_allowed"));
        }
        if (!jSONObject.isNull("plot")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("plot");
            if (!jSONObject2.isNull("text")) {
                movieInfo.m6948f(jSONObject2.getString("text"));
            }
            if (!jSONObject2.isNull("source_name")) {
                movieInfo.m6952g(jSONObject2.getString("source_name"));
            }
        }
        if (!jSONObject.isNull("charts")) {
            JSONArray jSONArray = jSONObject.getJSONArray("charts");
            List arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                arrayList.add(new C2027d(jSONObject3.getInt("position"), jSONObject3.getString("chart"), jSONObject3.getString("title")));
            }
            movieInfo.m6989p(arrayList);
        }
        if (!jSONObject.isNull("in_watchlist")) {
            movieInfo.m6979l(jSONObject.getBoolean("in_watchlist"));
        }
        if (!jSONObject.isNull("root_id")) {
            movieInfo.m6942e(jSONObject.getInt("root_id"));
        }
        if (!jSONObject.isNull("root_name")) {
            movieInfo.m6962i(jSONObject.getString("root_name"));
        }
        if (!jSONObject.isNull("root_name_second")) {
            movieInfo.m6967j(jSONObject.getString("root_name_second"));
        }
        if (!jSONObject.isNull("parent_id")) {
            movieInfo.m6947f(jSONObject.getInt("parent_id"));
        }
        if (!jSONObject.isNull("prev_id")) {
            movieInfo.m6951g(jSONObject.getInt("prev_id"));
        }
        if (!jSONObject.isNull("next_id")) {
            movieInfo.m6956h(jSONObject.getInt("next_id"));
        }
        if (!jSONObject.isNull("position_code")) {
            movieInfo.m6972k(jSONObject.getString("position_code"));
        }
        if (!jSONObject.isNull("has_no_seasons")) {
            movieInfo.m6983m(jSONObject.getBoolean("has_no_seasons"));
        }
        return movieInfo;
    }

    private MovieInfo m9272e(MovieInfo movieInfo, JSONObject jSONObject) {
        if (jSONObject.has("summary") && !jSONObject.isNull("summary")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("summary");
            if (jSONObject2.has("photo_count")) {
                movieInfo.m6966j(jSONObject2.getInt("photo_count"));
            }
            if (jSONObject2.has("comment_count")) {
                movieInfo.m6971k(jSONObject2.getInt("comment_count"));
            }
            if (jSONObject2.has("video_count")) {
                movieInfo.m6976l(jSONObject2.getInt("video_count"));
            }
            if (jSONObject2.has("trivia_count")) {
                movieInfo.m6981m(jSONObject2.getInt("trivia_count"));
            }
            if (jSONObject2.has("in_cinemas")) {
                movieInfo.m6964i(jSONObject2.getBoolean("in_cinemas"));
            }
            if (jSONObject2.has("in_favorite_cinemas")) {
                movieInfo.m6969j(jSONObject2.getBoolean("in_favorite_cinemas"));
            }
            if (jSONObject2.has("in_tv")) {
                movieInfo.m6974k(jSONObject2.getBoolean("in_tv"));
            }
        }
        return movieInfo;
    }

    public MovieInfo m9279b(MovieInfo movieInfo, JSONObject jSONObject) {
        if (jSONObject.has("rating") && !jSONObject.isNull("rating")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("rating");
            movieInfo.m6961i(jSONObject2.getInt("rating"));
            if (!jSONObject2.isNull("is_rating_computed")) {
                movieInfo.m6940d(jSONObject2.getBoolean("is_rating_computed"));
            }
        }
        if (jSONObject.has("comment") && !jSONObject.isNull("comment")) {
            movieInfo.m6977l(jSONObject.getJSONObject("comment").getString("text"));
        }
        return movieInfo;
    }

    private void m9273f(MovieInfo movieInfo, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("tv_schedule");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m9282d(jSONArray.getJSONObject(i)));
        }
        movieInfo.m6923a(arrayList);
    }

    public Seasons m9284f(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("seasons");
        List arrayList = new ArrayList();
        Seasons seasons = new Seasons();
        seasons.m7038a(arrayList);
        seasons.m7039a(jSONObject.getBoolean("has_no_seasons"));
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Season season = new Season();
            season.m7022a(jSONObject2.getInt("id"));
            season.m7023a(jSONObject2.getString("name"));
            season.m7027b(jSONObject2.getInt("rating_category"));
            List arrayList2 = new ArrayList();
            JSONArray jSONArray2 = jSONObject2.getJSONArray("genre");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(jSONArray2.getString(i2));
            }
            season.m7024a(arrayList2);
            season.m7028b(jSONObject2.getString("poster_url"));
            season.m7031c(jSONObject2.getString("year"));
            if (!jSONObject2.isNull("is_hidden")) {
                season.m7025a(jSONObject2.getBoolean("is_hidden"));
            }
            season.m7029b(m9276i(jSONObject2));
            arrayList.add(season);
        }
        return seasons;
    }

    private List<Episode> m9276i(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("episodes");
        List<Episode> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Episode episode = new Episode();
            episode.m6786a(jSONObject2.getInt("id"));
            episode.m6787a(jSONObject2.getString("name"));
            episode.m6789b(jSONObject2.getInt("rating_category"));
            episode.m6790b(jSONObject2.getString("year"));
            episode.m6792c(jSONObject2.getString("position_code"));
            arrayList.add(episode);
        }
        return arrayList;
    }
}
