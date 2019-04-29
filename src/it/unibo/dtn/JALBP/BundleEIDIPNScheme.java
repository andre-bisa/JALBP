package it.unibo.dtn.JALBP;

import java.net.URI;

/** Endpoint of IPN schema
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BundleEIDIPNScheme extends BundleEID {

	private int localNumber;
	private int demuxNumber;
	
	/**
	 * Builds an Endpoint according to IPN schema.
	 * It follows the schema: ipn:localNumber.demuxNumber
	 * Example: ipn:10.3 
	 * @param localNumber Local number
	 * @param demuxNumber Demux number
	 */
	public BundleEIDIPNScheme(int localNumber, int demuxNumber) {
		if (localNumber < 0 || demuxNumber < 0) 
			throw new IllegalArgumentException("Error, localNumber and/or demuxNumber can't be negative.");
			
		this.localNumber = localNumber;
		this.demuxNumber = demuxNumber;
		
		StringBuilder builder = new StringBuilder();
		builder.append("ipn:");
		builder.append(localNumber);
		builder.append('.');
		builder.append(demuxNumber);
		try {
			super.setEndpointID(new URI(builder.toString()));
		} catch (Exception e) {
			throw new IllegalArgumentException("Error on building IPN EID.");
		}
	}

	/**
	 * Gets the localNumber
	 * @return The localNumber
	 */
	public int getLocalNumber() {
		return this.localNumber;
	}
	
	/**
	 * Gets the demuxNumber
	 * @return The demuxNumber
	 */
	public int getDemuxNumber() {
		return this.demuxNumber;
	}

	/**
	 * The localNumber as String
	 * @return The localNumber as String
	 */
	@Override
	public String getLocalString() {
		return ""+this.getLocalNumber();
	}

	/**
	 * The demuxNumber as String
	 * @return The demuxNumber as String
	 */
	@Override
	public String getDemuxString() {
		return ""+this.getDemuxNumber();
	}
	
}
