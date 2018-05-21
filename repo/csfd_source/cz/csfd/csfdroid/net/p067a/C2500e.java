package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Filmography;
import cz.csfd.csfdroid.data.entity.Filmography.Type;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CreatorJsonHelper */
public class C2500e {
    private C2508m f6267a = new C2508m();

    public MovieCreator m9228a(MovieCreator movieCreator, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("info");
        m9225f(movieCreator, jSONObject2);
        m9223d(movieCreator, jSONObject.getJSONObject("summary"));
        m9222c(movieCreator, jSONObject2);
        return movieCreator;
    }

    private void m9222c(MovieCreator movieCreator, JSONObject jSONObject) {
        m9224e(movieCreator, jSONObject);
        if (jSONObject.has("biography") && !jSONObject.isNull("biography")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("biography");
            if (jSONObject2.has("text") && !jSONObject2.isNull("text")) {
                movieCreator.m6873i(jSONObject2.getString("text"));
            }
            if (jSONObject2.has("source_name") && !jSONObject2.isNull("source_name")) {
                movieCreator.m6875j(jSONObject2.getString("source_name"));
            }
        }
        if (jSONObject.has("photo_url") && !jSONObject.isNull("photo_url")) {
            movieCreator.m6864d(jSONObject.getString("photo_url"));
        }
        if (!jSONObject.isNull("photo_copyright")) {
            movieCreator.m6866e(jSONObject.getString("photo_copyright"));
        }
    }

    private void m9223d(MovieCreator movieCreator, JSONObject jSONObject) {
        if (jSONObject.has("film_photo_count")) {
            movieCreator.m6849a(jSONObject.getInt("film_photo_count"));
        }
        if (jSONObject.has("film_video_count")) {
            movieCreator.m6860c(jSONObject.getInt("film_video_count"));
        }
    }

    private void m9224e(MovieCreator movieCreator, JSONObject jSONObject) {
        if (jSONObject.has("birth_year") && !jSONObject.isNull("birth_year")) {
            movieCreator.m6861c(jSONObject.getString("birth_year"));
        }
        if (jSONObject.has("birth_date") && !jSONObject.isNull("birth_date")) {
            try {
                movieCreator.m6852a(new SimpleDateFormat("yyyy-MM-dd").parse(jSONObject.getString("birth_date")));
            } catch (Exception e) {
                C1998s.m6371a(getClass(), e);
            }
        }
        if (jSONObject.has("birth_place") && !jSONObject.isNull("birth_place")) {
            movieCreator.m6868f(jSONObject.getString("birth_place"));
        }
        if (jSONObject.has("death_year") && !jSONObject.isNull("death_year")) {
            movieCreator.m6869g(jSONObject.getString("death_year"));
        }
        if (jSONObject.has("death_date") && !jSONObject.isNull("death_date")) {
            try {
                movieCreator.m6857b(new SimpleDateFormat("yyyy-MM-dd").parse(jSONObject.getString("death_date")));
            } catch (Exception e2) {
                C1998s.m6371a(getClass(), e2);
            }
        }
        if (jSONObject.has("death_place") && !jSONObject.isNull("death_place")) {
            movieCreator.m6871h(jSONObject.getString("death_place"));
        }
    }

    public List<MovieCreator> m9231a(JSONObject jSONObject, String str) {
        List<MovieCreator> arrayList = new ArrayList();
        if (jSONObject.has("creators") && !jSONObject.isNull("creators")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("creators");
            if (!(optJSONObject == null || !optJSONObject.has(str) || optJSONObject.isNull(str))) {
                JSONArray jSONArray = optJSONObject.getJSONArray(str);
                int length = jSONArray.length();
                if (length > 0) {
                    for (int i = 0; i < length; i++) {
                        arrayList.add(m9245n(jSONArray.getJSONObject(i)));
                    }
                }
            }
        }
        return arrayList;
    }

    public List<MovieCreator> m9230a(JSONObject jSONObject) {
        return m9231a(jSONObject, "directors");
    }

    public List<MovieCreator> m9233b(JSONObject jSONObject) {
        return m9231a(jSONObject, "actors");
    }

    public List<MovieCreator> m9234c(JSONObject jSONObject) {
        return m9231a(jSONObject, "composers");
    }

    public List<MovieCreator> m9235d(JSONObject jSONObject) {
        return m9231a(jSONObject, "authors");
    }

    public List<MovieCreator> m9236e(JSONObject jSONObject) {
        return m9231a(jSONObject, "screenwriters");
    }

