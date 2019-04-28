package dtn.net;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import dtn.net.endpoint.DTNEndpointID;

/** DTN Bundle rappresentation
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class ALBPBundle {

	// *** BUNDLE ID
	private DTNEndpointID source = null;
	private ALBPBundleTimestamp creationTimestamp = new ALBPBundleTimestamp(0, 0);
	private int fragmentOffset = 0;
	private int origLength = 0;
	
	// *** BUNDLE SPEC
	private Optional<DTNEndpointID> destination = Optional.empty();
	private DTNEndpointID replyTo = null;
	private ALBPBundlePriority priority = new ALBPBundlePriority(0, 0);
	private DTNDeliveryOptions deliveryOption = DTNDeliveryOptions.None;
	private int expiration = 0;
	private int deliveryRegID = 0;
	private final List<ALBPExtensionBlock> blocks = new LinkedList<>();
	private final List<ALBPExtensionBlock> metadata = new LinkedList<>();
	private boolean unreliable = false;
	private boolean critical = false;
	private int flowLabel = 0;
	
	private ALBPStatusReport statusReport = null;
	
	// *** BUNDLE PAYLOAD
	private ALBPBundlePayload payload = null;
	
	/**
	 * Creats an empty bundle
	 */
	public ALBPBundle() {}

	public DTNEndpointID getSource() {
		return source;
	}

	public ALBPBundleTimestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public int getFragmentOffset() {
		return fragmentOffset;
	}

	public int getOrigLength() {
		return origLength;
	}

	public DTNEndpointID getDestination() {
		if (destination.isPresent())
			return destination.get();
		else
			return null;
	}

	public DTNEndpointID getReplyTo() {
		return replyTo;
	}

	public ALBPBundlePriority getPriority() {
		return priority;
	}

	public DTNDeliveryOptions getDeliveryOption() {
		return deliveryOption;
	}

	public int getExpiration() {
		return expiration;
	}

	public int getDeliveryRegID() {
		return deliveryRegID;
	}

	public ALBPExtensionBlock[] getBlocks() {
		return this.blocks.toArray(new ALBPExtensionBlock[this.blocks.size()]);
	}

	public ALBPExtensionBlock[] getMetadata() {
		return this.metadata.toArray(new ALBPExtensionBlock[this.metadata.size()]);
	}

	public boolean isUnreliable() {
		return unreliable;
	}

	public boolean isCritical() {
		return critical;
	}

	public int getFlowLabel() {
		return flowLabel;
	}

	public ALBPBundlePayload getPayload() {
		return payload;
	}

	public void setSource(DTNEndpointID source) {
		this.source = source;
	}

	public void setCreationTimestamp(ALBPBundleTimestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public void setFragmentOffset(int fragmentOffset) {
		this.fragmentOffset = fragmentOffset;
	}

	public void setOrigLength(int origLength) {
		this.origLength = origLength;
	}

	public void setDestination(DTNEndpointID destination) {
		this.destination =  Optional.of(destination);
	}

	public void setReplyTo(DTNEndpointID replyTo) {
		this.replyTo = replyTo;
	}

	public void setPriority(ALBPBundlePriority priority) {
		this.priority = priority;
	}

	public void setDeliveryOption(DTNDeliveryOptions deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public void setDeliveryRegID(int deliveryRegID) {
		this.deliveryRegID = deliveryRegID;
	}

	public void addBlock(ALBPExtensionBlock block) {
		this.blocks.add(block);
	}

	public void addMetadata(ALBPExtensionBlock metadata) {
		this.metadata.add(metadata);
	}

	public void setUnreliable(boolean unreliable) {
		this.unreliable = unreliable;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}

	public void setFlowLabel(int flowLabel) {
		this.flowLabel = flowLabel;
	}

	public void setPayload(ALBPBundlePayload payload) {
		this.payload = payload;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTimestamp == null) ? 0 : creationTimestamp.hashCode());
		result = prime * result + fragmentOffset;
		result = prime * result + origLength;
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
		if (!(obj instanceof ALBPBundle)) {
			return false;
		}
		ALBPBundle other = (ALBPBundle) obj;
		if (creationTimestamp == null) {
			if (other.creationTimestamp != null) {
				return false;
			}
		} else if (!creationTimestamp.equals(other.creationTimestamp)) {
			return false;
		}
		if (fragmentOffset != other.fragmentOffset) {
			return false;
		}
		if (origLength != other.origLength) {
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
	
	// ***** JNI UTILITY FUNCTIONS

	@SuppressWarnings("unused")
	private void setSource(String str) {
		this.setSource(DTNEndpointID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setCritical(int val) {
		this.setCritical(val != 0);
	}
	
	@SuppressWarnings("unused")
	private void setUnreliable(int val) {
		this.setUnreliable(val != 0);
	}
	
	@SuppressWarnings("unused")
	private void setDeliveryOption(int value) {
		this.setDeliveryOption(DTNDeliveryOptions.of(value));
	}
	
	@SuppressWarnings("unused")
	private void setPriority(int priority, int ordinal) {
		this.setPriority(new ALBPBundlePriority(priority, ordinal));
	}
	
	@SuppressWarnings("unused")
	private void setCreationTimestamp(int seconds, int sequenceNumber) {
		this.setCreationTimestamp(new ALBPBundleTimestamp(seconds, sequenceNumber));
	}
	
	@SuppressWarnings("unused")
	private void setReplyTo(String str) {
		this.setReplyTo(DTNEndpointID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setDestination(String str) {
		this.setDestination(DTNEndpointID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setBuffer(byte[] buffer) {
		this.payload = new ALBPBundlePayloadMemory(buffer);
	}
	
	@SuppressWarnings("unused")
	private void setPayloadFile(String payloadFileName) {
		this.payload = new ALBPBundlePayloadFile(payloadFileName);
	}
	
	@SuppressWarnings("unused")
	private void setPayloadTemporaryFile(String payloadFileName) {
		this.payload = new ALBPBundlePayloadTemporaryFile(payloadFileName);
	}
	
	@SuppressWarnings("unused")
	private void addBlock(byte[] blocks, int flags, int type) {
		this.addBlock(new ALBPExtensionBlock(blocks, flags, type));
	}
	
	@SuppressWarnings("unused")
	private void addMetadata(byte[] metadata, int flags, int type) {
		this.addMetadata(new ALBPExtensionBlock(metadata, flags, type));
	}
	
	private void createStatusReport() {
		if (this.statusReport == null)
			this.statusReport = new ALBPStatusReport(this);
	}
	
	@SuppressWarnings("unused")
	private void setSourceStatusReport(String str) {
		createStatusReport();
		this.statusReport.setSource(DTNEndpointID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setCreationTimestampStatusReport(int seconds, int sequenceNumber) {
		createStatusReport();
		this.statusReport.setCreationTimestamp(new ALBPBundleTimestamp(seconds, sequenceNumber));
	}
	
	@SuppressWarnings("unused")
	private void setFragmentOffsetStatusReport(int fragmentOffset) {
		createStatusReport();
		this.statusReport.setFragmentOffset(fragmentOffset);
	}
	
	@SuppressWarnings("unused")
	private void setOrigLengthStatusReport(int origLength) {
		createStatusReport();
		this.statusReport.setOrigLength(origLength);
	}
	
	@SuppressWarnings("unused")
	private void setReasonStatusReport(int val) {
		createStatusReport();
		this.statusReport.setReason(ALBPStatusReportReason.of(val));
	}
	
	@SuppressWarnings("unused")
	private void setFlagStatusReport(int val) {
		createStatusReport();
		this.statusReport.setFlag(ALBPStatusReportFlag.of(val));
	}
	
	@SuppressWarnings("unused")
	private void setReceiptTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setReceiptTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setCustodyTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setCustodyTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setForwardingTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setForwardingTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setDeliveryTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setDeliveryTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setDeletionTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setDeletionTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setAckByAppTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setAckByAppTimestamp(new ALBPBundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private String getSourceAsString() {
		return this.source.toString();
	}
	
	@SuppressWarnings("unused")
	private int getCreationTimestampSeconds() {
		return this.creationTimestamp.getSeconds();
	}
	
	@SuppressWarnings("unused")
	private int getCreationTimestampSequenceNumber() {
		return this.creationTimestamp.getSequenceNumber();
	}
	
	@SuppressWarnings("unused")
	private String getDestinationAsString() {
		DTNEndpointID EID = this.getDestination();
		if (EID == null)
			return "";
		else
			return EID.toString();
	}
	
	@SuppressWarnings("unused")
	private String getReplyToAsString() {
		return this.replyTo.toString();
	}
	
	@SuppressWarnings("unused")
	private int getPriorityVal() {
		return this.priority.getPriority().getValue();
	}
	
	@SuppressWarnings("unused")
	private int getPriorityOrdinal() {
		return this.priority.getOrdinal();
	}
	
	@SuppressWarnings("unused")
	private int getDeliveryOptionsVal() {
		return this.deliveryOption.getValue();
	}
	
	@SuppressWarnings("unused")
	private int getUnreliableAsVal() {
		return (this.unreliable ? 1 : 0);
	}
	
	@SuppressWarnings("unused")
	private int getCriticalAsVal() {
		return (this.critical ? 1 : 0);
	}
	
	@SuppressWarnings("unused")
	private int getPayloadLocationAsVal() {
		return this.payload.getPayloadLocation().getValue();
	}
	
	@SuppressWarnings("unused")
	private int getPayloadFileNameSize() {
		if (this.payload instanceof ALBPBundlePayloadFile) {
			return ((ALBPBundlePayloadFile)this.payload).getFileName().length();
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unused")
	private String getPayloadFileName() {
		if (this.payload instanceof ALBPBundlePayloadFile) {
			return ((ALBPBundlePayloadFile)this.payload).getFileName();
		} else {
			return "";
		}
	}
	
	@SuppressWarnings("unused")
	private int getPayloadMemorySize() {
		if (this.payload instanceof ALBPBundlePayloadMemory) {
			return ((ALBPBundlePayloadMemory)this.payload).getData().length;
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unused")
	private byte[] getPayloadMemoryData() {
		if (this.payload instanceof ALBPBundlePayloadMemory) {
			return ((ALBPBundlePayloadMemory)this.payload).getData();
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private int getMetadataSize() {
		return this.metadata.size();
	}
	
	@SuppressWarnings("unused")
	private int getMetadataType(int index) {
		return this.metadata.get(index).getType();
	}
	
	@SuppressWarnings("unused")
	private int getMetadataFlags(int index) {
		return this.metadata.get(index).getFlags();
	}
	
	@SuppressWarnings("unused")
	private int getMetadataDataSize(int index) {
		return this.metadata.get(index).getData().length;
	}
	
	@SuppressWarnings("unused")
	private byte[] getMetadataData(int index) {
		return this.metadata.get(index).getData();
	}
	
	@SuppressWarnings("unused")
	private int getBlocksSize() {
		return this.blocks.size();
	}
	
	@SuppressWarnings("unused")
	private int getBlocksType(int index) {
		return this.blocks.get(index).getType();
	}
	
	@SuppressWarnings("unused")
	private int getBlocksFlags(int index) {
		return this.blocks.get(index).getFlags();
	}
	
	@SuppressWarnings("unused")
	private int getBlocksDataSize(int index) {
		return this.blocks.get(index).getData().length;
	}
	
	@SuppressWarnings("unused")
	private byte[] getBlocksData(int index) {
		return this.blocks.get(index).getData();
	}
	
}
