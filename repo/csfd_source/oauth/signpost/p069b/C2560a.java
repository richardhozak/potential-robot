package oauth.signpost.p069b;

/* compiled from: OAuthCommunicationException */
public class C2560a extends C2559b {
    private String f6417a;

    public C2560a(Exception exception) {
        super("Communication with the service provider failed: " + exception.getLocalizedMessage(), exception);
    }

    public C2560a(String str, String str2) {
        super(str);
        this.f6417a = str2;
    }
}
