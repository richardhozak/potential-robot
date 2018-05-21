package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.C2028e;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.UserRatingItemView;
import java.text.DateFormat;
import java.util.Date;

/* compiled from: UserRatingListItem */
public class C2117y extends C2094q {
    private C2028e f4954b;

    public C2117y(C2028e c2028e) {
        super(c2028e.m7100a(), 0);
        this.f4954b = c2028e;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_user_rating, viewGroup);
    }

    public int m7468c() {
        return this.f4954b.m7102b();
    }

    public String m7469d() {
        Date c = this.f4954b.m7103c();
        String str = "";
        if (c != null) {
            return DateFormat.getDateInstance().format(c);
        }
        return str;
    }

    public String m7470e() {
        return this.f4954b.m7104d();
    }

    public Class<?> mo3427b() {
        return UserRatingItemView.class;
    }
}
