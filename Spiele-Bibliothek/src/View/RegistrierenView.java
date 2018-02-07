package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrierenView extends LoginView{
	private static final long serialVersionUID = -7102879226099900568L;
	private final JTextField email = new JTextField();
	private JPasswordField passwortBestaetigen = new JPasswordField();
	private JLabel emailT = new JLabel("E-Mail:");
	private JLabel passwortBestaetigenT = new JLabel("Passwort bestštigen");
	private JButton backToLogIn = new JButton("s");
	
	public static void main(String[] args) {
		RegistrierenView gui = new RegistrierenView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
		registrieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Registrieren")) {
					
				}
			}
			
		});
	}
	
	public RegistrierenView() {
		this.printMainLogin();
		printRegistrieren();
	}
	
	public void printMainLogin() {
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
      
		southPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		southPanel.add(registrieren);
		add(southPanel, BorderLayout.SOUTH);
		add(logo, BorderLayout.NORTH);
	}
	
	public void printRegistrieren() {
		final JPanel registrierenLabelPanel = new JPanel(new GridLayout(0, 1));
		registrierenLabelPanel.add(emailT);
		registrierenLabelPanel.add(benutzernameT);
		registrierenLabelPanel.add(passwortT);
		registrierenLabelPanel.add(passwortBestaetigenT);
		
		final JPanel registrierenInputPanel = new JPanel(new GridLayout(0, 1));
		registrierenInputPanel.add(email);
		registrierenInputPanel.add(benutzername);
		registrierenInputPanel.add(passwort);
		registrierenInputPanel.add(passwortBestaetigen);
		
		final JPanel registrierenPanel = new JPanel();
		registrierenPanel.add(registrierenLabelPanel);
		registrierenPanel.add(registrierenInputPanel);
		
		add(registrierenPanel, BorderLayout.CENTER);
	}
	
}
