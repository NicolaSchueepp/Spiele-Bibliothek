package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Benutzer;
import model.Spiel;

public class SpielBewertungJDBCDao implements SpielBewertungDao {

	private final Connection con = ConnectionFactory.getInstance().getConnection();

	@Override
	public List<Spiel> findTopGames() {
		final String SQL = "Select id, bezeichnung, hersteller, preis, erscheinungsjahr, genre, beschreibung, cover from (select AVG(Bewertung) as bewertung, Game.ID as id, Game.Bezeichnung as bezeichnung, Game.Hersteller as hersteller, Game.Preis as preis, Game.Erscheinungsjahr as erscheinungsjahr, Game.Genre as genre, Game.Beschreibung as beschreibung, Game.Cover as cover  from bewertung  join Game on Bewertung.Game_ID=Game.ID  group BY Game_ID order by bewertung DESC LIMIT 4)T";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> topSpiele = new ArrayList<Spiel>();

		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();

			for (int i = 0; i < 4; i++) {
				while (rs.next()) {
					Spiel spiel = new Spiel();
					spiel.setId(rs.getInt("id"));
					spiel.setBezeichnung(rs.getString("bezeichnung"));
					spiel.setHersteller(rs.getString("Hersteller"));
					spiel.setPreis(rs.getFloat("preis"));
					spiel.setErscheinungsjahr(rs.getInt("erscheinungsjahr"));
					spiel.setGenre(rs.getString("genre"));
					spiel.setBeschreibung(rs.getString("beschreibung"));
					spiel.setCover(rs.getString("cover"));

					topSpiele.add(spiel);
					break;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("1", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("2", e);
			}
		}

		return topSpiele;
	}

	@SuppressWarnings("null")
	@Override
	public List<Spiel> findGamesByGenre(String genre) {
		final String SQL = "select * from Game where Genre = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> spiele = null;

		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, genre);
			rs = ps.executeQuery();

			while (rs.next()) {
				Spiel spieltmp = new Spiel();
				spieltmp.setId(rs.getInt("id"));
				spieltmp.setBezeichnung(rs.getString("bezeichnung"));
				spieltmp.setHersteller(rs.getString("Hersteller"));
				spieltmp.setPreis(rs.getFloat("preis"));
				spieltmp.setErscheinungsjahr(rs.getInt("erscheinungsjahr"));
				spieltmp.setGenre(rs.getString("genre"));
				spieltmp.setBeschreibung(rs.getString("beschreibung"));
				spieltmp.setCover(rs.getString("cover"));

				spiele.add(spieltmp);
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
		return spiele;
	}

	@Override
	public List<Spiel> findAllGames() {
		final String SQL = "select * from Game";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> alleSpiele = new ArrayList<Spiel>();

		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				Spiel spiel = new Spiel();
				spiel.setId(rs.getInt("id"));
				spiel.setBezeichnung(rs.getString("bezeichnung"));
				spiel.setHersteller(rs.getString("Hersteller"));
				spiel.setPreis(rs.getFloat("preis"));
				spiel.setErscheinungsjahr(rs.getInt("erscheinungsjahr"));
				spiel.setGenre(rs.getString("genre"));
				spiel.setBeschreibung(rs.getString("beschreibung"));
				spiel.setCover(rs.getString("cover"));

				alleSpiele.add(spiel);
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

		return alleSpiele;
	}

	@Override
	public String[] getAllGenres() {
		final String SQL = "select distinct(genre) from Game";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> genrestmp = new ArrayList<String>();
		
		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String genre = new String();
				genre = rs.getString("genre");
				genrestmp.add(genre);
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
		String[] genres = genrestmp.toArray(new String[genrestmp.size()]);
		for(int i = 0; i < genrestmp.size();i++) {
			genres[i] = genrestmp.get(i);
		}
		
		return genres;
	}

	@Override
	public void addBewertung(Benutzer benutzer, Spiel spiel, int bewertung) {
		final String SQL = "insert into bewertung (Game_ID, Benutzer_ID, Bewertung) Values(?, ?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQL);
			ps.setInt(1, spiel.getId());
			ps.setInt(2, benutzer.getId());
			ps.setInt(3, bewertung);
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
