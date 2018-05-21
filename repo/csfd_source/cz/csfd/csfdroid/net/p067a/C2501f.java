package cz.csfd.csfdroid.net.p067a;

import org.json.JSONObject;

/* compiled from: ErrorJsonHelper */
public class C2501f {
    public boolean m9246a(JSONObject jSONObject) {
        return jSONObject.has("error");
    }

    public String m9247b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
        return jSONObject2.getInt("code") + ": " + jSONObject2.getString("message");
    }
}
