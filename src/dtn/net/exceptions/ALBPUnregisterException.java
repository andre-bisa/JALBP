package dtn.net.exceptions;

/** Unregister Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPUnregisterException extends ALBPException {

	private static final long serialVersionUID = -2950992698091156927L;

	public ALBPUnregisterException() {
	}

	public ALBPUnregisterException(String message) {
		super(message);
	}

	public ALBPUnregisterException(Throwable cause) {
		super(cause);
	}

	public ALBPUnregisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPUnregisterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
