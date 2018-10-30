package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Authentication;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Storage;

/**
 * Created by MSI on 20-Oct-18.
 */
public class StorageFrame extends JInternalFrame implements ActionListener, MouseListener {

	JTable table;

	JTextField getTxtNome, getTxtNr;

	JButton btnPesquisar, btnActualizar, btnGravar, btnNovo;

	DefaultTableModel model;

	JTextField codigo_;
	JTextField tipo;
	JTextField nome_;

	JCheckBox por_codigo;

	JButton update_;
	JButton save_;
	private ImageIcon icon;

	public void build_ui() {

		setTitle("Armazem");
		setSize(800, 500);
		setLocation(220, 220);
		setLayout(new BorderLayout());

		// Data to be displayed in the JTable
		String[][] data = null;

		// Column Names
		String[] columnNames = null;
		// Column Names
		columnNames = new String[] { "Codigo", "Nome", "Quantidade de produtos" };

		// Layout //

		JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel("Tela de Registo de Armazem");
		label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		north.add(label);

		model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		populate_table();

		// Layout //
		table = new JTable(model);
		table.addMouseListener(this);
		JPanel table_layout = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane(table);

		table_layout.add("North", table.getTableHeader());
		table_layout.add("Center", scroll);

		/* Inicializacao de variaveis */
		codigo_ = new JTextField(12);
		codigo_.setEnabled(false);
		codigo_.setText(ID_Gen.nextStorageId());

		por_codigo = new JCheckBox("Por Codigo");
		por_codigo.addActionListener(this);

		tipo = new JTextField(12);
		nome_ = new JTextField(12);

		// Button OK
		save_ = new JButton("Guardar");
		save_.addActionListener(this);

		// Button Cancel
		update_ = new JButton("Actualizar");
		update_.addActionListener(this);

		// Button Edit
		btnNovo = new JButton("EDIT");
		btnNovo.addActionListener(this);

		getTxtNome = new JTextField(15);
		getTxtNr = new JTextField(15);
		getTxtNr.setEnabled(false);
		btnPesquisar = new JButton("Procurar");
		btnPesquisar.addActionListener(this);

		/* Layout */

		JPanel headerLayout = new JPanel(new BorderLayout());
		JPanel banner = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel data_input = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		JPanel southBorder = new JPanel(new BorderLayout());
		JPanel searchPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		banner.add(label);

		data_input.add(new JLabel("Codig: "));
		data_input.add(codigo_);
		data_input.add(new JLabel("Tipo: "));
		data_input.add(tipo);
		data_input.add(save_);
		data_input.add(update_);
		data_input.add(btnNovo);

		searchPane.add(new JLabel("Codigo: "));
		searchPane.add(this.getTxtNr);
		searchPane.add(new JLabel("Nome: "));
		searchPane.add(this.getTxtNome);
		searchPane.add(this.por_codigo);
		searchPane.add(btnPesquisar);

		southBorder.add("North", data_input);
		southBorder.add("South", searchPane);

		data_input.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), "Dados: "));
		searchPane.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), "Pesquisa: "));

		headerLayout.add("North", banner);
		headerLayout.add("South", southBorder);

		this.add("North", headerLayout);
		this.add("South", table_layout);
		this.pack();

		setVisible(true);

	}

	public void trashCode() {
		/*
		 * setTitle("Armazem"); setSize(800,500); setLocation(220,220); setLayout(new
		 * BorderLayout());
		 * 
		 * // Data to be displayed in the JTable String[][] data = null;
		 * 
		 * // Column Names String[] columnNames = null; // Column Names columnNames =
		 * new String[] { "Codigo", "Nome", "Nuit" };
		 * 
		 * // Layout //
		 * 
		 * JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER)); JLabel label =
		 * new JLabel("Tela de Registo de Armazem"); label.setFont(new
		 * Font("Century Gothic", Font.BOLD, 14)); north.add(label);
		 * 
		 * model = new DefaultTableModel(data, columnNames) {
		 * 
		 * @Override public boolean isCellEditable(int row, int column) { // TODO
		 * Auto-generated method stub return false; } };
		 * 
		 * populate_table();
		 * 
		 * 
		 * // Layout //
		 * 
		 */
		/*
		 * JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER)); north.add(new
		 * JLabel("Tela de Registo de Armazem"));
		 *//*
			 * 
			 * 
			 * table = new JTable(model); JPanel table_layout = new JPanel(new
			 * BorderLayout()); JScrollPane scroll = new JScrollPane(table);
			 * 
			 * table_layout.add("North", table.getTableHeader()); table_layout.add("Center",
			 * scroll);
			 * 
			 * JPanel pnCenter = new JPanel(new GridLayout(2,1));
			 * 
			 * JPanel pnUpSide = new JPanel(new GridLayout(1,2));
			 * 
			 * JPanel pn = new JPanel(new BorderLayout());
			 * 
			 * ///// /////
			 * 
			 * JPanel pcenter = new JPanel(); pcenter.setLayout(new
			 * FlowLayout(FlowLayout.CENTER, 30, 70));
			 * 
			 * // Left Side JPanel pLeft = new JPanel(); pLeft.setLayout(new
			 * GridLayout(5,1));
			 * 
			 * pLeft.add(new JLabel("Codigo: ")); pLeft.add(new JLabel("")); pLeft.add(new
			 * JLabel("Tipo: ")); pLeft.add(new JLabel("")); pLeft.add(new
			 * JLabel("Password: "));
			 * 
			 * // Right Side JPanel pRight = new JPanel(); pRight.setLayout(new
			 * GridLayout(5, 1)); codigo_ = new JTextField(12); codigo_.setEnabled(false);
			 * codigo_.setText(ID_Gen.nextStorageId());
			 * 
			 * 
			 * //codigo_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
			 * tipo = new JTextField(12);
			 * //tipo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
			 * nome_ = new JTextField(12);
			 * //nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
			 * 
			 * 
			 * pRight.add(codigo_); pRight.add(new JLabel("")); pRight.add(nome_);
			 * pRight.add(new JLabel("")); pRight.add(tipo);
			 * 
			 * JPanel pbtn = new JPanel(); pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			 * 
			 * //Button OK save_= new JButton("OK"); save_.setBorder(null);
			 * save_.setBackground(Color.LIGHT_GRAY);
			 * save_.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20,
			 * Color.LIGHT_GRAY)); save_.addActionListener(this);
			 * save_.addActionListener(this);
			 * 
			 * //Button Cancel update_ = new JButton("Actualizar");
			 * update_.setBackground(Color.GRAY);
			 * update_.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
			 * update_.addActionListener(this);
			 * 
			 * pbtn.add(save_); pbtn.add(update_);
			 * 
			 * pcenter.add(pLeft); pcenter.add(pRight);
			 * 
			 * ///// /////
			 * 
			 * pn.add("Center", pcenter); pn.add("South", pbtn);
			 * 
			 * pnUpSide.add(pn);
			 * 
			 * pnUpSide.add(new JLabel(""));
			 * 
			 * 
			 * JPanel pnBottonSide = new JPanel(new BorderLayout());
			 * 
			 * JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 25));
			 * 
			 * getTxtNome = new JTextField(15); getTxtNr = new JTextField(15); btnPesquisar
			 * = new JButton("Procurar");
			 * 
			 * banner.add(new JLabel("Nr:")); banner.add(getTxtNome); banner.add(new
			 * JLabel("Nome:")); banner.add(getTxtNr); banner.add(btnPesquisar);
			 * 
			 * pnBottonSide.add("North", banner); pnBottonSide.add("Center", table_layout);
			 * 
			 * pnCenter.add(pnUpSide); pnCenter.add(pnBottonSide);
			 * 
			 * add("North",north ); add("Center", pnCenter);
			 * 
			 * setVisible(true);
			 */

	}

	public StorageFrame() {
		build_ui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == save_) {

			if (validation()) {
				String nome = tipo.getText();
				Storage store = new Storage(nome);
				UserUtility.active_user.adicionar_armazem(store);
				addToTable(store);
				codigo_.setText(ID_Gen.nextStorageId());
				clearAll();
				Authentication.write();
			}
		}

		else if (e.getSource() == update_) {
			update();
		}

		else if (e.getSource() == this.por_codigo) {
			if (this.por_codigo.isSelected()) {
				this.getTxtNome.setEnabled(false);
				this.getTxtNr.setEnabled(true);
			} else {
				this.getTxtNr.setEnabled(false);
				this.getTxtNome.setEnabled(true);
			}
		} else if (e.getSource() == this.btnPesquisar) {
			perform_search();
		} else if (e.getSource() == this.btnNovo) {
			dataSwitch();
		}
	}

	public void dataSwitch() {
		boolean switch_data = true;
		if (this.tipo.getText().equals("") || this.tipo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preecher os campos com dados validos.");
			switch_data = false;
		}
		for (Vector vector : model.getDataVector()) {
			if (vector.get(1).equals(this.tipo.getText())) {
				JOptionPane.showMessageDialog(null, "Existe um Armazem com esse Nome");
				switch_data = false;
			}
		}

		if(switch_data) {
			model.setValueAt(tipo.getText(), table.getSelectedRow(), 1);
			Storage armazem = UserUtility.active_user.findStorage_c(codigo_.getText());
			armazem.setTipo(tipo.getText());
			Authentication.write();
		}

	}

	public void update() {

		Vector vector = model.getDataVector();

		String[][] allStorages = UserUtility.active_user.getAllStorages();
		vector.clear();
		for (String[] str : allStorages) {
			Vector<String> temp = new Vector();
			temp.add(str[0]);
			temp.add(str[1]);
			temp.add(str[2]);
			vector.add(temp);
		}

		model.fireTableDataChanged();
	}

	public void addToTable(Storage store) {

		String[] additionable = { store.getId(), store.getTipo(), String.valueOf(store.getAllProducts().length) };
		this.model.addRow(additionable);
	}

	public void clearAll() {
		nome_.setText("");
		getTxtNome.setText("");
		getTxtNr.setText("");
	}

	public boolean validation() {
		String nome = tipo.getText().trim();

		if (nome.equals("") || nome.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Por favor preecher os campos com dados validos.");
			return false;
		}
		for (Vector vector : model.getDataVector()) {
			if (vector.get(1).equals(nome)) {
				JOptionPane.showMessageDialog(null, "Existe um Armazem com esse Nome");
				return false;
			}
		}

		return true;

	}

	public void populate_table() {

		String[][] allStorage = UserUtility.active_user.getAllStorages();

		for (String[] data : allStorage) {

			this.model.addRow(data);
		}
	}

	public void perform_search() {
		Vector vasd = new Vector<>();
		// ::>> Pesquisa
		if (!getTxtNome.getText().equals("") || !getTxtNr.getText().equals("")) {

			if (!getTxtNome.getText().equals("")) {

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
			} else if (!getTxtNr.getText().equals("")) {

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
		} else {
			JOptionPane.showMessageDialog(null, "Por favor verificar os valores introduzidos nos campos de Pesquisa!");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(table)) {
			Vector vector = model.getDataVector().elementAt(table.getSelectedRow());
			codigo_.setText("" +vector.get(0));
			tipo.setText("" + vector.get(1));
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
