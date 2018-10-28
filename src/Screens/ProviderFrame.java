package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Main.Authentication;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Provider;

/**
 * Created by MSI on 16-Oct-18.
 *
 */
public class ProviderFrame extends JInternalFrame implements ActionListener, MouseListener {

	JTable table;

	JTextField getTxtNome, getTxtNr;

	JButton btnPesquisar, btnActualizar, btnGravar, btnNovo;

	JTextField nuit_, nome_, codigo_;

	JCheckBox por_codigo;

	JButton update_;
	JButton save;
	String[] columnNames;

	static DefaultTableModel model;

	// ::>> Vamos decidir se livramo-nos disto
	public void trash_code() {

		/*
		 * setTitle("Fornecedores"); setSize(800, 500); setLayout(new BorderLayout());
		 *
		 * // Data to be displayed in the JTable String[][] data = null;
		 *
		 * // Column Names columnNames = new String[] { "Codigo", "Nome", "Nuit" };
		 *
		 * // Layout //
		 *
		 * JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER)); JLabel label =
		 * new JLabel("Tela de Registo de Fornecedores"); label.setFont(new
		 * Font("Century Gothic", Font.BOLD, 14)); north.add(label);
		 *
		 * model = new DefaultTableModel(data, columnNames) {
		 *
		 * @Override public boolean isCellEditable(int row, int column) { // TODO
		 * Auto-generated method stub return false; } };
		 *
		 * table = new JTable(model); JPanel table_layout = new JPanel(new
		 * BorderLayout()); JScrollPane scroll = new JScrollPane(table);
		 *
		 * table_layout.add("North", table.getTableHeader()); table_layout.add("Center",
		 * scroll);
		 *
		 * JPanel pnCenter = new JPanel(new GridLayout(2, 1));
		 *
		 * JPanel pnUpSide = new JPanel(new GridLayout(1, 2));
		 *
		 * JPanel pn = new JPanel(new BorderLayout());
		 */

		///// /////

		JPanel pcenter = new JPanel();
		pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

		// Left Side
		/*
		 * JPanel pLeft = new JPanel(); pLeft.setLayout(new GridLayout(6, 1));
		 */

		// ::>> Last Code
		/*
		 * pLeft.add(new JLabel("Codigo: ")); pLeft.add(new JLabel("")); pLeft.add(new
		 * JLabel("Nome: ")); pLeft.add(new JLabel("")); pLeft.add(new
		 * JLabel("Nuit: ")); pLeft.add(new JLabel(""));
		 */
		// Right Side
		JPanel pRight = new JPanel();
		pRight.setLayout(new FlowLayout(FlowLayout.LEFT));

		/*
		 * nuit_ = new JTextField(12);
		 *
		 * // username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
		 * Color.GRAY));
		 *
		 * // password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
		 * Color.GRAY));
		 *
		 * nome_ = new JTextField(12); //
		 * nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		 *
		 * codigo_ = new JTextField(5); codigo_.setText(ID_Gen.nextId());
		 * codigo_.setEnabled(false);
		 *
		 * JPanel aux = new JPanel(new FlowLayout()); pRight.add(new
		 * JLabel("Codgio: ")); pRight.add(codigo_); pRight.add(new JLabel("Nome: "));
		 * pRight.add(nome_); pRight.add(new JLabel("Nuit: ")); pRight.add(nuit_);
		 *
		 *
		 * JPanel pbtn = new JPanel(); pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 *
		 * // Button Save #Gravar save = new JButton("Gravar"); save.setBorder(null);
		 * save.setBackground(Color.LIGHT_GRAY);
		 * save.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20,
		 * Color.LIGHT_GRAY)); save.addActionListener(this);
		 *
		 * // Button Cancel update_ = new JButton("Actualizar");
		 * update_.setBackground(Color.GRAY);
		 * update_.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
		 * update_.addActionListener(this);
		 *
		 *
		 *//*
			 * pbtn.add(save); pbtn.add(update_);
			 *//*
				 *
				 * // pcenter.add(pLeft); pcenter.add(pRight);
				 *
				 * ///// /////
				 *
				 * pn.add("Center", pcenter); pn.add("North", pRight);
				 *
				 * pnUpSide.add(pn);
				 *
				 * pnUpSide.add(new JLabel(""));
				 *
				 * JPanel pnBottonSide = new JPanel(new BorderLayout());
				 *
				 * JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 25));
				 *
				 * getTxtNome = new JTextField(15); getTxtNr = new JTextField(15); btnPesquisar
				 * = new JButton("Procurar"); btnPesquisar.addActionListener(this);
				 *
				 * banner.add(new JLabel("Codigo: ")); banner.add(getTxtNr); banner.add(new
				 * JLabel("Nome:")); banner.add(getTxtNome); banner.add(btnPesquisar);
				 *
				 * pnBottonSide.add("North", banner); pnBottonSide.add("Center", table_layout);
				 *
				 * pnCenter.add(pnUpSide); pnCenter.add(pnBottonSide);
				 *
				 * add("North", north); add("Center", pnCenter); read();
				 */

	}

