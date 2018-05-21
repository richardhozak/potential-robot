package cz.csfd.csfdroid.module.creator;

import android.content.Context;
import android.net.Uri;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import java.util.List;

/* compiled from: CreatorModule */
public interface C2234f {

    /* compiled from: CreatorModule */
    public interface C2223a extends C1945a<MovieCreator> {
        void mo3510i();
    }

    /* compiled from: CreatorModule */
    public interface C2231b extends C1945a<MovieCreator> {
        void mo3417g();
    }

    int mo3512a(Uri uri);

    void mo3513a(int i);

    void mo3514a(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, CsfdDataProvider c2016c, Context context);

    void mo3515a(MovieCreator movieCreator, int i, int i2, C1945a<MovieCreator> c1945a, CsfdDataProvider c2016c);

    void mo3516a(MovieCreator movieCreator, Context context);

    void mo3517a(MovieCreator movieCreator, C2223a c2223a, CsfdDataProvider c2016c);

    void mo3518a(MovieCreator movieCreator, C2231b c2231b, CsfdDataProvider c2016c);

    void mo3519b(int i);

    void mo3520c(int i);

    void mo3521d(int i);
}
