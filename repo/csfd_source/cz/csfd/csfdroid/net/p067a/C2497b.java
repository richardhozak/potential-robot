package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.data.entity.ChartMovie;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChartJsonHelper */
public class C2497b {
    private C2508m f6265a = new C2508m();

    public List<Chart> m9207a(JSONObject jSONObject) {
        List<Chart> arrayList = new ArrayList();
        if (!jSONObject.isNull("charts")) {
            JSONArray jSONArray = jSONObject.getJSONArray("charts");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new Chart(jSONObject2.getString("id"), jSONObject2.getString("title")));
            }
        }
        return arrayList;
    }

    public List<ChartMovie> m9208a(JSONObject jSONObject, int i) {
        List<ChartMovie> arrayList = new ArrayList();
        if (!jSONObject.isNull("chart")) {
            JSONArray jSONArray = jSONObject.getJSONArray("chart");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(m9206b(jSONArray.getJSONObject(i2), (i2 + i) + 1));
            }
        }
        return arrayList;
    }

    private ChartMovie m9206b(JSONObject jSONObject, int i) {
        ChartMovie chartMovie = new ChartMovie(this.f6265a.m9280b(jSONObject), i);
        if (!jSONObject.isNull("rating")) {
            chartMovie.m6726a(jSONObject.getInt("rating"));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("summary");
        chartMovie.m6728b((int) Math.round(jSONObject2.getDouble("rating_average")));
        if (!jSONObject2.isNull("rating_count")) {
            chartMovie.m6730c(jSONObject2.getInt("rating_count"));
        }
        if (!jSONObject2.isNull("fanclub_count")) {
            chartMovie.m6732d(jSONObject2.getInt("fanclub_count"));
        }
        return chartMovie;
    }
}
