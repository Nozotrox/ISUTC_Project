import java.util.Iterator;
import java.util.Vector;

public class UserUtility {

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
}
