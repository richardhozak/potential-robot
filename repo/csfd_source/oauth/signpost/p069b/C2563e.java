package oauth.signpost.p069b;

/* compiled from: OAuthNotAuthorizedException */
public class C2563e extends C2559b {
    private String f6418a;

    public C2563e() {
        super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
    }

    public C2563e(String str) {
        super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
        this.f6418a = str;
    }
}
