package it.unibo.dtn.JAL.exceptions;

/** DTN2 Parameters Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALDTN2ParametersException extends JALException {

	private static final long serialVersionUID = 5622502052099262112L;

	public JALDTN2ParametersException() {
	}

	public JALDTN2ParametersException(String message) {
		super(message);
	}

	public JALDTN2ParametersException(Throwable cause) {
		super(cause);
	}

	public JALDTN2ParametersException(String message, Throwable cause) {
		super(message, cause);
	}

	public JALDTN2ParametersException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
