package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author MSI
 *
 */

/**
 *
 * LEMBRETE URGENTE SENAO BUG LEMBREM-SE DE ADICIONAR UM BACKGROUND
 *
 */

public class MainMenu extends JFrame implements ActionListener {

    // MAIN MENU

    private JButton  buyButton;
    private JDesktopPane desktopPane;
    private JMenu item1, item2;
    private JMenuItem menuItem1;
    private JInternalFrame  providerFrame;

    private JButton btnArmazem, btnProdutos, btnFornecedores;
    private JMenuBar menuBar;
    private JInternalFrame  searchFrame, buyFrame, armazemFrame,productFrame;
    private ImageIcon icon;

    public MainMenu(String user) {
        build_ui(user);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource().equals(btnProdutos)) {
            buildProductSale();
        } else if (arg0.getSource().equals(buyButton)) {
            buildProductBuy();
        } else if (arg0.getSource().equals(btnFornecedores)) {
            buildProvider();
        } else if (arg0.getSource().equals(menuItem1)) {
            JOptionPane.showMessageDialog(null, "SAINDO", "SAIR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else if (arg0.getSource().equals(btnArmazem)) {
            buildProductArmazem();
        }
    }

    private void buildProductArmazem() {
        // UI_Methods.buildArmazemFrame(armazemFrame);

    }

    private void buildProductSale() {
        productFrame=new ProductFrame();
        productFrame.setResizable(true);
        productFrame.setMaximizable(true);
        productFrame.setIconifiable(true);
        productFrame.setClosable(true);
        productFrame.setLocation(0, 0);

        desktopPane.add(productFrame);
        desktopPane.getDesktopManager().activateFrame(productFrame);
        productFrame.setVisible(true);
        productFrame.toFront();

        productFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    private void buildProductBuy() {

    }

    private void buildProvider() {

        providerFrame = new ProviderFrame();
        providerFrame.setResizable(true);
        providerFrame.setMaximizable(true);
        providerFrame.setIconifiable(true);
        providerFrame.setClosable(true);
        providerFrame.setLocation(220, 220);

        desktopPane.add(providerFrame);

        providerFrame.setVisible(true);
        providerFrame.toFront();
        providerFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void build_ui(String user) {
        setLayout(new BorderLayout());
        setDefaultLookAndFeelDecorated(true);

        menuBar = new JMenuBar();

        item1 = new JMenu("Sair");
        menuItem1 = new JMenuItem("EXIT");
        menuItem1.addActionListener(this);
        item1.add(menuItem1);
        item2 = new JMenu("HELP");
        item2.addActionListener(this);
        menuBar.add(item1);
        menuBar.add(item2);

        JPanel panel = new JPanel(new GridLayout(8, 1));

        JPanel panel2 = new JPanel(new BorderLayout());

        panel.setBackground(Color.WHITE);

        icon = new ImageIcon("img/buy.png");
        buyButton = new JButton("COMPRA");

        buyButton.addActionListener(this);



        // icon = new
        // ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sl.png");
        btnArmazem = new JButton("Armazem");
        btnArmazem.setBackground(Color.WHITE);
        btnArmazem.addActionListener(this);
        btnArmazem.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));

        // icon = new
        // ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/buy.png");
        btnProdutos = new JButton("Produtos");
        btnProdutos.setBackground(Color.WHITE);
        btnProdutos.addActionListener(this);
        btnProdutos.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));

        // icon = new
        // ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sale.png");
        btnFornecedores = new JButton(" Fornecedores");
        btnFornecedores.setBackground(Color.WHITE);
        btnFornecedores.addActionListener(this);
        btnFornecedores.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));

        panel.add(btnArmazem);
        panel.add(btnProdutos);
        panel.add(btnFornecedores);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        armazemFrame = new JInternalFrame("Armazem", true, true, true, true);

        buyFrame = new JInternalFrame("Menu de Compra", true, true, true, true);

        searchFrame = new JInternalFrame("Menu de Procura", true, true, true, true);

        providerFrame = new JInternalFrame("Menu de Fornecedores", true, true, true, true);

        productFrame=new JInternalFrame("Menu de Produtos",true, true, true, true);

        /**
         *
         * LEMBRETE URGENTE SENAO BUG LEMBREM-SE DE ADICIONAR UM BACKGROUND
         *
         */
        desktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                // BACKGROUND
                grphcs.drawImage(new ImageIcon("").getImage(), 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                // BACKGROUND 2 VEZES
                return new Dimension(new ImageIcon("").getIconWidth(), new ImageIcon("").getIconHeight());
            }
        };

        desktopPane.setVisible(true);

        desktopPane.setBackground(Color.LIGHT_GRAY);

        desktopPane.add(armazemFrame);
        desktopPane.add(productFrame);
        // desktopPane.add(searchFrame);
        // desktopPane.add(buyFrame);

        icon = new ImageIcon("img/bg.jpg");
        desktopPane.add(new JLabel(icon));

        desktopPane.setVisible(true);

        panel2.add("North", new JLabel("        "));
        panel2.add("Center", desktopPane);

        add("North", new JLabel(""));
        add("Center", panel2);
        add(BorderLayout.WEST, panel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setUndecorated(true);

        setJMenuBar(menuBar);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(user);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainMenu("");
    }

}
