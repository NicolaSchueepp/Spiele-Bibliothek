package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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

		JPanel centerGamesPanel = new JPanel(new GridLayout(0, 5));
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
		int counter = 1;
		for(Spiel spiel : spiele) {
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
			
		}
//		final JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 20, 0, 300);
//		scrollBar.addAdjustmentListener(new MyAdjustmentListener());
		
		final JPanel centerSouthPanel = new JPanel();
		centerSouthPanel.add(centerGamesPanel, BorderLayout.CENTER);
//		centerSouthPanel.add(scrollBar, BorderLayout.EAST);
		
		final JPanel centerNorthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
		centerNorthPanel.add(centerGenreBox, BorderLayout.NORTH);
		
		final JPanel centerPanel = new JPanel();
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerPanel.add(centerSouthPanel, BorderLayout.CENTER);

		add(centerPanel, BorderLayout.CENTER);

	}
	
	class MyAdjustmentListener implements AdjustmentListener {
	    public void adjustmentValueChanged(AdjustmentEvent e) {	
	      repaint();
	    }
	  }

}
