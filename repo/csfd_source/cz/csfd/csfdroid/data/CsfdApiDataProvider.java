package cz.csfd.csfdroid.data;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2011b;
import cz.csfd.csfdroid.data.CsfdDataProvider.C2019c;
import cz.csfd.csfdroid.data.CsfdDataProvider.Enum_OrderBy;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import cz.csfd.csfdroid.data.entity.C2024a;
import cz.csfd.csfdroid.data.entity.C2025b;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.data.entity.C2030g;
import cz.csfd.csfdroid.data.entity.C2031h;
import cz.csfd.csfdroid.data.entity.Chart;
import cz.csfd.csfdroid.data.entity.Cinema;
import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.MovieCreator;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideo;
import cz.csfd.csfdroid.data.entity.Seasons;
import cz.csfd.csfdroid.data.entity.TvStation;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Section;
import cz.csfd.csfdroid.data.entity.WatchlistMovie;
import cz.csfd.csfdroid.module.home.C2284d.C2283b;
import cz.csfd.csfdroid.net.C2517b;
import cz.csfd.csfdroid.net.p067a.C2496a;
import cz.csfd.csfdroid.net.p067a.C2497b;
import cz.csfd.csfdroid.net.p067a.C2498c;
import cz.csfd.csfdroid.net.p067a.C2499d;
import cz.csfd.csfdroid.net.p067a.C2500e;
import cz.csfd.csfdroid.net.p067a.C2501f;
import cz.csfd.csfdroid.net.p067a.C2502g;
import cz.csfd.csfdroid.net.p067a.C2503h;
import cz.csfd.csfdroid.net.p067a.C2504i;
import cz.csfd.csfdroid.net.p067a.C2505j;
import cz.csfd.csfdroid.net.p067a.C2506k;
import cz.csfd.csfdroid.net.p067a.C2507l;
import cz.csfd.csfdroid.net.p067a.C2508m;
import cz.csfd.csfdroid.net.p067a.C2509n;
import cz.csfd.csfdroid.net.p067a.C2510o;
import cz.csfd.csfdroid.net.p067a.C2511p;
import cz.csfd.csfdroid.net.p067a.C2513q;
import cz.csfd.csfdroid.net.p067a.C2514r;
import cz.csfd.csfdroid.net.p067a.C2515s;
import cz.csfd.csfdroid.net.queue.C2529b;
import cz.csfd.csfdroid.net.queue.C2529b.C2000b;
import cz.csfd.csfdroid.net.queue.Request;
import cz.csfd.csfdroid.net.queue.Request.C2522a;
import cz.csfd.csfdroid.p061d.C1998s;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CsfdApiDataProvider */
// C2017a
public class CsfdApiDataProvider implements CsfdDataProvider {
    private C2517b f4586a;
    private C2529b f4587b;
    private CsfdApiUrlHelper csfdApiUrlHelper = new CsfdApiUrlHelper();
    private C2506k f4589d = new C2506k();
    private C2504i f4590e = new C2504i();
    private C2501f f4591f = new C2501f();
    private C2508m f4592g = new C2508m();
    private C2500e f4593h = new C2500e();
    private C2509n f4594i = new C2509n();
    private C2499d f4595j = new C2499d();
    private C2503h f4596k = new C2503h();
    private C2505j f4597l = new C2505j();
    private C2514r f4598m = new C2514r();
    private C2510o f4599n = new C2510o();
    private C2498c f4600o = new C2498c();
    private C2497b f4601p = new C2497b();
    private C2513q f4602q = new C2513q();
    private C2502g f4603r = new C2502g();
    private C2515s f4604s = new C2515s();
    private C2511p f4605t = new C2511p();
    private C2496a f4606u = new C2496a();
    private C2507l f4607v = new C2507l();
    private Set<C2000b> f4608w = new HashSet();

    /* compiled from: CsfdApiDataProvider */
    private abstract class C2001b<T> implements C2000b {
        private SoftReference<C1945a<T>> f4491a;
        private C1945a<T> f4492b;
        final /* synthetic */ CsfdApiDataProvider f4493e;

        public abstract T mo3354b(JSONObject jSONObject);

        C2001b(CsfdApiDataProvider c2017a, C1945a<T> c1945a) {
            this(c2017a, c1945a, false);
        }

        C2001b(CsfdApiDataProvider c2017a, C1945a<T> c1945a, boolean z) {
            this.f4493e = c2017a;
            if (z) {
                this.f4492b = c1945a;
            } else {
                this.f4491a = new SoftReference(c1945a);
            }
        }

        protected C1945a<T> m6389a() {
            return this.f4492b != null ? this.f4492b : (C1945a) this.f4491a.get();
        }

        public void mo3352a(Request request, String str) {
            JSONObject a = m6388a(str);
            if (a != null) {
                try {
                    if (m6389a() != null) {
                        m6389a().mo3324a(mo3354b(a));
                    } else {
                        Log.e(getClass().toString(), "ApiResultListener is null");
                    }
                } catch (Exception e) {
                    C1998s.m6371a(getClass(), e);
                    if (m6389a() != null) {
                        m6389a().mo3323a(new C2021d("Bad JSON response."));
                    }
                }
            }
            this.f4493e.f4608w.remove(this);
        }

