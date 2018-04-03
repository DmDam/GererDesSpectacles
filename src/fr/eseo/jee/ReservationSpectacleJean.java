package eseo.test;

public class ReservationSpectacle {
	
	private int codeReservation;
	private int codeSpectacle;
	private int codeClient;
	private int nbPersonnes;
	private boolean Paiement;
	
	void setCodeReservation(int code) {
		codeReservation = code;
	}
	
	int getCodeReservation(){
		return codeReservation;
	}
	
	void setCodeSpectable(int code) {
		codeSpectacle = code;
	}
	
	int getCodeSpectacle(){
		return codeSpectacle;
	}
	
	void setCodeClient(int code) {
		codeClient = code;
	}
	
	int getCodeClient(){
		return codeClient;
	}
	
	void setNbPersonnes(int nb) {
		nbPersonnes = nb;
	}
	
	int getNbPersonnes(){
		return nbPersonnes;
	}
	
	void setPaiement(boolean paiement) {
		Paiement = paiement;
	}
	
	boolean getPaiement(){
		return Paiement;
	}
}
