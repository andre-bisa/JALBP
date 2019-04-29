package it.unibo.dtn.JALBP.exceptions;

/** Open Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPOpenException extends ALBPException {

	private static final long serialVersionUID = 8131873839176367226L;

	public ALBPOpenException() {
	}

	public ALBPOpenException(String message) {
		super(message);
	}

	public ALBPOpenException(Throwable cause) {
		super(cause);
	}

	public ALBPOpenException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPOpenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
