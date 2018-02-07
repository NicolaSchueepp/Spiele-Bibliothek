package Controller;

import datenbank.BenutzerDao;
import datenbank.BenutzerJDBCDao;
import model.Benutzer;

public class BenutzerController {
	
	private static final BenutzerController USER_CONTROLLER = new BenutzerController();
	
	private BenutzerController() {}
	
	public static BenutzerController getUserController() {
		return BenutzerController.USER_CONTROLLER;
	}
	
	private final BenutzerDao BENUTZER_DAO = new BenutzerJDBCDao();
	
	public Benutzer searchPasswortByName(String name) {
		return BENUTZER_DAO.findPasswortByName(name);
	}
}
