package cz.csfd.csfdroid.module.cinema;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* compiled from: FetchLocationAddressTask */
public class C2208j extends AsyncTask<Location, Void, String> {
    private Context f5373a;
    private C2217k f5374b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7928a((Location[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m7929a((String) obj);
    }

    public C2208j(Context context, C2217k c2217k) {
        this.f5373a = context;
        this.f5374b = c2217k;
    }

    protected String m7928a(Location... locationArr) {
        return m7927a(locationArr[0]);
    }

    protected void m7929a(String str) {
        if (this.f5374b.isAdded()) {
            this.f5374b.m7979a(str);
        }
    }

    private String m7927a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            String str;
            List fromLocation = new Geocoder(this.f5373a, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation == null || fromLocation.isEmpty()) {
                str = null;
            } else {
                Address address = (Address) fromLocation.get(0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(address.getAddressLine(0));
                if (address.getSubAdminArea() != null) {
                    stringBuilder.append(", ");
                    stringBuilder.append(address.getSubAdminArea());
                }
                str = stringBuilder.toString();
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
