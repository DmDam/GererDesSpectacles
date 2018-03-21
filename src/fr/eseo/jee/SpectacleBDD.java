package fr.eseo.jee;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class SpectacleBDD {

	private Connection db = null;
	private Statement stnt = null;
	
	protected String titreSpectacleSQL = "SELECT titreSpectacle FROM Spectacles";
	
	
	
	public SpectacleBDD() {
		
	}
	
	
	
	public Connection getDb() {
		return db;
	}
	public Statement getStnt() {
		return stnt;
	}
	public ResultSet getRset() {
		ResultSet rset = null;
		try {
			rset =  getStnt().getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rset;
	}
	
	
	
	protected void connexion() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			this.db = DriverManager.getConnection("jdbc:mysql://localhost/Spectacle?user=admin&password=network");
			System.out.println("Connection ok " + this.db);
		} catch (SQLException event) {
			System.out.println("Code erreur : "+event.getErrorCode());
			event.printStackTrace();
		} catch (Exception event) {
			event.printStackTrace();
		}
	}
	
	protected void createStatement() {
		try {
			this.stnt = getDb().createStatement();
			System.out.println("Statement created ...");
		} catch (SQLException event) {
			event.printStackTrace();
		}
	}
	
	protected void fermetureStatement() {
		try {
			getStnt().close();
			System.out.println("Fermeture statement ...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void fermetureConnexion() {
		try {
			getDb().close();
			System.out.println("Connexion close");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
