package cz.csfd.csfdroid.oauth;

import android.content.Context;
import android.os.AsyncTask;
import com.p042c.p043a.C1123v;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.p062a.ConsumerSecretService;
import cz.csfd.csfdroid.net.CsfdHttpClient;
import cz.csfd.csfdroid.oauth.C2540c.C1959b;
import cz.csfd.csfdroid.oauth.C2540c.C2530a;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.concurrent.Executors;
import oauth.signpost.C0792d;
import oauth.signpost.C2564e;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import p025c.p026a.p027a.p028a.OkHttpOAuthConsumer;

/* compiled from: OAuthServiceImpl */
public class OAuthServiceImpl implements C2540c {
    private final String consumerSecret;
    private C2530a f6346b;
    private Context f6347c;
    private C2016c f6348d;
    private CsfdHttpClient f6349e;
    private C0792d okHttpAuthConsumer;
    private C2564e f6351g;
    private Object f6352h = new Object();
    private C2544b f6353i;
    private C2543a f6354j;

    /* compiled from: OAuthServiceImpl */
    private class C2543a extends AsyncTask<String, Void, Boolean> {
        final /* synthetic */ OAuthServiceImpl f6343a;

        /* compiled from: OAuthServiceImpl */
        class C25421 implements C1945a<Identity> {
            final /* synthetic */ C2543a f6342a;

            C25421(C2543a c2543a) {
                this.f6342a = c2543a;
            }

            public void m9397a(Identity identity) {
                C1983f.m6333a("OAuthServiceImpl", "AccessTokenTask onPostExecute: " + identity);
                synchronized (this.f6342a.f6343a.f6352h) {
                    String token = this.f6342a.f6343a.okHttpAuthConsumer.getToken();
                    String tokenSecret = this.f6342a.f6343a.okHttpAuthConsumer.getTokenSecret();
                }
                if (this.f6342a.f6343a.f6346b != null) {
                    this.f6342a.f6343a.f6346b.mo3678a(identity, token, tokenSecret);
                }
            }

            public void mo3323a(Exception exception) {
                if (this.f6342a.f6343a.f6346b != null) {
                    this.f6342a.f6343a.f6346b.mo3677a();
                }
            }

            public void mo3322a() {
                if (this.f6342a.f6343a.f6346b != null) {
                    this.f6342a.f6343a.f6346b.mo3677a();
                }
            }
        }

        private C2543a(OAuthServiceImpl c2545d) {
            this.f6343a = c2545d;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m9400a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m9401a((Boolean) obj);
        }

        // access token
        protected Boolean m9400a(String... strArr) {
            C1983f.m6333a("OAuthServiceImpl", "AccessTokenTask started.");
            String str = strArr[0];
            try {
                synchronized (this.f6343a.f6352h) {
                    this.f6343a.f6351g.retrieveAccessToken(this.f6343a.okHttpAuthConsumer, str, new String[0]);
                }
                return Boolean.valueOf(true);
            } catch (Exception e) {
                C1998s.m6371a(getClass(), e);
                return Boolean.valueOf(false);
            }
        }

        protected void m9401a(Boolean bool) {
            if (bool.booleanValue()) {
                this.f6343a.f6348d.mo3361a(new C25421(this));
            } else if (this.f6343a.f6346b != null) {
                this.f6343a.f6346b.mo3677a();
            }
        }
    }

    /* compiled from: OAuthServiceImpl */
    private class C2544b extends AsyncTask<String, Integer, String> {
        final /* synthetic */ OAuthServiceImpl parentAuthService;

        private C2544b(OAuthServiceImpl c2545d) {
            this.parentAuthService = c2545d;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m9402a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m9403a((String) obj);
        }

        protected String m9402a(String... strArr) {
            C1983f.m6333a("OAuthServiceImpl", "RequestTokenTask started.");
            try {
                String retrieveRequestToken;
                synchronized (this.parentAuthService.f6352h) {
                    retrieveRequestToken = this.parentAuthService.f6351g.retrieveRequestToken(this.parentAuthService.okHttpAuthConsumer, "csfdroid://oauth-callback", new String[0]);
                }
                return retrieveRequestToken;
            } catch (Exception e) {
                C1998s.m6371a(getClass(), e);
                return null;
            }
        }

        protected void m9403a(String str) {
            C1983f.m6333a("OAuthServiceImpl", "RequestTokenTask onPostExecute: " + str);
            if (str == null) {
                this.parentAuthService.f6346b.mo3677a();
            } else {
                this.parentAuthService.m9408b(str);
            }
        }
    }

    public OAuthServiceImpl(CsfdHttpClient c2517b, ConsumerSecretService consumerSecretService) {
        this.f6349e = c2517b;
        this.consumerSecret = consumerSecretService.mo3356a(); // generate consumer secret
        m9407b();
    }

    private void m9407b() {
        C1983f.m6333a("OAuthServiceImpl", "Initializing OAuth consumer and provider.");
        synchronized (this.f6352h) {
            this.okHttpAuthConsumer = new OkHttpOAuthConsumer("061025241049", this.consumerSecret); // 061025241049 = api_consumer_key
            this.f6351g = new CommonsHttpOAuthProvider(m9409c(), m9412d(), m9414e());
        }
    }

