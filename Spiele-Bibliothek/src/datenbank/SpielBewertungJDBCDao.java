package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpielBewertungJDBCDao implements SpielBewertungDao {

	private final Connection con = ConnectionFactory.getInstance().getConnection();
	
	@SuppressWarnings("null")
	@Override
	public String[] findTopGamesCover() {
		final String SQL = "Select cover from (select Bewertung as bewertung, Game.Cover as cover from bewertung join Game on Bewertung.Game_ID=Game.ID ORDER BY Bewertung DESC LIMIT 4)T;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] topSpiele = new String[4];
		
		try {
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			for(int i = 0; i<4; i++) {
				while (rs.next()) {
					topSpiele[i] = rs.getString("cover");
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
