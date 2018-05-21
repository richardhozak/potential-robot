package cz.csfd.csfdroid.module.messages;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0230b;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.gd.widget.p065a.C2085b;
import cz.csfd.csfdroid.list.p063a.C2106n;
import cz.csfd.csfdroid.list.p063a.C2107o;
import cz.csfd.csfdroid.p061d.C1982e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: MessagesThreadFragment */
public class C2306f extends C2063g<List<Message>> {
    private C2086a f5653j;
    private List<C2083a> f5654k = new ArrayList();
    private List<Message> f5655l = new ArrayList();
    private List<Message> f5656m;
    private List<Message> f5657n = new ArrayList();
    private boolean f5658o;
    private C2297d f5659p;
    private int f5660q;
    private String f5661r;
    private ListView f5662s;
    private EditText f5663t;

    /* compiled from: MessagesThreadFragment */
    class C22991 implements OnClickListener {
        final /* synthetic */ C2306f f5645a;

        C22991(C2306f c2306f) {
            this.f5645a = c2306f;
        }

        public void onClick(View view) {
            this.f5645a.m8351a(this.f5645a.f5663t.getText().toString());
            this.f5645a.f5663t.setText("");
        }
    }

    /* compiled from: MessagesThreadFragment */
    class C23002 implements MultiChoiceModeListener {
        final /* synthetic */ C2306f f5646a;

