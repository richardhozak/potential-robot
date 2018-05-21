package cz.csfd.csfdroid.gd.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import cz.csfd.csfdroid.C2090h.C2089a;
import cz.csfd.csfdroid.gd.p064a.C2070c;
import cz.csfd.csfdroid.gd.p064a.C2074d;
import cz.csfd.csfdroid.gd.p064a.C2074d.C2072a;
import cz.csfd.csfdroid.p061d.C1983f;
import cz.csfd.csfdroid.p061d.C1998s;

public class AsyncImageView extends ImageView implements C2072a {
    private static final String f4875a = AsyncImageView.class.getSimpleName();
    private int f4876b;
    private Bitmap f4877c;
    private Drawable f4878d;
    private int f4879e;
    private String f4880f;
    private C2074d f4881g;
    private boolean f4882h;
    private boolean f4883i;
    private Bitmap f4884j;
    private C2080b f4885k;
    private C2070c f4886l;
    private Options f4887m;
    private C2079a f4888n;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C20781();
        String f4873a;

        static class C20781 implements Creator<SavedState> {
            C20781() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m7279a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m7280a(i);
            }

            public SavedState m7279a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m7280a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4873a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f4873a);
        }
    }

    private class C2079a extends AsyncTask<String, Void, Bitmap> {
        final /* synthetic */ AsyncImageView f4874a;

        private C2079a(AsyncImageView asyncImageView) {
            this.f4874a = asyncImageView;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7281a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7282a((Bitmap) obj);
        }

        protected Bitmap m7281a(String... strArr) {
            return C1998s.m6365a(this.f4874a.getContext()).m6231s().m7242a(strArr[0]);
        }

        protected void m7282a(Bitmap bitmap) {
            if (bitmap != null) {
                this.f4874a.f4883i = true;
                this.f4874a.f4884j = bitmap;
                this.f4874a.setImageBitmap(this.f4874a.f4884j);
            } else {
                this.f4874a.m7293e();
            }
            this.f4874a.f4888n = null;
        }
    }

    public interface C2080b {
        void m7283a(AsyncImageView asyncImageView);

        void m7284a(AsyncImageView asyncImageView, Bitmap bitmap);

        void m7285a(AsyncImageView asyncImageView, Throwable th);
    }

    public AsyncImageView(Context context) {
        this(context, null);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7291c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2089a.AsyncImageView);
        setUrl(obtainStyledAttributes.getString(1));
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setDefaultImageDrawable(drawable);
        }
        int i2 = obtainStyledAttributes.getInt(2, -1);
        if (i2 != -1) {
            setInDensity(i2);
        }
        if (VERSION.SDK_INT <= 10) {
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            setOptions(options);
        }
        obtainStyledAttributes.recycle();
    }

    private void m7291c() {
        this.f4876b = -1;
        this.f4882h = false;
    }

    public void setPaused(boolean z) {
        if (this.f4882h != z) {
            this.f4882h = z;
            if (!z) {
                m7295a();
            }
        }
    }

    public void setInDensity(int i) {
        if (this.f4887m == null) {
            this.f4887m = new Options();
            this.f4887m.inDither = true;
            this.f4887m.inScaled = true;
            this.f4887m.inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
        }
        this.f4887m.inDensity = i;
    }

    public void setOptions(Options options) {
        this.f4887m = options;
    }

    public void m7295a() {
        m7299a(false);
    }

    public void m7299a(boolean z) {
        if (this.f4881g == null && this.f4880f != null) {
            if (!this.f4883i || z) {
                this.f4884j = null;
                m7294f();
                if (z) {
                    m7293e();
                } else {
                    m7292d();
                }
            }
        }
    }

    @TargetApi(11)
    private void m7292d() {
        this.f4888n = new C2079a();
        if (VERSION.SDK_INT >= 11) {
            this.f4888n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.f4880f});
            return;
        }
        this.f4888n.execute(new String[]{this.f4880f});
    }

    private void m7293e() {
        if (!this.f4882h) {
            this.f4881g = new C2074d(this.f4880f, this, this.f4886l, this.f4887m);
            this.f4881g.m7263a(getContext());
        }
    }

    public void m7300b() {
        if (this.f4888n != null) {
            this.f4888n.cancel(true);
            this.f4888n = null;
        }
        if (this.f4881g != null) {
            this.f4881g.m7262a();
            this.f4881g = null;
        }
    }

    public void setOnImageViewLoadListener(C2080b c2080b) {
        this.f4885k = c2080b;
    }

    public void setUrl(String str) {
        if (this.f4884j == null || str == null || !str.equals(this.f4880f)) {
            this.f4883i = false;
            m7300b();
            this.f4880f = str;
            if (TextUtils.isEmpty(this.f4880f)) {
                this.f4884j = null;
                m7294f();
            } else if (this.f4882h) {
                this.f4884j = null;
                m7294f();
            } else {
                m7295a();
            }
        }
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f4876b = 2;
        this.f4877c = bitmap;
        m7294f();
    }

    public void setDefaultImageDrawable(Drawable drawable) {
        this.f4876b = 1;
        this.f4878d = drawable;
        m7294f();
    }

    public void setDefaultImageResource(int i) {
        this.f4876b = 0;
        this.f4879e = i;
        m7294f();
    }

    public void setImageProcessor(C2070c c2070c) {
        this.f4886l = c2070c;
    }

    private void m7294f() {
        C1983f.m6333a("AsyncImageView", "Setting default image.");
        switch (this.f4876b) {
            case 0:
                setImageResource(this.f4879e);
                return;
            case 1:
                setImageDrawable(this.f4878d);
                return;
            case 2:
                setImageBitmap(this.f4877c);
                return;
            default:
                setImageDrawable(null);
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4873a = this.f4880f;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setUrl(savedState.f4873a);
    }

    public void mo3422a(C2074d c2074d) {
        if (this.f4885k != null) {
            this.f4885k.m7283a(this);
        }
    }

    public synchronized void mo3424a(C2074d c2074d, Throwable th) {
        this.f4881g = null;
        if (this.f4885k != null) {
            this.f4885k.m7285a(this, th);
        }
    }

    public synchronized void mo3423a(C2074d c2074d, Bitmap bitmap) {
        this.f4883i = true;
        this.f4884j = bitmap;
        setImageBitmap(bitmap);
        if (this.f4885k != null) {
            this.f4885k.m7284a(this, bitmap);
        }
        this.f4881g = null;
    }

    public synchronized void mo3425b(C2074d c2074d) {
        this.f4881g = null;
        if (this.f4885k != null) {
            this.f4885k.m7285a(this, null);
        }
    }
}
