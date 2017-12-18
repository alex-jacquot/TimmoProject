package biens;

public class Maison extends Bien {

	int surfaceHabitable;
	int nombrePieces;
	int nombreEtages;
	Chauffage moyenChauffage;

	public Maison() {
		super();

	}

	public Maison(int idBien, String adresse, Orientation orientation, int surfaceHabitable, int nombrePieces,
			int nombreEtages, Chauffage moyenChauffage) {
		super(idBien, adresse, orientation, BienType.MAISON);
		this.surfaceHabitable = surfaceHabitable;
		this.nombrePieces = nombrePieces;
		this.nombreEtages = nombreEtages;
		this.moyenChauffage = moyenChauffage;
	}

	public int getSurfaceHabitable() {
		return surfaceHabitable;
	}

	public int getNombrePieces() {
		return nombrePieces;
	}

	public int getNombreEtages() {
		return nombreEtages;
	}

	public Chauffage getMoyenChauffage() {
		return moyenChauffage;
	}

	@Override
	public String toString() {
		return "Bien id n�" + idBien + ": Maison situ�e � " + adresse + " orient� " + orientation + 
				", "+ surfaceHabitable + "m� habitables avec " + nombrePieces + " pi�ces sur "
				+ nombreEtages + " �tage" +(nombreEtages>1?"s":"")+", chauff� avec " + moyenChauffage;
	}

}
