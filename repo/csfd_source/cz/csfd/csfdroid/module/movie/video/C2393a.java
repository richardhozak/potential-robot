package cz.csfd.csfdroid.module.movie.video;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.p061d.C1992n;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MyMediaController */
public class C2393a extends FrameLayout {
    private OnClickListener f5914A;
    private OnSeekBarChangeListener f5915B;
    private OnClickListener f5916C;
    private OnClickListener f5917D;
    StringBuilder f5918a;
    Formatter f5919b;
    private C2388a f5920c;
    private Context f5921d;
    private View f5922e;
    private SeekBar f5923f;
    private TextView f5924g;
    private TextView f5925h;
    private boolean f5926i;
    private boolean f5927j;
    private boolean f5928k;
    private boolean f5929l;
    private boolean f5930m;
    private OnClickListener f5931n;
    private OnClickListener f5932o;
    private ImageButton f5933p;
    private ImageButton f5934q;
    private ImageButton f5935r;
    private ImageButton f5936s;
    private ImageButton f5937t;
    private Spinner f5938u;
    private Spinner f5939v;
    private Button f5940w;
    private Button f5941x;
    private List<String> f5942y;
    private Handler f5943z;

    /* compiled from: MyMediaController */
    class C23835 extends Handler {
        final /* synthetic */ C2393a f5909a;

