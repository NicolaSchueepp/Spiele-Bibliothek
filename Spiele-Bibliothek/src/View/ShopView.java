package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.SpielController;
import model.Benutzer;
import model.Spiel;

public class ShopView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	JPanel centerGamesPanel = new JPanel(new GridLayout(0, 5, 40, 40));
	final JPanel centerSouthPanel = new JPanel();
	final JPanel centerPanel = new JPanel(new GridLayout(1, 1));
	final JPanel northFilteringPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 37, 0));
	
	List<Spiel> spiele;
	final JComboBox<String> genreBox;

	public ShopView(Benutzer benutzer) {
		setTitle("Genre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		genreBox = new JComboBox<String>(SpielController.getGameController().getAllGenres());
		genreBox.insertItemAt("Alle Spiele", 0);
		genreBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((String)genreBox.getSelectedItem()).equals("Alle Spiele")) {
					centerGamesPanel.removeAll();
					spiele = SpielController.getGameController().searchAllGames();
					addGames(benutzer, spiele);
					repaint();
				} else {
					centerGamesPanel.removeAll();
					spiele = SpielController.getGameController()
							.searchGamesByGenre((String)genreBox.getSelectedItem());
					addGames(benutzer, spiele);
					repaint();
				}
			}
		});
		
		//Filter werden dem North Panel hinzugefügt
		northFilteringPanel.add(genreBox);
		getNorthPanel().add(northFilteringPanel);
		
		//ScrollPane wird erstellt
		JScrollPane scrollPane = new JScrollPane (centerSouthPanel, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		genreBox.setSelectedItem("Alle Spiele");

		centerSouthPanel.add(centerGamesPanel, BorderLayout.CENTER);

		centerPanel.add(scrollPane);
		add(centerPanel, BorderLayout.CENTER);
	}

	public void addGames(Benutzer benutzer, List<Spiel> spieletmp) {
		for (Spiel spiel : spieletmp) {
			JButton button = new JButton(loadIcon(spiel.getCover()));

			button.setBorder(null);
			button.setBackground(getBackground());
			centerGamesPanel.add(button);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			});

			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GameView game = new GameView(benutzer, spiel);
					game.setSize(1500, 900);
					game.setResizable(false);
					game.setVisible(true);
					setVisible(false);
				}
			});
			repaint();

		}
	}

}
