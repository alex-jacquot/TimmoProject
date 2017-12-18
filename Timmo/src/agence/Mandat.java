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

import clients.Client;

public class Mandat {

    /**
     * Attributs
     */
	int idClient;
	int idBien;
	int prix;
	Date dateLimite;

	/**
	 * Mandat Constructor
	 * 
	 * @param idClient
	 *             Unique id of a Client.
	 * @param idBien
	 *             Unique id of a Bien.
	 * @param prix
	 *             Price of a Bien.
	 * @param dateLimite
	 *             The time's limit of the offer.
	 */
	public Mandat(int idClient, int idBien, int prix, Date dateLimite) {
		this.idClient = idClient;
		this.idBien = idBien;
		this.prix = prix;
		this.dateLimite = dateLimite;
	}

	/**
	 * Return the id of a Client.
	 * @return A Client's identification 
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * Retourn the id of a Bien.
	 * @return A Bien's identification
	 */
	public int getIdBien() {
		return idBien;
	}
	
	/**
	 * Return the price of a bien.
	 * @return A Bien's price.
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * Return the time's limit whereas the Bien is not available  anymore.
	 * @return A Date instance
	 */
	public Date getDateLimite() {
		return dateLimite;
	}
}
