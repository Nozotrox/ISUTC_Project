package Screens;

import Main.UserUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/**
 * Created by MSI on 16-Oct-18.
 *
 */
public class ReportFrame extends JInternalFrame implements ActionListener{

    JTextArea report = new JTextArea();
    JButton not;

    public ReportFrame(){
        setTitle("Histórico");
        setSize(800, 300);
        setLayout(new BorderLayout());
        report.setFont(new Font("Cambria", Font.PLAIN, 17));
        report.setEditable(false);
        report.setForeground(Color.black);

        JPanel pn = new JPanel();

        not = new JButton("Actualizar");
        not.addActionListener(this);

        pn.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pn.add(not);

        JScrollPane scroll = new JScrollPane(report);

        //getSource();
        getSource();
        this.add("North", pn);
        this.add("Center",scroll);
    }

    public void getSource(){
        report.setText("");
        ClassRelatorio cr = new ClassRelatorio();

        Vector ler = new Vector();
        ler = cr.ler_Relatorio();

        for (int i=0; i<ler.size(); i++) {
            report.setText(report.getText() + ler.get(i).toString() + "\n");
        }

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==not){
            getSource();
        }
    }
}