        public void mo3353a(Request request, String str, int i) {
            if (m6389a() != null) {
                if (i == HttpStatus.SC_PRECONDITION_FAILED) {
                    try {
                        JSONObject a = this.f4493e.f4589d.m9264a(str);
                        String str2 = "Http response code was 412";
                        if (this.f4493e.f4591f.m9246a(a)) {
                            str2 = this.f4493e.f4591f.m9247b(a);
                        }
                        m6389a().mo3323a(new C2022e(str2));
                    } catch (JSONException e) {
                        m6389a().mo3323a(new C2021d("Error on geting content."));
                    }
                } else {
                    m6389a().mo3323a(new C2021d("Error on geting content."));
                }
            }
            this.f4493e.f4608w.remove(this);
        }

        public void mo3351a(Request request, Exception exception) {
            if (m6389a() != null) {
                m6389a().mo3323a(exception);
            }
            this.f4493e.f4608w.remove(this);
        }

        public void mo3350a(Request request) {
            if (m6389a() != null) {
                m6389a().mo3322a();
            }
            this.f4493e.f4608w.remove(this);
        }

        private JSONObject m6388a(String str) {
            JSONObject jSONObject = null;
            try {
                jSONObject = this.f4493e.m6564a(str);
            } catch (Exception e) {
                C1998s.m6371a(getClass(), e);
                if (m6389a() != null) {
                    m6389a().mo3323a(new C2021d("Bad JSON response."));
                }
            } catch (Exception e2) {
                C1998s.m6371a(getClass(), e2);
                if (m6389a() != null) {
                    m6389a().mo3323a(new C2021d("Error on geting content."));
                }
            }
            return jSONObject;
        }
    }

    /* compiled from: CsfdApiDataProvider */
    private class C2012a implements C2011b {
        final /* synthetic */ CsfdApiDataProvider f4581a;
        private Request f4582b;

        private C2012a(CsfdApiDataProvider c2017a, Request request) {
            this.f4581a = c2017a;
            this.f4582b = request;
        }

        public void mo3355a() {
            if (this.f4582b != null) {
                this.f4581a.f4587b.m9360a(this.f4582b);
            }
        }
    }

    public CsfdApiDataProvider(C2517b c2517b, C2529b c2529b) {
        this.f4586a = c2517b;
        this.f4587b = c2529b;
    }

    public C2011b mo3361a(C1945a<Identity> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6660b(), 0);
            C2000b c20021 = new C2001b<Identity>(this, c1945a, true) {
                final /* synthetic */ CsfdApiDataProvider f4511a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6413a(jSONObject);
                }

