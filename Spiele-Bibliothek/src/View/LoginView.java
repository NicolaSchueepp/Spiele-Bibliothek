package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class LoginView extends JFrame {

	private static final long serialVersionUID = -7102879226099900568L;
	protected final JTextField benutzername = new JTextField("", 20);
	protected JPasswordField passwort = new JPasswordField("", 20);
	protected JButton login = new JButton("LogIn");
	protected static JButton registrieren = new JButton("Registrieren");
	protected JLabel benutzernameT = new JLabel("Benutzername:");
	protected JLabel passwortT = new JLabel("Passwort:");
	protected JPanel southPanel = new JPanel();
	protected JLabel logo = new JLabel(loadIcon("Logo.png"));
	
	

	public static void main(String[] args) {
		LoginView gui = new LoginView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
		registrieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Registrieren")) {
					RegistrierenView regist = new RegistrierenView();
					regist.setSize(1000, 1000);
					regist.pack();
					regist.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
	}
	

	public LoginView() {
		printMainLogin();
		printLogin();
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
		southPanel.add(registrieren);
		add(southPanel, BorderLayout.SOUTH);
		add(logo, BorderLayout.NORTH);
	}
	
	public void printLogin() {
		final JPanel loginLabelPanel = new JPanel(new GridLayout(0, 1));
		loginLabelPanel.add(benutzernameT);
		loginLabelPanel.add(passwortT);
		
		final JPanel loginInputPanel = new JPanel(new GridLayout(0, 1));
		loginInputPanel.add(benutzername);
		loginInputPanel.add(passwort);
		
		final JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);
		
		add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);
	}
	
}
