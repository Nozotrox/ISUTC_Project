import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private String username;


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
}
