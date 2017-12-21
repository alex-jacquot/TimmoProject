/**
 * Contains the various, static form methods to create a Bien, Client or Mandat via
 * console interface
 * 
 * @see Bien
 * @see Client
 * @see Mandat
 */

package agence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import biens.Appartement;
import biens.Bien;
import biens.BienFactory;
import biens.BienManager;
import biens.BienType;
import biens.Chauffage;
import biens.Orientation;
import clients.Client;
import clients.ClientFactory;
import clients.ClientManager;
import exceptions.BienHasTwoMandatsException;

public class Forms {

	public static void formMandat() {

		Scanner scan = new Scanner(System.in);
		int idClient;
		int idBien;
		Client c = null;
		Bien b = null;
		boolean done = false;
		boolean goodClient = false;
		Date date = null;

		do {

			System.out.println("Entrez l'id du client:");
			// This is actually this simple f*** yeah
			if (scan.hasNextInt())
				idClient = scan.nextInt();
			else {
				scan.next();
				continue;
			}

			c = ClientManager.getInstance().getClientById(idClient);
			if (c == null) {
				System.out.println("Aucun client avec cet id");
			} else {
				System.out.println("Est-ce le bon client? Y/N \n" + c);

				do {
					String temp = scan.next();
					if (temp.equals("Y")) {
						done = true;
						goodClient = true;
					} else if (temp.equals("N")) {
						done = true;
					}
				} while (!done);
			}
		} while (!goodClient);

		boolean goodBien = false;
		done = false;

		do {

			System.out.println("Entrez l'id du bien:");
			// This is actually this simple f*** yeah
			if (scan.hasNextInt())
				idBien = scan.nextInt();
			else {
				scan.next();
				continue;
			}

			b = BienManager.getInstance().getBienById(idBien);
			if (b == null) {
				System.out.println("Aucun bien avec cet id");
			} else if (b.hasMandat()) {
				System.out.println("Erreur le bien est déjà en vente");
				continue;
			} else {
				System.out.println("Est-ce le bon bien? Y/N \n" + b);

				do {
					String temp = scan.next();
					if (temp.equals("Y")) {
						done = true;
						goodBien = true;
					} else if (temp.equals("N")) {
						done = true;
					}
				} while (!done);
			}
		} while (!goodBien);
		int prix = 0;
		do {

			System.out.println("Entrez le prix de vente:");
			if (scan.hasNextInt())
				prix = scan.nextInt();
			else {
				scan.next();
				continue;
			}
		} while (1 > prix);

		System.out.println("Entrez la date limite (DD-MM-YYYY):");
		do {
			SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
			String dateString;
			done = false;

			dateString = scan.next();
			try {
				date = sdf.parse(dateString);
				done = true;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Mauvais format de date(DD-MM-YYYY attendu), recommencer");
				continue;
			}

		} while (!done);

		try {
			MandatFactory.createMandat(c, b, prix, date);
			System.out.println("Mandat crée!");
		} catch (BienHasTwoMandatsException e) {
			System.err.println("Un Bien ne peut avoir 2 mandats");
		}

	}

	public static void formClient() {
		Scanner scan = new Scanner(System.in);
		String nomClient, prenomClient, email, numTel;
		do {
			System.out.println("Entrez le prenom du client:"); // Asks question
			prenomClient = scan.nextLine();
		} while (prenomClient.isEmpty());

		do {
			System.out.println("Entrez le nom du client:");
			nomClient = scan.nextLine();
		} while (nomClient.isEmpty());

		do {
			System.out.println("Entrez l'email du client:");
			email = scan.nextLine();
		} while (email.isEmpty());

		do {
			System.out.println("Entrez le téléphone du client:");
			numTel = scan.nextLine();
		} while (numTel.isEmpty());

		ClientFactory.createClient(nomClient, prenomClient, email, numTel);

	}

