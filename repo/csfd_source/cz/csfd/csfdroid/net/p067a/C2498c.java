package cz.csfd.csfdroid.net.p067a;

import android.location.Location;
import android.util.Log;
import cz.csfd.csfdroid.data.entity.C2029f;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.CinemaMovie;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CinemaJsonHelper */
public class C2498c {
    private C2508m f6266a = new C2508m();

    public List<Cinema> m9214a(JSONObject jSONObject, Location location) {
        List arrayList = new ArrayList();
        if (!jSONObject.isNull("cinemas")) {
            m9211a(jSONObject.getJSONArray("cinemas"), location, arrayList);
        }
        return arrayList;
    }

    public Map<String, List<Cinema>> m9215a(JSONObject jSONObject) {
        Map<String, List<Cinema>> treeMap = new TreeMap();
        if (!jSONObject.isNull("towns")) {
            JSONArray jSONArray = jSONObject.getJSONArray("towns");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("name");
                List list = (List) treeMap.get(string);
                if (list == null) {
                    list = new ArrayList();
                    treeMap.put(string, list);
                }
                if (!jSONObject2.isNull("cinemas")) {
                    m9211a(jSONObject2.getJSONArray("cinemas"), null, list);
                }
            }
        }
        return treeMap;
    }

    private void m9211a(JSONArray jSONArray, Location location, List<Cinema> list) {
        int length = jSONArray.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                list.add(m9209a(m9212d(jSONObject), jSONObject, location));
            }
        }
    }

    public Cinema m9216b(JSONObject jSONObject) {
        return m9209a(m9212d(jSONObject), jSONObject, null);
    }

    private Cinema m9212d(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject.has("id")) {
            i = jSONObject.getInt("id");
        } else if (jSONObject.has("cinema_id")) {
            i = jSONObject.getInt("cinema_id");
        }
        Cinema cinema = new Cinema(i, jSONObject.getString("name").trim());
        if (!jSONObject.isNull("is_favorite")) {
            cinema.m6751c(jSONObject.getBoolean("is_favorite"));
        }
        return cinema;
    }

    public List<String> m9217c(JSONObject jSONObject) {
        List<String> arrayList = new ArrayList();
        if (!jSONObject.isNull("towns")) {
            JSONArray jSONArray = jSONObject.getJSONArray("towns");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i).getString("name"));
            }
        }
        return arrayList;
    }

    public Cinema m9213a(Cinema cinema, JSONObject jSONObject) {
        m9209a(cinema, jSONObject.getJSONObject("cinema"), null);
        cinema.m6739a(m9210a(jSONObject.getJSONArray("schedule")));
        if (!jSONObject.isNull("is_favorite")) {
            cinema.m6751c(jSONObject.getBoolean("is_favorite"));
        }
        return cinema;
    }

    private Cinema m9209a(Cinema cinema, JSONObject jSONObject, Location location) {
        int i;
        int i2 = 0;
        if (jSONObject.has("id")) {
            i = jSONObject.getInt("id");
        } else if (jSONObject.has("cinema_id")) {
            i = jSONObject.getInt("cinema_id");
        } else {
            i = 0;
        }
        String trim = jSONObject.getString("name").trim();
        cinema.m6704b(i);
        cinema.m6740a(trim);
        if (!jSONObject.isNull("address")) {
            cinema.m6745b(jSONObject.getString("address"));
        }
        if (!jSONObject.isNull("web_url")) {
            cinema.m6749c(jSONObject.getString("web_url"));
        }
        if (!jSONObject.isNull("phone")) {
            cinema.m6741a(C1998s.m6368a(jSONObject.getJSONArray("phone")));
        }
        if (!jSONObject.isNull("email")) {
            cinema.m6746b(C1998s.m6368a(jSONObject.getJSONArray("email")));
        }
        if (!jSONObject.isNull("coordinates")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("coordinates");
            if (!(jSONObject2.isNull("latitude") || jSONObject2.isNull("longitude"))) {
                Location location2 = new Location((String) null);
                location2.setLatitude(jSONObject2.getDouble("latitude"));
                location2.setLongitude(jSONObject2.getDouble("longitude"));
                cinema.m6738a(location2);
                if (location != null) {
                    cinema.m6744b(location.bearingTo(location2));
                    cinema.m6737a(location.distanceTo(location2) / 1000.0f);
                }
            }
        }
        if (!jSONObject.isNull("has_schedule")) {
            cinema.m6747b(jSONObject.getBoolean("has_schedule"));
        }
        if (!jSONObject.isNull("is_favorite")) {
            cinema.m6751c(jSONObject.getBoolean("is_favorite"));
        }
        if (!jSONObject.isNull("best_film_poster")) {
            cinema.m6753d(jSONObject.getString("best_film_poster"));
        }
        if (!jSONObject.isNull("schedule")) {
            JSONArray jSONArray = jSONObject.getJSONArray("schedule");
            List arrayList = new ArrayList();
            while (i2 < jSONArray.length()) {
                arrayList.add(jSONArray.getString(i2));
                i2++;
            }
            cinema.m6750c(arrayList);
        }
        return cinema;
    }

    private C2029f m9210a(JSONArray jSONArray) {
        C2029f c2029f = new C2029f();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = jSONObject.getJSONArray("start_datetime");
            JSONObject jSONObject2 = jSONObject.getJSONObject("film");
            Log.d("MYCSFD", "schedule item " + jSONObject.toString(2));
            MovieInfo b = this.f6266a.m9280b(jSONObject2);
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                try {
                    arrayList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONArray2.getString(i2)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            CinemaMovie cinemaMovie = new CinemaMovie(b, arrayList);
            cinemaMovie.m6765a(jSONObject.getBoolean("dubbing"));
            cinemaMovie.m6767b(jSONObject.getBoolean("subtitles"));
            cinemaMovie.m6769c(jSONObject.getBoolean("technology_3d"));
            cinemaMovie.m6771d(jSONObject.getBoolean("technology_4dx"));
            cinemaMovie.m6773e(jSONObject.getBoolean("csfd_hall"));
            cinemaMovie.m6775f(jSONObject.getBoolean("gold_class"));
            c2029f.m7107a(cinemaMovie);
        }
        return c2029f;
    }
}
