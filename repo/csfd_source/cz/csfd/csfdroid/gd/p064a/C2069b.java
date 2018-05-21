package cz.csfd.csfdroid.gd.p064a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.InputDeviceCompat;
import cz.csfd.csfdroid.p061d.C1998s;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: ImageLoader */
public class C2069b {
    private static final String f4856a = C2069b.class.getSimpleName();
    private static C2064a f4857b;
    private static ExecutorService f4858c;
    private static Options f4859d;

    /* compiled from: ImageLoader */
    private class C2066a implements Runnable {
        final /* synthetic */ C2069b f4848a;
        private String f4849b;
        private C2067b f4850c;
        private C2070c f4851d;
        private Options f4852e;

        public C2066a(C2069b c2069b, String str, C2068c c2068c, C2070c c2070c, Options options) {
            this.f4848a = c2069b;
            this.f4849b = str;
            this.f4850c = new C2067b(str, c2068c);
            this.f4851d = c2070c;
            this.f4852e = options;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r5 = this;
            r2 = 0;
            r0 = 10;
            android.os.Process.setThreadPriority(r0);
            r3 = r5.f4850c;
            r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            r0 = android.os.Message.obtain(r3, r0);
            r3.sendMessage(r0);
            r0 = r5.f4849b;	 Catch:{ Exception -> 0x0021 }
            r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x0038;
        L_0x0019:
            r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x0021 }
            r1 = "The given URL cannot be null or empty";
            r0.<init>(r1);	 Catch:{ Exception -> 0x0021 }
            throw r0;	 Catch:{ Exception -> 0x0021 }
        L_0x0021:
            r0 = move-exception;
            r1 = r2;
        L_0x0023:
            if (r1 != 0) goto L_0x0064;
        L_0x0025:
            if (r0 != 0) goto L_0x002e;
        L_0x0027:
            r0 = new java.lang.Exception;
            r1 = "Skia image decoding failed";
            r0.<init>(r1);
        L_0x002e:
            r1 = 257; // 0x101 float:3.6E-43 double:1.27E-321;
            r0 = android.os.Message.obtain(r3, r1, r0);
            r3.sendMessage(r0);
        L_0x0037:
            return;
        L_0x0038:
            r0 = new java.net.URL;	 Catch:{ Exception -> 0x0021 }
            r1 = r5.f4849b;	 Catch:{ Exception -> 0x0021 }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0021 }
            r1 = r0.openStream();	 Catch:{ Exception -> 0x0021 }
            r4 = 0;
            r0 = r5.f4852e;	 Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x0061;
        L_0x0048:
            r0 = cz.csfd.csfdroid.gd.p064a.C2069b.f4859d;	 Catch:{ Exception -> 0x0021 }
        L_0x004c:
            r1 = android.graphics.BitmapFactory.decodeStream(r1, r4, r0);	 Catch:{ Exception -> 0x0021 }
            r0 = r5.f4851d;	 Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0070;
        L_0x0054:
            if (r1 == 0) goto L_0x0070;
        L_0x0056:
            r0 = r5.f4851d;	 Catch:{ Exception -> 0x006e }
            r0 = r0.m7252a(r1);	 Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0070;
        L_0x005e:
            r1 = r0;
            r0 = r2;
            goto L_0x0023;
        L_0x0061:
            r0 = r5.f4852e;	 Catch:{ Exception -> 0x0021 }
            goto L_0x004c;
        L_0x0064:
            r0 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
            r0 = android.os.Message.obtain(r3, r0, r1);
            r3.sendMessage(r0);
            goto L_0x0037;
        L_0x006e:
            r0 = move-exception;
            goto L_0x0023;
        L_0x0070:
            r0 = r1;
            goto L_0x005e;
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.csfd.csfdroid.gd.a.b.a.run():void");
        }
    }

    /* compiled from: ImageLoader */
    private class C2067b extends Handler {
        final /* synthetic */ C2069b f4853a;
        private String f4854b;
        private C2068c f4855c;

        private C2067b(C2069b c2069b, String str, C2068c c2068c) {
            this.f4853a = c2069b;
            this.f4854b = str;
            this.f4855c = c2068c;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 256:
                    if (this.f4855c != null) {
                        this.f4855c.mo3419a(this.f4853a);
                        return;
                    }
                    return;
                case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                    if (this.f4855c != null) {
                        this.f4855c.mo3421a(this.f4853a, (Throwable) message.obj);
                        return;
                    }
                    return;
                case 258:
                    Bitmap bitmap = (Bitmap) message.obj;
                    C2069b.f4857b.m7244a(this.f4854b, bitmap);
                    if (this.f4855c != null) {
                        this.f4855c.mo3420a(this.f4853a, bitmap);
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: ImageLoader */
    public interface C2068c {
        void mo3419a(C2069b c2069b);

        void mo3420a(C2069b c2069b, Bitmap bitmap);

        void mo3421a(C2069b c2069b, Throwable th);
    }

    public C2069b(Context context) {
        if (f4857b == null) {
            f4857b = C1998s.m6365a(context).m6231s();
        }
        if (f4858c == null) {
            f4858c = C1998s.m6365a(context).m6230r();
        }
        if (f4859d == null) {
            f4859d = new Options();
            f4859d.inDither = true;
            f4859d.inScaled = true;
            f4859d.inDensity = 160;
            f4859d.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public Future<?> m7251a(String str, C2068c c2068c, C2070c c2070c, Options options) {
        return f4858c.submit(new C2066a(this, str, c2068c, c2070c, options));
    }
}
