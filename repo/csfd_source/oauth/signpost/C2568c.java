package oauth.signpost;

import com.google.p050a.p051a.p052a.p053a.C1198a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import oauth.signpost.p029c.C2566a;
import org.apache.http.protocol.HTTP;

/* compiled from: OAuth */
public class C2568c {
    private static final C1198a f6420a = new C1198a("-._~", false);

    public static String m9495a(String str) {
        if (str == null) {
            return "";
        }
        return f6420a.mo1978a(str);
    }

    public static String m9499b(String str) {
        if (str != null) {
            return URLDecoder.decode(str, HTTP.UTF_8);
        }
        try {
            return "";
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static C2566a m9501c(String str) {
        C2566a c2566a = new C2566a();
        if (C2568c.m9502d(str)) {
            return c2566a;
        }
        for (String str2 : str.split("\\&")) {
            String str22;
            String b;
            int indexOf = str22.indexOf(61);
            if (indexOf < 0) {
                b = C2568c.m9499b(str22);
                str22 = null;
            } else {
                b = C2568c.m9499b(str22.substring(0, indexOf));
                str22 = C2568c.m9499b(str22.substring(indexOf + 1));
            }
            c2566a.m9483a(b, str22);
        }
        return c2566a;
    }

    public static C2566a m9498a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        return C2568c.m9501c(stringBuilder.toString());
    }

    public static boolean m9502d(String str) {
        return str == null || str.length() == 0;
    }

    public static String m9497a(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str + (str.contains("?") ? "&" : "?"));
        for (int i = 0; i < strArr.length; i += 2) {
            if (i > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(C2568c.m9495a(strArr[i]) + "=" + C2568c.m9495a(strArr[i + 1]));
        }
        return stringBuilder.toString();
    }

    public static String m9496a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str + (str.contains("?") ? "&" : "?"));
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static C2566a m9503e(String str) {
        C2566a c2566a = new C2566a();
        if (str != null && str.startsWith("OAuth ")) {
            for (String split : str.substring("OAuth ".length()).split(",")) {
                String[] split2 = split.split("=");
                c2566a.m9483a(split2[0].trim(), split2[1].replace("\"", "").trim());
            }
        }
        return c2566a;
    }

    public static void m9500b(String str, String str2) {
        if (System.getProperty("debug") != null) {
            System.out.println("[SIGNPOST] " + str + ": " + str2);
        }
    }
}
