package cz.csfd.csfdroid.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.util.Log;

/* compiled from: ConnectionChangeReceiver */
public class C2516a extends BroadcastReceiver {
    private IntentFilter f6281a = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    private C1963a f6282b;

    /* compiled from: ConnectionChangeReceiver */
    public interface C1963a {
        void mo3330k();

        void mo3331l();
    }

    public C2516a(C1963a c1963a) {
        this.f6282b = c1963a;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ConnectionReceiver", "Received message on connectivity change");
        if (intent.hasExtra("networkInfo") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).isConnected()) {
            this.f6282b.mo3330k();
        } else if (intent.getBooleanExtra("noConnectivity", false)) {
            this.f6282b.mo3331l();
        }
    }

    public IntentFilter m9312a() {
        return this.f6281a;
    }
}
