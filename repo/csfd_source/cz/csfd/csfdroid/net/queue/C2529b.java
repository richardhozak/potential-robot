package cz.csfd.csfdroid.net.queue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import cz.csfd.csfdroid.CsfdApplication.C1942a;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1986i;
import cz.csfd.csfdroid.p061d.C1998s;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.apache.http.HttpStatus;

/* compiled from: RequestQueue */
public class C2529b implements C1942a {
    private static C2529b f6312a;
    private Context f6313b;
    private Queue<Request> f6314c;
    private Map<Request, List<WeakReference<C2000b>>> f6315d;
    private Set<Request> f6316e;
    private Map<Request, SoftReference<String>> f6317f;
    private Queue<Request> f6318g;
    private Handler f6319h = new C25271(this);

    /* compiled from: RequestQueue */
    public interface C2000b {
        void mo3350a(Request request);

        void mo3351a(Request request, Exception exception);

        void mo3352a(Request request, String str);

        void mo3353a(Request request, String str, int i);
    }

    /* compiled from: RequestQueue */
    class C25271 extends Handler {
        final /* synthetic */ C2529b f6309a;

        C25271(C2529b c2529b) {
            this.f6309a = c2529b;
        }

        public void handleMessage(Message message) {
            Request request;
            if (message.what == 1) {
                removeMessages(1);
                C1983f.m6333a("RequestQueue", "Sending pending requests.");
                synchronized (this.f6309a) {
                    Iterator it = this.f6309a.f6314c.iterator();
                    while (it.hasNext()) {
                        request = (Request) it.next();
                        Intent intent = new Intent(this.f6309a.f6313b, RequestService.class);
                        intent.setAction("cz.csfd.csfdroid.net.queue.EXECUTE_REQUEST");
                        intent.putExtra("request", request);
                        intent.putExtra("callback", new Messenger(new C2528a(request)));
                        it.remove();
                        this.f6309a.f6316e.add(request);
                        this.f6309a.f6313b.startService(intent);
                    }
                }
            } else if (message.what == 2) {
                request = (Request) message.obj;
                String string = message.getData().getString("result");
                C1983f.m6333a("RequestQueue", "Returning cached result for request: " + request.m9330a());
                synchronized (this.f6309a) {
                    this.f6309a.m9345a(request, string);
                }
            } else if (message.what == 3) {
                request = (Request) message.obj;
                C1983f.m6333a("RequestQueue", "Cancelling request: " + request.m9330a());
                Intent intent2 = new Intent(this.f6309a.f6313b, RequestService.class);
                intent2.setAction("cz.csfd.csfdroid.net.queue.CANCEL_REQUEST");
                intent2.putExtra("request", request);
                this.f6309a.f6313b.startService(intent2);
                synchronized (this.f6309a) {
                    this.f6309a.f6316e.remove(request);
                    this.f6309a.f6314c.remove(request);
                    this.f6309a.m9352b(request);
                }
            }
        }
    }

    /* compiled from: RequestQueue */
    class C2528a extends Handler {
        final /* synthetic */ C2529b f6310a;
        private Request f6311b;

        private C2528a(C2529b c2529b, Request request) {
            this.f6310a = c2529b;
            this.f6311b = request;
        }

        public void handleMessage(Message message) {
            C1983f.m6333a("RequestQueue", "Received callback for request: " + this.f6311b.m9330a() + ", code: " + message.arg1 + ", response: " + message.obj);
            synchronized (this.f6310a) {
                this.f6310a.f6316e.remove(this.f6311b);
                if (message.what == 1) {
                    if (message.arg1 == HttpStatus.SC_OK) {
                        this.f6310a.m9345a(this.f6311b, (String) message.obj);
                    } else {
                        this.f6310a.m9346a(this.f6311b, (String) message.obj, message.arg1);
                    }
                } else if (message.what == 2) {
                    this.f6310a.m9344a(this.f6311b, (Exception) message.obj);
                }
            }
        }
    }

    private C2529b(Context context) {
        this.f6313b = context.getApplicationContext();
        this.f6314c = new LinkedList();
        this.f6315d = new HashMap();
        this.f6316e = new HashSet();
        this.f6317f = new HashMap();
        this.f6318g = new LinkedList();
        C1998s.m6365a(context).m6211a((C1942a) this);
    }

    public static C2529b m9342a(Context context) {
        if (f6312a == null) {
            synchronized (C2529b.class) {
                if (f6312a == null) {
                    f6312a = new C2529b(context);
                }
            }
        }
        return f6312a;
    }

