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
	
	public Benutzer searchUserByName(String name) {
		return BENUTZER_DAO.findUserByName(name);
	}
	
	public void registerBenutzer(Benutzer benutzer) {
		BENUTZER_DAO.addBenutzer(benutzer);
	}
}
