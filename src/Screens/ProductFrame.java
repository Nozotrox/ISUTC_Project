package Screens;
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

/**
 *
 */

/**
 * @author MSI
 *
 */
public class ProductFrame extends JFrame implements ActionListener {
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

        upRight = new JPanel();
        upRight.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        upRight.add(new JLabel("Codigo"));
        codigo_ = new JTextField(20);
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
        upRight.add(new JLabel("Fornecedor"));

        upRight.add(combo);
        upper.add(upRight);

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
        if(!ProviderFrame.reader().isEmpty()){
            for (Object o : ProviderFrame.reader()) {
                Vector o1 = (Vector) o;
                combo.addItem(o1.get(1).toString());
            }
        }


    }

}
