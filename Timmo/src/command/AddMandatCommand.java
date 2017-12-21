/** Command calling the call of the form for the creation of a Mandat
 * 
 * Notes: AddMandatCommand is a Concrete Command from the Command design pattern
 * 
 * @see Command
 * @author Alex Jacquot
 * */

package command;

import agence.Forms;

public class AddMandatCommand implements Command {

	@Override
	public void executeCommand() {
		Forms.formMandat();

	}

	@Override
	public String writeCommand() {
		return "'add mandat': Ajoute un mandat de vente";
	}

}
