
package Main;

import Main_Classes.User;
import Screens.MainMenu;
import Screens.Sign_up;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;


public class Authentication extends JFrame implements ActionListener {


    private JPanel panelLeft, panelRight,
    //Panel Right Components
    pRTotal,
            pLeft, pRight, pbtn, pBotton;
    private ImageIcon icon;
    private JTextField username_;
    private JPasswordField password_;
    private JButton buttonOK, buttonRegisto, buttonCancel;


    public Authentication(){
        Authentication.read();
        build_ui();
    }

    //::>> UI METHODS
    private void build_ui(){
        this.setTitle("ifk > Login");
        this.setSize(500,350);
        this.setLocationRelativeTo(null);
        setUndecorated(true);
        this.setResizable(false);
        icon = new ImageIcon("ISUTC_Project/img/icon.jpg");
        this.setIconImage(icon.getImage());
        //Layout
        this.setLayout(new GridLayout(1, 2));

        //Panel Left
        panelLeft = new JPanel();
        panelLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        icon = new ImageIcon("ISUTC_Project/img/LeftImgLogin.jpg");
        panelLeft.add(new JLabel(icon));
        panelLeft.setBackground(Color.white);
        this.add(panelLeft);

        //Panel Right
        panelRight = new JPanel();
        panelRight.setBackground(Color.white);
        panelRight.setLayout(new FlowLayout(FlowLayout.CENTER, 1366, 45));
        JLabel title = new JLabel("Login");
        title.setFont(new Font("AriaL", Font.BOLD, 25));
        panelRight.add(title);
        // Left Side
        pLeft = new JPanel();
        pLeft.setBackground(Color.white);
        pLeft.setLayout(new GridLayout(3,1));

        pLeft.add(new JLabel("Username: "));
        pLeft.add(new JLabel("Password: "));
        pLeft.add(new JLabel(""));

        // Right Side
        pRight = new JPanel();
        pRight.setBackground(Color.white);
        pRight.setLayout(new GridLayout(3, 1));
        username_ = new JTextField(12);
        username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        password_ = new JPasswordField(12);
        password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        pbtn = new JPanel();
        pbtn.setBackground(Color.white);
        pbtn.setLayout(new FlowLayout(5));
        //Button OK
        buttonOK = new JButton("OK");
        buttonOK.setBorder(null);
        buttonOK.setBackground(Color.LIGHT_GRAY);
        buttonOK.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
        //Button Cancel
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(Color.GRAY);
        buttonCancel.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));

        pbtn.add(buttonOK); pbtn.add(buttonCancel);

        pRight.add(username_);
        pRight.add(password_);

        pRight.add(pbtn);

        // Botton
        pBotton = new JPanel();
        pBotton.setBackground(Color.white);
        pBotton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        //Button Registo
        buttonRegisto = new JButton("Registo");
        buttonRegisto.setBorder(null);
        buttonRegisto.setBackground(Color.WHITE);
        //buttonRegisto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pBotton.add(buttonRegisto);

        pRTotal = new JPanel();
        pRTotal.setBackground(Color.white);
        pRTotal.setLayout(new BorderLayout());
        pRTotal.add("West", pLeft); pRTotal.add("Center", pRight); pRTotal.add("South", pBotton);

        panelRight.add(pRTotal);
        this.add(panelRight);

        buttonOK.addActionListener(this);
        buttonRegisto.addActionListener(this);
        buttonCancel.addActionListener(this);

        this.setVisible(true);
    }

    //::>> FUNCTIONALITY METHODS

    public static void write(){

        FileOutputStream file_output = null;
        ObjectOutputStream o_output = null;
        Vector users = (Vector) UserUtility.users.clone();

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

    public static void read(){

        FileInputStream file_input = null;
        ObjectInputStream o_input = null;


        try {
            file_input = new FileInputStream("Credentials.dat");
            o_input = new ObjectInputStream(file_input);
            UserUtility.users = (Vector) o_input.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                o_input.close();
                file_input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e){
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

        String nome;
        String username;
        String password;


        if(e.getSource() == this.buttonRegisto){
            this.setVisible(false);
            new Sign_up();
        }
        else if(e.getSource() == this.buttonCancel){
            Authentication.write();
            System.exit(0);
        }

        else if(e.getSource() == this.buttonOK){
            username = this.username_.getText();
            password = this.password_.getText();

            User active_user = UserUtility.isValid(username, password, UserUtility.users);

            if(active_user != null){
                JOptionPane.showMessageDialog(null, "Bem-vindo "+username);
                UserUtility.active_user = active_user;
                this.setVisible(false);
                new MainMenu(username);
            }else{
                JOptionPane.showMessageDialog(null, "Username ou Password Incorrectos");
            }

        }
    }
}