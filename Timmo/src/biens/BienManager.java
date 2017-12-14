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

public class BienManager {

	/** Constructor (Singleton pattern) **/

	private static BienManager INSTANCE;

	private BienManager() {

	}

	public static BienManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BienManager();
		}
		return INSTANCE;
	}

	/** Attributes **/

	private ArrayList<Bien> biens;
	static int idBienIncrement = 1;

	/** Methods **/

	public void createBien(int idBien, String adresse, String orientation) {
		BienFactory.createBien(idBien, adresse, orientation);
	}

	public void addBien(Bien b) {
		this.biens.add(b);
	}

	public ArrayList<Bien> getBiens() {
		return biens;
	}

	public Bien getBienById(int idBien) {
		for (Bien b : biens) {
			if (b.getIdBien() == idBien) {
				return b;
			}
		}
		return null;
	}

}
