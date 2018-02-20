package Controller;

import datenbank.SpielBewertungDao;
import datenbank.SpielBewertungJDBCDao;
import model.Spiel;

public class SpielController {
	private static final SpielController GAME_CONTROLLER = new SpielController();
	
	private SpielController() {}
	
	public static SpielController getGameController() {
		return SpielController.GAME_CONTROLLER;
	}
	
	private final SpielBewertungDao SPIELBEWERTUNG_DAO = new SpielBewertungJDBCDao();
	
	public Spiel[] searchTopGames() {
		return SPIELBEWERTUNG_DAO.findTopGamesCover();
	}
}
