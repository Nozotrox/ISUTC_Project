import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class Authentication extends JFrame implements ActionListener {

    private Vector<User> users = new Vector<>();

    public Authentication(){
        build_ui();
    }

    //::>> UI METHODS
    private void build_ui(){

        this.setPreferredSize(new Dimension(380, 200));
        this.setSize(380,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel cred_layout = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        JPanel flowLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");

        JTextField username_ = new JTextField(20);
        JPasswordField password_ = new JPasswordField(20);

        JButton log_in = new JButton("Log In");
        JButton cancel = new JButton("Cancelar");
        JButton sign_up = new JButton("Registrar");

        log_in.addActionListener(this);
        sign_up.addActionListener(this);
        cancel.addActionListener(this);


        cred_layout.add(username);
        cred_layout.add(username_);

        cred_layout.add(password);
        cred_layout.add(password_);

        flowLayout.add(log_in);
        flowLayout.add(sign_up);
        flowLayout.add(cancel);
        flowLayout.add(new JLabel("  "));

        this.add("Center",cred_layout);
        this.add("South", flowLayout);
        this.add("East", new JLabel("      "));
        this.add("West", new JLabel("      "));
        this.pack();
        this.setVisible(true);
    }

    //::>> FUNCTIONALITY METHODS
    public boolean auth_log_in(String username, String password){
        Iterator users_it = users.iterator();
        User u = null;

        for(int i = 0; i < users.size(); i++){

            u = (User) users_it.next();
            if(compare_values(username, u.getUsername())){
                if(compare_values(password, u.getPassword())){
                    return true;
                }
                else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean compare_values(String first, String second){
        if(first.equals(second)){
            return true;
        }
        return false;
    }

    public boolean auth_sign_up(String name, String username, String password){

        User new_user = new User(name, username, password);
        Iterator users_it = users.iterator();
        User temp_u = null;

        for(int i = 0; i < users.size(); i++){
            temp_u = (User) users_it.next();

            if(compare_values(temp_u.getName(), name)){
                return false;
            }
            else{
                if(compare_values(temp_u.getUsername(), username)){
                    return false;
                }
                else{
                    users.add(new_user);
                    return true;
                }
            }
        }

        return false;
    }

    public void write(){

        FileOutputStream file_output = null;
        ObjectOutputStream o_output = null;


        try {
            file_output = new FileOutputStream("Credentials.dat");
            o_output = new ObjectOutputStream(file_output);

            o_output.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{

            try {
                o_output.close();
                file_output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void read(){

        FileInputStream file_input = null;
        ObjectInputStream o_input = null;

        try {
            file_input = new FileInputStream("Credentials.dat");
            o_input = new ObjectInputStream(file_input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                o_input.close();
                file_input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //::>> CLOSE

    public static void main(String[] args){
        new Authentication();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
