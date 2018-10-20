package Main_Classes;

import Main.ID_Gen;

import java.io.Serializable;

public class Provider implements DataList, Serializable {

    private String id = ID_Gen.generate_provider_id();
    private String nome;
    private String nuit;


    //::>>#TODO: Fazer metodo para encotrar fornecedor

    public Provider(String nome, String nuit){
        this.nome = nome;
        this.nuit = nuit;
    }

    //::>> Getters e Setters

    public String getId() {
        return id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    //::>> Segue a sequencia {id, nome, nuit}
    public String[] return_collection(){
        String[] object_data = {this.id, this.nome, this.nuit};
        return object_data;
    }
}
