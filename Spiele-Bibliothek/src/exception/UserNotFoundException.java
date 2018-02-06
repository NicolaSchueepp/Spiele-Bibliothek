package exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7816937761248610833L;

	public UserNotFoundException(String message) {
		super(message);
	}
}