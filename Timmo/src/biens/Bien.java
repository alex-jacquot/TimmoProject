/** Bien.java
 * Bien represents any properties a Client can buy or sell to the Agence
 * 
 * It has : 
 * An unique id.
 * An adress.
 * An orientation.
 * A type it can be Appartement, Maison, or Terrain.
 * 
 * @see Orientation
 * @see BienType
 * 
 * @author Alex Jacquot
 * @author Guillaume Ducoeur
 */

package biens;

import agence.Agence;
import agence.Mandat;

public abstract class Bien {

	int idBien;
	String adresse;
	Orientation orientation;
	BienType bienType;// better to stock the type (enum) rather than do instanceof
	// Client proprietaire; WRONG!

	public Bien() {

	}

	/**
	 * Bien Constructor.
	 * 
	 * @param idBien
	 * @param adresse
	 * @param orientation
	 * @param bienType
	 */
	public Bien(int idBien, String adresse, Orientation orientation, BienType bienType) {
		this.idBien = idBien;
		this.adresse = adresse;
		this.orientation = orientation;
		this.bienType = bienType;
	}

	/**
	 * Return a BienType.
	 * 
	 * @see BienType
	 * 
	 * @return The type of Bien
	 */
	public BienType getBienType() {
		return bienType;
	}

	/**
	 * Return the Bien's id.
	 * 
	 * @return The id of Bien
	 */
	public int getIdBien() {
		return idBien;
	}

	/**
	 * Set a new id for the Bien.
	 * 
	 * @param idBien
	 */
	public void setIdBien(int idBien) {
		this.idBien = idBien;
	}

	/**
	 * Get the address of the Bien.
	 * 
	 * @return The address of Bien
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Set a new address.
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Get the orientation of the Bien.
	 * 
	 * @return the orientation of Bien
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bien) {
			Bien c = (Bien) obj;
			return (c.idBien == this.idBien);
		}
		return false;
	}

	public boolean hasMandat() {
		return Agence.getInstance().getMandatForBien(this) != null;
	}

	public Mandat getMandat() {
		return Agence.getInstance().getMandatForBien(this);
	}
}
