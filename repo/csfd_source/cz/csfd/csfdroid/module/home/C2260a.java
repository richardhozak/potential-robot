package cz.csfd.csfdroid.module.home;

import android.app.Dialog;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cz.csfd.csfdroid.R;

/* compiled from: AboutDialog */
public class C2260a extends DialogFragment {
    public static void m8185a(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("about_dialog") == null) {
            new C2260a().show(fragmentManager, "about_dialog");
        }
    }

    public C2260a() {
        setCancelable(true);
        setStyle(0, R.style.Theme.Csfd.Dialog.NoTitle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.about, viewGroup, false);
        try {
            ((TextView) inflate.findViewById(R.id.about_version)).setText(getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
        }
        TextView textView = (TextView) inflate.findViewById(R.id.about_licences);
        textView.setText(getActivity().getResources().getText(R.string.about_licences));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }
}
