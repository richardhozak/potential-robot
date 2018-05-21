package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.List;

public class MovieVideos implements Serializable {
    private static final long serialVersionUID = 1;
    private List<MovieVideo> mVideos;

    public MovieVideos(List<MovieVideo> list) {
        this.mVideos = list;
    }

    public List<MovieVideo> m7009a() {
        return this.mVideos;
    }
}
