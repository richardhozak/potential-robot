package cz.csfd.csfdroid.oauth;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import java.net.URLEncoder;

/* compiled from: FacebookAuthHelper */
public class C2537a {
    public boolean m9383a(WebView webView, Uri uri) {
        String queryParameter = uri.getQueryParameter("fb_app_id");
        if (queryParameter != null) {
            webView.loadUrl(m9382a(queryParameter));
            return true;
        }
        Log.e("FacebookAuthHelper", "fb_app_id param is not set");
        return false;
    }

    public boolean m9384a(WebView webView, Uri uri, String str) {
        String queryParameter = uri.getQueryParameter("code");
        if (queryParameter != null) {
            webView.loadUrl(str + "&" + "fb_code" + "=" + queryParameter + "&" + "fb_redirect_uri" + "=" + URLEncoder.encode("https://www.csfd.cz/csfdroid/fb/redirect"));
        } else {
            Log.e("FacebookAuthHelper", "code param is not set, redirecting to login page");
            webView.loadUrl(str);
        }
        return true;
    }

    private String m9382a(String str) {
        return "https://www.facebook.com/dialog/oauth?client_id=" + str + "&" + "redirect_uri" + "=" + "https://www.csfd.cz/csfdroid/fb/redirect" + "&" + "response_type" + "=" + "code";
    }
}
