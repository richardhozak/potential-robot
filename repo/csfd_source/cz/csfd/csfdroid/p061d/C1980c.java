package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: ConnectionUtilsImpl */
public class C1980c implements C1979b {
    private ConnectivityManager f4478a;

    public boolean mo3348a(Context context) {
        if (this.f4478a == null) {
            this.f4478a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        for (NetworkInfo isConnected : this.f4478a.getAllNetworkInfo()) {
            if (isConnected.isConnected()) {
                return true;
            }
        }
        return false;
    }
}
