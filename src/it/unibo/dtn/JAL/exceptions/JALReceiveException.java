package it.unibo.dtn.JAL.exceptions;

/** Receive Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALReceiveException extends JALException {

	private static final long serialVersionUID = -390109630242053984L;

	public JALReceiveException() {
	}

	public JALReceiveException(String message) {
		super(message);
	}

	public JALReceiveException(Throwable cause) {
		super(cause);
	}

	public JALReceiveException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALReceiveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
