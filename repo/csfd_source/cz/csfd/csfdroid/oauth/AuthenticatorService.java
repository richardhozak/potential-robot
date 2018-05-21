package cz.csfd.csfdroid.oauth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticatorService extends Service {
    private C2538b f6320a;

    public void onCreate() {
        this.f6320a = new C2538b(this);
    }

    public IBinder onBind(Intent intent) {
        return this.f6320a.getIBinder();
    }
}
