package Screens;

import Main.Authentication;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Provider;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Created by MSI on 16-Oct-18.
 *
 */
public class ProviderFrame extends JInternalFrame implements ActionListener {

     JTable table;

     JTextField getTxtNome, getTxtNr;

     JButton btnPesquisar, btnActualizar, btnGravar;

     JTextField nuit_, nome_, codigo_;

     JButton cancel;
     JButton save;
    String[] columnNames;


    static DefaultTableModel model;

    public ProviderFrame(){
       setTitle("Fornecedores");
       setSize(600, 400);
       setLayout(new BorderLayout());

        // Data to be displayed in the JTable
        String[][] data = null;

        // Column Names
        columnNames = new String[]{ "Codigo", "Nome", "Nuit" };

        // Layout //

        JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Tela de Registo de Fornecedores");
        label.setFont(new Font("Century Gothic", Font.BOLD, 14));
        north.add(label);

        model = new DefaultTableModel(data, columnNames) {
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

        JPanel pnCenter = new JPanel(new GridLayout(2, 1));

        JPanel pnUpSide = new JPanel(new GridLayout(1, 2));

        JPanel pn = new JPanel(new BorderLayout());

        ///// /////

        JPanel pcenter = new JPanel();
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setLayout(new GridLayout(6, 1));

        pLeft.add(new JLabel("Codigo: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Nome: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Nuit: "));
        pLeft.add(new JLabel(""));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(6, 1));

        nuit_ = new JTextField(12);

        // username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        // password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        nome_ = new JTextField(12);
        // nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        codigo_ = new JTextField(5);
        codigo_.setText(ID_Gen.nextId());
        codigo_.setEnabled(false);

        JPanel aux = new JPanel(new FlowLayout());
        pRight.add(codigo_);
        pRight.add(new JLabel(""));
        pRight.add(nome_);
        pRight.add(new JLabel(""));
        pRight.add(nuit_);
        pRight.add(new JLabel(""));

        JPanel pbtn = new JPanel();
        pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Button Save #Gravar
        save = new JButton("Gravar");
        save.setBorder(null);
        save.setBackground(Color.LIGHT_GRAY);
        save.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
        save.addActionListener(this);

        // Button Cancel
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.GRAY);
        cancel.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
        cancel.addActionListener(this);

        pbtn.add(save);
        pbtn.add(cancel);

        pcenter.add(pLeft);
        pcenter.add(pRight);

        ///// /////

        pn.add("Center", pcenter);
        pn.add("South", pbtn);

        pnUpSide.add(pn);

        pnUpSide.add(new JLabel(""));

        JPanel pnBottonSide = new JPanel(new BorderLayout());

        JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 25));

        getTxtNome = new JTextField(15);
        getTxtNr = new JTextField(15);
        btnPesquisar = new JButton("Procurar");
        btnPesquisar.addActionListener(this);

        banner.add(new JLabel("Codigo: "));
        banner.add(getTxtNr);
        banner.add(new JLabel("Nome:"));
        banner.add(getTxtNome);
        banner.add(btnPesquisar);

        pnBottonSide.add("North", banner);
        pnBottonSide.add("Center", table_layout);

        pnCenter.add(pnUpSide);
        pnCenter.add(pnBottonSide);

        add("North", north);
        add("Center", pnCenter);
        read();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPesquisar) {
            Vector vasd = new Vector<>();

            //::>> Pesquisa
            if ((!model.getDataVector().isEmpty() && !getTxtNome.getText().equals("")) || (!model.getDataVector().isEmpty() && !codigo_.getText().equals(""))) {
                if ((getTxtNome.getText() != null) && (!getTxtNome.getText().equals(""))) {
                    for (Object object : model.getDataVector()) {
                        Vector vector = (Vector) object;
                        if (vector.get(1).equals(getTxtNome.getText())) {
                            vasd.add(vector);
                        }
                    }
                    int a = model.getDataVector().size();
                    for (int i = 0; i <= a; i++) {
                        try {
                            model.removeRow(i);
                            i--;
                        } catch (Exception d) {

                        }
                    }

                    for (Object vd : vasd) {
                        Vector vector = (Vector) vd;
                        model.addRow(new String[]{"" + vector.get(0), "" + vector.get(1), "" + vector.get(2)});
                    }
                }
                else if ((getTxtNr.getText() != null) || (!codigo_.getText().equals(""))){
                    for (Object object : model.getDataVector()) {
                        Vector vector = (Vector) object;
                        if (vector.get(0).equals(getTxtNr.getText())) {
                            vasd.add(vector);
                        }
                    }
                    int a = model.getDataVector().size();
                    for (int i = 0; i <= a; i++) {
                        try {
                            model.removeRow(i);
                            i--;
                        } catch (Exception d) {

                        }
                    }

                    for (Object vd : vasd) {
                        Vector vector = (Vector) vd;
                        model.addRow(new String[]{"" + vector.get(0), "" + vector.get(1), "" + vector.get(2)});
                    }
                    getTxtNome.setText("");
                    getTxtNr.setText("");

                }
                getTxtNome.setText("");
                getTxtNr.setText("");
            }
            else {
                read();
            }
        }
        else if (e.getSource().equals(save)) {

            String[] a = { "" + codigo_.getText(), "" + nome_.getText(), "" + nuit_.getText() };
            model.addRow(a);
            Provider fornecedor = new Provider(nome_.getText(), nuit_.getText());
            UserUtility.active_user.adicionar_fornecedor(fornecedor);
            codigo_.setText(ID_Gen.nextId());
            write();
        } else if (e.getSource().equals(cancel)) {
            model.removeRow(model.getDataVector().size() - 1);
        }
    }

    public void write(){
        Authentication.write();

        /*FileOutputStream file_output = null;
        ObjectOutputStream o_output = null;

        try {
            file_output = new FileOutputStream("Providers.dat");
            o_output = new ObjectOutputStream(file_output);

            o_output.writeObject(model.getDataVector());
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally{

            try {
                o_output.close();
                file_output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
    }

    private void read() {
        FileInputStream file_input = null;
        ObjectInputStream o_input = null;
        model.setDataVector(null,columnNames);

        if(UserUtility.active_user.getAllProviders() != null) {
            String[][] fornecedores = UserUtility.active_user.getAllProviders();
            for (String[] data : fornecedores) {
                model.addRow(data);
            }
        }

        /*try {
            file_input = new FileInputStream("Providers.dat");
            o_input = new ObjectInputStream(file_input);



            for(Object object:(Vector) o_input.readObject()){
                Vector ok= (Vector) object;
                String[] args=new String[]{""+ok.get(0),""+ok.get(1),""+ok.get(2)};
                model.addRow(args);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                o_input.close();
                file_input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e){
                e.printStackTrace();
            }

        }*/

    }

    public static Vector reader(){
        FileInputStream file_input = null;
        ObjectInputStream o_input = null;
        try {
            file_input = new FileInputStream("Providers.dat");
            o_input = new ObjectInputStream(file_input);
            return (Vector) o_input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                o_input.close();
                file_input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e){
                e.printStackTrace();
            }
            Vector v=new Vector();
            return v;
        }
    }


}
