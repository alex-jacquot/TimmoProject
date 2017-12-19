import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
import command.AddBienCommand;
import command.AddClientCommand;
import command.AddMandatCommand;
import command.Command;
import command.ExitCommand;
import command.HelpCommand;
import command.ListBiensCommand;
import command.ListClientsCommand;
import exceptions.BienHasTwoMandatsException;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class Application {

	// static ApplicationState state = ApplicationState.ROOT;
	static ArrayList<Command> choices;

	/*
	 * public void setState(ApplicationState state) { this.state = state; }
	 */

	/**
	 * Crée des données de test
	 * 
	 * @throws BienHasTwoMandatsException
	 */
	@SuppressWarnings("unused")
	public static void createStartObjects() throws BienHasTwoMandatsException {
		Agence timmo = Agence.getInstance();
		// System.out.println(timmo);

		Maison maison = BienFactory.createMaison("10 allées Antonio Machado", Orientation.OUEST, 300, 6, 1,
				Chauffage.GAZ);
		// System.out.println(maison);

		Appartement appart = BienFactory.createAppartement("Appartement Constantinople", Orientation.EST, 5, 8, 322);
		// System.out.println(appart);

		Terrain terrain = BienFactory.createTerrain("Parc d'odyssud", Orientation.NORD, 300, 80);
		// System.out.println(terrain);

		Client poor = ClientFactory.createClient("Alex", "JACQUOT", "alex.jacquot.dev@gmail.com", "060417****");
		// System.out.println(poor);

		Client entrepreneur = ClientFactory.createClient("Guillaume", "DUCOEUR", "pickup@artist.com", "06*******");
		// System.out.println(entrepreneur);

		Mandat m = MandatFactory.createMandat(entrepreneur, maison, 10000,
				new Date(Date.UTC(2018, 12, 10, 00, 00, 00)));

		// System.out.println(BienManager.getInstance().getBiens());
	}

	public static void main(String[] args)
			throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {

		createStartObjects();

		Scanner sc = new Scanner(System.in);
		String cmd;
		while (true) {
			System.out.println("\nEntrez une commande: tapez 'help' pour la liste des commandes");
			cmd = sc.nextLine();

			switch (cmd) {
			case "help":
				new HelpCommand().executeCommand();
				break;
			case "add client":
				new AddClientCommand().executeCommand();
				break;
			case "add bien":
				new AddBienCommand().executeCommand();
				break;
			case "add mandat":
				new AddMandatCommand().executeCommand();
				break;
			case "list clients":
				new ListClientsCommand().executeCommand();
				break;
			case "list biens":
				new ListBiensCommand().executeCommand();
				break;
			case "exit":
				new ExitCommand().executeCommand();
				break;
			default:
				System.out.println("Commande non reconnue");
				break;
			}
		}
	}

}
