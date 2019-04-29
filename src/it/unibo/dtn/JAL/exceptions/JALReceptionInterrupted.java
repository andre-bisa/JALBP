package it.unibo.dtn.JAL.exceptions;

import it.unibo.dtn.JAL.exceptions.JALException;

/** Reception Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALReceptionInterrupted extends JALException {

	private static final long serialVersionUID = -3447143910599245491L;

	public JALReceptionInterrupted() {
	}

	public JALReceptionInterrupted(String message) {
		super(message);
	}

	public JALReceptionInterrupted(Throwable cause) {
		super(cause);
	}

	public JALReceptionInterrupted(String message, Throwable cause) {
		super(message, cause);
	}

	public JALReceptionInterrupted(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
