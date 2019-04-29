package it.unibo.dtn.JAL;

/** 
 * Payload Location
 * <p>Creation date: 10/04/2019</p>
 * @author Andrea Bisacchi
 * @version 1.0
 *
 */
public enum BundlePayloadLocation {
File(0),
Memory(1),
TemporaryFile(2);
	
	private int intVal;
	private BundlePayloadLocation(int val) {
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
	public static BundlePayloadLocation of(int val) {
		switch (val) {
		case 0: return File;
		case 1: return Memory;
		case 2: return TemporaryFile;
		default: return null;
		}
	}
	
}