        C23002(C2306f c2306f) {
            this.f5646a = c2306f;
        }

        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            Message c = ((C2107o) ((C2083a) this.f5646a.f5654k.get(i))).m7423c();
            if (z) {
                this.f5646a.f5657n.add(c);
            } else {
                this.f5646a.f5657n.remove(c);
            }
            actionMode.setTitle(this.f5646a.getString(R.string.action_mode_selected_count, String.valueOf(this.f5646a.f5657n.size())));
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.messages_action_mode, menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete:
                    this.f5646a.m8360c(this.f5646a.f5657n);
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f5646a.f5657n.clear();
        }
    }

    /* compiled from: MessagesThreadFragment */
    class C23024 implements OnClickListener {
        final /* synthetic */ C2306f f5649a;

        C23024(C2306f c2306f) {
            this.f5649a = c2306f;
        }

        public void onClick(View view) {
            this.f5649a.m8371o();
            this.f5649a.f5658o = true;
        }
    }

    /* compiled from: MessagesThreadFragment */
    class C23035 implements C1945a<Boolean> {
        final /* synthetic */ C2306f f5650a;

        C23035(C2306f c2306f) {
            this.f5650a = c2306f;
        }

        public void m8337a(Boolean bool) {
            this.f5650a.f5656m = null;
        }

        public void mo3323a(Exception exception) {
            Toast.makeText(this.f5650a.getActivity(), R.string.deleting_messages_failed, 0).show();
            this.f5650a.m8371o();
        }

        public void mo3322a() {
        }
    }

    /* compiled from: MessagesThreadFragment */
    class C23046 implements C1945a<Message> {
        final /* synthetic */ C2306f f5651a;

        C23046(C2306f c2306f) {
            this.f5651a = c2306f;
        }

        public void m8341a(Message message) {
            if (this.f5651a.f5655l.size() == 0 || !this.f5651a.m8354a(message.m6840d(), ((Message) this.f5651a.f5655l.get(this.f5651a.f5655l.size() - 1)).m6840d())) {
                this.f5651a.f5653j.m7313a(new C2106n(message.m6840d()));
            }
            this.f5651a.f5655l.add(message);
            this.f5651a.f5653j.m7313a(new C2107o(message));
            this.f5651a.f5653j.notifyDataSetChanged();
            this.f5651a.f5662s.smoothScrollToPosition(this.f5651a.f5653j.getCount());
        }

        public void mo3323a(Exception exception) {
            Toast.makeText(this.f5651a.getActivity(), this.f5651a.getString(R.string.sending_message_failed), 0).show();
        }

        public void mo3322a() {
        }
    }

    /* compiled from: MessagesThreadFragment */
    class C23057 implements C1945a<User> {
        final /* synthetic */ C2306f f5652a;

        C23057(C2306f c2306f) {
            this.f5652a = c2306f;
        }

        public void m8345a(User user) {
            this.f5652a.f5661r = user.m6811b();
            ((MessagesThreadActivity) this.f5652a.getActivity()).m1367b().mo1413a(this.f5652a.f5661r);
        }

        public void mo3323a(Exception exception) {
        }

        public void mo3322a() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5659p = this.b.m6219g().mo3466p();
        this.f5660q = getArguments().getInt("user_id");
        this.f5661r = getArguments().getString("user_nick");
        Uri data = getActivity().getIntent().getData();
        if (this.f5660q == 0 && data != null) {
            try {
                int a = this.f5659p.mo3549a(data);
                if (a > 0) {
                    this.f5660q = a;
                }
            } catch (C2288a e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.f5661r)) {
            m8361d(this.f5660q);
        }
        ((MessagesThreadActivity) getActivity()).m1367b().mo1413a(this.f5661r);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_messages_thread, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5662s = (ListView) view.findViewById(16908298);
        this.f5663t = (EditText) view.findViewById(R.id.message);
        view.findViewById(R.id.container_reply).setVisibility(this.f5660q > 0 ? 0 : 8);
        ((Button) view.findViewById(R.id.button_send)).setOnClickListener(new C22991(this));
        if (VERSION.SDK_INT >= 11) {
            m8369m();
        }
    }

    @TargetApi(11)
    private void m8369m() {
        getListView().setChoiceMode(3);
        getListView().setMultiChoiceModeListener(new C23002(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getActivity().getMenuInflater().inflate(R.menu.messages_action_mode, contextMenu);
    }

    private void m8360c(List<Message> list) {
        this.f5656m = new ArrayList();
        this.f5656m.addAll(this.f5655l);
        final List arrayList = new ArrayList();
        for (Message message : list) {
            arrayList.add(message.m6831a());
            this.f5655l.remove(message);
        }
        m8370n();
        Snackbar.m1006a(getView(), (int) R.string.messages_were_deleted, 0).m1011a((int) R.string.cancel_delete, new C23024(this)).m1012a(new C0230b(this) {
            final /* synthetic */ C2306f f5648b;

            public void mo3546a(Snackbar snackbar, int i) {
                if (!this.f5648b.f5658o) {
                    this.f5648b.m8362d(arrayList);
                }
                this.f5648b.f5658o = false;
            }
        }).m1015a();
    }

    private void m8362d(List<String> list) {
        this.f5659p.mo3559b(new C23035(this), this.b.m6220h(), list);
    }

    private boolean m8354a(Date date, Date date2) {
        return Math.abs(date.getTime() - date2.getTime()) < 3600000 || C1982e.m6332b(date).equals(C1982e.m6332b(date2));
    }

    private void m8370n() {
        this.f5654k.clear();
        int i = 0;
        while (i < this.f5655l.size()) {
            Message message = (Message) this.f5655l.get(i);
            if (i == 0 || !m8354a(message.m6840d(), ((Message) this.f5655l.get(i - 1)).m6840d())) {
                this.f5654k.add(new C2106n(message.m6840d()));
            }
            this.f5654k.add(new C2107o(message));
            i++;
        }
        this.f5653j.notifyDataSetChanged();
    }

    private void m8371o() {
        this.f5655l.clear();
        this.f5655l.addAll(this.f5656m);
        this.f5656m = null;
        m8370n();
    }

    private void m8351a(String str) {
        this.f5659p.mo3555a(new C23046(this), this.b.m6220h(), this.f5660q, str);
    }

    protected void mo3433j() {
        this.f5659p.mo3554a(this, this.b.m6220h(), this.f5660q, 10, this.f5655l.size());
    }

    protected void mo3434k() {
        this.f5659p.mo3557b();
    }

    protected void m8373b(List<Message> list) {
        int i = 0;
        this.f5655l.addAll(list);
        m7233a(this.f5654k);
        int i2 = 0;
        while (i2 < list.size()) {
            Message message = (Message) list.get(i2);
            this.f5654k.add(0, new C2107o(message));
            if (i2 == list.size() - 1 || !m8354a(message.m6840d(), ((Message) list.get(i2 + 1)).m6840d())) {
                this.f5654k.add(0, new C2106n(message.m6840d()));
            }
            i2++;
        }
        if ((list.size() < 10 ? 1 : 0) == 0) {
            this.f5654k.add(0, m7236c(R.string.messages_fetching));
        }
        if (this.f5653j == null) {
            this.f5653j = new C2086a(getActivity(), this.f5654k);
            setListAdapter(this.f5653j);
            return;
        }
        View childAt = getListView().getChildAt(1);
        int top = childAt != null ? childAt.getTop() : 0;
        this.f5653j.notifyDataSetChanged();
        if (this.f5654k.size() > 0 && (this.f5654k.get(0) instanceof C2085b)) {
            i = 1;
        }
        getListView().setSelectionFromTop((getListView().getFirstVisiblePosition() + list.size()) + i, top - getResources().getDimensionPixelSize(R.dimen.message_scroll_offset));
    }

    private void m8361d(int i) {
        this.b.m6220h().mo3380a(new User(i), new C23057(this));
    }

    public String mo3436p() {
        return "/messages/thread";
    }
}
