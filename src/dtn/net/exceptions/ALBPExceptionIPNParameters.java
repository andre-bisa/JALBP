package dtn.net.exceptions;

/** Exception IPN Parameters Exception.
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPExceptionIPNParameters extends ALBPException {

	private static final long serialVersionUID = 5896208923655896757L;

	public ALBPExceptionIPNParameters() {
	}

	public ALBPExceptionIPNParameters(String message) {
		super(message);
	}

	public ALBPExceptionIPNParameters(Throwable cause) {
		super(cause);
	}

	public ALBPExceptionIPNParameters(String message, Throwable cause) {
		super(message, cause);
	}

	public ALBPExceptionIPNParameters(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
