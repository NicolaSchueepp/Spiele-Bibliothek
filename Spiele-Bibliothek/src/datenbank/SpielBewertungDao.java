package datenbank;

import model.Spiel;

public interface SpielBewertungDao {
	public abstract Spiel[] findTopGamesCover();
}
