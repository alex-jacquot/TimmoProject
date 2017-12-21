package command;

public class HelpCommand implements Command {

	@Override
	public void executeCommand() {
		Command[] tab = { new AddBienCommand(), new AddClientCommand(), new AddMandatCommand(), new ExitCommand(),
				new ListBiensCommand(), new ListClientsCommand(), new ListMandatsCommand() };
		for (Command c : tab) {
			System.out.println(c.writeCommand());
		}
	}

	@Override
	public String writeCommand() {
		return "'help': ben, cette commande en fait";
	}

}
