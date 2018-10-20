package Main;

import Main_Classes.User;

public class ID_Gen {

    public static int id_gen = UserUtility.active_user.getId_gen(); //::>> Variavel mantem controle dos id gerados
    public static int storage_id_gen = UserUtility.active_user.getStorage_id_gen();
    public static int provider_id_gen = UserUtility.active_user.getProvider_id_gen();

    public static int length = 4;


    public static String generate_id(){

        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.id_gen);
        ID_Gen.id_gen++;
        UserUtility.active_user.setId_gen(ID_Gen.id_gen);
        return zeros;
    }

    public static String generate_storage_id(){

        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.storage_id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.storage_id_gen);
        ID_Gen.storage_id_gen++;
        UserUtility.active_user.setStorage_id_gen(ID_Gen.storage_id_gen);
        return zeros;
    }

    public static String generate_provider_id(){

        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.provider_id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.provider_id_gen);
        ID_Gen.provider_id_gen++;
        UserUtility.active_user.setProvider_id_gen(ID_Gen.provider_id_gen);
        return zeros;
    }

    public static String nextId(){
        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.id_gen);
        return zeros;
    }

    public static String nextStorageId(){
        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.storage_id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.storage_id_gen);
        return zeros;
    }

    public static String nextProviderId(){
        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.provider_id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.provider_id_gen);
        return zeros;
    }





}
