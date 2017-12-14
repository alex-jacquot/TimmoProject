/** BienManager.java
 * 
 * Handles every operation regarding Bien objects
 * 
 * Notes: Agence is a Singleton I.e. always one single instance max
 * 
 * @author Alex Jacquot
 * */

package biens;

import java.util.ArrayList;
import java.util.HashSet;

import agence.Agence;
import clients.Client;

public class BienManager {

	// Singleton pattern
	private static BienManager INSTANCE;

	private BienManager() {

	}

	private static BienManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BienManager();
		}
		return INSTANCE;
	}

	/** Attributes **/

	private ArrayList<Bien> biens;

	/** Methods **/

	public ArrayList<Bien> getBiens() {
		return biens;
	}

	private Bien getBienById(int idBien) {
		for (Bien b : biens) {
			if (b.getIdBien() == idBien) {
				return b;
			}
		}
		return null;
	}

}
