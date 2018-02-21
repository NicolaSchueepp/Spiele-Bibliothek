package datenbank;

import java.util.List;

import javax.swing.JComboBox;

import model.Spiel;

public interface SpielBewertungDao {
	public abstract List<Spiel> findTopGames();

	public abstract List<Spiel> findGamesByGenre(String genre);

	public abstract List<Spiel> findAllGames();
	
	public abstract String[] getAllGenres();
}
