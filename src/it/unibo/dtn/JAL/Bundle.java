package it.unibo.dtn.JAL;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/** DTN Bundle rappresentation
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class Bundle {

	// *** BUNDLE ID
	private BundleEID source = null;
	private BundleTimestamp creationTimestamp = new BundleTimestamp(0, 0);
	private int fragmentOffset = 0;
	private int origLength = 0;
	
	// *** BUNDLE SPEC
	private Optional<BundleEID> destination = Optional.empty();
	private BundleEID replyTo = null;
	private BundlePriority priority = new BundlePriority(0);
	private BundleDeliveryOptions deliveryOption = BundleDeliveryOptions.None;
	private int expiration = 0;
	private int deliveryRegID = 0;
	private final List<BundleExtensionBlock> blocks = new LinkedList<>();
	private final List<BundleExtensionBlock> metadata = new LinkedList<>();
	private boolean unreliable = false;
	private boolean critical = false;
	private int flowLabel = 0;
	
	private StatusReport statusReport = null;
	
	// *** BUNDLE PAYLOAD
	private BundlePayload payload = null;
	
	/**
	 * Creats an empty bundle
	 */
	public Bundle() {}

	public BundleEID getSource() {
		return source;
	}

	public BundleTimestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public int getFragmentOffset() {
		return fragmentOffset;
	}

	public int getOrigLength() {
		return origLength;
	}

	public BundleEID getDestination() {
		if (destination.isPresent())
			return destination.get();
		else
			return null;
	}

	public BundleEID getReplyTo() {
		return replyTo;
	}

	public BundlePriority getPriority() {
		return priority;
	}

	public BundleDeliveryOptions getDeliveryOption() {
		return deliveryOption;
	}

	public int getExpiration() {
		return expiration;
	}

	public int getDeliveryRegID() {
		return deliveryRegID;
	}

	public BundleExtensionBlock[] getBlocks() {
		return this.blocks.toArray(new BundleExtensionBlock[this.blocks.size()]);
	}

	public BundleExtensionBlock[] getMetadata() {
		return this.metadata.toArray(new BundleExtensionBlock[this.metadata.size()]);
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

	public BundlePayload getPayload() {
		return payload;
	}

	public void setSource(BundleEID source) {
		this.source = source;
	}

	public void setCreationTimestamp(BundleTimestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public void setFragmentOffset(int fragmentOffset) {
		this.fragmentOffset = fragmentOffset;
	}

	public void setOrigLength(int origLength) {
		this.origLength = origLength;
	}

	public void setDestination(BundleEID destination) {
		this.destination =  Optional.of(destination);
	}

	public void setReplyTo(BundleEID replyTo) {
		this.replyTo = replyTo;
	}

	public void setPriority(BundlePriority priority) {
		this.priority = priority;
	}

	public void setDeliveryOption(BundleDeliveryOptions deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public void setDeliveryRegID(int deliveryRegID) {
		this.deliveryRegID = deliveryRegID;
	}

	public void addBlock(BundleExtensionBlock block) {
		this.blocks.add(block);
	}

	public void addMetadata(BundleExtensionBlock metadata) {
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

	public void setPayload(BundlePayload payload) {
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
		if (!(obj instanceof Bundle)) {
			return false;
		}
		Bundle other = (Bundle) obj;
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
		this.setSource(BundleEID.of(str));
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
		this.setDeliveryOption(BundleDeliveryOptions.of(value));
	}
	
	@SuppressWarnings("unused")
	private void setPriority(int priority, int ordinal) {
		this.setPriority(new BundlePriority(priority, ordinal));
	}
	
	@SuppressWarnings("unused")
	private void setCreationTimestamp(int seconds, int sequenceNumber) {
		this.setCreationTimestamp(new BundleTimestamp(seconds, sequenceNumber));
	}
	
	@SuppressWarnings("unused")
	private void setReplyTo(String str) {
		this.setReplyTo(BundleEID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setDestination(String str) {
		this.setDestination(BundleEID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setBuffer(byte[] buffer) {
		this.payload = new BundlePayloadMemory(buffer);
	}
	
	@SuppressWarnings("unused")
	private void setPayloadFile(String payloadFileName) {
		this.payload = new BundlePayloadFile(payloadFileName);
	}
	
	@SuppressWarnings("unused")
	private void setPayloadTemporaryFile(String payloadFileName) {
		this.payload = new BundlePayloadTemporaryFile(payloadFileName);
	}
	
	@SuppressWarnings("unused")
	private void addBlock(byte[] blocks, int flags, int type) {
		this.addBlock(new BundleExtensionBlock(blocks, flags, type));
	}
	
	@SuppressWarnings("unused")
	private void addMetadata(byte[] metadata, int flags, int type) {
		this.addMetadata(new BundleExtensionBlock(metadata, flags, type));
	}
	
	private void createStatusReport() {
		if (this.statusReport == null)
			this.statusReport = new StatusReport(this);
	}
	
	@SuppressWarnings("unused")
	private void setSourceStatusReport(String str) {
		createStatusReport();
		this.statusReport.setSource(BundleEID.of(str));
	}
	
	@SuppressWarnings("unused")
	private void setCreationTimestampStatusReport(int seconds, int sequenceNumber) {
		createStatusReport();
		this.statusReport.setCreationTimestamp(new BundleTimestamp(seconds, sequenceNumber));
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
		this.statusReport.setReason(StatusReportReason.of(val));
	}
	
	@SuppressWarnings("unused")
	private void setFlagStatusReport(int val) {
		createStatusReport();
		this.statusReport.setFlags(StatusReportFlag.of(val));
	}
	
	@SuppressWarnings("unused")
	private void setReceiptTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setReceiptTimestamp(new BundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setCustodyTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setCustodyTimestamp(new BundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setForwardingTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setForwardingTimestamp(new BundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setDeliveryTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setDeliveryTimestamp(new BundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setDeletionTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setDeletionTimestamp(new BundleTimestamp(secs, seqno));
	}
	
	@SuppressWarnings("unused")
	private void setAckByAppTimestampStatusReport(int secs, int seqno) {
		createStatusReport();
		this.statusReport.setAckByAppTimestamp(new BundleTimestamp(secs, seqno));
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
		BundleEID EID = this.getDestination();
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
		return this.priority.getPriority();
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
		if (this.payload instanceof BundlePayloadFile) {
			return ((BundlePayloadFile)this.payload).getFileName().length();
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unused")
	private String getPayloadFileName() {
		if (this.payload instanceof BundlePayloadFile) {
			return ((BundlePayloadFile)this.payload).getFileName();
		} else {
			return "";
		}
	}
	
	@SuppressWarnings("unused")
	private int getPayloadMemorySize() {
		if (this.payload instanceof BundlePayloadMemory) {
			return ((BundlePayloadMemory)this.payload).getData().length;
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unused")
	private byte[] getPayloadMemoryData() {
		if (this.payload instanceof BundlePayloadMemory) {
			return ((BundlePayloadMemory)this.payload).getData();
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
