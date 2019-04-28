package dtn.net.exceptions;

/** Receive Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPReceiveException extends ALBPException {

	private static final long serialVersionUID = -390109630242053984L;

	public ALBPReceiveException() {
	}

	public ALBPReceiveException(String message) {
		super(message);
	}

	public ALBPReceiveException(Throwable cause) {
		super(cause);
	}

	public ALBPReceiveException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPReceiveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
