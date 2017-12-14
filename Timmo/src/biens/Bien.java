package biens;

import java.util.Optional;

import agence.Mandat;
import clients.Client;

public class Bien {

	int idBien;
	String adresse;
	String orientation;
	// Client proprietaire; WRONG!

	public Bien() {

	}

	public static void main(String[] args) {

	}

	public int getIdBien() {
		return idBien;
	}

	public void setIdBien(int idBien) {
		this.idBien = idBien;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Bien(int idBien, String adresse, String orientation) {
		super();
		this.idBien = idBien;
		this.adresse = adresse;
		this.orientation = orientation;
	}

}