        C23835(C2393a c2393a) {
            this.f5909a = c2393a;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f5909a.m8755e();
                    return;
                case 2:
                    int b = this.f5909a.m8740h();
                    if (!this.f5909a.f5927j && this.f5909a.f5926i && this.f5909a.f5920c.mo3598e()) {
                        sendMessageDelayed(obtainMessage(2), (long) (1000 - (b % 1000)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: MyMediaController */
    class C23846 implements OnClickListener {
        final /* synthetic */ C2393a f5910a;

        C23846(C2393a c2393a) {
            this.f5910a = c2393a;
        }

        public void onClick(View view) {
            this.f5910a.m8744j();
            this.f5910a.m8747a(3000);
        }
    }

    /* compiled from: MyMediaController */
    class C23857 implements OnSeekBarChangeListener {
        final /* synthetic */ C2393a f5911a;

        C23857(C2393a c2393a) {
            this.f5911a = c2393a;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f5911a.m8747a(3600000);
            this.f5911a.f5927j = true;
            this.f5911a.f5943z.removeMessages(2);
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                long c = (((long) this.f5911a.f5920c.mo3596c()) * ((long) i)) / 1000;
                this.f5911a.f5920c.mo3594a((int) c);
                if (this.f5911a.f5925h != null) {
                    this.f5911a.f5925h.setText(this.f5911a.m8732b((int) c));
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f5911a.f5927j = false;
            this.f5911a.m8740h();
            this.f5911a.m8742i();
            this.f5911a.m8747a(3000);
            this.f5911a.f5943z.sendEmptyMessage(2);
        }
    }

    /* compiled from: MyMediaController */
    class C23868 implements OnClickListener {
        final /* synthetic */ C2393a f5912a;

        C23868(C2393a c2393a) {
            this.f5912a = c2393a;
        }

        public void onClick(View view) {
            this.f5912a.f5920c.mo3594a(this.f5912a.f5920c.mo3597d() - 5000);
            this.f5912a.m8740h();
            this.f5912a.m8747a(3000);
        }
    }

    /* compiled from: MyMediaController */
    class C23879 implements OnClickListener {
        final /* synthetic */ C2393a f5913a;

        C23879(C2393a c2393a) {
            this.f5913a = c2393a;
        }

        public void onClick(View view) {
            this.f5913a.f5920c.mo3594a(this.f5913a.f5920c.mo3597d() + 15000);
            this.f5913a.m8740h();
            this.f5913a.m8747a(3000);
        }
    }

    /* compiled from: MyMediaController */
    public interface C2388a {
        void mo3593a();

        void mo3594a(int i);

        void mo3595b();

        int mo3596c();

        int mo3597d();

        boolean mo3598e();

        int mo3599f();

        boolean mo3600g();

        boolean mo3601h();

        boolean mo3602i();
    }

    /* compiled from: MyMediaController */
    public interface C2389b {
        void mo3610a(C2393a c2393a);
    }

    /* compiled from: MyMediaController */
    public interface C2390c {
        void mo3609a(C2393a c2393a);
    }

    /* compiled from: MyMediaController */
    public interface C2391d {
        void mo3607a(C2393a c2393a, String str, int i);
    }

    /* compiled from: MyMediaController */
    public interface C2392e {
        void mo3608a(C2393a c2393a, String str, int i);
    }

    public C2393a(Context context, C2388a c2388a) {
        this(context, c2388a, true);
    }

    public C2393a(Context context, C2388a c2388a, boolean z) {
        super(context);
        this.f5943z = new C23835(this);
        this.f5914A = new C23846(this);
        this.f5915B = new C23857(this);
        this.f5916C = new C23868(this);
        this.f5917D = new C23879(this);
        this.f5921d = context;
        this.f5928k = z;
        setMediaPlayer(c2388a);
        m8736f();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.f5922e != null) {
            m8729a(this.f5922e);
        }
    }

    public void setMediaPlayer(C2388a c2388a) {
        this.f5920c = c2388a;
        m8742i();
    }

    public void m8751a(Map<String, String> map, String str, final C2391d c2391d) {
        int parseInt;
        String str2;
        this.f5942y = new ArrayList();
        if (map.size() > 1) {
            Display defaultDisplay = ((WindowManager) this.f5921d.getSystemService("window")).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            if (width > height) {
                width = height;
            }
            List<String> a = C1992n.m6357a((Map) map);
            List arrayList = new ArrayList();
            int i = 0;
            for (String str3 : a) {
                int i2;
                Object obj;
                try {
                    parseInt = Integer.parseInt(str3);
                    try {
                        String str4 = str3 + "p";
                        i2 = parseInt;
                        obj = str4;
                    } catch (NumberFormatException e) {
                        i2 = parseInt;
                        str2 = str3;
                        this.f5942y.add(str3);
                        arrayList.add(obj);
                        height = this.f5942y.indexOf(str3);
                        i = height;
                    }
                } catch (NumberFormatException e2) {
                    parseInt = 0;
                    i2 = parseInt;
                    str2 = str3;
                    this.f5942y.add(str3);
                    arrayList.add(obj);
                    height = this.f5942y.indexOf(str3);
                    i = height;
                }
                if (i2 == 0 || i2 <= r1) {
                    this.f5942y.add(str3);
                    arrayList.add(obj);
                    if (str != null && str.equals(str3)) {
                        height = this.f5942y.indexOf(str3);
                        i = height;
                    }
                }
                height = i;
                i = height;
            }
            if (arrayList.size() > 1) {
                SpinnerAdapter arrayAdapter = new ArrayAdapter(this.f5921d, 17367048, arrayList);
                arrayAdapter.setDropDownViewResource(17367049);
                this.f5938u.setAdapter(arrayAdapter);
                this.f5938u.setSelection(i);
                this.f5938u.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                    final /* synthetic */ C2393a f5902b;

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        c2391d.mo3607a(this.f5902b, (String) this.f5902b.f5942y.get(i), i);
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                this.f5938u.setVisibility(0);
            }
        }
    }

    public void m8750a(List<Entry<String, String>> list, String str, final C2392e c2392e) {
        if (list.size() > 1) {
            List arrayList = new ArrayList();
            int i = 0;
            for (Entry entry : list) {
                int i2;
                arrayList.add(entry.getKey());
                if (str == null || !str.equals(entry.getKey())) {
                    i2 = i;
                } else {
                    i2 = arrayList.indexOf(entry.getKey());
                }
                i = i2;
            }
            SpinnerAdapter arrayAdapter = new ArrayAdapter(this.f5921d, 17367048, arrayList);
            arrayAdapter.setDropDownViewResource(17367049);
            this.f5939v.setAdapter(arrayAdapter);
            this.f5938u.setSelection(i);
            this.f5939v.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ C2393a f5904b;

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    c2392e.mo3608a(this.f5904b, (String) adapterView.getItemAtPosition(i), i);
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f5939v.setVisibility(0);
        }
    }

    public void m8749a(final C2390c c2390c) {
        this.f5940w.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2393a f5906b;

            public void onClick(View view) {
                if (c2390c != null) {
                    c2390c.mo3609a(this.f5906b);
                }
            }
        });
    }

    public void m8748a(final C2389b c2389b) {
        this.f5941x.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2393a f5908b;

            public void onClick(View view) {
                if (c2389b != null) {
                    c2389b.mo3610a(this.f5908b);
                }
            }
        });
    }

