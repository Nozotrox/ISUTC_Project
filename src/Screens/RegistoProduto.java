package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistoProduto extends JFrame implements ActionListener {


    JLabel
    codigo,
    armazem,
    stock_minimo,
    quantidade,
    nome,
    fornecedor;

    JButton
    actualizar,
    gravar;

    JComboBox fornecedor_;


    JTextField
    codigo_,
    armazem_,
    stock_minimo_,
    quantidade_,
    nome_;

    public void initialize_variables(){

        nome = new JLabel("Nome: ");
        armazem = new JLabel("                    Armazem: ");
        stock_minimo = new JLabel("Stock Minimo: ");
        quantidade = new JLabel("                 Quantidade: ");
        fornecedor = new JLabel("Fornecedor: " );
        codigo = new JLabel("             Codigo: ");

        nome_ = new JTextField(20);
        armazem_ = new JTextField(5);
        stock_minimo_ = new JTextField(5);
        quantidade_ = new JTextField(5);
        codigo_ = new JTextField(5);


        fornecedor_ = new JComboBox(new String[] {"---Selecione Fornecedero---", "Hello", "Wordl"});

        actualizar = new JButton("Actualizar");
        gravar = new JButton("Gravar");

    }


    public void build_ui(){
        initialize_variables();
        this.setSize(400, 200);
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(6 ,1));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        //:::>> Table
        String[][] data = null;
        String[] columnNames = {"Codigo", "Aramazem", "Stock Minimo", "Quantidade", "Nome", "Fornecedor"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        JTable table = new JTable(model);
        JPanel table_layout = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(table);

        table_layout.add("North", table.getTableHeader());
        table_layout.add("Center", scroll);



        panel.add(codigo);
        panel.add(codigo_);

        panel.add(armazem);
        panel.add(armazem_);

        panel2.add(stock_minimo);
        panel2.add(stock_minimo_);

        panel2.add(quantidade);
        panel2.add(quantidade_);

        panel3.add(nome);
        panel3.add(nome_);

        panel4.add(fornecedor);
        panel4.add(fornecedor_);

        panel5.add(actualizar);
        panel5.add(gravar);

        panel6.add(table_layout);




        this.add(panel);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);

//        this.pack();
        this.setVisible(true);

    }

    public RegistoProduto() {
        build_ui();
    }

    public static void main(String[] args){
        new RegistoProduto();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
