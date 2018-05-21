package cz.csfd.csfdroid.data.store.cache;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2037a;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2038b;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2039c;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2040d;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2041e;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2045i;
import cz.csfd.csfdroid.data.store.cache.C2047a.C2046j;

public class PersistentCacheProvider extends ContentProvider {
    public static final Uri f4705a = Uri.parse("content://cz.csfd.csfdroid.cache");
    public static final Uri f4706b = Uri.parse("content://cz.csfd.csfdroid.cache/movies");
    public static final Uri f4707c = Uri.parse("content://cz.csfd.csfdroid.cache/movies/movie");
    public static final Uri f4708d = Uri.parse("content://cz.csfd.csfdroid.cache/movies/movie/video");
    public static final Uri f4709e = Uri.parse("content://cz.csfd.csfdroid.cache/movies/movie/video/resolution");
    public static final Uri f4710f = Uri.parse("content://cz.csfd.csfdroid.cache/movies/movie/video/subtitles");
    public static final Uri f4711g = Uri.parse("content://cz.csfd.csfdroid.cache/favorites_activity");
    public static final Uri f4712h = Uri.parse("content://cz.csfd.csfdroid.cache/home/date");
    private static final UriMatcher f4713k = new UriMatcher(-1);
    private C2050c f4714i;
    private SQLiteDatabase f4715j;

