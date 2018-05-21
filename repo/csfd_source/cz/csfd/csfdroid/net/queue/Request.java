package cz.csfd.csfdroid.net.queue;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Request implements Parcelable, Comparable<Request> {
    public static final Creator<Request> CREATOR = new C25211();
    private String f6293a;
    private C2522a f6294b;
    private Map<String, String> f6295c;
    private int f6296d;
    private long f6297e;

    static class C25211 implements Creator<Request> {
        C25211() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m9327a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m9328a(i);
        }

        public Request m9327a(Parcel parcel) {
            return new Request(parcel);
        }

        public Request[] m9328a(int i) {
            return new Request[i];
        }
    }

    public enum C2522a {
        GET,
        POST,
        DELETE
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m9329a((Request) obj);
    }

    public Request(String str, int i) {
        this(str, C2522a.GET, Collections.EMPTY_MAP, i);
    }

    public Request(String str, Map<String, String> map, int i) {
        this(str, C2522a.POST, map, i);
    }

    public Request(String str, C2522a c2522a, Map<String, String> map, int i) {
        this.f6293a = str;
        this.f6294b = c2522a;
        this.f6295c = map != null ? new HashMap(map) : Collections.EMPTY_MAP;
        this.f6296d = i;
        this.f6297e = System.currentTimeMillis();
    }

    private Request(Parcel parcel) {
        this.f6293a = parcel.readString();
        this.f6294b = C2522a.valueOf(parcel.readString());
        Bundle readBundle = parcel.readBundle();
        this.f6295c = new HashMap();
        for (String str : readBundle.keySet()) {
            this.f6295c.put(str, readBundle.getString(str));
        }
        this.f6296d = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6293a);
        parcel.writeString(this.f6294b.name());
        Bundle bundle = new Bundle();
        for (Entry entry : this.f6295c.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        parcel.writeBundle(bundle);
        parcel.writeInt(i);
    }

    public String m9330a() {
        return this.f6293a;
    }

    public C2522a m9331b() {
        return this.f6294b;
    }

    public Map<String, String> m9332c() {
        return this.f6295c;
    }

    public int m9333d() {
        return this.f6296d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        if (this.f6295c == null ? request.f6295c != null : !this.f6295c.equals(request.f6295c)) {
            return false;
        }
        if (this.f6294b != request.f6294b) {
            return false;
        }
        if (this.f6293a != null) {
            if (this.f6293a.equals(request.f6293a)) {
                return true;
            }
        } else if (request.f6293a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f6293a != null) {
            hashCode = this.f6293a.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = hashCode * 31;
        if (this.f6294b != null) {
            hashCode = this.f6294b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.f6295c != null) {
            i = this.f6295c.hashCode();
        }
        return hashCode + i;
    }

    public int m9329a(Request request) {
        return (int) (this.f6297e - request.f6297e);
    }

    public int describeContents() {
        return 0;
    }
}
