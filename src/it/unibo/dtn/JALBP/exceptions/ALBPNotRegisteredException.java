package it.unibo.dtn.JALBP.exceptions;

/** Not registered Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPNotRegisteredException extends ALBPException {

	private static final long serialVersionUID = 9210458729062575129L;

	public ALBPNotRegisteredException() {
	}

	public ALBPNotRegisteredException(String message) {
		super(message);
	}

	public ALBPNotRegisteredException(Throwable cause) {
		super(cause);
	}

	public ALBPNotRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPNotRegisteredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
