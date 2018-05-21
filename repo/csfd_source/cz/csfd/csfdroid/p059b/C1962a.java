package cz.csfd.csfdroid.p059b;

import java.io.Serializable;
import java.util.Map.Entry;

/* compiled from: CompatibilitySimpleImmutableEntry */
public class C1962a<K, V> implements Serializable, Entry<K, V> {
    private final K f4434a;
    private final V f4435b;

    public C1962a(K k, V v) {
        this.f4434a = k;
        this.f4435b = v;
    }

    public K getKey() {
        return this.f4434a;
    }

    public V getValue() {
        return this.f4435b;
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof java.util.Map.Entry;
        if (r2 == 0) goto L_0x003b;
    L_0x0009:
        r5 = (java.util.Map.Entry) r5;
        r2 = r4.f4434a;
        if (r2 != 0) goto L_0x0021;
    L_0x000f:
        r2 = r5.getKey();
        if (r2 != 0) goto L_0x001f;
    L_0x0015:
        r2 = r4.f4435b;
        if (r2 != 0) goto L_0x002e;
    L_0x0019:
        r2 = r5.getValue();
        if (r2 == 0) goto L_0x0004;
    L_0x001f:
        r0 = r1;
        goto L_0x0004;
    L_0x0021:
        r2 = r4.f4434a;
        r3 = r5.getKey();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001f;
    L_0x002d:
        goto L_0x0015;
    L_0x002e:
        r2 = r4.f4435b;
        r3 = r5.getValue();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001f;
    L_0x003a:
        goto L_0x0004;
    L_0x003b:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.csfd.csfdroid.b.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f4434a == null ? 0 : this.f4434a.hashCode();
        if (this.f4435b != null) {
            i = this.f4435b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return this.f4434a + "=" + this.f4435b;
    }
}
