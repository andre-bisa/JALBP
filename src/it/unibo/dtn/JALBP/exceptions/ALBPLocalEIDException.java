package it.unibo.dtn.JALBP.exceptions;

/** Local EndpointID Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPLocalEIDException extends ALBPException {

	private static final long serialVersionUID = -1010954074533901681L;

	public ALBPLocalEIDException() {
	}

	public ALBPLocalEIDException(String message) {
		super(message);
	}

	public ALBPLocalEIDException(Throwable cause) {
		super(cause);
	}

	public ALBPLocalEIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPLocalEIDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
