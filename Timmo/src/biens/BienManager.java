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
import java.util.Scanner;

import agence.Agence;
import clients.ClientFactory;

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
	static int idBienIncrement = 1;// Bien id with autoincrement

	/** Methods **/

	/**
	 * Stocke un bien dans bienManager. Appelé par BienFactory.
	 * 
	 * @see BienFactory
	 * @param a
	 *            le Bien à ajouter
	 */
	public void addBien(Bien a) {
		this.biens.add(a);
		this.idBienIncrement++;// add
	}

	public ArrayList<Bien> getBiens() {
		return this.biens;
	}

	public String listBiens() {
		// strigbuilder?
		String s = "Biens de l'agence " + Agence.getInstance().NAME + " :\n";
		for (Bien b : this.getBiens()) {
			s += b + " \n";
		}
		return s;
	}

	public void formBien() {
		Scanner scan = new Scanner(System.in);
		String adresseBien;
		Orientation orientation;
		BienType bienType;
		int temp;
		do {
			System.out.println("Entrez l'adresse du bien:"); // Asks question
			adresseBien = scan.nextLine();
		} while (adresseBien.isEmpty());

		do {
			System.out.println("Entrez l'orientation du bien:\n" + "1.OUEST\n" + "2.NORD\n" + "3.EST\n" + "4.SUD\n");
			temp = scan.nextInt();
		} while (0 > temp && 5 < temp);
		orientation = Orientation.values()[temp - 1];

		do {
			System.out.println("Entrez le type de bien:\n" + "1.APPARTEMENT\n" + "2.MAISON\n" + "3.TERRAIN\n");
			temp = scan.nextInt();
		} while (0 > temp && 4 < temp);
		bienType = BienType.values()[temp - 1];

		// BienFactory.createBien();
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
