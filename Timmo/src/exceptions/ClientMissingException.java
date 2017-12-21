/**
 * 
 * Thrown when a Client is missing. Unused.
 * 
 * 
 * 
 * @author Alex Jacquot
 * */

package exceptions;

public class ClientMissingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error: Client missing";
	}
	
}
