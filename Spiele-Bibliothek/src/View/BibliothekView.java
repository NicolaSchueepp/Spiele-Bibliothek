package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	protected static JButton home = new JButton("Home");
	protected static JButton genre = new JButton("Genre");
	protected static JButton warenkorb = new JButton("Warenkorb");
	protected static JButton bibliothek = new JButton("Bibliothek");
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
		
		
//		Genre
		genre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Genre")) {
					GenreView genre = new GenreView();
					genre.setSize(1000, 1000);
					genre.pack();
					genre.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
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
