package it.unibo.dtn.JAL.exceptions;

/** Exception IPN Parameters Exception.
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALExceptionIPNParameters extends JALException {

	private static final long serialVersionUID = 5896208923655896757L;

	public JALExceptionIPNParameters() {
	}

	public JALExceptionIPNParameters(String message) {
		super(message);
	}

	public JALExceptionIPNParameters(Throwable cause) {
		super(cause);
	}

	public JALExceptionIPNParameters(String message, Throwable cause) {
		super(message, cause);
	}

	public JALExceptionIPNParameters(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
