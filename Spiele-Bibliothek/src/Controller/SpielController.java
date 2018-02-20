package Controller;

import datenbank.SpielBewertungDao;
import datenbank.SpielBewertungJDBCDao;

public class SpielController {
	private static final SpielController GAME_CONTROLLER = new SpielController();
	
	private SpielController() {}
	
	public static SpielController getGameController() {
		return SpielController.GAME_CONTROLLER;
	}
	
	private final SpielBewertungDao SPIELBEWERTUNG_DAO = new SpielBewertungJDBCDao();
	
	public String[] searchTopGames() {
		return SPIELBEWERTUNG_DAO.findTopGamesCover();
	}
}