package it.unibo.dtn.JAL.exceptions;

/** Receiver Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALReceiverException extends JALException {

	private static final long serialVersionUID = -3217931555123026583L;

	public JALReceiverException() {
	}

	public JALReceiverException(String message) {
		super(message);
	}

	public JALReceiverException(Throwable cause) {
		super(cause);
	}

	public JALReceiverException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALReceiverException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
