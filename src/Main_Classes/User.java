package Main_Classes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

public class User implements Serializable {

    private String name;
    private String password;
    private String username;
    private int id_gen = 0;
    private int storage_id_gen = 0;
    private int provider_id_gen = 0;

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


    public void setProvider_id_gen(int provider_id_gen) {
        this.provider_id_gen = provider_id_gen;
    }

    public void setStorage_id_gen(int storage_id_gen) {
        this.storage_id_gen = storage_id_gen;
    }

    public int getStorage_id_gen() {
        return storage_id_gen;
    }

    public int getProvider_id_gen() {
        return provider_id_gen;
    }

    public void setId_gen(int id_gen) {
        this.id_gen = id_gen;
    }

    public int getId_gen() {
        return id_gen;
    }

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

    public Vector getStorage(){
        return this.armazens;
    }

    public String[][] getAllProviders(){
        int parm_fornecedor = 3;
        int rows = this.fornecedores.size();
        String[][] allProviders = new String[rows][parm_fornecedor];

        int count = 0;

        for(Provider prv: this.fornecedores){
            allProviders[count] = prv.return_collection();
            count++;
        }
        return allProviders;
    }

    public Storage findStorage(String tipo){
        for(Storage store: armazens){
            if(store.getTipo().equals(tipo)){
                return store;
            }
        }
        return null;
    }

    public Provider findProvider(String nome){
        for(Provider provider: fornecedores){
            if(provider.getNome().equals(nome)){
                return provider;
            }
        }
        return null;
    }



    public String[][] getAllStorages(){
        int parm_storage = 3;
        String[][] allStorage = new String[this.armazens.size()][parm_storage];
        int count = 0;

        for(Storage stor: this.armazens){

            allStorage[count] = stor.return_collection();
            count++;
        }

        return allStorage;

    }

    //::>> CLOSURE
}
