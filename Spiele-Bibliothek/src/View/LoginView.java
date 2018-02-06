package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	//private ImageIcon logo = new ImageIcon("Logo.jpg");
	//private JLabel logolabel = new JLabel(logo);

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
		//add(logolabel, BorderLayout.NORTH);
	}
	public void MainView() {
		
	}
}
