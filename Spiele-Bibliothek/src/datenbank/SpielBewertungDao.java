package datenbank;

import java.util.List;

import model.Spiel;

public interface SpielBewertungDao {
	public abstract List<Spiel> findTopGames();
	public abstract List<Spiel> findGamesByGenre();
	public abstract List<Spiel> findAllGames();
}
