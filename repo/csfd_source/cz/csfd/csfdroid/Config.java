package cz.csfd.csfdroid;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.AdSize;
import com.h6ah4i.android.compat.p055a.C1792a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2019c;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2020d;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.data.entity.C2025b;
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.data.entity.HomeList;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Config */
public class C2057e {
    private static int f4826c = -1;
    private final String f4827a = "CSFDroid";
    private final String f4828b = "home_refreshed_date";
    private Context f4829d;
    private SharedPreferences f4830e;

    public C2057e(Application application) {
        this.f4829d = application;
        this.f4830e = PreferenceManager.getDefaultSharedPreferences(this.f4829d);
    }

    public List<HomeList> m7176a() {
        List<HomeList> arrayList = new ArrayList();
        arrayList.add(new HomeList("new_videos", this.f4829d.getString(R.string.preferences_home_new_videos), this.f4829d.getString(R.string.preferences_home_new_videos_desc)));
        arrayList.add(new HomeList("favorites", this.f4829d.getString(R.string.preferences_home_favorites), this.f4829d.getString(R.string.preferences_home_favorites_desc)));
        arrayList.add(new HomeList("tv_tips", this.f4829d.getString(R.string.preferences_home_tv_tips), this.f4829d.getString(R.string.preferences_home_tv_tips_desc)));
        arrayList.add(new HomeList("cinema_releases", this.f4829d.getString(R.string.preferences_home_cinema_releases), this.f4829d.getString(R.string.preferences_home_cinema_releases_desc)));
        arrayList.add(new HomeList("favorite_cinemas", this.f4829d.getString(R.string.preferences_home_favorite_cinemas), this.f4829d.getString(R.string.preferences_home_favorite_cinemas_desc)));
        arrayList.add(new HomeList("dvd_releases", this.f4829d.getString(R.string.preferences_home_dvd_releases), this.f4829d.getString(R.string.preferences_home_dvd_releases_desc)));
        arrayList.add(new HomeList("bluray_releases", this.f4829d.getString(R.string.preferences_home_bd_releases), this.f4829d.getString(R.string.preferences_home_bd_releases_desc)));
        arrayList.add(new HomeList("film_profile_visits", this.f4829d.getString(R.string.preferences_home_film_profile_visits), this.f4829d.getString(R.string.preferences_home_film_profile_visits_desc)));
        arrayList.add(new HomeList("creator_profile_visits", this.f4829d.getString(R.string.preferences_home_creator_profile_visits), this.f4829d.getString(R.string.preferences_home_creator_profile_visits_desc)));
        return arrayList;
    }

    public List<HomeList> m7188b() {
        List<HomeList> a = m7176a();
        for (int i = 0; i < a.size(); i++) {
            HomeList homeList = (HomeList) a.get(i);
            String str = "home_" + homeList.m6799a();
            boolean z = this.f4830e.getBoolean(str, false);
            if (!this.f4830e.contains(str)) {
                z = true;
            }
            int i2 = this.f4830e.getInt(str + "_position", i);
            homeList.m6801a(z);
            homeList.m6800a(i2);
        }
        Collections.sort(a);
        return a;
    }

    public void m7186a(List<HomeList> list) {
        Editor edit = this.f4830e.edit();
        for (int i = 0; i < list.size(); i++) {
            HomeList homeList = (HomeList) list.get(i);
            String str = "home_" + homeList.m6799a();
            edit.putBoolean(str, homeList.m6803c());
            edit.putInt(str + "_position", i);
        }
        edit.commit();
    }

    public List<String> m7193c() {
        List<String> arrayList = new ArrayList();
        for (HomeList homeList : m7188b()) {
            if (homeList.m6803c()) {
                arrayList.add(homeList.m6799a());
            }
        }
        arrayList.add("adverts");
        return arrayList;
    }

    public void m7185a(Date date) {
        this.f4830e.edit().putLong("home_refreshed_date", date.getTime()).commit();
    }

    public int m7197d() {
        return this.f4830e.getInt("last_version", 0);
    }

    public void m7177a(int i) {
        this.f4830e.edit().putInt("last_version", i).commit();
    }

    public boolean m7199e() {
        return this.f4830e.getBoolean("first_run", true);
    }

    public void m7200f() {
        this.f4830e.edit().putBoolean("first_run", false).commit();
    }

