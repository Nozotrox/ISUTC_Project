package Screens;

import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Storage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Screens.ProviderFrame.model;

/**
 * Created by MSI on 20-Oct-18.
 */
public class StorageFrame extends JInternalFrame implements ActionListener {

    JTable table;

    JTextField getTxtNome, getTxtNr;

    JButton btnPesquisar,  btnActualizar,  btnGravar;


    DefaultTableModel model;

    JTextField codigo_;
    JTextField tipo;
    JTextField nome_;

    JButton update_;
    JButton save_;
    private ImageIcon icon;

    public StorageFrame(){

        setTitle("Armazem");
        System.out.println("SHITK");
        setSize(600,400);
        setLocation(220,220);
        setLayout(new BorderLayout());

        // Data to be displayed in the JTable
        String[][] data = null;

        // Column Names
        String[] columnNames = null;
        // Column Names
        columnNames = new String[] { "Codigo", "Nome", "Nuit" };

        // Layout //

        JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Tela de Registo de Armazem");
        label.setFont(new Font("Century Gothic", Font.BOLD, 14));
        north.add(label);

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        populate_table();


        //   Layout    //

/*        JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        north.add(new JLabel("Tela de Registo de Armazem"));*/


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
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 70));

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setLayout(new GridLayout(5,1));

        pLeft.add(new JLabel("Codigo: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Tipo: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Password: "));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(5, 1));
        codigo_ = new JTextField(12);
        codigo_.setEnabled(false);
        codigo_.setText(ID_Gen.nextStorageId());


        //codigo_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        tipo = new JTextField(12);
        //tipo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        nome_ = new JTextField(12);
        //nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));


        pRight.add(codigo_);
        pRight.add(new JLabel(""));
        pRight.add(nome_);
        pRight.add(new JLabel(""));
        pRight.add(tipo);

        JPanel pbtn = new JPanel();
        pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Button OK
         save_= new JButton("OK"); save_.setBorder(null); save_.setBackground(Color.LIGHT_GRAY); save_.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY)); save_.addActionListener(this);
         save_.addActionListener(this);

        //Button Cancel
        update_ = new JButton("Actualizar");
        update_.setBackground(Color.GRAY);
        update_.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
        update_.addActionListener(this);

        pbtn.add(save_); pbtn.add(update_);

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

//    public static void main(String [] args){
//        new StorageFrame();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==save_){

            if(validation()){

                String nome = nome_.getText();
                Storage store = new Storage(nome);
                UserUtility.active_user.adicionar_armazem(store);
                addToTable(store);
                codigo_.setText(ID_Gen.nextStorageId());
                clearAll();
            }
        }

        if(e.getSource() == update_){
            update();
        }
    }


    public void update(){
        clearTable();
        populate_table();
    }
    public void addToTable(Storage store){

        String[] additionable = {store.getId(), store.getTipo(), String.valueOf(store.getAllProducts().length)};
        this.model.addRow(additionable);
    }

    public void clearTable(){
        int rowCount = model.getRowCount();

        for(int i = 0; i < rowCount; i++){
            model.removeRow(i);
        }

    }

    public void clearAll(){
        nome_.setText("");
        getTxtNome.setText("");
        getTxtNr.setText("");
    }

    public boolean validation(){
        String nome = nome_.getText();

        if(nome.equals("") || nome.isEmpty()){
            return false;
        }

        return true;

    }

    public void populate_table(){

        String[][] allStorage = UserUtility.active_user.getAllStorages();

        for(String[] data: allStorage){

            this.model.addRow(data);
        }
    }
}
