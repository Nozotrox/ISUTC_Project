package Screens;

import Main.Authentication;
import Main_Classes.ClockTimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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

	private static Color menuColor = new Color(5,15,25);

	public MainMenu(String user) {
		build_ui(user);
	}
	private void buildStorage() {

		if(storageFrame == null) {
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
	}

	private void buildProduct() {
		if(!productFrame.isVisible() ) {
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
	}

	private void buildProvider() {
		if(!providerFrame.isVisible()) {
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
	}

	private void build_ui(String user) {
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

		setLayout(new BorderLayout());
		setDefaultLookAndFeelDecorated(true);

		menuBar = new JMenuBar();

		isistema = new JMenu("Sistema");
		    isistema.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		isistemaVenda = new JMenuItem("Venda");
		isistemaCompra = new JMenuItem("Compra");
		isistema.add(isistemaVenda);
		isistema.add(isistemaCompra);

		isair = new JMenu("Sair");
		    isair.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		isairLogout = new JMenuItem("Log Out");
		isairExit = new JMenuItem("Fechar");
		isairExit.addActionListener(this);
		isair.add(isairLogout);


		isairLogout.addActionListener(this);
		isairExit.addActionListener(this);


		isair.add(isairExit);

		ihelp = new JMenu("HELP");
		    ihelp.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		ihelp.addActionListener(this);

		menuBar.add(isistema);
		menuBar.add(ihelp);
		menuBar.add(isair);

		menuBar.setBackground(Color.white);

		JPanel panel = new JPanel(new GridLayout(6, 1));

		JPanel panel2 = new JPanel(new BorderLayout());

		panel.setBackground(menuColor);

		icon = new ImageIcon("img\\icon\\sotage.png");
		btnArmazem = new JButton(icon);
		btnArmazem.setBackground(menuColor);
		btnArmazem.addActionListener(this);
		btnArmazem.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, menuColor));




		icon = new ImageIcon("img\\icon\\product.png");
		btnProdutos = new JButton(icon);
		btnProdutos.setBackground(menuColor);
		btnProdutos.addActionListener(this);
		btnProdutos.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, menuColor));


		icon = new ImageIcon("img\\icon\\provider.png");
		btnFornecedores = new JButton(icon);
		btnFornecedores.setBackground(menuColor);
		btnFornecedores.addActionListener(this);
		btnFornecedores.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, menuColor));

		panel.add(btnArmazem);
		panel.add(btnProdutos);
		panel.add(btnFornecedores);
		panel.add(new JLabel(""));

//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        JLabel hour;

		hour = new JLabel("00:00:00");


		ClockTimer clock = new ClockTimer(hour);
		clock.start();


		hour.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, menuColor));
		hour.setFont(new Font("Century Gothic", Font.BOLD, 25));
		hour.setForeground(Color.WHITE);

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
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				// BACKGROUND
				grphcs.drawImage(new ImageIcon("img\\bg.jpg").getImage(), 0, 0, null);
			}

			public Dimension getPreferredSize() {
				// BACKGROUND 2 VEZES
				return new Dimension(new ImageIcon("img\\bg.jpg").getIconWidth(), new ImageIcon("ISUTC_Project\\img\\bg.jpg").getIconHeight());
			}
		};

		desktopPane.setVisible(true);

		desktopPane.setBackground(Color.LIGHT_GRAY);

		desktopPane.add(armazemFrame);
		desktopPane.add(providerFrame);
		desktopPane.add(productFrame);
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

		ImageIcon icon = new ImageIcon("img\\icon.jpg");
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
        if (arg0.getSource().equals(isairLogout)) {
			this.dispose();
            new Authentication();
        }

	}

	public static void main(String[] args) {
		new MainMenu("ifk");
	}

}
