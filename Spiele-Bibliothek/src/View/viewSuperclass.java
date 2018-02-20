package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class viewSuperclass extends JFrame {

	private static final long serialVersionUID = 4971276353377865761L;
	protected JLabel searchIcon = new JLabel(loadIcon("search.png"));
	protected JButton homeButton = new JButton("Home");
	protected JButton spieleButton = new JButton("Shop");
	protected JButton warenkorbButton = new JButton("Warenkorb");
	protected JButton bibliothekButton = new JButton("Bibliothek");
	protected JTextField searchField = new JTextField(20);
	protected JPanel northPanel = new JPanel(new GridLayout(1, 0));
	
	public void printMainMenu() {
		
		final JPanel buttonNavigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonNavigation.add(homeButton);
		buttonNavigation.add(spieleButton);
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
		
		searchField.setText("Suchen");
		searchField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				searchField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				searchField.setText("Suchen");
			}
			
		});
		
		searchField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView shopView = new ShopView();
				shopView.setSize(1500, 900);
				shopView.setResizable(false);
				shopView.setVisible(true);
				setVisible(false);
			}
		});
		
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
		
		spieleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView genreview = new ShopView();
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
