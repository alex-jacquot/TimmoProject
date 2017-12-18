package biens;

public class Terrain extends Bien {

	int surfaceSol;
	int longueurFacade;

	public Terrain() {
		super();

	}

	public Terrain(int idBien, String adresse, Orientation orientation, int surfaceSol, int longueurFacade) {
		super(idBien, adresse, orientation, BienType.TERRAIN);
		this.surfaceSol = surfaceSol;
		this.longueurFacade = longueurFacade;

	}

	public int getSurfaceSol() {
		return surfaceSol;
	}

	public int getLongueurFacade() {
		return longueurFacade;
	}

}
