package dtn.net.exceptions;

/** Send Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class ALBPSendException extends ALBPException {

	private static final long serialVersionUID = 8956910223105504096L;

	public ALBPSendException() {
	}

	public ALBPSendException(String arg0) {
		super(arg0);
	}

	public ALBPSendException(Throwable arg0) {
		super(arg0);
	}

	public ALBPSendException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ALBPSendException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
