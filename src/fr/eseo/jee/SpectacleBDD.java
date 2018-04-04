package fr.eseo.jee;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class SpectacleBDD {

	private Connection db = null;
	private Statement stnt = null;

	public static String SPECTACLES_QL = "SELECT * FROM Spectacles";
	public static String DELETE_RESERVATION_SQL = "DELETE FROM Reservation WHERE idReservation=";

	public SpectacleBDD() {
		
		/*Exemple de connexion et de requete
		this.connexion();
		this.createStatement();
		
		try {
			getStnt().executeQuery("SELECT titreSpectacle FROM Spectacles");
			
			while(getRset().next()) {
				System.out.println(getRset().getString("titreSpectacle"));
				System.out.println("----------");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		this.fermetureStatement();
		this.fermetureConnexion();
		*/
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
			rset = getStnt().getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rset;
	}

	public void connexion() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			this.db = DriverManager.getConnection("jdbc:mysql://localhost/Spectacle?user=admin&password=network");
			System.out.println("Connexion réussie à " + this.db + ".");
		} catch (SQLException event) {
			System.out.println("Echec de connexion. Code erreur : " + event.getErrorCode());
			event.printStackTrace();
		} catch (Exception event) {
			event.printStackTrace();
		}
	}

	public void createStatement() {
		try {
			this.stnt = getDb().createStatement();
			System.out.println("Création du statement.");
		} catch (SQLException event) {
			event.printStackTrace();
		}
	}

	public void fermetureStatement() {
		try {
			getStnt().close();
			System.out.println("Fermeture du statement.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fermetureConnexion() {
		try {
			getDb().close();
			System.out.println("Fermeture de la connexion.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
