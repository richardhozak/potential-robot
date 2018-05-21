package cz.csfd.csfdroid.data;

import android.content.Context;
import android.location.Location;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.data.entity.C2025b;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.data.entity.C2031h;
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.Seasons;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.data.entity.WatchlistMovie;
import cz.csfd.csfdroid.module.home.C2284d.Enum_ReleaseType;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: CsfdDataProvider */
public interface CsfdDataProvider {

    /* compiled from: CsfdDataProvider */
    public interface C1945a<T> {
        void mo3322a();

        void mo3323a(Exception exception);

        void mo3324a(T t);
    }

    /* compiled from: CsfdDataProvider */
    public interface C2011b {
        void mo3355a();
    }

    /* compiled from: CsfdDataProvider */
    public enum C2019c {
        TODAY(R.id.menu_item_date_today),
        TOMORROW(R.id.menu_item_date_tomorrow),
        WEEKEND(R.id.menu_item_date_weekend),
        WEEK(R.id.menu_item_date_week),
        MONTH(R.id.menu_item_date_month),
        ALL(R.id.menu_item_date_all);
        
        private int f4616g;

        private C2019c(int i) {
            this.f4616g = i;
        }

        public int m6698a() {
            return this.f4616g;
        }

        public static C2019c m6697a(int i) {
            for (C2019c c2019c : C2019c.values()) {
                if (c2019c.m6698a() == i) {
                    return c2019c;
                }
            }
            return null;
        }
    }

    /* compiled from: CsfdDataProvider */
    public enum Enum_OrderBy {
        TIME("time"),
        RATING("rating");
        
        private String f4620c;

        private Enum_OrderBy(String str) {
            this.f4620c = str;
        }

        public String m6699a() {
            return this.f4620c;
        }
    }

    C2011b mo3357a(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, Context context);

    C2011b mo3358a(int i, C1945a<Object> c1945a);

    C2011b mo3359a(int i, boolean z, C2019c c2019c, C1945a<List<Cinema>> c1945a);

    C2011b mo3360a(Location location, int i, boolean z, C2019c c2019c, C1945a<List<Cinema>> c1945a);

    C2011b mo3361a(C1945a<Identity> c1945a);

    C2011b mo3362a(C1945a<List<ActivityEntity>> c1945a, int i);

    C2011b mo3363a(C1945a<C2024a> c1945a, int i, int i2);

    C2011b mo3364a(C1945a<List<Message>> c1945a, int i, int i2, int i3);

    C2011b mo3365a(C1945a<C2024a> c1945a, int i, int i2, String str, Map<String, String> map);

    C2011b mo3366a(C1945a<Message> c1945a, int i, String str);

    C2011b mo3367a(C1945a<List<C2030g>> c1945a, long j, int i, Enum_OrderBy c2020d);

    C2011b mo3368a(C1945a<List<User>> c1945a, String str, int i);

    C2011b mo3369a(C1945a<List<TvStation>> c1945a, Date date, List<Integer> list, int i, boolean z);

    C2011b mo3370a(C1945a<Boolean> c1945a, List<Integer> list);

    C2011b mo3371a(Chart chart, int i, int i2, C1945a<Chart> c1945a);

    C2011b mo3372a(Cinema cinema, C1945a<Cinema> c1945a);

    C2011b mo3373a(MovieCreator movieCreator, int i, int i2, C1945a<MovieCreator> c1945a);

    C2011b mo3374a(MovieCreator movieCreator, C1945a<MovieCreator> c1945a);

    C2011b mo3375a(MovieInfo movieInfo, int i, int i2, int i3, C1945a<MovieInfo> c1945a);

    C2011b mo3376a(MovieInfo movieInfo, int i, int i2, int i3, C1945a<MovieInfo> c1945a, Context context);

    C2011b mo3377a(MovieInfo movieInfo, int i, int i2, C1945a<MovieInfo> c1945a);

    C2011b mo3378a(MovieInfo movieInfo, C1945a<MovieInfo> c1945a);

    C2011b mo3379a(User user, int i, int i2, C1945a<List<C2028e>> c1945a);

    C2011b mo3380a(User user, C1945a<User> c1945a);

    C2011b mo3381a(User user, Section section, C1945a<List<Object>> c1945a);

    C2011b mo3382a(Enum_ReleaseType c2283b, Date date, C1945a<List<MovieInfo>> c1945a);

    C2011b mo3383a(String str, int i, boolean z, C2019c c2019c, C1945a<Map<String, List<Cinema>>> c1945a);

    C2011b mo3384a(String str, C1945a<Map<String, List<? extends BasicEntity>>> c1945a);

    C2011b mo3385a(List<TvStation> list, C1945a<Boolean> c1945a);

    C2011b mo3386a(List<String> list, C1945a<Map<String, List<? extends BasicEntity>>> c1945a, Context context);

    C2011b mo3387b(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, Context context);

    C2011b mo3388b(int i, C1945a<Object> c1945a);

    C2011b mo3389b(C1945a<List<Chart>> c1945a);

    C2011b mo3390b(C1945a<List<WatchlistMovie>> c1945a, int i);

    C2011b mo3391b(C1945a<List<MessageThread>> c1945a, int i, int i2);

    C2011b mo3392b(C1945a<C2024a> c1945a, int i, int i2, String str, Map<String, String> map);

    C2011b mo3393b(C1945a<Boolean> c1945a, List<String> list);

    C2011b mo3394b(MovieCreator movieCreator, C1945a<MovieCreator> c1945a);

    C2011b mo3395b(MovieInfo movieInfo, int i, int i2, C1945a<MovieInfo> c1945a);

    C2011b mo3396b(MovieInfo movieInfo, C1945a<MovieInfo> c1945a);

    C2011b mo3397b(User user, int i, int i2, C1945a<List<C2028e>> c1945a);

    C2011b mo3398b(String str, C1945a<List<String>> c1945a);

    C2011b mo3399c(int i, C1945a<Object> c1945a);

    C2011b mo3400c(C1945a<List<TvStation>> c1945a);

    C2011b mo3401c(C1945a<Boolean> c1945a, int i);

    C2011b mo3402c(MovieInfo movieInfo, C1945a<MovieInfo> c1945a);

    C2011b mo3403d(int i, C1945a<Object> c1945a);

    C2011b mo3404d(C1945a<C2025b> c1945a);

    C2011b mo3405d(C1945a<Boolean> c1945a, int i);

    C2011b mo3406d(MovieInfo movieInfo, C1945a<MovieInfo> c1945a);

    C2011b mo3407e(C1945a<List<C2031h>> c1945a);

    C2011b mo3408e(C1945a<Seasons> c1945a, int i);

    C2011b mo3409f(C1945a<Integer> c1945a);

    C2011b mo3410g(C1945a<List<User>> c1945a);
}
