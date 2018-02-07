package datenbank;

import model.Benutzer;

public interface BenutzerDao {
	public abstract Benutzer findPasswortByName(String name);
	public void addBenutzer(Benutzer benutzer);
}