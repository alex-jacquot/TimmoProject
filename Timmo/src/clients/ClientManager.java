/** ClientManager.java
 * 
 * Handles every operation regarding Bien objects
 * 
 * Notes: Agence is a Singleton I.e. always one single instance max
 * 
 * @author Alex Jacquot
 * */

package clients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import agence.Agence;

public class ClientManager {

	/** Constructor and Singleton pattern **/

	private static ClientManager INSTANCE;
	static int idClientIncrement = 1;

	private ClientManager() {
		clients = new ArrayList<>();
	}

	public static ClientManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClientManager();
		}
		return INSTANCE;
	}

	public void formClient() {
		Scanner scan = new Scanner(System.in);
		String nomClient, prenomClient, email, numTel;
		do {
			System.out.println("Entrez le prenom du client:"); // Asks question
			prenomClient = scan.nextLine();
		} while (prenomClient.isEmpty());

		do {
			System.out.println("Entrez le nom du client:");
			nomClient = scan.nextLine();
		} while (nomClient.isEmpty());

		do {
			System.out.println("Entrez l'email du client:");
			email = scan.nextLine();
		} while (email.isEmpty());

		do {
			System.out.println("Entrez le téléphone du client:");
			numTel = scan.nextLine();
		} while (numTel.isEmpty());
		ClientFactory.createClient(nomClient, prenomClient, email, numTel);
	}

	public String listClients() {
		// strigbuilder?
		String s = "Clients de l'agence " + Agence.getInstance().NAME + " :\n";
		for (Client b : this.getClients()) {
			s += b + " \n";
		}
		return s;
	}

	/** Attributes **/

	private ArrayList<Client> clients;

	/** Methods **/

	public ArrayList<Client> getClients() {
		return clients;
	}

	public Client getClientById(int idClient) {
		for (Client b : clients) {
			if (b.getIdClient() == idClient) {
				return b;
			}
		}
		return null;
	}

	public void addClient(Client c) {
		this.clients.add(c);
		this.idClientIncrement++;
	}

}
