package dtn.net.exceptions;

/** Register Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPRegisterException extends ALBPException {

	private static final long serialVersionUID = 5626146390624728511L;

	public ALBPRegisterException() {
	}

	public ALBPRegisterException(String message) {
		super(message);
	}

	public ALBPRegisterException(Throwable cause) {
		super(cause);
	}

	public ALBPRegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPRegisterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
