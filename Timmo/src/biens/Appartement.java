package biens;

public class Appartement extends Bien {
	int etage;
	int nombreDePieces;
	int chargesMensuelles;

	public Appartement(int idBien, String adresse, Orientation orientation, int etage, int nombreDePieces,
			int chargesMensuelles) {

		super(idBien, adresse, orientation, BienType.APPARTEMENT);
		this.etage = etage;
		this.nombreDePieces = nombreDePieces;
		this.chargesMensuelles = chargesMensuelles;

	}
}
