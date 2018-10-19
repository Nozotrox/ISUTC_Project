package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MSI on 20-Oct-18.
 */
public class StorageFrame extends JInternalFrame implements ActionListener {

    JTable table;

    JTextField getTxtNome, getTxtNr;

    JButton btnPesquisar,  btnActualizar,  btnGravar;



    JTextField username_;
    JPasswordField password_;
    JTextField nome_;

    JButton cancel;
    JButton sign_up;
    private ImageIcon icon;

    public StorageFrame(){

        setTitle("Armazem");
        System.out.println("SHITK");
        setSize(600,400);
        setLocation(220,220);
        setLayout(new BorderLayout());

        // Data to be displayed in the JTable
        String[][] data = {
                { "Anand Jha", "6014", "IT" },
                { "Anand Jha", "6014", "IT" },
                { "Anand Jha", "6014", "IT" }
        };

        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };

        //   Layout    //

        JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        north.add(new JLabel("Tela de Registo de Armazem"));

        table = new JTable(data, columnNames);
        JPanel table_layout = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(table);

        table_layout.add("North", table.getTableHeader());
        table_layout.add("Center", scroll);

        JPanel pnCenter = new JPanel(new GridLayout(2,1));

        JPanel pnUpSide = new JPanel(new GridLayout(1,2));

        JPanel pn = new JPanel(new BorderLayout());

        /////         /////

        JPanel pcenter = new JPanel();
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 70));

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setLayout(new GridLayout(5,1));

        pLeft.add(new JLabel("Nome: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Username: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Password: "));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(5, 1));
        username_ = new JTextField(12);
        //username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        password_ = new JPasswordField(12);
        //password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        nome_ = new JTextField(12);
        //nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        pRight.add(nome_);
        pRight.add(new JLabel(""));
        pRight.add(username_);
        pRight.add(new JLabel(""));
        pRight.add(password_);

        JPanel pbtn = new JPanel();
        pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Button OK
        sign_up = new JButton("OK");
        sign_up.setBorder(null);
        sign_up.setBackground(Color.LIGHT_GRAY);
        sign_up.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
        sign_up.addActionListener(this);

        //Button Cancel
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.GRAY);
        cancel.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
        cancel.addActionListener(this);

        pbtn.add(sign_up); pbtn.add(cancel);

        pcenter.add(pLeft); pcenter.add(pRight);

        /////         /////

        pn.add("Center", pcenter);
        pn.add("South", pbtn);

        pnUpSide.add(pn);

        pnUpSide.add(new JLabel(""));


        JPanel pnBottonSide = new JPanel(new BorderLayout());

        JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 25));

        getTxtNome = new JTextField(15);  getTxtNr = new JTextField(15);
        btnPesquisar = new JButton("Procurar");

        banner.add(new JLabel("Nr:"));
        banner.add(getTxtNome);
        banner.add(new JLabel("Nome:"));
        banner.add(getTxtNr);
        banner.add(btnPesquisar);

        pnBottonSide.add("North", banner);
        pnBottonSide.add("Center", table_layout);

        pnCenter.add(pnUpSide);
        pnCenter.add(pnBottonSide);

        add("North",north );
        add("Center", pnCenter);

        setVisible(true);
    }

    public static void main(String [] args){
        new StorageFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnPesquisar){
            //data
        }
    }
}
