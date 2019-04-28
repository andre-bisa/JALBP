package dtn.net;

import java.io.Closeable;
import java.io.IOException;

import dtn.net.endpoint.DTNEndpointID;
import dtn.net.exceptions.ALBPException;
import dtn.net.exceptions.ALBPTimeoutException;

/** ALBPSocket. It let to send and receive {@link ALBPBundle}s<br>
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPSocket implements Closeable {

	private int registrationDescriptor = -1;
	private boolean registered = false;
	
	private int timeout = 60;
	private ALBPBundlePayloadLocation payloadLocation = ALBPBundlePayloadLocation.Memory;
	
	private DTNEndpointID myEID = null;
	
	private ALBPSocket() throws ALBPException {
		ALBPEngine.getInstance(); // To be sure it is initialized
	}

	/**
	 * 
	 * @return The amount of seconds to wait after throwing {@link ALBPTimeoutException} in {@link #receive()} 
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * Sets the amount of seconds to wait after throwing {@link ALBPTimeoutException} in {@link #receive()} 
	 * @param seconds The seconds
	 */
	public void setTimeout(int seconds) {
		this.timeout = seconds;
	}

	/**
	 * Get where to save the Bundle
	 * @return The payload location
	 */
	public ALBPBundlePayloadLocation getPayloadLocation() {
		return payloadLocation;
	}

	/**
	 * Sets where to save the bundle
	 * @param payloadLocation Where to save the bundle
	 */
	public void setPayloadLocation(ALBPBundlePayloadLocation payloadLocation) {
		this.payloadLocation = payloadLocation;
	}
	
	/**
	 * Function used in JNI (in C code)
	 * @param rd = registration descriptor
	 */
	private void setRegistrationDescriptor(int rd) {
		this.registrationDescriptor = rd;
	}

	/**
	 * Closes the ALBPSocket.
	 * @throws IOException The IOException incapsulates the {@link ALBPException}
	 */
	@Override
	public void close() throws IOException {
		int result = ALBPSocket.c_unregister(this.registrationDescriptor);
		try {
			ALBPExceptionManager.checkError(result);
		} catch (ALBPException e) {
			throw new IOException(e);
		}
		this.registered = false;
	}
	
	/**
	 * Receives a Bundle from DTN
	 * @return The ALBPBundle received
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public ALBPBundle receive() throws ALBPException {
		ALBPBundle result = new ALBPBundle();
		
		int ris = c_receive(this.registrationDescriptor, result, payloadLocation.getValue(), timeout);
		
		ALBPExceptionManager.checkError(ris, "Error on receiving bundle.");
		return result;
	}
	
	/**
	 * The same as {@link #setTimeout(int)} followed by receive
	 * @param timeout In seconds
	 * @return The Bundle received
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public ALBPBundle receive(int timeout) throws ALBPException {
		this.setTimeout(timeout);
		return this.receive();
	}
	
	/**
	 * The same as {@link #setPayloadLocation(ALBPBundlePayloadLocation)} followed by receive
	 * @param location Payload location
	 * @return The bundle received
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public ALBPBundle receive(ALBPBundlePayloadLocation location) throws ALBPException {
		this.setPayloadLocation(location);
		return this.receive();
	}
	
	/**
	 * The same as {@link #setTimeout(int)} and {@link #setPayloadLocation(ALBPBundlePayloadLocation)} followed by receive
	 * @param location Payload location
	 * @param timeout In seconds
	 * @return The bundle received
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public ALBPBundle receive(ALBPBundlePayloadLocation location, int timeout) throws ALBPException {
		this.setPayloadLocation(location);
		this.setTimeout(timeout);
		return this.receive();
	}
	
	/**
	 * Sends a Bundle through the DTN connection
	 * @param bundle The Bundle to send
	 * @throws ALBPException According to ALBPException.
	 * @throws IllegalArgumentException In case the expiration is &#60;= 0 or the destination is invalid.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public void send(ALBPBundle bundle) throws ALBPException, IllegalArgumentException {
		if (bundle.getExpiration() <= 0)
			throw new IllegalArgumentException("The expiration can't be <= 0.");
		if (bundle.getDestination().toString().length() <= 0)
			throw new IllegalArgumentException("The destination can't be empty.");
		
		int ris = c_send(this.registrationDescriptor, bundle);
		ALBPExceptionManager.checkError(ris, "Error on sending bundle.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + registrationDescriptor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ALBPSocket)) {
			return false;
		}
		ALBPSocket other = (ALBPSocket) obj;
		if (registrationDescriptor != other.registrationDescriptor) {
			return false;
		}
		return true;
	}
	
	/**
	 * Creates a ALBPSocket from a demuxIPN
	 * @param demuxIPN The demux
	 * @return A registered ALBPSocket
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public static ALBPSocket of(int demuxIPN) throws ALBPException {
		return ALBPSocket.of("", demuxIPN);
	}
	
	/**
	 * Creates a ALBPSocket from a demuxDTN
	 * @param demuxDTN The demux
	 * @return A registered ALBPSocket
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public static ALBPSocket of(String demuxDTN) throws ALBPException {
		return ALBPSocket.of(demuxDTN, 0);
	}
	
	/**
	 * Creates a ALBPSocket from a demuxIPN and demuxDTN
	 * @param demuxDTN The demuxDTN
	 * @param demuxIPN The demuxIPN
	 * @return A registered ALBPSocket
	 * @throws ALBPException According to ALBPException.
	 * @see ALBPException
	 * @see ALBPExceptionManager
	 */
	public static ALBPSocket of(String demuxDTN, int demuxIPN) throws ALBPException {
		ALBPSocket result = new ALBPSocket();
		int error = ALBPSocket.c_register(result, demuxDTN, demuxIPN);
		ALBPExceptionManager.checkError(error, "Error on registering DTN socket.");
		result.registered = true;
		return result;
	}
	
	private static native int c_register(ALBPSocket socket, String dtnDemuxString, int IPNDemux); 
	private static native int c_unregister(int registrationDescriptor);
	private static native int c_receive(int registrationDescriptor, ALBPBundle bundle, int payloadLocation, int timeout);
	private static native int c_send(int registrationDescriptor, ALBPBundle bundle);
	
}
