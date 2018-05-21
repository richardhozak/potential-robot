package cz.csfd.csfdroid.data.store.cache;

import android.os.Handler;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.store.cache.C2049b.C2048a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: PersistentHomeCache */
public class C2054d implements C2049b {
    private static final String[] f4815c = new String[]{"new_videos", "tv_tips", "dvd_releases", "bluray_releases", "cinema_releases", "film_profile_visits", "favorites"};
    private C2055e f4816a;
    private ExecutorService f4817b = Executors.newSingleThreadExecutor();

    public C2054d(C2055e c2055e) {
        this.f4816a = c2055e;
    }

    public void mo3413a(final List<String> list, final C2048a c2048a) {
        final Handler handler = new Handler();
        this.f4817b.execute(new Runnable(this) {
            final /* synthetic */ C2054d f4812d;

            public void run() {
                final Map a = this.f4812d.m7138a(list);
                handler.post(new Runnable(this) {
                    final /* synthetic */ C20521 f4808b;

                    public void run() {
                        c2048a.mo3535a(a);
                    }
                });
            }
        });
    }

    private Map<String, List<? extends BasicEntity>> m7138a(List<String> list) {
        Map<String, List<? extends BasicEntity>> hashMap = new HashMap();
        for (String str : list) {
            if (this.f4816a.m7159b(str)) {
                hashMap.put(str, this.f4816a.m7157a(str));
            }
        }
        return hashMap;
    }

    public void mo3414a(final Map<String, List<? extends BasicEntity>> map) {
        this.f4817b.execute(new Runnable(this) {
            final /* synthetic */ C2054d f4814b;

            public void run() {
                this.f4814b.m7140b(map);
            }
        });
    }

    private void m7140b(Map<String, List<? extends BasicEntity>> map) {
        for (String str : f4815c) {
            if (map.containsKey(str)) {
                this.f4816a.m7158a(str, (List) map.get(str));
            }
        }
    }
}
