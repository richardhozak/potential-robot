package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;

public class LoadingView extends LinearLayout {
    private ViewGroup f6376a;
    private ViewGroup f6377b;
    private TextView f6378c;
    private Button f6379d;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C25481();
        int f6374a;
        int f6375b;

        static class C25481 implements Creator<SavedState> {
            C25481() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m9445a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m9446a(i);
            }

            public SavedState m9445a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m9446a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f6374a = parcel.readInt();
            this.f6375b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6374a);
            parcel.writeInt(this.f6375b);
        }
    }

    public LoadingView(Context context) {
        super(context);
        m9447a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9447a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9447a();
    }

    public void m9447a() {
        setGravity(17);
        setOrientation(1);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.view_loading, this, false);
        while (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeView(childAt);
            addView(childAt);
        }
        this.f6376a = (ViewGroup) findViewById(R.id.loading_progress_panel);
        this.f6377b = (ViewGroup) findViewById(R.id.loading_error_panel);
        this.f6379d = (Button) findViewById(R.id.loading_button_try_again);
        this.f6378c = (TextView) findViewById(R.id.loading_error_text);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6374a = this.f6376a.getVisibility();
        savedState.f6375b = this.f6377b.getVisibility();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f6376a.setVisibility(savedState.f6374a);
        this.f6377b.setVisibility(savedState.f6375b);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public void m9448b() {
        this.f6376a.setVisibility(0);
    }

    public void m9449c() {
        this.f6376a.setVisibility(8);
    }

    public void m9450d() {
        this.f6377b.setVisibility(0);
    }

    public void m9451e() {
        this.f6377b.setVisibility(8);
    }

    public void setOnTryAgainListener(OnClickListener onClickListener) {
        this.f6379d.setOnClickListener(onClickListener);
    }

    public void setErrorText(String str) {
        this.f6378c.setText(str);
    }

    public void setErrorText(int i) {
        this.f6378c.setText(i);
    }

    public void m9452f() {
        this.f6378c.setText(R.string.loading_error_generic);
    }

    public void setTryAgainButtonText(int i) {
        this.f6379d.setText(i);
    }

    public void m9453g() {
        this.f6379d.setText(R.string.loading_button_try_again);
    }
}
