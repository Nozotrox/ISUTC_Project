package Screens;

import javax.swing.*;

public class Factura extends Thread {

    JTextArea campus;
    String text;
    public Factura(JTextArea campus, String text_to_print){
        this.campus = campus;
        this.text = text_to_print;
    }


    public void run(){

        for(int i = 0; i < this.text.length(); i++){
            this.campus.append(this.text.substring(i, i+1));

            try {
                this.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
