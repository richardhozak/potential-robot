package cz.csfd.csfdroid.data.store;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class CsfdroidProvider extends ContentProvider {
    private static UriMatcher f4701a = new UriMatcher(-1);
    private C2035b f4702b;

    static {
        f4701a.addURI("cz.csfd.csfdroid", "cinemas/favourite", 1);
        f4701a.addURI("cz.csfd.csfdroid", "cinemas/favourite/#", 2);
    }

    public boolean onCreate() {
        this.f4702b = new C2035b(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        SQLiteDatabase writableDatabase = this.f4702b.getWritableDatabase();
        switch (f4701a.match(uri)) {
            case 1:
                str3 = str;
                break;
            case 2:
                long parseId = ContentUris.parseId(uri);
                if (!TextUtils.isEmpty(str)) {
                    str3 = str + " AND _id=" + parseId;
                    break;
                }
                str3 = "_id=" + parseId;
                break;
            default:
                throw new IllegalArgumentException("Unknown content uri: " + uri.toString());
        }
        return writableDatabase.query("favourite_cinemas", strArr, str3, strArr2, null, null, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f4702b.getWritableDatabase();
        switch (f4701a.match(uri)) {
            case 1:
                break;
            case 2:
                long parseId = ContentUris.parseId(uri);
                if (!TextUtils.isEmpty(str)) {
                    str = str + " AND _id=" + parseId;
                    break;
                }
                str = "_id=" + parseId;
                break;
            default:
                throw new IllegalArgumentException("Unknown content uri: " + uri.toString());
        }
        int update = writableDatabase.update("favourite_cinemas", contentValues, str, strArr);
        if (update > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return update;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f4702b.getWritableDatabase();
        switch (f4701a.match(uri)) {
            case 1:
                long insert = writableDatabase.insert("favourite_cinemas", null, contentValues);
                if (insert < 0) {
                    return null;
                }
                Uri build = ContentUris.appendId(uri.buildUpon(), insert).build();
                getContext().getContentResolver().notifyChange(build, null);
                return build;
            default:
                throw new IllegalArgumentException("Unknown content uri: " + uri.toString());
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f4702b.getWritableDatabase();
        switch (f4701a.match(uri)) {
            case 1:
                break;
            case 2:
                long parseId = ContentUris.parseId(uri);
                if (!TextUtils.isEmpty(str)) {
                    str = str + " AND _id=" + parseId;
                    break;
                }
                str = "_id=" + parseId;
                break;
            default:
                throw new IllegalArgumentException("Unknown content uri: " + uri.toString());
        }
        int delete = writableDatabase.delete("favourite_cinemas", str, strArr);
        if (delete > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return delete;
    }

    public String getType(Uri uri) {
        switch (f4701a.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/cz.csfd.csfdroid.favourite_cinemas";
            case 2:
                return "vnd.android.cursor.item/cz.csfd.csfdroid.favourite_cinemas";
            default:
                throw new IllegalArgumentException("Unknown content uri: " + uri.toString());
        }
    }
}
