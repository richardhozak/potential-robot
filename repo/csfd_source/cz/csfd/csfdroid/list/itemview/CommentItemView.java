package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2098f;
import cz.csfd.csfdroid.p061d.C1998s;

public class CommentItemView extends RelativeLayout implements C2087b {
    private TextView f5019a;
    private TextView f5020b;
    private ImageView f5021c;
    private TextView f5022d;

    public CommentItemView(Context context) {
        this(context, null);
    }

    public CommentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5019a = (TextView) findViewById(R.id.comment_item_nick);
        this.f5020b = (TextView) findViewById(R.id.comment_item_text);
        this.f5021c = (ImageView) findViewById(R.id.comment_item_rating);
        this.f5022d = (TextView) findViewById(R.id.comment_item_garbage_rating);
    }

    public void setObject(C2083a c2083a) {
        final C2098f c2098f = (C2098f) c2083a;
        CharSequence spannableString = new SpannableString(c2098f.m7374d());
        spannableString.setSpan(new UnderlineSpan(), 0, c2098f.m7374d().length(), 0);
        this.f5019a.setText(spannableString);
        this.f5019a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommentItemView f5018b;

            public void onClick(View view) {
                C1998s.m6365a(this.f5018b.getContext()).m6219g().mo3459i().mo3653a(this.f5018b.getContext(), c2098f.m7373c().m6780a());
            }
        });
        if (c2098f.m7376f().length() > 0) {
            this.f5020b.setText(Html.fromHtml(c2098f.m7376f()));
            this.f5020b.setMovementMethod(LinkMovementMethod.getInstance());
            this.f5020b.setLinksClickable(true);
            this.f5020b.setVisibility(0);
        } else {
            this.f5020b.setVisibility(8);
        }
        m7491a(getContext(), c2098f.m7375e(), c2098f.m7373c().m6784d(), this.f5021c, this.f5022d);
    }

    public static void m7491a(Context context, int i, boolean z, ImageView imageView, TextView textView) {
        Resources resources = context.getResources();
        imageView.setVisibility(0);
        textView.setVisibility(8);
        switch (i) {
            case -1:
                imageView.setVisibility(8);
                textView.setVisibility(8);
                return;
            case 0:
                imageView.setVisibility(8);
                textView.setVisibility(0);
                return;
            case 20:
                if (z) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_1_empty));
                    return;
                } else {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_1));
                    return;
                }
            case 40:
                if (z) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_2_empty));
                    return;
                } else {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_2));
                    return;
                }
            case 60:
                if (z) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_3_empty));
                    return;
                } else {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_3));
                    return;
                }
            case 80:
                if (z) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_4_empty));
                    return;
                } else {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_4));
                    return;
                }
            case 100:
                if (z) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_5_empty));
                    return;
                } else {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.rating_5));
                    return;
                }
            default:
                return;
        }
    }
}
