package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.UserNotFoundException;
import model.Spiel;

public class SpielBewertungJDBCDao implements SpielBewertungDao {

	private final Connection con = ConnectionFactory.getInstance().getConnection();
	
	@SuppressWarnings("null")
	@Override
	public List<Spiel> findTopGames() {
		final String SQL = "Select id, bezeichnung, hersteller, preis, erscheinungsjahr, genre, beschreibung, cover from (select Bewertung as bewertung, Game.ID as id, Game.Bezeichnung as bezeichnung, Game.Hersteller as hersteller, Game.Preis as preis, Game.Erscheinungsjahr as erscheinungsjahr, Game.Genre as genre, Game.Beschreibung as beschreibung, Game.Cover as cover from bewertung join Game on Bewertung.Game_ID=Game.ID ORDER BY Bewertung DESC LIMIT 4)T";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Spiel> topSpiele = new ArrayList<Spiel>();
		
		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			for(int i = 0; i<4; i++) {
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
		}catch(SQLException e) {
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
	public List<Spiel> findGamesByGenre() {
		final String SQL = "";
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Spiel> findAllGames() {
		final String SQL = "select * from Game";
		PreparedStatement ps= null;
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
		
		return alleSpiele;
	}

}