    private void m8736f() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        removeAllViews();
        addView(m8746a(), layoutParams);
    }

    protected View m8746a() {
        this.f5922e = ((LayoutInflater) this.f5921d.getSystemService("layout_inflater")).inflate(R.layout.media_controller, null);
        m8729a(this.f5922e);
        return this.f5922e;
    }

    private void m8729a(View view) {
        int i = 0;
        this.f5933p = (ImageButton) view.findViewById(R.id.pause);
        if (this.f5933p != null) {
            this.f5933p.requestFocus();
            this.f5933p.setOnClickListener(this.f5914A);
        }
        this.f5934q = (ImageButton) view.findViewById(R.id.ffwd);
        if (this.f5934q != null) {
            this.f5934q.setOnClickListener(this.f5917D);
            if (!this.f5929l) {
                this.f5934q.setVisibility(this.f5928k ? 0 : 8);
            }
        }
        this.f5935r = (ImageButton) view.findViewById(R.id.rew);
        if (this.f5935r != null) {
            this.f5935r.setOnClickListener(this.f5916C);
            if (!this.f5929l) {
                ImageButton imageButton = this.f5935r;
                if (!this.f5928k) {
                    i = 8;
                }
                imageButton.setVisibility(i);
            }
        }
        this.f5936s = (ImageButton) view.findViewById(R.id.next);
        if (!(this.f5936s == null || this.f5929l || this.f5930m)) {
            this.f5936s.setVisibility(8);
        }
        this.f5937t = (ImageButton) view.findViewById(R.id.prev);
        if (!(this.f5937t == null || this.f5929l || this.f5930m)) {
            this.f5937t.setVisibility(8);
        }
        this.f5923f = (SeekBar) view.findViewById(R.id.mediacontroller_progress);
        if (this.f5923f != null) {
            if (this.f5923f instanceof SeekBar) {
                this.f5923f.setOnSeekBarChangeListener(this.f5915B);
            }
            this.f5923f.setMax(1000);
        }
        this.f5924g = (TextView) view.findViewById(R.id.time);
        this.f5925h = (TextView) view.findViewById(R.id.time_current);
        this.f5918a = new StringBuilder();
        this.f5919b = new Formatter(this.f5918a, Locale.getDefault());
        m8745k();
        this.f5938u = (Spinner) view.findViewById(R.id.video_resolution_chooser);
        this.f5939v = (Spinner) view.findViewById(R.id.video_subtitles_chooser);
        this.f5940w = (Button) view.findViewById(R.id.video_button_ad_skip);
        this.f5941x = (Button) view.findViewById(R.id.video_button_ad_url);
    }

    public void m8752b() {
        m8747a(3000);
    }

    public void m8747a(int i) {
        m8753c();
        if (!this.f5926i) {
            if (this.f5933p != null) {
                this.f5933p.requestFocus();
            }
            setVisibility(0);
            this.f5926i = true;
        }
        m8742i();
        this.f5943z.sendEmptyMessage(2);
        this.f5943z.removeMessages(1);
        if (i != 0) {
            this.f5943z.sendEmptyMessageDelayed(1, (long) i);
        }
    }

    public void setAdSkipButtonVisibility(boolean z) {
        this.f5940w.setVisibility(z ? 0 : 8);
    }

    public void setAdUrlButtonVisibility(boolean z) {
        this.f5941x.setVisibility(z ? 0 : 8);
    }

    public void m8753c() {
        m8740h();
        setEnabled(true);
        m8739g();
        m8742i();
    }

