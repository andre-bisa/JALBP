package it.unibo.dtn.JAL.exceptions;

import it.unibo.dtn.JAL.exceptions.JALException;

/** Reception Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALReceptionInterruptedException extends JALException {

	private static final long serialVersionUID = -3447143910599245491L;

	public JALReceptionInterruptedException() {
	}

	public JALReceptionInterruptedException(String message) {
		super(message);
	}

	public JALReceptionInterruptedException(Throwable cause) {
		super(cause);
	}

	public JALReceptionInterruptedException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALReceptionInterruptedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
