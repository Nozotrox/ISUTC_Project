package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import Main.*;

public class Sign_up extends JFrame implements ActionListener {


    JLabel username;
    JLabel password;
    JLabel nome;

    JTextField username_;
    JPasswordField password_;
    JTextField nome_;

    JButton log_in;
    JButton cancel;
    JButton sign_up;


    public Sign_up(){
        build_ui();
    }

    public void build_ui(){

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

        cancel = new JButton("Cancelar");
        sign_up = new JButton("Registrar");

        sign_up.addActionListener(this);
        cancel.addActionListener(this);


        cred_layout.add(nome);
        cred_layout.add(nome_);

        cred_layout.add(username);
        cred_layout.add(username_);

        cred_layout.add(password);
        cred_layout.add(password_);


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

    public static void main(String[] args){
        new Sign_up();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nome;
        String username;
        String password;

        if(e.getSource() == cancel){
            this.dispose();
        }
        else if(e.getSource() == sign_up){

            nome = this.nome_.getText();
            username = this.username_.getText();
            password = this.password_.getText();

            if(username.isEmpty()){
                username = nome;
            }

            if(!(nome.equals("") || password.equals(""))){

                if(UserUtility.isRegistred(nome, username, UserUtility.users)){
                    JOptionPane.showMessageDialog(null, "Usuario ja Registrado!");

                }
                else{
                    User novoUsuario = new User(nome, username, password);
                    UserUtility.users.add(novoUsuario);
                    JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");
                    this.username_.setText("");
                    this.password_.setText("");
                    this.nome_.setText("");
                    this.dispose();

                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor, Preencha os campos Obrigatorios: Nome e Password");
            }





        }



    }
}
