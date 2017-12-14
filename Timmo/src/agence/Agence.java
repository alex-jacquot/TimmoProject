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

	private static String NAME = "TIMMO-BILIER";

	private Set<Client> clients;
	private Set<Bien> biens;

	// Singleton pattern
	private static Agence INSTANCE;

	private Agence() {

	}

	private static Agence getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Agence();
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
