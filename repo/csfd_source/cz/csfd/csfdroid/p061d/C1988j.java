package cz.csfd.csfdroid.p061d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2022e;
import cz.csfd.csfdroid.widget.LoadingView;

/* compiled from: ErrorHandlingUtils */
public class C1988j {
    public static void m6341a(Context context, LoadingView loadingView, OnClickListener onClickListener, Exception exception) {
        if (exception instanceof C2022e) {
            C1988j.m6340a(context, loadingView);
        } else {
            C1988j.m6342a(loadingView, onClickListener);
        }
    }

    private static void m6340a(final Context context, LoadingView loadingView) {
        loadingView.m9449c();
        loadingView.m9450d();
        loadingView.setErrorText(context.getString(R.string.loading_error_invalid_version, new Object[]{((CsfdApplication) context.getApplicationContext()).m6218f()}));
        loadingView.setTryAgainButtonText(R.string.loading_button_try_again_update_app);
        loadingView.setOnTryAgainListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
                context.startActivity(intent);
            }
        });
    }

    private static void m6342a(LoadingView loadingView, OnClickListener onClickListener) {
        loadingView.m9449c();
        loadingView.m9450d();
        loadingView.m9452f();
        loadingView.m9453g();
        loadingView.setOnTryAgainListener(onClickListener);
    }
}
