package cz.csfd.csfdroid.module.messages;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import cz.csfd.csfdroid.C2063g;
import cz.csfd.csfdroid.CsfdApplication;
import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.User;
import cz.csfd.csfdroid.gd.widget.C2086a;
import cz.csfd.csfdroid.gd.widget.p065a.C2083a;
import cz.csfd.csfdroid.list.p063a.C2116x;
import cz.csfd.csfdroid.module.search.C2434c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactsFragment */
public class C2290b extends C2063g<List<User>> {
    private static int f5617j = 20;
    private CsfdApplication f5618k;
    private C2297d f5619l;
    private C2434c f5620m;
    private List<User> f5621n;
    private List<C2083a> f5622o;
    private C2086a f5623p;
    private EditText f5624q;

    /* compiled from: ContactsFragment */
    class C22891 implements TextWatcher {
        final /* synthetic */ C2290b f5616a;

        C22891(C2290b c2290b) {
            this.f5616a = c2290b;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f5616a.mo3433j();
            } else {
                this.f5616a.m8278a(charSequence.toString());
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5618k = (CsfdApplication) getActivity().getApplication();
        this.f5619l = this.f5618k.m6219g().mo3466p();
        this.f5620m = this.f5618k.m6219g().mo3452b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_contacts, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5624q = (EditText) view.findViewById(R.id.search_field);
        this.f5624q.addTextChangedListener(new C22891(this));
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        User user = (User) ((List) this.i).get(i - getListView().getHeaderViewsCount());
        Intent intent = new Intent(getActivity(), MessagesThreadActivity.class);
        intent.putExtra("user_id", user.m6705g());
        intent.putExtra("user_nick", user.m6811b());
        startActivity(intent);
    }

    protected void mo3433j() {
        this.f5619l.mo3552a(this, this.f5618k.m6220h());
    }

    protected void mo3434k() {
        this.f5619l.mo3560c();
        this.f5620m.mo3621b();
    }

    protected void m8280b(List<User> list) {
        this.f5621n = list;
        this.f5622o = new ArrayList();
        for (User c2116x : this.f5621n) {
            this.f5622o.add(new C2116x(c2116x));
        }
        this.f5623p = new C2086a(getActivity(), this.f5622o);
        setListAdapter(this.f5623p);
    }

    private void m8278a(String str) {
        this.f5620m.mo3618a(str, f5617j, this, this.f5618k.m6220h());
    }

    public String mo3436p() {
        return "/messages/contacts";
    }
}
