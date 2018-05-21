package cz.csfd.csfdroid.module.cinema;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_TimeRange;
import cz.csfd.csfdroid.data.entity.Cinema;
import java.util.List;
import java.util.Map;

/* compiled from: CinemaModule */
public interface C2197e {

    /* compiled from: CinemaModule */
    public interface C2176c extends C1945a<List<String>> {
        void mo3487b();
    }

    /* compiled from: CinemaModule */
    public interface C2178d extends C1945a<Map<String, List<Cinema>>> {
        void mo3488b();
    }

    /* compiled from: CinemaModule */
    public interface C2194a extends C1945a<Cinema> {
        void mo3417g();
    }

    /* compiled from: CinemaModule */
    public interface C2196b extends C1945a<List<Cinema>> {
        void mo3489b();
    }

    int mo3490a(Uri uri);

    Fragment mo3491a();

    void mo3492a(int i);

    void mo3493a(int i, C1945a<Object> c1945a, CsfdDataProvider c2016c);

    void mo3494a(int i, boolean z, Enum_TimeRange c2019c, C1945a<List<Cinema>> c1945a, CsfdDataProvider c2016c);

    void mo3495a(Context context);

    void mo3496a(Context context, Cinema cinema, Integer num);

    void mo3497a(Location location, int i, boolean z, Enum_TimeRange c2019c, C2196b c2196b, CsfdDataProvider c2016c, ContentResolver contentResolver);

    void mo3498a(Cinema cinema, C2194a c2194a, CsfdDataProvider c2016c);

    void mo3499a(String str, int i, boolean z, Enum_TimeRange c2019c, C2178d c2178d, CsfdDataProvider c2016c, ContentResolver contentResolver);

    void mo3500a(String str, C2176c c2176c, CsfdDataProvider c2016c);

    void mo3501b();

    void mo3502b(int i, C1945a<Object> c1945a, CsfdDataProvider c2016c);

    void mo3503b(Context context);

    void mo3504c();

    void mo3505d();

    void mo3506e();
}
