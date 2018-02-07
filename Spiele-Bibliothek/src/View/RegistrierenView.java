package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.BenutzerController;
import model.Benutzer;

public class RegistrierenView extends LoginView{
	private static final long serialVersionUID = -7102879226099900568L;
	
	public static void main(String[] args) {
		RegistrierenView gui = new RegistrierenView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
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
						LoginView loginSicht = new LoginView();
						loginSicht.setSize(1000, 1000);
						loginSicht.pack();
						loginSicht.setResizable(false);
						loginSicht.setVisible(true);
						gui.setVisible(false);
					}else {
						meldung.setText("Passwort stimmt nicht überrein");
						meldung.setForeground(Color.red);
						meldung.setVisible(true);
					}
					
				}
			}
			
		});
		
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
		
		backToLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				LoginView a = new LoginView();
				a.setSize(1000, 1000);
				a.pack();
				a.setResizable(false);
				a.setVisible(true);
				gui.setVisible(false);
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
		southPanel.add(backToLogIn);
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
		registrierenLabelPanel.add(new JLabel(""));
		
		final JPanel registrierenInputPanel = new JPanel(new GridLayout(0, 1));
		registrierenInputPanel.add(email);
		registrierenInputPanel.add(benutzername);
		registrierenInputPanel.add(passwort);
		registrierenInputPanel.add(passwortBestaetigen);
		registrierenInputPanel.add(meldung);
		
		final JPanel registrierenPanel = new JPanel();
		registrierenPanel.add(registrierenLabelPanel);
		registrierenPanel.add(registrierenInputPanel);
		
		add(registrierenPanel, BorderLayout.CENTER);
	}
	
}
