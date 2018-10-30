
package Screens;

import javax.naming.AuthenticationException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main_Classes.User;

import Main.*;

public class saleFrame extends JFrame implements ActionListener {

    JTextField codigo_, nome_, quant_, stockmin_, armazem_;
    JComboBox fornecedor;

    JButton cancel;
    JButton sign_up;

    String user;

    private ImageIcon icon;

    public saleFrame(String u){
        user = u;
        build_ui();
    }

    public saleFrame(){
        build_ui();
    }

    public void build_ui(){

        setPreferredSize(new Dimension(400, 250));
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.setBackground(Color.white);

        JPanel pcenter = new JPanel();
        pcenter.setBackground(Color.white);
        pcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        icon = new ImageIcon("ISUTC_Product/img/addUser.png");
        JLabel title = new JLabel(icon);
        title.setFont(new Font("AriaL", Font.BOLD, 25));
        pcenter.add(title);

        // Left Side
        JPanel pLeft = new JPanel();
        pLeft.setBackground(Color.white);
        pLeft.setLayout(new GridLayout(7,1));

        pLeft.add(new JLabel("Produto: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Preço/unidade: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Quantidade: "));
        pLeft.add(new JLabel(""));
        pLeft.add(new JLabel("Preço Total: "));


        // Right Side
        JPanel pRight = new JPanel();
        pRight.setBackground(Color.white);
        pRight.setLayout(new GridLayout(7, 1));

        armazem_ = new JPasswordField(12);
        armazem_ .setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        nome_ = new JTextField(12);
        nome_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        stockmin_ = new JTextField(12);
        stockmin_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        quant_ = new JTextField(12);
        quant_.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        pRight.add(armazem_);
        pRight.add(new JLabel(""));
        pRight.add(stockmin_);
        pRight.add(new JLabel(""));
        pRight.add(quant_);
        pRight.add(new JLabel(""));
        pRight.add(nome_);


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
        new saleFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
