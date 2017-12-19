package command;

import clients.ClientManager;

public class ListClientsCommand implements Command {

	@Override
	public void executeCommand() {
		System.out.println(ClientManager.getInstance().listClients());

	}

	@Override
	public String writeCommand() {
		return "'list clients': Lister les clients de l'agence";
	}

}
