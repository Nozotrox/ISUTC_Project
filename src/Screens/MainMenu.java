package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author MSI
 *
 */

/**
 *
 *LEMBRETE URGENTE SENAO BUG LEMBREM-SE DE ADICIONAR UM BACKGROUND
 *
 */

public class MainMenu extends JFrame implements ActionListener {

    // MAIN MENU
    private JButton button1, button2, button3,button4;
    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu item1,item2;
    private JInternalFrame saleFrame, searchFrame, buyFrame;

    private ImageIcon icon;

    // SALE MENU
    private JTable selectItem;
    private JLabel label1;

    // SEARCH MENU
    private JTable searchItems;
    private JLabel name, id;
    private JTextField name_, id_;

    public MainMenu() {
        build_ui();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource().equals(button1)) {
            buildProductSale();
        } else if (arg0.getSource().equals(button2)) {
            buildProductBuy();
        } else if (arg0.getSource().equals(button3)) {

        }else if(arg0.getSource().equals(button4)){
            buildProductSearch();
        }
    }

    private void buildProductSale() {
        saleFrame.setLayout(new BorderLayout());
        saleFrame.add("Center", new JLabel("VENDA"));
        saleFrame.setSize(600, 400);
        saleFrame.setLocation(0,0);
        saleFrame.toFront();
        saleFrame.setVisible(true);
        saleFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void buildProductBuy() {
        buyFrame.setLayout(new BorderLayout());
        buyFrame.add("Center", new JLabel("Compra"));
        buyFrame.setSize(600, 400);
        buyFrame.setLocation(0,0);
        buyFrame.toFront();
        buyFrame.setVisible(true);
        buyFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void buildProductSearch() {
        searchFrame.setLayout(new BorderLayout());
        searchFrame.add("Center", new JLabel("PESQUISA"));
        searchFrame.setSize(600, 400);
        searchFrame.setLocation(0, 0);
        searchFrame.toFront();
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void build_ui() {
        setLayout(new BorderLayout());
        setDefaultLookAndFeelDecorated(true);


        menuBar=new JMenuBar();

        item1=new JMenu("Sair");
        item2=new JMenu("HELP");
        menuBar.add(item1);
        menuBar.add(item2);
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JPanel panel2 = new JPanel(new BorderLayout());

        panel.setBackground(Color.WHITE);


        icon = new ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sl.png");
        button1 = new JButton(icon);
        button1.setBackground(Color.WHITE);
        button1.addActionListener(this);

        icon = new ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/buy.png");
        button2 = new JButton(icon.getImage()+ " COMPRA");
        button2.setBackground(Color.WHITE);
        button2.addActionListener(this);

        //icon = new ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sale.png");
        button3 = new JButton(" FORNECEDORES");
        button3.setBackground(Color.WHITE);
        button3.addActionListener(this);

        icon = new ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/search.png");
        button4=new JButton(icon.getImage()+ "FILTRO");
        button4.setBackground(Color.WHITE);
        button4.addActionListener(this);



        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        saleFrame = new JInternalFrame("Menu de Venda", true, true, true, true);

        buyFrame = new JInternalFrame("Menu de Compra", true, true, true, true);

        searchFrame = new JInternalFrame("Menu de Procura", true, true, true, true);

        /**
         *
         *LEMBRETE URGENTE SENAO BUG LEMBREM-SE DE ADICIONAR UM BACKGROUND
         *
         */
        desktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                //BACKGROUND
                grphcs.drawImage(new ImageIcon("").getImage(), 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                //BACKGROUND 2 VEZES
                return new Dimension(new ImageIcon("").getIconWidth(),
                        new ImageIcon("").getIconHeight());
            }
        };

        desktopPane.setVisible(true);
        desktopPane.add(saleFrame);
        desktopPane.add(searchFrame);
        desktopPane.add(buyFrame);

        icon = new ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/bg.jpg");
        desktopPane.add(new JLabel(icon));

        panel2.add("North", new JLabel("        "));
        panel2.add("Center", desktopPane);

        add("North", new JLabel(""));
        add("Center", panel2);
        add(BorderLayout.WEST, panel);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);

        setJMenuBar(menuBar);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

}
