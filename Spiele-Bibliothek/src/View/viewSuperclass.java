package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Benutzer;

public class viewSuperclass extends JFrame {

	private static final long serialVersionUID = 4971276353377865761L;
	protected JLabel searchIcon = new JLabel(loadIcon("search.png"));
	protected JButton homeButton = new JButton("Home");
	protected JButton shopButton = new JButton("Shop");
	protected JButton warenkorbButton = new JButton("Warenkorb");
	protected JButton bibliothekButton = new JButton("Bibliothek");
	protected JTextField searchField = new JTextField(20);
	protected JPanel northPanel = new JPanel(new GridLayout(1, 0));
	
	public void addMainMenu(Benutzer benutzer) {
		
		final JPanel buttonNavigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonNavigation.add(homeButton);
		buttonNavigation.add(shopButton);
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
		searchField.setFont(new Font("Open Sans", 15, 15));
		searchField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("Suchen")) {
					searchField.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().equals("")) {
					searchField.setText("Suchen");
				}
			}
			
		});
		
		searchField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView shopView = new ShopView(benutzer);
				shopView.setSize(1500, 900);
				shopView.setResizable(false);
				shopView.setVisible(true);
				setVisible(false);
			}
		});
		homeButton.setFont(new Font("Open Sans", 15, 15));
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView homeview = new HomeView(benutzer);
				homeview.setSize(1500, 900);
				homeview.setResizable(false);
				homeview.setVisible(true);
				setVisible(false);
			}
		});
		shopButton.setFont(new Font("Open Sans", 15, 15));
		shopButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		warenkorbButton.setFont(new Font("Open Sans", 15, 15));
		warenkorbButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		bibliothekButton.setFont(new Font("Open Sans", 15, 15));
		bibliothekButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		shopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView shopView = new ShopView(benutzer);
				shopView.setSize(1500, 900);
				shopView.setResizable(false);
				shopView.setVisible(true);
				setVisible(false);
			}
		});
		
		warenkorbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WarenkorbView warenkorbview = new WarenkorbView(benutzer);
				warenkorbview.setSize(1500, 900);
				warenkorbview.setResizable(false);
				warenkorbview.setVisible(true);
				setVisible(false);
			}
		});
		
		bibliothekButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BibliothekView bibliothekView = new BibliothekView(benutzer);
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
