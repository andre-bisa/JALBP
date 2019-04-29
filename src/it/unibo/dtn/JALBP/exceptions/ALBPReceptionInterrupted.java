package it.unibo.dtn.JALBP.exceptions;

import it.unibo.dtn.JALBP.exceptions.ALBPException;

/** Reception Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPReceptionInterrupted extends ALBPException {

	private static final long serialVersionUID = -3447143910599245491L;

	public ALBPReceptionInterrupted() {
	}

	public ALBPReceptionInterrupted(String message) {
		super(message);
	}

	public ALBPReceptionInterrupted(Throwable cause) {
		super(cause);
	}

	public ALBPReceptionInterrupted(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPReceptionInterrupted(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
