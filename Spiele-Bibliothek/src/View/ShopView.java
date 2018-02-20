package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ShopView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	JComboBox<Object> genreBox;

	public static void main(String[] args) {
		ShopView gui = new ShopView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
		
	}
	
	public ShopView() {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		printMainMenu();

		
		genreBox = new JComboBox<Object>(new Object[] {"--> Alle Spiele <--","Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(genreBox);
		
		final JPanel panelMitte = new JPanel();
		panelMitte.add(bewertung);
		
		add(panelMitte, BorderLayout.CENTER);
	}

}
