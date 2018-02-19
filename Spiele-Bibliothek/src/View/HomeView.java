package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomeView extends JFrame {
	protected JLabel searchIcon = new JLabel(loadIcon("search.png"));
	private static final long serialVersionUID = 4724085734802179441L;
	protected JButton homeButton = new JButton("Home");
	protected JButton genreButton = new JButton("Genre");
	protected JButton warenkorbButton = new JButton("Warenkorb");
	protected JButton bibliothekButton = new JButton("Bibliothek");
	protected JTextField searchField = new JTextField(20);
	protected JPanel northPanel = new JPanel(new GridLayout(1, 0));
	
	
	public static void main(String[] args) {
		HomeView gui = new HomeView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public HomeView() {
		printMainMenu();
	}
	
	
	public void printMainMenu() {
		final JPanel buttonNavigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonNavigation.add(homeButton);
		buttonNavigation.add(genreButton);
		buttonNavigation.add(warenkorbButton);
		buttonNavigation.add(bibliothekButton);
		
		final JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		searchPanel.add(searchField);
		
		northPanel.add(buttonNavigation);
		northPanel.add(searchPanel);
		add(northPanel, BorderLayout.NORTH);
	}
	
	public static Icon loadIcon(String iconName) {
		final URL resource = LoginView.class.getResource("/images/" + iconName);

		if (resource == null) {
			System.err.println("Fehler: " + "/images/" + iconName);
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

}

