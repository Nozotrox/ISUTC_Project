package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
public class StorageFrame extends JInternalFrame implements ActionListener {

	JTable table;

	// FILTER TExtField
	JTextField getTxtNome, getTxtNr;

	JButton btnPesquisar, btnActualizar, btnGravar;

	// Own TextField
	JTextField codigo_, nome_;

	JButton cancel;
	JButton save;
	private ImageIcon icon;
	DefaultTableModel model;
	String[] columnNames;

	public StorageFrame() {

		setTitle("Armazem");
		setSize(600, 400);
		setLocation(220, 220);
		setLayout(new BorderLayout());

		// Data to be displayed in the JTable
		String[][] data = null;
		// Column Names
		columnNames = new String[] { "Codigo", "Nome" };

		// Layout //

		model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		north.add(new JLabel("Tela de Registo de Armazem"));

		table = new JTable(model);
		JPanel table_layout = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane(table);

		table_layout.add("North", table.getTableHeader());
		table_layout.add("Center", scroll);

		JPanel pnCenter = new JPanel(new GridLayout(2, 1));

		JPanel pnUpSide = new JPanel(new GridLayout(1, 2));

		JPanel pn = new JPanel(new BorderLayout());

		///// /////

		JPanel pcenter = new JPanel();
		pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 70));

		// Left Side
		JPanel pLeft = new JPanel();
		pLeft.setLayout(new GridLayout(4, 1));

		pLeft.add(new JLabel("Nome: "));
		pLeft.add(new JLabel(""));
		pLeft.add(new JLabel("Codigo: "));
		pLeft.add(new JLabel(""));

		// Right Side
		JPanel pRight = new JPanel();
		pRight.setLayout(new GridLayout(4, 1));
		codigo_ = new JTextField(12);
		codigo_.setText(ID_Gen.nextId());
		codigo_.setEnabled(false);
		// username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

		// password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		nome_ = new JTextField(12);
		// nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

		pRight.add(nome_);
		pRight.add(new JLabel(""));
		pRight.add(codigo_);
		pRight.add(new JLabel(""));

		JPanel pbtn = new JPanel();
		pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

		// Button OK
		save = new JButton("OK");
		save.setBorder(null);
		save.setBackground(Color.LIGHT_GRAY);
		save.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
		save.addActionListener(this);

		// Button Cancel
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.GRAY);
		cancel.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
		cancel.addActionListener(this);

		pbtn.add(save);
		pbtn.add(cancel);

		pcenter.add(pLeft);
		pcenter.add(pRight);

		///// /////

		pn.add("Center", pcenter);
		pn.add("South", pbtn);

		pnUpSide.add(pn);

		pnUpSide.add(new JLabel(""));

		JPanel pnBottonSide = new JPanel(new BorderLayout());

		JPanel banner = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 25));

		getTxtNome = new JTextField(15);
		getTxtNr = new JTextField(15);
		btnPesquisar = new JButton("Procurar");
		btnPesquisar.addActionListener(this);

		banner.add(new JLabel("Nr:"));
		banner.add(getTxtNr);
		banner.add(new JLabel("Nome:"));
		banner.add(getTxtNome);
		banner.add(btnPesquisar);

		pnBottonSide.add("North", banner);
		pnBottonSide.add("Center", table_layout);

		pnCenter.add(pnUpSide);
		pnCenter.add(pnBottonSide);

		add("North", north);
		add("Center", pnCenter);

		setVisible(true);
		read();
	}

	public static void main(String[] args) {
		new StorageFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPesquisar) {
			Vector vasd = new Vector<>();

			// ::>> Pesquisa
			if ((!model.getDataVector().isEmpty() && !getTxtNome.getText().equals(""))) {
				if ((getTxtNome.getText() != null) && (!getTxtNome.getText().equals(""))) {
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
						model.addRow(new String[] { "" + vector.get(0), "" + vector.get(1) });
					}
				}
				getTxtNome.setText("");
				getTxtNr.setText("");
			} else {
				read();
			}
		} else if (e.getSource().equals(save)) {

			String[] a = new String[] { "" + codigo_.getText(), "" + nome_.getText() };
			model.addRow(a);
			Storage storage = new Storage(nome_.getText());
			UserUtility.active_user.adicionar_armazem(storage);
			/*
			 * 
			 * 
			 * 
			 * 
			 */
			write();
			codigo_.setText(ID_Gen.nextId());
			// Provider fornecedor = new Provider(nome_.getText(), nuit_.getText());
			// UserUtility.active_user.adicionar_fornecedor(fornecedor);
			// write();
		} else if (e.getSource().equals(cancel)) {
			model.removeRow(model.getDataVector().size() - 1);
		}
	}

	public void write() {
		Authentication.write();

		/*
		 * FileOutputStream file_output = null; ObjectOutputStream o_output = null;
		 * 
		 * try { file_output = new FileOutputStream("Providers.dat"); o_output = new
		 * ObjectOutputStream(file_output);
		 * 
		 * o_output.writeObject(model.getDataVector()); } catch (FileNotFoundException
		 * e) { e.printStackTrace();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally{
		 * 
		 * try { o_output.close(); file_output.close(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * }
		 */
	}

	private void read() {
		FileInputStream file_input = null;
		ObjectInputStream o_input = null;
		model.setDataVector(null, columnNames);

		if (UserUtility.active_user.getAllStorages() != null) {
			String[][] armazens = UserUtility.active_user.getAllStorages();
			for (String[] data : armazens) {
				model.addRow(data);
			}
		}

		/*
		 * try { file_input = new FileInputStream("Providers.dat"); o_input = new
		 * ObjectInputStream(file_input);
		 * 
		 * 
		 * 
		 * for(Object object:(Vector) o_input.readObject()){ Vector ok= (Vector) object;
		 * String[] args=new String[]{""+ok.get(0),""+ok.get(1),""+ok.get(2)};
		 * model.addRow(args);
		 * 
		 * }
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); } finally{ try { o_input.close();
		 * file_input.close(); } catch (IOException e) { e.printStackTrace(); }
		 * catch(NullPointerException e){ e.printStackTrace(); }
		 * 
		 * }
		 */

	}
}
