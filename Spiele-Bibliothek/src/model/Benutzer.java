package model;

import java.util.Calendar;
import java.util.Date;

public class Benutzer {
	int id = 0;
	String benutzername = "";
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String passwort = "";
	String email = "";
	
	public String toString(){
		String result = "";
		result += benutzername + "=";
		result += passwort + " ";
		return result;
	}
}