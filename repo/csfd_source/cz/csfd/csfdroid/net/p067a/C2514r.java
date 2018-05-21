package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.C2031h;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.p059b.C1962a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VideosJsonHelper */
public class C2514r {
    private C2508m f6280a = new C2508m();

    public List<MovieVideo> m9309a(JSONObject jSONObject, int i) {
        List<MovieVideo> arrayList = new ArrayList();
        if (jSONObject.has("videos") && !jSONObject.isNull("videos")) {
            JSONArray jSONArray = jSONObject.getJSONArray("videos");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(m9310b(jSONArray.getJSONObject(i2), i + i2));
                }
            }
        }
        return arrayList;
    }

    public MovieVideo m9310b(JSONObject jSONObject, int i) {
        String str = "";
        if (jSONObject.has("description") && !jSONObject.isNull("description")) {
            str = jSONObject.getString("description");
        }
        Photo c = m9307c(jSONObject);
        Map b = m9306b(jSONObject);
        List arrayList = new ArrayList();
        if (!jSONObject.isNull("subtitles")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("subtitles");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                arrayList.add(new C1962a(str2, jSONObject2.getString(str2)));
            }
        }
        MovieVideo movieVideo = new MovieVideo(i, str, b, c, arrayList);
        if (!jSONObject.isNull("film")) {
            movieVideo.m7002a(this.f6280a.m9278a(jSONObject.getJSONObject("film")));
        }
        if (!jSONObject.isNull("copyright")) {
            movieVideo.m7003a(jSONObject.getString("copyright"));
        }
        return movieVideo;
    }

    private Map<String, String> m9306b(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        if (jSONObject.has("video") && !jSONObject.isNull("video")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("video");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject2.getString(str));
            }
        }
        return hashMap;
    }

    private Photo m9307c(JSONObject jSONObject) {
        if (!jSONObject.has("preview_image") || jSONObject.isNull("preview_image")) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("preview_image");
        return new Photo(jSONObject2.getString("url"), jSONObject2.getInt("width"), jSONObject2.getInt("height"));
    }

    public List<C2031h> m9308a(JSONObject jSONObject) {
        List<C2031h> arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("types");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new C2031h(jSONObject2.getInt("id"), jSONObject2.getString("name")));
        }
        return arrayList;
    }
}
