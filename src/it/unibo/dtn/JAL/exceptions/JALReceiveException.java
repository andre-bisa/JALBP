package it.unibo.dtn.JAL.exceptions;

import java.io.IOException;

/** Receive Exception
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 *
 */
public class JALReceiveException extends IOException {

	private static final long serialVersionUID = -390109630242053984L;

	public JALReceiveException() {
	}

	public JALReceiveException(String message) {
		super(message);
	}

	public JALReceiveException(Throwable cause) {
		super(cause);
	}

	public JALReceiveException(String message, Throwable cause) {
		super(message, cause);
	}

}
