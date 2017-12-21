/** Agence.java

 * Handles a full, single Agence Information System for every action an Agence should do.
 * It also handles Mandat and Voeu storing and linking.
 * 
 * Notes: Agence is a Singleton
 * 
 * @see BienManager
 * @see ClientManager
 * @see Mandat
 * @see Voeu
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 * */

package agence;

import java.util.ArrayList;
import biens.Bien;
import biens.BienManager;
import clients.Client;
import clients.ClientManager;

@SuppressWarnings("unused")
public class Agence {

	/** Constructor Singleton pattern */
	private static Agence INSTANCE;

	private ArrayList<Mandat> mandats;
	private ArrayList<Voeu> voeux;
	
	private ClientManager cm;
	private BienManager bm;

	private Agence() {
		mandats = new ArrayList<Mandat>();
		voeux = new ArrayList<Voeu>();
		cm = ClientManager.getInstance();
		bm = BienManager.getInstance();
	}

	public static Agence getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Agence();
		}
		return INSTANCE;
	}

	/** Attributes */

	public static String NAME = "TIMMO-BILIER";// why not

	/**
	 * Add a mandat to the mandats's collection
	 * 
	 * @param m
	 *            A mandat.
	 */
	public void addMandat(Mandat m) {
		this.mandats.add(m);
	}

	/**
	 * Remove a mandat to the mandats's collection and destroy the references on
	 * CLient and Bien
	 * 
	 * @param m
	 *            A mandat.
	 */
	public void deleteMandat(Mandat m) {
		this.mandats.remove(m);
	}

	/**
	 * Ajouter un voeu à la collection de voeux
	 * 
	 * @param v
	 *            A voeu
	 */
	public void addVoeu(Voeu v) {
		this.voeux.add(v);
	}

	public ArrayList<Mandat> getMandats() {
		return this.mandats;
	}

	/**
	 * Returns the existing Mandats of the client
	 * 
	 * @param b
	 * @return Mandat
	 */
	public ArrayList<Mandat> getMandatsForClient(Client c) {
		ArrayList<Mandat> result = new ArrayList<>();

		for (Mandat m : this.mandats) {
			if (m.getClient().equals(c)) {
				result.add(m);
			}
		}

		return result;
	}

	/**
	 * Returns the existing Mandat of the bien (note : a bien can only have 0 or 1
	 * mandat at any given time)
	 * 
	 * @param b
	 * @return Mandat
	 */
	public Mandat getMandatForBien(Bien b) {

		for (Mandat m : this.mandats) {
			if (m.getBien().equals(b)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Agence " + NAME;
	}

	public void getAvailableBiens() {
		for (Mandat m : this.mandats) {
			System.out.println(m);
		}
	}

}