    public List<MovieCreator> m9237f(JSONObject jSONObject) {
        return m9231a(jSONObject, "cinematographers");
    }

    public List<MovieCreator> m9238g(JSONObject jSONObject) {
        return m9231a(jSONObject, "production");
    }

    public List<MovieCreator> m9239h(JSONObject jSONObject) {
        return m9231a(jSONObject, "edit");
    }

    public List<MovieCreator> m9240i(JSONObject jSONObject) {
        return m9231a(jSONObject, "sound");
    }

    public List<MovieCreator> m9241j(JSONObject jSONObject) {
        return m9231a(jSONObject, "scenographies");
    }

    public List<MovieCreator> m9242k(JSONObject jSONObject) {
        return m9231a(jSONObject, "masks");
    }

    public List<MovieCreator> m9243l(JSONObject jSONObject) {
        return m9231a(jSONObject, "costumes");
    }

    public List<MovieCreator> m9244m(JSONObject jSONObject) {
        List<MovieCreator> arrayList = new ArrayList();
        JSONObject jSONObject2 = jSONObject.getJSONObject("info");
        if (jSONObject2.has("directors") && !jSONObject2.isNull("directors")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("directors");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    arrayList.add(m9245n(jSONArray.getJSONObject(i)));
                }
            }
        }
        return arrayList;
    }

    public MovieCreator m9232b(MovieCreator movieCreator, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("films");
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                movieCreator.m6850a(m9226o(jSONArray.getJSONObject(i)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return movieCreator;
    }

    private Filmography m9226o(JSONObject jSONObject) {
        Filmography filmography = new Filmography();
        String str = (String) jSONObject.keys().next();
        filmography.m6796a(Type.valueOf(str));
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        m9220a(filmography.m6797b(), jSONObject2, "main", "main");
        m9220a(filmography.m6797b(), jSONObject2, "tv_series", "tv_series");
        m9220a(filmography.m6797b(), jSONObject2, "documents", "documents");
        m9220a(filmography.m6797b(), jSONObject2, "tv_shows", "tv_shows");
        m9220a(filmography.m6797b(), jSONObject2, "music_video_clip", "music_video_clip");
        return filmography;
    }

    private void m9220a(Map<String, List<MovieInfo>> map, JSONObject jSONObject, String str, String str2) {
        if (jSONObject.has(str) && !jSONObject.isNull(str)) {
            map.put(str2, m9221b(jSONObject.getJSONArray(str)));
        }
    }

    private List<MovieInfo> m9221b(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<MovieInfo> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(this.f6267a.m9278a(jSONArray.getJSONObject(i)));
                } catch (Exception e) {
                    C1998s.m6371a(getClass(), e);
                }
            }
        }
        return arrayList;
    }

    MovieCreator m9245n(JSONObject jSONObject) {
        MovieCreator movieCreator = new MovieCreator(jSONObject.getInt("id"));
        m9225f(movieCreator, jSONObject);
        return movieCreator;
    }

    private void m9225f(MovieCreator movieCreator, JSONObject jSONObject) {
        String str;
        if (!jSONObject.has("firstname") || jSONObject.isNull("firstname")) {
            str = "";
        } else {
            str = jSONObject.getString("firstname");
        }
        movieCreator.m6851a(str);
        if (!jSONObject.has("surname") || jSONObject.isNull("surname")) {
            str = "";
        } else {
            str = jSONObject.getString("surname");
        }
        movieCreator.m6856b(str);
        m9224e(movieCreator, jSONObject);
        List p = m9227p(jSONObject);
        if (p != null) {
            movieCreator.m6853a(p);
        }
        if (jSONObject.has("photo_url") && !jSONObject.isNull("photo_url")) {
            movieCreator.m6864d(jSONObject.getString("photo_url"));
        }
    }

    List<MovieCreator> m9229a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<MovieCreator> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                arrayList.add(m9245n(jSONArray.getJSONObject(i)));
            }
        }
        return arrayList;
    }

    private List<String> m9227p(JSONObject jSONObject) {
        List<String> list = null;
        if (jSONObject.has("type") && !jSONObject.isNull("type")) {
            JSONArray jSONArray = jSONObject.getJSONArray("type");
            int length = jSONArray.length();
            list = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                if (!jSONArray.isNull(i)) {
                    list.add(jSONArray.getString(i));
                }
            }
        }
        return list;
    }
}
