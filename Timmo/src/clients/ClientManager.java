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

	public String listClients() {
		// strigbuilder?
		String s = "Clients de l'agence " + Agence.NAME + " :\n";
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
		ClientManager.idClientIncrement++;
	}

}
