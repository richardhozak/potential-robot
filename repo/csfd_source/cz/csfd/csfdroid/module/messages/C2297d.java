package cz.csfd.csfdroid.module.messages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import cz.csfd.csfdroid.data.CsfdDataProvider;
import cz.csfd.csfdroid.data.CsfdDataProvider.C1945a;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.data.entity.User;
import java.util.List;

/* compiled from: MessagesModule */
public interface C2297d {
    int mo3549a(Uri uri);

    Intent mo3550a(Context context);

    void mo3551a();

    void mo3552a(C1945a<List<User>> c1945a, CsfdDataProvider c2016c);

    void mo3553a(C1945a<List<MessageThread>> c1945a, CsfdDataProvider c2016c, int i, int i2);

    void mo3554a(C1945a<List<Message>> c1945a, CsfdDataProvider c2016c, int i, int i2, int i3);

    void mo3555a(C1945a<Message> c1945a, CsfdDataProvider c2016c, int i, String str);

    void mo3556a(C1945a<Boolean> c1945a, CsfdDataProvider c2016c, List<Integer> list);

    void mo3557b();

    void mo3558b(C1945a<Integer> c1945a, CsfdDataProvider c2016c);

    void mo3559b(C1945a<Boolean> c1945a, CsfdDataProvider c2016c, List<String> list);

    void mo3560c();

    Fragment mo3561d();
}
