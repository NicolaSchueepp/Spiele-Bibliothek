package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Benutzer;

public class BibliothekView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JButton download = new JButton("Download");
	private JButton download2 = new JButton("Download");
	private JLabel logo = new JLabel(loadIcon("Logo.png"));
	private JLabel assasinsCreed = new JLabel(loadIcon("assassinsCreedOrigins.jpg"));
	private JLabel assasinsCreedText = new JLabel("TEXT");
	private JLabel logoText = new JLabel("TEXT2");

	public BibliothekView(Benutzer benutzer) {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		
		final JPanel gameView = new JPanel(new GridLayout(3, 1));
		gameView.add(logo);
		gameView.add(assasinsCreed);
		gameView.add(logoText);
		gameView.add(assasinsCreedText);
		gameView.add(download);
		gameView.add(download2);
		
		add(gameView, BorderLayout.SOUTH);
		
		
	}
}
