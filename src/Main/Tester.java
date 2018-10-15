package Main;

import javax.swing.*;

public class Tester extends JFrame {

    public Tester(){
        build();
    }

    private void build(){

        this.setBounds(50, 50, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(100, 100, 50, 20);
        this.getContentPane().add(nome);


        this.setVisible(true);

    }

    public static void main(String[] args){
        new Tester();
    }
}
