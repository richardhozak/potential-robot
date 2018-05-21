package cz.csfd.csfdroid.oauth;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.p030a.p031a.C0831a;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.entity.Identity.Acl;
import cz.csfd.csfdroid.oauth.C2540c.C2530a;
import cz.csfd.csfdroid.p061d.C1998s;
import java.net.URLEncoder;
import java.util.Map.Entry;

public class OAuthCallbackActivity extends AccountAuthenticatorActivity {
    private CsfdApplication f6330a;
    private boolean f6331b = false;
    private AccountManager f6332c;
    private WebView f6333d;
    private View f6334e;
    private C2537a f6335f;
    private boolean f6336g;
    private String f6337h;

    class C25322 extends WebViewClient {
        final /* synthetic */ OAuthCallbackActivity f6323a;

        C25322(OAuthCallbackActivity oAuthCallbackActivity) {
            this.f6323a = oAuthCallbackActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            Log.d("OAuthCallbackActivity", "onPageFinished " + str);
            if (!str.startsWith("https://www.csfd.cz/csfdroid/fb/") && !str.startsWith("csfdroid://oauth-callback")) {
                this.f6323a.f6333d.setVisibility(0);
                this.f6323a.f6334e.setVisibility(8);
                this.f6323a.f6333d.setBackgroundColor(0);
                if (VERSION.SDK_INT >= 11) {
                    this.f6323a.f6333d.setLayerType(1, null);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.d("OAuthCallbackActivity", "shouldOverrideUrlLoading " + str);
            Uri parse = Uri.parse(str);
            if (str.startsWith("csfdroid://oauth-callback")) {
                this.f6323a.m9374a(parse);
                this.f6323a.f6333d.setVisibility(8);
                this.f6323a.f6334e.setVisibility(0);
                return true;
            } else if (str.startsWith("https://www.csfd.cz/csfdroid/fb/init")) {
                this.f6323a.f6333d.setVisibility(8);
                this.f6323a.f6334e.setVisibility(0);
                return this.f6323a.f6335f.m9383a(webView, parse);
            } else if (!str.startsWith("https://www.csfd.cz/csfdroid/fb/redirect")) {
                return false;
            } else {
                this.f6323a.f6333d.setVisibility(8);
                this.f6323a.f6334e.setVisibility(0);
                return this.f6323a.f6335f.m9384a(webView, parse, this.f6323a.f6337h);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.d("OAuthCallbackActivity", "onPageStarted " + str);
        }
    }

    class C25353 extends WebChromeClient {
        final /* synthetic */ OAuthCallbackActivity f6328a;

        C25353(OAuthCallbackActivity oAuthCallbackActivity) {
            this.f6328a = oAuthCallbackActivity;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            Builder builder = new Builder(this.f6328a);
            builder.setMessage(str2);
            builder.setCancelable(true);
            builder.setPositiveButton(17039370, new OnClickListener(this) {
                final /* synthetic */ C25353 f6325b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.setOnCancelListener(new OnCancelListener(this) {
                final /* synthetic */ C25353 f6327b;

                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            try {
                builder.create().show();
            } catch (Throwable e) {
                e.printStackTrace();
                C0831a.m3752a(e);
            }
            return true;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webView.getHitTestResult().getExtra())));
            return false;
        }
    }

    class C25364 implements OnTouchListener {
        final /* synthetic */ OAuthCallbackActivity f6329a;

        C25364(OAuthCallbackActivity oAuthCallbackActivity) {
            this.f6329a = oAuthCallbackActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                case 1:
                    if (!view.hasFocus()) {
                        view.requestFocus();
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.oauth_callback);
        this.f6330a = C1998s.m6365a((Context) this);
        this.f6332c = AccountManager.get(this);
        this.f6335f = new C2537a();
        if (this.f6330a.m6229q().m6250a()) {
            Toast.makeText(this, R.string.login_account_exists, 1).show();
            finish();
            return;
        }
        m9373a();
        this.f6334e = findViewById(R.id.dialog_progress_message);
        final String stringExtra = getIntent().getStringExtra("authtokenType");
        this.f6330a.m6228p().mo3682a(this, this.f6330a.m6220h(), new C2530a(this) {
            final /* synthetic */ OAuthCallbackActivity f6322b;

            public void mo3678a(Identity identity, String str, String str2) {
                String b = identity.m6811b();
                Account account = new Account(b, "cz.csfd.csfdroid.account");
                String a = C2538b.m9387a(str, str2);
                this.f6322b.f6332c.addAccountExplicitly(account, a, this.f6322b.m9370a(identity));
                Intent intent = new Intent();
                intent.putExtra("authAccount", b);
                intent.putExtra("accountType", "cz.csfd.csfdroid.account");
                if (stringExtra != null && stringExtra.equals("cz.csfd.csfdroid.token")) {
                    intent.putExtra("authtoken", a);
                }
                this.f6322b.setAccountAuthenticatorResult(intent.getExtras());
                this.f6322b.setResult(-1, intent);
                Toast.makeText(this.f6322b, R.string.login_success, 0).show();
                this.f6322b.f6336g = true;
                this.f6322b.finish();
            }

            public void mo3677a() {
                Toast.makeText(this.f6322b, R.string.login_failure, 0).show();
                this.f6322b.finish();
            }

            public void mo3679a(String str) {
                String str2 = str + "&fb_callback=" + URLEncoder.encode("https://www.csfd.cz/csfdroid/fb/init");
                this.f6322b.f6337h = str2;
                this.f6322b.f6333d.loadUrl(str2);
                this.f6322b.f6333d.setBackgroundColor(0);
                if (VERSION.SDK_INT >= 11) {
                    this.f6322b.f6333d.setLayerType(1, null);
                }
            }
        });
    }

    private void m9373a() {
        this.f6333d = (WebView) findViewById(R.id.login_webview);
        this.f6333d.getSettings().setBuiltInZoomControls(true);
        this.f6333d.getSettings().setJavaScriptEnabled(true);
        this.f6333d.getSettings().setSaveFormData(false);
        this.f6333d.getSettings().setSavePassword(false);
        this.f6333d.getSettings().setSupportMultipleWindows(true);
        if (VERSION.SDK_INT >= 21) {
            this.f6333d.getSettings().setMixedContentMode(0);
        }
        this.f6333d.setWebViewClient(new C25322(this));
        this.f6333d.setWebChromeClient(new C25353(this));
        this.f6333d.requestFocus(TransportMediator.KEYCODE_MEDIA_RECORD);
        this.f6333d.setOnTouchListener(new C25364(this));
    }

    protected void onStop() {
        super.onStop();
        if (!this.f6336g) {
            m9378b();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m9378b();
    }

    private void m9378b() {
        this.f6330a.m6228p().mo3681a();
        Toast.makeText(this, R.string.login_cancelled, 0).show();
        finish();
    }

    private void m9374a(Uri uri) {
        if (uri.toString().startsWith("csfdroid://oauth-callback")) {
            C1998s.m6365a((Context) this).m6228p().mo3684a(uri.getQueryParameter("oauth_verifier"));
        }
    }

    private Bundle m9370a(Identity identity) {
        Bundle bundle = new Bundle();
        for (Entry entry : identity.m6829a().entrySet()) {
            bundle.putString(((Acl) entry.getKey()).m6805a(), ((Boolean) entry.getValue()).toString());
        }
        bundle.putString("user_id", String.valueOf(identity.m6705g()));
        bundle.putString("avatar", identity.m6817d());
        return bundle;
    }
}
