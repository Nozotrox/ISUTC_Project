package Screens;

import Main.UserUtility;
import Main_Classes.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class Report extends JFrame {



    JTable table;
    DefaultTableModel model;

    public Report(){
        try{
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        build_ui();
    }

    public void build_ui(){
        this.setTitle("Relatorio");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // Column Names
        String[][] data = null;
        // Column Names
        String[] columnNames = new String[] { "Descricao", "Dados" };

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };

        /* Layout da tabela */
        table = new JTable(model);
        JPanel table_layout = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(table);
        table_layout.add("North", table.getTableHeader());
        table_layout.add("Center", scroll);

        populateTable();

        this.add(table_layout);
        this.setVisible(true);
        this.pack();
    }


    public void populateTable(){

        String[] numero_prod = {"Numero de Produtos", String.valueOf(UserUtility.numeroProdutos())};

        String[] pmv = UserUtility.prod_maisVendidos();
        String[] prod_mais_vendidos = {"Produtos mais vendidos", "1." + pmv[0] + " 2." + pmv[1] + " 3." + pmv[2]};

        String[] numero_vendas = {"Numero de vendas", String.valueOf(UserUtility.active_user.getVendas().size())};

        String[][] amp = UserUtility.armazensMaisProd();
        String[] armazens_mais_prod = {"Armazens com mais produtos", "1. " + amp[0][0] + " 2." + amp[1][0] + " 3." + amp[2][0]};
        String[] armazens_mais_prod_q = {"Numero de Produtos",  "1. " + amp[0][1] + " 2." + amp[1][1] + " 3." + amp[2][1]};

        String[] maior_fornecedor = {"Maior Fornecedor", UserUtility.maior_forn()[0][0]};
        String[] produtosPforn = {"Numero de Produtos Fornecidos", UserUtility.maior_forn()[0][1]};

        model.addRow(numero_prod);
        model.addRow(prod_mais_vendidos);
        model.addRow(numero_vendas);
        model.addRow(armazens_mais_prod);
        model.addRow(armazens_mais_prod_q);
        model.addRow(maior_fornecedor);
        model.addRow(produtosPforn);


    }


//
//    public static void main(String[] args){
//        new Report();
//    }
}
