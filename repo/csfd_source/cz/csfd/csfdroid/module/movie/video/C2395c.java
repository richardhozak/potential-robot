package cz.csfd.csfdroid.module.movie.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Subtitles */
public class C2395c {
    private static Pattern f5948a = Pattern.compile(".*(\\d+).*");
    private static Pattern f5949b = Pattern.compile("(\\d+):(\\d+):(\\d+),(\\d+) --> (\\d+):(\\d+):(\\d+),(\\d+)");
    private List<C2394b> f5950c = new ArrayList();

    public C2395c(String str) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        C2394b c2394b = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (c2394b == null) {
                Matcher matcher = f5948a.matcher(readLine);
                if (matcher.matches()) {
                    c2394b = new C2394b();
                    c2394b.f5944a = Integer.parseInt(matcher.group(1));
                    c2394b.f5947d = "";
                }
            } else {
                try {
                    Matcher matcher2 = f5949b.matcher(readLine);
                    if (matcher2.matches()) {
                        c2394b.f5945b = (long) (((((Integer.parseInt(matcher2.group(1)) * 3600) + (Integer.parseInt(matcher2.group(2)) * 60)) + Integer.parseInt(matcher2.group(3))) * 1000) + Integer.parseInt(matcher2.group(4)));
                        c2394b.f5946c = (long) (((((Integer.parseInt(matcher2.group(5)) * 3600) + (Integer.parseInt(matcher2.group(6)) * 60)) + Integer.parseInt(matcher2.group(7))) * 1000) + Integer.parseInt(matcher2.group(8)));
                    } else if (readLine.equals("")) {
                        this.f5950c.add(c2394b);
                        c2394b = null;
                    } else {
                        if (!c2394b.f5947d.equals("")) {
                            c2394b.f5947d += "<br/>";
                        }
                        c2394b.f5947d += readLine;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public String m8756a(long j) {
        for (C2394b c2394b : this.f5950c) {
            if (j < c2394b.f5945b) {
                return "";
            }
            if (j <= c2394b.f5946c) {
                return c2394b.f5947d;
            }
        }
        return "";
    }
}
