package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.BenutzerController;

public class GenreView extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static JButton home = new JButton("Home");
	protected static JButton genre = new JButton("Genre");
	protected static JButton warenkorb = new JButton("Warenkorb");
	protected static JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	JComboBox<Object> genreBox;

	public static void main(String[] args) {
		GenreView gui = new GenreView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
//		Home
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Home")) {
					HomeView home = new HomeView();
					home.setSize(1000, 1000);
					home.pack();
					home.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
//		Warenkorb
		warenkorb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Warenkorb")) {
					WarenkorbView warenkorb = new WarenkorbView();
					warenkorb.setSize(1000, 1000);
					warenkorb.pack();
					warenkorb.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
		
//		Bibliothek
		bibliothek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Bibliothek")) {
					BibliothekView bibliothek = new BibliothekView();
					bibliothek.setSize(1000, 1000);
					bibliothek.pack();
					bibliothek.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
	}
	
	public GenreView() {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		genreBox = new JComboBox<Object>(new Object[] {"Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
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
