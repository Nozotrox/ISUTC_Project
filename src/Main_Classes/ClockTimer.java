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

    public void run(){

        try {
            while(true) {
                this.sleep(1000);
                now = LocalDateTime.now();
                time.setText(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
//                System.out.print("running");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
