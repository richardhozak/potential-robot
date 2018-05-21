package cz.csfd.csfdroid.net.p067a;

import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.p061d.C1998s;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MessagesJsonHelper */
public class C2507l {
    public List<MessageThread> m9266a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("threads");
        List<MessageThread> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            MessageThread messageThread = new MessageThread(m9265e(jSONArray.getJSONObject(i)));
            messageThread.m6844a(jSONArray.getJSONObject(i).getInt("unread"));
            arrayList.add(messageThread);
        }
        return arrayList;
    }

    public List<Message> m9267b(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("messages");
        List<Message> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m9265e(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private Message m9265e(JSONObject jSONObject) {
        int i = 0;
        Message message = new Message();
        if (jSONObject.has("sender")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sender");
            int parseInt = (jSONObject2.getString("id") == null || jSONObject2.getString("id").equals("null")) ? 0 : Integer.parseInt(jSONObject2.getString("id"));
            User user = new User(parseInt, jSONObject2.getString("nick"));
            user.m6815c(jSONObject2.getString("avatar_url"));
            user.m6812b(jSONObject2.getString("fullname"));
            message.m6832a(user);
        } else if (jSONObject.has("sender_id")) {
            message.m6832a(new User(Integer.parseInt(jSONObject.getString("sender_id"))));
        }
        if (jSONObject.has("recipient")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("recipient");
            if (!(jSONObject3.getString("id") == null || jSONObject3.getString("id").equals("null"))) {
                i = Integer.parseInt(jSONObject3.getString("id"));
            }
            User user2 = new User(i, jSONObject3.getString("nick"));
            user2.m6815c(jSONObject3.getString("avatar_url"));
            user2.m6812b(jSONObject3.getString("fullname"));
            message.m6836b(user2);
        } else if (jSONObject.has("recipient_id")) {
            message.m6836b(new User(Integer.parseInt(jSONObject.getString("recipient_id"))));
        }
        if (jSONObject.has("id")) {
            message.m6833a(jSONObject.getString("id"));
        }
        message.m6837b(jSONObject.getString("text"));
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (jSONObject.has("sent_datetime") && !jSONObject.isNull("sent_datetime")) {
                message.m6834a(simpleDateFormat.parse(jSONObject.getString("sent_datetime")));
            }
            if (jSONObject.has("read_by_recipient_datetime") && !jSONObject.isNull("read_by_recipient_datetime")) {
                message.m6838b(simpleDateFormat.parse(jSONObject.getString("read_by_recipient_datetime")));
            }
        } catch (Exception e) {
            C1998s.m6371a(getClass(), e);
        }
        return message;
    }

    public Message m9268c(JSONObject jSONObject) {
        return m9265e(jSONObject.getJSONArray("sendMessages").getJSONObject(0));
    }

    public List<User> m9269d(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("contacts");
        List<User> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C2513q.m9297a(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
