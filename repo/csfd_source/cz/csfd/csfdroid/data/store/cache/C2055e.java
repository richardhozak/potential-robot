package cz.csfd.csfdroid.data.store.cache;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityOperation;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityType;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieInfo.Category;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.Photo;
import cz.csfd.csfdroid.data.entity.TvProgramm;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Gender;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2037a;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2038b;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2039c;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2040d;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2041e;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2042f;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2043g;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2044h;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2045i;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2046j;
import cz.csfd.csfdroid.p059b.C1962a;
import cz.csfd.csfdroid.p061d.C1992n;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PersistentHomeListCache */
public class C2055e {
    private static final String[] f4818a = new String[]{C2039c.CSFD_ID.m7120b(), C2039c.COLOR.m7120b(), C2039c.RATING.m7120b(), C2039c.GENRE.m7120b(), C2039c.ORIGIN.m7120b(), C2039c.NAME.m7120b(), C2039c.RELEASE_DATE.m7120b(), C2039c.TYPE.m7120b(), C2039c.YEAR.m7120b(), C2045i.DATE.m7129b() + " AS " + C2045i.DATE.m7130c(), C2045i.STATION.m7129b() + " AS " + C2045i.STATION.m7130c(), C2039c.POSTER_URL.m7120b()};
    private static final String f4819b = C2041e.ORDER_IN_LIST.m7123a();
    private static final String[] f4820c = new String[]{C2038b.LAST_STORED_DATE.m7118b()};
    private static final String f4821d = (C2040d.KEY.m7121a() + "=?");
    private final Context f4822e;

    public C2055e(Context context) {
        this.f4822e = context;
    }

    public void m7158a(String str, List<? extends BasicEntity> list) {
        ContentProviderClient acquireContentProviderClient = this.f4822e.getContentResolver().acquireContentProviderClient(PersistentCacheProvider.f4705a);
        try {
            acquireContentProviderClient.delete(PersistentCacheProvider.f4706b, f4821d, new String[]{str});
            if (str.equals("favorites")) {
                acquireContentProviderClient.delete(PersistentCacheProvider.f4711g, null, null);
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        try {
            long a = m7143a(str, acquireContentProviderClient);
            if (str.equals("favorites")) {
                m7152a((List) list, acquireContentProviderClient);
            } else {
                m7151a(list, a, acquireContentProviderClient);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(C2038b.MOVIE_LIST_ID.m7118b(), Long.valueOf(a));
            contentValues.put(C2038b.LAST_STORED_DATE.m7118b(), Long.valueOf(new Date().getTime()));
            acquireContentProviderClient.insert(PersistentCacheProvider.f4712h, contentValues);
        } catch (Exception e2) {
            C1998s.m6371a(getClass(), e2);
        } finally {
            acquireContentProviderClient.release();
        }
    }

    private long m7143a(String str, ContentProviderClient contentProviderClient) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C2040d.KEY.m7122b(), str);
        return ContentUris.parseId(contentProviderClient.insert(PersistentCacheProvider.f4706b, contentValues));
    }

    private void m7152a(List<ActivityEntity> list, ContentProviderClient contentProviderClient) {
        for (ActivityEntity activityEntity : list) {
            ContentValues contentValues = new ContentValues();
            m7149a(contentValues, activityEntity);
            contentProviderClient.insert(PersistentCacheProvider.f4711g, contentValues);
        }
    }

    private void m7151a(List<MovieInfo> list, long j, ContentProviderClient contentProviderClient) {
        int i = 0;
        for (MovieInfo movieInfo : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C2040d._ID.m7122b(), Long.valueOf(j));
            int i2 = i + 1;
            contentValues.put(C2041e.ORDER_IN_LIST.m7124b(), Integer.valueOf(i));
            m7150a(contentValues, movieInfo);
            m7156b(contentValues, movieInfo);
            m7148a(contentProviderClient, movieInfo);
            contentProviderClient.insert(PersistentCacheProvider.f4707c, contentValues);
            i = i2;
        }
    }

