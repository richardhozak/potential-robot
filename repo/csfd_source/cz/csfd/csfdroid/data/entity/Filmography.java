package cz.csfd.csfdroid.data.entity;

import cz.csfd.csfdroid.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filmography {
    private Type f4643a;
    private Map<String, List<MovieInfo>> f4644b = new HashMap();

    public enum Type {
        director(R.string.movie_list_filmography_director),
        author(R.string.movie_list_filmography_author),
        screenwriter(R.string.movie_list_filmography_screenwriter),
        cinematographer(R.string.movie_list_filmography_cinematographer),
        composer(R.string.movie_list_filmography_composer),
        actor(R.string.movie_list_filmography_actor),
        production(R.string.movie_list_filmography_producer),
        edit(R.string.movie_list_filmography_editor),
        sound(R.string.movie_list_filmography_sound),
        scenography(R.string.movie_list_filmography_scenographer),
        mask(R.string.movie_list_filmography_masker),
        costumes(R.string.movie_list_filmography_costumer);
        
        int title;

        private Type(int i) {
            this.title = i;
        }
    }

    public void m6796a(Type type) {
        this.f4643a = type;
    }

    public int m6795a() {
        return this.f4643a.title;
    }

    public Map<String, List<MovieInfo>> m6797b() {
        return this.f4644b;
    }
}
