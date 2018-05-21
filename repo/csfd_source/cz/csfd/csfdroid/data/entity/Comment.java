package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private static final long serialVersionUID = 1;
    private Date insertedDateTime;
    private int rating;
    private boolean ratingComputed;
    private String text;
    private User user;

    public Comment(User user, int i, String str, Date date) {
        this.user = user;
        this.rating = i;
        this.text = str;
        this.insertedDateTime = date;
    }

    public User m6780a() {
        return this.user;
    }

    public int m6782b() {
        return this.rating;
    }

    public String m6783c() {
        return this.text;
    }

    public boolean m6784d() {
        return this.ratingComputed;
    }

    public void m6781a(boolean z) {
        this.ratingComputed = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Comment comment = (Comment) obj;
        if ((this.user == comment.user || this.user.equals(comment.user)) && this.rating == comment.rating && ((this.text == comment.text || this.text.equals(comment.text)) && ((this.insertedDateTime == comment.insertedDateTime || this.insertedDateTime.equals(comment.insertedDateTime)) && this.ratingComputed == comment.ratingComputed))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.insertedDateTime == null ? 0 : this.insertedDateTime.hashCode()) + ((((this.rating + (((this.user == null ? 0 : this.user.hashCode()) + 217) * 31)) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31);
        if (this.ratingComputed) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }
}
