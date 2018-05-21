package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class BasicEntity implements Serializable {
    private static final long serialVersionUID = 1;
    protected int id = -1;

    public BasicEntity(int i) {
        this.id = i;
    }

    public int m6705g() {
        return this.id;
    }

    public void m6704b(int i) {
        this.id = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this.id != ((BasicEntity) obj).id) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.id + 217;
    }
}
