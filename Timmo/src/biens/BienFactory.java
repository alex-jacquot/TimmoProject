/** BienFactory.java
 * Factory class designed to create a new Bien by calling the correct subtype constructor an registering the object in BienManager
 * 
 * @see Bien
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 */

package biens;

public class BienFactory {

	/**
	 * Create a Bien of Maison's type.
	 * 
	 * @param adresse
	 * @param orientation
	 * @param surfaceHabitable
	 * @param nombrePieces
	 * @param nombreEtages
	 * @param moyenChauffage
	 * @return An instance of Maison.
	 */
	public static Maison createMaison(String adresse, Orientation orientation, int surfaceHabitable, int nombrePieces,
			int nombreEtages, Chauffage moyenChauffage) {

		Maison m = new Maison(BienManager.idBienIncrement, adresse, orientation, surfaceHabitable, nombrePieces,
				nombreEtages, moyenChauffage);

		BienManager.getInstance().addBien(m);

		return m;
	}

	/**
	 * Create a Bien of Appartement's type.
	 * 
	 * @param adresse
	 * @param orientation
	 * @param etage
	 * @param nombreDePieces
	 * @param chargesMensuelles
	 * @return An instance of Appartement.
	 */
	public static Appartement createAppartement(String adresse, Orientation orientation, int etage, int nombreDePieces,
			int chargesMensuelles) {

		Appartement a = new Appartement(BienManager.idBienIncrement, adresse, orientation, etage, nombreDePieces,
				chargesMensuelles);

		BienManager.getInstance().addBien(a);

		return a;
	}

	/**
	 * Create a Bien of Terrain's type.
	 * 
	 * @param adresse
	 * @param orientation
	 * @param surfaceSol
	 * @param longueurFacade
	 * @return An instance of Terrain.
	 */
	public static Terrain createTerrain(String adresse, Orientation orientation, int surfaceSol, int longueurFacade) {

		Terrain t = new Terrain(BienManager.idBienIncrement, adresse, orientation, surfaceSol, longueurFacade);

		BienManager.getInstance().addBien(t);

		return t;
	}
}
