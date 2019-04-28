package dtn.net.exceptions;

/** General ALBP Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPException extends Exception {

	private static final long serialVersionUID = 5378300238838390343L;

	public ALBPException() {
	}

	public ALBPException(String message) {
		super(message);
	}

	public ALBPException(Throwable cause) {
		super(cause);
	}

	public ALBPException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
