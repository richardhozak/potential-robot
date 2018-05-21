package cz.csfd.csfdroid.module.messages;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0230b;
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
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.C2016c.C1945a;
import cz.csfd.csfdroid.data.entity.Message;
import cz.csfd.csfdroid.data.entity.MessageThread;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2108p;
import cz.csfd.csfdroid.module.ads.C2147a.C2146b;
import cz.csfd.csfdroid.module.home.C2157b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessagesFragment */
public class C2296c extends C2063g<List<MessageThread>> {
    private C2086a f5631j;
    private List<C2083a> f5632k = new ArrayList();
    private List<MessageThread> f5633l = new ArrayList();
    private List<MessageThread> f5634m;
    private List<MessageThread> f5635n = new ArrayList();
    private boolean f5636o;
    private C2297d f5637p;
    private boolean f5638q;
    private boolean f5639r;

    /* compiled from: MessagesFragment */
    class C22911 implements OnClickListener {
        final /* synthetic */ C2296c f5625a;

        C22911(C2296c c2296c) {
            this.f5625a = c2296c;
        }

        public void onClick(View view) {
            this.f5625a.m8303q();
        }
    }

    /* compiled from: MessagesFragment */
    class C22922 implements MultiChoiceModeListener {
        final /* synthetic */ C2296c f5626a;

        C22922(C2296c c2296c) {
            this.f5626a = c2296c;
        }

        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            MessageThread messageThread = (MessageThread) this.f5626a.f5633l.get(i - this.f5626a.getListView().getHeaderViewsCount());
            if (z) {
                this.f5626a.f5635n.add(messageThread);
            } else {
                this.f5626a.f5635n.remove(messageThread);
            }
            actionMode.setTitle(this.f5626a.getString(R.string.action_mode_selected_count, String.valueOf(this.f5626a.f5635n.size())));
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
                    this.f5626a.m8296c(this.f5626a.f5635n);
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f5626a.f5635n.clear();
        }
    }

    /* compiled from: MessagesFragment */
    class C22944 implements OnClickListener {
        final /* synthetic */ C2296c f5629a;

        C22944(C2296c c2296c) {
            this.f5629a = c2296c;
        }

        public void onClick(View view) {
            this.f5629a.m8302o();
            this.f5629a.f5636o = true;
        }
    }

    /* compiled from: MessagesFragment */
    class C22955 implements C1945a<Boolean> {
        final /* synthetic */ C2296c f5630a;

        C22955(C2296c c2296c) {
            this.f5630a = c2296c;
        }

        public void m8286a(Boolean bool) {
            this.f5630a.f5634m = null;
        }

        public void mo3323a(Exception exception) {
            if (this.f5630a.getActivity() != null) {
                Toast.makeText(this.f5630a.getActivity(), R.string.deleting_messages_failed, 0).show();
                this.f5630a.m8302o();
            }
        }

        public void mo3322a() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5637p = this.b.m6219g().mo3466p();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_messages, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7230a(view, C2146b.MESSAGES);
        setListAdapter(this.f5631j);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_red)));
        floatingActionButton.setImageResource(R.drawable.ic_add_white_24dp);
        floatingActionButton.setOnClickListener(new C22911(this));
        if (VERSION.SDK_INT >= 11) {
            m8300m();
        } else {
            registerForContextMenu(getListView());
        }
    }

    @TargetApi(11)
    private void m8300m() {
        getListView().setChoiceMode(3);
        getListView().setMultiChoiceModeListener(new C22922(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getActivity().getMenuInflater().inflate(R.menu.messages_action_mode, contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
        switch (menuItem.getItemId()) {
            case R.id.menu_delete:
                MessageThread messageThread = (MessageThread) this.f5633l.get(adapterContextMenuInfo.position - getListView().getHeaderViewsCount());
                List arrayList = new ArrayList();
                arrayList.add(messageThread);
                m8296c(arrayList);
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    private void m8296c(List<MessageThread> list) {
        this.f5634m = new ArrayList();
        this.f5634m.addAll(this.f5633l);
        final List arrayList = new ArrayList();
        for (MessageThread messageThread : list) {
            arrayList.add(Integer.valueOf(messageThread.m6843a().m6705g()));
            this.f5633l.remove(messageThread);
        }
        m8301n();
        Snackbar.m1006a(getView(), (int) R.string.messages_were_deleted, 0).m1011a((int) R.string.cancel_delete, new C22944(this)).m1012a(new C0230b(this) {
            final /* synthetic */ C2296c f5628b;

            public void mo3546a(Snackbar snackbar, int i) {
                if (!this.f5628b.f5636o) {
                    this.f5628b.m8297d(arrayList);
                }
                this.f5628b.f5636o = false;
            }
        }).m1015a();
    }

    private void m8297d(List<Integer> list) {
        this.f5637p.mo3556a(new C22955(this), this.b.m6220h(), list);
    }

    private void m8301n() {
        this.f5632k.clear();
        for (MessageThread c2108p : this.f5633l) {
            this.f5632k.add(new C2108p(c2108p));
        }
        this.f5631j.notifyDataSetChanged();
    }

    private void m8302o() {
        this.f5633l.clear();
        this.f5633l.addAll(this.f5634m);
        this.f5634m = null;
        m8301n();
    }

    public void onResume() {
        super.onResume();
        if (this.f5638q) {
            this.f5639r = true;
            this.f5637p.mo3553a((C1945a) this, this.b.m6220h(), 10, 0);
        }
        if (getActivity() instanceof C2157b) {
            ((C2157b) getActivity()).mo3476s();
        }
    }

    protected void mo3433j() {
        this.f5637p.mo3553a((C1945a) this, this.b.m6220h(), 10, this.f5633l.size());
    }

    protected void mo3434k() {
        this.f5637p.mo3551a();
    }

    protected void m8305b(List<MessageThread> list) {
        this.f5638q = true;
        if (this.f5639r) {
            this.f5633l.clear();
            this.f5632k.clear();
            this.f5639r = false;
        }
        this.f5633l.addAll(list);
        m7233a(this.f5632k);
        for (MessageThread messageThread : list) {
            Message b = messageThread.m6846b();
            messageThread.m6845a(b.m6842f().m6705g() != this.b.m6229q().m6253c() ? b.m6842f() : b.m6841e());
            this.f5632k.add(new C2108p(messageThread));
        }
        if (!(list.size() < 10)) {
            m7234a(this.f5632k, (int) R.string.messages_fetching);
        }
        if (this.f5631j == null) {
            this.f5631j = new C2086a(getActivity(), this.f5632k);
            setListAdapter(this.f5631j);
            return;
        }
        this.f5631j.notifyDataSetChanged();
    }

    public String mo3436p() {
        return "/messages";
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        MessageThread messageThread = (MessageThread) this.f5633l.get(i - getListView().getHeaderViewsCount());
        Intent intent = new Intent(getActivity(), MessagesThreadActivity.class);
        intent.putExtra("user_id", messageThread.m6843a().m6705g());
        intent.putExtra("user_nick", messageThread.m6843a().m6811b());
        startActivity(intent);
    }

    private void m8303q() {
        startActivity(new Intent(getActivity(), ContactsActivity.class));
    }
}
