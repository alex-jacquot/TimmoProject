package biens;

public class BienFactory {

	public static Maison createMaison(String adresse, Orientation orientation, int surfaceHabitable, int nombrePieces,
			int nombreEtages, Chauffage moyenChauffage) {

		Maison m = new Maison(BienManager.idBienIncrement, adresse, orientation, surfaceHabitable, nombrePieces,
				nombreEtages, moyenChauffage);

		BienManager.getInstance().addBien(m);

		return m;
	}

	public static Appartement createAppartement(String adresse, Orientation orientation, int etage, int nombreDePieces,
			int chargesMensuelles) {

		Appartement a = new Appartement(BienManager.idBienIncrement, adresse, orientation, etage, nombreDePieces,
				chargesMensuelles);

		BienManager.getInstance().addBien(a);

		return a;
	}

	public static Terrain createTerrain(String adresse, Orientation orientation, int surfaceSol, int longueurFacade) {

		Terrain t = new Terrain(BienManager.idBienIncrement, adresse, orientation, surfaceSol, longueurFacade);

		BienManager.getInstance().addBien(t);

		return t;
	}
}
