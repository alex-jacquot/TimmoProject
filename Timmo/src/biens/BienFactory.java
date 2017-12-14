package biens;

import agence.Agence;
import agence.Mandat;
import clients.ClientManager;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class BienFactory {

	public static Bien createBien(int idBien, String adresse, String orientation) {

		// TODO Exceptions

		// TODO test non duplicates

		Bien b = new Bien(idBien, adresse, orientation);

		BienManager.getInstance().addBien(b);// add mandat to agence list

		BienManager.idBienIncrement++;

		return b;

	}

}
