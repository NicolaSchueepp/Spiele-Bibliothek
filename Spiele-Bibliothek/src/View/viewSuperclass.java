package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Benutzer;
import model.Spiel;

public class viewSuperclass extends JFrame {

	private static final long serialVersionUID = 4971276353377865761L;
	protected JLabel searchIcon = new JLabel(loadIcon("search.png"));
	protected JButton homeButton = new JButton("Home");
	protected JButton shopButton = new JButton("Shop");
	protected JButton warenkorbButton = new JButton("Warenkorb");
	protected JButton bibliothekButton = new JButton("Bibliothek");
	protected JTextField searchField = new JTextField(20);
	protected JPanel northPanel = new JPanel(new GridLayout(0, 2));
	protected JButton ausloggenButton = new JButton("Ausloggen");

	public void addMainMenu(Benutzer benutzer, List<Spiel> warenkorb) {

		final JPanel buttonNavigation = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonNavigation.add(homeButton);
		buttonNavigation.add(shopButton);
		buttonNavigation.add(warenkorbButton);
		buttonNavigation.add(bibliothekButton);

		final JPanel buttonNavigation2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 50));
		buttonNavigation2.add(buttonNavigation);

		final JPanel northSearchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		northSearchPanel.add(searchIcon);
		northSearchPanel.add(searchField);
		northSearchPanel.add(ausloggenButton);

		final JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 50));
		searchPanel.add(northSearchPanel);

		northPanel.add(buttonNavigation2);
		northPanel.add(searchPanel);
		add(northPanel, BorderLayout.NORTH);

		searchField.setText("Suchen");
		searchField.setFont(new Font("Open Sans", 0, 15));
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

		ausloggenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView loginview = new LoginView();
				loginview.setSize(1000, 1000);
				loginview.pack();
				loginview.setResizable(false);
				loginview.setVisible(true);
				loginview.setLocation(getLocation());
				setVisible(false);
			}
		});

		searchField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView shopView = new ShopView(benutzer, warenkorb);
				shopView.setSize(1500, 900);
				shopView.setResizable(false);
				shopView.setVisible(true);
				shopView.setLocation(getLocation());
				setVisible(false);
			}
		});
		homeButton.setFont(new Font("Open Sans", 0, 15));
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView homeview = new HomeView(benutzer, warenkorb);
				homeview.setSize(1500, 900);
				homeview.setResizable(false);
				homeview.setVisible(true);
				homeview.setLocation(getLocation());
				setVisible(false);
			}
		});
		shopButton.setFont(new Font("Open Sans", 0, 15));
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
		warenkorbButton.setFont(new Font("Open Sans", 0, 15));
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
		bibliothekButton.setFont(new Font("Open Sans", 0, 15));
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
				ShopView shopView = new ShopView(benutzer, warenkorb);
				shopView.setSize(1500, 900);
				shopView.setResizable(false);
				shopView.setVisible(true);
				shopView.setLocation(getLocation());
				setVisible(false);
			}
		});

		warenkorbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WarenkorbView warenkorbview = new WarenkorbView(benutzer, warenkorb);
				warenkorbview.setSize(1500, 900);
				warenkorbview.setResizable(false);
				warenkorbview.setVisible(true);
				warenkorbview.setLocation(getLocation());
				setVisible(false);
			}
		});

		bibliothekButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BibliothekView bibliothekView = new BibliothekView(benutzer, warenkorb);
				bibliothekView.setSize(1500, 900);
				bibliothekView.setResizable(false);
				bibliothekView.setVisible(true);
				bibliothekView.setLocation(getLocation());
				setVisible(false);
			}
		});

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
		ausloggenButton.setFont(new Font("Open Sans", 0, 15));
		ausloggenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

	public static Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon) {
			return ((ImageIcon) icon).getImage();
		} else {
			BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
					BufferedImage.TYPE_INT_RGB);
			icon.paintIcon(null, image.getGraphics(), 0, 0);
			return image;
		}
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}
}
