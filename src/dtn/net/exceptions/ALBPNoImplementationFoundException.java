package dtn.net.exceptions;

/** No Implementation Found Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPNoImplementationFoundException extends ALBPException {

	private static final long serialVersionUID = -6097056302780187215L;

	public ALBPNoImplementationFoundException() {
	}

	public ALBPNoImplementationFoundException(String message) {
		super(message);
	}

	public ALBPNoImplementationFoundException(Throwable cause) {
		super(cause);
	}

	public ALBPNoImplementationFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPNoImplementationFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
