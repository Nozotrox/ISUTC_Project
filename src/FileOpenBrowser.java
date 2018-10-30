import java.io.File;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FileOpenBrowser {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame("FileOpenBrowser"); // set API Name
        JPanel topPanel = new JPanel(new FlowLayout()); // set Panel Layout

        Button btn = new Button("Help");
        btn.setBounds(50, 100, 60, 30);
        topPanel.add(btn);

        frame.add(topPanel, BorderLayout.PAGE_START);

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Start..");
                    File file = new File("ISUTC_Project\\src\\hi.html");
                    Desktop.getDesktop().browse(file.toURI());
                    System.out.println("End..");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}