package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class GenreView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	JComboBox<Object> genreBox;

	public static void main(String[] args) {
		GenreView gui = new GenreView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
		
	}
	
	public GenreView() {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		printMainMenu();

		
		genreBox = new JComboBox<Object>(new Object[] {"Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(genreBox);
		
		final JPanel panelMitte = new JPanel();
		panelMitte.add(bewertung);
		
		add(panelMitte, BorderLayout.CENTER);
	}

}
