package agence;

import java.util.Date;

import biens.BienManager;
import clients.ClientManager;
import exceptions.*;

public class MandatFactory {

	public static Mandat createMandat(int idBien, int idClient, int prix, Date dateLimite)
			throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {

		if (ClientManager.getInstance().getClientById(idClient) == null) {
			throw new ClientMissingException();
		}

		if (BienManager.getInstance().getBienById(idBien) == null) {
			throw new BienMissingException();
		}

		// TODO test non duplicates

		// non duplicate
		Mandat m = new Mandat(idBien, idClient, prix, dateLimite);

		Agence.getInstance().addMandat(m);// add mandat to agence list

		return m;

	}
}
