package datenbank;

import model.Benutzer;

public interface BenutzerDao {
	public abstract Benutzer findPasswortByName(String name);
	public abstract Benutzer addBenutzer(String benutzername, String passwort, String email);
}