    static {
        f4713k.addURI("cz.csfd.csfdroid.cache", f4706b.getPath().substring(1), 1);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4707c.getPath().substring(1), 2);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4708d.getPath().substring(1), 3);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4709e.getPath().substring(1), 4);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4710f.getPath().substring(1), 5);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4711g.getPath().substring(1), 6);
        f4713k.addURI("cz.csfd.csfdroid.cache", f4712h.getPath().substring(1), 7);
    }

    public boolean onCreate() {
        this.f4714i = new C2050c(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.f4715j == null) {
            this.f4715j = this.f4714i.getReadableDatabase();
        }
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f4713k.match(uri)) {
            case 1:
                sQLiteQueryBuilder.setTables("movie_list JOIN movie_list_movie ON (" + C2040d._ID.m7121a() + " = " + C2041e.MOVIE_LIST_ID.m7123a() + ") JOIN " + "movie" + " ON (" + C2041e.MOVIE_ID.m7123a() + " = " + C2039c._ID.m7119a() + ") LEFT JOIN " + "tv_programm" + " ON (" + C2039c._ID.m7119a() + " = " + C2045i.MOVIE_ID.m7128a() + ")");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, C2039c.CSFD_ID.m7119a(), null, str2);
            case 3:
                sQLiteQueryBuilder.setTables("movie_video");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, null, null, str2);
            case 4:
                sQLiteQueryBuilder.setTables("movie_video_resolutions");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, null, null, str2);
            case 5:
                sQLiteQueryBuilder.setTables("movie_video_subtitles");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, null, null, str2);
            case 6:
                sQLiteQueryBuilder.setTables("favorites_activity JOIN movie ON (" + C2037a.MOVIE_ID.m7115a() + " = " + C2039c._ID.m7119a() + ") JOIN " + "user" + " ON (" + C2037a.USER_ID.m7115a() + " = " + C2046j._ID.m7131a() + ")");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, C2037a.INSERTED_DATETIME.m7115a(), null, str2);
            case 7:
                sQLiteQueryBuilder.setTables("movie_list JOIN home_list_cache ON(" + C2040d._ID.m7121a() + " = " + C2038b.MOVIE_LIST_ID.m7117a() + ")");
                return sQLiteQueryBuilder.query(this.f4715j, strArr, str, strArr2, C2040d._ID.m7121a(), null, str2);
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri.toString());
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (this.f4715j == null || this.f4715j.isReadOnly()) {
            this.f4715j = this.f4714i.getWritableDatabase();
        }
        int delete;
        switch (f4713k.match(uri)) {
            case 1:
                if (m7112a(str, strArr) < 0) {
                    return 0;
                }
                this.f4715j.beginTransaction();
                try {
                    delete = this.f4715j.delete("movie_list", str, strArr);
                    this.f4715j.setTransactionSuccessful();
                    return delete;
                } finally {
                    this.f4715j.endTransaction();
                }
            case 6:
                this.f4715j.beginTransaction();
                try {
                    delete = this.f4715j.delete("favorites_activity", str, strArr);
                    this.f4715j.setTransactionSuccessful();
                    return delete;
                } finally {
                    this.f4715j.endTransaction();
                }
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri.toString());
        }
    }

    private int m7112a(String str, String[] strArr) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("movie_list");
        Cursor query = sQLiteQueryBuilder.query(this.f4715j, new String[]{C2040d._ID.m7121a()}, str, strArr, null, null, null);
        try {
            int i;
            if (query.moveToFirst()) {
                i = query.getInt(query.getColumnIndexOrThrow(C2040d._ID.m7122b()));
            } else {
                i = -1;
            }
            query.close();
            return i;
        } catch (Throwable th) {
            query.close();
        }
    }

    public String getType(Uri uri) {
        switch (f4713k.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/vnd.cz.csfd.csfdroid.cache.homelist";
            case 7:
                return "vnd.android.cursor.item/vnd.cz.csfd.csfdroid.cache.date";
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (this.f4715j == null || this.f4715j.isReadOnly()) {
            this.f4715j = this.f4714i.getWritableDatabase();
        }
        ContentValues contentValues2;
        ContentValues contentValues3;
        long a;
        long longValue;
        Uri withAppendedId;
        switch (f4713k.match(uri)) {
            case 1:
                return ContentUris.withAppendedId(f4706b, this.f4715j.insert("movie_list", null, contentValues));
            case 2:
                contentValues2 = new ContentValues(contentValues);
                contentValues2.remove(C2040d._ID.m7122b());
                contentValues2.remove(C2041e.ORDER_IN_LIST.m7124b());
                contentValues3 = new ContentValues();
                boolean containsKey = contentValues2.containsKey(C2045i.DATE.m7129b());
                if (containsKey) {
                    contentValues2.remove(C2045i.DATE.m7129b());
                    contentValues2.remove(C2045i.STATION.m7129b());
                    contentValues3.put(C2045i.DATE.m7129b(), contentValues.getAsLong(C2045i.DATE.m7129b()));
                    contentValues3.put(C2045i.STATION.m7129b(), contentValues.getAsString(C2045i.STATION.m7129b()));
                }
                this.f4715j.beginTransaction();
                try {
                    a = m7113a(contentValues2);
                    if (a < 0) {
                        throw new SQLException("Failed to insert row into " + uri);
                    }
                    if (containsKey) {
                        contentValues3.put(C2045i.MOVIE_ID.m7129b(), Long.valueOf(a));
                        this.f4715j.insert("tv_programm", null, contentValues3);
                    }
                    longValue = contentValues.getAsLong(C2040d._ID.m7122b()).longValue();
                    int intValue = contentValues.getAsInteger(C2041e.ORDER_IN_LIST.m7124b()).intValue();
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put(C2041e.MOVIE_LIST_ID.m7124b(), Long.valueOf(longValue));
                    contentValues4.put(C2041e.MOVIE_ID.m7124b(), Long.valueOf(a));
                    contentValues4.put(C2041e.ORDER_IN_LIST.m7124b(), Integer.valueOf(intValue));
                    this.f4715j.insert("movie_list_movie", null, contentValues4);
                    this.f4715j.setTransactionSuccessful();
                    withAppendedId = ContentUris.withAppendedId(f4707c, a);
                    return withAppendedId;
                } finally {
                    this.f4715j.endTransaction();
                }
            case 3:
                return ContentUris.withAppendedId(f4708d, this.f4715j.insert("movie_video", null, contentValues));
            case 4:
                return ContentUris.withAppendedId(f4709e, this.f4715j.insert("movie_video_resolutions", null, contentValues));
            case 5:
                return ContentUris.withAppendedId(f4710f, this.f4715j.insert("movie_video_subtitles", null, contentValues));
            case 6:
                contentValues2 = new ContentValues(contentValues);
                contentValues2.remove(C2037a.TYPE.m7116b());
                contentValues2.remove(C2037a.OPERATION.m7116b());
                contentValues2.remove(C2037a.INSERTED_DATETIME.m7116b());
                contentValues2.remove(C2037a.RATING.m7116b());
                contentValues2.remove(C2046j.USER_ID.m7132b());
                contentValues2.remove(C2046j.NICK.m7132b());
                contentValues2.remove(C2046j.AVATAR_URL.m7132b());
                contentValues2.remove(C2046j.GENDER_ID.m7132b());
                contentValues3 = new ContentValues(contentValues);
                contentValues3.remove(C2039c.CSFD_ID.m7120b());
                contentValues3.remove(C2039c.COLOR.m7120b());
                contentValues3.remove(C2039c.TYPE.m7120b());
                contentValues3.remove(C2039c.NAME.m7120b());
                contentValues3.remove(C2039c.YEAR.m7120b());
                contentValues3.remove(C2039c.POSTER_URL.m7120b());
                contentValues3.remove(C2046j.USER_ID.m7132b());
                contentValues3.remove(C2046j.NICK.m7132b());
                contentValues3.remove(C2046j.AVATAR_URL.m7132b());
                contentValues3.remove(C2046j.GENDER_ID.m7132b());
                ContentValues contentValues5 = new ContentValues(contentValues);
                contentValues5.remove(C2039c.CSFD_ID.m7120b());
                contentValues5.remove(C2039c.COLOR.m7120b());
                contentValues5.remove(C2039c.RATING.m7120b());
                contentValues5.remove(C2039c.GENRE.m7120b());
                contentValues5.remove(C2039c.ORIGIN.m7120b());
                contentValues5.remove(C2039c.TYPE.m7120b());
                contentValues5.remove(C2039c.NAME.m7120b());
                contentValues5.remove(C2039c.RELEASE_DATE.m7120b());
                contentValues5.remove(C2039c.YEAR.m7120b());
                contentValues5.remove(C2039c.POSTER_URL.m7120b());
                contentValues5.remove(C2037a.TYPE.m7116b());
                contentValues5.remove(C2037a.OPERATION.m7116b());
                contentValues5.remove(C2037a.INSERTED_DATETIME.m7116b());
                contentValues5.remove(C2037a.RATING.m7116b());
                this.f4715j.beginTransaction();
                try {
                    a = m7113a(contentValues2);
                    if (a < 0) {
                        throw new SQLException("Failed to insert row into " + uri);
                    }
                    long b = m7114b(contentValues5);
                    if (b < 0) {
                        throw new SQLException("Failed to insert row into " + uri);
                    }
                    contentValues3.put(C2037a.USER_ID.m7116b(), Long.valueOf(b));
                    contentValues3.put(C2037a.MOVIE_ID.m7116b(), Long.valueOf(a));
                    longValue = this.f4715j.insert("favorites_activity", null, contentValues3);
                    if (longValue < 0) {
                        throw new SQLException("Failed to insert row into " + uri);
                    }
                    this.f4715j.setTransactionSuccessful();
                    withAppendedId = ContentUris.withAppendedId(f4711g, longValue);
                    return withAppendedId;
                } finally {
                    this.f4715j.endTransaction();
                }
            case 7:
                return ContentUris.withAppendedId(f4712h, this.f4715j.insert("home_list_cache", null, contentValues));
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri.toString());
        }
    }

    private long m7113a(ContentValues contentValues) {
        long j;
        Integer asInteger = contentValues.getAsInteger(C2039c.CSFD_ID.m7120b());
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("movie");
        String str = C2039c.CSFD_ID.m7119a() + "=?";
        String[] strArr = new String[]{String.valueOf(asInteger)};
        Cursor query = sQLiteQueryBuilder.query(this.f4715j, new String[]{C2039c._ID.m7119a(), C2039c.CSFD_ID.m7119a()}, str, strArr, null, null, null);
        if (query.moveToFirst()) {
            j = query.getLong(query.getColumnIndexOrThrow(C2039c._ID.m7120b()));
            this.f4715j.update("movie", contentValues, str, strArr);
        } else {
            j = this.f4715j.insert("movie", null, contentValues);
        }
        query.close();
        return j;
    }

    private long m7114b(ContentValues contentValues) {
        long j;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("user");
        String str = C2046j.USER_ID + " = ?";
        String[] strArr = new String[]{String.valueOf(contentValues.getAsInteger(C2046j.USER_ID.m7132b()))};
        Cursor query = sQLiteQueryBuilder.query(this.f4715j, new String[]{C2046j._ID.m7131a(), C2046j.USER_ID.m7131a()}, str, strArr, null, null, null);
        if (query.moveToFirst()) {
            j = query.getLong(query.getColumnIndexOrThrow(C2046j._ID.m7132b()));
            this.f4715j.update("user", contentValues, str, strArr);
        } else {
            j = this.f4715j.insert("user", null, contentValues);
        }
        query.close();
        return j;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
