package cz.csfd.csfdroid;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: CustomProgressDialog */
public class C2058f extends DialogFragment {
    private OnCancelListener f4831a;

    public static C2058f m7220a(FragmentManager fragmentManager, String str, int i, boolean z) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            C2058f c2058f = new C2058f();
            Bundle bundle = new Bundle();
            bundle.putInt("message", i);
            bundle.putBoolean("cancelable", z);
            c2058f.setArguments(bundle);
            c2058f.show(fragmentManager, str);
            return c2058f;
        } else if (findFragmentByTag instanceof C2058f) {
            return (C2058f) findFragmentByTag;
        } else {
            return null;
        }
    }

    public C2058f() {
        setStyle(0, R.style.Theme.Csfd.Dialog.NoTitle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(getArguments().getBoolean("cancelable"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_progress, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.dialog_message)).setText(getArguments().getInt("message"));
    }

    public void m7221a(OnCancelListener onCancelListener) {
        this.f4831a = onCancelListener;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (this.f4831a != null) {
            this.f4831a.onCancel(dialogInterface);
        }
    }
}
