package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.SpielController;
import model.Benutzer;
import model.Spiel;

public class BibliothekView extends viewSuperclass {

	private static final long serialVersionUID = 1L;

	public BibliothekView(Benutzer benutzer, List<Spiel> warenkorb) {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		final JPanel view = new JPanel(new GridLayout(0, 4));
		List<Spiel> liste = SpielController.getGameController().getKäufeByUser(benutzer.getId());
		
		for(Spiel spiel : liste) {
			final JPanelWithBackground game = new JPanelWithBackground(iconToImage(loadIcon(spiel.getCover())));
			
			JButton download = new JButton("Download");
			download.setOpaque(true);
			game.add(download, BorderLayout.SOUTH);
			game.setSize(250,312);
			
			view.add(game);
			download.setVisible(false);

			game.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					download.setVisible(false);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					download.setVisible(true);
					repaint();
				}

			});
			
			download.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					FileWriter writer;
					File datei = new File(spiel.getBezeichnung()+".txt");
					
					try {
						writer = new FileWriter(datei);
						writer.write("Viel Spass mit dem Spiel"+spiel.getBezeichnung());
						
						writer.flush();
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			download.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					download.setVisible(true);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					download.setVisible(true);
					repaint();
				}

			});
		}

		JScrollPane scrollPane = new JScrollPane(view, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane, BorderLayout.CENTER);

	}
}
