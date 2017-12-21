package command;

import agence.Agence;

public class ListMandatsCommand implements Command {

	@Override
	public void executeCommand() {
		Agence.getInstance().getAvailableBiens();

	}

	@Override
	public String writeCommand() {
		return "'list mandats': Liste tous les biens en vente et leurs vendeurs";
	}

}
