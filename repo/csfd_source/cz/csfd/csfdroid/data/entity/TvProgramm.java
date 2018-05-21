package cz.csfd.csfdroid.data.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TvProgramm implements Serializable {
    private static final long serialVersionUID = 1;
    private Date dateTime;
    private Date scheduleDate;
    private String station;
    private int stationId;

    public TvProgramm(String str, Date date) {
        this.station = str;
        this.dateTime = date;
    }

    public String m7053a() {
        return this.station;
    }

    public int m7056b() {
        return this.stationId;
    }

    public void m7054a(int i) {
        this.stationId = i;
    }

    public Date m7057c() {
        return this.dateTime;
    }

    public Date m7058d() {
        return this.scheduleDate;
    }

    public void m7055a(Date date) {
        this.scheduleDate = date;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");
        DateFormat timeInstance = DateFormat.getTimeInstance(3);
        m7052b(new Date());
        return this.station + ", " + timeInstance.format(this.dateTime);
    }

    public String m7059e() {
        return new SimpleDateFormat("H:mm").format(this.dateTime);
    }

    private Date m7052b(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TvProgramm tvProgramm = (TvProgramm) obj;
        if ((this.station == tvProgramm.station || this.station.equals(tvProgramm.station)) && (this.dateTime == tvProgramm.dateTime || this.dateTime.equals(tvProgramm.dateTime))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.station == null ? 0 : this.station.hashCode()) + 217;
        if (this.dateTime != null) {
            i = this.dateTime.hashCode();
        }
        return (hashCode * 31) + i;
    }
}
