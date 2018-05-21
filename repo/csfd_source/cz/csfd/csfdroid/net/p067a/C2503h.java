package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GalleryJsonHelper */
public class C2503h {
    public List<Photo> m9251a(JSONObject jSONObject) {
        List<Photo> arrayList = new ArrayList();
        if (jSONObject.has("photos") && !jSONObject.isNull("photos")) {
            JSONArray jSONArray = jSONObject.getJSONArray("photos");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    arrayList.add(m9250b(jSONArray.getJSONObject(i)));
                }
            }
        }
        return arrayList;
    }

    private Photo m9250b(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject.isNull("default")) {
            jSONObject2 = jSONObject;
        } else {
            jSONObject2 = jSONObject.getJSONObject("default");
        }
        Photo photo = new Photo(jSONObject2.getString("url"), jSONObject2.getInt("width"), jSONObject2.getInt("height"));
        if (!jSONObject.isNull("small")) {
            jSONObject2 = jSONObject.getJSONObject("small");
            if (!(jSONObject2.isNull("url") || jSONObject2.isNull("width") || jSONObject2.isNull("height"))) {
                photo.m7012a(jSONObject2.getString("url"));
                photo.m7011a(jSONObject2.getInt("width"));
                photo.m7014b(jSONObject2.getInt("height"));
            }
        }
        if (!jSONObject.isNull("copyright")) {
            photo.m7015b(jSONObject.getString("copyright"));
        }
        return photo;
    }
}
