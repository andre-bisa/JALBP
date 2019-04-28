package dtn.net;

/** Payload saved in memory
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public final class ALBPBundlePayloadMemory extends ALBPBundlePayload {
	//private int CRC;
	private byte[] buffer;
	
	/**
	 * 
	 * @param buffer Payload data buffer
	 */
	public ALBPBundlePayloadMemory(byte[] buffer) {
		super(ALBPBundlePayloadLocation.Memory);
		this.buffer = buffer;
	}

	@Override
	public byte[] getData() {
		return this.buffer;
	}

}
