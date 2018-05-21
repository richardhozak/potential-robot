package oauth.signpost;

import java.util.Random;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;
import oauth.signpost.p068a.C2558a;
import oauth.signpost.p069b.C2560a;
import oauth.signpost.p069b.C2561c;
import oauth.signpost.p070d.C2569f;
import oauth.signpost.p070d.C2570a;
import oauth.signpost.p070d.C2571c;
import oauth.signpost.p070d.C2572b;
import oauth.signpost.p070d.C2573d;

/* compiled from: AbstractOAuthConsumer */
public abstract class C0793a implements C0792d {
    private static final long serialVersionUID = 1;
    private C2566a additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private C2571c messageSigner;
    private final Random random = new Random(System.nanoTime());
    private C2566a requestParameters;
    private boolean sendEmptyTokens;
    private C2569f signingStrategy;
    private String token;

    protected abstract C0795b wrap(Object obj);

    public C0793a(String str, String str2) {
        this.consumerKey = str;
        this.consumerSecret = str2;
        setMessageSigner(new C2572b());
        setSigningStrategy(new C2570a());
    }

    public void setMessageSigner(C2571c c2571c) {
        this.messageSigner = c2571c;
        c2571c.m9509a(this.consumerSecret);
    }

    public void setSigningStrategy(C2569f c2569f) {
        this.signingStrategy = c2569f;
    }

    public void setAdditionalParameters(C2566a c2566a) {
        this.additionalParameters = c2566a;
    }

    public synchronized C0795b sign(C0795b c0795b) {
        if (this.consumerKey == null) {
            throw new C2561c("consumer key not set");
        } else if (this.consumerSecret == null) {
            throw new C2561c("consumer secret not set");
        } else {
            this.requestParameters = new C2566a();
            try {
                if (this.additionalParameters != null) {
                    this.requestParameters.m9489a(this.additionalParameters, false);
                }
                collectHeaderParameters(c0795b, this.requestParameters);
                collectQueryParameters(c0795b, this.requestParameters);
                collectBodyParameters(c0795b, this.requestParameters);
                completeOAuthParameters(this.requestParameters);
                this.requestParameters.m9494d("oauth_signature");
                String a = this.messageSigner.mo3701a(c0795b, this.requestParameters);
                C2568c.m9500b("signature", a);
                this.signingStrategy.mo3699a(a, c0795b, this.requestParameters);
                C2568c.m9500b("Request URL", c0795b.getRequestUrl());
            } catch (Exception e) {
                throw new C2560a(e);
            }
        }
        return c0795b;
    }

    public synchronized C0795b sign(Object obj) {
        return sign(wrap(obj));
    }

    public synchronized String sign(String str) {
        C0795b c2558a;
        c2558a = new C2558a(str);
        C2569f c2569f = this.signingStrategy;
        this.signingStrategy = new C2573d();
        sign(c2558a);
        this.signingStrategy = c2569f;
        return c2558a.getRequestUrl();
    }

    public void setTokenWithSecret(String str, String str2) {
        this.token = str;
        this.messageSigner.m9511b(str2);
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.messageSigner.m9512c();
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    protected void completeOAuthParameters(C2566a c2566a) {
        if (!c2566a.containsKey("oauth_consumer_key")) {
            c2566a.m9484a("oauth_consumer_key", this.consumerKey, true);
        }
        if (!c2566a.containsKey("oauth_signature_method")) {
            c2566a.m9484a("oauth_signature_method", this.messageSigner.mo3700a(), true);
        }
        if (!c2566a.containsKey("oauth_timestamp")) {
            c2566a.m9484a("oauth_timestamp", generateTimestamp(), true);
        }
        if (!c2566a.containsKey("oauth_nonce")) {
            c2566a.m9484a("oauth_nonce", generateNonce(), true);
        }
        if (!c2566a.containsKey("oauth_version")) {
            c2566a.m9484a("oauth_version", "1.0", true);
        }
        if (!c2566a.containsKey("oauth_token")) {
            if ((this.token != null && !this.token.equals("")) || this.sendEmptyTokens) {
                c2566a.m9484a("oauth_token", this.token, true);
            }
        }
    }

    public C2566a getRequestParameters() {
        return this.requestParameters;
    }

    public void setSendEmptyTokens(boolean z) {
        this.sendEmptyTokens = z;
    }

    protected void collectHeaderParameters(C0795b c0795b, C2566a c2566a) {
        c2566a.m9489a(C2568c.m9503e(c0795b.getHeader("Authorization")), false);
    }

    protected void collectBodyParameters(C0795b c0795b, C2566a c2566a) {
        String contentType = c0795b.getContentType();
        if (contentType != null && contentType.startsWith("application/x-www-form-urlencoded")) {
            c2566a.m9489a(C2568c.m9498a(c0795b.getMessagePayload()), true);
        }
    }

    protected void collectQueryParameters(C0795b c0795b, C2566a c2566a) {
        String requestUrl = c0795b.getRequestUrl();
        int indexOf = requestUrl.indexOf(63);
        if (indexOf >= 0) {
            c2566a.m9489a(C2568c.m9501c(requestUrl.substring(indexOf + 1)), true);
        }
    }

    protected String generateTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    protected String generateNonce() {
        return Long.toString(this.random.nextLong());
    }
}
