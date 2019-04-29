package it.unibo.dtn.JAL.exceptions;

/**Timeout Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALTimeoutException extends JALException {

	private static final long serialVersionUID = 3461692587016464226L;

	public JALTimeoutException() {
	}

	public JALTimeoutException(String message) {
		super(message);
	}

	public JALTimeoutException(Throwable cause) {
		super(cause);
	}

	public JALTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
