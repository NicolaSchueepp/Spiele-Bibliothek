package datenbank;

import model.Benutzer;

public interface BenutzerDao {
	public abstract Benutzer findUserByName(String name);
	public abstract void addBenutzer(Benutzer benutzer);
}