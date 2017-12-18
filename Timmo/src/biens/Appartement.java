/** Appartement.java
 * Appartement is a type of Bien.
 * It has a floor, a number of rooms and a mensual cost.
 * 
 * @see Bien
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 */

package biens;

public class Appartement extends Bien {
    /**
     * Attributes 
     */
	int etage;
	int nombreDePieces;
	int chargesMensuelles;
	
	/**
	 * Appartement Constructor
	 * 
	 * @param idBien
	 * @param adresse
	 * @param orientation
	 * @param etage
	 * @param nombreDePieces
	 * @param chargesMensuelles
	 */
	public Appartement(int idBien, String adresse, Orientation orientation, int etage, int nombreDePieces,
			int chargesMensuelles) {

		super(idBien, adresse, orientation, BienType.APPARTEMENT);
		this.etage = etage;
		this.nombreDePieces = nombreDePieces;
		this.chargesMensuelles = chargesMensuelles;

	}
}
