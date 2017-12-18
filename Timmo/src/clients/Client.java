package clients;

import java.util.ArrayList;

import agence.Agence;
import agence.Mandat;
import biens.Bien;

public class Client {

	// int idClient;//Pour ne pas réinscrire les clients déjà isncrits (alt.
	// hashCode())

	int idClient;
	String nom;
	String prenom;

	public Client(String prenom, String nom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client id n° " + idClient + ": " + prenom + " " + nom.toUpperCase();
	}

	public ArrayList<Bien> getBiens() {
		ArrayList<Bien> result = new ArrayList<>();
		ArrayList<Mandat> mandats = Agence.getInstance().getMandats();
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