    private void m8739g() {
        if (!(this.f5933p == null || this.f5920c.mo3600g())) {
            this.f5933p.setEnabled(false);
        }
        if (!(this.f5935r == null || this.f5920c.mo3601h())) {
            this.f5935r.setEnabled(false);
        }
        if (!(this.f5934q == null || this.f5920c.mo3602i())) {
            this.f5934q.setEnabled(false);
        }
        if (this.f5923f == null) {
            return;
        }
        if (!this.f5920c.mo3602i() || !this.f5920c.mo3601h()) {
            this.f5923f.setEnabled(false);
        }
    }

    public boolean m8754d() {
        return this.f5926i;
    }

    public void m8755e() {
        if (this.f5926i) {
            try {
                this.f5943z.removeMessages(2);
                setVisibility(4);
            } catch (IllegalArgumentException e) {
                Log.w("MediaController", "already removed");
            }
            this.f5926i = false;
        }
    }

    private String m8732b(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        i2 /= 3600;
        this.f5918a.setLength(0);
        if (i2 > 0) {
            return this.f5919b.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
        }
        return this.f5919b.format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
    }

    private int m8740h() {
        if (this.f5920c == null || this.f5927j) {
            return 0;
        }
        int d = this.f5920c.mo3597d();
        int c = this.f5920c.mo3596c();
        if (this.f5923f != null) {
            if (c > 0) {
                this.f5923f.setProgress((int) ((1000 * ((long) d)) / ((long) c)));
            }
            this.f5923f.setSecondaryProgress(this.f5920c.mo3599f() * 10);
        }
        if (this.f5924g != null) {
            this.f5924g.setText(m8732b(c));
        }
        if (this.f5925h == null) {
            return d;
        }
        this.f5925h.setText(m8732b(d));
        return d;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getRepeatCount() == 0 && (keyCode == 79 || keyCode == 85 || keyCode == 62)) {
            m8744j();
            m8747a(3000);
            if (this.f5933p == null) {
                return true;
            }
            this.f5933p.requestFocus();
            return true;
        } else if (keyCode == 86) {
            if (!this.f5920c.mo3598e()) {
                return true;
            }
            this.f5920c.mo3595b();
            m8742i();
            return true;
        } else if (keyCode == 25 || keyCode == 24) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (keyCode == 4 || keyCode == 82) {
                m8755e();
                return true;
            }
            m8747a(3000);
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    private void m8742i() {
        if (this.f5922e != null && this.f5933p != null) {
            if (this.f5920c.mo3598e()) {
                this.f5933p.setImageResource(17301539);
            } else {
                this.f5933p.setImageResource(17301540);
            }
        }
    }

    private void m8744j() {
        if (this.f5920c.mo3598e()) {
            this.f5920c.mo3595b();
        } else {
            this.f5920c.mo3593a();
        }
        m8742i();
    }

    public void setEnabled(boolean z) {
        boolean z2 = true;
        if (this.f5933p != null) {
            this.f5933p.setEnabled(z);
        }
        if (this.f5934q != null) {
            this.f5934q.setEnabled(z);
        }
        if (this.f5935r != null) {
            this.f5935r.setEnabled(z);
        }
        if (this.f5936s != null) {
            ImageButton imageButton = this.f5936s;
            boolean z3 = z && this.f5931n != null;
            imageButton.setEnabled(z3);
        }
        if (this.f5937t != null) {
            ImageButton imageButton2 = this.f5937t;
            if (!z || this.f5932o == null) {
                z2 = false;
            }
            imageButton2.setEnabled(z2);
        }
        if (this.f5923f != null) {
            this.f5923f.setEnabled(z);
        }
        m8739g();
        super.setEnabled(z);
    }

    private void m8745k() {
        boolean z = true;
        if (this.f5936s != null) {
            this.f5936s.setOnClickListener(this.f5931n);
            this.f5936s.setEnabled(this.f5931n != null);
        }
        if (this.f5937t != null) {
            this.f5937t.setOnClickListener(this.f5932o);
            ImageButton imageButton = this.f5937t;
            if (this.f5932o == null) {
                z = false;
            }
            imageButton.setEnabled(z);
        }
    }
}
