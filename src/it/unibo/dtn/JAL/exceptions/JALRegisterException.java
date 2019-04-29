package it.unibo.dtn.JAL.exceptions;

/** Register Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALRegisterException extends JALException {

	private static final long serialVersionUID = 5626146390624728511L;

	public JALRegisterException() {
	}

	public JALRegisterException(String message) {
		super(message);
	}

	public JALRegisterException(Throwable cause) {
		super(cause);
	}

	public JALRegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALRegisterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
