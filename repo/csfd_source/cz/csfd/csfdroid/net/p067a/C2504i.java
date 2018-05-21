package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HomeJsonHelper */
public class C2504i {
    private C2500e f6268a = new C2500e();
    private C2508m f6269b = new C2508m();
    private C2514r f6270c = new C2514r();
    private C2502g f6271d = new C2502g();
    private C2498c f6272e = new C2498c();
    private C2496a f6273f = new C2496a();

    public Map<String, List<? extends BasicEntity>> m9262a(JSONObject jSONObject) {
        Map hashMap = new HashMap(4);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!str.equals("adverts")) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                if (str.equals("favorites")) {
                    hashMap.put(str, m9252a(jSONArray));
                } else if (str.equals("creator_profile_visits")) {
                    hashMap.put(str, m9258c(jSONArray));
                } else if (str.equals("favorite_cinemas")) {
                    hashMap.put(str, m9255b(jSONArray));
                } else {
                    hashMap.put(str, m9260d(jSONArray));
                }
            }
        }
        return hashMap;
    }

    private List<ActivityEntity> m9252a(JSONArray jSONArray) {
        List<ActivityEntity> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(this.f6271d.m9248a(jSONArray.getJSONObject(i), i));
        }
        return arrayList;
    }

    private List<Cinema> m9255b(JSONArray jSONArray) {
        List<Cinema> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(this.f6272e.m9216b(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private List<MovieCreator> m9258c(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<MovieCreator> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(m9254b(jSONArray.getJSONObject(i)));
                } catch (Exception e) {
                    C1998s.m6371a(getClass(), e);
                }
            }
        }
        return arrayList;
    }

    private MovieCreator m9254b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("creator");
        C1998s.m6372a(getClass(), jSONObject.toString(4));
        return this.f6268a.m9245n(jSONObject2);
    }

    private List<MovieInfo> m9260d(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<MovieInfo> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(m9257c(jSONArray.getJSONObject(i)));
                } catch (Exception e) {
                    C1998s.m6371a(getClass(), e);
                }
            }
        }
        return arrayList;
    }

    private MovieInfo m9257c(JSONObject jSONObject) {
        MovieInfo a = this.f6269b.m9278a(jSONObject.getJSONObject("film"));
        m9253a(jSONObject, a);
        m9256b(jSONObject, a);
        m9259c(jSONObject, a);
        return a;
    }

    private void m9253a(JSONObject jSONObject, MovieInfo movieInfo) {
        if (jSONObject.has("start_datetime") && jSONObject.has("station")) {
            TvProgramm d = this.f6269b.m9282d(jSONObject);
            if (d != null) {
                movieInfo.m6921a(d);
            }
        }
    }

    private void m9256b(JSONObject jSONObject, MovieInfo movieInfo) {
        if (jSONObject.has("release_date") && !jSONObject.isNull("release_date")) {
            Date e = this.f6269b.m9283e(jSONObject);
            if (e != null) {
                movieInfo.m6924a(e);
            }
        }
    }

    private void m9259c(JSONObject jSONObject, MovieInfo movieInfo) {
        if (jSONObject.has("video") && !jSONObject.isNull("video")) {
            movieInfo.m6920a(this.f6270c.m9310b(jSONObject, 1));
        }
    }

    public List<MovieInfo> m9261a(JSONObject jSONObject, String str) {
        return m9260d(jSONObject.getJSONArray(str + "_releases"));
    }
}
