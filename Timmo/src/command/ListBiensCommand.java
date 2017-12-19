package command;

import biens.BienManager;

public class ListBiensCommand implements Command {

	@Override
	public void executeCommand() {
		System.out.println(BienManager.getInstance().listBiens());

	}

	@Override
	public String writeCommand() {
		return "'list biens': Lister les biens de l'agence";
	}

}
