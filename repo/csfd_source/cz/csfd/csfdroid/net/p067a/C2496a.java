package cz.csfd.csfdroid.net.p067a;

import com.google.android.gms.ads.AdSize;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.data.entity.C2025b;
import cz.csfd.csfdroid.module.ads.C2153c;
import cz.csfd.csfdroid.module.ads.C2154d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdsJsonHelper */
public class C2496a {
    public C2024a m9201a(JSONObject jSONObject) {
        AdSize adSize = null;
        if (!jSONObject.has("ad") || jSONObject.isNull("ad")) {
            return null;
        }
        String str;
        String str2;
        String str3;
        String str4;
        double d;
        int i;
        JSONObject jSONObject2 = jSONObject.getJSONObject("ad");
        double d2 = 0.0533333346247673d;
        if (jSONObject2.isNull("banner") && jSONObject2.isNull("bottom")) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            d = 0.0533333346247673d;
            d2 = 0.1388888955116272d;
        } else {
            JSONObject jSONObject3;
            if (jSONObject2.isNull("banner")) {
                jSONObject3 = jSONObject2.getJSONObject("bottom");
            } else {
                jSONObject3 = jSONObject2.getJSONObject("banner");
            }
            if (!jSONObject3.has("name") || jSONObject3.isNull("name")) {
                str4 = null;
            } else {
                str4 = jSONObject3.getString("name");
            }
            if (!jSONObject3.has("portrait") || jSONObject3.isNull("portrait")) {
                str3 = null;
            } else {
                str3 = jSONObject3.getString("portrait");
            }
            if (!jSONObject3.has("landscape") || jSONObject3.isNull("landscape")) {
                str2 = null;
            } else {
                str2 = jSONObject3.getString("landscape");
            }
            if (!jSONObject3.has("link") || jSONObject3.isNull("link")) {
                str = null;
            } else {
                str = jSONObject3.getString("link");
            }
            if (!jSONObject3.isNull("ratio_landscape")) {
                d2 = jSONObject3.getDouble("ratio_landscape");
            }
            if (jSONObject3.isNull("ratio_portrait")) {
                d = d2;
                d2 = 0.1388888955116272d;
            } else {
                d = d2;
                d2 = jSONObject3.getDouble("ratio_portrait");
            }
        }
        if (!jSONObject2.has("next") || jSONObject2.isNull("next")) {
            i = 0;
        } else {
            i = jSONObject2.getInt("next");
        }
        C2024a c2024a = new C2024a(str4, str3, str2, str, i * 1000);
        c2024a.m7085a(d);
        c2024a.m7088b(d2);
        if (!jSONObject2.isNull("admob")) {
            str4 = jSONObject2.getString("admob");
            if ("medium_rectangle".equals(str4)) {
                adSize = AdSize.MEDIUM_RECTANGLE;
            } else if ("smart_banner".equals(str4)) {
                adSize = AdSize.SMART_BANNER;
            }
        }
        c2024a.m7086a(adSize);
        return c2024a;
    }

    public C2024a m9202b(JSONObject jSONObject) {
        String str = null;
        if (jSONObject.isNull("ad")) {
            return null;
        }
        String str2;
        String str3;
        int i;
        JSONObject jSONObject2 = jSONObject.getJSONObject("ad");
        int i2 = 2;
        if (jSONObject2.isNull("splash")) {
            str2 = null;
            str3 = null;
        } else {
            String str4;
            JSONObject jSONObject3 = jSONObject2.getJSONObject("splash");
            if (!jSONObject3.has("name") || jSONObject3.isNull("name")) {
                str4 = null;
            } else {
                str4 = jSONObject3.getString("name");
            }
            if (jSONObject3.has("image")) {
                str3 = jSONObject3.getString("image");
            } else {
                str3 = null;
            }
            if (jSONObject3.has("link") && !jSONObject3.isNull("link")) {
                str = jSONObject3.getString("link");
            }
            if (jSONObject3.isNull("duration")) {
                str2 = str;
                str = str4;
            } else {
                i2 = jSONObject3.getInt("duration");
                str2 = str;
                str = str4;
            }
        }
        if (!jSONObject2.has("next") || jSONObject2.isNull("next")) {
            i = 0;
        } else {
            i = jSONObject2.getInt("next");
        }
        return new C2024a(str, str3, str2, i * 1000, i2);
    }

    public C2154d m9203c(JSONObject jSONObject) {
        if (jSONObject.isNull("adverts")) {
            return null;
        }
        return m9204d(jSONObject.getJSONObject("adverts"));
    }

    public C2154d m9204d(JSONObject jSONObject) {
        int i = jSONObject.getInt("intensity");
        JSONArray jSONArray = jSONObject.getJSONArray("videos");
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            Map hashMap = new HashMap();
            JSONObject jSONObject3 = jSONObject2.getJSONObject("video");
            Iterator keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject3.getString(str));
            }
            arrayList.add(new C2153c(hashMap, jSONObject2.getString("tracking"), jSONObject2.getString("link"), jSONObject2.getInt("skip_timeout"), (float) jSONObject2.getDouble("ratio")));
        }
        return new C2154d(arrayList, i);
    }

    public C2025b m9205e(JSONObject jSONObject) {
        C2025b c2025b = new C2025b();
        c2025b.f4678a = jSONObject.getString("app_unit_id");
        c2025b.f4679b = jSONObject.getString("home_interstitial_id");
        c2025b.f4680c = jSONObject.getString("search_interstitial_id");
        return c2025b;
    }
}
