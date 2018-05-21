package cz.csfd.csfdroid.list.p063a;

import android.content.Context;
import android.view.ViewGroup;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.itemview.C2087b;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.itemview.UserItemView;

/* compiled from: UserListItem */
public class C2116x extends C2083a {
    private User f4953b;

    public C2116x(User user) {
        this.f4953b = user;
    }

    public C2087b mo3426a(Context context, ViewGroup viewGroup) {
        return C2083a.m7302a(context, R.layout.list_item_user, viewGroup);
    }

    public User m7463c() {
        return this.f4953b;
    }

    public String m7464d() {
        return this.f4953b.m6811b();
    }

    public String m7465e() {
        return this.f4953b.m6817d();
    }

    public Class<?> mo3427b() {
        return UserItemView.class;
    }
}
