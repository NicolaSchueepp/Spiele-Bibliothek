package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.BenutzerController;
import model.Benutzer;

public class RegistrierenView extends LoginView {
	private static final long serialVersionUID = -7102879226099900568L;

	public static void main(String[] args) {
		RegistrierenView gui = new RegistrierenView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public RegistrierenView() {
		this.printMainLogin();
		printRegistrieren();
		getRootPane().setDefaultButton(registrieren);
		// Registrieren
		registrieren.addActionListener(new ActionListener() {
			

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (email.getText().equals("*")) {
					meldung.setText("Invalide Email Adresse!");
					meldung.setForeground(Color.red);
					meldung.setVisible(true);
				} else if (benutzername.getText().length() < 7) {
					meldung.setText("Benutzername zu kurz!");
					meldung.setForeground(Color.red);
					meldung.setVisible(true);
				} else if (!passwort.getText().equals(passwortBestaetigen.getText()) && passwort.getText().length() > 4) {
					meldung.setText("Passwoerter stimmen nicht überein!");
					meldung.setForeground(Color.red);
					meldung.setVisible(true);
				} else {
					Benutzer b = new Benutzer();
					b.setBenutzername(benutzername.getText());
					b.setEmail(email.getText());
					b.setPasswort(passwort.getText());
					BenutzerController.getUserController().registerBenutzer(b);
					System.out.println("Benutzer Registriert!!!");
					LoginView loginview = new LoginView();
					loginview.setSize(1000, 1000);
					loginview.pack();
					loginview.setResizable(false);
					loginview.setVisible(true);
					meldung.setVisible(false);
					setVisible(false);
				}
			}

		});
		
		//BackToLogIn
		backToLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView loginview = new LoginView();
				loginview.setSize(1000, 1000);
				loginview.pack();
				loginview.setResizable(false);
				loginview.setVisible(true);
				meldung.setVisible(false);
				setVisible(false);
			}

		});
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
		JPanel registrierenLabelPanel = new JPanel(new GridLayout(0, 1));
		registrierenLabelPanel.add(emailT);
		registrierenLabelPanel.add(benutzernameT);
		registrierenLabelPanel.add(passwortT);
		registrierenLabelPanel.add(passwortBestaetigenT);
		registrierenLabelPanel.add(new JLabel(""));

		JPanel registrierenInputPanel = new JPanel(new GridLayout(0, 1));
		registrierenInputPanel.add(email);
		registrierenInputPanel.add(benutzername);
		registrierenInputPanel.add(passwort);
		registrierenInputPanel.add(passwortBestaetigen);
		registrierenInputPanel.add(meldung);

		JPanel registrierenPanel = new JPanel();
		registrierenPanel.add(registrierenLabelPanel);
		registrierenPanel.add(registrierenInputPanel);

		add(registrierenPanel, BorderLayout.CENTER);
	}

}
