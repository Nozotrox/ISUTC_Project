/**
 * 
 */
package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

/**
 * @author MSI
 *
 */
public class Splash extends JFrame {

	JProgressBar progressBar;

	public Splash() {
		setLayout(new BorderLayout());
		UIManager.put("ProgressBar.background", Color.decode("#a16598"));
		UIManager.put("ProgressBar.foreground", Color.decode("#e48397"));
		UIManager.put("ProgressBar.selectionBackground", Color.WHITE);
		UIManager.put("ProgressBar.selectionForeground", Color.WHITE);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);

		JPanel aux = new JPanel() {
			@Override
			protected void paintComponent(Graphics arg0) {
				// BACKGROUND
				arg0.drawImage(new ImageIcon("img\\bg.jpg").getImage(), 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				// BACKGROUND 2 VEZES
				return new Dimension(new ImageIcon("img\\bg.jpg").getIconWidth(),
						new ImageIcon("ISUTC_Project\\img\\bg.jpg").getIconHeight());
			}
		};
		add("Center", aux);
		add("South", progressBar);
		setSize(new ImageIcon("img\\bg.jpg").getIconWidth() - 500, new ImageIcon("img\\bg.jpg").getIconHeight() - 500);
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
