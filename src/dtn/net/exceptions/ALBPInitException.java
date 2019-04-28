package dtn.net.exceptions;

/** Init Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPInitException extends ALBPException {

	private static final long serialVersionUID = 3716072856487089335L;

	public ALBPInitException() {
	}

	public ALBPInitException(String message) {
		super(message);
	}

	public ALBPInitException(Throwable cause) {
		super(cause);
	}

	public ALBPInitException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
