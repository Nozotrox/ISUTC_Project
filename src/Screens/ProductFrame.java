package Screens;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Provider;

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
    private JTextField codigo_, armazem_, stockMinimo_, qtd_, nome_, fornecedor;
    private JButton save, update;

    public ProductFrame() {
        setTitle("Produtos");
        setSize(600, 400);
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


        JPanel pRight = new JPanel();
        pRight.setLayout(new GridLayout(6, 1));

            stockMinimo_ = new JTextField(12);

            armazem_ = new JTextField(12);

            qtd_ = new JTextField(12);

            nome_ = new JTextField(12);

            codigo_ = new JTextField(12);
            codigo_.setEnabled(false);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(new JLabel("Codigo:"));
        p1.add(codigo_);
        pRight.add(p1);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.add(new JLabel("Armazem:"));
        p2.add(armazem_);
        pRight.add(p2);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.add(new JLabel("Stock Minimo:"));
        p3.add(stockMinimo_);
        pRight.add(p3);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4.add(new JLabel("Quantidade:"));
        p4.add(qtd_);
        pRight.add(p4);

        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5.add(new JLabel("Nome:"));
        p5.add(nome_);
        pRight.add(p5);

        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p6.add(new JLabel("Fornecedor:"));
        p6.add(combo);
        pRight.add(p6);

        JScrollPane scroll = new JScrollPane(pRight);

        JPanel upper = new JPanel(new GridLayout(1, 2, 0, 0));
        upper.add(scroll);

        upLeft = new JPanel();
        upLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        save = new JButton("Gravar");
        save.addActionListener(this);
        update = new JButton("Actualizar");
        update.addActionListener(this);
        upLeft.add(save);
        upLeft.add(update);

        upper.add(upLeft);

        add(upper);
        add(tablePanel);
    }

    public static void main(String[] args) {
        new ProductFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource().equals(save)) {
            model.addRow(new String[] { "" + codigo_.getText(), "" + armazem_.getText(), "" + stockMinimo_.getText(),
                    "" + qtd_.getText(), "" + nome_.getText(), "" + combo.getSelectedItem().toString() });
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

}
