package cz.csfd.csfdroid.data.store.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: MovieStoreSqlHelper */
public class C2050c extends SQLiteOpenHelper {
    public C2050c(Context context) {
        super(context, "csfd_movies", null, 4);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m7136a(sQLiteDatabase);
    }

    private void m7136a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE movie (_id INTEGER PRIMARY KEY AUTOINCREMENT,csfd_id INTEGER UNIQUE,name VARCHAR(255),year INTEGER,genre VARCHAR(255),'type' VARCHAR(255),color INTEGER,rating INTEGER, release_date INTEGER, poster_url VARCHAR(255),origin VARCHAR(255))");
        sQLiteDatabase.execSQL("CREATE TABLE movie_video (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_id INTEGER,name VARCHAR(255),is_homepage_trailer INTEGER,thumbnail TEXT,thumbnail_width INTEGER,thumbnail_height INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE movie_video_resolutions (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_video_id INTEGER,resolution VARCHAR(255),url TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE movie_video_subtitles (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_video_id INTEGER,language VARCHAR(255),url TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE tv_programm (_id INTEGER PRIMARY KEY AUTOINCREMENT,station VARCHAR(255),'date' INTEGER,movie_id INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE movie_list (_id INTEGER PRIMARY KEY AUTOINCREMENT,'key' VARCHAR(255) UNIQUE)");
        sQLiteDatabase.execSQL("CREATE TABLE movie_list_movie (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_list_id INTEGER,movie_id INTEGER,order_in_list INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE home_list_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_list_id INTEGER,last_stored_date INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE favorites_activity (_id INTEGER PRIMARY KEY AUTOINCREMENT,activity_type INTEGER,activity_operation INTEGER,inserted_datetime TEXT,activity_rating INTEGER,user_id INTEGER,movie_id INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE user (_id INTEGER PRIMARY KEY AUTOINCREMENT,user_id INTEGER,nick TEXT,avatar_url TEXT,gender_id INTEGER)");
        sQLiteDatabase.execSQL("CREATE INDEX movie_list_movie_movie_list_id ON movie_list_movie(movie_list_id)");
        sQLiteDatabase.execSQL("CREATE INDEX movie_list_movie_movie_id ON movie_list_movie(movie_id)");
        sQLiteDatabase.execSQL("CREATE INDEX home_list_cache_movie_list_id ON home_list_cache(movie_list_id)");
        sQLiteDatabase.execSQL("CREATE TRIGGER delete_movie_list AFTER DELETE ON movie_list FOR EACH ROW BEGIN DELETE FROM movie_list_movie WHERE movie_list_id = OLD._id;DELETE FROM home_list_cache WHERE movie_list_id = OLD._id;END");
        sQLiteDatabase.execSQL("CREATE TRIGGER delete_movie_list_movie AFTER DELETE ON movie_list_movie FOR EACH ROW WHEN (SELECT COUNT(_id) FROM movie_list_movie WHERE movie_id = OLD.movie_id) == 0 BEGIN DELETE FROM movie WHERE _id = OLD.movie_id;END");
        sQLiteDatabase.execSQL("CREATE TRIGGER delete_movie AFTER DELETE ON movie FOR EACH ROW BEGIN DELETE FROM tv_programm WHERE movie_id = OLD._id;END");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3;
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE movie ADD rating INTEGER");
            sQLiteDatabase.execSQL("DELETE FROM movie_list");
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL("ALTER TABLE movie ADD poster_url VARCHAR(255)");
            sQLiteDatabase.execSQL("DELETE FROM movie_list");
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL("ALTER TABLE movie ADD origin VARCHAR(255)");
            sQLiteDatabase.execSQL("CREATE TABLE movie_video (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_id INTEGER,name VARCHAR(255),is_homepage_trailer INTEGER,thumbnail TEXT,thumbnail_width INTEGER,thumbnail_height INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE movie_video_resolutions (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_video_id INTEGER,resolution VARCHAR(255),url TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE movie_video_subtitles (_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_video_id INTEGER,language VARCHAR(255),url TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE favorites_activity (_id INTEGER PRIMARY KEY AUTOINCREMENT,activity_type INTEGER,activity_operation INTEGER,inserted_datetime TEXT,activity_rating INTEGER,user_id INTEGER,movie_id INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE user (_id INTEGER PRIMARY KEY AUTOINCREMENT,user_id INTEGER,nick TEXT,avatar_url TEXT,gender_id INTEGER)");
            sQLiteDatabase.execSQL("DELETE FROM movie_list");
            i3++;
        }
    }
}
