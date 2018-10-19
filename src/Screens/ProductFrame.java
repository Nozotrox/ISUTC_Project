package Screens;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Product;
import Main_Classes.Provider;
import Main_Classes.Storage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import static Main.UserUtility.active_user;

/**
 *
 */

/**
 * @author MSI
 *
 */
public class ProductFrame extends JInternalFrame implements ActionListener {
    public JTable table;
    public DefaultTableModel model;
    JComboBox<String> combo;
    JScrollPane sp;
    JPanel tablePanel;
    String[] columnsNames;
    private JPanel upRight;
    private JPanel upLeft;
    private JTextField codigo_, stockMinimo_, qtd_, nome_, fornecedor;
    private JComboBox armazem_;
    private JButton save, update;

    public ProductFrame() {

        setSize(800, 550);
        setLocation(0,0);
        setLayout(new GridLayout(2, 1));
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout(0, 0));

        columnsNames = new String[] { "Codigo", "Armazem", "Stock Minimo", "Quantidade", "Nome", "Fornecedor" };
        model = new DefaultTableModel(null, columnsNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.sizeColumnsToFit(1);

        sp = new JScrollPane(table);

        tablePanel.add("North", table.getTableHeader());
        tablePanel.add("Center", sp);

        combo = new JComboBox<>();
        combo.addItem("Escolha uma Opcao               ");
        fillComboBox();

        JPanel upper = new JPanel();

        upper.setLayout(new GridLayout(1, 2, 0, 0));

        /*upRight = new JPanel();
        upRight.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        upRight.add(new JLabel("Codigo"));

        //::>>> Set up de Codigo
        codigo_ = new JTextField(20);
        codigo_.setEnabled(false);
        codigo_.setText(ID_Gen.nextId());

        upRight.add(codigo_);
        upRight.add(new JLabel("Armazem"));
        armazem_ = new JTextField(20);
        upRight.add(armazem_);
        upRight.add(new JLabel("Stock Minimo"));
        stockMinimo_ = new JTextField(20);
        upRight.add(stockMinimo_);
        upRight.add(new JLabel("Quantidade"));
        qtd_ = new JTextField(20);
        upRight.add(qtd_);
        upRight.add(new JLabel("Nome"));
        nome_ = new JTextField(20);
        upRight.add(nome_);
        upRight.add(new JLabel("Fornecedor"));*/

        upRight = new JPanel(new GridLayout(7, 1, 5, 5));

        //::>> Setup Codigo
        codigo_ = new JTextField(20);
        codigo_.setEnabled(false);
        codigo_.setText(ID_Gen.nextId());

        JPanel code = new JPanel(new FlowLayout(FlowLayout.LEFT));
        code.add(new JLabel("Codigo                  "));
        code.add(codigo_);


        //::>> Setup Armazem
        armazem_ = new JComboBox(new String[]{"Escolha um Fornecedor"});
        JPanel storage = new JPanel(new FlowLayout(FlowLayout.LEFT));
        storage.add(new JLabel("Armazem             "));
        storage.add(armazem_);


        //::>> Setup  Stock Minimo
        stockMinimo_ = new JTextField(20);
        JPanel stock = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stock.add(new JLabel("Stock Minimo      "));
        stock.add(stockMinimo_);


        //::>> Setup Quantidade
        qtd_ = new JTextField(20);
        JPanel qtd  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtd.add(new JLabel("Quantidade:         "));
        qtd.add(qtd_);


        //::>> Setup NOme
        nome_ = new JTextField(20);
        JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT));
        name.add(new JLabel("Nome:                   "));
        name.add(nome_);

        //::>> Setup Fornecedor
        JPanel provider = new JPanel(new FlowLayout(FlowLayout.LEFT));
        provider.add(new JLabel("Fornecedor:         "));
        provider.add(combo);

        //::>> Setup Space
        JPanel space = new JPanel();
        space.add(new JLabel(" "));

        upRight.add(code);
        upRight.add(storage);
        upRight.add(stock);
        upRight.add(qtd);
        upRight.add(name);
        upRight.add(provider);
        upRight.add(space);

        upper.add(upRight);

        upLeft = new JPanel();
        upLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        save = new JButton("Gravar  ");
        save.addActionListener(this);
        update = new JButton("Actualizar");
        update.addActionListener(this);
        upLeft.add(save);
        upLeft.add(update);

        upper.add(upLeft);

        add(upper);
        add(tablePanel);

    }
//
//    public static void main(String[] args) {
//        new ProductFrame().setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        boolean toSave;
        if (arg0.getSource().equals(save)) {

            try {
                int stockMin = Integer.parseInt(stockMinimo_.getText());
                int quantidade = Integer.parseInt(qtd_.getText());

                if (stockMin <= 0 || quantidade <= 0){
                    toSave = false;
                }
                else{
                    toSave = true;
                }


                if(toSave){
                    save();
                }

            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, "Insira um Dado valido");
            }


        } else if (arg0.getSource().equals(update)) {

        }

    }

    public void fillComboBox(){
        String[][] fornecedores = UserUtility.active_user.getAllProviders();
        for(String[] data: fornecedores){
            String nome = data[1];
            combo.addItem(nome);
        }

        /*if(!ProviderFrame.reader().isEmpty()){
            for (Object o : ProviderFrame.reader()) {
                Vector o1 = (Vector) o;
                combo.addItem(o1.get(1).toString());
            }
        }*/


    }


    public void save(){

        String nome = nome_.getText();
        Provider fornecedor = new Provider("lsjf", "lsdkjfl");
        int qtd = Integer.parseInt(qtd_.getText());
        int stk = Integer.parseInt(stockMinimo_.getText());
        Storage armazem = new Storage("lsjkfs");


        Product produto  = new Product(nome, fornecedor, armazem, qtd, stk);

        model.addRow(new String[] { "" + codigo_.getText(), "" + armazem_.getSelectedItem().toString() , "" + stockMinimo_.getText(),
                "" + qtd_.getText(), "" + nome_.getText(), "" + combo.getSelectedItem().toString() });

        clearAll();

    }

    public void clearAll(){
        nome_.setText("");
        combo.setSelectedIndex(0);
        qtd_.setText("");
        stockMinimo_.setText("");
        armazem_.setSelectedIndex(0);
    }

}
