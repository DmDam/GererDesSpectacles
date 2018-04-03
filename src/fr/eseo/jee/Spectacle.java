package fr.eseo.jee;

import java.util.Calendar;

public class Spectacle {
	
	private int codeSpectacle;
	private String typeSpectacle;
	private String titreSpectacle;
	private String villeSpectacle;
	private String dateSpectacle;
	private int prixSpectacle;
	
	void setCodeSpectable(int code) {
		codeSpectacle = code;
	}
	
	int getCodeSpectacle(){
		return codeSpectacle;
	}
	
	void setTypeSpectable(String type) {
		typeSpectacle = type;
	}
	
	String getTypeSpectacle(){
		return typeSpectacle;
	}
	void setTitreSpectable(String titre) {
		titreSpectacle = titre;
	}
	
	String getTitreSpectacle(){
		return titreSpectacle;
	}
	void setVilleSpectable(String ville) {
		villeSpectacle = ville;
	}
	
	String getVilleSpectacle(){
		return villeSpectacle;
	}
	void setDateSpectable(String date) {
	}
	
	String getDateSpectacle(){
		return dateSpectacle;
	}
	
	void setPrixSpectable(int prix) {
		prixSpectacle = prix;
	}
	
	int getPrixSpectacle(){
		return prixSpectacle;
	}
	
}
