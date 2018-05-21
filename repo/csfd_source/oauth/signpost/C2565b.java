package oauth.signpost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.p029c.C0795b;
import oauth.signpost.p029c.C2566a;
import oauth.signpost.p029c.C2567c;
import oauth.signpost.p069b.C2560a;
import oauth.signpost.p069b.C2561c;
import oauth.signpost.p069b.C2563e;
import org.apache.http.HttpStatus;

/* compiled from: AbstractOAuthProvider */
public abstract class C2565b implements C2564e {
    private static final long serialVersionUID = 1;
    private String accessTokenEndpointUrl;
    private String authorizationWebsiteUrl;
    private Map<String, String> defaultHeaders = new HashMap();
    private boolean isOAuth10a;
    private transient C2575f listener;
    private String requestTokenEndpointUrl;
    private C2566a responseParameters = new C2566a();

    protected abstract C0795b createRequest(String str);

    protected abstract C2567c sendRequest(C0795b c0795b);

    public C2565b(String str, String str2, String str3) {
        this.requestTokenEndpointUrl = str;
        this.accessTokenEndpointUrl = str2;
        this.authorizationWebsiteUrl = str3;
    }

    public synchronized String retrieveRequestToken(C0792d c0792d, String str, String... strArr) {
        String b;
        c0792d.setTokenWithSecret(null, null);
        C2566a c2566a = new C2566a();
        c2566a.m9490a(strArr, true);
        c2566a.m9484a("oauth_callback", str, true);
        retrieveToken(c0792d, this.requestTokenEndpointUrl, c2566a);
        b = this.responseParameters.m9491b("oauth_callback_confirmed");
        this.responseParameters.m9494d("oauth_callback_confirmed");
        this.isOAuth10a = Boolean.TRUE.toString().equals(b);
        if (this.isOAuth10a) {
            b = C2568c.m9497a(this.authorizationWebsiteUrl, "oauth_token", c0792d.getToken());
        } else {
            b = C2568c.m9497a(this.authorizationWebsiteUrl, "oauth_token", c0792d.getToken(), "oauth_callback", str);
        }
        return b;
    }

