package datenbank;

import java.sql.Connection;

import model.Benutzer;

public class Demo {

	public static void main(String[] args) {
		Benutzer p = new Benutzer();
		Connection con = ConnectionFactory.getInstance().getConnection();
		BenutzerDao pd = new BenutzerJDBCDao(con);

		for (Benutzer benutzer : pd.getAllBenutzer()) {
			System.out.println(benutzer.toString());
		}
		
		ConnectionFactory.getInstance().closeConnection();
	}
}