    private void m7148a(ContentProviderClient contentProviderClient, MovieInfo movieInfo) {
        MovieVideo Y = movieInfo.m6915Y();
        if (Y != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C2042f.MOVIE_ID.m7125a(), Integer.valueOf(movieInfo.m6705g()));
            contentValues.put(C2042f.IS_HOMEPAGE_TRAILER.m7125a(), Integer.valueOf(1));
            contentValues.put(C2042f.NAME.m7125a(), Y.m7001a());
            contentValues.put(C2042f.THUMBNAIL.m7125a(), Y.m7006d().m7010a());
            contentValues.put(C2042f.THUMBNAIL_WIDTH.m7125a(), Integer.valueOf(Y.m7006d().m7013b()));
            contentValues.put(C2042f.THUMBNAIL_HEIGHT.m7125a(), Integer.valueOf(Y.m7006d().m7016c()));
            Uri insert = contentProviderClient.insert(PersistentCacheProvider.f4708d, contentValues);
            for (Entry entry : Y.m7004b().m7000a().entrySet()) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(C2043g.MOVIE_VIDEO_ID.m7126a(), Long.valueOf(ContentUris.parseId(insert)));
                contentValues2.put(C2043g.RESOLUTION.m7126a(), (String) entry.getKey());
                contentValues2.put(C2043g.URL.m7126a(), (String) entry.getValue());
                contentProviderClient.insert(PersistentCacheProvider.f4709e, contentValues2);
            }
            for (Entry entry2 : Y.m7005c()) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put(C2044h.MOVIE_VIDEO_ID.m7127a(), Long.valueOf(ContentUris.parseId(insert)));
                contentValues3.put(C2044h.LANGUAGE.m7127a(), (String) entry2.getKey());
                contentValues3.put(C2044h.URL.m7127a(), (String) entry2.getValue());
                contentProviderClient.insert(PersistentCacheProvider.f4710f, contentValues3);
            }
        }
    }

    private void m7150a(ContentValues contentValues, MovieInfo movieInfo) {
        contentValues.put(C2039c.CSFD_ID.m7120b(), Integer.valueOf(movieInfo.m6705g()));
        contentValues.put(C2039c.COLOR.m7120b(), Integer.valueOf(movieInfo.m6916Z().m6890a()));
        contentValues.put(C2039c.RATING.m7120b(), Integer.valueOf(movieInfo.m6941e()));
        contentValues.put(C2039c.GENRE.m7120b(), C1992n.m6356a(movieInfo.m6997x(), ";"));
        contentValues.put(C2039c.ORIGIN.m7120b(), C1992n.m6352a(movieInfo, ";"));
        contentValues.put(C2039c.TYPE.m7120b(), movieInfo.m6893C());
        contentValues.put(C2039c.NAME.m7120b(), movieInfo.m6917a());
        Date ae = movieInfo.ae();
        if (ae != null) {
            contentValues.put(C2039c.RELEASE_DATE.m7120b(), Long.valueOf(ae.getTime()));
        }
        contentValues.put(C2039c.YEAR.m7120b(), Integer.valueOf(movieInfo.m6965j()));
        contentValues.put(C2039c.POSTER_URL.m7120b(), movieInfo.m6936d());
    }

    private void m7156b(ContentValues contentValues, MovieInfo movieInfo) {
        if (!movieInfo.ad().isEmpty()) {
            TvProgramm a = m7144a(movieInfo);
            contentValues.put(C2045i.DATE.m7129b(), Long.valueOf(a.m7057c().getTime()));
            contentValues.put(C2045i.STATION.m7129b(), a.m7053a());
        }
    }

    private void m7149a(ContentValues contentValues, ActivityEntity activityEntity) {
        contentValues.put(C2037a.TYPE.m7116b(), Integer.valueOf(activityEntity.m6706a().m6703a()));
        contentValues.put(C2037a.OPERATION.m7116b(), Integer.valueOf(activityEntity.m6713b().m6701a()));
        contentValues.put(C2037a.INSERTED_DATETIME.m7116b(), Long.valueOf(activityEntity.m6714c().getTime()));
        contentValues.put(C2037a.RATING.m7116b(), Integer.valueOf(activityEntity.m6716e()));
        contentValues.put(C2046j.USER_ID.m7132b(), Integer.valueOf(activityEntity.m6715d().m6705g()));
        contentValues.put(C2046j.NICK.m7132b(), activityEntity.m6715d().m6811b());
        contentValues.put(C2046j.AVATAR_URL.m7132b(), activityEntity.m6715d().m6817d());
        Gender l = activityEntity.m6715d().m6827l();
        if (l != null) {
            contentValues.put(C2046j.GENDER_ID.m7132b(), Integer.valueOf(l.m7072a()));
        }
        MovieInfo f = activityEntity.m6717f();
        contentValues.put(C2039c.CSFD_ID.m7120b(), Integer.valueOf(f.m6705g()));
        contentValues.put(C2039c.COLOR.m7120b(), Integer.valueOf(f.m6916Z().m6890a()));
        contentValues.put(C2039c.TYPE.m7120b(), f.m6893C());
        contentValues.put(C2039c.NAME.m7120b(), f.m6917a());
        contentValues.put(C2039c.YEAR.m7120b(), Integer.valueOf(f.m6965j()));
        contentValues.put(C2039c.POSTER_URL.m7120b(), f.m6936d());
    }

    private TvProgramm m7144a(MovieInfo movieInfo) {
        TvProgramm tvProgramm = (TvProgramm) movieInfo.ad().get(0);
        TvProgramm tvProgramm2 = tvProgramm;
        for (TvProgramm tvProgramm3 : movieInfo.ad()) {
            if (tvProgramm3.m7057c().compareTo(tvProgramm2.m7057c()) >= 0) {
                tvProgramm3 = tvProgramm2;
            }
            tvProgramm2 = tvProgramm3;
        }
        return tvProgramm2;
    }

    public List<? extends BasicEntity> m7157a(String str) {
        List<? extends BasicEntity> a;
        ContentProviderClient acquireContentProviderClient = this.f4822e.getContentResolver().acquireContentProviderClient(PersistentCacheProvider.f4705a);
        try {
            if (str.equals("favorites")) {
                a = m7146a(acquireContentProviderClient);
                return a;
            }
            a = m7154b(str, acquireContentProviderClient);
            acquireContentProviderClient.release();
            return a;
        } catch (RemoteException e) {
            a = e;
            C1998s.m6371a(getClass(), (Exception) a);
            return Collections.emptyList();
        } finally {
            acquireContentProviderClient.release();
        }
    }

    private List<ActivityEntity> m7146a(ContentProviderClient contentProviderClient) {
        List<ActivityEntity> arrayList = new ArrayList();
        Cursor query = contentProviderClient.query(PersistentCacheProvider.f4711g, null, null, null, C2037a.INSERTED_DATETIME.m7116b() + " DESC");
        if (query != null) {
            if (query.moveToFirst()) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow(C2039c.CSFD_ID.m7120b());
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow(C2039c.COLOR.m7120b());
                int columnIndexOrThrow3 = query.getColumnIndexOrThrow(C2039c.NAME.m7120b());
                int columnIndexOrThrow4 = query.getColumnIndexOrThrow(C2039c.TYPE.m7120b());
                int columnIndexOrThrow5 = query.getColumnIndexOrThrow(C2039c.YEAR.m7120b());
                int columnIndexOrThrow6 = query.getColumnIndexOrThrow(C2039c.POSTER_URL.m7120b());
                int columnIndexOrThrow7 = query.getColumnIndexOrThrow(C2037a.TYPE.m7116b());
                int columnIndexOrThrow8 = query.getColumnIndexOrThrow(C2037a.OPERATION.m7116b());
                int columnIndexOrThrow9 = query.getColumnIndexOrThrow(C2037a.INSERTED_DATETIME.m7116b());
                int columnIndexOrThrow10 = query.getColumnIndexOrThrow(C2037a.RATING.m7116b());
                int columnIndexOrThrow11 = query.getColumnIndexOrThrow(C2046j.USER_ID.m7132b());
                int columnIndexOrThrow12 = query.getColumnIndexOrThrow(C2046j.NICK.m7132b());
                int columnIndexOrThrow13 = query.getColumnIndexOrThrow(C2046j.AVATAR_URL.m7132b());
                int columnIndexOrThrow14 = query.getColumnIndexOrThrow(C2046j.GENDER_ID.m7132b());
                do {
                    MovieInfo movieInfo = new MovieInfo(query.getInt(columnIndexOrThrow));
                    movieInfo.m6919a(Category.m6889a(query.getInt(columnIndexOrThrow2)));
                    movieInfo.m6922a(query.getString(columnIndexOrThrow3));
                    movieInfo.m6957h(query.getString(columnIndexOrThrow4));
                    movieInfo.m6932c(query.getInt(columnIndexOrThrow5));
                    movieInfo.m6938d(query.getString(columnIndexOrThrow6));
                    User user = new User(query.getInt(columnIndexOrThrow11));
                    user.m6808a(query.getString(columnIndexOrThrow12));
                    if (!query.isNull(columnIndexOrThrow13)) {
                        user.m6815c(query.getString(columnIndexOrThrow13));
                    }
                    int i = query.getInt(columnIndexOrThrow14);
                    if (i > 0) {
                        user.m6807a(Gender.m7071a(i));
                    }
                    ActivityEntity activityEntity = new ActivityEntity(1);
                    activityEntity.m6709a(ActivityType.m6702a(query.getInt(columnIndexOrThrow7)));
                    activityEntity.m6708a(ActivityOperation.m6700a(query.getInt(columnIndexOrThrow8)));
                    activityEntity.m6712a(new Date(query.getLong(columnIndexOrThrow9)));
                    activityEntity.m6707a(query.getInt(columnIndexOrThrow10));
                    activityEntity.m6711a(user);
                    activityEntity.m6710a(movieInfo);
                    arrayList.add(activityEntity);
                } while (query.moveToNext());
            }
            query.close();
        }
        return arrayList;
    }

    private List<MovieInfo> m7154b(String str, ContentProviderClient contentProviderClient) {
        List<MovieInfo> arrayList = new ArrayList();
        ContentProviderClient contentProviderClient2 = contentProviderClient;
        Cursor query = contentProviderClient2.query(PersistentCacheProvider.f4706b, f4818a, f4821d, new String[]{str}, f4819b);
        if (query != null && query.moveToFirst()) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow(C2039c.CSFD_ID.m7120b());
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow(C2039c.COLOR.m7120b());
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow(C2039c.RATING.m7120b());
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow(C2039c.GENRE.m7120b());
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow(C2039c.ORIGIN.m7120b());
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow(C2039c.NAME.m7120b());
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow(C2039c.RELEASE_DATE.m7120b());
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow(C2039c.TYPE.m7120b());
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow(C2039c.YEAR.m7120b());
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow(C2045i.DATE.m7130c());
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow(C2045i.STATION.m7130c());
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow(C2039c.POSTER_URL.m7120b());
            do {
                MovieInfo movieInfo = new MovieInfo(query.getInt(columnIndexOrThrow));
                movieInfo.m6919a(Category.m6889a(query.getInt(columnIndexOrThrow2)));
                movieInfo.m6918a(query.getInt(columnIndexOrThrow3));
                movieInfo.m6982m(Arrays.asList(query.getString(columnIndexOrThrow4).split(";")));
                movieInfo.m6985n(Arrays.asList(query.getString(columnIndexOrThrow5).split(";")));
                movieInfo.m6922a(query.getString(columnIndexOrThrow6));
                movieInfo.m6957h(query.getString(columnIndexOrThrow8));
                movieInfo.m6932c(query.getInt(columnIndexOrThrow9));
                movieInfo.m6938d(query.getString(columnIndexOrThrow12));
                Date date = new Date(query.getLong(columnIndexOrThrow7));
                if (date.getTime() > 0) {
                    movieInfo.m6924a(date);
                }
                date = new Date(query.getLong(columnIndexOrThrow10));
                if (date.getTime() > 0) {
                    movieInfo.m6921a(new TvProgramm(query.getString(columnIndexOrThrow11), date));
                }
                m7155b(contentProviderClient, movieInfo);
                arrayList.add(movieInfo);
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    private void m7155b(ContentProviderClient contentProviderClient, MovieInfo movieInfo) {
        Cursor query = contentProviderClient.query(PersistentCacheProvider.f4708d, null, C2042f.MOVIE_ID + " = ? AND " + C2042f.IS_HOMEPAGE_TRAILER + " = 1", new String[]{String.valueOf(movieInfo.m6705g())}, null);
        if (query != null) {
            if (query.moveToFirst()) {
                long j = query.getLong(query.getColumnIndex(C2042f._ID.m7125a()));
                String string = query.getString(query.getColumnIndex(C2042f.NAME.m7125a()));
                String string2 = query.getString(query.getColumnIndex(C2042f.THUMBNAIL.m7125a()));
                int i = query.getInt(query.getColumnIndex(C2042f.THUMBNAIL_WIDTH.m7125a()));
                int i2 = query.getInt(query.getColumnIndex(C2042f.THUMBNAIL_HEIGHT.m7125a()));
                Map a = m7147a(contentProviderClient, j);
                List b = m7153b(contentProviderClient, j);
                if (!(a == null || a.isEmpty())) {
                    movieInfo.m6920a(new MovieVideo(1, string, a, new Photo(string2, i, i2), b));
                }
            }
            query.close();
        }
    }

    private Map<String, String> m7147a(ContentProviderClient contentProviderClient, long j) {
        Cursor query = contentProviderClient.query(PersistentCacheProvider.f4709e, null, C2043g.MOVIE_VIDEO_ID + " = ?", new String[]{String.valueOf(j)}, null);
        Map<String, String> hashMap = new HashMap();
        if (query != null) {
            int columnIndex = query.getColumnIndex(C2043g.RESOLUTION.m7126a());
            int columnIndex2 = query.getColumnIndex(C2043g.URL.m7126a());
            while (query.moveToNext()) {
                hashMap.put(query.getString(columnIndex), query.getString(columnIndex2));
            }
            query.close();
        }
        return hashMap;
    }

    private List<Entry<String, String>> m7153b(ContentProviderClient contentProviderClient, long j) {
        Cursor query = contentProviderClient.query(PersistentCacheProvider.f4710f, null, C2044h.MOVIE_VIDEO_ID + " = ?", new String[]{String.valueOf(j)}, null);
        List<Entry<String, String>> arrayList = new ArrayList();
        if (query != null) {
            int columnIndex = query.getColumnIndex(C2044h.LANGUAGE.m7127a());
            int columnIndex2 = query.getColumnIndex(C2044h.URL.m7127a());
            while (query.moveToNext()) {
                arrayList.add(new C1962a(query.getString(columnIndex), query.getString(columnIndex2)));
            }
            query.close();
        }
        return arrayList;
    }

    public boolean m7159b(String str) {
        boolean after;
        Exception e;
        ContentProviderClient acquireContentProviderClient = this.f4822e.getContentResolver().acquireContentProviderClient(PersistentCacheProvider.f4705a);
        try {
            Cursor query = acquireContentProviderClient.query(PersistentCacheProvider.f4712h, f4820c, f4821d, new String[]{str}, null);
            if (query.moveToFirst()) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow(C2038b.LAST_STORED_DATE.m7118b());
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(query.getLong(columnIndexOrThrow));
                after = instance.after(m7145a());
            } else {
                after = false;
            }
            try {
                query.close();
            } catch (RemoteException e2) {
                e = e2;
                C1998s.m6371a(getClass(), e);
                acquireContentProviderClient.release();
                return after;
            }
        } catch (Exception e3) {
            e = e3;
            after = false;
            C1998s.m6371a(getClass(), e);
            acquireContentProviderClient.release();
            return after;
        }
        acquireContentProviderClient.release();
        return after;
    }

    private Calendar m7145a() {
        Calendar instance = Calendar.getInstance();
        instance.set(10, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance;
    }
}
