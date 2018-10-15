package Main;

public class ID_Gen {

    public static int id_gen = 1; //::>> Variavel mantem controle dos id gerados
    public static int length = 4;


    public static String generate_id(){

        String zeros = "";
        int num_zeros = 4 - String.valueOf(ID_Gen.id_gen).length();

        for(int i = 0; i < num_zeros; i++){
            zeros += "0";
        }

        zeros += String.valueOf(ID_Gen.id_gen);
        ID_Gen.id_gen++;
        return zeros;
    }

    public static void main(String[] args){

        System.out.println(ID_Gen.generate_id());
    }
}