	public ProviderFrame() {

		build_ui();

	}

	public void build_ui() {


		setTitle("Fornecedores");
		setSize(800, 300);
		setLayout(new BorderLayout());

		// Data to be displayed in the JTable
		String[][] data = null;

		// Column Names
		columnNames = new String[] { "Codigo", "Nome", "Nuit" };

		// Layout //

		JLabel label = new JLabel("Tela de Registo de Fornecedores");
		label.setFont(new Font("Century Gothic", Font.BOLD, 14));

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

		/* Inicializacao de variaveis */
		nuit_ = new JTextField(12);
		nome_ = new JTextField(12);
		codigo_ = new JTextField(5);
		codigo_.setText(ID_Gen.nextProviderId());
		codigo_.setEnabled(false);

		// Button Save #Gravar
		save = new JButton("Gravar");
		save.addActionListener(this);

		// Button Cancel
		update_ = new JButton("Actualizar");
		update_.addActionListener(this);

		// Button de Teste
		btnNovo = new JButton("Teste");
		btnNovo.addActionListener(this);

		// Check Box
		por_codigo = new JCheckBox("Por Codigo");
		por_codigo.addActionListener(this);

		getTxtNome = new JTextField(15);
		getTxtNr = new JTextField(15);
		getTxtNr.setEnabled(false);
		btnPesquisar = new JButton("Procurar");
		btnPesquisar.addActionListener(this);



		/* Construcao de Layout */

		//::>> Cabecalho
		JPanel topo = new JPanel(new BorderLayout());
		JPanel banner = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel dados_entrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		JPanel pesquisa_container = new JPanel(new BorderLayout());
		JPanel pesquisa_elements = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,20));

		dados_entrada.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true), "Dados:"));

		banner.add(label);

		dados_entrada.add(new JLabel("Codigo: "));
		dados_entrada.add(codigo_);
		dados_entrada.add(new JLabel("Nome: "));
		dados_entrada.add(nome_);
		dados_entrada.add(new JLabel("Nuit: "));
		dados_entrada.add(nuit_);
		dados_entrada.add(save);
		dados_entrada.add(update_);

		topo.add("North", banner);
		topo.add("South", dados_entrada);

		pesquisa_elements.add(new JLabel("Codigo: "));
		pesquisa_elements.add(getTxtNr);
		pesquisa_elements.add(new JLabel("Nome: "));
		pesquisa_elements.add(getTxtNome);
		pesquisa_elements.add(por_codigo);
		pesquisa_elements.add(btnPesquisar);

		pesquisa_container.add(pesquisa_elements);

		pesquisa_container.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true), "Pesquisa:"));

		// ::>> Centro
		this.add("North", topo);
		this.add("Center", pesquisa_container);
		this.add("South", table_layout);
		this.pack();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		read();


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPesquisar) {

			Vector vasd = new Vector<>();
			boolean continue_ = validade_search_inputs();

			// ::>> Pesquisa
			if ((!model.getDataVector().isEmpty() && !getTxtNome.getText().equals("") && continue_)
					|| (!model.getDataVector().isEmpty() && !getTxtNr.getText().equals(""))) {

				if ((getTxtNome.getText() != null) && (!getTxtNome.getText().equals(""))) {
					update();

					for (Object object : model.getDataVector()) {
						Vector vector = (Vector) object;
						if (vector.get(1).equals(getTxtNome.getText())) {
							vasd.add(vector);
						}
					}

					int a = model.getDataVector().size();
					for (int i = 0; i <= a; i++) {
						try {
							model.removeRow(i);
							i--;
						} catch (Exception d) {

						}
					}

					for (Object vd : vasd) {
						Vector vector = (Vector) vd;
						model.addRow(new String[] { "" + vector.get(0), "" + vector.get(1), "" + vector.get(2) });
					}
				} else if ((getTxtNr.getText() != null) || (!getTxtNr.getText().equals(""))) {
					update();
					for (Object object : model.getDataVector()) {
						Vector vector = (Vector) object;
						if (vector.get(0).equals(getTxtNr.getText())) {
							vasd.add(vector);
						}
					}

					int a = model.getDataVector().size();
					for (int i = 0; i <= a; i++) {
						try {
							model.removeRow(i);
							i--;
						} catch (Exception d) {

						}
					}

					for (Object vd : vasd) {
						Vector vector = (Vector) vd;
						model.addRow(new String[] { "" + vector.get(0), "" + vector.get(1), "" + vector.get(2) });
					}
					getTxtNome.setText("");
					getTxtNr.setText("");

				}
				getTxtNome.setText("");
				getTxtNr.setText("");
			}
		} else if (e.getSource().equals(save)) {

			boolean continue_ = validate_inputs();
			if (continue_) {

				String[] a = { "" + codigo_.getText(), "" + nome_.getText(), "" + nuit_.getText() };
				model.addRow(a);
				Provider fornecedor = new Provider(nome_.getText(), nuit_.getText());
				UserUtility.active_user.adicionar_fornecedor(fornecedor);
				codigo_.setText(ID_Gen.nextProviderId());
				write();
			}

		} else if (e.getSource().equals(update_)) {
			update();
		} else if (e.getSource().equals(btnNovo)) {
			dataSwitch();
			write();
		} else if (e.getSource().equals(btnActualizar)) {
			update();
		} else if (e.getSource().equals(this.por_codigo)) {

			if (this.por_codigo.isSelected()) {
				this.getTxtNr.setEnabled(true);
				this.getTxtNome.setEnabled(false);
			} else {
				this.getTxtNr.setEnabled(false);
				this.getTxtNome.setEnabled(true);
			}
		}
	}

	public void write() {
		Authentication.write();
	}

	public boolean validate_inputs() {
		if (this.nome_.getText().trim().equals("") || this.nuit_.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor preencher os campos com dados validos");
			return false;
		}

		try {

			long nuit = Integer.parseInt(this.nuit_.getText());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Preencher o campo de Nuit com dados validos: Numeros");
			return false;
		}
		return true;
	}

	public boolean validade_search_inputs() {

		if (this.getTxtNr.getText().trim().equals("") && this.getTxtNome.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor preencher os campos com dados validos!");
			return  false;
		}
		return true;
	}

	private void read() {
		FileInputStream file_input = null;
		ObjectInputStream o_input = null;
		model.setDataVector(null, columnNames);

		if (UserUtility.active_user.getAllProviders() != null) {
			String[][] fornecedores = UserUtility.active_user.getAllProviders();
			for (String[] data : fornecedores) {
				model.addRow(data);
			}
		}
	}

	public static Vector reader() {
		FileInputStream file_input = null;
		ObjectInputStream o_input = null;
		try {
			file_input = new FileInputStream("Providers.dat");
			o_input = new ObjectInputStream(file_input);
			return (Vector) o_input.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				o_input.close();
				file_input.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			Vector v = new Vector();
			return v;
		}
	}

	public void dataSwitch() {
		model.setValueAt(nome_.getText(), table.getSelectedRow(), 1);
		model.setValueAt(nuit_.getText(), table.getSelectedRow(), 2);
	}

	public void update() {
		Vector vector = model.getDataVector();

		String[][] allProviders = UserUtility.active_user.getAllProviders();
		vector.clear();

		for (String[] str : allProviders) {
			Vector<String> temp = new Vector();
			temp.add(str[0]);
			temp.add(str[1]);
			temp.add(str[2]);
			model.addRow(new String[] { "" + temp.get(0), "" + temp.get(1), "" + temp.get(2) });
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(table)) {
			Vector vector = model.getDataVector().elementAt(table.getSelectedRow());
			nome_.setText("" + vector.get(1));
			nuit_.setText("" + vector.get(2));
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
