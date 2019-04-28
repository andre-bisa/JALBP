package dtn.net;

/** Payload Location
 * Creation date: 10/04/2019
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum ALBPBundlePayloadLocation {
File(0),
Memory(1),
TemporaryFile(2);
	
	private int intVal;
	private ALBPBundlePayloadLocation(int val) {
		this.intVal = val;
	}
	
	/**
	 * 
	 * @return Value for C code
	 */
	public int getValue() {
		return this.intVal;
	}
	
	/**
	 * Creates a PayloadLocation from an integer.
	 * @param val The value according to {@link #getValue()}
	 * @return A PayloadLocation
	 */
	public static ALBPBundlePayloadLocation of(int val) {
		switch (val) {
		case 0: return File;
		case 1: return Memory;
		case 2: return TemporaryFile;
		default: return null;
		}
	}
	
}
