package command;

public class ExitCommand implements Command {

	@Override
	public void executeCommand() {
		System.out.println("Exiting");
		System.exit(0);
	}

	@Override
	public String writeCommand() {
		return "'exit': Quitter le programme";
	}

}
