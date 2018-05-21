package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.onesignal.C1934w.C1933a;
import com.onesignal.C1935x;
import com.onesignal.ae.C1854f;
import org.json.JSONObject;

/* compiled from: CsfdNotificationOpenedHandler */
public class C1981d implements C1854f {
    private Context f4479a;

    public C1981d(Context context) {
        this.f4479a = context;
    }

    public void mo3349a(C1935x c1935x) {
        C1933a c1933a = c1935x.f4350b.f4347a;
        JSONObject jSONObject = c1935x.f4349a.f4341d.f4360d;
        if (jSONObject != null) {
            Log.d("OneSignalHandler", jSONObject.toString());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(jSONObject.optString("android_uri", null)));
            intent.setFlags(268566528);
            this.f4479a.startActivity(intent);
        }
    }
}
