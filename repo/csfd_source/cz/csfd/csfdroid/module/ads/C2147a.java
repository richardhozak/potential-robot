package cz.csfd.csfdroid.module.ads;

import android.content.Context;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.C2024a;
import java.util.HashMap;

/* compiled from: AdsModule */
public interface C2147a {

    /* compiled from: AdsModule */
    public interface C2139a extends C1945a<C2024a> {
        void mo3443b();

        void mo3444c();
    }

    /* compiled from: AdsModule */
    public enum C2146b {
        HOME("Home"),
        RELEASES("Releases"),
        TV("Tv"),
        CINEMAS("Cinema"),
        CHARTS("Charts"),
        FILM("Film"),
        CREATOR("Creator"),
        SEARCH("Search"),
        FAVORITES("Favorites"),
        WATCHLIST("Watchlist"),
        USER("User"),
        VIDEOS("Videos"),
        MESSAGES("Messages");
        
        private String f5177n;

        private C2146b(String str) {
            this.f5177n = str;
        }

        public String m7622a() {
            return this.f5177n;
        }
    }

    C2011b mo3445a(C2016c c2016c, Context context);

    C2011b mo3446a(C2146b c2146b, HashMap<String, String> hashMap, C2139a c2139a, C2016c c2016c, Context context);

    void mo3447a(C2016c c2016c, Context context, C2057e c2057e);

    void mo3448a(boolean z);

    boolean mo3449a();

    C2011b mo3450b(C2146b c2146b, HashMap<String, String> hashMap, C2139a c2139a, C2016c c2016c, Context context);
}
