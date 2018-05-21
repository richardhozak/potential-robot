package cz.csfd.csfdroid.net.p067a;

import android.util.Log;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieInfo.Category;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Gender;
import cz.csfd.csfdroid.data.entity.User.Section;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserJsonHelper */
public class C2513q {
    private C2508m f6278a = new C2508m();
    private C2500e f6279b = new C2500e();

    public User m9301a(User user, JSONObject jSONObject) {
        user.m6704b(jSONObject.getInt("id"));
        user.m6808a(jSONObject.getString("nick"));
        if (!jSONObject.isNull("fullname")) {
            user.m6812b(jSONObject.getString("fullname"));
        }
        if (!jSONObject.isNull("avatar_url")) {
            user.m6815c(jSONObject.getString("avatar_url"));
        }
        if (!jSONObject.isNull("occupation")) {
            user.m6818d(jSONObject.getString("occupation"));
        }
        if (!jSONObject.isNull("district")) {
            user.m6820e(jSONObject.getString("district"));
        }
        if (!jSONObject.isNull("registration_datetime")) {
            user.m6821f(jSONObject.getString("registration_datetime"));
        }
        if (!jSONObject.isNull("summary")) {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("summary");
            user.m6809a(m9298b(jSONObject2));
            user.m6806a(jSONObject2.getInt("point_count"));
        }
        if (!jSONObject.isNull("in_favorites")) {
            user.m6816c(jSONObject.getBoolean("in_favorites"));
        }
        user.m6810a(true);
        return user;
    }

    public User m9302b(User user, JSONObject jSONObject) {
        m9301a(user, jSONObject.getJSONObject("info"));
        if (!jSONObject.isNull("preview")) {
            m9299f(user, jSONObject.getJSONObject("preview"));
        }
        return user;
    }

    public static User m9297a(JSONObject jSONObject) {
        User user = new User(jSONObject.getInt("id"));
        user.m6808a(jSONObject.getString("nick"));
        if (!jSONObject.isNull("fullname")) {
            user.m6812b(jSONObject.getString("fullname"));
        }
        if (!jSONObject.isNull("avatar_url")) {
            user.m6815c(jSONObject.getString("avatar_url"));
        }
        if (!jSONObject.isNull("gender_id")) {
            user.m6807a(Gender.m7071a(jSONObject.getInt("gender_id")));
        }
        return user;
    }

