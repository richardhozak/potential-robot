package cz.csfd.csfdroid.module.cinema;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_TimeRange;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.store.C2034a.C2033a;
import cz.csfd.csfdroid.data.store.C2056d;
import cz.csfd.csfdroid.module.cinema.C2197e.C2176c;
import cz.csfd.csfdroid.module.cinema.C2197e.C2178d;
import cz.csfd.csfdroid.module.cinema.C2197e.C2194a;
import cz.csfd.csfdroid.module.cinema.C2197e.C2196b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

/* compiled from: CinemaModuleImpl */
public class C2200f implements C2197e {
    private C2056d<Cinema> f5334a;
    private C2011b f5335b;
    private C2011b f5336c;
    private C2011b f5337d;
    private C2011b f5338e;
    private C2011b f5339f;
    private C2011b f5340g;
    private C2011b f5341h;
    private int f5342i;

    public void mo3495a(Context context) {
        Intent intent = new Intent(context, CinemasActivity.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public Fragment mo3491a() {
        return new C2203g();
    }

    public void mo3503b(Context context) {
        Intent intent = new Intent(context, CinemasActivity.class);
        intent.putExtra("tab", "FAVORITE");
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public void mo3496a(Context context, Cinema cinema, Integer num) {
        if (this.f5334a == null) {
            this.f5334a = C1998s.m6365a(context).m6224l();
        }
        this.f5334a.m7164a((BasicEntity) cinema);
        Intent intent = new Intent(context, CinemaDetailActivity.class);
        if (num != null && num.intValue() > 0) {
            intent.putExtra("movie_id", num);
        }
        intent.setData(m7900b(cinema.m6705g()));
        context.startActivity(intent);
    }

    public Uri m7900b(int i) {
        Builder builder = new Builder();
        builder.scheme("csfdroid").authority("csfd.cz").path("kino").appendPath(i + "");
        return builder.build();
    }

    public int mo3490a(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme.equals("csfdroid")) {
            return Integer.parseInt(uri.getLastPathSegment());
        }
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            try {
                scheme = (String) uri.getPathSegments().get(1);
                int indexOf = scheme.indexOf("-");
                if (indexOf > 0) {
                    return Integer.parseInt(scheme.substring(0, indexOf));
                }
                return Integer.parseInt(scheme);
            } catch (Throwable e) {
                throw new C2183b(uri.toString(), e);
            }
        }
        throw new C2183b(uri.toString());
    }

    public void mo3497a(Location location, int i, boolean z, Enum_TimeRange c2019c, final C2196b c2196b, CsfdDataProvider c2016c, final ContentResolver contentResolver) {
        if (c2196b != null) {
            c2196b.mo3489b();
        }
        this.f5335b = c2016c.mo3360a(location, i, z, c2019c, new C2196b(this) {
            final /* synthetic */ C2200f f5330c;

            public void mo3489b() {
                c2196b.mo3489b();
            }

            public void m7881a(List<Cinema> list) {
                C2200f.m7888a(list, contentResolver);
                c2196b.mo3324a((Object) list);
            }

            public void mo3323a(Exception exception) {
                c2196b.mo3323a(exception);
            }

            public void mo3322a() {
                c2196b.mo3322a();
            }
        });
    }

    public void mo3501b() {
        if (this.f5335b != null) {
            this.f5335b.mo3355a();
            this.f5335b = null;
        }
    }

    public void mo3498a(Cinema cinema, C2194a c2194a, CsfdDataProvider c2016c) {
        mo3492a(this.f5342i);
        if (c2194a != null) {
            c2194a.mo3417g();
        }
        this.f5336c = c2016c.mo3372a(cinema, (C1945a) c2194a);
        this.f5342i = cinema.m6705g();
    }

    public void mo3492a(int i) {
        if (this.f5336c != null && this.f5342i == i) {
            this.f5336c.mo3355a();
            this.f5336c = null;
        }
    }

    public void mo3500a(String str, C2176c c2176c, CsfdDataProvider c2016c) {
        mo3504c();
        if (c2176c != null) {
            c2176c.mo3487b();
        }
        this.f5337d = c2016c.mo3398b(str, (C1945a) c2176c);
    }

    public void mo3504c() {
        if (this.f5337d != null) {
            this.f5337d.mo3355a();
            this.f5337d = null;
        }
    }

    public void mo3499a(String str, int i, boolean z, Enum_TimeRange c2019c, final C2178d c2178d, CsfdDataProvider c2016c, final ContentResolver contentResolver) {
        mo3505d();
        if (c2178d != null) {
            c2178d.mo3488b();
        }
        this.f5338e = c2016c.mo3383a(str, i, z, c2019c, new C2178d(this) {
            final /* synthetic */ C2200f f5333c;

            public void mo3488b() {
                c2178d.mo3488b();
            }

            public void m7886a(Map<String, List<Cinema>> map) {
                for (List a : map.values()) {
                    C2200f.m7888a(a, contentResolver);
                }
                c2178d.mo3324a((Object) map);
            }

            public void mo3323a(Exception exception) {
                c2178d.mo3323a(exception);
            }

            public void mo3322a() {
                c2178d.mo3322a();
            }
        });
    }

    public void mo3505d() {
        if (this.f5338e != null) {
            this.f5338e.mo3355a();
            this.f5338e = null;
        }
    }

    public void mo3494a(int i, boolean z, Enum_TimeRange c2019c, C1945a<List<Cinema>> c1945a, CsfdDataProvider c2016c) {
        mo3506e();
        this.f5341h = c2016c.mo3359a(i, z, c2019c, (C1945a) c1945a);
    }

    public void mo3506e() {
        if (this.f5341h != null) {
            this.f5341h.mo3355a();
            this.f5341h = null;
        }
    }

    public void mo3493a(int i, C1945a<Object> c1945a, CsfdDataProvider c2016c) {
        m7907f();
        this.f5339f = c2016c.mo3358a(i, (C1945a) c1945a);
    }

    public void m7907f() {
        if (this.f5339f != null) {
            this.f5339f.mo3355a();
            this.f5339f = null;
        }
    }

    public void mo3502b(int i, C1945a<Object> c1945a, CsfdDataProvider c2016c) {
        m7908g();
        this.f5340g = c2016c.mo3388b(i, (C1945a) c1945a);
    }

    public void m7908g() {
        if (this.f5340g != null) {
            this.f5340g.mo3355a();
            this.f5340g = null;
        }
    }

    public static List<Cinema> m7888a(List<Cinema> list, ContentResolver contentResolver) {
        Cursor query = contentResolver.query(C2033a.f4703a, null, null, null, null);
        List arrayList = new ArrayList();
        if (query.moveToFirst()) {
            do {
                arrayList.add(Integer.valueOf(query.getInt(query.getColumnIndex("cinema_id"))));
            } while (query.moveToNext());
        }
        query.close();
        for (Cinema cinema : list) {
            if (arrayList.contains(Integer.valueOf(cinema.m6705g()))) {
                cinema.m6751c(true);
            }
        }
        return list;
    }
}
