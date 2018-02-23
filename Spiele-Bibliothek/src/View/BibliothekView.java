package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.Benutzer;

public class BibliothekView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JButton download = new JButton("Download");
	private JButton download2 = new JButton("Download");
	private JLabel cod = new JLabel(loadIcon("callOfDutyWWII.jpg"));
	private JLabel assasinsCreed = new JLabel(loadIcon("assassinsCreedOrigins.jpg"));
	private JLabel assasinsCreedText = new JLabel("TEXT");
	private JLabel codText = new JLabel("TEXT2");

	public BibliothekView(Benutzer benutzer) {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
	
		final JPanel images = new JPanel(new GridLayout(1, 1));
		images.add(cod);
		images.add(assasinsCreed);
		images.add(download);
		
//		final JPanel downloads = new JPanel(new GridLayout(1, 1));
//		downloads.add(download);
		
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

		
		
		add(images, BorderLayout.CENTER);
//		add(downloads, BorderLayout.SOUTH);
		
		
		
	}
}