    private List<Section> m9298b(JSONObject jSONObject) {
        List<Section> arrayList = new ArrayList();
        int i = jSONObject.getInt("film_rating_count");
        if (i > 0) {
            Section section = Section.FILM_RATINGS;
            section.m7075a(i);
            arrayList.add(section);
        }
        if (jSONObject.has("film_comment_count")) {
            i = jSONObject.getInt("film_comment_count");
            if (i > 0) {
                section = Section.FILM_COMMENTS;
                section.m7075a(i);
                arrayList.add(section);
            }
        }
        i = jSONObject.getInt("fanclub_films_count");
        if (i > 0) {
            section = Section.FANCLUB_FILMS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_series_count");
        if (i > 0) {
            section = Section.FANCLUB_SERIES;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_shows_count");
        if (i > 0) {
            section = Section.FANCLUB_SHOWS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_actors_count");
        if (i > 0) {
            section = Section.FANCLUB_ACTORS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_actresses_count");
        if (i > 0) {
            section = Section.FANCLUB_ACTRESSES;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_directors_count");
        if (i > 0) {
            section = Section.FANCLUB_DIRECTORS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_composers_count");
        if (i > 0) {
            section = Section.FANCLUB_COMPOSERS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_screenwriters_count");
        if (i > 0) {
            section = Section.FANCLUB_SCREENWRITERS;
            section.m7075a(i);
            arrayList.add(section);
        }
        i = jSONObject.getInt("fanclub_cinematographers_count");
        if (i > 0) {
            section = Section.FANCLUB_CINEMATOGRAPHERS;
            section.m7075a(i);
            arrayList.add(section);
        }
        if (jSONObject.has("favorites_count")) {
            i = jSONObject.getInt("favorites_count");
            if (i > 0) {
                section = Section.FAVOURITE_USERS;
                section.m7075a(i);
                arrayList.add(section);
            }
        }
        return arrayList;
    }

    private void m9299f(User user, JSONObject jSONObject) {
        for (Section section : user.m6825j()) {
            String f = section.m7081f();
            if (!jSONObject.isNull(f)) {
                JSONArray jSONArray = jSONObject.getJSONArray(f);
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    switch (section) {
                        case FILM_RATINGS:
                        case FILM_COMMENTS:
                            arrayList.add(m9300g(user, jSONObject2));
                            break;
                        case FANCLUB_FILMS:
                        case FANCLUB_SERIES:
                        case FANCLUB_SHOWS:
                            arrayList.add(this.f6278a.m9278a(jSONObject2.getJSONObject("film")));
                            break;
                        case FANCLUB_ACTORS:
                        case FANCLUB_ACTRESSES:
                        case FANCLUB_DIRECTORS:
                        case FANCLUB_COMPOSERS:
                        case FANCLUB_SCREENWRITERS:
                        case FANCLUB_CINEMATOGRAPHERS:
                            arrayList.add(this.f6279b.m9245n(jSONObject2.getJSONObject("creator")));
                            break;
                        case FAVOURITE_USERS:
                            arrayList.add(C2513q.m9297a(jSONObject2.getJSONObject("user")));
                            break;
                        default:
                            Log.d("UserJsonHelper", "unknown section " + section);
                            break;
                    }
                }
                section.m7076a(arrayList);
            }
        }
    }

    public List<C2028e> m9303c(User user, JSONObject jSONObject) {
        if (jSONObject.has("user")) {
            m9301a(user, jSONObject.getJSONObject("user"));
        }
        JSONArray jSONArray = null;
        if (jSONObject.has("ratings")) {
            jSONArray = jSONObject.getJSONArray("ratings");
        } else if (jSONObject.has("comments")) {
            jSONArray = jSONObject.getJSONArray("comments");
        }
        List<C2028e> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m9300g(user, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private C2028e m9300g(User user, JSONObject jSONObject) {
        int i = -1;
        if (!jSONObject.isNull("rating")) {
            i = jSONObject.getInt("rating");
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("film");
        MovieInfo movieInfo = new MovieInfo(jSONObject2.getInt("id"));
        movieInfo.m6922a(jSONObject2.getString("name"));
        movieInfo.m6932c(jSONObject2.getInt("year"));
        if (!jSONObject2.isNull("type")) {
            movieInfo.m6957h(jSONObject2.getString("type"));
        }
        movieInfo.m6919a(Category.m6889a(jSONObject2.getInt("rating_category")));
        if (!jSONObject2.isNull("poster_url")) {
            movieInfo.m6938d(jSONObject2.getString("poster_url"));
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString("inserted_datetime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        C2028e c2028e = new C2028e(user, movieInfo, i, date);
        if (jSONObject.has("text")) {
            c2028e.m7101a(jSONObject.getString("text"));
        }
        return c2028e;
    }

    public List m9304d(User user, JSONObject jSONObject) {
        if (jSONObject.has("user")) {
            m9301a(user, jSONObject.getJSONObject("user"));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("fanclub");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2.has("film")) {
                arrayList.add(new C2508m().m9280b(jSONObject2.getJSONObject("film")));
            } else if (jSONObject2.has("creator")) {
                arrayList.add(new C2500e().m9245n(jSONObject2.getJSONObject("creator")));
            }
        }
        return arrayList;
    }

    public List<User> m9305e(User user, JSONObject jSONObject) {
        if (jSONObject.has("user")) {
            m9301a(user, jSONObject.getJSONObject("user"));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("favorites");
        List<User> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i).getJSONObject("user");
            User user2 = new User(jSONObject2.getInt("id"));
            user2.m6808a(jSONObject2.getString("nick"));
            if (!jSONObject2.isNull("avatar_url")) {
                user2.m6815c(jSONObject2.getString("avatar_url"));
            }
            arrayList.add(user2);
        }
        return arrayList;
    }
}
