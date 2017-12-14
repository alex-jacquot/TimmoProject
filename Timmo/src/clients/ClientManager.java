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

import agence.Agence;

public class ClientManager {

	// Singleton pattern
	private static ClientManager INSTANCE;

	private ClientManager() {

	}

	public static ClientManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClientManager();
		}
		return INSTANCE;
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

}
