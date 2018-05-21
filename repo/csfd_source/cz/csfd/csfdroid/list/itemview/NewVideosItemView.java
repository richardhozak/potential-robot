package cz.csfd.csfdroid.list.itemview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.p042c.p049b.C1187t;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.MovieInfo;
import cz.csfd.csfdroid.data.entity.MovieVideos;
import cz.csfd.csfdroid.gd.widget.AsyncImageView;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2111s;
import cz.csfd.csfdroid.list.p063a.C2111s.C2110a;
import cz.csfd.csfdroid.module.movie.C2366h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewVideosItemView extends FrameLayout implements C2087b {
    private PagerAdapter f5071a;
    private LayoutInflater f5072b;
    private ViewPager f5073c;

    private class C2128a extends PagerAdapter {
        final /* synthetic */ NewVideosItemView f5065a;
        private List<MovieInfo> f5066b;
        private Map<MovieInfo, View> f5067c;
        private C1187t f5068d;
        private C2366h f5069e;
        private MovieVideos f5070f;

        private C2128a(NewVideosItemView newVideosItemView, List<MovieInfo> list) {
            this.f5065a = newVideosItemView;
            this.f5066b = list;
            this.f5067c = new HashMap();
            this.f5068d = C1187t.m5432a(newVideosItemView.getContext());
            this.f5069e = ((CsfdApplication) newVideosItemView.getContext().getApplicationContext()).m6219g().mo3453c();
            List arrayList = new ArrayList();
            for (MovieInfo Y : list) {
                arrayList.add(Y.m6915Y());
            }
            this.f5070f = new MovieVideos(arrayList);
        }

        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            final MovieInfo movieInfo = (MovieInfo) this.f5066b.get(i);
            View inflate = this.f5065a.f5072b.inflate(R.layout.list_item_new_videos_video, viewGroup, false);
            inflate.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2128a f5062c;

                public void onClick(View view) {
                    ((CsfdApplication) this.f5062c.f5065a.getContext().getApplicationContext()).m6219g().mo3453c().mo3577a(movieInfo, this.f5062c.f5070f, i, true, this.f5062c.f5065a.getContext());
                }
            });
            this.f5068d.m5439a(movieInfo.m6915Y().m7006d().m7010a()).m5473a().m5482c().m5477a((AsyncImageView) inflate.findViewById(R.id.new_video_thumbnail));
            ((TextView) inflate.findViewById(R.id.new_video_movie_name)).setText(movieInfo.m6917a());
            TextView textView = (TextView) inflate.findViewById(R.id.new_video_description);
            CharSequence a = movieInfo.m6915Y().m7001a();
            if (!TextUtils.isEmpty(a)) {
                textView.setText(a);
            }
            ((ImageView) inflate.findViewById(R.id.new_video_color)).setImageResource(m7504a(movieInfo));
            inflate.findViewById(R.id.new_video_name).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2128a f5064b;

                public void onClick(View view) {
                    this.f5064b.f5069e.mo3575a(movieInfo, this.f5064b.f5065a.getContext());
                }
            });
            this.f5067c.put(movieInfo, inflate);
            viewGroup.addView(inflate);
            return movieInfo;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) this.f5067c.get(obj));
        }

        public int getCount() {
            return this.f5066b.size();
        }

        public float getPageWidth(int i) {
            return 0.8f;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return this.f5067c.get(obj) == view;
        }

        private int m7504a(MovieInfo movieInfo) {
            switch (movieInfo.m6916Z()) {
                case RED:
                    return R.drawable.movie_item_c1;
                case BLUE:
                    return R.drawable.movie_item_c2;
                case BLACK:
                    return R.drawable.movie_item_c3;
                default:
                    return R.drawable.movie_item_c0;
            }
        }
    }

    public NewVideosItemView(Context context) {
        super(context);
        m7508a();
    }

    public NewVideosItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7508a();
    }

    public NewVideosItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7508a();
    }

    private void m7508a() {
        this.f5072b = LayoutInflater.from(getContext());
    }

    public void mo3428b() {
        this.f5073c = (ViewPager) findViewById(R.id.new_videos_viewpager);
    }

    public void setObject(C2083a c2083a) {
        final C2111s c2111s = (C2111s) c2083a;
        this.f5071a = new C2128a(c2111s.m7433c());
        this.f5073c.setAdapter(this.f5071a);
        this.f5073c.setOffscreenPageLimit(2);
        this.f5073c.setPageMargin(getResources().getDimensionPixelSize(R.dimen.new_videos_page_margin));
        final C2110a d = c2111s.m7434d();
        this.f5073c.setOnPageChangeListener(new OnPageChangeListener(this) {
            final /* synthetic */ NewVideosItemView f5057c;
            private int f5058d = 0;

            public void onPageSelected(int i) {
                c2111s.m7431a(i);
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageScrollStateChanged(int i) {
                if (this.f5058d == 0) {
                    if (i == 1) {
                        d.setOverridingTouchTarget(this.f5057c.f5073c);
                    }
                } else if (i == 0 || i == 2) {
                    d.setOverridingTouchTarget(null);
                }
                this.f5058d = i;
            }
        });
    }
}
