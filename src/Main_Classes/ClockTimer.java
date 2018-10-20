package Main_Classes;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ClockTimer extends Thread {

    Calendar cal;
    SimpleDateFormat sdf;
    JLabel time;
    LocalDateTime now;

    public ClockTimer(JLabel jt){
        super("Clock");
        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");
        time = jt;
    }

    public String timeFormat(int hour, int minute, int seconds){

        String hour_s = String.valueOf(hour);
        String minute_s = String.valueOf(minute);
        String seconds_s = String.valueOf(seconds);

        String f_hour = (hour_s.length() > 1)? hour_s: "0" + hour_s;
        String f_minute = (minute_s.length() > 1)? minute_s: "0" + minute_s;
        String f_seconds = (seconds_s.length() > 1)? seconds_s: "0" + seconds_s;

        return f_hour + ":" + f_minute + ":" + f_seconds;


    }

    public void run(){

        try {
            while(true) {
                this.sleep(1000);
                now = LocalDateTime.now();
                String timeString = timeFormat(now.getHour(), now.getMinute(), now.getSecond());
                time.setText(timeString);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
