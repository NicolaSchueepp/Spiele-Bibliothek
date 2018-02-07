package datenbank;

import java.util.List;
import model.Benutzer;

public interface BenutzerDao {
	public abstract List<Benutzer> getAllBenutzer();
	public abstract Benutzer findUserByName();
}