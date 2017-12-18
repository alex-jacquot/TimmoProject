/** BienManager.java
 * 
 * Handles every operation (creation, stockage..) regarding Bien objects
 * 
 * Notes: Agence is a Singleton i.e. always one single instance max
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 * */

package biens;

import java.util.ArrayList;
import java.util.HashSet;

import agence.Agence;

public class BienManager {

	/** Constructor (Singleton pattern) **/

	private static BienManager INSTANCE;

	private BienManager() {
		biens = new ArrayList<>();
	}

	public static BienManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BienManager();
		}
		return INSTANCE;
	}

	/** Attributes **/

	private ArrayList<Bien> biens;
	static int idBienIncrement = 1;//Bien id with autoincrement

	/** Methods **/

	
	/**Save a Bien to BienManager's collection and increase the autoincrement. Called by BienFactory.
	 * 
	 * @param a
	 */
	public void addBien(Bien a) {
		this.biens.add(a);
		this.idBienIncrement++;//add
	}

	public ArrayList<Bien> getBiens() {
		return this.biens;
	}

	public Bien getBienById(int idBien) {
		for (Bien b : biens) {
			if (b.getIdBien() == idBien) {
				return b;
			}
		}
		return null;
	}

	public ArrayList<Appartement> getAppartements() {
		ArrayList<Appartement> result = new ArrayList<>();
		for (Bien b : biens) {
			if (b.getBienType() == BienType.APPARTEMENT) {
				result.add((Appartement) b);
			}
		}
		return result;

	}

	public ArrayList<Maison> getMaisons() {
		ArrayList<Maison> result = new ArrayList<>();
		for (Bien b : biens) {
			if (b.getBienType() == BienType.MAISON) {
				result.add((Maison) b);
			}
		}
		return result;

	}

	public ArrayList<Terrain> getTerrain() {
		ArrayList<Terrain> result = new ArrayList<>();
		for (Bien b : biens) {
			if (b.getBienType() == BienType.TERRAIN) {
				result.add((Terrain) b);
			}
		}
		return result;

	}
}
