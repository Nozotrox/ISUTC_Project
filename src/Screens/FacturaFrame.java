package Screens;

import javax.swing.*;

public class FacturaFrame extends JFrame {

    public FacturaFrame(){

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Factura");

        JTextArea textArea = new JTextArea();
        this.add(textArea);
        Factura thread = new Factura(textArea);
        thread.start();

        this.setVisible(true);
    }


    public static void main(String[] args){
        new FacturaFrame();
    }

}
