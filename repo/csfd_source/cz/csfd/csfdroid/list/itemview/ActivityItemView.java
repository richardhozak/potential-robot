package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.C2057e;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.ActivityEntity;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityOperation;
import cz.csfd.csfdroid.data.entity.ActivityEntity.ActivityType;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.data.entity.User.Gender;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2092a;
import cz.csfd.csfdroid.p061d.C1998s;

public class ActivityItemView extends RelativeLayout implements C2087b {
    private ImageView f4959a;
    private TextView f4960b;
    private TextView f4961c;
    private ImageView f4962d;
    private TextView f4963e;
    private TextView f4964f;
    private TextView f4965g;
    private ImageView f4966h;
    private TextView f4967i;
    private TextView f4968j;
    private C2057e f4969k;
    private ActivityEntity f4970l;

    public ActivityEntity getActivityEntity() {
        return this.f4970l;
    }

    public ActivityItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4969k = ((CsfdApplication) context.getApplicationContext()).m6226n();
    }

    public void mo3428b() {
        this.f4959a = (ImageView) findViewById(R.id.movie_item_rating);
        this.f4960b = (TextView) findViewById(R.id.movie_item_garbage_rating);
        this.f4961c = (TextView) findViewById(R.id.rating_date);
        this.f4962d = (ImageView) findViewById(R.id.movie_item_poster);
        this.f4963e = (TextView) findViewById(R.id.movie_item_name);
        this.f4964f = (TextView) findViewById(R.id.movie_item_year);
        this.f4965g = (TextView) findViewById(R.id.movie_item_type);
        this.f4966h = (ImageView) findViewById(R.id.movie_item_color);
        this.f4967i = (TextView) findViewById(R.id.user_nick);
        this.f4968j = (TextView) findViewById(R.id.activity_description);
    }

    public void setObject(C2083a c2083a) {
        C2092a c2092a = (C2092a) c2083a;
        ActivityEntity c = c2092a.m7322c();
        this.f4970l = c;
        CommentItemView.m7491a(getContext(), c.m6716e(), c.m6717f().m6908R(), this.f4959a, this.f4960b);
        MovieInfo f = c.m6717f();
        if (this.f4969k.m7214t()) {
            String d = f.m6936d();
            if (d.length() == 0) {
                this.f4962d.setImageResource(R.drawable.poster_free);
            } else {
                C1187t.m5432a(getContext()).m5439a(d).m5477a(this.f4962d);
            }
            this.f4962d.setVisibility(0);
        } else {
            this.f4962d.setVisibility(8);
        }
        this.f4963e.setText(f.m6917a());
        if (f.m6965j() > 0) {
            this.f4964f.setText("(" + f.m6965j() + ")");
            this.f4964f.setVisibility(0);
        } else {
            this.f4964f.setVisibility(8);
        }
        this.f4966h.setImageResource(c2092a.m7324e());
        this.f4961c.setText(c2092a.m7323d());
        final User d2 = c.m6715d();
        this.f4967i.setText(d2.m6811b());
        this.f4967i.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActivityItemView f4958b;

            public void onClick(View view) {
                C1998s.m6365a(this.f4958b.getContext()).m6219g().mo3459i().mo3653a(this.f4958b.getContext(), d2);
            }
        });
        this.f4968j.setText(m7477a(c));
    }

    private String m7477a(ActivityEntity activityEntity) {
        User d = activityEntity.m6715d();
        String str = "";
        if (activityEntity.m6706a() == ActivityType.FILM_RATING && activityEntity.m6713b() == ActivityOperation.INSERT) {
            str = getContext().getString(R.string.activity_rated);
            return d.m6827l() == Gender.FEMALE ? str + "a" : str;
        } else if (activityEntity.m6706a() == ActivityType.FILM_RATING && activityEntity.m6713b() == ActivityOperation.UPDATE) {
            str = getContext().getString(R.string.activity_updated);
            if (d.m6827l() == Gender.FEMALE) {
                str = str + "a";
            }
            return (str + " ") + getContext().getString(R.string.activity_rating);
        } else if (activityEntity.m6706a() == ActivityType.FILM_COMMENT && activityEntity.m6713b() == ActivityOperation.INSERT) {
            str = getContext().getString(R.string.activity_commented);
            if (d.m6827l() == Gender.FEMALE) {
                return str + "a";
            }
            return str;
        } else if (activityEntity.m6706a() != ActivityType.FILM_COMMENT || activityEntity.m6713b() != ActivityOperation.UPDATE) {
            return str;
        } else {
            str = getContext().getString(R.string.activity_updated);
            if (d.m6827l() == Gender.FEMALE) {
                str = str + "a";
            }
            return (str + " ") + getContext().getString(R.string.activity_comment);
        }
    }
}