    public synchronized void m9361a(Request request, C2000b c2000b) {
        m9353b(request, c2000b);
    }

    private void m9353b(Request request, C2000b c2000b) {
        if (this.f6316e.contains(request) && (request.m9333d() & 4) == 0) {
            C1983f.m6333a("RequestQueue", "Request for: " + request.m9330a() + " already executing.");
            m9358e(request, c2000b);
            return;
        }
        m9356c(request, c2000b);
    }

    private void m9356c(Request request, C2000b c2000b) {
        if (this.f6317f.containsKey(request) && (request.m9333d() & 2) == 0) {
            String str = (String) ((SoftReference) this.f6317f.get(request)).get();
            if (str != null) {
                C1983f.m6333a("RequestQueue", "Request for: " + request.m9330a() + " cached.");
                m9358e(request, c2000b);
                Message obtainMessage = this.f6319h.obtainMessage(2, request);
                Bundle bundle = new Bundle();
                bundle.putString("result", str);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
                return;
            }
            this.f6317f.remove(request);
            this.f6318g.remove(request);
            m9357d(request, c2000b);
            return;
        }
        m9357d(request, c2000b);
    }

    private void m9357d(Request request, C2000b c2000b) {
        if (this.f6314c.contains(request)) {
            C1983f.m6333a("RequestQueue", "Request for: " + request.m9330a() + " already in queue.");
        } else {
            C1983f.m6333a("RequestQueue", "Request for: " + request.m9330a() + " added to queue.");
            this.f6314c.add(request);
        }
        m9358e(request, c2000b);
        this.f6319h.sendEmptyMessage(1);
    }

    private void m9358e(Request request, C2000b c2000b) {
        C1986i c1986i = new C1986i(c2000b);
        if (this.f6315d.containsKey(request)) {
            ((List) this.f6315d.get(request)).add(c1986i);
            return;
        }
        List linkedList = new LinkedList();
        linkedList.add(c1986i);
        this.f6315d.put(request, linkedList);
    }

    public synchronized void m9360a(Request request) {
        if (this.f6314c.contains(request) || this.f6316e.contains(request)) {
            this.f6319h.obtainMessage(3, request).sendToTarget();
        }
    }

    private void m9345a(Request request, String str) {
        C1983f.m6333a("RequestQueue", "Notifying listeners for request: " + request.m9330a());
        m9354b(request, str);
        List<WeakReference> list = (List) this.f6315d.remove(request);
        if (list != null) {
            Log.d("RequestQueue", "Listeners count: " + list.size());
            for (WeakReference weakReference : list) {
                C1983f.m6333a("RequestQueue", "Listener: " + weakReference.get());
                if (weakReference.get() != null) {
                    ((C2000b) weakReference.get()).mo3352a(request, str);
                }
            }
            return;
        }
        Log.d("RequestQueue", "Listeners are null");
    }

    private void m9354b(Request request, String str) {
        if ((request.m9333d() & 1) != 0) {
            this.f6317f.put(request, new SoftReference(str));
            this.f6318g.remove(request);
            this.f6318g.add(request);
            if (this.f6318g.size() > 100) {
                Request request2 = (Request) this.f6318g.poll();
                if (request2 != null) {
                    this.f6317f.remove(request2);
                }
            }
        }
    }

    private void m9344a(Request request, Exception exception) {
        List<WeakReference> list = (List) this.f6315d.remove(request);
        if (list != null) {
            for (WeakReference weakReference : list) {
                if (weakReference.get() != null) {
                    ((C2000b) weakReference.get()).mo3351a(request, exception);
                }
            }
        }
    }

    private void m9346a(Request request, String str, int i) {
        List<WeakReference> list = (List) this.f6315d.remove(request);
        if (list != null) {
            for (WeakReference weakReference : list) {
                if (weakReference.get() != null) {
                    ((C2000b) weakReference.get()).mo3353a(request, str, i);
                }
            }
        }
    }

    private void m9352b(Request request) {
        List<WeakReference> list = (List) this.f6315d.remove(request);
        if (list != null) {
            for (WeakReference weakReference : list) {
                if (weakReference.get() != null) {
                    ((C2000b) weakReference.get()).mo3350a(request);
                }
            }
        }
    }

    public void mo3415a() {
        m9362b();
    }

    public synchronized void m9362b() {
        this.f6317f.clear();
        this.f6318g.clear();
    }
}
