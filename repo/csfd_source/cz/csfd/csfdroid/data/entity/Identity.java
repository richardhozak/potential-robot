package cz.csfd.csfdroid.data.entity;

import java.util.EnumMap;
import java.util.Map;

public class Identity extends User {
    private static final long serialVersionUID = 1;
    Map<Acl, Boolean> acls = new EnumMap(Acl.class);

    public enum Acl {
        FILM_COMMENT("film_comment");
        
        private String key;

        private Acl(String str) {
            this.key = str;
        }

        public String m6805a() {
            return this.key;
        }
    }

    public Identity(int i, String str) {
        super(i, str);
    }

    public void m6830a(Acl acl, boolean z) {
        this.acls.put(acl, Boolean.valueOf(z));
    }

    public Map<Acl, Boolean> m6829a() {
        return this.acls;
    }
}
