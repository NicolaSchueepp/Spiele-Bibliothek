package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.SpielController;
import model.Benutzer;
import model.Spiel;

public class ShopView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	
	List<Spiel> spiele;
	final JComboBox<String> genreBox;

	public ShopView(Benutzer benutzer) {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		genreBox = new JComboBox<String>(SpielController.getGameController().getAllGenres());
		genreBox.insertItemAt("Alle Spiele", 0);

		final JPanel centerGenreBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerGenreBox.add(genreBox);

		JPanel centerGamesPanel = new JPanel(new GridLayout(5, 0));
		genreBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (genreBox.getSelectedItem().toString().equals("Alle Spiele")) {
					spiele = SpielController.getGameController().searchAllGames();
				} else {
					spiele = SpielController.getGameController().searchGamesByGenre(genreBox.getSelectedItem().toString());
				}
			}
		});
		
		genreBox.setSelectedItem("Alle Spiele");
		
		final JPanel centerSouthPanel = new JPanel(new GridLayout(0, 5));
		for() {
			
		}
		
		final JPanel centerPanel = new JPanel();
		centerPanel.add(centerGenreBox, BorderLayout.NORTH);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerPanel.add(centerSouthPanel);

		add(centerPanel, BorderLayout.CENTER);

	}

}
