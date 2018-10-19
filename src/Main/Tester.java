package Main;

import Main_Classes.Product;
import Main_Classes.Provider;
import Main_Classes.Storage;
import Main_Classes.User;

import javax.swing.*;

public class Tester extends JFrame {

    public static void main(String[] args){


        User user = new User("Feliciano", "123");
        Provider forn_1 = new Provider("Antonio", "123");
        Provider forn_2 = new Provider("Gaza", "123");
        Provider forn_3 = new Provider("Inhambane", "123");

        Storage arm_1 = new Storage("Comida");
        Storage arm_2 = new Storage("Bebida");
        Storage arm_3 = new Storage("Quinquilharia");

        user.adicionar_fornecedor(forn_1);
        user.adicionar_fornecedor(forn_2);
        user.adicionar_fornecedor(forn_3);

        Product pro_1 = new Product("papaia", forn_1, arm_1, 20, 5);
        Product pro_2 = new Product("banana", forn_1, arm_1, 20, 5);
        Product pro_3 = new Product("uvas", forn_1, arm_1, 20, 5);

        arm_1.adicionar_produtos(pro_1);
        arm_1.adicionar_produtos(pro_2);
        arm_1.adicionar_produtos(pro_3);



        user.adicionar_armazem(arm_1);
        user.adicionar_armazem(arm_2);
        user.adicionar_armazem(arm_3);

        System.out.println(user.getAllProviders().toString());
        System.out.println(user.getAllStorages().toString());

    }
}
