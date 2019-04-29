package it.unibo.dtn.JAL;

/** 
 * Payload saved in memory
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public final class BundlePayloadMemory extends BundlePayload {
	//private int CRC;
	private byte[] buffer;
	
	/**
	 * 
	 * @param buffer Payload data buffer
	 */
	public BundlePayloadMemory(byte[] buffer) {
		super(BundlePayloadLocation.Memory);
		this.buffer = buffer;
	}

	@Override
	public byte[] getData() {
		return this.buffer;
	}

}
