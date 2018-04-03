package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;

import fr.eseo.jee.Spectacle;
import fr.eseo.jee.SpectacleBDD;

@WebService(targetNamespace = "http://test.eseo/", endpointInterface = "eseo.test.GestionSpectaclesInterface", portName = "GestionSpectaclesPort", serviceName = "GestionSpectaclesService")
public class GestionSpectacles {
		
	public Spectacle[] trouverSpectacle(Spectacle unSpectacle) {
		
		SpectacleBDD instanceBDD = new SpectacleBDD();
		instanceBDD.connexion();
		instanceBDD.createStatement();
		Spectacle[] speclist = new Spectacle[10];
		int i = 0;
		
		try {
			instanceBDD.getStnt().executeQuery("SELECT * FROM Spectacles WHERE idSpectacle = " + unSpectacle.getCodeSpectacle() + " AND typeSpectale = " + unSpectacle.getTypeSpectacle() + " AND titreSpectacle = " + unSpectacle.getTitreSpectacle() + " AND ville = " + unSpectacle.getVilleSpectacle() + " AND dateSpectacle = " + unSpectacle.getDateSpectacle() + " AND prixSpectacle = " + unSpectacle.getPrixSpectacle() + ";");
			ResultSet rset = instanceBDD.getStnt().getResultSet();
			
			while(instanceBDD.getRset().next()) {
				Spectacle sp = new Spectacle();
				sp.setCodeSpectable(rset.getInt(1));
				sp.setTypeSpectable(rset.getString(2));
				sp.setTitreSpectable(rset.getString(3));
				sp.setVilleSpectable(rset.getString(4));
				sp.setDateSpectable(rset.getString(5));
				sp.setPrixSpectable(rset.getInt(6));
				System.out.println("----------");
				
				speclist[i] = sp;
				i++;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();
		return speclist;
	}
	
	
	
	
	
	public int reserverSpectacle(ReservationSpectacleJean uneReservation) {
		
		SpectacleBDD instanceBDD = new SpectacleBDD();
		instanceBDD.connexion();
		instanceBDD.createStatement();
		int cr = 0;
		
		try {
			instanceBDD.getStnt().executeQuery("INSERT INTO `reservation`(`idReservation`, `idSpectacle`, `idClient`, `nombresPlaces`, `booleanPaiementEffectue`) VALUES (" + uneReservation.getCodeReservation() + " , " + uneReservation.getCodeSpectacle() + " , " + uneReservation.getCodeClient() + " , " + uneReservation.getNbPersonnes() + " , " + uneReservation.getPaiement()+ " ); ");
			ResultSet rset = instanceBDD.getStnt().getResultSet();
			
			while(instanceBDD.getRset().next()) {
				
				if (rset.getInt(1) == uneReservation.getCodeReservation()) {
					
					System.out.println("Votre réservation a bien était prise en compte");
					cr = rset.getInt(1);
				}
			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();
		return cr;
	}
	
	
	
	
	
		
	public String payerSpectacle(int codeReservation) {
		
		SpectacleBDD instanceBDD = new SpectacleBDD();
		instanceBDD.connexion();
		instanceBDD.createStatement();
		String message = "Votre paiement non effectué";
		
		try {
			instanceBDD.getStnt().executeQuery("UPDATE Reservation SET booleanPaiementEffectue = TRUE WHERE idReservation = " + codeReservation + " ); ");
			ResultSet rset = instanceBDD.getStnt().getResultSet();
			
			while(instanceBDD.getRset().next()) {
				
				if (rset.getInt(1) == codeReservation && rset.getBoolean(5) == true) {
					
					System.out.println("Votre paiement a bien était effectué.");
					message = "Votre paiement a bien était effectué";
				}
			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();
		return message;
	}
	
	
	
	
	
		
	public boolean annulerSpectacle(int codeReservation) {
		
		SpectacleBDD instanceBDD = new SpectacleBDD();
		instanceBDD.connexion();
		instanceBDD.createStatement();
		boolean annuler = false;
		
		try {
			instanceBDD.getStnt().executeQuery("DELETE FROM reservation WHERE idReservation = " + codeReservation + " ); ");
			ResultSet rset = instanceBDD.getStnt().getResultSet();
			
			while(instanceBDD.getRset().next()) {
				
				if (rset.getInt(1) != codeReservation) {
					
					annuler = true;
				}
				else if (rset.getInt(1) == codeReservation) {
					
					annuler = false;
				}
			
			}
			
			if (annuler = true) {
				System.out.println("Votre reservation a bien était annulée.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		instanceBDD.fermetureStatement();
		instanceBDD.fermetureConnexion();
		return annuler;
	}

}
