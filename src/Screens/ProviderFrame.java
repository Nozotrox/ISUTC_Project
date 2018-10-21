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
        label.setFont(new Font("Century Gothic", Font.BOLD, 25));
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
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(3, 1));

        nuit_ = new JTextField(15);

        nome_ = new JTextField(15);

        codigo_ = new JTextField(15);

        codigo_.setText(ID_Gen.nextId());
        codigo_.setEnabled(false);

            JPanel p1 = new JPanel(new FlowLayout());
            p1.add(new JLabel("Codigo: "));
            p1.add(codigo_);
        pRight.add(p1);
            JPanel p2 = new JPanel(new FlowLayout());
            p2.add(new JLabel("Nome: "));
            p2.add(nome_);
        pRight.add(p2);
            JPanel p3 = new JPanel(new FlowLayout());
            p3.add(new JLabel("Nuit:   "));
            p3.add(nuit_);
        pRight.add(p3);

        // Button Save #Gravar
        save = new JButton("Gravar");
        save.setBackground(Color.LIGHT_GRAY);
        save.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
        save.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(Color.GRAY);
        btnActualizar.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
        btnActualizar.addActionListener(this);

        //pcenter.add(pLeft);
        pcenter.add(pRight);

        pn.add("Center", pcenter);

        pnUpSide.add(pn);

        pnUpSide.add(new JLabel(""));

        JPanel pnBottonSide = new JPanel(new BorderLayout());

        JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 15));

        banner.add(btnActualizar);
        banner.add(save);

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
