/** Agence.java
 * Handles a full, single Agence Information System for every action an Agence should do.
 * 
 * Notes: Agence is a Singleton i.e. always one single instance max
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
import java.util.HashSet;
import java.util.Set;

import biens.Appartement;
import biens.Bien;
import biens.BienFactory;
import biens.BienManager;
import biens.Chauffage;
import biens.Maison;
import biens.Orientation;
import clients.Client;
import clients.ClientManager;

public class Agence {

	/** Constructor Singleton pattern */
	private static Agence INSTANCE;

	private ArrayList<Mandat> mandats;
	private ArrayList<Voeu> voeux;
	private ClientManager cm;
	private BienManager bm;

	private Agence() {
		mandats = new ArrayList();
		voeux = new ArrayList();
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

	private static String NAME = "TIMMO-BILIER";// why not

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
	 * Ajouter un voeu à la collection de voeux
	 * 
	 * @param v
	 *            A voeu
	 */
	public void addVoeu(Voeu v) {
		this.voeux.add(v);
	}

	public static void main(String[] args) {

		Agence timmo = Agence.getInstance();
		Maison m = BienFactory.createMaison("10 allées Antonio Machado", Orientation.OUEST, 300, 6, 1, Chauffage.GAZ);
		System.out.println(m);
		Appartement a = BienFactory.createAppartement("9 allées Antonio Machado", Orientation.EST, 5, 8, 322);
		System.out.println(a);
		Maison m2 = BienFactory.createMaison("Résidence Constantinople apt 6", Orientation.EST, 50, 2, 1,
				Chauffage.ELECTRICITE);
		System.out.println(BienManager.getInstance().getBiens());
	}

	public ArrayList<Mandat> getMandats() {
		return this.mandats;
	}

}
