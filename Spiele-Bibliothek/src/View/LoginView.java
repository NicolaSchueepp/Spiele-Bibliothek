package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Listener.LoginRegisterListener;

public class LoginView extends JFrame {

	private static final long serialVersionUID = -7102879226099900568L;
	private final JTextField benutzername = new JTextField("", 20);
	private final JTextField email = new JTextField();
	private JPasswordField passwort = new JPasswordField("", 20);
	private JPasswordField passwortBestaetigen = new JPasswordField();
	private JButton login = new JButton("LogIn");
	private JButton registrieren = new JButton("Registrieren");
	private JLabel benutzernameT = new JLabel("Benutzername:");
	private JLabel passwortT = new JLabel("Passwort:");
	private JPanel southPanel = new JPanel();
	private JLabel logo = new JLabel(loadIcon("Logo.png"));
	
	

	public static void main(String[] args) {
		LoginView gui = new LoginView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public LoginView() {
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
      
		southPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		southPanel.add(login);
		southPanel.add(registrieren);
		add(southPanel, BorderLayout.SOUTH);
		
		final JPanel loginLabelPanel = new JPanel(new GridLayout(2, 1));
		loginLabelPanel.add(benutzernameT);
		loginLabelPanel.add(passwortT);
		
		final JPanel loginInputPanel = new JPanel(new GridLayout(2, 1));
		loginInputPanel.add(benutzername);
		loginInputPanel.add(passwort);
		
		final JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);
		
		add(loginPanel, BorderLayout.CENTER);
		add(logo, BorderLayout.NORTH);
		
		login.addActionListener(new LoginRegisterListener());
	}
	public void MainView() {
		
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
