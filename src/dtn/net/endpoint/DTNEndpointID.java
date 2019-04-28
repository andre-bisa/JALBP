package dtn.net.endpoint;

import java.net.URI;

/** DTN Endpoint
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public abstract class DTNEndpointID {

	/**
	 * None endpoint
	 */
	public static DTNEndpointID NoneEndpoint = new DTNEndpoint("none");
	
	private URI uri = null;
	
	protected DTNEndpointID() {
	}
	
	protected void setEndpointID(URI uri) {
		this.uri = uri;
	}
	
	/**
	 * Returns the Endpoint ID as String
	 * @return The Endpoint as a String
	 */
	public String getEndpointID() {
		return this.uri.toString();
	}
	
	@Override
	public String toString() {
		return this.uri.toString();
	}
	
	/**
	 * Returns the localString
	 * @return The localString
	 */
	public abstract String getLocalString();
	
	/**
	 * Returns the demuxString
	 * @return The demuxString
	 */
	public abstract String getDemuxString();
	
	/**
	 * Factory constructor of DTNEndpointID.
	 * @param str String in IPN or DTN schema
	 * @return The DTNEndpointID
	 */
	public static DTNEndpointID of(String str) {
		if (str == null || str.length() == 0 || str.equals(NoneEndpoint.getEndpointID()))
			return NoneEndpoint;
		
		URI uri = null;
		try {
			uri = URI.create(str);
		} catch (IllegalArgumentException e) { // Malformed
			return null;
		}
		return DTNEndpointID.of(uri);
	}
	
	/**
	 * Factory constructor of DTNEndpointID
	 * @param uri IPN or DTN URI
	 * @return The DTNEndpointID
	 */
	public static DTNEndpointID of(URI uri) {
		if (uri == null)
			return null;
		
		DTNEndpointID result = null;
		
		if (uri.getScheme().equals("ipn")) {
			String firstNumber = uri.toString().substring(4, uri.toString().indexOf("."));
			String secondNumber = uri.toString().substring(uri.toString().indexOf(".")+1);
			result = new IPNEndpoint(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber));
		} else if (uri.getScheme().equals("dtn")) {
			System.out.println(uri.toString());
			String firstPart = uri.toString().substring(4, uri.toString().indexOf("/"));
			String secondPart = null;
			try {
				secondPart = uri.toString().substring(uri.toString().indexOf("/") + 1);
			} catch (IndexOutOfBoundsException e) {	}
			result = new DTNEndpoint(firstPart, secondPart);
		}
		
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.toString().hashCode());
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
		if (!(obj instanceof DTNEndpointID)) {
			return false;
		}
		DTNEndpointID other = (DTNEndpointID) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.toString().equals(other.uri.toString())) {
			return false;
		}
		return true;
	}
	
}