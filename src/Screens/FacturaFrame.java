package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaFrame extends JFrame implements ActionListener {

    JButton vender = new JButton("Vender");
    JButton cancelar = new JButton("Fechar");
    public static boolean sell = false;



    public FacturaFrame(String recibo){
        super();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Factura");
        this.setLayout(new BorderLayout());


        /*LAYOUT*/
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Cambria", Font.BOLD, 10));
        textArea.setPreferredSize(new Dimension(300, 500));
        JPanel buttons_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttons_panel.add(this.vender);
        buttons_panel.add(this.cancelar);

        this.add("Center", textArea);
        this.add("South", buttons_panel);

//        this.vender.addActionListener(this);
        this.cancelar.addActionListener(this);


        this.add(textArea);
        Factura thread = new Factura(textArea, recibo);
        thread.start();

        this.setVisible(true);
        this.pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==this.vender){
            FacturaFrame.sell = true;
            this.dispose();
        }

        else if(e.getSource() == this.cancelar){
            FacturaFrame.sell = false;
            this.dispose();
        }

    }
}
