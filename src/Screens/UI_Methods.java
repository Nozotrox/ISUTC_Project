package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_Methods {

    static JTable table;

    static JTextField getTxtNome, getTxtNr, setTxtNome, setTxtNr;

    static JButton btnPesquisar,  btnActualizar,  btnGravar;

    public static  void buildArmazemFrame(JInternalFrame armazemFrame){
        armazemFrame.setLocation(0,0);
        armazemFrame.toFront();
        armazemFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        armazemFrame.setTitle("Armazem");
        armazemFrame.setSize(600,400);
        //setLocationRelativeTo(null);
        armazemFrame.setLayout(new BorderLayout());

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
        JLabel label = new JLabel("Tela de Registo de Armazem");

        label.setFont(new Font("Century Gothic", Font.BOLD, 25));
        north.add(label);

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        table = new JTable(model);
        JPanel table_layout = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(table);

        table_layout.add("North", table.getTableHeader());
        table_layout.add("Center", scroll);

        JPanel pnCenter = new JPanel(new GridLayout(2,1));

        JPanel pnUpSide = new JPanel(new GridLayout(1,2));

        JPanel pn = new JPanel(new BorderLayout());

        /////         /////

        JPanel pcenter = new JPanel();
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 60));

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setLayout(new GridLayout(3,1));

        pLeft.add(new JLabel("Nr: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Nome: "));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(3, 1));
        setTxtNr = new JTextField(15);
        setTxtNome = new JTextField(15);

        pRight.add(setTxtNr);
        pRight.add(new JLabel(""));
        pRight.add(setTxtNome);

        JPanel pbtn = new JPanel();
        pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Button OK
        btnActualizar = new JButton("Actualizar");
        //sign_up.addActionListener(this);

        //Button Cancel
        btnGravar = new JButton("Gravar");
        //cancel.addActionListener(this);

        pbtn.add(btnActualizar); pbtn.add(btnGravar);

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

        armazemFrame.add("North",north );
        armazemFrame.add("Center", pnCenter);

        armazemFrame.setVisible(true);
    }
}
