package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Spiel;

public class SpielBewertungJDBCDao implements SpielBewertungDao {

	private final Connection con = ConnectionFactory.getInstance().getConnection();
	
	@SuppressWarnings("null")
	@Override
	public Spiel[] findTopGamesCover() {
		final String SQL = "Select id, bezeichnung, hersteller, preis, erscheinungsjahr, genre, beschreibung, cover from (select Bewertung as bewertung, Game.ID as id, Game.Bezeichnung as bezeichnung, Game.Hersteller as hersteller, Game.Preis as preis, Game.Erscheinungsjahr as erscheinungsjahr, Game.Genre as genre, Game.Beschreibung as beschreibung, Game.Cover as cover from bewertung join Game on Bewertung.Game_ID=Game.ID ORDER BY Bewertung DESC LIMIT 4)T";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Spiel[] topSpiele = new Spiel[4];
		
		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			for(int i = 0; i<4; i++) {
				while (rs.next()) {
					topSpiele[i].setId(rs.getInt("id"));
					topSpiele[i].setBezeichnung(rs.getString("bezeichnung"));
					topSpiele[i].setHersteller(rs.getString("hersteller"));
					topSpiele[i].setPreis(rs.getFloat("preis"));
					topSpiele[i].setErscheinungsjahr(rs.getInt("erscheinungsjahr"));
					topSpiele[i].setGenre(rs.getString("genre"));
					topSpiele[i].setBeschreibung(rs.getString("beschreibung"));
					topSpiele[i].setCover(rs.getString("cover"));
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

}
