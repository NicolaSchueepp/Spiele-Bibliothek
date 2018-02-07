package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BibliothekView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton home = new JButton("Home");
	private JButton genre = new JButton("Genre");
	private JButton warenkorb = new JButton("Warenkorb");
	private JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	private JButton download = new JButton("Download");
	private JButton download2 = new JButton("Download");
	private JLabel logo = new JLabel(loadIcon("Logo.png"));
	private JLabel assasinsCreed = new JLabel(loadIcon("Assassin’s-Creed-Origins.jpg"));
	private JLabel assasinsCreedText = new JLabel("TEXT");
	private JLabel logoText = new JLabel("TEXT2");

	public static void main(String[] args) {
		BibliothekView gui = new BibliothekView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public BibliothekView() {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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

		
		final JPanel gameView = new JPanel(new GridLayout(3, 1));
		gameView.add(logo);
		gameView.add(assasinsCreed);
		gameView.add(logoText);
		gameView.add(assasinsCreedText);
		gameView.add(download);
		gameView.add(download2);
		
		
		add(panelOben, BorderLayout.CENTER);
		add(gameView, BorderLayout.SOUTH);
	}
		
		
	private static Icon loadIcon(String iconName) {
		final URL resource = LoginView.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Fehler: " + "/images/" + iconName);
			return new ImageIcon();
		}
		return new ImageIcon(resource);	
	}
}
