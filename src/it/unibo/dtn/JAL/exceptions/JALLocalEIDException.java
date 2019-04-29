package it.unibo.dtn.JAL.exceptions;

/** Local EndpointID Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALLocalEIDException extends JALException {

	private static final long serialVersionUID = -1010954074533901681L;

	public JALLocalEIDException() {
	}

	public JALLocalEIDException(String message) {
		super(message);
	}

	public JALLocalEIDException(Throwable cause) {
		super(cause);
	}

	public JALLocalEIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALLocalEIDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
