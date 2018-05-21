package cz.csfd.csfdroid.p061d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import cz.csfd.csfdroid.widget.C2550a;

/* compiled from: DialogBuilder */
public class C1984g {
    public static AlertDialog m6336a(Context context, int i) {
        AlertDialog create = new Builder(context).setMessage(i).create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public static C2550a m6337a(Context context) {
        return new C2550a(context);
    }
}
