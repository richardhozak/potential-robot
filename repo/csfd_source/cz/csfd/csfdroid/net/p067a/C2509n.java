package cz.csfd.csfdroid.net.p067a;

import android.util.Log;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchJsonHelper */
public class C2509n {
    private C2508m f6274a = new C2508m();
    private C2500e f6275b = new C2500e();
    private C2513q f6276c = new C2513q();

    public Map<String, List<? extends BasicEntity>> m9290a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Map hashMap = new HashMap(2);
        if (!jSONObject.isNull("films")) {
            optJSONArray = jSONObject.optJSONArray("films");
            if (optJSONArray != null) {
                hashMap.put("films", m9285a(optJSONArray));
            }
        }
        if (!jSONObject.isNull("creators")) {
            optJSONArray = jSONObject.optJSONArray("creators");
            if (optJSONArray != null) {
                hashMap.put("creators", m9286b(optJSONArray));
            }
        }
        if (!jSONObject.isNull("users")) {
            optJSONArray = jSONObject.optJSONArray("users");
            if (optJSONArray != null) {
                hashMap.put("users", m9288c(optJSONArray));
                Log.d("CSFD", "users list count: " + m9288c(optJSONArray).size());
            }
        }
        return hashMap;
    }

    public List<User> m9291b(JSONObject jSONObject) {
        return m9288c(jSONObject.getJSONArray("users"));
    }

    private List<MovieInfo> m9285a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<MovieInfo> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                arrayList.add(m9287c(jSONArray.getJSONObject(i)));
            }
        }
        return arrayList;
    }

    private MovieInfo m9287c(JSONObject jSONObject) {
        return this.f6274a.m9278a(jSONObject);
    }

    private List<MovieCreator> m9286b(JSONArray jSONArray) {
        return this.f6275b.m9229a(jSONArray);
    }

    private List<User> m9288c(JSONArray jSONArray) {
        int length = jSONArray.length();
        List<User> arrayList = new ArrayList(length);
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                arrayList.add(m9289d(jSONArray.getJSONObject(i)));
            }
        }
        return arrayList;
    }

    private User m9289d(JSONObject jSONObject) {
        C2513q c2513q = this.f6276c;
        return C2513q.m9297a(jSONObject);
    }
}
