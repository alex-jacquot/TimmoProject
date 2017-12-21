/**
 * Specific subtype of a Bien with a floor number, a rooms count, and additionnal mensual charges
 * @see Bien
 * @see BienFactory
 * @author Alex Jacquot
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

	public int getEtage() {
		return etage;
	}

	public int getNombreDePieces() {
		return nombreDePieces;
	}

	public int getChargesMensuelles() {
		return chargesMensuelles;
	}

	@Override
	public String toString() {
		return "Bien id n°" + idBien + ": Appartement situé à " + adresse + " orienté " + orientation + ", "
				+ nombreDePieces + " pièces situé au " + etage + ((etage == 1) ? "er" : "ème") + " à "
				+ chargesMensuelles + "€ de charges par mois";
	}

}
