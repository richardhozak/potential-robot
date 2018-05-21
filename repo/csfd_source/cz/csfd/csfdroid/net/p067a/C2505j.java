package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.entity.Identity.Acl;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* compiled from: IdentityJsonHelper */
public class C2505j {
    public Identity m9263a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(HTTP.IDENTITY_CODING);
        Identity identity = new Identity(jSONObject2.getInt("id"), jSONObject2.getString("nick"));
        if (jSONObject2.has("avatar_url")) {
            identity.m6815c(jSONObject2.getString("avatar_url"));
        }
        if (jSONObject2.has("acl") && !jSONObject2.isNull("acl")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("acl");
            for (Acl acl : Acl.values()) {
                if (jSONObject3.has(acl.m6805a())) {
                    identity.m6830a(acl, jSONObject3.getBoolean(acl.m6805a()));
                }
            }
        }
        return identity;
    }
}
