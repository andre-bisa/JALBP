package it.unibo.dtn.JALBP.exceptions;

/** Receiver Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPReceiverException extends ALBPException {

	private static final long serialVersionUID = -3217931555123026583L;

	public ALBPReceiverException() {
	}

	public ALBPReceiverException(String message) {
		super(message);
	}

	public ALBPReceiverException(Throwable cause) {
		super(cause);
	}

	public ALBPReceiverException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPReceiverException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
