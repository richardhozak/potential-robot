package cz.csfd.csfdroid.net.queue;

import android.content.Intent;
import android.os.IBinder;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.net.C2517b;
import cz.csfd.csfdroid.p061d.C1983f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class RequestService extends C2524a {
    private C2517b f6304a;
    private Map<Request, Future<?>> f6305b;

    public void onCreate() {
        super.onCreate();
        this.f6304a = ((CsfdApplication) getApplicationContext()).m6221i();
        this.f6305b = new HashMap();
        m9339a(true);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected int mo3672a() {
        return 2;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!intent.getAction().equals("cz.csfd.csfdroid.net.queue.CANCEL_REQUEST")) {
            return super.onStartCommand(intent, i, i2);
        }
        Request request = (Request) intent.getParcelableExtra("request");
        Future future = (Future) this.f6305b.remove(request);
        if (future != null) {
            future.cancel(true);
            C1983f.m6333a("RequestService", "Request: " + request.m9330a() + " cancelled.");
        }
        return 3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo3673a(android.content.Intent r8) {
        /*
        r7 = this;
        r0 = r8.getAction();
        r1 = "cz.csfd.csfdroid.net.queue.EXECUTE_REQUEST";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x008b;
    L_0x000c:
        r0 = "request";
        r0 = r8.getParcelableExtra(r0);
        r0 = (cz.csfd.csfdroid.net.queue.Request) r0;
        r1 = "callback";
        r1 = r8.getParcelableExtra(r1);
        r1 = (android.os.Messenger) r1;
        r2 = "RequestService";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Executing request: ";
        r3 = r3.append(r4);
        r4 = r0.m9330a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        cz.csfd.csfdroid.p061d.C1983f.m6333a(r2, r3);
        r4 = android.os.Message.obtain();
        r2 = 0;
        r3 = cz.csfd.csfdroid.net.queue.RequestService.C25231.f6298a;	 Catch:{ c -> 0x00b1 }
        r5 = r0.m9331b();	 Catch:{ c -> 0x00b1 }
        r5 = r5.ordinal();	 Catch:{ c -> 0x00b1 }
        r3 = r3[r5];	 Catch:{ c -> 0x00b1 }
        switch(r3) {
            case 1: goto L_0x008c;
            case 2: goto L_0x0097;
            case 3: goto L_0x00a6;
            default: goto L_0x004c;
        };
    L_0x004c:
        if (r2 == 0) goto L_0x0083;
    L_0x004e:
        r3 = 1;
        r4.what = r3;
        r3 = r2.m9317b();
        r4.obj = r3;
        r3 = r2.m9316a();
        r4.arg1 = r3;
        r3 = "RequestService";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Response for request: ";
        r5 = r5.append(r6);
        r6 = r0.m9330a();
        r5 = r5.append(r6);
        r6 = " is: ";
        r5 = r5.append(r6);
        r2 = r5.append(r2);
        r2 = r2.toString();
        cz.csfd.csfdroid.p061d.C1983f.m6333a(r3, r2);
    L_0x0083:
        r2 = r7.f6305b;
        r2.remove(r0);
        r1.send(r4);	 Catch:{ RemoteException -> 0x00bf }
    L_0x008b:
        return;
    L_0x008c:
        r3 = r7.f6304a;	 Catch:{ c -> 0x00b1 }
        r5 = r0.m9330a();	 Catch:{ c -> 0x00b1 }
        r2 = r3.mo3669a(r5);	 Catch:{ c -> 0x00b1 }
        goto L_0x004c;
    L_0x0097:
        r3 = r7.f6304a;	 Catch:{ c -> 0x00b1 }
        r5 = r0.m9330a();	 Catch:{ c -> 0x00b1 }
        r6 = r0.m9332c();	 Catch:{ c -> 0x00b1 }
        r2 = r3.mo3670a(r5, r6);	 Catch:{ c -> 0x00b1 }
        goto L_0x004c;
    L_0x00a6:
        r3 = r7.f6304a;	 Catch:{ c -> 0x00b1 }
        r5 = r0.m9330a();	 Catch:{ c -> 0x00b1 }
        r2 = r3.mo3671b(r5);	 Catch:{ c -> 0x00b1 }
        goto L_0x004c;
    L_0x00b1:
        r3 = move-exception;
        r5 = "RequestService";
        r6 = "Error when sending request.";
        cz.csfd.csfdroid.p061d.C1983f.m6334a(r5, r6, r3);
        r5 = 2;
        r4.what = r5;
        r4.obj = r3;
        goto L_0x004c;
    L_0x00bf:
        r0 = move-exception;
        r1 = "RequestService";
        r2 = "Error when sending back the response.";
        cz.csfd.csfdroid.p061d.C1983f.m6334a(r1, r2, r0);
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.csfd.csfdroid.net.queue.RequestService.a(android.content.Intent):void");
    }
}
