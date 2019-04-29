package it.unibo.dtn.JAL.exceptions;

/** General ALBP Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALException extends Exception {

	private static final long serialVersionUID = 5378300238838390343L;

	public JALException() {
	}

	public JALException(String message) {
		super(message);
	}

	public JALException(Throwable cause) {
		super(cause);
	}

	public JALException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
