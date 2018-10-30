package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import Main.Authentication;
import Main.ID_Gen;
import Main.UserUtility;
import Main_Classes.Product;
import Main_Classes.Provider;
import Main_Classes.Storage;
import Main_Classes.User;

/**
 *
 */

/**
 * @author MSI
 *
 */
public class ProductFrame extends JInternalFrame implements ActionListener, MouseListener {
	public JTable table;
	public DefaultTableModel model;
	JComboBox<String> combo;
	JScrollPane sp;
	JPanel tablePanel;
	String[] columnsNames;
	String user;

	private JTextField codigo_, stockMinimo_, qtd_, nome_, preco_;
	private JComboBox armazem_;
	private JButton save, update, btnPesquisar, btnNovo;
	private JCheckBox efect_pesquisa, qtd_chkbx, stk_min, nome_chkbx, fornecedor_chckbx, armazem_chkbx;
	private JPanel chckBoxesPanel;
	private ButtonGroup checkBoxes;
	private boolean verify_again = true;

	ClassRelatorio cr = new ClassRelatorio();

	public ProductFrame(String u){
		user = u;
		build_ui();
	}
	public ProductFrame() {
		build_ui();
	}
	public void build_ui() {

		setLocation(0, 0);
		this.setTitle("Produtos");
		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));
		this.setLayout(new BorderLayout());

		JLabel title = new JLabel("Introducao de Produtos");
		columnsNames = new String[] { "Codigo", "Nome", "Stock Minimo", "Armazem", "Quantidade", "Fornecedores",
				"Preco" };
		model = new DefaultTableModel(null, columnsNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		table = new JTable(model);
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		table.sizeColumnsToFit(1);
		populate_table();

		sp = new JScrollPane(table);
		tablePanel.add("North", table.getTableHeader());
		tablePanel.add("Center", sp);

		combo = new JComboBox<>();

		// ::>> Setup Codigo
		codigo_ = new JTextField(7);
		codigo_.setEnabled(false);
		codigo_.setText(ID_Gen.nextId());

		// ::>> Setup Armazem
		armazem_ = new JComboBox();

		// ::>> Setup Stock Minimo
		stockMinimo_ = new JTextField(7);

		// ::>> Setup Quantidade
		qtd_ = new JTextField(7);
		JPanel qtd = new JPanel(new FlowLayout(FlowLayout.LEFT));
		qtd.add(new JLabel("Quantidade:         "));
		qtd.add(qtd_);

		// ::>> Setup NOme
		nome_ = new JTextField(20);

		// ::>> Setup Preco
		preco_ = new JTextField(20);

		// ::>> Setup Fornecedor
		fillComboBox();

		// ::>Setup Buttons
		save = new JButton("Gravar  ");
		save.addActionListener(this);
		update = new JButton("Actualizar");
		update.addActionListener(this);
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(this);
		btnNovo = new JButton("Editar");
		btnNovo.addActionListener(this);

		setColumnSizes();

		// ::>> CheckBoxes

		efect_pesquisa = new JCheckBox("Efectuar_Pesquisa");
		qtd_chkbx = new JCheckBox("Quantidade");
		stk_min = new JCheckBox("Stock Minimo");
		armazem_chkbx = new JCheckBox("Armazem");
		fornecedor_chckbx = new JCheckBox("Fornecedor");
		nome_chkbx = new JCheckBox("Nome");
		checkBoxes = new ButtonGroup();

		efect_pesquisa.addActionListener(this);
		qtd_chkbx.addActionListener(this);
		stk_min.addActionListener(this);
		armazem_chkbx.addActionListener(this);
		fornecedor_chckbx.addActionListener(this);
		nome_chkbx.addActionListener(this);

		checkBoxes.add(qtd_chkbx);
		checkBoxes.add(stk_min);
		checkBoxes.add(nome_chkbx);
		checkBoxes.add(fornecedor_chckbx);
		checkBoxes.add(armazem_chkbx);

		// ::>> Layout

		JPanel data_input = new JPanel(new BorderLayout());
		JPanel data_fields = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel data_combo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		chckBoxesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel checkBoxGroup = new JPanel(new BorderLayout());

		// ::>> Top : header
		data_fields.add(new JLabel("Codigo: "));
		data_fields.add(codigo_);
		data_fields.add(new JLabel("Quantidade: "));
		data_fields.add(qtd_);
		data_fields.add(new JLabel("Stock minimo: "));
		data_fields.add(stockMinimo_);
		data_fields.add(new JLabel("Preco:  "));
		data_fields.add(preco_);

		data_combo.add(new JLabel("Nome: "));
		data_combo.add(nome_);
		data_combo.add(new JLabel("Fornecedores: "));
		data_combo.add(combo);
		data_combo.add(new JLabel("Armazem: "));
		data_combo.add(armazem_);
		data_combo.add(save);
		data_combo.add(update);
		data_combo.add(btnNovo);

		chckBoxesPanel.add(qtd_chkbx);
		chckBoxesPanel.add(stk_min);
		chckBoxesPanel.add(nome_chkbx);
		chckBoxesPanel.add(fornecedor_chckbx);
		chckBoxesPanel.add(armazem_chkbx);
		chckBoxesPanel.add(this.btnPesquisar);

		checkBoxGroup.add("North", data_combo);
		checkBoxGroup.add("Center", efect_pesquisa);
		checkBoxGroup.add("South", chckBoxesPanel);

		data_input.add("North", data_fields);
		data_input.add("South", checkBoxGroup);

		data_combo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		data_combo.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
		data_input.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		this.chckBoxesPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), "Pesquisa"));

		this.add("North", data_input);
		this.add("Center", tablePanel);
		this.pack();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chckBoxesPanel.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean toSave = false;
		if (arg0.getSource().equals(save)) {

			try {
				int stockMin = Integer.parseInt(stockMinimo_.getText());
				int quantidade = Integer.parseInt(qtd_.getText());

				if(stockMin > quantidade){
					JOptionPane.showMessageDialog(null, "::::Aviso!::::\nQuantidade menor que o stock minimo");
				}
				toSave = validation();

				if (toSave) {
					save();
				}

			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Insira Dados validos");
			}

		} else if (arg0.getSource().equals(update)) {
			update();
		} else if (arg0.getSource().equals(this.efect_pesquisa)) {
			if (this.efect_pesquisa.isSelected()) {
				this.chckBoxesPanel.setVisible(true);
				this.save.setEnabled(false);
			} else {
				this.chckBoxesPanel.setVisible(false);
				this.save.setEnabled(true);
			}
		} else if (arg0.getSource().equals(btnNovo)) {
			dataSwitch();
			Authentication.write();
		}

		else if (arg0.getSource().equals(this.btnPesquisar)) {

			Enumeration enume = this.checkBoxes.getElements();
			int count = this.checkBoxes.getButtonCount();

			Iterator it = enume.asIterator();

			for (int i = 0; i < count; i++) {

				JCheckBox checkBox = (JCheckBox) it.next();
				if (checkBox.isSelected()) {
					switch (i) {

					case 0:
						search_by_param(this.qtd_.getText(), 0);
						break;
					case 1:
						search_by_param(this.stockMinimo_.getText(), 1);
						break;
					case 2:
						search_by_param(this.nome_.getText(), 2);
						break;
					case 3:
						search_by_param(this.combo.getSelectedItem().toString(), 3);
						break;
					case 4:
						search_by_param(this.armazem_.getSelectedItem().toString(), 4);
						break;
					}
				}
			}
		}

	}

	public boolean validation(){
		int stockMin = Integer.parseInt(stockMinimo_.getText());
		int quantidade = Integer.parseInt(qtd_.getText());
		double preco = Double.parseDouble(preco_.getText());

		if (stockMin < 0 || quantidade <= 0 || preco < 0) {
			JOptionPane.showMessageDialog(null, "Atencao, valores Negativos ou iguais a Zero(0).");
			return false;
		}

		else if (armazem_.getSelectedIndex() == 0 || combo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um Armazem e um Forncecedor antes de gravar.");
			return false;

		} else if (preco == 0) {
			JOptionPane.showMessageDialog(null, "Preco inserido igual a zero(0).");
			return false;
		} else {
			return true;
		}
	}

	public void search_by_param(String param, int type) {
		update();
		Vector vasd = new Vector<>();

		if (!param.equals("")) {
			switch (type) {

			case 0: {

				for (Vector object : model.getDataVector()) {
					Vector vector = object;
					if (object.get(4).equals(param)) {
						vasd.add(vector);
					}

				}
				break;

			}

			case 1: {

				for (Vector object : model.getDataVector()) {
					Vector vector = object;
					if (object.get(2).equals(param)) {
						vasd.add(vector);
					}

				}

				break;

			}

			case 2: {

				for (Vector object : model.getDataVector()) {
					Vector vector = object;
					if (object.get(1).equals(param)) {
						vasd.add(vector);
					}

				}
				break;
			}

			case 3: {

				for (Vector object : model.getDataVector()) {
					Vector vector = object;
					if (object.get(5).equals(param)) {
						vasd.add(vector);
					}

				}
				break;
			}

			case 4: {

				for (Vector object : model.getDataVector()) {
					Vector vector = object;
					if (object.get(3).equals(param)) {
						vasd.add(vector);
					}

				}
				break;
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
				model.addRow(new String[] { "" + vector.get(0), "" + vector.get(1), "" + vector.get(2),
						"" + vector.get(3), "" + vector.get(4), "" + vector.get(5), "" + vector.get(6) });
			}
		} else {
			JOptionPane.showMessageDialog(null, "Os dados no campo selecionado nao sao validos");
		}

	}

	public void fillComboBox() {
		String[][] fornecedores = UserUtility.active_user.getAllProviders();
		combo.addItem("Escolha o Fornecedor");
		for (String[] data : fornecedores) {
			String nome = data[1];
			combo.addItem(nome);
		}

		String[][] armazens = UserUtility.active_user.getAllStorages();
		armazem_.addItem("Escolha o Armazem");
		for (String[] armazem : armazens) {
			armazem_.addItem(armazem[1]);
		}

	}

	public void populate_table() {

		Vector<Storage> storages = UserUtility.active_user.getStorage();
		for (Storage storage : storages) {

			String[][] data = storage.getAllProducts();

			for (String[] dt : data) {
				model.addRow(new String[] { "" + dt[0], "" + dt[1], "" + dt[5], "" + dt[3], "" + dt[4], "" + dt[2],
						"" + UserUtility.active_user.findStorage("" + dt[3]).getProduto("" + dt[0]).getPreco() });
			}

		}
	}

	public void save() {
		String nome = nome_.getText();
		Provider fornecedor = UserUtility.active_user.findProvider(combo.getSelectedItem().toString());
		int qtd = Integer.parseInt(qtd_.getText());
		int stk = Integer.parseInt(stockMinimo_.getText());
		double preco = Double.parseDouble(preco_.getText());
		Storage armazem = UserUtility.active_user.findStorage(armazem_.getSelectedItem().toString());

		if(armazem.verificar_existencia(nome) && armazem.verificar_existencia(preco)){
			Product produto = armazem.getProduto(nome, preco);
			produto.setQuantidade(produto.getQuantidade() + qtd);
			produto.setProd_s(produto.getProd_s() + qtd);
			update();
		}
		else {
			Product produto = new Product(nome, fornecedor, armazem, qtd, stk, preco);

			armazem.adicionar_produtos(produto);

			model.addRow(new String[]{"" + codigo_.getText(), "" + nome_.getText(), "" + stockMinimo_.getText(),
					"" + armazem_.getSelectedItem().toString(), "" + qtd_.getText(),
					"" + combo.getSelectedItem().toString(), "" + preco_.getText()});
		codigo_.setText(ID_Gen.nextId());
		}

		String s = new String(user+" Adicionou Produto: Código="+codigo_.getText()+" Nome="+nome_.getText());
		cr.salvar_Relatorio(s);

		Authentication.write();
		clearAll();

	}

	public void dataSwitch() {
		model.setValueAt(nome_.getText(), table.getSelectedRow(), 1);
		model.setValueAt(stockMinimo_.getText(), table.getSelectedRow(), 2);
		model.setValueAt(armazem_.getSelectedItem().toString(), table.getSelectedRow(), 3);
		model.setValueAt(qtd_.getText(), table.getSelectedRow(), 4);
		model.setValueAt(combo.getSelectedItem().toString(), table.getSelectedRow(), 5);
		model.setValueAt(preco_.getText(), table.getSelectedRow(), 6);

		if(validation()) {
			String nome = nome_.getText();
			Provider fornecedor = UserUtility.active_user.findProvider(combo.getSelectedItem().toString());
			String id = codigo_.getText();
			int qtd = Integer.parseInt(qtd_.getText());
			int stk = Integer.parseInt(stockMinimo_.getText());
			double preco = Double.parseDouble(preco_.getText());
			Storage armazem = UserUtility.active_user.findStorage(armazem_.getSelectedItem().toString());

			Product produto = armazem.getProduto(id);
			produto.setQuantidade(qtd);
			produto.setStock_minimo(stk);
			produto.setNome(nome);
			produto.setArmazem(armazem);
			produto.setFornecedor(fornecedor);
			update();
		}
	}

	public void clearAll() {
		nome_.setText("");
		combo.setSelectedIndex(0);
		qtd_.setText("");
		stockMinimo_.setText("");
		armazem_.setSelectedIndex(0);
		preco_.setText("");
	}

	public void clearComboBox() {
		combo.removeAllItems();
		armazem_.removeAllItems();
	}

	public void clearTable() {

		Vector vector = model.getDataVector();
		vector.clear();
	}

	public void setColumnSizes() {
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) this.table.getColumnModel();
		for (int i = 0; i < 6; i++) {
			columnModel.getColumn(i).setMinWidth(100);
		}

	}

	public void update() {
		clearComboBox();
		clearTable();
		fillComboBox();
		populate_table();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(table)) {
			Vector vector = model.getDataVector().elementAt(table.getSelectedRow());
			codigo_.setText("" + vector.get(0));
			nome_.setText("" + vector.get(1));
			stockMinimo_.setText("" + vector.get(2));
			armazem_.setSelectedItem("" + vector.get(3));
			qtd_.setText("" + vector.get(4));
			combo.setSelectedItem("" + vector.get(5));
			preco_.setText("" + vector.get(6));
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