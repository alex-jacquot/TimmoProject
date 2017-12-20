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
import java.util.InputMismatchException;
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
		int temp = 0;

		do {
			System.out.println("Entrez l'adresse du bien:"); // Asks question

			adresseBien = scan.nextLine();
		} while (adresseBien.isEmpty());

		do {

			System.out.println("Entrez l'orientation du bien:\n" + "1.OUEST\n" + "2.NORD\n" + "3.EST\n" + "4.SUD");
			// This is actually this simple f*** yeah
			if (scan.hasNextInt())
				temp = scan.nextInt();
			else {
				scan.next();
				continue;
			}

		} while (1 > temp || 4 < temp);

		orientation = Orientation.values()[temp - 1];

		do {

			System.out.println("Entrez le type du bien:\n" + "1.APPARTEMENT\n" + "2.MAISON\n" + "3.TERRAIN\n");
			if (scan.hasNextInt())
				temp = scan.nextInt();
			else {
				scan.next();
				continue;
			}
		} while (1 > temp || 3 < temp);
		bienType = BienType.values()[temp - 1];

		switch (bienType) {
		case MAISON:
			int surfaceHabitable = 0, nombrePieces = 0, nombreEtages = 0;
			Chauffage moyenChauffage;
			do {
				System.out.println("Entrez la surface habitable:");
				if (scan.hasNextInt())
					surfaceHabitable = scan.nextInt();
				else {
					scan.next();
					continue;
				}

			} while (1 > surfaceHabitable || 1000 < surfaceHabitable);

			do {
				System.out.println("Entrez le nombre de pieces:");
				if (scan.hasNextInt())
					nombrePieces = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombrePieces || 100 < nombrePieces);

			do {
				System.out.println("Entrez le nombre d'étages:");
				if (scan.hasNextInt())
					nombreEtages = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombreEtages || 100 < nombreEtages);

			do {
				System.out.println("Entrez le moyen de chauffage:\n" + "1.ELECTRICITE\n" + "2.GAZ\n");
				if (scan.hasNextInt())
					temp = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > temp || 2 < temp);
			moyenChauffage = Chauffage.values()[temp - 1];
			Bien maison = BienFactory.createMaison(adresseBien, orientation, surfaceHabitable, nombrePieces,
					nombreEtages, moyenChauffage);
			System.out.println("Maison (id n°" + maison.getIdBien() + ") crée!");
			break;

		case APPARTEMENT:
			int etage = 0, nombreDePieces = 0, chargesMensuelles = 0;
			do {
				System.out.println("Entrez l'étage:");
				if (scan.hasNextInt())
					etage = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > etage || etage > 100);

			do {
				System.out.println("Entrez le nombre de pieces:");
				if (scan.hasNextInt())
					nombreDePieces = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombreDePieces || 20 < nombreDePieces);

			do {
				System.out.println("Entrez les charges mensuelles:");
				if (scan.hasNextInt())
					chargesMensuelles = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > chargesMensuelles || 2000 < chargesMensuelles);
			Appartement appart = BienFactory.createAppartement(adresseBien, orientation, etage, nombreDePieces,
					chargesMensuelles);
			System.out.println("Appartement (id n°" + appart.getIdBien() + ") crée!");
			break;

		case TERRAIN:
			int surfaceSol = 0;
			int longueurFacade = 0;
			do {
				System.out.println("Entrez la surface au sol:");
				if (scan.hasNextInt())
					surfaceSol = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > surfaceSol || 1000 < surfaceSol);

			do {
				System.out.println("Entrez la longueur de façade:");
				if (scan.hasNextInt())
					longueurFacade = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > longueurFacade || 1000 < longueurFacade);
			Bien terrain = BienFactory.createTerrain(adresseBien, orientation, surfaceSol, longueurFacade);
			System.out.println("Terrain (id n°" + terrain.getIdBien() + ") crée!");
			break;
		}

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
