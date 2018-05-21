package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2117y;

public class UserRatingItemView extends MovieItemView {
    private ImageView f5111a;
    private TextView f5112b;
    private TextView f5113c;
    private TextView f5114d;

    public UserRatingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        super.mo3428b();
        this.f5111a = (ImageView) findViewById(R.id.movie_item_rating);
        this.f5112b = (TextView) findViewById(R.id.movie_item_garbage_rating);
        this.f5113c = (TextView) findViewById(R.id.rating_date);
        this.f5114d = (TextView) findViewById(R.id.comment);
    }

    public void setObject(C2083a c2083a) {
        super.setObject(c2083a);
        C2117y c2117y = (C2117y) c2083a;
        CommentItemView.m7491a(getContext(), c2117y.m7468c(), c2117y.m7332i().m6908R(), this.f5111a, this.f5112b);
        this.f5113c.setText(c2117y.m7469d());
        if (TextUtils.isEmpty(c2117y.m7470e())) {
            this.f5114d.setVisibility(8);
            return;
        }
        this.f5114d.setText(Html.fromHtml(c2117y.m7470e()), BufferType.SPANNABLE);
        this.f5114d.setVisibility(0);
    }
}
