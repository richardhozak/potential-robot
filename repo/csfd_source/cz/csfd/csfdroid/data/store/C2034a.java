package cz.csfd.csfdroid.data.store;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: Contract */
public class C2034a {
    public static final Uri f4704a = Uri.parse("content://cz.csfd.csfdroid");

    private interface C2032b extends BaseColumns {
    }

    /* compiled from: Contract */
    public static class C2033a implements C2032b {
        public static final Uri f4703a = C2034a.f4704a.buildUpon().appendEncodedPath("cinemas/favourite").build();
    }
}
