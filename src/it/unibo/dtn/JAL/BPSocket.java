package it.unibo.dtn.JAL;

import java.io.Closeable;
import java.io.IOException;

import it.unibo.dtn.JAL.exceptions.JALException;
import it.unibo.dtn.JAL.exceptions.JALTimeoutException;

/** 
 * ALBPSocket. It let to send and receive {@link Bundle}s<br>
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BPSocket implements Closeable {

	private int registrationDescriptor = -1;
	private boolean registered = false;
	
	private int timeout = 60;
	private BundlePayloadLocation payloadLocation = BundlePayloadLocation.Memory;
	
	private BundleEID myEID = null;
	
	private BPSocket() throws JALException {
		JALEngine.getInstance(); // To be sure it is initialized
	}

	/**
	 * 
	 * @return The amount of seconds to wait after throwing {@link JALTimeoutException} in {@link #receive()} 
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * Sets the amount of seconds to wait after throwing {@link JALTimeoutException} in {@link #receive()} 
	 * @param seconds The seconds
	 */
	public void setTimeout(int seconds) {
		this.timeout = seconds;
	}

	/**
	 * Get where to save the Bundle
	 * @return The payload location
	 */
	public BundlePayloadLocation getPayloadLocation() {
		return payloadLocation;
	}

	/**
	 * Sets where to save the bundle
	 * @param payloadLocation Where to save the bundle
	 */
	public void setPayloadLocation(BundlePayloadLocation payloadLocation) {
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
	 * Closes the Socket.
	 * @throws IOException The IOException incapsulates the {@link JALException}
	 */
	@Override
	public void close() throws IOException {
		try {
			this.unregister();
		} catch (JALException e) {
			throw new IOException(e);
		}
	}
	
	/**
	 * Closes the Socket.
	 * @throws JALException In case of errors {@link JALException}
	 */
	public void unregister() throws JALException {
		int result = BPSocket.c_unregister(this.registrationDescriptor);
		ExceptionManager.checkError(result);
		this.registered = false;
	}
	
	/**
	 * Receives a Bundle from DTN
	 * @return The ALBPBundle received
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public Bundle receive() throws JALException {
		Bundle result = new Bundle();
		
		int ris = c_receive(this.registrationDescriptor, result, payloadLocation.getValue(), timeout);
		
		ExceptionManager.checkError(ris, "Error on receiving bundle.");
		return result;
	}
	
	/**
	 * The receive with a specific timeout
	 * @param timeout In seconds
	 * @return The Bundle received
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public Bundle receive(int timeout) throws JALException {
		return this.receive(null, timeout);
	}
	
	/**
	 * The receive with a specific payload location
	 * @param location Payload location
	 * @return The bundle received
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public Bundle receive(BundlePayloadLocation location) throws JALException {
		return this.receive(location, null);
	}
	
	/**
	 * The receive with a specific payload location and timeout
	 * @param location Payload location
	 * @param timeout In seconds
	 * @return The bundle received
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public Bundle receive(BundlePayloadLocation location, Integer timeout) throws JALException {
		int oldTimeout = this.timeout;
		BundlePayloadLocation oldLocation = this.payloadLocation;
		if (location != null)
			this.setPayloadLocation(location);
		if (timeout != null)
			this.setTimeout(timeout);
		Bundle result = this.receive();
		this.setPayloadLocation(oldLocation);
		this.setTimeout(oldTimeout);
		return result;
	}
	
	/**
	 * Sends a Bundle through the DTN connection
	 * @param bundle The Bundle to send
	 * @throws JALException According to ALBPException.
	 * @throws IllegalArgumentException In case the expiration is &#60;= 0 or the destination is invalid.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public void send(Bundle bundle) throws JALException, IllegalArgumentException {
		if (bundle.getExpiration() <= 0)
			throw new IllegalArgumentException("The expiration can't be <= 0.");
		if (bundle.getDestination().toString().length() <= 0)
			throw new IllegalArgumentException("The destination can't be empty.");
		
		int ris = c_send(this.registrationDescriptor, bundle);
		ExceptionManager.checkError(ris, "Error on sending bundle.");
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
		if (!(obj instanceof BPSocket)) {
			return false;
		}
		BPSocket other = (BPSocket) obj;
		if (registrationDescriptor != other.registrationDescriptor) {
			return false;
		}
		return true;
	}
	
	/**
	 * Creates a ALBPSocket from a demuxIPN
	 * @param demuxIPN The demux
	 * @return A registered ALBPSocket
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public static BPSocket register(int demuxIPN) throws JALException {
		return BPSocket.register("", demuxIPN);
	}
	
	/**
	 * Creates a ALBPSocket from a demuxDTN
	 * @param demuxDTN The demux
	 * @return A registered ALBPSocket
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public static BPSocket register(String demuxDTN) throws JALException {
		return BPSocket.register(demuxDTN, 0);
	}
	
	/**
	 * Creates a ALBPSocket from a demuxIPN and demuxDTN
	 * @param demuxDTN The demuxDTN
	 * @param demuxIPN The demuxIPN
	 * @return A registered ALBPSocket
	 * @throws JALException According to ALBPException.
	 * @see JALException
	 * @see ExceptionManager
	 */
	public static BPSocket register(String demuxDTN, int demuxIPN) throws JALException {
		BPSocket result = new BPSocket();
		int error = BPSocket.c_register(result, demuxDTN, demuxIPN);
		ExceptionManager.checkError(error, "Error on registering DTN socket.");
		result.registered = true;
		return result;
	}
	
	private static native int c_register(BPSocket socket, String dtnDemuxString, int IPNDemux); 
	private static native int c_unregister(int registrationDescriptor);
	private static native int c_receive(int registrationDescriptor, Bundle bundle, int payloadLocation, int timeout);
	private static native int c_send(int registrationDescriptor, Bundle bundle);
	
}
