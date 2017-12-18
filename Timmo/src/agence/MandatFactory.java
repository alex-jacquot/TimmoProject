/** MandatFactory.java
 * This class is a Factory designed to create new mandats.
 * It throws exceptions if not created correctly.
 * 
 * @see Mandat
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 */

package agence;

import java.util.Date;

import biens.Bien;
import biens.BienManager;
import clients.Client;
import clients.ClientManager;
import exceptions.*;

public class MandatFactory {

	/**
	 * Create a Mandat.
	 * 
	 * @param idBien
	 * @param idClient
	 * @param prix
	 * @param dateLimite
	 * @return A Mandat instance.
	 * @throws ClientMissingException
	 *             If the Client doesn't exist.
	 * @throws BienMissingException
	 *             If the Bien doesn't exist.
	 * @throws BienHasTwoMandatsException
	 *             If there's already a Mandat with the same id.
	 */
	public static Mandat createMandat(Client client, Bien bien, int prix, Date dateLimite)
			throws BienHasTwoMandatsException {

		/*
		 * if (ClientManager.getInstance().getClient(client) == null) { throw new
		 * ClientMissingException(); }
		 * 
		 * if (BienManager.getInstance().getBienById(idBien) == null) { throw new
		 * BienMissingException(); }
		 */

		if (Agence.getInstance().getMandatForBien(bien) != null) {
			throw new BienHasTwoMandatsException();
		}

		Mandat m = new Mandat(client, bien, prix, dateLimite);

		Agence.getInstance().addMandat(m);// add mandat to agence list

		return m;

	}
}
