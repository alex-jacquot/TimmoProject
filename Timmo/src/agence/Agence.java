/** Agence.java
 * 
 * Handles a full, single Agence Information System for every action an Agence should do.
 * 
 * Notes: Agence is a Singleton I.e. always one single instance max
 * 
 * @author Alex Jacquot
 * */

package agence;

import java.util.HashSet;
import java.util.Set;

import biens.Bien;
import biens.BienManager;
import clients.Client;

public class Agence {

	/** Constructor Singleton pattern **/

	private static Agence INSTANCE;

	private Agence() {
		mandats = new HashSet<>();
		voeux = new HashSet<>();
	}

	public static Agence getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Agence();
		}
		return INSTANCE;
	}

	/** Attributes **/

	private static String NAME = "TIMMO-BILIER";// why not

	private Set<Mandat> mandats;
	private Set<Voeu> voeux;

	

	public void addMandat(Mandat m) {
		this.mandats.add(m);
	}

	public void addVoeu(Voeu v) {
		this.voeux.add(v);
	}
	
	public static void main(String[] args) {

		Agence timmo = Agence.getInstance();
		Mandat m1 = new Mandat(0, 0, 0, null);
	}

}
