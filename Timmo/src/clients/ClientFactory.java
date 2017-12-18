package clients;

import biens.Bien;
import biens.BienManager;

public class ClientFactory {

	public static Client createClient(String prenom, String nom, String email, String numTel) {

		Client c = new Client(prenom, nom, email, numTel);

		ClientManager.getInstance().addClient(c);// add mandat to agence list

		return c;
	}

}
