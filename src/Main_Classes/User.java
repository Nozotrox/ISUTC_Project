package Main_Classes;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    private String name;
    private String password;
    private String username;

    private Vector<Provider> fornecedores = new Vector();
    private Vector<Storage> armazens = new Vector();


    public User(String name, String password){
        this.name = name;
        this.username = name;
        this.password = password;
    }

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    //::>> GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    //::>> CLOSURE

    //:::>> HELPER METHODS

    public void adicionar_fornecedor(Provider fornecedor){
        this.fornecedores.add(fornecedor);
    }

    public void remover_fornecedor(Provider fornecedor){

        for(Provider forn: this.fornecedores){
            if(forn.getId().equals(fornecedor.getId())){
                this.fornecedores.remove(forn);
            }
        }

    }

    public void adicionar_armazem(Storage armazem){
        this.armazens.add(armazem);
    }

    public void remover_armazem(Storage armazem){

        for(Storage stor: this.armazens){
            if(stor.getId().equals(armazem.getId())){
                this.armazens.remove(stor);
            }
        }
    }

    //::>> CLOSURE
}
