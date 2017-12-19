package command;

import biens.BienManager;

public class AddBienCommand implements Command {

	@Override
	public void executeCommand() {
		BienManager.getInstance().formBien();
		System.out.println("Bien crée");
	}

	@Override
	public String writeCommand() {
		return "'add bien': Ajoute un bien dans la BD";
	}

}
