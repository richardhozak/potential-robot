package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message implements Serializable {
    private static final long serialVersionUID = 1;
    private String id;
    private Date readByRecipientDate;
    private User recipient;
    private User sender;
    private Date sentDate;
    private String text;

    public String m6831a() {
        return this.id;
    }

    public void m6833a(String str) {
        this.id = str;
    }

    public String m6835b() {
        return this.text.replaceAll("</p>\\s+<p>", "<br />").replaceAll("</?p>", "").replaceAll("<img.+?>", "").replaceAll("&nbsp;", " ").replaceAll("<br />\\s*<br />\\s*$", "").replaceAll("<br />\\s*$", "");
    }

    public String m6839c() {
        Matcher matcher = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>").matcher(this.text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public void m6837b(String str) {
        this.text = str;
    }

    public Date m6840d() {
        return this.sentDate;
    }

    public void m6834a(Date date) {
        this.sentDate = date;
    }

    public void m6838b(Date date) {
        this.readByRecipientDate = date;
    }

    public User m6841e() {
        return this.sender;
    }

    public void m6832a(User user) {
        this.sender = user;
    }

    public User m6842f() {
        return this.recipient;
    }

    public void m6836b(User user) {
        this.recipient = user;
    }
}
