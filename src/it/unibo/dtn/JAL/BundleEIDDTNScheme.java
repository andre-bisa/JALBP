package it.unibo.dtn.JAL;

import java.net.URI;

/** Endpoint of DTN schema
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BundleEIDDTNScheme extends BundleEID {

	private String localName;
	private String demuxString;

	/**
	 * Creates a DTN schema EndpointID (without demuxString)
	 * @param localName LocalName
	 */
	public BundleEIDDTNScheme(String localName) {
		this(localName, null);
	}
	
	/**
	 * Creates a DTN schema EndpointID
	 * @param localName LocalName
	 * @param demuxString DemuxString
	 */
	public BundleEIDDTNScheme(String localName, String demuxString) {
		if (localName == null || localName.length() == 0) 
			throw new IllegalArgumentException("Error, localName can't be empty.");

		this.localName = localName;
		this.demuxString = demuxString;

		StringBuilder builder = new StringBuilder();
		builder.append("dtn:");
		builder.append(localName);
		if (demuxString != null && demuxString.length() > 0) {
			builder.append('/');
			builder.append(demuxString);
		}
		try {
			super.setEndpointID(new URI(builder.toString()));
		} catch (Exception e) {
			throw new IllegalArgumentException("Error on building DTN EID.");
		}
	}

	/**
	 * Returns the LocalName
	 * @return The LocalName
	 */
	public String getLocalName() {
		return this.localName;
	}

	@Override
	public String getDemuxString() {
		return this.demuxString;
	}

	@Override
	public String getLocalString() {
		return this.getLocalName();
	}

}

