package cz.csfd.csfdroid.module.cinema;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: CityAdapter */
public class C2206h extends BaseAdapter implements Filterable {
    private static final Pattern f5355a = Pattern.compile("[\\p{InCombiningDiacriticalMarks}]+");
    private static final String[] f5356b = new String[]{"á", "ä", "č", "ď", "ě", "é", "í", "ĺ", "ľ", "ň", "ó", "ô", "ö", "ő", "ř", "ŕ", "š", "ť", "ú", "ů", "ü", "ű", "ý", "ž"};
    private static final String[] f5357c = new String[]{"a", "a", "c", "d", "e", "e", "i", "l", "l", "n", "o", "o", "o", "o", "r", "r", "s", "t", "u", "u", "u", "u", "y", "z"};
    private LayoutInflater f5358d;
    private Filter f5359e;
    private Object f5360f;
    private List<String> f5361g = new ArrayList();
    private List<String> f5362h = new ArrayList();

    /* compiled from: CityAdapter */
    private class C2205a extends Filter {
        final /* synthetic */ C2206h f5354a;

        private C2205a(C2206h c2206h) {
            this.f5354a = c2206h;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList;
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (this.f5354a.f5360f) {
                    arrayList = new ArrayList(this.f5354a.f5361g);
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            } else {
                String a = this.f5354a.m7917a(charSequence.toString());
                synchronized (this.f5354a.f5360f) {
                    arrayList = new ArrayList(this.f5354a.f5361g);
                }
                arrayList.size();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    String a2 = this.f5354a.m7917a(str.toString());
                    if (a2.startsWith(a)) {
                        arrayList2.add(str);
                    } else {
                        for (String startsWith : a2.split(" ")) {
                            if (startsWith.startsWith(a)) {
                                arrayList2.add(str);
                                break;
                            }
                        }
                    }
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            synchronized (this.f5354a.f5360f) {
                this.f5354a.f5362h.clear();
                this.f5354a.f5362h.addAll((List) filterResults.values);
            }
            if (filterResults.count > 0) {
                this.f5354a.notifyDataSetChanged();
            } else {
                this.f5354a.notifyDataSetInvalidated();
            }
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m7916a(i);
    }

    public C2206h(Context context) {
        this.f5358d = LayoutInflater.from(context);
        this.f5360f = new Object();
    }

    public void m7918a() {
        synchronized (this.f5360f) {
            this.f5361g.clear();
            this.f5362h.clear();
        }
        notifyDataSetChanged();
    }

    public void m7919a(List<String> list) {
        synchronized (this.f5360f) {
            this.f5361g.clear();
            this.f5362h.clear();
            this.f5361g.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        int size;
        synchronized (this.f5360f) {
            size = this.f5362h.size();
        }
        return size;
    }

    public String m7916a(int i) {
        String str;
        synchronized (this.f5360f) {
            str = (String) this.f5362h.get(i);
        }
        return str;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5358d.inflate(17367050, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(16908308);
        synchronized (this.f5360f) {
            textView.setText((CharSequence) this.f5362h.get(i));
        }
        return view;
    }

    public String m7917a(String str) {
        if (VERSION.SDK_INT >= 9) {
            return f5355a.matcher(Normalizer.normalize(str.toLowerCase(), Form.NFD)).replaceAll("");
        }
        for (int i = 0; i < f5356b.length; i++) {
            str = str.replaceAll(f5356b[i], f5357c[i]);
        }
        return str;
    }

    public Filter getFilter() {
        if (this.f5359e == null) {
            this.f5359e = new C2205a();
        }
        return this.f5359e;
    }
}
