/** Client Factory.java
 * Factory class designed to create a new Client
 * 
 * @see Client
 * @see Agence
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 */


package clients;

public class ClientFactory {

	public static Client createClient(String prenom, String nom, String email, String numTel) {

		Client c = new Client(prenom, nom, email, numTel);

		ClientManager.getInstance().addClient(c);// add mandat to agence list

		return c;
	}

}
