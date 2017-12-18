import java.util.ArrayList;
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
import command.Command;
import command.SellBienCommand;
import exceptions.BienHasTwoMandatsException;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class Application {

	static ApplicationState state = ApplicationState.ROOT;
	static ArrayList<Command> choices;

	public void setState(ApplicationState state) {
		this.state = state;
	}

	public void createStartObjects() throws BienHasTwoMandatsException {
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

	public static void main(String[] args)
			throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {

		switch (state) {
		case ROOT:

			updateChoices(new SellBienCommand());

			break;

		case CREATE_CLIENT:

			break;
		default:
			break;

		}
	}

	private static void updateChoices(Command... commands) {
		choices = new ArrayList(); // empty
		for (Command c : commands) {
			choices.add(c);
		}
		choices.add(new ReturnCommand());
	}
}
