package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityOperation;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FavoritesJsonHelper */
public class C2502g {
    public List<ActivityEntity> m9249a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("activity");
        List<ActivityEntity> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m9248a(jSONArray.getJSONObject(i), i));
        }
        return arrayList;
    }

    ActivityEntity m9248a(JSONObject jSONObject, int i) {
        ActivityEntity activityEntity = new ActivityEntity(i);
        activityEntity.m6709a(ActivityType.valueOf(jSONObject.getString("type").toUpperCase()));
        activityEntity.m6708a(ActivityOperation.valueOf(jSONObject.getString("operation").toUpperCase()));
        try {
            activityEntity.m6712a(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString("inserted_datetime").substring(0, 19)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        activityEntity.m6711a(C2513q.m9297a(jSONObject.getJSONObject("user")));
        if (!jSONObject.isNull("rating")) {
            activityEntity.m6707a(jSONObject.getInt("rating"));
        }
        if (!jSONObject.isNull("film")) {
            activityEntity.m6710a(new C2508m().m9278a(jSONObject.getJSONObject("film")));
        }
        return activityEntity;
    }
}
