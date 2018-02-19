package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeView extends JFrame {
	protected JLabel searchIcon = new JLabel(loadIcon("search.png"));
	private static final long serialVersionUID = 4724085734802179441L;
	protected JButton homeButton = new JButton("Home");
	protected JButton genreButton = new JButton("Genre");
	protected JButton warenkorbButton = new JButton("Warenkorb");
	protected JButton bibliothekButton = new JButton("Bibliothek");
	protected JTextField searchField = new JTextField(20);
	protected JPanel northPanel = new JPanel(new GridLayout(1, 0));
	protected JPanel centerPanel = new JPanel(new FlowLayout());
	protected JTextArea textLabel = new JTextArea(5,20);
	
	public static void main(String[] args) {
		HomeView gui = new HomeView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public HomeView() {
		printMainMenu();
		
		textLabel.setEditable(false);
		textLabel.setBackground(getBackground());
		textLabel.setText("Lorem ipsum dolor sit amet, consetetur "
				+ "sadipscing elitr, sed diam nonumy eirmod tempor inv"
				+ "idunt ut labore et dolore magna aliquyam erat, sed diam vo"
				+ "luptua. At vero eos et accusam et justo duo dolores e"
				+ "t ea rebum. Stet clita kasd gubergren, no sea takimata "
				+ "sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dol"
				+ "or sit amet, consetetur sadipscing elitr, sed diam nonu"
				+ "my eirmod tempor invidunt ut labore et dolore magna aliquy"
				+ "am erat, sed diam voluptua. At vero eos et accusam et justo "
				+ "duo dolores et ea rebum. Stet clita kasd gubergren, no sea tak"
				+ "imata sanctus est Lorem ipsum dolor sit amet.");
		centerPanel.add(textLabel);
		add(centerPanel, BorderLayout.CENTER);
	}
	
	
	public void printMainMenu() {
		final JPanel buttonNavigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonNavigation.add(homeButton);
		buttonNavigation.add(genreButton);
		buttonNavigation.add(warenkorbButton);
		buttonNavigation.add(bibliothekButton);
		
		final JPanel buttonNavigation2 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,50));
		buttonNavigation2.add(buttonNavigation);
		
		final JPanel northSearchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		northSearchPanel.add(searchIcon);
		northSearchPanel.add(searchField);
		
		final JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,50));
		searchPanel.add(northSearchPanel);
	
		northPanel.add(buttonNavigation2);
		northPanel.add(searchPanel);
		add(northPanel, BorderLayout.NORTH);
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView homeview = new HomeView();
				homeview.setSize(1500, 900);
				homeview.setResizable(false);
				homeview.setVisible(true);
				setVisible(false);
			}
		});
		
		genreButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GenreView genreview = new GenreView();
				genreview.setSize(1500, 900);
				genreview.setResizable(false);
				genreview.setVisible(true);
				setVisible(false);
			}
		});
		
		warenkorbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WarenkorbView warenkorbview = new WarenkorbView();
				warenkorbview.setSize(1500, 900);
				warenkorbview.setResizable(false);
				warenkorbview.setVisible(true);
				setVisible(false);
			}
		});
		
		bibliothekButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BibliothekView bibliothekView = new BibliothekView();
				bibliothekView.setSize(1500, 900);
				bibliothekView.setResizable(false);
				bibliothekView.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	public static Icon loadIcon(String iconName) {
		final URL resource = LoginView.class.getResource("/images/" + iconName);

		if (resource == null) {
			System.err.println("Fehler: " + "/images/" + iconName);
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

}

