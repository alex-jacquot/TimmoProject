/** AddBienCommand.java
 * 
 * Command calling the call of the form for the creation of a Bien
 * 
 * Notes: AddBienCommand is a Concrete Command from the Command design pattern
 * 
 * @see Command
 * @author Alex Jacquot
 * */

package command;

import agence.Forms;

public class AddBienCommand implements Command {

	@Override
	public void executeCommand() {
		Forms.formBien();
		// System.out.println("Bien crée");
	}

	@Override
	public String writeCommand() {
		return "'add bien': Ajoute un bien dans la BD";
	}

}
