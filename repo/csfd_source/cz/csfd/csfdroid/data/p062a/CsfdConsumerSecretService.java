package cz.csfd.csfdroid.data.p062a;

import cz.csfd.csfdroid.data.CsfdApiUrlHelper;

/* compiled from: CsfdConsumerSecretService */
public class C2015c implements C2013a {
    private String consumerSecret;

    public String mo3356a() {
        if (this.consumerSecret == null) {
            this.consumerSecret = new CsfdConsumerSecretGenerator(CsfdApiUrlHelper.getRequestAccessTokenUrl()).generateConsumerSecret();
        }
        return this.consumerSecret;
    }
}
