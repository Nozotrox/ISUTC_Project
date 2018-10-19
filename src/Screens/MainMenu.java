package Screens;

import java.awt.*;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import java.lang.Object;
import java.time.Clock;

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
	private JDesktopPane desktopPane;
	private JMenu isistema, isair, ihelp;
	private JMenuItem isairLogout, isairExit, isistemaVenda, isistemaCompra;
	private JInternalFrame saleFrame, providerFrame;

	private JButton btnArmazem, btnProdutos, btnFornecedores;
	private JMenuBar menuBar;
	private JInternalFrame storageFrame, productFrame, buyFrame, armazemFrame;
	private ImageIcon icon;
    private Clock clock;

	public MainMenu(String user) {
		build_ui(user);
	}
	private void buildStorage() {
		storageFrame = new StorageFrame();
		storageFrame.setResizable(true);
		storageFrame.setMaximizable(true);
		storageFrame.setIconifiable(true);
		storageFrame.setClosable(true);
		storageFrame.setLocation(220, 220);

		desktopPane.add(storageFrame);

		storageFrame.setVisible(true);
		storageFrame.toFront();
		storageFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void buildProduct() {
		productFrame = new ProductFrame();
		productFrame.setResizable(true);
		productFrame.setMaximizable(true);
		productFrame.setIconifiable(true);
		productFrame.setClosable(true);
		productFrame.setLocation(220, 220);

		desktopPane.add(productFrame);

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

		isistema = new JMenu("Sistema");
		isistemaVenda = new JMenuItem("Venda");
		isistemaCompra = new JMenuItem("Compra");
		isistema.add(isistemaVenda);
		isistema.add(isistemaCompra);

		isair = new JMenu("Sair");
		isairLogout = new JMenuItem("Log Out");
		isairExit = new JMenuItem("Fechar");
		isairExit.addActionListener(this);
		isair.add(isairLogout);
		isair.add(isairExit);

		ihelp = new JMenu("HELP");
		ihelp.addActionListener(this);

		menuBar.add(isistema);
		menuBar.add(ihelp);
		menuBar.add(isair);

		menuBar.setBackground(Color.white);

		JPanel panel = new JPanel(new GridLayout(8, 1));

		JPanel panel2 = new JPanel(new BorderLayout());

		panel.setBackground(Color.WHITE);

		// icon = new
		// ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sl.png");
		btnArmazem = new JButton("Armazem");
		btnArmazem.setBackground(Color.WHITE);
		btnArmazem.addActionListener(this);
		btnArmazem.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.white));

		// icon = new
		// ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/buy.png");
		btnProdutos = new JButton("Produtos");
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.addActionListener(this);
		btnProdutos.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.white));
		// icon = new
		// ImageIcon("D:/Kelvin/Documents/Java/ISUTC_Project/src/img/sale.png");
		btnFornecedores = new JButton(" Fornecedores");
		btnFornecedores.setBackground(Color.WHITE);
		btnFornecedores.addActionListener(this);
		btnFornecedores.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.white));

		panel.add(btnArmazem);
		panel.add(btnProdutos);
		panel.add(btnFornecedores);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        JLabel hour;
        hour.setFont(new Font("Century Gothic", Font.BOLD, 15));
        hour.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));

        if (eventDate.isBefore(LocalDate.now(clock)){
            hour = new JLabel(sdf.format(cal.getTime()));
        }

		panel.add(hour);



		panel.add(new JLabel(""));

		armazemFrame = new JInternalFrame("Armazem", true, true, true, true);

		buyFrame = new JInternalFrame("Menu de Compra", true, true, true, true);

		productFrame = new JInternalFrame("Menu de Procura", true, true, true, true);

		providerFrame = new JInternalFrame("Menu de Fornecedores", true, true, true, true);

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
				grphcs.drawImage(new ImageIcon("ISUTC_Project\\img\\bg.jpg").getImage(), 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				// BACKGROUND 2 VEZES
				return new Dimension(new ImageIcon("ISUTC_Project\\img\\bg.jpg").getIconWidth(), new ImageIcon("ISUTC_Project\\img\\bg.jpg").getIconHeight());
			}
		};

		desktopPane.setVisible(true);

		desktopPane.setBackground(Color.LIGHT_GRAY);

		desktopPane.add(armazemFrame);
		// desktopPane.add(searchFrame);
		// desktopPane.add(buyFrame);

		icon = new ImageIcon("img/bg.jpg");
		desktopPane.add(new JLabel(icon));

		desktopPane.setVisible(true);

		//panel2.add("North", new JLabel("        "));
		panel2.add("Center", desktopPane);

		add("North", new JLabel(""));
		add("Center", panel2);
		add(BorderLayout.WEST, panel);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);

		ImageIcon icon = new ImageIcon("ISUTC_Project\\img\\icon.jpg");
		setIconImage(icon.getImage());
		setJMenuBar(menuBar);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(user);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(btnProdutos)) {
			buildProduct();
		} else if (arg0.getSource().equals(btnFornecedores)) {
			buildProvider();
		} else if (arg0.getSource().equals(isairExit)) {
			JOptionPane.showMessageDialog(null, "SAINDO", "SAIR", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		if (arg0.getSource().equals(btnArmazem)) {
			buildStorage();
		}
	}

	public static void main(String[] args) {
		new MainMenu("ifk");
	}

}
