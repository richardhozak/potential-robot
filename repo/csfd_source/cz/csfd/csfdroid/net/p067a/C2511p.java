package cz.csfd.csfdroid.net.p067a;

import android.net.Uri;
import android.text.TextUtils;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.TvMovie;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TvTipsJsonHelper */
public class C2511p {
    public List<C2030g> m9295a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("tips");
        List<C2030g> arrayList = new ArrayList();
        C2508m c2508m = new C2508m();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            long a = m9294a(jSONObject2.getString("start_datetime"));
            if (a > 0) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("station");
                String string = jSONObject3.getString("name");
                Object string2 = jSONObject3.getString("logo_url");
                MovieInfo b = c2508m.m9280b(jSONObject2.getJSONObject("film"));
                b.m6921a(new TvProgramm(string, new Date(a)));
                arrayList.add(new C2030g(a, string, TextUtils.isEmpty(string2) ? null : Uri.parse(string2), b));
            }
        }
        return arrayList;
    }

    public List<TvStation> m9296b(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("stations");
        List<TvStation> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            TvStation tvStation = new TvStation();
            tvStation.m7062a(jSONObject2.getInt("id"));
            tvStation.m7064a(jSONObject2.getString("name"));
            tvStation.m7067b(jSONObject2.getString("logo_url"));
            if (jSONObject2.has("selected")) {
                tvStation.m7065a(jSONObject2.getBoolean("selected"));
            }
            if (jSONObject2.has("schedule")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("schedule");
                C2508m c2508m = new C2508m();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("film");
                    TvMovie tvMovie = new TvMovie();
                    tvMovie.m7047a(c2508m.m9278a(jSONObject4));
                    tvMovie.m7046a(jSONObject3.getInt("length_minutes"));
                    tvMovie.m7048a(new Date(m9294a(jSONObject3.getString("start_datetime"))));
                    tvMovie.m7050b(new Date(m9294a(jSONObject3.getString("end_datetime"))));
                    tvStation.m7063a(tvMovie);
                }
            }
            arrayList.add(tvStation);
        }
        return arrayList;
    }

    private long m9294a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            return 0;
        }
    }
}
