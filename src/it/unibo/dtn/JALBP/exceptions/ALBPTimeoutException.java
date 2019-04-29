package it.unibo.dtn.JALBP.exceptions;

/**Timeout Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPTimeoutException extends ALBPException {

	private static final long serialVersionUID = 3461692587016464226L;

	public ALBPTimeoutException() {
	}

	public ALBPTimeoutException(String message) {
		super(message);
	}

	public ALBPTimeoutException(Throwable cause) {
		super(cause);
	}

	public ALBPTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