    public synchronized void retrieveAccessToken(C0792d c0792d, String str, String... strArr) {
        if (c0792d.getToken() == null || c0792d.getTokenSecret() == null) {
            throw new C2561c("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
        }
        C2566a c2566a = new C2566a();
        c2566a.m9490a(strArr, true);
        if (this.isOAuth10a && str != null) {
            c2566a.m9484a("oauth_verifier", str, true);
        }
        retrieveToken(c0792d, this.accessTokenEndpointUrl, c2566a);
    }

    protected void retrieveToken(C0792d c0792d, String str, C2566a c2566a) {
        C0795b createRequest;
        C2567c sendRequest;
        C2563e e;
        Throwable th;
        C2561c e2;
        Exception e3;
        Object obj;
        C0795b c0795b = null;
        Map requestHeaders = getRequestHeaders();
        if (c0792d.getConsumerKey() == null || c0792d.getConsumerSecret() == null) {
            throw new C2561c("Consumer key or secret not set");
        }
        try {
            createRequest = createRequest(str);
            try {
                for (String str2 : requestHeaders.keySet()) {
                    createRequest.setHeader(str2, (String) requestHeaders.get(str2));
                }
                if (c2566a != null) {
                    if (!c2566a.isEmpty()) {
                        c0792d.setAdditionalParameters(c2566a);
                    }
                }
                if (this.listener != null) {
                    this.listener.m9519a(createRequest);
                }
                c0792d.sign(createRequest);
                if (this.listener != null) {
                    this.listener.m9521b(createRequest);
                }
                sendRequest = sendRequest(createRequest);
            } catch (C2563e e4) {
                e = e4;
                sendRequest = null;
                c0795b = createRequest;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    createRequest = c0795b;
                }
            } catch (C2561c e5) {
                e2 = e5;
                sendRequest = null;
                throw e2;
            } catch (Exception e6) {
                e3 = e6;
                obj = null;
                throw new C2560a(e3);
            } catch (Throwable th3) {
                th = th3;
                sendRequest = null;
                try {
                    closeConnection(createRequest, sendRequest);
                    throw th;
                } catch (Exception e32) {
                    throw new C2560a(e32);
                }
            }
            try {
                int statusCode = sendRequest.getStatusCode();
                boolean z = false;
                if (this.listener != null) {
                    z = this.listener.m9520a(createRequest, sendRequest);
                }
                if (z) {
                    try {
                        closeConnection(createRequest, sendRequest);
                        return;
                    } catch (Exception e322) {
                        throw new C2560a(e322);
                    }
                }
                if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES) {
                    handleUnexpectedResponse(statusCode, sendRequest);
                }
                C2566a a = C2568c.m9498a(sendRequest.getContent());
                String b = a.m9491b("oauth_token");
                String b2 = a.m9491b("oauth_token_secret");
                a.m9494d("oauth_token");
                a.m9494d("oauth_token_secret");
                setResponseParameters(a);
                if (b == null || b2 == null) {
                    throw new C2561c("Request token or token secret not set in server reply. The service provider you use is probably buggy.");
                }
                c0792d.setTokenWithSecret(b, b2);
                try {
                    closeConnection(createRequest, sendRequest);
                } catch (Exception e3222) {
                    throw new C2560a(e3222);
                }
            } catch (C2563e e7) {
                e = e7;
                c0795b = createRequest;
                throw e;
            } catch (C2561c e8) {
                e2 = e8;
                throw e2;
            } catch (Exception e9) {
                e3222 = e9;
                throw new C2560a(e3222);
            }
        } catch (C2563e e10) {
            e = e10;
            sendRequest = null;
            throw e;
        } catch (C2561c e11) {
            e2 = e11;
            sendRequest = null;
            createRequest = null;
            throw e2;
        } catch (Exception e12) {
            e3222 = e12;
            obj = null;
            Object obj2 = null;
            throw new C2560a(e3222);
        } catch (Throwable th4) {
            th = th4;
            closeConnection(createRequest, sendRequest);
            throw th;
        }
    }

    protected void handleUnexpectedResponse(int i, C2567c c2567c) {
        if (c2567c != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c2567c.getContent()));
            StringBuilder stringBuilder = new StringBuilder();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuilder.append(readLine);
            }
            switch (i) {
                case HttpStatus.SC_UNAUTHORIZED /*401*/:
                    throw new C2563e(stringBuilder.toString());
                default:
                    throw new C2560a("Service provider responded in error: " + i + " (" + c2567c.getReasonPhrase() + ")", stringBuilder.toString());
            }
        }
    }

    protected void closeConnection(C0795b c0795b, C2567c c2567c) {
    }

    public C2566a getResponseParameters() {
        return this.responseParameters;
    }

    protected String getResponseParameter(String str) {
        return this.responseParameters.m9491b(str);
    }

    public void setResponseParameters(C2566a c2566a) {
        this.responseParameters = c2566a;
    }

    public void setOAuth10a(boolean z) {
        this.isOAuth10a = z;
    }

    public boolean isOAuth10a() {
        return this.isOAuth10a;
    }

    public String getRequestTokenEndpointUrl() {
        return this.requestTokenEndpointUrl;
    }

    public String getAccessTokenEndpointUrl() {
        return this.accessTokenEndpointUrl;
    }

    public String getAuthorizationWebsiteUrl() {
        return this.authorizationWebsiteUrl;
    }

    public void setRequestHeader(String str, String str2) {
        this.defaultHeaders.put(str, str2);
    }

    public Map<String, String> getRequestHeaders() {
        return this.defaultHeaders;
    }

    public void setListener(C2575f c2575f) {
        this.listener = c2575f;
    }

    public void removeListener(C2575f c2575f) {
        this.listener = null;
    }
}
