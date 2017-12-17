package biens;

import java.util.Optional;

import agence.Mandat;
import clients.Client;

public abstract class Bien {

	int idBien;
	String adresse;
	Orientation orientation;
	BienType bienType;// better to stock the type (enum) rather than do instanceof
	// Client proprietaire; WRONG!

	public Bien() {

	}

	public BienType getBienType() {
		return bienType;
	}

	public Bien(int idBien, String adresse, Orientation orientation, BienType bienType) {
		this.idBien = idBien;
		this.adresse = adresse;
		this.orientation = orientation;
		this.bienType = bienType;
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

	public Orientation getOrientation() {
		return orientation;
	}

}
