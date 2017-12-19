package command;

import clients.ClientManager;

public class AddClientCommand implements Command {

	@Override
	public void executeCommand() {
		ClientManager.getInstance().formClient();
		System.out.println("Client crée");
	}

	@Override
	public String writeCommand() {
		return "'add client': Ajoute un client dans la BD";
	}

}
