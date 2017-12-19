package clients;

public class Client {

	// int idClient;//Pour ne pas réinscrire les clients déjà isncrits (alt.
	// hashCode())

	int idClient;
	String nom;
	String prenom;
	String email;
	String numTel;

	public Client(String prenom, String nom, String email, String numTel) {
		this.idClient = ClientManager.idClientIncrement;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTel = numTel;
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
		return "Client id n° " + idClient + ": " + prenom + " " + nom.toUpperCase() + ", " + email + ", " + numTel;
	}

	/*
	 * public ArrayList<Bien> getBiens() { ArrayList<Bien> result = new
	 * ArrayList<>(); ArrayList<Mandat> mandats = Agence.getInstance().getMandats();
	 * 
	 * return result; }
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client c = (Client) obj;
			return (c.idClient == this.idClient);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
