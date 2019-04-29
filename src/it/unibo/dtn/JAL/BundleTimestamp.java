package it.unibo.dtn.JAL;

/**
 * Bundle timestamp
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
class BundleTimestamp {
	private int seconds;
	private int sequenceNumber;
	
	public BundleTimestamp(int seconds, int sequenceNumber) {
		super();
		this.seconds = seconds;
		this.sequenceNumber = sequenceNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seconds;
		result = prime * result + sequenceNumber;
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
		if (!(obj instanceof BundleTimestamp)) {
			return false;
		}
		BundleTimestamp other = (BundleTimestamp) obj;
		if (seconds != other.seconds) {
			return false;
		}
		if (sequenceNumber != other.sequenceNumber) {
			return false;
		}
		return true;
	}

	public int getSeconds() {
		return seconds;
	}
	
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	@Override
	public String toString() {
		return ""+this.seconds+"."+this.sequenceNumber;
	}

}
