package Screens;

import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Product;
import Main_Classes.Storage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class SalesMenuFrame extends JInternalFrame implements ActionListener, MouseListener {


    public JTable table;
    public DefaultTableModel model;
    JComboBox<String> combo;
    JScrollPane sp;
    JPanel tablePanel;
    String[] columnsNames;
    Vector<String[]> data = new Vector();

    private JTextField codigo_, stockMinimo_, qtd_, nome_, qtd_venda, preco, taxes, total;
    private JComboBox armazem_;
    private JButton save, update, btnPesquisar, calcular, vender;
    private JCheckBox efectuarPesquisa;


    public SalesMenuFrame(){
        build_ui();
    }

    public void build_ui(){

        setLocation(0,0);
        this.setTitle("Produtos");
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout(0, 0));
        this.setLayout(new BorderLayout(0, 0));

        JLabel title = new JLabel("Introducao de Produtos");
        columnsNames = new String[] { "Codigo", "Nome","Quantidade", "Stock Minimo" };
        model = new DefaultTableModel(null, columnsNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        table = new JTable(model);
        table.addMouseListener(this);
        table.setFillsViewportHeight(true);
        table.sizeColumnsToFit(1);
        populate_table();

        sp = new JScrollPane(table);
        tablePanel.add("North", table.getTableHeader());
        tablePanel.add("Center", sp);

        combo = new JComboBox<>();

        //::>> Setup Codigo
        codigo_ = new JTextField(7);
        codigo_.setEnabled(false);

        //::>> Setup Armazem
        armazem_ = new JComboBox();

        //::>> Setup  Stock Minimo
        stockMinimo_ = new JTextField(7);

        //::>> Setup Quantidade
        qtd_ = new JTextField(7);
        JPanel qtd  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtd.add(new JLabel("Quantidade:         "));
        qtd.add(qtd_);


        //::>> Setup NOme
        nome_ = new JTextField(20);

        //::>> Setup Fornecedor
        fillComboBox();

        //::>Setup Buttons
        save = new JButton("Gravar  ");
        save.addActionListener(this);
        update = new JButton("Actualizar");
        update.addActionListener(this);
        this.btnPesquisar = new JButton("Pesquisar");
        this.btnPesquisar.addActionListener(this);
        this.calcular = new JButton("Calcular");
        this.vender = new JButton("Vender");
        this.vender.addActionListener(this);
        this.calcular.addActionListener(this);

        this.efectuarPesquisa = new JCheckBox("Efectura Pesquisa");
        this.efectuarPesquisa.addActionListener(this);
        setColumnSizes();

        //::>> Setup Selling elemnts
        total = new JTextField(20);
        qtd_venda = new JTextField(10);
        preco = new JTextField(10);
        total = new JTextField(10);
        total.setEnabled(false);
        taxes = new JTextField(10);

        /*Layout*/

        JPanel bd1 = new JPanel(new GridLayout(2,2, 10, 10));
        bd1.setPreferredSize(new Dimension(150, 65));
        JPanel bd2 = new JPanel(new GridLayout(2,2, 10, 10));
        JPanel bd3 = new JPanel(new GridLayout(2,2, 10, 10));
        bd3.setPreferredSize(new Dimension(200, 65));
        JPanel bd4 = new JPanel(new GridLayout(2,1, 10, 10));
        JPanel bdLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel bd5 = new JPanel(new GridLayout(2,2, 10, 10));
        JPanel bd6 = new JPanel(new GridLayout(2,2, 10, 10));
        JPanel bd7 = new JPanel(new GridLayout(2,1, 10, 10));
        JPanel bdLayout2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bdLayout2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true), "Dados Venda"));


        JPanel data_fields = new JPanel(new BorderLayout());

        JLabel lbl2 = new JLabel("ID: ");
        lbl2.setHorizontalAlignment(JLabel.RIGHT);

        bd1.add(lbl2);
        bd1.add(this.codigo_);


        JLabel lbl1 = new JLabel("Nome: ");
        lbl1.setHorizontalAlignment(JLabel.RIGHT);

        bd1.add(lbl1);
        bd1.add(this.nome_);

        bd2.add(new JLabel("Quantidade: "));
        bd2.add(this.qtd_);

        bd2.add(new JLabel("Stock Minimo: "));
        bd2.add(this.stockMinimo_);

        bd3.add(new JLabel("Fornecedor: "));
        bd3.add(this.combo);

        bd3.add(new JLabel("Armazem: "));
        bd3.add(this.armazem_);

        bd4.add(this.btnPesquisar);
        bd4.add(this.efectuarPesquisa);


        bdLayout.add(bd1);
        bdLayout.add(bd2);
        bdLayout.add(bd3);
        bdLayout.add(bd4);


        bd5.add(new JLabel("Quantidade: ", JLabel.RIGHT));
        bd5.add(qtd_venda);
        bd5.add(new JLabel("Preco: ", JLabel.RIGHT));
        bd5.add(preco);

        bd6.add(new JLabel("Iva: ", JLabel.RIGHT));
        bd6.add(taxes);
        bd6.add(new JLabel("Total: ", JLabel.RIGHT));
        bd6.add(total);

        bd7.add(calcular);
        bd7.add(new JLabel(""));
        bd7.add(this.vender);

        bd6.setPreferredSize(new Dimension(150, 63));

        bdLayout2.add(bd5);
        bdLayout2.add(bd6);
        bdLayout2.add(bd7);

        /*Initila Disabling*/
        this.nome_.setEnabled(false);
        this.qtd_.setEnabled(false);
        this.stockMinimo_.setEnabled(false);
        this.combo.setEnabled(false);
        this.armazem_.setEnabled(false);
        this.vender.setEnabled(false);

        data_fields.add("North", bdLayout);
        data_fields.add("South", bdLayout2);

        this.add("North", data_fields);
        this.add("South", tablePanel);

        this.pack();
        this.setVisible(true);

    }


    public void vender(){
        Storage storage = UserUtility.active_user.findStorage(armazem_.getSelectedItem().toString());
        Product product = storage.getProduto(this.codigo_.getText());
        product.setQuantidade(product.getQuantidade() - Integer.parseInt(this.qtd_venda.getText()));
        update();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == this.efectuarPesquisa){

            if(efectuarPesquisa.isSelected()) {
                this.nome_.setEnabled(true);
                this.qtd_.setEnabled(true);
                this.stockMinimo_.setEnabled(true);
                this.combo.setEnabled(true);
                this.armazem_.setEnabled(true);
            }
            else{
                this.nome_.setEnabled(false);
                this.qtd_.setEnabled(false);
                this.stockMinimo_.setEnabled(false);
                this.combo.setEnabled(false);
                this.armazem_.setEnabled(false);
            }
        }

        else if(e.getSource() == this.calcular){

            validate_and_calculate();
        }

        else if(e.getSource() == this.vender){
            vender();
        }

    }

    public void update(){

        Vector vector = model.getDataVector();
        vector.clear();

        Vector<Storage> storages = UserUtility.active_user.getStorage();
        for(Storage storage: storages){

            String[][] data = storage.getAllProducts();

            for(String[] dt: data){
                this.data.add(dt);
                model.addRow(new String[]{"" + dt[0], "" + dt[1], "" + dt[4], ""+ dt[5]});
            }

        }
    }

    public void validate_and_calculate(){
        boolean proceed = true;
        if(this.qtd_.getText().trim().equals("") || this.preco.getText().trim().equals("") || this.taxes.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Preecha os campos antes de calcular");
            proceed = false;
        }

        if(proceed){

            try{

                int qtd = Integer.parseInt(this.qtd_venda.getText());
                double preco = Double.parseDouble(this.preco.getText());
                double iva = Double.parseDouble(this.taxes.getText());

                if(     qtd <= 0
                        || preco <= 0
                        || iva < 0
                        )
                {
                    JOptionPane.showMessageDialog(null, "Preencha os campos com dados validos");
                }

                else {

                    if(qtd > Double.parseDouble(this.qtd_.getText())){
                        JOptionPane.showMessageDialog(null, "Quantidade Superior a Existente");
                    }
                    else {
                        double total_0 = qtd * preco;
                        double total_1 = total_0 + total_0 * Double.parseDouble(this.taxes.getText());
                        this.total.setText(String.valueOf(total_1));
                        this.vender.setEnabled(true);
                    }
                }

            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, "Preencha os campos com dados validos");
            }
        }
    }

    public void fillComboBox(){
        String[][] fornecedores = UserUtility.active_user.getAllProviders();
        combo.addItem("Escolha o Fornecedor");
        for(String[] data: fornecedores){
            String nome = data[1];
            combo.addItem(nome);
        }

        String[][] armazens = UserUtility.active_user.getAllStorages();
        armazem_.addItem("Escolha o Armazem");
        for(String[] armazem: armazens){
            armazem_.addItem(armazem[1]);
        }

    }

    public void populate_table(){
        Vector<Storage> storages = UserUtility.active_user.getStorage();
        for(Storage storage: storages){

            String[][] data = storage.getAllProducts();

            for(String[] dt: data){
                this.data.add(dt);
                model.addRow(new String[]{"" + dt[0], "" + dt[1], "" + dt[4], ""+ dt[5]});
            }

        }
    }

    public void gerar_recibo(){

        /*String str = "\t\t\t<<<<::: FACTURA :::>>>>\n" +
                "\t\t\t\n" +
                "\t\t\tA negociar Como (Mocambique) LTD\n" +
                "\t\t\t\tMATOLA\n" +
                "\n" +
                "***********************************************************\n" +
                "\n" +
                "::>Usuario\n" + UserUtility.active_user.get
                "Nome:\n" +
                "Username: \n" +
                "***********************************************************\n" +
                "\n" +
                "::>Venda\n" +
                "Data: \n" +
                "Hora:\n" +
                "\n" +
                "\n" +
                "***************************************\n" +
                "Produto\t\tQtd\t\tPreco\n" +
                "\n" +
                "\n" +
                "\n" +
                "************************************\n" +
                "Obrigado Por comprar no ifk!\n" +
                "Nao deixe de ver as nossas ofertas no \n" +
                "Facebook ou em ifk.com";
*/


    }

    public void setColumnSizes(){
        DefaultTableColumnModel columnModel = (DefaultTableColumnModel) this.table.getColumnModel();
        for(int i = 0; i < 4; i++){
            columnModel.getColumn(i).setMinWidth(100);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = table.getSelectedRow();
        Vector<String> selected_data = model.getDataVector().get(row);

        this.codigo_.setText(selected_data.get(0));
        this.nome_.setText(selected_data.get(1));
        this.qtd_.setText(selected_data.get(2));
        this.stockMinimo_.setText(selected_data.get(3));
        this.combo.setSelectedItem(this.data.get(row)[2]);
        this.armazem_.setSelectedItem(this.data.get(row)[3]);


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
