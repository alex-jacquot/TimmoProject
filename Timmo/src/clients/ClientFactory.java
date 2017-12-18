package clients;

import biens.Bien;
import biens.BienManager;

public class ClientFactory {

	public static Client createClient(String prenom, String nom) {

		Client c = new Client(prenom, nom);

		ClientManager.getInstance().addClient(c);// add mandat to agence list

		return c;
	}

}
