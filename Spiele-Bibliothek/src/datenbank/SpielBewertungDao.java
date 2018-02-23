package datenbank;

import java.util.List;

import model.Benutzer;
import model.Bewertung;
import model.Spiel;

public interface SpielBewertungDao {
	public abstract List<Spiel> findTopGames();

	public abstract List<Spiel> findGamesByGenre(String genre);

	public abstract List<Spiel> findAllGames();

	public abstract String[] getAllGenres();

	public abstract void addBewertung(Benutzer benutzer, Spiel spiel, int bewertung);

	public abstract List<Bewertung> getAllBewertungenbyID(int spielID);
}
