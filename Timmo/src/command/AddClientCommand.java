/** Command calling the call of the form for the creation of a Client
 * 
 * Notes: AddClientCommand is a Concrete Command from the Command design pattern
 * 
 * @see Command
 * @author Alex Jacquot
 * */

package command;

import agence.Forms;

public class AddClientCommand implements Command {

	@Override
	public void executeCommand() {
		Forms.formClient();
	}

	@Override
	public String writeCommand() {
		return "'add client': Ajoute un client dans la BD";
	}

}
