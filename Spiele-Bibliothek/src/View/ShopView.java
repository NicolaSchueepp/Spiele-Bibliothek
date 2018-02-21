package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Benutzer;

public class ShopView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	JComboBox<String> genreBox;

	public static void main(String[] args) {
		ShopView gui = new ShopView(null);
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
		
	}
	
	public ShopView(Benutzer benutzer) {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		
		genreBox = new JComboBox<String>(new String[] {"--> Alle Spiele <--","Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
		final JPanel centerGenreBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerGenreBox.add(genreBox);
		
		final JPanel centerPanel = new JPanel();
		centerPanel.add(centerGenreBox);
		
		add(centerPanel, BorderLayout.CENTER);
		
	}

}
