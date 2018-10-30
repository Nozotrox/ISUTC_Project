package Main;

import Main_Classes.Product;
import Main_Classes.Storage;
import Main_Classes.User;

import java.util.Iterator;
import java.util.Vector;

public class UserUtility {

    public static Vector users = new Vector();
    public static User active_user = null;


    private  static void add_User(User user){
        users.add(user);
    }

    private static Vector getUsers(){
        return users;
    }

    public static boolean isRegistred(String nome, String username, Vector elements){

        Iterator it = elements.iterator();

        for(int i = 0; i < elements.size(); i++){
            User next_user = (User) it.next();
            if(next_user.getName().equals(nome)){
                if(next_user.getUsername().equals(username)){
                    return true;
                }
            }
        }
        return false;
    }

    public static User isValid(String username, String password, Vector elements){

        Iterator it = elements.iterator();

        for(int i = 0; i < elements.size(); i++){
            User next_user = (User) it.next();

            if(next_user.getUsername().equals(username)){
                if(next_user.getPassword().equals(password)){
                    return  next_user;
                }
            }


        }
        return null;
    }

    //::>> Estatistica

    //::>> Numero de produtos
    public static int numeroProdutos(){
        int sum = 0;
        Vector<Storage> storages = UserUtility.active_user.getStorage();

        for(Storage store: storages){
            sum += store.getQuantidadeProd();
        }

        return sum;
    }

    public static String[] prod_maisVendidos(){
        int nome = 2, qtd = 3;
        String[] maisVend = new String[3];

        Vector<Integer> quantidades = new Vector();
        Vector<String> maisVendidos = new Vector();

        for(String[] venda: UserUtility.active_user.getVendas()){
            maisVendidos.add(venda[nome]);
            quantidades.add(Integer.parseInt(venda[qtd]));
        }

        for(int fixo = 0; fixo < quantidades.size(); fixo++){
            for(int movel = fixo + 1; movel < quantidades.size(); movel++ ){

                if(quantidades.get(movel) > quantidades.get(fixo)){
                    syncronizedSwitch(fixo, movel, quantidades, maisVendidos);
                }
            }
        }

        for(int i = 0; i < 3; i ++){
            try{

                maisVend[i] = maisVendidos.get(i);
            }
            catch(IndexOutOfBoundsException ex){
                ex.printStackTrace();
                maisVend[i] = "---";
            }
        }

        return maisVend;

    }


    public static void syncronizedSwitch(int init, int fin, Vector<Integer> one, Vector<String> two){

        int temp = one.get(init);
        one.set(init, one.get(fin));
        one.set(fin, temp);

        String temp_s  = two.get(init);
        two.set(init, two.get(fin));
        two.set(fin, temp_s);

    }

    public int numeroVendas(){
        return UserUtility.active_user.getVendas().size();
    }


    public static String[][] armazensMaisProd(){
        int nome = 2, qtd = 3;
        String[][] maisVend = new String[3][2];

        Vector<Integer> quantidades = new Vector();
        Vector<String> maisVendidos = new Vector();

        for(Storage store: UserUtility.active_user.getStorage()){
            maisVendidos.add(store.getTipo());
            quantidades.add(store.getQuantidadeProd());
        }

        for(int fixo = 0; fixo < quantidades.size(); fixo++){
            for(int movel = fixo + 1; movel < quantidades.size(); movel++ ){

                if(quantidades.get(movel) > quantidades.get(fixo)){
                    syncronizedSwitch(fixo, movel, quantidades, maisVendidos);
                }
            }
        }

        for(int i = 0; i < 3; i ++){
            try{

                maisVend[i][0] = maisVendidos.get(i);
                maisVend[i][1] = String.valueOf(quantidades.get(i));
            }
            catch(IndexOutOfBoundsException ex){
                ex.printStackTrace();
                maisVend[i][0] = "---";
                maisVend[i][1] = "---";
            }
        }

        return maisVend;

    }

    public static String[][] maior_forn(){

        String[][] m_forn = new String[3][2];
        Vector<String> provider_names = new Vector();
        Vector<Integer> qtd_prod = new Vector();



        for(Storage store: UserUtility.active_user.getStorage()){

            for(Product pro: store.getProdutos()){

                String nome = pro.getFornecedor().getNome();
                int qtd = pro.getProd_s();

                if(provider_names.contains(nome)){
                    int index = provider_names.indexOf(nome);
                    qtd_prod.set(index, qtd_prod.get(index) + qtd);
                }
                else {
                    provider_names.add(nome);
                    qtd_prod.add(qtd);
                }

            }
        }

        for(int fixo = 0; fixo < qtd_prod.size(); fixo++){
            for(int movel = fixo + 1; movel < qtd_prod.size(); movel++ ){

                if(qtd_prod.get(movel) > qtd_prod.get(fixo)){
                    syncronizedSwitch(fixo, movel, qtd_prod, provider_names);
                }
            }
        }

        for(int i = 0; i < 1; i ++){
            try{

                m_forn[i][0] = provider_names.get(i);
                m_forn[i][1] = String.valueOf(qtd_prod.get(i));
            }
            catch(IndexOutOfBoundsException ex){
                ex.printStackTrace();
                m_forn[i][0] = "---";
                m_forn[i][1] = "---";
            }
        }

        return m_forn;

    }



}
