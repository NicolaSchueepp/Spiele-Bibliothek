package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.Benutzer;
import model.Spiel;

public class BibliothekView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JButton download = new JButton("Download");
	private JButton download2 = new JButton("Download");
	private JLabel cod = new JLabel(loadIcon("callOfDutyWWII.jpg"));
	private JLabel assasinsCreed = new JLabel(loadIcon("assassinsCreedOrigins.jpg"));
	private JLabel assasinsCreedText = new JLabel("TEXT");
	private JLabel codText = new JLabel("TEXT2");

	public BibliothekView(Benutzer benutzer, List<Spiel> warenkorb) {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		
		final JPanel images = new JPanel(new GridLayout(2, 1));
		images.add(assasinsCreed);
		
		final JPanel game = new JPanel(new GridLayout(1, 1));
		game.add(cod);
		game.add(download);
		
		final JPanel view = new JPanel(new FlowLayout(FlowLayout.LEFT));
		view.add(game);
		view.add(images);
		
		download.setVisible(false);

		cod.addMouseListener(new MouseAdapter() {
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
		


		
		add(view, BorderLayout.CENTER);
		
		
		
	}
//	@Override
//	  protected void paintComponent(Graphics g) {
//
//	    super.paintComponent(g);
//	        g.drawImage(bgImage, 0, 0, null);
//	}
}