                public Identity m6413a(JSONObject jSONObject) {
                    return this.f4511a.f4597l.m9263a(jSONObject);
                }
            };
            this.f4608w.add(c20021);
            this.f4587b.m9361a(request, c20021);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3384a(String str, C1945a<Map<String, List<? extends BasicEntity>>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_searchWithQuery(str), 1);
            C2000b anonymousClass12 = new C2001b<Map<String, List<? extends BasicEntity>>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4496a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6399a(jSONObject);
                }

                public Map<String, List<? extends BasicEntity>> m6399a(JSONObject jSONObject) {
                    return this.f4496a.f4594i.m9290a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass12);
            this.f4587b.m9361a(request, anonymousClass12);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3378a(final MovieInfo movieInfo, C1945a<MovieInfo> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_filmFromId(movieInfo.m6705g()), 2);
            C2000b anonymousClass23 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4520b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6421a(jSONObject);
                }

                public MovieInfo m6421a(JSONObject jSONObject) {
                    this.f4520b.f4592g.m9277a(movieInfo, jSONObject);
                    movieInfo.m6926a(true);
                    if (movieInfo.m6970k().size() == 0) {
                        movieInfo.m6929b(this.f4520b.f4593h.m9244m(jSONObject));
                    }
                    return movieInfo;
                }
            };
            this.f4608w.add(anonymousClass23);
            this.f4587b.m9361a(request, anonymousClass23);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3396b(final MovieInfo movieInfo, C1945a<MovieInfo> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_creatorsFromFilmId(movieInfo.m6705g()), 1);
            C2000b anonymousClass34 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4535b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6443a(jSONObject);
                }

                public MovieInfo m6443a(JSONObject jSONObject) {
                    movieInfo.m6929b(this.f4535b.f4593h.m9230a(jSONObject));
                    movieInfo.m6925a(this.f4535b.f4593h.m9233b(jSONObject));
                    movieInfo.m6934c(this.f4535b.f4593h.m9234c(jSONObject));
                    movieInfo.m6939d(this.f4535b.f4593h.m9235d(jSONObject));
                    movieInfo.m6944e(this.f4535b.f4593h.m9236e(jSONObject));
                    movieInfo.m6949f(this.f4535b.f4593h.m9237f(jSONObject));
                    movieInfo.m6953g(this.f4535b.f4593h.m9238g(jSONObject));
                    movieInfo.m6958h(this.f4535b.f4593h.m9239h(jSONObject));
                    movieInfo.m6963i(this.f4535b.f4593h.m9240i(jSONObject));
                    movieInfo.m6968j(this.f4535b.f4593h.m9241j(jSONObject));
                    movieInfo.m6973k(this.f4535b.f4593h.m9242k(jSONObject));
                    movieInfo.m6978l(this.f4535b.f4593h.m9243l(jSONObject));
                    movieInfo.m6959h(true);
                    return movieInfo;
                }
            };
            this.f4608w.add(anonymousClass34);
            this.f4587b.m9361a(request, anonymousClass34);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3375a(final MovieInfo movieInfo, int i, final int i2, int i3, C1945a<MovieInfo> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_photosFromFilmIdWithOffsetAndLimitAndWidth(movieInfo.m6705g(), i, i2, i3), 1);
            C2000b anonymousClass45 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4551c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6467a(jSONObject);
                }

                public MovieInfo m6467a(JSONObject jSONObject) {
                    Collection a = this.f4551c.f4596k.m9251a(jSONObject);
                    if (a.size() < i2) {
                        movieInfo.m6930b(true);
                    }
                    movieInfo.m6960i().addAll(a);
                    return movieInfo;
                }
            };
            this.f4608w.add(anonymousClass45);
            this.f4587b.m9361a(request, anonymousClass45);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3377a(final MovieInfo movieInfo, int i, final int i2, C1945a<MovieInfo> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_commentsFromFilmIdWithOffsetAndLimit(movieInfo.m6705g(), i, i2), 1);
            C2000b anonymousClass51 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4562c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6481a(jSONObject);
                }

                public MovieInfo m6481a(JSONObject jSONObject) {
                    Collection a = this.f4562c.f4595j.m9219a(jSONObject);
                    if (a.size() < i2) {
                        movieInfo.m6945e(true);
                    }
                    movieInfo.m6901K().addAll(a);
                    return movieInfo;
                }
            };
            this.f4608w.add(anonymousClass51);
            this.f4587b.m9361a(request, anonymousClass51);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3376a(MovieInfo movieInfo, int i, int i2, int i3, C1945a<MovieInfo> c1945a, Context context) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_videosFromFilmIdWithOffsetAndLimitAndWidth(movieInfo.m6705g(), i, i2, i3), 1);
            final MovieInfo movieInfo2 = movieInfo;
            final int i4 = i2;
            final Context context2 = context;
            C2000b anonymousClass52 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4566d;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6483a(jSONObject);
                }

                public MovieInfo m6483a(JSONObject jSONObject) {
                    Collection a = this.f4566d.f4598m.m9309a(jSONObject, movieInfo2.m6912V());
                    if (a.size() < i4) {
                        movieInfo2.m6950f(true);
                    }
                    movieInfo2.m6911U().addAll(a);
                    ((CsfdApplication) context2.getApplicationContext()).m6212a(this.f4566d.f4606u.m9203c(jSONObject));
                    return movieInfo2;
                }
            };
            this.f4608w.add(anonymousClass52);
            this.f4587b.m9361a(request, anonymousClass52);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3395b(final MovieInfo movieInfo, int i, final int i2, C1945a<MovieInfo> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_triviaFromFilmIdWithOffsetAndLimit(movieInfo.m6705g(), i, i2), 1);
            C2000b anonymousClass53 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4569c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6485a(jSONObject);
                }

                public MovieInfo m6485a(JSONObject jSONObject) {
                    Collection a = this.f4569c.f4599n.m9292a(jSONObject);
                    if (a.size() < i2) {
                        movieInfo.m6935c(true);
                    }
                    movieInfo.m6903M().addAll(a);
                    return movieInfo;
                }
            };
            this.f4608w.add(anonymousClass53);
            this.f4587b.m9361a(request, anonymousClass53);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3374a(final MovieCreator movieCreator, C1945a<MovieCreator> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_creatorFromId(movieCreator.m6705g()), 1);
            C2000b anonymousClass54 = new C2001b<MovieCreator>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4571b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6487a(jSONObject);
                }

                public MovieCreator m6487a(JSONObject jSONObject) {
                    this.f4571b.f4593h.m9228a(movieCreator, jSONObject);
                    movieCreator.m6854a(true);
                    return movieCreator;
                }
            };
            this.f4608w.add(anonymousClass54);
            this.f4587b.m9361a(request, anonymousClass54);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3394b(final MovieCreator movieCreator, C1945a<MovieCreator> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6645a(movieCreator.m6705g()), 1);
            C2000b c20032 = new C2001b<MovieCreator>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4528b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6433a(jSONObject);
                }

                public MovieCreator m6433a(JSONObject jSONObject) {
                    this.f4528b.f4593h.m9232b(movieCreator, jSONObject);
                    movieCreator.m6858b(true);
                    return movieCreator;
                }
            };
            this.f4608w.add(c20032);
            this.f4587b.m9361a(request, c20032);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3357a(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, final Context context) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_videosFromCreatorIdWithOffsetAndLimit(i, i2, i3), 1);
            C2000b c20043 = new C2001b<List<MovieVideo>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4543b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6455a(jSONObject);
                }

                public List<MovieVideo> m6455a(JSONObject jSONObject) {
                    ((CsfdApplication) context.getApplicationContext()).m6212a(this.f4543b.f4606u.m9203c(jSONObject));
                    return this.f4543b.f4598m.m9309a(jSONObject, 0);
                }
            };
            this.f4608w.add(c20043);
            this.f4587b.m9361a(request, c20043);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3373a(final MovieCreator movieCreator, int i, final int i2, C1945a<MovieCreator> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_photosFromCreatorIdWithOffsetAndLimit(movieCreator.m6705g(), i, i2), 1);
            C2000b c20054 = new C2001b<MovieCreator>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4558c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6477a(jSONObject);
                }

                public MovieCreator m6477a(JSONObject jSONObject) {
                    Collection a = this.f4558c.f4596k.m9251a(jSONObject);
                    if (a.size() < i2) {
                        movieCreator.m6862c(true);
                    }
                    movieCreator.m6885t().addAll(a);
                    return movieCreator;
                }
            };
            this.f4608w.add(c20054);
            this.f4587b.m9361a(request, c20054);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3386a(List<String> list, C1945a<Map<String, List<? extends BasicEntity>>> c1945a, final Context context) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_homeData((List) list), 0);
            C2000b c20065 = new C2001b<Map<String, List<? extends BasicEntity>>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4573b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6489a(jSONObject);
                }

                public Map<String, List<? extends BasicEntity>> m6489a(JSONObject jSONObject) {
                    if (!(context == null || context.getApplicationContext() == null)) {
                        ((CsfdApplication) context.getApplicationContext()).m6212a(this.f4573b.f4606u.m9203c(jSONObject));
                    }
                    return this.f4573b.f4590e.m9262a(jSONObject);
                }
            };
            this.f4608w.add(c20065);
            this.f4587b.m9361a(request, c20065);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3402c(final MovieInfo movieInfo, C1945a<MovieInfo> c1945a) {
        try {
            Request request;
            if (movieInfo.m6906P() == -1) {
                request = new Request(this.csfdApiUrlHelper.url_myRatingFromFilmId(movieInfo.m6705g()), C2522a.DELETE, null, 0);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("rating", String.valueOf(movieInfo.m6906P()));
                request = new Request(this.csfdApiUrlHelper.url_myRatingFromFilmId(movieInfo.m6705g()), hashMap, 0);
            }
            C2000b c20076 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4575b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6491a(jSONObject);
                }

                public MovieInfo m6491a(JSONObject jSONObject) {
                    this.f4575b.f4592g.m9279b(movieInfo, jSONObject);
                    return movieInfo;
                }
            };
            this.f4608w.add(c20076);
            this.f4587b.m9361a(request, c20076);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3406d(final MovieInfo movieInfo, C1945a<MovieInfo> c1945a) {
        try {
            Request request;
            if (movieInfo.m6909S() == null) {
                request = new Request(this.csfdApiUrlHelper.url_myCommentFromFilmId(movieInfo.m6705g()), C2522a.DELETE, null, 0);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("text", movieInfo.m6909S());
                request = new Request(this.csfdApiUrlHelper.url_myCommentFromFilmId(movieInfo.m6705g()), hashMap, 0);
            }
            C2000b c20087 = new C2001b<MovieInfo>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4577b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6493a(jSONObject);
                }

                public MovieInfo m6493a(JSONObject jSONObject) {
                    return movieInfo;
                }
            };
            this.f4608w.add(c20087);
            this.f4587b.m9361a(request, c20087);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3360a(final Location location, int i, boolean z, C2019c c2019c, C1945a<List<Cinema>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6644a(location.getLatitude(), location.getLongitude(), i, !z, c2019c), 2);
            C2000b c20098 = new C2001b<List<Cinema>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4579b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6495a(jSONObject);
                }

                public List<Cinema> m6495a(JSONObject jSONObject) {
                    return this.f4579b.f4600o.m9214a(jSONObject, location);
                }
            };
            this.f4608w.add(c20098);
            this.f4587b.m9361a(request, c20098);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3383a(String str, int i, boolean z, C2019c c2019c, C1945a<Map<String, List<Cinema>>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6657a(str, i, !z, c2019c), 2);
            C2000b c20109 = new C2001b<Map<String, List<Cinema>>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4580a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6497a(jSONObject);
                }

                public Map<String, List<Cinema>> m6497a(JSONObject jSONObject) {
                    return this.f4580a.f4600o.m9215a(jSONObject);
                }
            };
            this.f4608w.add(c20109);
            this.f4587b.m9361a(request, c20109);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3359a(int i, boolean z, C2019c c2019c, C1945a<List<Cinema>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6651a(i, !z, c2019c), 2);
            C2000b anonymousClass10 = new C2001b<List<Cinema>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4494a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6395a(jSONObject);
                }

                public List<Cinema> m6395a(JSONObject jSONObject) {
                    return this.f4494a.f4600o.m9214a(jSONObject, null);
                }
            };
            this.f4608w.add(anonymousClass10);
            this.f4587b.m9361a(request, anonymousClass10);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3398b(String str, C1945a<List<String>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_cinemaFromTowns(str), 1);
            C2000b anonymousClass11 = new C2001b<List<String>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4495a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6397a(jSONObject);
                }

                public List<String> m6397a(JSONObject jSONObject) {
                    return this.f4495a.f4600o.m9217c(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass11);
            this.f4587b.m9361a(request, anonymousClass11);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3372a(final Cinema cinema, C1945a<Cinema> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_cinemaFromId(cinema.m6705g()), 2);
            C2000b anonymousClass13 = new C2001b<Cinema>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4498b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6401a(jSONObject);
                }

                public Cinema m6401a(JSONObject jSONObject) {
                    this.f4498b.f4600o.m9213a(cinema, jSONObject);
                    cinema.m6742a(true);
                    return cinema;
                }
            };
            this.f4608w.add(anonymousClass13);
            this.f4587b.m9361a(request, anonymousClass13);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3358a(int i, C1945a<Object> c1945a) {
        try {
            String g = this.csfdApiUrlHelper.m6680g();
            Map hashMap = new HashMap();
            hashMap.put("cinema_id", String.valueOf(i));
            Request request = new Request(g, C2522a.POST, hashMap, 4);
            C2000b anonymousClass14 = new C2001b<Object>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4499a;

                public Object mo3354b(JSONObject jSONObject) {
                    return Boolean.valueOf(true);
                }
            };
            this.f4608w.add(anonymousClass14);
            this.f4587b.m9361a(request, anonymousClass14);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3388b(int i, C1945a<Object> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6693l(i), C2522a.DELETE, null, 4);
            C2000b anonymousClass15 = new C2001b<Object>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4500a;

                public Object mo3354b(JSONObject jSONObject) {
                    return Boolean.valueOf(true);
                }
            };
            this.f4608w.add(anonymousClass15);
            this.f4587b.m9361a(request, anonymousClass15);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3389b(C1945a<List<Chart>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_charts(), 1);
            C2000b anonymousClass16 = new C2001b<List<Chart>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4501a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6405a(jSONObject);
                }

                public List<Chart> m6405a(JSONObject jSONObject) {
                    return this.f4501a.f4601p.m9207a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass16);
            this.f4587b.m9361a(request, anonymousClass16);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3371a(Chart chart, int i, int i2, C1945a<Chart> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_chartsFromNameWithOffsetAndLimit(chart.m6718a(), i, i2), 1);
            final int i3 = i;
            final Chart chart2 = chart;
            final int i4 = i2;
            C2000b anonymousClass17 = new C2001b<Chart>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4505d;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6407a(jSONObject);
                }

                public Chart m6407a(JSONObject jSONObject) {
                    Collection a = this.f4505d.f4601p.m9208a(jSONObject, i3);
                    List c = chart2.m6722c();
                    if (a.size() < i4) {
                        chart2.m6720a(true);
                    }
                    c.addAll(a);
                    return chart2;
                }
            };
            this.f4608w.add(anonymousClass17);
            this.f4587b.m9361a(request, anonymousClass17);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
            return new C2012a(null);
        }
    }

    public C2011b mo3380a(final User user, C1945a<User> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_userFromId(user.m6705g()), 1);
            C2000b anonymousClass18 = new C2001b<User>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4507b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6409a(jSONObject);
                }

                public User m6409a(JSONObject jSONObject) {
                    return this.f4507b.f4602q.m9302b(user, jSONObject);
                }
            };
            this.f4608w.add(anonymousClass18);
            this.f4587b.m9361a(request, anonymousClass18);
            return new C2012a(request);
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
            c1945a.mo3323a(new C2021d("Error on creating url."));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new C2012a(null);
    }

    public C2011b mo3379a(final User user, int i, final int i2, C1945a<List<C2028e>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_filmRatingsFromUserIdWithOffsetAndLimit(user.m6705g(), i, i2), 1);
            C2000b anonymousClass19 = new C2001b<List<C2028e>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4510c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6411a(jSONObject);
                }

                public List<C2028e> m6411a(JSONObject jSONObject) {
                    Collection c = this.f4510c.f4602q.m9303c(user, jSONObject);
                    List<C2028e> h = user.m6823h();
                    if (c.size() < i2) {
                        user.m6813b(true);
                    }
                    h.addAll(c);
                    return h;
                }
            };
            this.f4608w.add(anonymousClass19);
            this.f4587b.m9361a(request, anonymousClass19);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3397b(final User user, int i, final int i2, C1945a<List<C2028e>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_filmCommentsFromsUserIdWithOffsetAndLimit(user.m6705g(), i, i2), 1);
            C2000b anonymousClass20 = new C2001b<List<C2028e>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4514c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6415a(jSONObject);
                }

                public List<C2028e> m6415a(JSONObject jSONObject) {
                    Collection c = this.f4514c.f4602q.m9303c(user, jSONObject);
                    List<C2028e> h = user.m6823h();
                    if (c.size() < i2) {
                        user.m6813b(true);
                    }
                    h.addAll(c);
                    return h;
                }
            };
            this.f4608w.add(anonymousClass20);
            this.f4587b.m9361a(request, anonymousClass20);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3381a(final User user, final Section section, C1945a<List<Object>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_sectionFromUserIdAndSectionPath(user.m6705g(), section.sectionPath()), 1);
            C2000b anonymousClass21 = new C2001b<List<Object>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4517c;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6417a(jSONObject);
                }

                public List m6417a(JSONObject jSONObject) {
                    if (section == Section.FAVOURITE_USERS) {
                        return this.f4517c.f4602q.m9305e(user, jSONObject);
                    }
                    return this.f4517c.f4602q.m9304d(user, jSONObject);
                }
            };
            this.f4608w.add(anonymousClass21);
            this.f4587b.m9361a(request, anonymousClass21);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3362a(C1945a<List<ActivityEntity>> c1945a, int i) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_favoritesActivitiyWithOffset(i), 1);
            C2000b anonymousClass22 = new C2001b<List<ActivityEntity>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4518a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6419a(jSONObject);
                }

                public List m6419a(JSONObject jSONObject) {
                    return this.f4518a.f4603r.m9249a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass22);
            this.f4587b.m9361a(request, anonymousClass22);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3390b(C1945a<List<WatchlistMovie>> c1945a, int i) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_watchlistWithOffset(i), 1);
            C2000b anonymousClass24 = new C2001b<List<WatchlistMovie>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4521a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6423a(jSONObject);
                }

                public List m6423a(JSONObject jSONObject) {
                    return this.f4521a.f4604s.m9311a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass24);
            this.f4587b.m9361a(request, anonymousClass24);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3399c(int i, C1945a<Object> c1945a) {
        try {
            String d = this.csfdApiUrlHelper.url_watchlist();
            Map hashMap = new HashMap();
            hashMap.put("film_id", String.valueOf(i));
            Request request = new Request(d, C2522a.POST, hashMap, 4);
            C2000b anonymousClass25 = new C2001b<Object>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4522a;

                public Object mo3354b(JSONObject jSONObject) {
                    return Boolean.valueOf(true);
                }
            };
            this.f4608w.add(anonymousClass25);
            this.f4587b.m9361a(request, anonymousClass25);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3403d(int i, C1945a<Object> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_watchlistWithFilmId(i), C2522a.DELETE, null, 4);
            C2000b anonymousClass26 = new C2001b<Object>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4523a;

                public Object mo3354b(JSONObject jSONObject) {
                    return Boolean.valueOf(true);
                }
            };
            this.f4608w.add(anonymousClass26);
            this.f4587b.m9361a(request, anonymousClass26);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3367a(C1945a<List<C2030g>> c1945a, long j, int i, Enum_OrderBy c2020d) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_tvTipsWithOffsetAndDateTimeStampWithOrder(j, i, c2020d), 2);
            C2000b anonymousClass27 = new C2001b<List<C2030g>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4524a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6427a(jSONObject);
                }

                public List m6427a(JSONObject jSONObject) {
                    return this.f4524a.f4605t.m9295a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass27);
            this.f4587b.m9361a(request, anonymousClass27);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3400c(C1945a<List<TvStation>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_tvStations(), 2);
            C2000b anonymousClass28 = new C2001b<List<TvStation>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4525a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6429a(jSONObject);
                }

                public List m6429a(JSONObject jSONObject) {
                    return this.f4525a.f4605t.m9296b(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass28);
            this.f4587b.m9361a(request, anonymousClass28);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3385a(List<TvStation> list, C1945a<Boolean> c1945a) {
        try {
            String e = this.csfdApiUrlHelper.url_tvStations();
            List arrayList = new ArrayList();
            for (TvStation tvStation : list) {
                if (tvStation.m7069d()) {
                    arrayList.add(Integer.valueOf(tvStation.m7060a()));
                }
            }
            Map hashMap = new HashMap();
            hashMap.put("stations", C1998s.m6367a(arrayList, ","));
            Request request = new Request(e, hashMap, 2);
            C2000b anonymousClass29 = new C2001b<Boolean>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4526a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6431a(jSONObject);
                }

                public Boolean m6431a(JSONObject jSONObject) {
                    return Boolean.valueOf(true);
                }
            };
            this.f4608w.add(anonymousClass29);
            this.f4587b.m9361a(request, anonymousClass29);
            return new C2012a(request);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3369a(C1945a<List<TvStation>> c1945a, Date date, List<Integer> list, int i, boolean z) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.url_tvScheduleWithDateAndStationsIdsListWithOffset(date, (List) list, i), z ? 2 : 1);
            C2000b anonymousClass30 = new C2001b<List<TvStation>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4529a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6435a(jSONObject);
                }

                public List<TvStation> m6435a(JSONObject jSONObject) {
                    return this.f4529a.f4605t.m9296b(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass30);
            this.f4587b.m9361a(request, anonymousClass30);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3404d(C1945a<C2025b> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6686i(), 1);
            C2000b anonymousClass31 = new C2001b<C2025b>(this, c1945a, true) {
                final /* synthetic */ CsfdApiDataProvider f4530a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6437a(jSONObject);
                }

                public C2025b m6437a(JSONObject jSONObject) {
                    return this.f4530a.f4606u.m9205e(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass31);
            this.f4587b.m9361a(request, anonymousClass31);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3365a(C1945a<C2024a> c1945a, int i, int i2, String str, Map<String, String> map) {
        Log.d("CsfdApiDataProvider", "getAdBanner");
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6649a(i, i2, str, (Map) map), 2);
            C2000b anonymousClass32 = new C2001b<C2024a>(this, c1945a, true) {
                final /* synthetic */ CsfdApiDataProvider f4531a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6439a(jSONObject);
                }

                public C2024a m6439a(JSONObject jSONObject) {
                    return this.f4531a.f4606u.m9201a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass32);
            this.f4587b.m9361a(request, anonymousClass32);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3382a(final C2283b c2283b, Date date, C1945a<List<MovieInfo>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6653a(c2283b, date), 1);
            C2000b anonymousClass33 = new C2001b<List<MovieInfo>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4533b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6441a(jSONObject);
                }

                public List<MovieInfo> m6441a(JSONObject jSONObject) {
                    return this.f4533b.f4590e.m9261a(jSONObject, c2283b.toString().toLowerCase());
                }
            };
            this.f4608w.add(anonymousClass33);
            this.f4587b.m9361a(request, anonymousClass33);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3363a(C1945a<C2024a> c1945a, int i, int i2) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6646a(i, i2), 2);
            C2000b anonymousClass35 = new C2001b<C2024a>(this, c1945a, true) {
                final /* synthetic */ CsfdApiDataProvider f4536a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6445a(jSONObject);
                }

                public C2024a m6445a(JSONObject jSONObject) {
                    return this.f4536a.f4606u.m9202b(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass35);
            this.f4587b.m9361a(request, anonymousClass35);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3392b(C1945a<C2024a> c1945a, int i, int i2, String str, Map<String, String> map) {
        Log.d("CsfdApiDataProvider", "getAdBottom");
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6665b(i, i2, str, (Map) map), 2);
            C2000b anonymousClass36 = new C2001b<C2024a>(this, c1945a, true) {
                final /* synthetic */ CsfdApiDataProvider f4537a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6447a(jSONObject);
                }

                public C2024a m6447a(JSONObject jSONObject) {
                    return this.f4537a.f4606u.m9201a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass36);
            this.f4587b.m9361a(request, anonymousClass36);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3407e(C1945a<List<C2031h>> c1945a) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6683h(), 1);
            C2000b anonymousClass37 = new C2001b<List<C2031h>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4538a;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6449a(jSONObject);
                }

                public List<C2031h> m6449a(JSONObject jSONObject) {
                    return this.f4538a.f4598m.m9308a(jSONObject);
                }
            };
            this.f4608w.add(anonymousClass37);
            this.f4587b.m9361a(request, anonymousClass37);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3387b(int i, int i2, int i3, C1945a<List<MovieVideo>> c1945a, final Context context) {
        try {
            Request request = new Request(this.csfdApiUrlHelper.m6682g(i3, i, i2), 1);
            C2000b anonymousClass38 = new C2001b<List<MovieVideo>>(this, c1945a) {
                final /* synthetic */ CsfdApiDataProvider f4540b;

                public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                    return m6451a(jSONObject);
                }

                public List<MovieVideo> m6451a(JSONObject jSONObject) {
                    ((CsfdApplication) context.getApplicationContext()).m6212a(this.f4540b.f4606u.m9203c(jSONObject));
                    return this.f4540b.f4598m.m9309a(jSONObject, 0);
                }
            };
            this.f4608w.add(anonymousClass38);
            this.f4587b.m9361a(request, anonymousClass38);
            return new C2012a(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new C2012a(null);
        }
    }

    public C2011b mo3391b(C1945a<List<MessageThread>> c1945a, int i, int i2) {
        Request request = new Request(this.csfdApiUrlHelper.m6662b(i, i2), 2);
        C2000b anonymousClass39 = new C2001b<List<MessageThread>>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4541a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6453a(jSONObject);
            }

            public List<MessageThread> m6453a(JSONObject jSONObject) {
                return this.f4541a.f4607v.m9266a(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass39);
        this.f4587b.m9361a(request, anonymousClass39);
        return new C2012a(request);
    }

    public C2011b mo3364a(C1945a<List<Message>> c1945a, int i, int i2, int i3) {
        Request request = new Request(this.csfdApiUrlHelper.m6685h(i, i2, i3), 2);
        C2000b anonymousClass40 = new C2001b<List<Message>>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4544a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6457a(jSONObject);
            }

            public List<Message> m6457a(JSONObject jSONObject) {
                return this.f4544a.f4607v.m9267b(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass40);
        this.f4587b.m9361a(request, anonymousClass40);
        return new C2012a(request);
    }

    public C2011b mo3366a(C1945a<Message> c1945a, int i, String str) {
        String k = this.csfdApiUrlHelper.m6690k();
        Map hashMap = new HashMap();
        hashMap.put("user_id", String.valueOf(i));
        hashMap.put("text", str);
        Request request = new Request(k, C2522a.POST, hashMap, 4);
        C2000b anonymousClass41 = new C2001b<Message>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4545a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6459a(jSONObject);
            }

            public Message m6459a(JSONObject jSONObject) {
                return this.f4545a.f4607v.m9268c(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass41);
        this.f4587b.m9361a(request, anonymousClass41);
        return new C2012a(request);
    }

    public C2011b mo3370a(C1945a<Boolean> c1945a, List<Integer> list) {
        Request request = new Request(this.csfdApiUrlHelper.m6667b((List) list), 4);
        C2000b anonymousClass42 = new C2001b<Boolean>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4546a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6461a(jSONObject);
            }

            public Boolean m6461a(JSONObject jSONObject) {
                return Boolean.valueOf(true);
            }
        };
        this.f4608w.add(anonymousClass42);
        this.f4587b.m9361a(request, anonymousClass42);
        return new C2012a(request);
    }

    public C2011b mo3393b(C1945a<Boolean> c1945a, List<String> list) {
        Request request = new Request(this.csfdApiUrlHelper.m6671c((List) list), 4);
        C2000b anonymousClass43 = new C2001b<Boolean>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4547a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6463a(jSONObject);
            }

            public Boolean m6463a(JSONObject jSONObject) {
                return Boolean.valueOf(true);
            }
        };
        this.f4608w.add(anonymousClass43);
        this.f4587b.m9361a(request, anonymousClass43);
        return new C2012a(request);
    }

    public C2011b mo3409f(C1945a<Integer> c1945a) {
        Request request = new Request(this.csfdApiUrlHelper.m6688j(), 4);
        C2000b anonymousClass44 = new C2001b<Integer>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4548a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6465a(jSONObject);
            }

            public Integer m6465a(JSONObject jSONObject) {
                return Integer.valueOf(jSONObject.getInt("unreadThreads"));
            }
        };
        this.f4608w.add(anonymousClass44);
        this.f4587b.m9361a(request, anonymousClass44);
        return new C2012a(request);
    }

    public C2011b mo3410g(C1945a<List<User>> c1945a) {
        Request request = new Request(this.csfdApiUrlHelper.m6692l(), 1);
        C2000b anonymousClass46 = new C2001b<List<User>>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4552a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6469a(jSONObject);
            }

            public List<User> m6469a(JSONObject jSONObject) {
                return this.f4552a.f4607v.m9269d(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass46);
        this.f4587b.m9361a(request, anonymousClass46);
        return new C2012a(request);
    }

    public C2011b mo3368a(C1945a<List<User>> c1945a, String str, int i) {
        Request request = new Request(this.csfdApiUrlHelper.url_searchUsersWithQueryAndLimit(str, i), 1);
        C2000b anonymousClass47 = new C2001b<List<User>>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4553a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6471a(jSONObject);
            }

            public List<User> m6471a(JSONObject jSONObject) {
                return this.f4553a.f4594i.m9291b(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass47);
        this.f4587b.m9361a(request, anonymousClass47);
        return new C2012a(request);
    }

    public C2011b mo3401c(C1945a<Boolean> c1945a, int i) {
        Request request = new Request(this.csfdApiUrlHelper.m6694m(i), 4);
        C2000b anonymousClass48 = new C2001b<Boolean>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4554a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6473a(jSONObject);
            }

            public Boolean m6473a(JSONObject jSONObject) {
                return Boolean.valueOf(true);
            }
        };
        this.f4608w.add(anonymousClass48);
        this.f4587b.m9361a(request, anonymousClass48);
        return new C2012a(request);
    }

    public C2011b mo3405d(C1945a<Boolean> c1945a, int i) {
        Request request = new Request(this.csfdApiUrlHelper.m6695n(i), 4);
        C2000b anonymousClass49 = new C2001b<Boolean>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4555a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6475a(jSONObject);
            }

            public Boolean m6475a(JSONObject jSONObject) {
                return Boolean.valueOf(true);
            }
        };
        this.f4608w.add(anonymousClass49);
        this.f4587b.m9361a(request, anonymousClass49);
        return new C2012a(request);
    }

    public C2011b mo3408e(C1945a<Seasons> c1945a, int i) {
        Request request = new Request(this.csfdApiUrlHelper.m6696o(i), 1);
        C2000b anonymousClass50 = new C2001b<Seasons>(this, c1945a) {
            final /* synthetic */ CsfdApiDataProvider f4559a;

            public /* synthetic */ Object mo3354b(JSONObject jSONObject) {
                return m6479a(jSONObject);
            }

            public Seasons m6479a(JSONObject jSONObject) {
                return this.f4559a.f4592g.m9284f(jSONObject);
            }
        };
        this.f4608w.add(anonymousClass50);
        this.f4587b.m9361a(request, anonymousClass50);
        return new C2012a(request);
    }

    private JSONObject m6564a(String str) {
        JSONObject a = this.f4589d.m9264a(str);
        C1998s.m6372a(getClass(), "Retrieved JSON content: " + a.toString());
        if (!this.f4591f.m9246a(a)) {
            return a;
        }
        throw new C2021d(this.f4591f.m9247b(a));
    }
}
