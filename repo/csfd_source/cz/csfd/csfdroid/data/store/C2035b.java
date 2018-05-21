package cz.csfd.csfdroid.data.store;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: CsfdroidSqliteHelper */
public class C2035b extends SQLiteOpenHelper {
    public C2035b(Context context) {
        super(context, "csfdroid.db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ").append("favourite_cinemas").append("(");
        stringBuilder.append("_id").append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        stringBuilder.append("name").append(" TEXT,");
        stringBuilder.append("address").append(" TEXT,");
        stringBuilder.append("cinema_id").append(" INTEGER");
        stringBuilder.append(")");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