	public static void formBien() {
		Scanner scan = new Scanner(System.in);
		String adresseBien;
		Orientation orientation;
		BienType bienType;
		int temp = 0;

		do {
			System.out.println("Entrez l'adresse du bien:"); // Asks question

			adresseBien = scan.nextLine();
		} while (adresseBien.isEmpty());

		do {

			System.out.println("Entrez l'orientation du bien:\n" + "1.OUEST\n" + "2.NORD\n" + "3.EST\n" + "4.SUD");
			// This is actually this simple f*** yeah
			if (scan.hasNextInt())
				temp = scan.nextInt();
			else {
				scan.next();
				continue;
			}

		} while (1 > temp || 4 < temp);

		orientation = Orientation.values()[temp - 1];

		do {

			System.out.println("Entrez le type du bien:\n" + "1.APPARTEMENT\n" + "2.MAISON\n" + "3.TERRAIN\n");
			if (scan.hasNextInt())
				temp = scan.nextInt();
			else {
				scan.next();
				continue;
			}
		} while (1 > temp || 3 < temp);
		bienType = BienType.values()[temp - 1];

		switch (bienType) {
		case MAISON:
			int surfaceHabitable = 0, nombrePieces = 0, nombreEtages = 0;
			Chauffage moyenChauffage;
			do {
				System.out.println("Entrez la surface habitable:");
				if (scan.hasNextInt())
					surfaceHabitable = scan.nextInt();
				else {
					scan.next();
					continue;
				}

			} while (1 > surfaceHabitable || 1000 < surfaceHabitable);

			do {
				System.out.println("Entrez le nombre de pieces:");
				if (scan.hasNextInt())
					nombrePieces = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombrePieces || 100 < nombrePieces);

			do {
				System.out.println("Entrez le nombre d'étages:");
				if (scan.hasNextInt())
					nombreEtages = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombreEtages || 100 < nombreEtages);

			do {
				System.out.println("Entrez le moyen de chauffage:\n" + "1.ELECTRICITE\n" + "2.GAZ\n");
				if (scan.hasNextInt())
					temp = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > temp || 2 < temp);
			moyenChauffage = Chauffage.values()[temp - 1];
			Bien maison = BienFactory.createMaison(adresseBien, orientation, surfaceHabitable, nombrePieces,
					nombreEtages, moyenChauffage);
			System.out.println("Maison (id n°" + maison.getIdBien() + ") crée!");
			break;

		case APPARTEMENT:
			int etage = 0, nombreDePieces = 0, chargesMensuelles = 0;
			do {
				System.out.println("Entrez l'étage:");
				if (scan.hasNextInt())
					etage = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > etage || etage > 100);

			do {
				System.out.println("Entrez le nombre de pieces:");
				if (scan.hasNextInt())
					nombreDePieces = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > nombreDePieces || 20 < nombreDePieces);

			do {
				System.out.println("Entrez les charges mensuelles:");
				if (scan.hasNextInt())
					chargesMensuelles = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > chargesMensuelles || 2000 < chargesMensuelles);
			Appartement appart = BienFactory.createAppartement(adresseBien, orientation, etage, nombreDePieces,
					chargesMensuelles);
			System.out.println("Appartement (id n°" + appart.getIdBien() + ") crée!");
			break;

		case TERRAIN:
			int surfaceSol = 0;
			int longueurFacade = 0;
			do {
				System.out.println("Entrez la surface au sol:");
				if (scan.hasNextInt())
					surfaceSol = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > surfaceSol || 1000 < surfaceSol);

			do {
				System.out.println("Entrez la longueur de façade:");
				if (scan.hasNextInt())
					longueurFacade = scan.nextInt();
				else {
					scan.next();
					continue;
				}
			} while (1 > longueurFacade || 1000 < longueurFacade);
			Bien terrain = BienFactory.createTerrain(adresseBien, orientation, surfaceSol, longueurFacade);
			System.out.println("Terrain (id n°" + terrain.getIdBien() + ") crée!");
			break;
		}

		// BienFactory.createBien();
	}
}
