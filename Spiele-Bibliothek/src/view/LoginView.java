package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = -7102879226099900568L;
	private final JTextField benutzername = new JTextField("");
	private final JTextField email = new JTextField();
	private JPasswordField passwort = new JPasswordField();
	private JPasswordField passwortBestätigen = new JPasswordField();
	private JButton login = new JButton("LogIn");
	private JButton registrieren = new JButton("Registrieren");
	private JPanel panelunten = new JPanel();
	private JPanel paneloben = new JPanel();
	private JPanel paddingleft = new JPanel();
	private JPanel paddingright = new JPanel();
	
	public static void main(String[] args) {
		LoginView gui = new LoginView();
		gui.setSize(1000, 1000);
		gui.setVisible(true);
		
	}
	
	public LoginView() {
		paddingleft.setSize(200, 200);
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panelunten, BorderLayout.SOUTH);
		add(paneloben, BorderLayout.CENTER);
		add(paddingright, BorderLayout.EAST);
		add(paddingleft, BorderLayout.WEST);
		panelunten.add(login, BorderLayout.SOUTH);
		panelunten.add(registrieren, BorderLayout.SOUTH);
		paneloben.add(new JLabel("Benutzername:"), BorderLayout.CENTER);
		paneloben.add(benutzername, BorderLayout.CENTER);
		paneloben.add(new JLabel("Passwort:"), BorderLayout.CENTER);
		paneloben.add(passwort, BorderLayout.CENTER);
		paneloben.setLayout(new GridLayout(0, 2));
	}

}
