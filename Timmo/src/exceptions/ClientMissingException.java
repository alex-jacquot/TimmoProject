package exceptions;

public class ClientMissingException extends Exception {

	@Override
	public String getMessage() {
		return "Error: Client missing";
		//test
	}
	
}
