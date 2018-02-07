package View;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.BenutzerController;
import model.Benutzer;


public class LoginView extends JFrame {

	private static final long serialVersionUID = -7102879226099900568L;
	protected final static JTextField benutzername = new JTextField("", 20);
	protected static JPasswordField passwort = new JPasswordField("", 20);
	protected static JButton login = new JButton("LogIn");
	protected static JButton registNow = new JButton("Jetzt Registrieren");
	protected static JLabel benutzernameT = new JLabel("Benutzername:");
	protected static JLabel passwortT = new JLabel("Passwort:");
	protected JPanel southPanel = new JPanel();
	protected JLabel logo = new JLabel(loadIcon("Logo.png"));
	protected static JLabel meldung = new JLabel("");
	protected static JButton backToLogIn = new JButton("Zurück zum Log in");
	protected static JButton registrieren = new JButton("Registrieren");
	protected final static JTextField email = new JTextField();
	protected static JPasswordField passwortBestaetigen = new JPasswordField();
	protected JLabel emailT = new JLabel("E-Mail:");
	protected JLabel passwortBestaetigenT = new JLabel("Passwort bestätigen");
	
	public static void main(String[] args) {
		LoginView gui = new LoginView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
		registNow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Jetzt Registrieren")) {
					RegistrierenView regist = new RegistrierenView();
					regist.setSize(1000, 1000);
					regist.pack();
					regist.setVisible(true);
					gui.setVisible(false);
					meldung.setVisible(false);
				}
			}
			
		});
		
		//
		registrieren.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Registrieren")) {
					if(passwort.getText().equals(passwortBestaetigen.getText())) {
						Benutzer b = new Benutzer();
						b.setBenutzername(benutzername.getText());
						b.setEmail(email.getText());
						b.setPasswort(passwort.getText());
						BenutzerController.getUserController().registerBenutzer(b);
						
						System.out.println("Registrierung abgeschlossen");
						gui.setVisible(true);
//						regist.setVisible(false);
					}else {
						meldung.setText("Passwort stimmt nicht überrein");
						meldung.setForeground(Color.red);
						meldung.setVisible(true);
					}
					
				}
			}
			
		});
		
		//Login
		login.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("LogIn")) {
					Benutzer benutzer = BenutzerController.getUserController().searchPasswortByName(benutzername.getText());
					
					if (passwort.getText().equals(benutzer.getPasswort())) {
						GameView bl = new GameView();
						bl.setSize(1000, 1000);
						bl.pack();
						// gui.setResizable(false);
						bl.setVisible(true);
						gui.setVisible(false);
					}else {
						meldung.setText("Benutzername / Passwort ist ungültig!");
						meldung.setForeground(Color.red);
						meldung.setVisible(true);
					}
				}
			}
			
		});
		
		//LogIn
		backToLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("backToLogIn")) {
					gui.setVisible(true);
//					regist.setVisible(false);
				}
			}
			
		});
	}
	

	public LoginView() {
		printMainLogin();
		final JPanel loginLabelPanel = new JPanel(new GridLayout(0, 1));
		loginLabelPanel.add(benutzernameT);
		loginLabelPanel.add(passwortT);
		loginLabelPanel.add(new JLabel(""));
		
		final JPanel loginInputPanel = new JPanel(new GridLayout(0, 1));
		loginInputPanel.add(benutzername);
		loginInputPanel.add(passwort);
		loginInputPanel.add(meldung);
		
		final JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);
		
		add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);
	}

	
	public static Icon loadIcon(String iconName) {
		final URL resource = LoginView.class.getResource("/images/" + iconName);

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
