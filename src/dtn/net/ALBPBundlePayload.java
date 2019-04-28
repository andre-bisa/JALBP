package dtn.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Bundle Payload
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public abstract class ALBPBundlePayload {

	private ALBPBundlePayloadLocation location = null;
	private ALBPStatusReport statusReport = null;
	
	protected ALBPBundlePayload(ALBPBundlePayloadLocation location) {
		this.location = location;
	}
	
	protected void setStatusReport(ALBPStatusReport statusReport) {
		this.statusReport = statusReport;
	}
	
	protected ALBPStatusReport getStatusReport() {
		return this.statusReport;
	}
	
	public ALBPBundlePayloadLocation getPayloadLocation() {
		return this.location;
	}
	
	public InputStream getInputStream() {
		return new ByteArrayInputStream(this.getData());
	}

	public BufferedReader getBufferedReader() {
		return new BufferedReader(this.getInputStreamReader());
	}

	public InputStreamReader getInputStreamReader() {
		return new InputStreamReader(this.getInputStream());
	}
	
	public abstract byte[] getData();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((statusReport == null) ? 0 : statusReport.hashCode());
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
		if (!(obj instanceof ALBPBundlePayload)) {
			return false;
		}
		ALBPBundlePayload other = (ALBPBundlePayload) obj;
		if (location != other.location) {
			return false;
		}
		if (statusReport == null) {
			if (other.statusReport != null) {
				return false;
			}
		} else if (!statusReport.equals(other.statusReport)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Payload type="+this.location + "\tdata=" + new String(this.getData());
	}
}
