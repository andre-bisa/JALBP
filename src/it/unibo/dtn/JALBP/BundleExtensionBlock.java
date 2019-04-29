package it.unibo.dtn.JALBP;

import java.util.Arrays;

/** Extension Block
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public class BundleExtensionBlock {
	private int type;
	private int flags;
	private byte[] data;
	
	public BundleExtensionBlock(byte[] data, int flags, int type) {
		this.data = data;
		this.flags = flags;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + flags;
		result = prime * result + type;
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
		if (!(obj instanceof BundleExtensionBlock)) {
			return false;
		}
		BundleExtensionBlock other = (BundleExtensionBlock) obj;
		if (!Arrays.equals(data, other.data)) {
			return false;
		}
		if (flags != other.flags) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	public int getType() {
		return type;
	}

	public int getFlags() {
		return flags;
	}

	public byte[] getData() {
		return data;
	}

}
