package cz.csfd.csfdroid.p061d;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/* compiled from: ProgressDialogFragment */
public class C1996r extends DialogFragment {
    public static C1996r m6363a(int i, boolean z) {
        C1996r c1996r = new C1996r();
        Bundle bundle = new Bundle();
        bundle.putInt("messageResource", i);
        bundle.putBoolean("cancelable", z);
        c1996r.setArguments(bundle);
        return c1996r;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i = getArguments().getInt("messageResource");
        boolean z = getArguments().getBoolean("cancelable");
        Resources resources = getResources();
        Dialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage(resources.getString(i));
        progressDialog.setCancelable(z);
        return progressDialog;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (getTargetFragment() != null) {
            ((OnCancelListener) getTargetFragment()).onCancel(dialogInterface);
        }
    }
}
