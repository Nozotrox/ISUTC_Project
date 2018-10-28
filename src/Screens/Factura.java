package Screens;

import javax.swing.*;

public class Factura extends Thread {

    JTextArea campus;
    public Factura(JTextArea campus){
        this.campus = campus;
    }


    public void run(){

        String text = "It doesn't have to be exact, just generally the same. \n" +
                "And also there is no X or winner variable since I haven't implemented that. \n" +
                "I also tried changing the margins from (5,5,5,5) to like (1,1,1,1), but that didn't change anything at all \n" +
                "so that also confused me. s";
        for(int i = 0; i < text.length(); i++){
            this.campus.append(text.substring(i, i+1));

            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
