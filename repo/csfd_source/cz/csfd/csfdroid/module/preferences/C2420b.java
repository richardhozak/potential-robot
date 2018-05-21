package cz.csfd.csfdroid.module.preferences;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.HomeList;
import java.util.List;

/* compiled from: CheckableAdapter */
public class C2420b<T> extends ArrayAdapter<T> {
    private C2419a f6024a;

    /* compiled from: CheckableAdapter */
    public interface C2419a {
        void mo3612a(int i, boolean z);
    }

    public C2420b(Context context, int i, int i2, List<T> list) {
        super(context, i, i2, list);
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        final CheckedTextView checkedTextView = (CheckedTextView) view2.findViewById(R.id.text);
        checkedTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2420b f6023c;

            public void onClick(View view) {
                checkedTextView.toggle();
                this.f6023c.f6024a.mo3612a(i, checkedTextView.isChecked());
            }
        });
        checkedTextView.setChecked(((HomeList) getItem(i)).m6803c());
        return view2;
    }

    public void m8854a(C2419a c2419a) {
        this.f6024a = c2419a;
    }
}
