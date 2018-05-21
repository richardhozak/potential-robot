package cz.csfd.csfdroid.data.entity;

import android.util.SparseArray;
import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;

public class ActivityEntity extends BasicEntity implements Serializable {
    private Date inserted;
    private MovieInfo movie;
    private ActivityOperation operation;
    private int rating = -1;
    private ActivityType type;
    private User user;

    public enum ActivityOperation {
        INSERT(1),
        UPDATE(2);
        
        private static SparseArray<ActivityOperation> f4623c;
        private int id;

        static {
            f4623c = new SparseArray(2);
            Iterator it = EnumSet.allOf(ActivityOperation.class).iterator();
            while (it.hasNext()) {
                ActivityOperation activityOperation = (ActivityOperation) it.next();
                f4623c.put(activityOperation.m6701a(), activityOperation);
            }
        }

        private ActivityOperation(int i) {
            this.id = i;
        }

        public int m6701a() {
            return this.id;
        }

        public static ActivityOperation m6700a(int i) {
            return (ActivityOperation) f4623c.get(i);
        }
    }

    public enum ActivityType {
        FILM_RATING(1),
        FILM_COMMENT(2);
        
        private static SparseArray<ActivityType> f4627c;
        private int id;

        static {
            f4627c = new SparseArray(2);
            Iterator it = EnumSet.allOf(ActivityType.class).iterator();
            while (it.hasNext()) {
                ActivityType activityType = (ActivityType) it.next();
                f4627c.put(activityType.m6703a(), activityType);
            }
        }

        private ActivityType(int i) {
            this.id = i;
        }

        public int m6703a() {
            return this.id;
        }

        public static ActivityType m6702a(int i) {
            return (ActivityType) f4627c.get(i);
        }
    }

    public ActivityEntity(int i) {
        super(i);
    }

    public ActivityType m6706a() {
        return this.type;
    }

    public void m6709a(ActivityType activityType) {
        this.type = activityType;
    }

    public ActivityOperation m6713b() {
        return this.operation;
    }

    public void m6708a(ActivityOperation activityOperation) {
        this.operation = activityOperation;
    }

    public Date m6714c() {
        return this.inserted;
    }

    public void m6712a(Date date) {
        this.inserted = date;
    }

    public User m6715d() {
        return this.user;
    }

    public void m6711a(User user) {
        this.user = user;
    }

    public int m6716e() {
        return this.rating;
    }

    public void m6707a(int i) {
        this.rating = i;
    }

    public MovieInfo m6717f() {
        return this.movie;
    }

    public void m6710a(MovieInfo movieInfo) {
        this.movie = movieInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityEntity activityEntity = (ActivityEntity) obj;
        if (this.rating != activityEntity.rating) {
            return false;
        }
        if (this.inserted == null ? activityEntity.inserted != null : !this.inserted.equals(activityEntity.inserted)) {
            return false;
        }
        if (this.movie == null ? activityEntity.movie != null : !this.movie.equals(activityEntity.movie)) {
            return false;
        }
        if (this.operation != activityEntity.operation) {
            return false;
        }
        if (this.type != activityEntity.type) {
            return false;
        }
        if (this.user != null) {
            if (this.user.equals(activityEntity.user)) {
                return true;
            }
        } else if (activityEntity.user == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.type != null ? this.type.hashCode() : 0) * 31;
        if (this.operation != null) {
            hashCode = this.operation.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.inserted != null) {
            hashCode = this.inserted.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.user != null) {
            hashCode = this.user.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((hashCode + hashCode2) * 31) + this.rating) * 31;
        if (this.movie != null) {
            i = this.movie.hashCode();
        }
        return hashCode + i;
    }
}
