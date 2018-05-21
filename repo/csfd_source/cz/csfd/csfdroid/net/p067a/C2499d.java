package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Comment;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommentJsonHelper */
public class C2499d {
    public List<Comment> m9219a(JSONObject jSONObject) {
        List<Comment> arrayList = new ArrayList();
        if (jSONObject.has("comments") && !jSONObject.isNull("comments")) {
            JSONArray jSONArray = jSONObject.getJSONArray("comments");
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    arrayList.add(m9218b(jSONArray.getJSONObject(i)));
                }
            }
        }
        return arrayList;
    }

    private Comment m9218b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("user");
        User user = new User(jSONObject2.getInt("id"), jSONObject2.getString("nick"));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString("inserted_datetime"));
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        int i = -1;
        if (!jSONObject.isNull("rating")) {
            i = jSONObject.getInt("rating");
        }
        Comment comment = new Comment(user, i, jSONObject.getString("text"), date);
        if (!jSONObject.isNull("is_rating_computed")) {
            comment.m6781a(jSONObject.getBoolean("is_rating_computed"));
        }
        return comment;
    }
}
