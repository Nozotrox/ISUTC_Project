package Main_Classes;

import Main.ID_Gen;

import java.util.Vector;

public class Storage {

    //::>> Classe gera ID's automaticamente


    private String id = ID_Gen.generate_id();
    private String tipo;
    private Vector<Product> produtos = new Vector();

    public Storage(String tipo){
        this.tipo = tipo;
    }

    public Storage (String tipo, Vector<Product> produtos){
        this(tipo);
        this.produtos = produtos;
    }

    //::>> Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    //::>> Metodos Auxiliares

    public boolean verificar_existencia(Product produto){

        for(Product pro: this.produtos){
            if(pro.getId().equals(produto.getId())) {
                return true;
            }
        }

        return false;
    }

    public boolean adicionar_produtos(Product produto){

        if(verificar_existencia(produto)){
            return false;
        }
        else{
            this.produtos.add(produto);
        }
        return true;
    }

    public boolean verifcar_produtos(){
        if(this.produtos.isEmpty()){
            return true;
        }
        return false;
    }
}
