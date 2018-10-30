package Main;

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

    public get
}
