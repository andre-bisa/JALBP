package dtn.net.exceptions;

/** Close Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPCloseErrorException extends ALBPException {

	private static final long serialVersionUID = 6929339757136887871L;

	public ALBPCloseErrorException() {
	}

	public ALBPCloseErrorException(String message) {
		super(message);
	}

	public ALBPCloseErrorException(Throwable cause) {
		super(cause);
	}

	public ALBPCloseErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPCloseErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
