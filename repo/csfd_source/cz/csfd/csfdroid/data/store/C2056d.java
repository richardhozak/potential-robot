package cz.csfd.csfdroid.data.store;

import cz.csfd.csfdroid.CsfdApplication.C1942a;
import cz.csfd.csfdroid.data.entity.BasicEntity;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: EntityStore */
public class C2056d<T extends BasicEntity> implements C1942a {
    private int f4823a;
    private Map<Integer, SoftReference<T>> f4824b;
    private LinkedList<Integer> f4825c;

    public C2056d() {
        this(50);
    }

    public C2056d(int i) {
        this.f4823a = i;
        this.f4824b = new HashMap(i);
        this.f4825c = new LinkedList();
    }

    public void m7164a(T t) {
        m7160c();
        m7161c(Integer.valueOf(t.m6705g()));
        this.f4824b.put(Integer.valueOf(t.m6705g()), new SoftReference(t));
    }

    public T m7162a(Integer num) {
        if (this.f4824b.containsKey(num)) {
            m7161c(num);
            BasicEntity basicEntity = (BasicEntity) ((SoftReference) this.f4824b.get(num)).get();
            if (basicEntity != null) {
                return basicEntity;
            }
            this.f4825c.remove(num);
            this.f4824b.remove(num);
        }
        throw new C2036c(num + " not in store");
    }

    public boolean m7166b(Integer num) {
        return this.f4824b.containsKey(num) && ((SoftReference) this.f4824b.get(num)).get() != null;
    }

    private void m7161c(Integer num) {
        if (this.f4825c.contains(num)) {
            this.f4825c.remove(this.f4825c.indexOf(num));
        }
        this.f4825c.addLast(num);
    }

    private void m7160c() {
        if (this.f4823a > 0 && this.f4824b.size() == this.f4823a) {
            int intValue = ((Integer) this.f4825c.getFirst()).intValue();
            this.f4825c.removeFirst();
            this.f4824b.remove(Integer.valueOf(intValue));
        }
    }

    public void mo3415a() {
        m7165b();
    }

    public void m7165b() {
        this.f4825c.clear();
        this.f4824b.clear();
    }
}
