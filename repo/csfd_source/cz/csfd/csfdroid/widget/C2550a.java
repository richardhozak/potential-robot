package cz.csfd.csfdroid.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cz.csfd.csfdroid.R;

/* compiled from: NoConnectionDialog */
public class C2550a extends Dialog {
    private Context f6387a;
    private boolean f6388b = false;

    /* compiled from: NoConnectionDialog */
    class C25491 implements OnClickListener {
        final /* synthetic */ C2550a f6386a;

        C25491(C2550a c2550a) {
            this.f6386a = c2550a;
        }

        public void onClick(View view) {
            this.f6386a.f6387a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        }
    }

    public C2550a(Context context) {
        super(context, R.style.Theme.Csfd.Dialog);
        this.f6387a = context;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.no_connection_dialog);
        setTitle(R.string.dialog_no_connection_title);
        setCancelable(true);
        ((Button) findViewById(R.id.dialog_settings_button)).setOnClickListener(new C25491(this));
    }

    protected void onStop() {
        super.onStop();
        this.f6388b = true;
    }

    public boolean m9457a() {
        return this.f6388b;
    }
}
