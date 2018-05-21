package cz.csfd.csfdroid;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import com.onesignal.ae;
import cz.csfd.csfdroid.data.C2016c;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.C2016c.C2011b;
import cz.csfd.csfdroid.data.entity.Identity;
import cz.csfd.csfdroid.data.entity.Identity.Acl;
import cz.csfd.csfdroid.oauth.C2538b;
import cz.csfd.csfdroid.oauth.C2540c;
import cz.csfd.csfdroid.oauth.C2540c.C1959b;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.Map.Entry;

/* compiled from: Accounts */
public class C1950a {
    private C2016c f4412a;
    private AccountManager f4413b;
    private C2540c f4414c;
    private C2011b f4415d;
    private C1948b f4416e;

    /* compiled from: Accounts */
    class C19463 implements C1945a<Identity> {
        final /* synthetic */ C1950a f4411a;

        C19463(C1950a c1950a) {
            this.f4411a = c1950a;
        }

        public void m6238a(Identity identity) {
            Account f = this.f4411a.m6256f();
            for (Entry entry : identity.m6829a().entrySet()) {
                this.f4411a.f4413b.setUserData(f, ((Acl) entry.getKey()).m6805a(), ((Boolean) entry.getValue()).toString());
            }
            this.f4411a.f4413b.setUserData(f, "user_id", String.valueOf(identity.m6705g()));
            this.f4411a.f4413b.setUserData(f, "avatar", identity.m6817d());
            ae.m5823a("user_id", String.valueOf(identity.m6705g()));
            if (this.f4411a.f4416e != null) {
                this.f4411a.f4416e.mo3534a();
            }
        }

        public void mo3323a(Exception exception) {
            C1998s.m6371a(getClass(), exception);
        }

        public void mo3322a() {
        }
    }

    /* compiled from: Accounts */
    public interface C1947a {
        void mo3328a();
    }

    /* compiled from: Accounts */
    public interface C1948b {
        void mo3534a();
    }

    public C1950a(AccountManager accountManager, C2540c c2540c, C2016c c2016c) {
        this.f4412a = c2016c;
        this.f4413b = accountManager;
        this.f4414c = c2540c;
    }

    public void m6246a(Activity activity, final C1947a c1947a) {
        if (m6256f() == null) {
            this.f4413b.addAccount("cz.csfd.csfdroid.account", "cz.csfd.csfdroid.token", null, null, activity, new AccountManagerCallback<Bundle>(this) {
                final /* synthetic */ C1950a f4408b;

                public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                    try {
                        Bundle bundle = (Bundle) accountManagerFuture.getResult();
                        if (c1947a != null && bundle.getString("accountType").equals("cz.csfd.csfdroid.account")) {
                            c1947a.mo3328a();
                        }
                    } catch (Exception e) {
                        C1998s.m6371a(getClass(), e);
                    } catch (Exception e2) {
                        C1998s.m6371a(getClass(), e2);
                    } catch (Exception e22) {
                        C1998s.m6371a(getClass(), e22);
                    }
                }
            }, null);
        }
    }

    public boolean m6250a() {
        return m6256f() != null;
    }

    public void m6249a(final C2540c c2540c) {
        Account f = m6256f();
        if (f != null) {
            this.f4413b.getAuthToken(f, "cz.csfd.csfdroid.token", false, new AccountManagerCallback<Bundle>(this) {
                final /* synthetic */ C1950a f4410b;

                public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                    try {
                        String string = ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
                        String a = C2538b.m9386a(string);
                        string = C2538b.m9389b(string);
                        if (a != null && string != null) {
                            c2540c.mo3685a(a, string);
                        }
                    } catch (Exception e) {
                        C1998s.m6371a(getClass(), e);
                    } catch (Exception e2) {
                        C1998s.m6371a(getClass(), e2);
                    } catch (Exception e22) {
                        C1998s.m6371a(getClass(), e22);
                    }
                }
            }, null);
        }
    }

    public void m6252b() {
        m6248a(null);
    }

    public void m6248a(C1959b c1959b) {
        for (Account removeAccount : this.f4413b.getAccountsByType("cz.csfd.csfdroid.account")) {
            this.f4413b.removeAccount(removeAccount, null, null);
        }
        this.f4414c.mo3683a(c1959b);
        ae.m5821a("user_id");
        if (this.f4415d != null) {
            this.f4415d.mo3355a();
        }
    }

    public boolean m6251a(Acl acl) {
        return Boolean.valueOf(this.f4413b.getUserData(m6256f(), acl.m6805a())).booleanValue();
    }

    public int m6253c() {
        Account f = m6256f();
        if (f == null) {
            return 0;
        }
        String userData = this.f4413b.getUserData(f, "user_id");
        if (userData != null) {
            return Integer.valueOf(userData).intValue();
        }
        return 0;
    }

    public String m6254d() {
        Account f = m6256f();
        if (f == null) {
            return null;
        }
        return this.f4413b.getUserData(f, "avatar");
    }

    public void m6255e() {
        if (m6250a()) {
            this.f4415d = this.f4412a.mo3361a(new C19463(this));
        }
    }

    public void m6247a(C1948b c1948b) {
        this.f4416e = c1948b;
    }

    public Account m6256f() {
        Account[] accountsByType = this.f4413b.getAccountsByType("cz.csfd.csfdroid.account");
        if (accountsByType.length == 0) {
            return null;
        }
        return accountsByType[0];
    }
}
