/** BienHasTwoMandatsExceptions.java
 * 
 * Exception thrown when attempting to create a Mandat for a Bien when it already has an associated Mandat.
 * 
 * Notes: AddBienCommand is a Command from the Command design pattern
 * 
 * @author Alex Jacquot
 * */

package exceptions;

public class BienHasTwoMandatsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Un bien ne peut avoir plus de 2 mandats";
	}

}
