package cz.csfd.csfdroid.module.preferences;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.h6ah4i.android.compat.preference.MultiSelectListPreferenceCompat;
import com.onesignal.ae;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.module.home.MainActivity;
import cz.csfd.csfdroid.module.tvtips.TvStationsActivity;
import cz.csfd.csfdroid.p058a.C1949a;
import java.util.Set;

public class PreferencesActivity extends PreferenceActivity implements C1949a {

    class C24122 implements OnPreferenceClickListener {
        final /* synthetic */ PreferencesActivity f6013a;

        C24122(PreferencesActivity preferencesActivity) {
            this.f6013a = preferencesActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            if (this.f6013a.m8847a()) {
                this.f6013a.startActivity(new Intent(this.f6013a, TvStationsActivity.class));
            } else {
                Toast.makeText(this.f6013a.getApplicationContext(), this.f6013a.getString(R.string.stations_login_required), 1).show();
            }
            return true;
        }
    }

    class C24133 implements OnPreferenceClickListener {
        final /* synthetic */ PreferencesActivity f6014a;

        C24133(PreferencesActivity preferencesActivity) {
            this.f6014a = preferencesActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f6014a.startActivity(new Intent(this.f6014a, ChartSortActivity.class));
            return true;
        }
    }

    class C24144 implements OnPreferenceClickListener {
        final /* synthetic */ PreferencesActivity f6015a;

        C24144(PreferencesActivity preferencesActivity) {
            this.f6015a = preferencesActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f6015a.startActivity(new Intent(this.f6015a, HomeSortActivity.class));
            return true;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        final C2057e n = ((CsfdApplication) getApplication()).m6226n();
        ((ListPreference) findPreference("text_size")).setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ PreferencesActivity f6012b;

            class C24091 implements OnClickListener {
                final /* synthetic */ C24111 f6008a;

                C24091(C24111 c24111) {
                    this.f6008a = c24111;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            public boolean onPreferenceChange(Preference preference, final Object obj) {
                Builder message = new Builder(this.f6012b).setTitle(R.string.preferences_text_size_restart_warning_title).setMessage(R.string.preferences_text_size_restart_warning);
                message.setPositiveButton(R.string.preferences_text_size_restart_warning_yes, new OnClickListener(this) {
                    final /* synthetic */ C24111 f6010b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        n.m7195c((String) obj);
                        Intent intent = new Intent(this.f6010b.f6012b, MainActivity.class);
                        intent.addFlags(67108864);
                        this.f6010b.f6012b.startActivity(intent);
                    }
                }).setNegativeButton(R.string.preferences_text_size_restart_warning_no, new C24091(this));
                message.create().show();
                return false;
            }
        });
        findPreference("preferences_tv_stations").setOnPreferenceClickListener(new C24122(this));
        findPreference("preferences_charts_sort").setOnPreferenceClickListener(new C24133(this));
        findPreference("preferences_home_sort").setOnPreferenceClickListener(new C24144(this));
        final MultiSelectListPreferenceCompat multiSelectListPreferenceCompat = (MultiSelectListPreferenceCompat) findPreference("notifications");
        multiSelectListPreferenceCompat.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ PreferencesActivity f6017b;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                Set set = (Set) obj;
                for (String str : this.f6017b.getResources().getStringArray(R.array.notifications)) {
                    if (set.contains(str)) {
                        Log.d("PreferencesActivity", "subscribe: " + str);
                        ae.m5823a(str, "1");
                    } else {
                        Log.d("PreferencesActivity", "unsubscribe: " + str);
                        ae.m5821a(str);
                    }
                }
                multiSelectListPreferenceCompat.m5557a(set);
                return false;
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Tracker u = ((CsfdApplication) getApplication()).m6233u();
        u.setScreenName(mo3436p());
        u.send(new ScreenViewBuilder().build());
    }

    protected void onStop() {
        super.onStop();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private boolean m8847a() {
        return ((CsfdApplication) getApplication()).m6229q().m6250a();
    }

    public String mo3436p() {
        return "/preferences";
    }
}
