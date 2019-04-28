package dtn.net;

import dtn.net.endpoint.DTNEndpointID;

/** Status Report
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPStatusReport {
	private ALBPBundle bundle;
	
	private DTNEndpointID source;
	private ALBPBundleTimestamp creationTimestamp;
	private int fragmentOffset = 0;
	private int origLength = 0;
	
	private ALBPStatusReportReason reason;
	private ALBPStatusReportFlag flag;
	private ALBPBundleTimestamp receiptTimestamp;
	private ALBPBundleTimestamp custodyTimestamp;
	private ALBPBundleTimestamp forwardingTimestamp;
	private ALBPBundleTimestamp deliveryTimestamp;
	private ALBPBundleTimestamp deletionTimestamp;
	private ALBPBundleTimestamp ackByAppTimestamp;
	
	public ALBPStatusReport() {
		this(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ackByAppTimestamp == null) ? 0 : ackByAppTimestamp.hashCode());
		result = prime * result + ((bundle == null) ? 0 : bundle.hashCode());
		result = prime * result + ((creationTimestamp == null) ? 0 : creationTimestamp.hashCode());
		result = prime * result + ((custodyTimestamp == null) ? 0 : custodyTimestamp.hashCode());
		result = prime * result + ((deletionTimestamp == null) ? 0 : deletionTimestamp.hashCode());
		result = prime * result + ((deliveryTimestamp == null) ? 0 : deliveryTimestamp.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((forwardingTimestamp == null) ? 0 : forwardingTimestamp.hashCode());
		result = prime * result + fragmentOffset;
		result = prime * result + origLength;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((receiptTimestamp == null) ? 0 : receiptTimestamp.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		if (!(obj instanceof ALBPStatusReport)) {
			return false;
		}
		ALBPStatusReport other = (ALBPStatusReport) obj;
		if (ackByAppTimestamp == null) {
			if (other.ackByAppTimestamp != null) {
				return false;
			}
		} else if (!ackByAppTimestamp.equals(other.ackByAppTimestamp)) {
			return false;
		}
		if (bundle == null) {
			if (other.bundle != null) {
				return false;
			}
		} else if (!bundle.equals(other.bundle)) {
			return false;
		}
		if (creationTimestamp == null) {
			if (other.creationTimestamp != null) {
				return false;
			}
		} else if (!creationTimestamp.equals(other.creationTimestamp)) {
			return false;
		}
		if (custodyTimestamp == null) {
			if (other.custodyTimestamp != null) {
				return false;
			}
		} else if (!custodyTimestamp.equals(other.custodyTimestamp)) {
			return false;
		}
		if (deletionTimestamp == null) {
			if (other.deletionTimestamp != null) {
				return false;
			}
		} else if (!deletionTimestamp.equals(other.deletionTimestamp)) {
			return false;
		}
		if (deliveryTimestamp == null) {
			if (other.deliveryTimestamp != null) {
				return false;
			}
		} else if (!deliveryTimestamp.equals(other.deliveryTimestamp)) {
			return false;
		}
		if (flag != other.flag) {
			return false;
		}
		if (forwardingTimestamp == null) {
			if (other.forwardingTimestamp != null) {
				return false;
			}
		} else if (!forwardingTimestamp.equals(other.forwardingTimestamp)) {
			return false;
		}
		if (fragmentOffset != other.fragmentOffset) {
			return false;
		}
		if (origLength != other.origLength) {
			return false;
		}
		if (reason != other.reason) {
			return false;
		}
		if (receiptTimestamp == null) {
			if (other.receiptTimestamp != null) {
				return false;
			}
		} else if (!receiptTimestamp.equals(other.receiptTimestamp)) {
			return false;
		}
		if (source == null) {
			if (other.source != null) {
				return false;
			}
		} else if (!source.equals(other.source)) {
			return false;
		}
		return true;
	}

	public ALBPBundle getReferredBundle() {
		return bundle;
	}
	
	public ALBPStatusReport(ALBPBundle bundle) {
		this.bundle = bundle;
	}

	public DTNEndpointID getSource() {
		return source;
	}

	public void setSource(DTNEndpointID source) {
		this.source = source;
	}

	public ALBPBundleTimestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(ALBPBundleTimestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public int getFragmentOffset() {
		return fragmentOffset;
	}

	public void setFragmentOffset(int fragmentOffset) {
		this.fragmentOffset = fragmentOffset;
	}

	public int getOrigLength() {
		return origLength;
	}

	public void setOrigLength(int origLength) {
		this.origLength = origLength;
	}

	public ALBPStatusReportReason getReason() {
		return reason;
	}

	public void setReason(ALBPStatusReportReason reason) {
		this.reason = reason;
	}

	public ALBPStatusReportFlag getFlag() {
		return flag;
	}

	public void setFlag(ALBPStatusReportFlag flag) {
		this.flag = flag;
	}

	public ALBPBundleTimestamp getReceiptTimestamp() {
		return receiptTimestamp;
	}

	public void setReceiptTimestamp(ALBPBundleTimestamp receiptTimestamp) {
		this.receiptTimestamp = receiptTimestamp;
	}

	public ALBPBundleTimestamp getCustodyTimestamp() {
		return custodyTimestamp;
	}

	public void setCustodyTimestamp(ALBPBundleTimestamp custodyTimestamp) {
		this.custodyTimestamp = custodyTimestamp;
	}

	public ALBPBundleTimestamp getForwardingTimestamp() {
		return forwardingTimestamp;
	}

	public void setForwardingTimestamp(ALBPBundleTimestamp forwardingTimestamp) {
		this.forwardingTimestamp = forwardingTimestamp;
	}

	public ALBPBundleTimestamp getDeliveryTimestamp() {
		return deliveryTimestamp;
	}

	public void setDeliveryTimestamp(ALBPBundleTimestamp deliveryTimestamp) {
		this.deliveryTimestamp = deliveryTimestamp;
	}

	public ALBPBundleTimestamp getDeletionTimestamp() {
		return deletionTimestamp;
	}

	public void setDeletionTimestamp(ALBPBundleTimestamp deletionTimestamp) {
		this.deletionTimestamp = deletionTimestamp;
	}

	public ALBPBundleTimestamp getAckByAppTimestamp() {
		return ackByAppTimestamp;
	}

	public void setAckByAppTimestamp(ALBPBundleTimestamp ackByAppTimestamp) {
		this.ackByAppTimestamp = ackByAppTimestamp;
	}

	
}
