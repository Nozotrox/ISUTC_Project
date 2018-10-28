/**
 * 
 */
package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * @author MSI
 *
 */
public class Splash extends JFrame {

	JProgressBar progressBar;

	public Splash() {
		setLayout(new BorderLayout());
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		add("Center", new JLabel(new ImageIcon("img\\bg.jpg")));
		add("South", progressBar);
		setSize(new ImageIcon("img\\bg.jpg").getIconWidth() - 200, new ImageIcon("img\\bg.jpg").getIconHeight() - 200);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		runningPBar();
	}

	public void runningPBar() {
		int i = 0;// Creating an integer variable and intializing it to 0

		while (i <= 100) {
			try {
				Thread.sleep(50);// Pausing execution for 50 milliseconds
				progressBar.setValue(i);// Setting value of Progress Bar

				i++;
				if (i == 100) {
					dispose();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public Dimension getPreferredSize() {
		// BACKGROUND 2 VEZES
		return new Dimension(new ImageIcon("img\\bg.jpg").getIconWidth(),
				new ImageIcon("ISUTC_Project\\img\\bg.jpg").getIconHeight());
	}

}
