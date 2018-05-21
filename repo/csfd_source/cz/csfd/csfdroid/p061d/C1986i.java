package cz.csfd.csfdroid.p061d;

import java.lang.ref.WeakReference;

/* compiled from: EquatableWeakReference */
public class C1986i<T> extends WeakReference<T> {
    public C1986i(T t) {
        super(t);
    }

    public boolean equals(Object obj) {
        boolean equals = super.equals(obj);
        if (equals || !(obj instanceof C1986i)) {
            return equals;
        }
        Object obj2 = get();
        if (obj2 != null) {
            return obj2.equals(((C1986i) obj).get());
        }
        return equals;
    }

    public int hashCode() {
        Object obj = get();
        return obj != null ? obj.hashCode() : super.hashCode();
    }
}
