package it.unibo.dtn.JAL;

import it.unibo.dtn.JAL.exceptions.JALCloseErrorException;
import it.unibo.dtn.JAL.exceptions.JALDTN2ParametersException;
import it.unibo.dtn.JAL.exceptions.JALException;
import it.unibo.dtn.JAL.exceptions.JALExceptionIPNParameters;
import it.unibo.dtn.JAL.exceptions.JALInitException;
import it.unibo.dtn.JAL.exceptions.JALLocalEIDException;
import it.unibo.dtn.JAL.exceptions.JALNoImplementationFoundException;
import it.unibo.dtn.JAL.exceptions.JALNotRegisteredException;
import it.unibo.dtn.JAL.exceptions.JALNullPointerException;
import it.unibo.dtn.JAL.exceptions.JALOpenException;
import it.unibo.dtn.JAL.exceptions.JALReceiveException;
import it.unibo.dtn.JAL.exceptions.JALReceiverException;
import it.unibo.dtn.JAL.exceptions.JALReceptionInterruptedException;
import it.unibo.dtn.JAL.exceptions.JALRegisterException;
import it.unibo.dtn.JAL.exceptions.JALSendException;
import it.unibo.dtn.JAL.exceptions.JALTimeoutException;
import it.unibo.dtn.JAL.exceptions.JALUnregisterException;

/** Exception Manager. Very usefull to have a generic resolution of ALBPExceptions.
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
class ExceptionManager {

	private ExceptionManager() {}
	
	/**
	 * Throws Exception in case the <b>error</b> is an AL_BP Exception
	 * @param error The error resulted in AL_BP
	 * @param errorString The custom String in case of Exception
	 * @throws JALException In case the error is an Exception
	 */
	public static void checkError(int error, String errorString) throws JALException {
		switch (error) {
		case 0: // Everything is ok
			break;

		case 1:	throw new JALNullPointerException(errorString + " Error, null pointer passed to C code.");

		case 2:	throw new JALInitException(errorString + " Error on initializing ALBP.");

		case 3:	throw new JALOpenException(errorString + " Error on opening DTN socket.");

		case 4:	throw new JALLocalEIDException(errorString + " Error on building local EID.");

		case 5:	throw new JALRegisterException(errorString + " Error on registering DTN socket.");

		case 6:	throw new JALCloseErrorException(errorString + " Error on closing DTN socket.");

		case 7:	throw new JALUnregisterException(errorString + " Error on unregistering DTN socket.");

		case 8:	throw new JALNotRegisteredException(errorString + " Error, the socket was not registered.");

		case 9: throw new JALSendException(errorString + " General error on sending bundle.");
		
		case 10: throw new JALReceiveException(errorString + " General error on receiving bundle.");
		
		case 11: throw new JALReceptionInterruptedException(errorString + " Error, the reception was interrupted.");

		case 12: throw new JALTimeoutException(errorString + " Error, timeout on receiving bundle.");
		
		case 13: throw new JALReceiverException(errorString + " Error, the receiver is not indicated or is dtn:none.");
		
		case 14: throw new JALExceptionIPNParameters(errorString + " Error on passing value for IPN schema.");

		case 15: throw new JALDTN2ParametersException(errorString + " Error on parameters passed to DTN2.");

		case 16: throw new JALNoImplementationFoundException(errorString + " Error, no implementation found.");

		default: throw new JALException(errorString + " General error occurred. The error is not defined. Error code=" + error);
		}
	}

	/**
	 * The same as {@link #checkError(int, String) checkError} but without the costum String
	 * @param error The error resulted in AL_BP
	 * @throws JALException In case the error is an Exception
	 */
	public static void checkError(int error) throws JALException {
		checkError(error, "");
	}

}
