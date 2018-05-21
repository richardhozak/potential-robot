package cz.csfd.csfdroid.p060c;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/* compiled from: Tab */
public class C1972c {
    private C1971a f4467a;
    private String f4468b;

    /* compiled from: Tab */
    public static final class C1971a {
        private final Class<?> f4464a;
        private final Bundle f4465b;
        private final Fragment f4466c;

        C1971a(Class<?> cls, Bundle bundle, Fragment fragment) {
            this.f4464a = cls;
            this.f4465b = bundle;
            this.f4466c = fragment;
        }

        public Class<?> m6307a() {
            return this.f4464a;
        }

        public Bundle m6308b() {
            return this.f4465b;
        }

        public Fragment m6309c() {
            return this.f4466c;
        }
    }

    public C1972c(String str, Class<?> cls, Bundle bundle, Fragment fragment) {
        this.f4468b = str;
        this.f4467a = new C1971a(cls, bundle, fragment);
    }

    public C1971a m6310a() {
        return this.f4467a;
    }

    public String m6312b() {
        return this.f4468b;
    }

    public void m6311a(String str) {
        this.f4468b = str;
    }
}
