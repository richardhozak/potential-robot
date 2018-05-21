package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;

public class MessageThread implements Serializable {
    private static final long serialVersionUID = 1;
    private Message latestMessage;
    private User participant;
    private int unread;

    public MessageThread(Message message) {
        this.latestMessage = message;
    }

    public User m6843a() {
        return this.participant;
    }

    public void m6845a(User user) {
        this.participant = user;
    }

    public Message m6846b() {
        return this.latestMessage;
    }

    public int m6847c() {
        return this.unread;
    }

    public void m6844a(int i) {
        this.unread = i;
    }
}
