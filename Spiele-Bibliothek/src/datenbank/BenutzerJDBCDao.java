package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.UserNotFoundException;
import model.Benutzer;

public class BenutzerJDBCDao implements BenutzerDao {
	
	private final Connection con = ConnectionFactory.getInstance().getConnection();

	@Override
	public Benutzer findPasswortByName(String name) {
		final String SQL = "select passwort from benutzer where benutzername = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Benutzer benutzer = null;
		
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				benutzer = new Benutzer();
				benutzer.setPasswort(rs.getString("passwort"));
				break;
			}
		} catch(SQLException e) {
			throw new RuntimeException("Oh oh", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Oh oh", e);
			}
		}
		
		if (benutzer != null) {
			return benutzer;
		}else {
			throw new UserNotFoundException("No user with Name "+name +" found.");
		}		
	}

	@Override
	public Benutzer addBenutzer(String benutzername, String passwort, String email) {
		final String SQL = "insert into benutzer (Benutzername, Passwort, Email) Values(?, ?, ?)";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Benutzer benutzer = null;
		
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, benutzername);
			ps.setString(2, passwort);
			ps.setString(3, email);
			rs = ps.executeQuery();

		} catch(SQLException e) {
			throw new RuntimeException("Oh oh", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Oh oh", e);
			}
		}
		return benutzer;
	}
}