    public String m7201g() {
        StringBuilder stringBuilder = new StringBuilder("CSFDroid");
        try {
            stringBuilder.append("/").append(this.f4829d.getPackageManager().getPackageInfo(this.f4829d.getPackageName(), 0).versionName);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        stringBuilder.append(" (").append(Build.MODEL).append("; ").append(VERSION.RELEASE).append(" ").append(VERSION.CODENAME).append(")");
        return stringBuilder.toString();
    }

    public void m7178a(long j) {
        this.f4830e.edit().putLong("ad_played_time", j).commit();
    }

    public long m7202h() {
        return this.f4830e.getLong("ad_played_time", 0);
    }

    public void m7189b(long j) {
        this.f4830e.edit().putLong("ad_banner_updated", System.currentTimeMillis()).putLong("ad_banner_next_time", j).apply();
    }

    public long m7203i() {
        return Math.min(this.f4830e.getLong("ad_banner_next_time", 0), this.f4830e.getLong("ad_banner_updated", 0) + 86400000);
    }

    public void m7194c(long j) {
        this.f4830e.edit().putLong("ad_bottom_updated", System.currentTimeMillis()).putLong("ad_bottom_next_time", j).apply();
    }

    public long m7204j() {
        return Math.min(this.f4830e.getLong("ad_bottom_next_time", 0), this.f4830e.getLong("ad_bottom_updated", 0) + 86400000);
    }

    public long m7205k() {
        return Math.min(this.f4830e.getLong("ad_splash_next_time", 0), this.f4830e.getLong("ad_splash_updated", 0) + 86400000);
    }

    public void m7184a(String str) {
        this.f4830e.edit().putString("last_selected_resolution", str).commit();
    }

    public String m7206l() {
        return this.f4830e.getString("last_selected_resolution", null);
    }

    public void m7190b(String str) {
        this.f4830e.edit().putString("last_selected_language", str).commit();
    }

    public String m7207m() {
        return this.f4830e.getString("last_selected_language", null);
    }

    public int m7208n() {
        if (f4826c < 0) {
            f4826c = this.f4830e.getInt("image_cache_size", 25);
        }
        return f4826c;
    }

    public int m7209o() {
        return Integer.valueOf(this.f4830e.getString("subtitles_size", this.f4829d.getString(R.string.subtitles_default_size))).intValue();
    }

    public float m7210p() {
        return Float.valueOf(this.f4830e.getString("text_size", this.f4829d.getString(R.string.text_default_size))).floatValue();
    }

    public void m7195c(String str) {
        this.f4830e.edit().putString("text_size", str).commit();
    }

    public boolean m7211q() {
        return this.f4830e.getBoolean("cinemas_without_schedule", false);
    }

    public void m7187a(boolean z) {
        this.f4830e.edit().putBoolean("cinemas_without_schedule", z).commit();
    }

    public C2019c m7212r() {
        return C2019c.valueOf(this.f4830e.getString("cinemas_time_range", "ALL"));
    }

    public void m7180a(C2019c c2019c) {
        this.f4830e.edit().putString("cinemas_time_range", c2019c.name()).commit();
    }

    public boolean m7213s() {
        return this.f4830e.getBoolean("side_menu_shown", false);
    }

    public void m7191b(boolean z) {
        this.f4830e.edit().putBoolean("side_menu_shown", z).commit();
    }

    public boolean m7214t() {
        return this.f4830e.getBoolean("show_posters", true);
    }

    public List<Chart> m7215u() {
        int i = 0;
        int i2 = this.f4830e.getInt("charts_size", 0);
        List arrayList = new ArrayList();
        while (i < i2) {
            arrayList.add(new Chart(this.f4830e.getString("charts_" + i + "_id", null), this.f4830e.getString("charts_" + i + "_title", null)));
            i++;
        }
        List v = C2057e.m7168v();
        if (arrayList.size() < v.size()) {
            for (i = arrayList.size(); i < v.size(); i++) {
                arrayList.add(v.get(i));
            }
            m7192b(arrayList);
        }
        return arrayList;
    }

    public boolean m7192b(List<Chart> list) {
        m7167H();
        Editor edit = this.f4830e.edit();
        edit.putInt("charts_size", list.size());
        for (int i = 0; i < list.size(); i++) {
            edit.putString("charts_" + i + "_id", ((Chart) list.get(i)).m6718a());
            edit.putString("charts_" + i + "_title", ((Chart) list.get(i)).m6721b());
        }
        edit.putLong("charts_timestamp", Calendar.getInstance().getTimeInMillis());
        return edit.commit();
    }

    private void m7167H() {
        int i = 0;
        Editor edit = this.f4830e.edit();
        int i2 = this.f4830e.getInt("charts_size", 0);
        if (i2 > 0) {
            while (i < i2) {
                edit.remove("charts_" + i + "_id");
                edit.remove("charts_" + i + "_title");
                i++;
            }
        }
        edit.remove("charts_size");
        edit.commit();
    }

    public static List<Chart> m7168v() {
        List<Chart> arrayList = new ArrayList();
        arrayList.add(new Chart("filmsByRatingAverageTop", "Nejlepší filmy"));
        arrayList.add(new Chart("filmsByRatingAverageBottom", "Nejhorší filmy"));
        arrayList.add(new Chart("filmsByFanclub", "Nejoblíbenější filmy"));
        arrayList.add(new Chart("filmsByRatingDeviation", "Nejrozporuplnější filmy"));
        arrayList.add(new Chart("seriesByRatingAverageTop", "Nejlepší seriály"));
        arrayList.add(new Chart("seriesByRatingAverageBottom", "Nejhorší seriály"));
        arrayList.add(new Chart("seriesByFanclub", "Nejoblíbenější seriály"));
        return arrayList;
    }

    public C2020d m7216w() {
        return C2020d.valueOf(this.f4830e.getString("tv_tips_order", "TIME"));
    }

    public void m7181a(C2020d c2020d) {
        this.f4830e.edit().putString("tv_tips_order", c2020d.name()).commit();
    }

    public boolean m7217x() {
        return this.f4830e.getBoolean("tv_tips_update", false);
    }

    public void m7196c(boolean z) {
        this.f4830e.edit().putBoolean("tv_tips_update", z).commit();
    }

    public long m7218y() {
        return this.f4830e.getLong("favorite_cinemas_changed", 0);
    }

    public void m7198d(long j) {
        this.f4830e.edit().putLong("favorite_cinemas_changed", j).commit();
    }

    public String m7219z() {
        return this.f4830e.getString("ad_unit_id", null);
    }

    public AdSize m7169A() {
        String string = this.f4830e.getString("admob_size", null);
        if (AdSize.SMART_BANNER.toString().equals(string)) {
            return AdSize.SMART_BANNER;
        }
        if (AdSize.MEDIUM_RECTANGLE.toString().equals(string)) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        return null;
    }

    public void m7179a(AdSize adSize) {
        this.f4830e.edit().putString("admob_size", adSize != null ? adSize.toString() : null).apply();
    }

    public void m7182a(C2024a c2024a) {
        Editor edit = this.f4830e.edit();
        if (c2024a != null) {
            edit.putString("ad_splash_name", c2024a.m7083a());
            edit.putString("ad_splash_image", c2024a.m7087b());
            edit.putString("ad_splash_url", c2024a.m7090d());
            edit.putInt("ad_splash_duration", c2024a.m7092f());
            edit.putLong("ad_splash_updated", new Date().getTime());
            edit.putLong("ad_splash_timeout", (long) c2024a.m7091e());
            edit.putLong("ad_splash_next_time", new Date().getTime() + ((long) c2024a.m7091e()));
        } else {
            edit.remove("ad_splash_name");
            edit.remove("ad_splash_image");
            edit.remove("ad_splash_url");
            edit.remove("ad_splash_duration");
            edit.remove("ad_splash_updated");
            edit.remove("ad_splash_timeout");
            edit.remove("ad_splash_next_time");
        }
        edit.apply();
    }

    public C2024a m7170B() {
        int i = 0;
        long j = this.f4830e.getLong("ad_splash_updated", 0);
        if (j == 0) {
            return null;
        }
        String string = this.f4830e.getString("ad_splash_name", null);
        String string2 = this.f4830e.getString("ad_splash_image", null);
        String string3 = this.f4830e.getString("ad_splash_url", null);
        int i2 = this.f4830e.getInt("ad_splash_duration", 0);
        long j2 = this.f4830e.getLong("ad_splash_shown", 0);
        C2024a c2024a = new C2024a(string, string2, string3, 0, i2);
        if (new Date().getTime() - j > 86400000 * 7) {
            i = 1;
        }
        long e = ((long) c2024a.m7091e()) + j2;
        if (i != 0 || e > new Date().getTime()) {
            return null;
        }
        return c2024a;
    }

    public void m7171C() {
        this.f4830e.edit().putLong("ad_splash_shown", new Date().getTime()).apply();
    }

    public void m7183a(C2025b c2025b) {
        this.f4830e.edit().putString("ad_unit_id", c2025b.f4678a).putString("home_interstitial_id", c2025b.f4679b).putString("search_interstitial_id", c2025b.f4680c).apply();
    }

    public C2025b m7172D() {
        C2025b c2025b = new C2025b();
        c2025b.f4678a = this.f4830e.getString("ad_unit_id", null);
        c2025b.f4679b = this.f4830e.getString("home_interstitial_id", null);
        c2025b.f4680c = this.f4830e.getString("search_interstitial_id", null);
        return c2025b;
    }

    public void increaseNumberOfLaunches() {
        this.f4830e.edit().putLong("number_of_launches", getNumberOfLaunches() + 1).commit();
    }

    public long getNumberOfLaunches() {
        return this.f4830e.getLong("number_of_launches", 0);
    }

    public Set<String> m7175G() {
        return C1792a.m5539a(this.f4830e, "notifications", new HashSet(Arrays.asList(this.f4829d.getResources().getStringArray(R.array.notifications))));
    }
}
