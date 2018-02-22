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
	public Benutzer findUserByName(String name) {
		final String SQL = "select * from benutzer where benutzername = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Benutzer benutzer = null;

		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			rs = ps.executeQuery();

			while (rs.next()) {
				benutzer = new Benutzer();
				benutzer.setId(rs.getInt("ID"));
				benutzer.setBenutzername(rs.getString("Benutzername"));
				benutzer.setPasswort(rs.getString("passwort"));
				benutzer.setEmail(rs.getString("Email"));
				break;
			}
		} catch (SQLException e) {
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
		} else {
			throw new UserNotFoundException("No user with Name " + name + " found.");
		}
	}

	@Override
	public void addBenutzer(Benutzer benutzer) {
		final String SQL = "insert into benutzer (Benutzername, Passwort, Email) Values(?, ?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, benutzer.getBenutzername());
			ps.setString(2, benutzer.getPasswort());
			ps.setString(3, benutzer.getEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}