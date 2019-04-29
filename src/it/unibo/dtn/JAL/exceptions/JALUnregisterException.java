package it.unibo.dtn.JAL.exceptions;

/** Unregister Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALUnregisterException extends JALException {

	private static final long serialVersionUID = -2950992698091156927L;

	public JALUnregisterException() {
	}

	public JALUnregisterException(String message) {
		super(message);
	}

	public JALUnregisterException(Throwable cause) {
		super(cause);
	}

	public JALUnregisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALUnregisterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
