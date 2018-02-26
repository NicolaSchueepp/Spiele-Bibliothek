package Controller;

import java.util.List;

import datenbank.SpielBewertungDao;
import datenbank.SpielBewertungJDBCDao;
import model.Benutzer;
import model.Bewertung;
import model.Spiel;
import model.spieleliste;

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
	
	public List<Bewertung> searchAllBewertungenbyID(int id) {
		return SPIELBEWERTUNG_DAO.getAllBewertungenbyID(id);
	}
	
	public void addBewertung(Benutzer benutzer, Spiel game ,int bewertung) {
		SPIELBEWERTUNG_DAO.addBewertung(benutzer, game, bewertung);
	}
	
	public List<spieleliste> getAlleKäufe() {
		return SPIELBEWERTUNG_DAO.getAlleKäufe();
	}
	
	public void addKauf(spieleliste spieleliste) {
		SPIELBEWERTUNG_DAO.addKauf(spieleliste);
	}
	
	public List<Spiel> getKäufeByUser(int id) {
		return SPIELBEWERTUNG_DAO.getKäufeByUser(id);
	}
	
	public List<Spiel> getGamesByName(String gamename){
		return SPIELBEWERTUNG_DAO.getGamesByName(gamename);
	}
}
