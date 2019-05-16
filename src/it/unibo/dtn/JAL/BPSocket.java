package it.unibo.dtn.JAL;

import java.io.Closeable;
import java.io.IOException;

import it.unibo.dtn.JAL.exceptions.JALCloseErrorException;
import it.unibo.dtn.JAL.exceptions.JALDTN2ParametersException;
import it.unibo.dtn.JAL.exceptions.JALIPNParametersException;
import it.unibo.dtn.JAL.exceptions.JALGeneralException;
import it.unibo.dtn.JAL.exceptions.JALInitException;
import it.unibo.dtn.JAL.exceptions.JALLibraryNotFoundException;
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

/** 
 * <p>This class represents a socket to send and receive bundles.</p>
 * 
 * <p>
 * A BPSocket is the sending or receiving point for a bundle delivery service. Each bundle sent or received on a datagram socket is individually addressed and routed. Multiple bundles sent from one machine to another may be routed differently, and may arrive in any order.
 * </p>
 * 
 * <p>
 * <table border="1">
 * 		<tr>
 * 			<th colspan="2">Default settings</th>
 * 		</tr>
 * 		<tr>
 * 			<td>Timeout</td>
 * 			<td>60 seconds</td>
 * 		</tr>
 * 		<tr>
 * 			<td>Payload location</td>
 * 			<td>Memory</td>
 * 		</tr>
 * </table>
 * </p>
 * 
 * <p>
 * If you need to change the default settings of {@link JALEngine} you have to set those before creating a BPSocket.
 * </p>
 * 
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BPSocket implements Closeable, AutoCloseable {
	private int registrationDescriptor = -1;
	
	private int timeout = 60;
	private BundlePayloadLocation payloadLocation = BundlePayloadLocation.Memory;
	
	/**
	 * Creates a BPSocket. This constructor wants to be sure that the {@link JALEngine} is initialized
	 * @throws JALLibraryNotFoundException In case the al_bp library was not found in the system
	 * @throws JALNoImplementationFoundException - in case no DTN implementations were found in the current system
	 * @throws JALDTN2ParametersException - in case you are forcing IPN scheme but the 
	 * @throws JALInitException - in case of other occurrences
	 */
	private BPSocket() throws JALLibraryNotFoundException, JALNoImplementationFoundException, JALDTN2ParametersException, JALInitException {
		JALEngine.getInstance(); // To be sure it is initialized
	}

	/**
	 * Returns the amount of seconds to wait after throwing  {@link JALTimeoutException} in {@link #receive()}
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
	 * Returns the current setting about where to save the bundle
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
	 * Gets the EID which you have been registered
	 * @return The EID you have been registered
	 */
	public String getLocalEID() {
		return c_get_local_eid(this.registrationDescriptor);
	}
	
	@Deprecated
	/**
	 * Unregisters the BPSocket
	 * @throws JALUnregisterException - in case of other occurrences
	 */
	@Override
	public void close() throws JALUnregisterException, IOException {
		try {
			this.unregister();
		} catch (JALNotRegisteredException | JALUnregisterException e) {
			throw new JALUnregisterException(e);
		}
	}
	
	/**
	 * Unregisters the BPSocket
	 * @throws JALNotRegisteredException - in case you are trying to unregister a not initialized socket
	 * @throws JALCloseErrorException - in case of errors on closing socket
	 * @throws JALUnregisterException - in case of other occurrences 
	 */
	public void unregister() throws JALNotRegisteredException, JALCloseErrorException, JALUnregisterException {
		int result = BPSocket.c_unregister(this.registrationDescriptor);
		try {
			ExceptionManager.checkError(result);
		} catch (JALSendException | JALReceiveException | JALNullPointerException | JALInitException
				| JALRegisterException | JALGeneralException e) {
			throw new JALUnregisterException(e);
		}
	}
	
	/**
	 * Receives a bundle from the BPSocket
	 * @return The bundle received
	 * @throws JALNotRegisteredException - in case you are trying to receive through a not initialized socket
	 * @throws JALTimeoutException - if timeout expires on waiting for a bundle
	 * @throws JALReceptionInterruptedException - in case the receive is interrupted (in the most cases it is just a warning)
	 * @throws JALReceiveException - in case of other occurrences
	 */
	public Bundle receive() throws JALNotRegisteredException, JALTimeoutException, JALReceptionInterruptedException, JALReceiveException {
		Bundle result = new Bundle();
		int ris = c_receive(this.registrationDescriptor, result, payloadLocation.getValue(), timeout);
		try {
			ExceptionManager.checkError(ris, "Error on receiving bundle.");
		} catch (JALNullPointerException | JALSendException | JALInitException | JALRegisterException
				| JALUnregisterException | JALGeneralException e) {
			throw new JALReceiveException(e);
		}
		return result;
	}
	
	/**
	 * The receive with a specific timeout
	 * @param timeout In seconds
	 * @return The bundle received
	 * @throws JALNotRegisteredException - in case you are trying to receive through a not initialized socket
	 * @throws JALTimeoutException - if timeout expires on waiting for a bundle
	 * @throws JALReceptionInterruptedException - in case the receive is interrupted (in the most cases it is just a warning)
	 * @throws JALReceiveException - in case of other occurrences
	 */
	public Bundle receive(int timeout) throws JALNotRegisteredException, JALTimeoutException, JALReceptionInterruptedException, JALReceiveException {
		return this.receive(null, timeout);
	}
	
	/**
	 * The receive with a specific payload location
	 * @param location Payload location
	 * @return The bundle received
	 * @throws JALNotRegisteredException - in case you are trying to receive through a not initialized socket
	 * @throws JALTimeoutException - if timeout expires on waiting for a bundle
	 * @throws JALReceptionInterruptedException - in case the receive is interrupted (in the most cases it is just a warning)
	 * @throws JALReceiveException - in case of other occurrences
	 */
	public Bundle receive(BundlePayloadLocation location) throws JALNotRegisteredException, JALTimeoutException, JALReceptionInterruptedException, JALReceiveException {
		return this.receive(location, null);
	}
	
	/**
	 * The receive with a specific payload location and timeout
	 * @param location Payload location
	 * @param timeout In seconds
	 * @return The bundle received
	 * @throws JALNotRegisteredException - in case you are trying to receive through a not initialized socket
	 * @throws JALTimeoutException - if timeout expires on waiting for a bundle
	 * @throws JALReceptionInterruptedException - in case the receive is interrupted (in the most cases it is just a warning)
	 * @throws JALReceiveException - in case of other occurrences
	 */
	public Bundle receive(BundlePayloadLocation location, Integer timeout) throws JALNotRegisteredException, JALTimeoutException, JALReceptionInterruptedException, JALReceiveException {
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
	 * Sends a bundle through the BPSocket
	 * @param bundle The bundle to send
	 * @throws IllegalArgumentException In case the expiration is &#60;= 0 or the destination is invalid or the bundlePayload is null.
	 * @throws IllegalStateException In case the flags in {@link StatusReport} inside the bundle are setted but is not set the ReplyTo.
	 * @throws NullPointerException - in case the bundle is null
	 * @throws JALNullPointerException - in case of null in some important internal bundle fields
	 * @throws JALNotRegisteredException - in case you are trying to send through a not initialized socket
	 * @throws JALReceiverException - in case the destination is not set
	 * @throws JALSendException - in case of other occurrences
	 */
	public void send(Bundle bundle) throws NullPointerException, IllegalArgumentException, IllegalStateException, JALNullPointerException, JALNotRegisteredException, JALReceiverException, JALSendException {
		if (bundle == null)
			throw new NullPointerException("Bundle can't be null.");
		if (bundle.getExpiration() <= 0)
			throw new IllegalArgumentException("The expiration can't be <= 0.");
		if (bundle.getDestination().toString().length() <= 0)
			throw new IllegalArgumentException("The destination can't be empty.");
		if (bundle.getPayload() == null)
			throw new IllegalArgumentException("The BundlePayload can't be null.");
		if (bundle.getReplyTo() != null && !(bundle.getReplyTo() != null) && bundle.getDeliveryOptions() != null && bundle.getDeliveryOptions().size() == 0)
			throw new IllegalStateException("Can't set flags in StatusReport without a ReplyTo.");
		if (bundle.getReplyTo() != null && (bundle.getReplyTo() != null) && bundle.getReplyTo().equals(BundleEID.NoneEndpoint) && bundle.getDeliveryOptions() != null && bundle.getDeliveryOptions().size() == 0)
			throw new IllegalStateException("Can't set flags in StatusReport without a dtn:none ReplyTo.");
		
		if (bundle.getSource() == null)
			bundle.setSource(BundleEID.of(this.getLocalEID()));
		
		int ris = c_send(this.registrationDescriptor, bundle);
		try {
			ExceptionManager.checkError(ris, "Error on sending bundle.");
		} catch (JALReceiveException | JALInitException | JALRegisterException | JALUnregisterException
				| JALGeneralException e) {
			throw new JALSendException(e);
		}
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
	 * Creates a BPSocket that can use only IPN scheme
	 * @param demuxIPN The demux token
	 * @return A registered BPSocket
	 * @throws JALLocalEIDException - in case errors occurs on building local EID
	 * @throws JALOpenException - in case errors occurs on opening the socket
	 * @throws JALIPNParametersException - in case the scheme is IPN and the demux number is negative (negative port are not supported)
	 * @throws JALRegisterException - in case of other occurrences
	 */
	public static BPSocket register(int demuxIPN) throws JALLocalEIDException, JALOpenException, JALIPNParametersException, JALRegisterException {
		return BPSocket.register("", demuxIPN);
	}
	
	/**
	 * Creates a BPSocket that can use only DTN scheme
	 * @param demuxDTN The demux token
	 * @return A registered ALBPSocket
	 * @throws JALLocalEIDException - in case errors occurs on building local EID
	 * @throws JALOpenException - in case errors occurs on opening the socket
	 * @throws JALIPNParametersException - in case the scheme is IPN and the demux number is negative (negative port are not supported)
	 * @throws JALRegisterException - in case of other occurrences
	 */
	public static BPSocket register(String demuxDTN) throws JALLocalEIDException, JALOpenException, JALIPNParametersException, JALRegisterException {
		return BPSocket.register(demuxDTN, 0);
	}
	
	/**
	 * Creates a BPSocket that can use both DTN and IPN schemes (depending on forcing settings in {@link JALEngine} and/or depeding on the current DTN implementation running)
	 * @param demuxDTN The demuxDTN
	 * @param demuxIPN The demuxIPN
	 * @return A registered ALBPSocket
	 * @throws JALLocalEIDException - in case errors occurs on building local EID
	 * @throws JALOpenException - in case errors occurs on opening the socket
	 * @throws JALIPNParametersException - in case the scheme is IPN and the demux number is negative (negative port are not supported)
	 * @throws JALRegisterException - in case of other occurrences
	 */
	public static BPSocket register(String demuxDTN, int demuxIPN) throws JALLocalEIDException, JALOpenException, JALIPNParametersException, JALRegisterException {
		BPSocket result;
		try {
			result = new BPSocket();
		} catch (JALLibraryNotFoundException | JALInitException e) {
			throw new JALRegisterException(e);
		}
		int error = BPSocket.c_register(result, demuxDTN, demuxIPN);
		try {
			ExceptionManager.checkError(error, "Error on registering DTN socket.");
		}
		catch (JALSendException | JALReceiveException | JALNullPointerException | JALInitException
				| JALUnregisterException | JALNotRegisteredException | JALGeneralException e) {
			throw new JALRegisterException(e);
		}
		return result;
	}
	
	private static native int c_register(BPSocket socket, String dtnDemuxString, int IPNDemux); 
	private static native int c_unregister(int registrationDescriptor);
	private static native int c_receive(int registrationDescriptor, Bundle bundle, int payloadLocation, int timeout);
	private static native int c_send(int registrationDescriptor, Bundle bundle);
	private static native String c_get_local_eid(int registrationDescriptor);
	
}
