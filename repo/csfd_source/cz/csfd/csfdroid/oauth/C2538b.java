package cz.csfd.csfdroid.oauth;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import cz.csfd.csfdroid.p061d.C1998s;

/* compiled from: OAuthAuthenticator */
public class C2538b extends AbstractAccountAuthenticator {
    private Context f6338a;
    private AccountManager f6339b;

    public C2538b(Context context) {
        super(context);
        this.f6338a = context;
        this.f6339b = AccountManager.get(context);
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        C1998s.m6372a(getClass(), "Adding account.");
        C1998s.m6372a(getClass(), "Starting login activity.");
        return m9385a(accountAuthenticatorResponse, str2);
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        throw new UnsupportedOperationException();
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        C1998s.m6372a(getClass(), "Getting auth token.");
        if (str.equals("cz.csfd.csfdroid.token")) {
            String password = this.f6339b.getPassword(account);
            if (password != null) {
                C1998s.m6372a(getClass(), "Returning auth token.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("authAccount", account.name);
                bundle2.putString("accountType", "cz.csfd.csfdroid.account");
                bundle2.putString("authtoken", password);
                this.f6339b.setAuthToken(account, "cz.csfd.csfdroid.token", password);
                return bundle2;
            }
            C1998s.m6372a(getClass(), "Starting login activity.");
            return m9385a(accountAuthenticatorResponse, str);
        }
        bundle2 = new Bundle();
        C1998s.m6372a(getClass(), "Invalid authtoken type.");
        bundle2.putString("errorMessage", "invalid authTokenType");
        return bundle2;
    }

    public String getAuthTokenLabel(String str) {
        return "OAuth";
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    private Bundle m9385a(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        Parcelable b = m9388b(accountAuthenticatorResponse, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", b);
        return bundle;
    }

    private Intent m9388b(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        Intent intent = new Intent(this.f6338a, OAuthCallbackActivity.class);
        intent.putExtra("authtokenType", str);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        return intent;
    }

    public static String m9387a(String str, String str2) {
        return str + ";" + str2;
    }

    public static String m9386a(String str) {
        String[] split = str.split(";");
        if (split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String m9389b(String str) {
        String[] split = str.split(";");
        if (split.length == 2) {
            return split[1];
        }
        return null;
    }
}
