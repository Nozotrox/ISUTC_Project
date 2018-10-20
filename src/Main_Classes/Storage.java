package Main_Classes;

import java.io.Serializable;
import java.util.Vector;

import Main.ID_Gen;

public class Storage implements DataList, Serializable {

	// ::>> Classe gera ID's automaticamente

	private String id = ID_Gen.generate_id();
	private String tipo;
	private Vector<Product> produtos = new Vector();

	public Storage(String tipo) {
		this.tipo = tipo;
	}

	public Storage(String tipo, Vector<Product> produtos) {
		this(tipo);
		this.produtos = produtos;
	}

	// ::>> Getters e Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	// ::>> Metodos Auxiliares

	public boolean verificar_existencia(Product produto) {

		for (Product pro : this.produtos) {
			if (pro.getId().equals(produto.getId())) {
				return true;
			}
		}

		return false;
	}

	public boolean adicionar_produtos(Product produto) {

		if (verificar_existencia(produto)) {
			return false;
		} else {
			this.produtos.add(produto);
		}
		return true;
	}

	public boolean verifcar_produtos() {
		return this.produtos.isEmpty();
	}

	// ::>> Returns in this sequence {id, tipo, quantidade de produtos}
	@Override
	public String[] return_collection() {
		String[] data_list = { this.id, this.tipo, String.valueOf(this.produtos.size()) };
		return data_list;
	}

	public String[][] getAllProducts() {
		int param_products = 6;
		int rows = this.produtos.size();
		String[][] allProdutcs = new String[rows][param_products];
		int count = 0;

		for (Product pro : this.produtos) {
			allProdutcs[count] = pro.return_collection();
			count++;
		}

		return allProdutcs;
	}
}
