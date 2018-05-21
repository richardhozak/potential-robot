package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.AdBannerItemView;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import java.util.HashMap;

/* compiled from: AdBannerListItem */
public class C2093b extends C2083a {
    private C2146b f4904b;
    private String f4905c;
    private HashMap<String, String> f4906d;

    public C2093b(C2146b c2146b, String str) {
        this.f4904b = c2146b;
        this.f4905c = str;
    }

    public C2093b(C2146b c2146b, HashMap<String, String> hashMap, String str) {
        this.f4904b = c2146b;
        this.f4906d = hashMap;
        this.f4905c = str;
    }

    public C2146b m7327c() {
        return this.f4904b;
    }

    public String m7328d() {
        return this.f4905c;
    }

    public HashMap<String, String> m7329e() {
        return this.f4906d;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_ad_banner_view, viewGroup);
    }

    public Class<?> mo3427b() {
        return AdBannerItemView.class;
    }
}
