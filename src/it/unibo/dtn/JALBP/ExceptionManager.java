package it.unibo.dtn.JALBP;

import it.unibo.dtn.JALBP.exceptions.ALBPCloseErrorException;
import it.unibo.dtn.JALBP.exceptions.ALBPDTN2ParametersException;
import it.unibo.dtn.JALBP.exceptions.ALBPException;
import it.unibo.dtn.JALBP.exceptions.ALBPExceptionIPNParameters;
import it.unibo.dtn.JALBP.exceptions.ALBPInitException;
import it.unibo.dtn.JALBP.exceptions.ALBPLocalEIDException;
import it.unibo.dtn.JALBP.exceptions.ALBPNoImplementationFoundException;
import it.unibo.dtn.JALBP.exceptions.ALBPNotRegisteredException;
import it.unibo.dtn.JALBP.exceptions.ALBPNullPointerException;
import it.unibo.dtn.JALBP.exceptions.ALBPOpenException;
import it.unibo.dtn.JALBP.exceptions.ALBPReceiveException;
import it.unibo.dtn.JALBP.exceptions.ALBPReceiverException;
import it.unibo.dtn.JALBP.exceptions.ALBPReceptionInterrupted;
import it.unibo.dtn.JALBP.exceptions.ALBPRegisterException;
import it.unibo.dtn.JALBP.exceptions.ALBPSendException;
import it.unibo.dtn.JALBP.exceptions.ALBPTimeoutException;
import it.unibo.dtn.JALBP.exceptions.ALBPUnregisterException;

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
	 * @throws ALBPException In case the error is an Exception
	 */
	public static void checkError(int error, String errorString) throws ALBPException {
		switch (error) {
		case 0: // Everything is ok
			break;

		case 1:	throw new ALBPNullPointerException(errorString + " Error, null pointer passed to C code.");

		case 2:	throw new ALBPInitException(errorString + " Error on initializing ALBP.");

		case 3:	throw new ALBPOpenException(errorString + " Error on opening DTN socket.");

		case 4:	throw new ALBPLocalEIDException(errorString + " Error on building local EID.");

		case 5:	throw new ALBPRegisterException(errorString + " Error on registering DTN socket.");

		case 6:	throw new ALBPCloseErrorException(errorString + " Error on closing DTN socket.");

		case 7:	throw new ALBPUnregisterException(errorString + " Error on unregistering DTN socket.");

		case 8:	throw new ALBPNotRegisteredException(errorString + " Error, the socket was not registered.");

		case 9: throw new ALBPSendException(errorString + " General error on sending bundle.");
		
		case 10: throw new ALBPReceiveException(errorString + " General error on receiving bundle.");
		
		case 11: throw new ALBPReceptionInterrupted(errorString + " Error, the reception was interrupted.");

		case 12: throw new ALBPTimeoutException(errorString + " Error, timeout on receiving bundle.");
		
		case 13: throw new ALBPReceiverException(errorString + " Error, the receiver is not indicated or is dtn:none.");
		
		case 14: throw new ALBPExceptionIPNParameters(errorString + " Error on passing value for IPN schema.");

		case 15: throw new ALBPDTN2ParametersException(errorString + " Error on parameters passed to DTN2.");

		case 16: throw new ALBPNoImplementationFoundException(errorString + " Error, no implementation found.");

		default: throw new ALBPException(errorString + " General error occurred. The error is not defined. Error code=" + error);
		}
	}

	/**
	 * The same as {@link #checkError(int, String) checkError} but without the costum String
	 * @param error The error resulted in AL_BP
	 * @throws ALBPException In case the error is an Exception
	 */
	public static void checkError(int error) throws ALBPException {
		checkError(error, "");
	}

}
