/** Mandat.java
 * 
 * 
 * Note : Mandat is an immaterial link between a Client and a Bien, only both ids are shared and then used by associated Manager classes
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 * */

package agence;

import java.util.Date;

import biens.Bien;
import clients.Client;

public class Mandat {

	/**
	 * Attributs
	 */
	Client client;
	Bien bien;
	int prix;
	Date dateLimite;

	/**
	 * Mandat Constructor
	 * 
	 * @param idClient
	 *            Unique id of a Client.
	 * @param idBien
	 *            Unique id of a Bien.
	 * @param prix
	 *            Price of a Bien.
	 * @param dateLimite
	 *            The time's limit of the offer.
	 */
	public Mandat(Client client, Bien bien, int prix, Date dateLimite) {
		this.client = client;
		this.bien = bien;
		this.prix = prix;
		this.dateLimite = dateLimite;
	}

	/**
	 * Return the id of a Client.
	 * 
	 * @return A Client's identification
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Retourn the id of a Bien.
	 * 
	 * @return A Bien's identification
	 */
	public Bien getBien() {
		return bien;
	}

	/**
	 * Return the price of a bien.
	 * 
	 * @return A Bien's price.
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * Return the time's limit whereas the Bien is not available anymore.
	 * 
	 * @return A Date instance
	 */
	public Date getDateLimite() {
		return dateLimite;
	}

	@Override
	public String toString() {
		return "Mandat donnant droit à M. " + client.getPrenom() + " " + client.getNom() + "de vendre son "
				+ bien.getBienType() + "(id n°" + bien.getIdBien() + " pour la somme de " + prix + " euros (expire le "
				+ dateLimite + ")";
	}

}
