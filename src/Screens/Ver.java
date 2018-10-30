package Screens;

import Main.UserUtility;
import Main_Classes.User;

import java.util.*;

public class Ver {
    public static void main(String [] args){
        try{
           for(String[] aux : UserUtility.active_user.getVendas()){
               for(String s : aux){
                   System.out.print(s);
               }
           }
        }
        catch(Exception ex){ex.printStackTrace();}
    }
}
