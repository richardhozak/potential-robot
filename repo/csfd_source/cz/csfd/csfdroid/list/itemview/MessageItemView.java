package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2107o;

public class MessageItemView extends RelativeLayout implements C2087b {
    private TextView f5046a;
    private TextView f5047b;
    private ImageView f5048c;
    private View f5049d;

    class C21231 implements OnTouchListener {
        final /* synthetic */ MessageItemView f5045a;

        C21231(MessageItemView messageItemView) {
            this.f5045a = messageItemView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Spannable newSpannable = Factory.getInstance().newSpannable(((TextView) view).getText());
            TextView textView = (TextView) view;
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
                int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                Layout layout = textView.getLayout();
                x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(x, x, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 1) {
                        clickableSpanArr[0].onClick(textView);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public MessageItemView(Context context) {
        this(context, null);
    }

    public MessageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void mo3428b() {
        this.f5046a = (TextView) findViewById(R.id.message_item_date);
        this.f5047b = (TextView) findViewById(R.id.message_item_text);
        this.f5048c = (ImageView) findViewById(R.id.message_item_image);
        this.f5049d = findViewById(R.id.message_bubble);
    }

    public void setObject(C2083a c2083a) {
        C2107o c2107o = (C2107o) c2083a;
        Message c = c2107o.m7423c();
        this.f5046a.setText(c2107o.m7424d());
        this.f5046a.setVisibility(8);
        this.f5047b.setText(Html.fromHtml(c.m6835b()));
        this.f5047b.setOnTouchListener(new C21231(this));
        LayoutParams layoutParams = (LayoutParams) this.f5049d.getLayoutParams();
        if (c2107o.m7423c().m6841e().m6705g() == ((CsfdApplication) getContext().getApplicationContext()).m6229q().m6253c()) {
            this.f5049d.setBackgroundResource(R.drawable.xml_chat_red);
            this.f5047b.setTextColor(getResources().getColor(R.color.text_color_primary));
            this.f5047b.setLinkTextColor(getResources().getColor(R.color.text_color_primary));
            this.f5046a.setTextColor(getResources().getColor(R.color.text_color_primary_transparent));
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        } else {
            this.f5049d.setBackgroundResource(R.drawable.xml_chat_grey);
            this.f5047b.setTextColor(getResources().getColor(R.color.text_color_inverse));
            this.f5046a.setTextColor(getResources().getColor(R.color.text_color_inverse_transparent));
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
        }
        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.margin_horizontal);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.margin_horizontal);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.margin_vertical);
        String c2 = c.m6839c();
        if (TextUtils.isEmpty(c2)) {
            this.f5048c.setVisibility(8);
            return;
        }
        this.f5048c.setImageResource(0);
        C1187t.m5432a(getContext()).m5439a(c2).m5481b(getResources().getDisplayMetrics().widthPixels - ((int) TypedValue.applyDimension(1, 34.0f, getResources().getDisplayMetrics())), 0).m5477a(this.f5048c);
        this.f5048c.setVisibility(0);
    }
}
