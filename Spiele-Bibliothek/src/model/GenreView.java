package model;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.LoginView;

public class GenreView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton home = new JButton("Home");
	private JButton genre = new JButton("Genre");
	private JButton warenkorb = new JButton("Warenkorb");
	private JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	JComboBox genreBox;

	public static void main(String[] args) {
		GenreView gui = new GenreView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public GenreView() {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		genreBox = new JComboBox(new Object[] {"Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
		final JPanel schaltflaeche = new JPanel(new GridLayout(1, 4));
		schaltflaeche.add(home);
		schaltflaeche.add(genre);
		schaltflaeche.add(warenkorb);
		schaltflaeche.add(bibliothek);
		
		final JPanel suche = new JPanel(new GridLayout(1, 1));
		suche.add(search);
		
		final JPanel panelOben = new JPanel();
		panelOben.add(schaltflaeche);
		panelOben.add(suche);
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(genreBox);
		
		final JPanel panelMitte = new JPanel();
		panelMitte.add(bewertung);
		
		add(panelOben, BorderLayout.NORTH);
		add(panelMitte, BorderLayout.CENTER);
	}

}
