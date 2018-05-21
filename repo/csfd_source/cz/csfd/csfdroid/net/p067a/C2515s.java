package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.WatchlistMovie;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WatchlistJsonHelper */
public class C2515s {
    public List<WatchlistMovie> m9311a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("watchlist");
        List<WatchlistMovie> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new WatchlistMovie(new C2508m().m9280b(jSONArray.getJSONObject(i).getJSONObject("film"))));
        }
        return arrayList;
    }
}
