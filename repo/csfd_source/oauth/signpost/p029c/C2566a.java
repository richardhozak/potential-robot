package oauth.signpost.p029c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import oauth.signpost.C2568c;

/* compiled from: HttpParameters */
public class C2566a implements Serializable, Map<String, SortedSet<String>> {
    private TreeMap<String, SortedSet<String>> f6419a = new TreeMap();

    public /* synthetic */ Object get(Object obj) {
        return m9485a(obj);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m9486a((String) obj, (SortedSet) obj2);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m9494d(obj);
    }

    public SortedSet<String> m9486a(String str, SortedSet<String> sortedSet) {
        return (SortedSet) this.f6419a.put(str, sortedSet);
    }

    public SortedSet<String> m9487a(String str, SortedSet<String> sortedSet, boolean z) {
        if (!z) {
            return (SortedSet) this.f6419a.put(str, sortedSet);
        }
        m9494d(str);
        for (String a : sortedSet) {
            m9484a(str, a, true);
        }
        return m9485a((Object) str);
    }

    public String m9483a(String str, String str2) {
        return m9484a(str, str2, false);
    }

    public String m9484a(String str, String str2, boolean z) {
        if (z) {
            str = C2568c.m9495a(str);
        }
        SortedSet sortedSet = (SortedSet) this.f6419a.get(str);
        if (sortedSet == null) {
            sortedSet = new TreeSet();
            this.f6419a.put(str, sortedSet);
        }
        if (str2 != null) {
            if (z) {
                str2 = C2568c.m9495a(str2);
            }
            sortedSet.add(str2);
        }
        return str2;
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> map) {
        this.f6419a.putAll(map);
    }

    public void m9489a(Map<? extends String, ? extends SortedSet<String>> map, boolean z) {
        if (z) {
            for (String str : map.keySet()) {
                m9487a(str, (SortedSet) map.get(str), true);
            }
            return;
        }
        this.f6419a.putAll(map);
    }

    public void m9490a(String[] strArr, boolean z) {
        for (int i = 0; i < strArr.length - 1; i += 2) {
            m9484a(strArr[i], strArr[i + 1], z);
        }
    }

    public SortedSet<String> m9485a(Object obj) {
        return (SortedSet) this.f6419a.get(obj);
    }

    public String m9491b(Object obj) {
        return m9481a(obj, false);
    }

    public String m9481a(Object obj, boolean z) {
        SortedSet sortedSet = (SortedSet) this.f6419a.get(obj);
        if (sortedSet == null || sortedSet.isEmpty()) {
            return null;
        }
        String str = (String) sortedSet.first();
        return z ? C2568c.m9499b(str) : str;
    }

    public String m9493c(Object obj) {
        return m9492b(obj, true);
    }

    public String m9492b(Object obj, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            obj = C2568c.m9495a((String) obj);
        }
        Set set = (Set) this.f6419a.get(obj);
        if (set == null) {
            return obj + "=";
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            stringBuilder.append(obj + "=" + ((String) it.next()));
            if (it.hasNext()) {
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }

    public String m9482a(String str) {
        String b = m9491b(str);
        if (b == null) {
            return null;
        }
        return str + "=\"" + b + "\"";
    }

    public boolean containsKey(Object obj) {
        return this.f6419a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        for (SortedSet contains : this.f6419a.values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int i = 0;
        for (String str : this.f6419a.keySet()) {
            i = ((SortedSet) this.f6419a.get(str)).size() + i;
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f6419a.isEmpty();
    }

    public void clear() {
        this.f6419a.clear();
    }

    public SortedSet<String> m9494d(Object obj) {
        return (SortedSet) this.f6419a.remove(obj);
    }

    public Set<String> keySet() {
        return this.f6419a.keySet();
    }

    public Collection<SortedSet<String>> values() {
        return this.f6419a.values();
    }

    public Set<Entry<String, SortedSet<String>>> entrySet() {
        return this.f6419a.entrySet();
    }

    public C2566a m9488a() {
        C2566a c2566a = new C2566a();
        for (Entry entry : entrySet()) {
            String str = (String) entry.getKey();
            if (str.startsWith("oauth_") || str.startsWith("x_oauth_")) {
                c2566a.m9486a(str, (SortedSet) entry.getValue());
            }
        }
        return c2566a;
    }
}
