package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Trivia;
import cz.csfd.csfdroid.data.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TriviaJsonHelper */
public class C2510o {
    public List<Trivia> m9292a(JSONObject jSONObject) {
        List<Trivia> arrayList = new ArrayList();
        if (jSONObject.has("trivia") && !jSONObject.isNull("trivia")) {
            JSONArray jSONArray = jSONObject.getJSONArray("trivia");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    arrayList.add(m9293b(jSONArray.getJSONObject(i)));
                }
            }
        }
        return arrayList;
    }

    public Trivia m9293b(JSONObject jSONObject) {
        String str;
        User user;
        String str2 = null;
        String string = jSONObject.getString("text");
        if (jSONObject.isNull("type")) {
            str = null;
        } else {
            str = jSONObject.getString("type");
        }
        if (jSONObject.isNull("source_user")) {
            user = null;
        } else {
            JSONObject jSONObject2 = jSONObject.getJSONObject("source_user");
            user = new User(jSONObject2.getInt("id"), jSONObject2.getString("nick"));
        }
        if (!jSONObject.isNull("source_name")) {
            str2 = jSONObject.getString("source_name");
        }
        return new Trivia(string, str, user, str2);
    }
}
