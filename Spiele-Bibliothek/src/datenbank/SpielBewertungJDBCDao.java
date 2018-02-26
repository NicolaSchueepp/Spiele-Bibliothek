package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Benutzer;
import model.Bewertung;
import model.Spiel;
import model.spieleliste;

public class SpielBewertungJDBCDao implements SpielBewertungDao {

	private final Connection con = ConnectionFactory.getInstance().getConnection();

	@Override
	public List<Spiel> findTopGames() {
		final String SQL = "Select id, bezeichnung, hersteller, preis, erscheinungsjahr, genre, beschreibung, cover, video from (select AVG(Bewertung) as bewertung, Game.ID as id, Game.Bezeichnung as bezeichnung, Game.Hersteller as hersteller, Game.Preis as preis, Game.Erscheinungsjahr as erscheinungsjahr, Game.Genre as genre, Game.Beschreibung as beschreibung, Game.Cover as cover, Game.Video as video from bewertung  join Game on Bewertung.Game_ID=Game.ID  group BY Game_ID order by bewertung DESC LIMIT 4)T";
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
					spiel.setVideo(rs.getString("video"));

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

	@Override
	public List<Spiel> findGamesByGenre(String genre) {
		final String SQL = "select * from Game where Genre = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> spiele = new ArrayList<Spiel>();

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
				spieltmp.setVideo(rs.getString("video"));

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
				spiel.setVideo(rs.getString("video"));
				
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
		for (int i = 0; i < genrestmp.size(); i++) {
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
	@Override
	public List<Bewertung> getAllBewertungenbyID(int spiel_ID) {
		final String SQL = "select * from bewertung where Game_ID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bewertung> bewertungList = new ArrayList<Bewertung>();

		try {
			ps = con.prepareStatement(SQL);
			ps.setInt(1, spiel_ID);
			rs = ps.executeQuery();

			while (rs.next()) {
				Bewertung bewertung = new Bewertung();
				bewertung.setGame_ID(rs.getInt("Game_ID"));
				bewertung.setBenutzer_ID(rs.getInt("Benutzer_ID"));
				bewertung.setBewertung(rs.getInt("Bewertung"));
				
				bewertungList.add(bewertung);
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
		return bewertungList;

	}

	@Override
	public List<spieleliste> getAlleKäufe() {
		final String SQL = "select * from spieleliste";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<spieleliste> spielelisteList = new ArrayList<spieleliste>();

		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				spieleliste spieleliste = new spieleliste();
				
				spieleliste.setBenutzer_ID(rs.getInt("Benutzer_ID"));
				spieleliste.setGame_ID(rs.getInt("Game_ID"));
				
				spielelisteList.add(spieleliste);
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
		return spielelisteList;
	}

	@Override
	public void addKauf(spieleliste spieleliste) {
		final String SQL = "insert into spieleliste (Benutzer_ID, Game_ID) Values(?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQL);
			ps.setInt(1, spieleliste.getBenutzer_ID());
			ps.setInt(2, spieleliste.getGame_ID());
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

	@Override
	public List<Spiel> getKäufeByUser(int userid) {
		final String SQL = "select Distinct(Game_ID) from spieleliste where Benutzer_ID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> spielelisteList = new ArrayList<Spiel>();

		try {
			ps = con.prepareStatement(SQL);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				for(Spiel spiel : getSpielByID(rs.getInt("Game_ID"))) {
					spielelisteList.add(spiel);
				}
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
		return spielelisteList;
	}

	@Override
	public List<Spiel> getSpielByID(int userid) {
		final String SQL = "select * from Game where ID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> spieleliste = new ArrayList<Spiel>();

		try {
			ps = con.prepareStatement(SQL);
			ps.setInt(1, userid);
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
				spiel.setVideo(rs.getString("video"));
				
				spieleliste.add(spiel);
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
		return spieleliste;
	}

	@Override
	public List<Spiel> getGamesByName(String gamename) {
		final String SQL = "select * from Game where bezeichnung like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> spieleliste = new ArrayList<Spiel>();
		
		
		try {
			ps = con.prepareStatement(SQL);
			ps.setString(1, "%"+gamename+"%");
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
				spiel.setVideo(rs.getString("video"));
				
				spieleliste.add(spiel);
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
		return spieleliste;
	}

}
