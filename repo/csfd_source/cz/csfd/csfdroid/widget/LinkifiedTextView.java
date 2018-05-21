package cz.csfd.csfdroid.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class LinkifiedTextView extends ConfigurableSizeTextView {
    public LinkifiedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            Spannable spannable = (Spannable) text;
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (((int) motionEvent.getX()) - getTotalPaddingLeft()) + getScrollX();
                int y = (((int) motionEvent.getY()) - getTotalPaddingTop()) + getScrollY();
                Layout layout = getLayout();
                x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 1) {
                        clickableSpanArr[0].onClick(this);
                    } else if (action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
