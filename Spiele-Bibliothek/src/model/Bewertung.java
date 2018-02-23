package model;

public class Bewertung {
	private int Game_ID;
	private int Benutzer_ID;
	private int Bewertung;

	public int getGame_ID() {
		return Game_ID;
	}

	public void setGame_ID(int game_ID) {
		Game_ID = game_ID;
	}

	public int getBenutzer_ID() {
		return Benutzer_ID;
	}

	public void setBenutzer_ID(int benutzer_ID) {
		Benutzer_ID = benutzer_ID;
	}

	public int getBewertung() {
		return Bewertung;
	}

	public void setBewertung(int bewertung) {
		Bewertung = bewertung;
	}

}
