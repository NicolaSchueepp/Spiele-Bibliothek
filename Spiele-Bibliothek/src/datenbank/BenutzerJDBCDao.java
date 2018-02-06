package datenbank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenutzerJDBCDao implements BenutzerDao {

	private Connection con = null;

	public BenutzerJDBCDao(Connection connection) {
		con = connection;
	}

	public List<Benutzer> getAllBenutzer() {
		try {
		  List<Benutzer> benutzer = new ArrayList<Benutzer>();
			Benutzer p = null;
			String sql = "SELECT * from benutzer";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				p = new Benutzer();
				p.setId(rs.getInt("Id"));
				p.setBenutzername(rs.getString("Benutzername"));
				p.setPasswort(rs.getString("passwort"));
				benutzer.add(p);
			}
			return benutzer;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}