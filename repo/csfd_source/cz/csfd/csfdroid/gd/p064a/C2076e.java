package cz.csfd.csfdroid.gd.p064a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: PersistentImageCache */
public class C2076e {
    private Context f4870a;
    private C2057e f4871b = ((CsfdApplication) this.f4870a).m6226n();
    private File f4872c;

    /* compiled from: PersistentImageCache */
    private class C2075a extends AsyncTask<Void, Void, Void> {
        String f4867a;
        Bitmap f4868b;
        final /* synthetic */ C2076e f4869c;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7265a((Void[]) objArr);
        }

        public C2075a(C2076e c2076e, String str, Bitmap bitmap) {
            this.f4869c = c2076e;
            this.f4867a = str;
            this.f4868b = bitmap;
        }

        protected Void m7265a(Void... voidArr) {
            if (this.f4869c.m7269b()) {
                String a = this.f4869c.m7268b(this.f4867a);
                if (this.f4869c.m7274d()) {
                    try {
                        this.f4868b.compress(this.f4868b.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG, 100, new FileOutputStream(new File(this.f4869c.f4872c, a)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Log.e("PersistentImageCache", "Can't write image to cache for url: " + this.f4867a);
                    }
                }
                this.f4869c.m7272c();
            }
            return null;
        }
    }

    @TargetApi(8)
    public C2076e(Context context) {
        File externalCacheDir;
        this.f4870a = context.getApplicationContext();
        if (VERSION.SDK_INT >= 8) {
            externalCacheDir = this.f4870a.getExternalCacheDir();
        } else {
            externalCacheDir = new File(Environment.getExternalStorageDirectory(), "Android/data/cz.csfd.csfdroid/cache");
        }
        this.f4872c = new File(externalCacheDir, "images");
        m7269b();
    }

    private boolean m7269b() {
        if (m7275e()) {
            if (this.f4872c.exists()) {
                return true;
            }
            if (m7274d() && this.f4872c.mkdirs()) {
                try {
                    new File(this.f4872c, ".nomedia").createNewFile();
                    return true;
                } catch (IOException e) {
                    Log.e("PersistentImageCache", "Can't create .nomedia file.");
                    return true;
                }
            }
        }
        return false;
    }

    public Bitmap m7277a(String str) {
        Bitmap bitmap = null;
        if (m7275e()) {
            File file = new File(this.f4872c, m7268b(str));
            if (file.exists()) {
                try {
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                } catch (OutOfMemoryError e) {
                }
            }
        }
        return bitmap;
    }

    public void m7278a(String str, Bitmap bitmap) {
        C2075a c2075a = new C2075a(this, str, bitmap);
        if (VERSION.SDK_INT >= 11) {
            c2075a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            c2075a.execute(new Void[0]);
        }
    }

    private void m7272c() {
        synchronized (this.f4872c) {
            if (m7274d()) {
                long a = m7276a();
                long n = ((long) this.f4871b.m7208n()) * 1048576;
                if (a > n) {
                    long j = a - n;
                    if (((float) j) / ((float) n) > 0.15f) {
                        while (j > 0 && m7274d()) {
                            File file;
                            File file2 = null;
                            File[] listFiles = this.f4872c.listFiles();
                            if (listFiles != null) {
                                for (File file3 : listFiles) {
                                    if (file2 == null || file3.lastModified() < file2.lastModified()) {
                                        file2 = file3;
                                    }
                                }
                                file = file2;
                            } else {
                                file = null;
                            }
                            if (file != null) {
                                a = j - file.length();
                                file.delete();
                            } else {
                                a = j;
                            }
                            j = a;
                        }
                    }
                }
            }
        }
    }

    public long m7276a() {
        long j = 0;
        if (m7275e()) {
            File[] listFiles = this.f4872c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        j += file.length();
                    }
                }
            }
        }
        return j;
    }

    private boolean m7274d() {
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        return equals ? equals : equals;
    }

    private boolean m7275e() {
        String externalStorageState = Environment.getExternalStorageState();
        boolean z = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
        return z ? z : z;
    }

    private String m7268b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(str.getBytes("utf8"));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
