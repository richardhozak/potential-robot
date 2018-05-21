package cz.csfd.csfdroid.p061d;

/* compiled from: DistanceUtils */
public class C1985h {
    public static String m6338a(float f) {
        if (f < 1000.0f) {
            return ((int) f) + " m";
        }
        if (f < 10000.0f) {
            return C1985h.m6339a(f / 1000.0f, 1) + " km";
        }
        return ((int) (f / 1000.0f)) + " km";
    }

    static String m6339a(float f, int i) {
        int pow = (int) Math.pow(10.0d, (double) i);
        return ((int) f) + "." + (((int) Math.abs(((float) pow) * f)) % pow);
    }
}