    public void mo3682a(Context context, C2016c c2016c, C2530a c2530a) {
        this.f6346b = c2530a;
        this.f6347c = context;
        this.f6348d = c2016c;
        mo3681a();
        this.f6353i = new C2544b();
        this.f6353i.execute(new String[0]);
    }

    public void mo3683a(final C1959b c1959b) {
        Executors.newSingleThreadExecutor().execute(new Runnable(this) {
            final /* synthetic */ OAuthServiceImpl f6341b;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r4 = 0;
                r0 = r5.f6341b;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r1 = r0.f6352h;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                monitor-enter(r1);	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r0 = r5.f6341b;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r0 = r0.f6349e;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r2 = r5.f6341b;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r2 = r2.okHttpAuthConsumer;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r3 = r5.f6341b;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r3 = r3.m9415f();	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r2 = r2.sign(r3);	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r0.mo3669a(r2);	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                monitor-exit(r1);	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                r0 = r5.f6341b;
                r0.mo3685a(r4, r4);
                r0 = r3;
                if (r0 == 0) goto L_0x0030;
            L_0x002b:
                r0 = r3;
                r0.mo3329a();
            L_0x0030:
                return;
            L_0x0031:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
                throw r0;	 Catch:{ c -> 0x0034, d -> 0x004b, c -> 0x0062, a -> 0x0079 }
            L_0x0034:
                r0 = move-exception;
                r1 = r5.getClass();	 Catch:{ all -> 0x0090 }
                cz.csfd.csfdroid.p061d.C1998s.m6371a(r1, r0);	 Catch:{ all -> 0x0090 }
                r0 = r5.f6341b;
                r0.mo3685a(r4, r4);
                r0 = r3;
                if (r0 == 0) goto L_0x0030;
            L_0x0045:
                r0 = r3;
                r0.mo3329a();
                goto L_0x0030;
            L_0x004b:
                r0 = move-exception;
                r1 = r5.getClass();	 Catch:{ all -> 0x0090 }
                cz.csfd.csfdroid.p061d.C1998s.m6371a(r1, r0);	 Catch:{ all -> 0x0090 }
                r0 = r5.f6341b;
                r0.mo3685a(r4, r4);
                r0 = r3;
                if (r0 == 0) goto L_0x0030;
            L_0x005c:
                r0 = r3;
                r0.mo3329a();
                goto L_0x0030;
            L_0x0062:
                r0 = move-exception;
                r1 = r5.getClass();	 Catch:{ all -> 0x0090 }
                cz.csfd.csfdroid.p061d.C1998s.m6371a(r1, r0);	 Catch:{ all -> 0x0090 }
                r0 = r5.f6341b;
                r0.mo3685a(r4, r4);
                r0 = r3;
                if (r0 == 0) goto L_0x0030;
            L_0x0073:
                r0 = r3;
                r0.mo3329a();
                goto L_0x0030;
            L_0x0079:
                r0 = move-exception;
                r1 = r5.getClass();	 Catch:{ all -> 0x0090 }
                cz.csfd.csfdroid.p061d.C1998s.m6371a(r1, r0);	 Catch:{ all -> 0x0090 }
                r0 = r5.f6341b;
                r0.mo3685a(r4, r4);
                r0 = r3;
                if (r0 == 0) goto L_0x0030;
            L_0x008a:
                r0 = r3;
                r0.mo3329a();
                goto L_0x0030;
            L_0x0090:
                r0 = move-exception;
                r1 = r5.f6341b;
                r1.mo3685a(r4, r4);
                r1 = r3;
                if (r1 == 0) goto L_0x009f;
            L_0x009a:
                r1 = r3;
                r1.mo3329a();
            L_0x009f:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.csfd.csfdroid.oauth.d.1.run():void");
            }
        });
    }

    public void mo3681a() {
        if (this.f6354j != null) {
            this.f6354j.cancel(true);
            this.f6354j = null;
        }
        if (this.f6353i != null) {
            this.f6353i.cancel(true);
            this.f6353i = null;
        }
        mo3685a(null, null);
    }

    public void mo3684a(String str) {
        if (this.f6354j != null) {
            this.f6354j.cancel(true);
        }
        this.f6354j = new C2543a();
        this.f6354j.execute(new String[]{str});
    }

    public void mo3685a(String str, String str2) {
        if (str == null || str2 == null) {
            m9407b();
            return;
        }
        synchronized (this.f6352h) {
            this.okHttpAuthConsumer.setTokenWithSecret(str, str2);
        }
    }

    public synchronized C1123v mo3680a(C1123v c1123v) {
        C1123v c1123v2;
        try {
            synchronized (this.f6352h) {
                c1123v2 = (C1123v) this.okHttpAuthConsumer.sign((Object) c1123v).unwrap();
            }
        } catch (Throwable e) {
            throw new C2546f(e);
        }
        return c1123v2;
    }

    private void m9408b(String str) {
        this.f6346b.mo3679a(str);
    }

    private String m9409c() {
        return "https://android-api.csfd.cz/oauth/request-token";
    }

    private String m9412d() {
        return "https://android-api.csfd.cz/oauth/access-token";
    }

    private String m9414e() {
        return "https://android-api.csfd.cz/oauth/authorize";
    }

    private String m9415f() {
        return "https://android-api.csfd.cz/oauth/logout";
    }
}
