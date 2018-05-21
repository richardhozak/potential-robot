package cz.csfd.csfdroid.net.queue;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: MultiThreadedIntentService */
public abstract class C2524a extends Service {
    private ExecutorService f6299a;
    private boolean f6300b;
    private ArrayList<Future<?>> f6301c;
    private Handler f6302d;
    private final Runnable f6303e = new C25251(this);

    /* compiled from: MultiThreadedIntentService */
    class C25251 implements Runnable {
        final /* synthetic */ C2524a f6306a;

        C25251(C2524a c2524a) {
            this.f6306a = c2524a;
        }

        public void run() {
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException("This runnable can only be called in the Main thread!");
            }
            ArrayList a = this.f6306a.f6301c;
            int i = 0;
            while (i < a.size()) {
                if (((Future) a.get(i)).isDone()) {
                    a.remove(i);
                    i--;
                }
                i++;
            }
            if (a.isEmpty()) {
                this.f6306a.stopSelf();
            }
        }
    }

    /* compiled from: MultiThreadedIntentService */
    private class C2526a implements Runnable {
        final /* synthetic */ C2524a f6307a;
        private Intent f6308b;

        public C2526a(C2524a c2524a, Intent intent) {
            this.f6307a = c2524a;
            this.f6308b = intent;
        }

        public void run() {
            this.f6307a.mo3673a(this.f6308b);
            this.f6307a.f6302d.removeCallbacks(this.f6307a.f6303e);
            this.f6307a.f6302d.post(this.f6307a.f6303e);
        }
    }

    protected abstract void mo3673a(Intent intent);

    public void m9339a(boolean z) {
        this.f6300b = z;
    }

    public void onCreate() {
        super.onCreate();
        this.f6299a = Executors.newFixedThreadPool(mo3672a());
        this.f6302d = new Handler();
        this.f6301c = new ArrayList();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f6301c.add(this.f6299a.submit(new C2526a(this, intent)));
        return this.f6300b ? 3 : 2;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6299a.shutdown();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected int mo3672a() {
        return 1;
    }
}
