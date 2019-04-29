package it.unibo.dtn.JAL.exceptions;

/** Close Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALCloseErrorException extends JALException {

	private static final long serialVersionUID = 6929339757136887871L;

	public JALCloseErrorException() {
	}

	public JALCloseErrorException(String message) {
		super(message);
	}

	public JALCloseErrorException(Throwable cause) {
		super(cause);
	}

	public JALCloseErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALCloseErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
