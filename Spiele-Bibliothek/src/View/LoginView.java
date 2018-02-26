package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.BenutzerController;
import exception.UserNotFoundException;
import model.Benutzer;
import model.Spiel;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1996805941238253797L;
	protected JTextField benutzername = new JTextField("", 20);
	protected JPasswordField passwort = new JPasswordField("", 20);
	protected JButton login = new JButton("LogIn");
	protected JButton registNow = new JButton("Jetzt Registrieren");
	protected JLabel benutzernameT = new JLabel("Benutzername:");
	protected JLabel passwortT = new JLabel("Passwort:");
	protected JPanel southPanel = new JPanel();
	protected JLabel logo = new JLabel(loadIcon("Logo.png"));
	protected JLabel meldung = new JLabel("");
	protected JButton backToLogIn = new JButton("Zurueck zum Log in");
	protected JButton registrieren = new JButton("Registrieren");
	protected JTextField email = new JTextField();
	protected JPasswordField passwortBestaetigen = new JPasswordField();
	protected JLabel emailT = new JLabel("E-Mail:");
	protected JLabel passwortBestaetigenT = new JLabel("Passwort bestaetigen");

	public static void main(String[] args) {
		LoginView gui = new LoginView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public LoginView() {
		printMainLogin();
		getRootPane().setDefaultButton(login);

		JPanel loginLabelPanel = new JPanel(new GridLayout(0, 1));
		loginLabelPanel.add(benutzernameT);
		loginLabelPanel.add(passwortT);
		loginLabelPanel.add(new JLabel(""));

		JPanel loginInputPanel = new JPanel(new GridLayout(0, 1));
		loginInputPanel.add(benutzername);
		loginInputPanel.add(passwort);
		loginInputPanel.add(meldung);

		JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);

		add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);

		// Jetzt Registrieren
		registNow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrierenView regist = new RegistrierenView();
				regist.setSize(1000, 1000);
				regist.pack();
				regist.setResizable(false);
				regist.setVisible(true);
				meldung.setVisible(false);
				regist.setLocation(getLocation());
				setVisible(false);
			}
		});

		// Login
		login.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Benutzer benutzer = null;
				try {
					benutzer = BenutzerController.getUserController().searchUserByName(benutzername.getText());
				} catch (UserNotFoundException b) {
					meldung.setText("Benutzername / Passwort ist ungueltig!");
					meldung.setForeground(Color.red);
					meldung.setVisible(true);
				}
				if (passwort.getText().equals(benutzer.getPasswort())) {
					List<Spiel> warenkorb = new ArrayList<Spiel>();
					HomeView homeview = new HomeView(benutzer, warenkorb);
					homeview.setSize(1500, 900);
					homeview.setResizable(false);
					homeview.setVisible(true);
					meldung.setVisible(false);
					homeview.setLocation(getLocation());
					setVisible(false);
				} else {
					meldung.setText("Benutzername / Passwort ist ungueltig!");
					meldung.setForeground(Color.red);
					meldung.setVisible(true);
				}
			}

		});
	}

	public Icon loadIcon(String iconName) {
		URL resource = LoginView.class.getResource("/images/" + iconName);

		if (resource == null) {
			System.err.println("Fehler: " + "/images/" + iconName);
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public void printMainLogin() {
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		southPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		southPanel.add(login);
		southPanel.add(registNow);
		add(southPanel, BorderLayout.SOUTH);
		add(logo, BorderLayout.NORTH);
	}

}
