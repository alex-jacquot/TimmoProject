/**
 * Interface dfining a Command, conform to the Command design pattern.
 * 
 * @author Alex Jacquot
 */

package command;

public interface Command {

	/**
	 * Corresponding code from the model classes to be executed on command call.
	 */
	public void executeCommand();

	/**
	 * 
	 * @return Help text of the command
	 */
	public String writeCommand();

}
