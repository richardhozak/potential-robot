package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class Trivia implements Serializable {
    private static final long serialVersionUID = 1;
    private String source;
    private String text;
    private String type;
    private User user;

    public Trivia(String str, String str2, User user, String str3) {
        this.text = str;
        this.type = str2;
        this.user = user;
        this.source = str3;
    }

    public String m7041a() {
        return this.text;
    }

    public String m7042b() {
        return this.type;
    }

    public User m7043c() {
        return this.user;
    }

    public String m7044d() {
        return this.source;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Trivia trivia = (Trivia) obj;
        if ((this.text == trivia.text || this.text.equals(trivia.text)) && ((this.type == trivia.type || this.type.equals(trivia.type)) && ((this.user == trivia.user || this.type.equals(trivia.user)) && (this.source == trivia.source || this.source.equals(trivia.source))))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.user == null ? 0 : this.user.hashCode()) + (((((this.text == null ? 0 : this.text.hashCode()) + 217) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31);
        if (this.source != null) {
            i = this.source.hashCode();
        }
        return (hashCode * 31) + i;
    }
}
