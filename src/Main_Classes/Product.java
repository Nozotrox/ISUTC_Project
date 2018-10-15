package Main_Classes;

import Main.ID_Gen;

public class Product {

    private String id = ID_Gen.generate_id();
    private int stock_minimo;
    private String nome;
    private Provider fornecedor;
    private Storage armazem;
    private int quantidade;


    public Product(String nome, Provider fornecedor, Storage armazem, int quantidade, int stockMinimo){
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.armazem = armazem;
        this.quantidade = quantidade;
        this.stock_minimo = stockMinimo;

    }

    //::>> Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Provider getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Provider fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Storage getArmazem() {
        return armazem;
    }

    public void setArmazem(Storage armazem) {
        this.armazem = armazem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void removerProduto(int quantidade){
        this.setQuantidade(this.quantidade - quantidade);
    }


    //::>> Se a quantidade do produto for menor que o stock minimo ira devolver False
    //::>> Logic >> Q: Can i set Product quantity?  A: If this.quantity > this.sotck_minimo, True, else False;
    public boolean setQuantidade(int quantidade) {
        this.quantidade = quantidade;

        if(this.quantidade > this.stock_minimo){
            return true;
        }
        return false;
    }
}
