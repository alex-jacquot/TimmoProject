package clients;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
