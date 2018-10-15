
package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main_Classes.User;

import Main.*;

public class Sign_up extends JFrame implements ActionListener {

    JTextField username_;
    JPasswordField password_;
    JTextField nome_;

    JButton cancel;
    JButton sign_up;

    //String user;

    private ImageIcon icon;

    public Sign_up(){
        build_ui();
    }

    public void build_ui(){

        setPreferredSize(new Dimension(400, 250));
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setUndecorated(true);
        this.setBackground(Color.white);

        JPanel pcenter = new JPanel();
        pcenter.setBackground(Color.white);
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 70));
        icon = new ImageIcon("ISUTC_Project/img/addUser.png");
            JLabel title = new JLabel(icon);
            title.setFont(new Font("AriaL", Font.BOLD, 25));
        pcenter.add(title);

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setBackground(Color.white);
        pLeft.setLayout(new GridLayout(5,1));

        pLeft.add(new JLabel("Nome: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Username: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Password: "));

        // Right Side
        JPanel pRight = new JPanel();
        pRight.setBackground(Color.white);
        pRight.setLayout(new GridLayout(5, 1));
        username_ = new JTextField(12);
        username_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        password_ = new JPasswordField(12);
        password_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        nome_ = new JTextField(12);
        nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        pRight.add(nome_);
        pRight.add(new JLabel(""));
        pRight.add(username_);
        pRight.add(new JLabel(""));
        pRight.add(password_);

        JPanel pbtn = new JPanel();
        pbtn.setBackground(Color.white);
        pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //Button OK
        sign_up = new JButton("OK");
        sign_up.setBorder(null);
        sign_up.setBackground(Color.LIGHT_GRAY);
        sign_up.setBorder(BorderFactory.createMatteBorder(5, 20, 5, 20, Color.LIGHT_GRAY));
        sign_up.addActionListener(this);

        //Button Cancel
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.GRAY);
        cancel.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 10, Color.GRAY));
        cancel.addActionListener(this);

        pbtn.add(sign_up); pbtn.add(cancel);

        pcenter.add(pLeft); pcenter.add(pRight);
        this.add("Center", pcenter);
        this.add("South", pbtn);
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

        Authentication au = new Authentication();

        if(e.getSource() == cancel){
            this.dispose();
            au.setVisible(true);
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
                    JOptionPane.showMessageDialog(null, "Usuário já registrado!");
                    au.setVisible(true);
                }
                else{
                    User novoUsuario = new User(nome, username, password);
                    UserUtility.users.add(novoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuário "+username+" registrado com sucesso!");
                    au.setVisible(true);
                    this.dispose();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatorios: Nome e Password");
            }
        }



    }
}
