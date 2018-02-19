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

public class GenreView extends HomeView {

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
		
		genreBox = new JComboBox<Object>(new Object[] {"Action", "Adventure", "Ego Shooter", "Gesellschaft", "Rollenspiel", "Simulation", "Sport"});
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(genreBox);
		
		final JPanel panelMitte = new JPanel();
		panelMitte.add(bewertung);
		
		add(panelMitte, BorderLayout.CENTER);
	}

}
