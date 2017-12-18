import java.util.Date;

import agence.Agence;
import agence.Mandat;
import agence.MandatFactory;
import biens.Appartement;
import biens.BienFactory;
import biens.Chauffage;
import biens.Maison;
import biens.Orientation;
import biens.Terrain;
import clients.Client;
import clients.ClientFactory;
import exceptions.BienHasTwoMandatsException;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class Application {

	public static void main(String[] args)
			throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {

		Agence timmo = Agence.getInstance();
		System.out.println(timmo);

		Maison maison = BienFactory.createMaison("10 allées Antonio Machado", Orientation.OUEST, 300, 6, 1,
				Chauffage.GAZ);
		System.out.println(maison);

		Appartement appart = BienFactory.createAppartement("Appartement Constantinople", Orientation.EST, 5, 8, 322);
		System.out.println(appart);

		Terrain terrain = BienFactory.createTerrain("Parc d'odyssud", Orientation.NORD, 300, 80);
		System.out.println(terrain);

		Client poor = ClientFactory.createClient("Guy", "Poor", "toopoor@4mail.com", "N/A");// No biens, no voeux
		System.out.println(poor);

		Client entrepreneur = ClientFactory.createClient("Isell", "lottastuff", "contactme@andbuy.com", "123464646");
		System.out.println(entrepreneur);

		Mandat m = MandatFactory.createMandat(entrepreneur, maison, 10000,
				new Date(Date.UTC(2018, 12, 10, 00, 00, 00)));

		// System.out.println(BienManager.getInstance().getBiens());
	}
}
