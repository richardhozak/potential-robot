package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2113u;
import cz.csfd.csfdroid.p061d.C1998s;

public class TriviaItemView extends RelativeLayout implements C2087b {
    private TextView f5090a;

    private class C2129a extends ClickableSpan {
        int f5088a;
        final /* synthetic */ TriviaItemView f5089b;

        C2129a(TriviaItemView triviaItemView, int i) {
            this.f5089b = triviaItemView;
            this.f5088a = i;
        }

        public void onClick(View view) {
            C1998s.m6365a(this.f5089b.getContext()).m6219g().mo3459i().mo3653a(this.f5089b.getContext(), new User(this.f5088a));
        }
    }

    public TriviaItemView(Context context) {
        this(context, null);
    }

    public TriviaItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5090a = (TextView) findViewById(R.id.trivia_item_text);
    }

    public void setObject(C2083a c2083a) {
        C2113u c2113u = (C2113u) c2083a;
        String e = c2113u.m7446e();
        if (c2113u.m7447f() != null && c2113u.m7447f().length() > 0) {
            e = "<strong>" + c2113u.m7447f() + ":</strong> " + e;
        }
        if (c2113u.m7444c() != null) {
            e = e + " <strong><em>(" + c2113u.m7444c() + ")</em></strong>";
        }
        CharSequence spannableString = new SpannableString(Html.fromHtml(e));
        int d = c2113u.m7445d();
        if (d > 0) {
            int length = (spannableString.length() - c2113u.m7444c().length()) - 1;
            int length2 = spannableString.length() - 1;
            spannableString.setSpan(new C2129a(this, d), length, length2, 0);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.list_item_additional_light)), length, length2, 0);
        }
        this.f5090a.setText(spannableString);
        this.f5090a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5090a.setLinksClickable(true);
    }
}
