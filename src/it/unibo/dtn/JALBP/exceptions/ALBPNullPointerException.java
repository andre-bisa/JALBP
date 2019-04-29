package it.unibo.dtn.JALBP.exceptions;

/** NullPointerException passed to C code
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPNullPointerException extends ALBPException {

	private static final long serialVersionUID = 2343869017726215223L;

	public ALBPNullPointerException() {
	}

	public ALBPNullPointerException(String message) {
		super(message);
	}

	public ALBPNullPointerException(Throwable cause) {
		super(cause);
	}

	public ALBPNullPointerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPNullPointerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
