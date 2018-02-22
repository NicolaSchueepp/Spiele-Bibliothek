package Controller;

import java.util.List;

import datenbank.SpielBewertungDao;
import datenbank.SpielBewertungJDBCDao;
import model.Spiel;

public class SpielController {
	private static final SpielController GAME_CONTROLLER = new SpielController();

	private SpielController() {
	}

	public static SpielController getGameController() {
		return SpielController.GAME_CONTROLLER;
	}

	private final SpielBewertungDao SPIELBEWERTUNG_DAO = new SpielBewertungJDBCDao();

	public List<Spiel> searchTopGames() {
		return SPIELBEWERTUNG_DAO.findTopGames();
	}

	public List<Spiel> searchAllGames() {
		return SPIELBEWERTUNG_DAO.findAllGames();
	}

	public List<Spiel> searchGamesByGenre(String genre) {
		return SPIELBEWERTUNG_DAO.findGamesByGenre(genre);
	}
	
	public String[] getAllGenres() {
		return SPIELBEWERTUNG_DAO.getAllGenres();
	}
}
