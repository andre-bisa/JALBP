package it.unibo.dtn.JALBP.exceptions;

/** DTN2 Parameters Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPDTN2ParametersException extends ALBPException {

	private static final long serialVersionUID = 5622502052099262112L;

	public ALBPDTN2ParametersException() {
	}

	public ALBPDTN2ParametersException(String message) {
		super(message);
	}

	public ALBPDTN2ParametersException(Throwable cause) {
		super(cause);
	}

	public ALBPDTN2ParametersException(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPDTN2ParametersException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
