import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class Authentication extends JFrame implements ActionListener {

    private Vector<User> users = new Vector<>();

    JLabel username;
    JLabel password;
    JLabel nome;

    JTextField username_;
    JPasswordField password_;
    JTextField nome_;

    JButton log_in;
    JButton cancel;
    JButton cancel2;
    JButton sign_up;

    JButton confirmar;

    JFrame jf;

    boolean insideReg;


    public Authentication(){
        build_ui();
    }

    //::>> UI METHODS
    private void build_ui(){

        this.setPreferredSize(new Dimension(400, 250));
        this.setSize(380,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel cred_layout = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        JPanel flowLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        username = new JLabel("Username: ");
        password = new JLabel("Password: ");
        nome = new JLabel("     Nome: ");

        username_ = new JTextField(20);
        password_ = new JPasswordField(20);
        nome_ = new JTextField(20);

        log_in = new JButton("Log In");
        cancel = new JButton("Cancelar");
        sign_up = new JButton("Registrar");

        log_in.addActionListener(this);
        sign_up.addActionListener(this);
        cancel.addActionListener(this);


        cred_layout.add(nome);
        cred_layout.add(nome_);

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

        nome.setVisible(false);
        nome_.setVisible(false);
    }

    private void sign_up_ui(){

        this.insideReg = true;

        jf = new JFrame();
        jf.setPreferredSize(new Dimension(400, 250));
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel cred_layout = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        JPanel flowLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        cred_layout.add(nome);
        cred_layout.add(nome_);

        cred_layout.add(username);
        cred_layout.add(username_);

        cred_layout.add(password);
        cred_layout.add(password_);

        confirmar = new JButton("Confirmar");
        cancel2 = new JButton("Cancelar");
        cancel2.addActionListener(this);

        confirmar.addActionListener(this);

        flowLayout.add(confirmar);
        flowLayout.add(cancel2);
        flowLayout.add(new JLabel("  "));

        jf.add("Center",cred_layout);
        jf.add("South", flowLayout);
        jf.add("East", new JLabel("      "));
        jf.add("West", new JLabel("      "));
        jf.pack();
        jf.setVisible(true);

        nome.setVisible(true);
        nome_.setVisible(true);

    }

    private void log_in_ui(){
        this.nome.setVisible(false);
        this.nome_.setVisible(false);
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

        if(e.getSource() == this.sign_up){

            sign_up_ui();
        }

        if(e.getSource() == this.confirmar || e.getSource() == this.cancel){
            String nome;
            String username;
            String password;

            nome = this.nome_.getText();
            username = this.username_.getText();
            password = this.password_.getText();

            if(username.isEmpty()){
                username = nome;
            }

            if(UserUtility.isRegistred(nome, username, this.users)){
                JOptionPane.showMessageDialog(null, "Usuario ja Registrado!");

            }
            else{
                User novoUsuario = new User(nome, username, password);
                this.users.add(novoUsuario);
                JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");

            }

            if(insideReg){
                this.username_.setText("");
                this.password_.setText("");
                this.nome_.setText("");
                jf.dispose();
            }



            this.insideReg = false;
        }

        if(e.getSource() == this.cancel){
            System.exit(0);
        }

        if(e.getSource() == this.cancel2){
            this.dispose();
        }
    }
}
